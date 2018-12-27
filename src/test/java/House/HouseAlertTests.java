package House;

import Appliances.Appliance;
import EventsAlerts.ControlUnit;
import EventsAlerts.EventReporter;
import Organism.Animals.Dog;
import Organism.Organism;
import Organism.Persons.Dad;
import Reports.HouseConfigurationReport;
import Sensors.FireSensor;
import Sensors.WindSensor;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseAlertTests {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Dad dad;
    Organism organism;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;
    HouseConfigurationReport houseConfigurationReport;

    Blind blind;
    WindSensor windSensor;
    FireSensor fireSensorObyvak;
    FireSensor fireSensorGaraz;
    Outside outside;

    ControlUnit controlUnit;
    @BeforeEach
    void setUp() {
        house = new House("house1");

        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,1);
        garaz = new NonHabitableRoom("Garaz",house,floor,0);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        organism = new Dog("Rex");
        organism.moveToHouse(house);

        houseConfigurationReport = new HouseConfigurationReport();

        blind = obyvak.getWindowsList().get(0).getBlind();
        windSensor = new WindSensor(house);
        outside = house.getOutside();
        outside.attach(windSensor);

        eventReporter.getControlUnit().addAlertHandler(blind);

        fireSensorObyvak = new FireSensor(house);
        fireSensorGaraz = new FireSensor(house);

        eventReporter.getControlUnit().addAlertHandler(dad);
    }

    @Test
    void windSensorTest(){
        assertFalse(blind.isPulled());
        while(!outside.getIsWind())
            outside.newLap();
        assertTrue(outside.getIsWind());
        assertTrue(blind.isPulled());

    }

    @Test
    void fireSensorTest(){
        assertFalse(obyvak.isOnFire());
        assertFalse(garaz.isOnFire());

        obyvak.setOnFire();
        assertTrue(obyvak.isOnFire());
        fireSensorObyvak.update(obyvak);
        assertFalse(obyvak.isOnFire());


    }

}