package Reports;

import Appliances.Appliance;
import EventsAlerts.EventReporter;
import House.*;
import Organism.Animals.Dog;
import Organism.Organism;
import Organism.Persons.Dad;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseConfigurationReportTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Organism organism;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;
    HouseConfigurationReport houseConfigurationReport;

    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,2);
        garaz = new NonHabitableRoom("Garaz",house,floor,0);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        organism = new Dad("Pavel");
        organism.moveToHouse(house);
        organism = new Dog("Rex");
        organism.moveToHouse(house);

        houseConfigurationReport = new HouseConfigurationReport();

    }

    @Test
    void generateConfigurationReport() {
        houseConfigurationReport.generateConfigurationReport(house);
    }
}