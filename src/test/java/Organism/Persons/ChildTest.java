package Organism.Persons;

import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.PC;
import Appliances.WashingMachine.WashingMachine;
import EventsAlerts.EventReporter;
import House.House;
import House.Floor;
import House.NonHabitableRoom;
import House.HabitableRoom;
import SportsEquipment.Ski;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChildTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Child child;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;

    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro", house);
        obyvak = new HabitableRoom("obyvak", house, floor, 0);
        garaz = new NonHabitableRoom("Garaz", house, floor, 0);
        double pcComsuption[] = new double[]{0.8, 0.01, 0.0002};
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        child = new Child("Jan");
        child.moveToHouse(house);
        appliance = new PC("Pocitac", "Zalman", obyvak, ConsumptionType.electricity, pcComsuption);
        appliance = new WashingMachine("pracka", "whirpool", obyvak, ConsumptionType.electricity, pcComsuption);
        sportEquipment = new Ski("atomic", garaz);
        obyvak.addAppliance(appliance);
        garaz.addSportEquipment(sportEquipment);
        child.setEventReporter(eventReporter);

    }

    @Test
    void cry() {

    }

    @Test
    void stopCrying() {
    }

    @Test
    void nextAction() {
    }

    @Test
    void isSad() {
    }

    @Test
    void hangOn() {
        assertFalse(child.isBusy());
        child.nextAction();
        assertTrue(child.isBusy());
    }

    @Test
    void announce() {
    }

}