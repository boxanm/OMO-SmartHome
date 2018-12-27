package Reports;

import Appliances.*;
import EventsAlerts.EventReporter;
import House.*;
import Organism.Animals.Dog;
import Organism.Animals.Ferret;
import Organism.Persons.Dad;
import Organism.Persons.Mom;
import Sensors.FireSensor;
import Sensors.WindSensor;
import SportsEquipment.Bicycle;
import SportsEquipment.Ski;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    double freezerComsuption[] = new double[] {1, 0.02, 0.0005};
    double fridgeComsuption[] = new double[] {0.8, 0.01, 0.0002};
    double playstationComsuption[] = new double[] {0.7, 0.04, 0.0006};


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",floor,2);
        garaz = new NonHabitableRoom("Garaz",floor,0);
        sportEquipment = new Ski("atomic",garaz);
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
        houseConfigurationReport.generateConfigurationReportOnScreen(house);
    }

    @Test
    void generateConfigurationReportToFile(){
        HouseConfigurationReport houseConfigurationReport= new HouseConfigurationReport();
        houseConfigurationReport.generateConfigurationReportToFile(house);

    }

    @Test
    void generateEventReport(){
        dad.useCar(new Car("volvo",garaz));
        dog.makeSound();

        FireSensor fireSensor = new FireSensor(house);
        obyvak.attach(fireSensor);
        obyvak.setOnFire();

        WindSensor windSensor = new WindSensor(house);
        house.getOutside().attach(windSensor);
        while(!house.getOutside().getIsWind())
            house.getOutside().newLap();


        EventReport eventReport = new EventReport();

        eventReport.generateReport(house);
        eventReport.generateEventReportToFile(house);
    }

    @Test
    void activityAndUsageReport(){
        Fridge fridge = new Fridge("fridge","whirpool",obyvak, ConsumptionType.electricity, fridgeComsuption);
        Freezer freezer = new Freezer("freezer","whirpool",obyvak, ConsumptionType.electricity, freezerComsuption);
        PlayStation playStation = new PlayStation("konzole1","PS2",obyvak, ConsumptionType.electricity, playstationComsuption);
        Mom mom = new Mom("mom");
        mom.moveToHouse(house);

        System.out.println(house.getAppliances().size() + " " + (house.getPersonList().size()+house.getAnimalList().size()));

        dad.useAppliance(freezer);
        mom.useAppliance(playStation);
        dad.useAppliance(fridge);
        dad.useAppliance(freezer);
        mom.useAppliance(fridge);
        mom.useAppliance(playStation);

        dad.useSportEquipment(sportEquipment);


        Bicycle bike = new Bicycle("favorit",garaz);
        mom.useSportEquipment(bike);

        dad.useSportEquipment(bike);
        dog.makeSound();
        dog.makeSound();

        Ferret ferret = new Ferret("fretka");
        ferret.moveToHouse(house);
        ferret.makeSound();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
        activityAndUsageReport.generateReport(house);
    }
}