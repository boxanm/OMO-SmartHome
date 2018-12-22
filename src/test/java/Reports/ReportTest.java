package Reports;

import Appliances.Appliance;
import EventsAlerts.EventReporter;
import House.*;
import Organism.Animals.Dog;
import Organism.Organism;
import Organism.Persons.Dad;
import Senzors.FireSensor;
import Senzors.WindSensor;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Dad dad;
    Dog dog;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;

    @BeforeEach
    void setUp() {
        house = new House("house1");
        eventReporter = new EventReporter();
        house.setEventReporter(eventReporter);
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,2);
        garaz = new NonHabitableRoom("Garaz",house,floor,0);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        dog = new Dog("Rex");
        dog.moveToHouse(house);


    }

    @Test
    void generateConfigurationReport() {
        HouseConfigurationReport houseConfigurationReport= new HouseConfigurationReport();
        houseConfigurationReport.generateConfigurationReport(house);
    }

    @Test
    void generateEventReport(){
        dad.useCar(new Car("volvo",garaz));
        dog.makeSound();

        FireSensor fireSensor = new FireSensor(house,obyvak);
        obyvak.attach(fireSensor);
        obyvak.setOnFire();

        WindSensor windSensor = new WindSensor(house);
        house.getOutside().attach(windSensor);
        while(!house.getOutside().getIsWind())
            house.getOutside().newLap();


        EventReport eventReport = new EventReport();

        eventReport.generateReport(house);


    }
}