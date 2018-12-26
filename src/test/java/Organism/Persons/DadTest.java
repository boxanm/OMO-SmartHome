package Organism.Persons;

import Appliances.Appliance;
import Appliances.ComsuptionType;
import Appliances.PC;
import EventsAlerts.EventReporter;
import House.*;
import SportsEquipment.Ski;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DadTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Dad dad;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;
    @BeforeEach
    void setUp() {
        eventReporter = new EventReporter();
        house = new House("house1");
        house.setEventReporter(eventReporter);
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,0);
        garaz = new NonHabitableRoom("Garaz",house,floor,0);
        double pcComsuption[] = new double[] {0.8, 0.01, 0.0002};
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        appliance = new PC("Pocitac","Zalman",obyvak, ComsuptionType.electricity, pcComsuption);
        sportEquipment = new Ski("atomic",garaz);
        obyvak.addAppliance(appliance);
        garaz.addSportEquipment(sportEquipment);
        dad.setEventReporter(eventReporter);

    }

    @Test
    void callFireman() {
        garaz.setOnFire();
        assertTrue(garaz.isOnFire());
        dad.callFireman(garaz);
        assertFalse(garaz.isOnFire());
    }

    @Test
    void extinguish() {
        garaz.setOnFire();
        dad.extinguish(garaz);
        assertTrue(garaz.isOnFire());
        dad.extinguish(garaz);
        assertFalse(garaz.isOnFire());
    }


    @Test
    void nextAction() {
        assertFalse(dad.isBusy());
        dad.nextAction();
        assertTrue(dad.isBusy());
    }

    @Test
    void useAppliance() {
    }

    @Test
    void useSportEquipment() {
    }

    @Test
    void hangOn() {
        assertFalse(dad.isBusy());
        dad.nextAction();
        assertTrue(dad.isBusy());
    }

    @Test
    void handleAlert() {
    }

    @Test
    void cheerUp() {
    }

    @Test
    void repair() {
    }


    @Test
    void useCar() {
        Car car = new Car("tatra",garaz);
        assertTrue(car.isPresent());
        assertFalse(dad.isBusy());
        dad.useCar(car);
        assertFalse(car.isPresent());
        assertTrue(dad.isBusy());
    }
}