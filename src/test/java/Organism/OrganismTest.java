package Organism;

import Appliances.Appliance;
import EventsAlerts.EventReporter;
import House.*;
import Organism.Persons.Dad;
import SportsEquipment.SportEquipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrganismTest {


    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Organism organism;
    EventReporter eventReporter;
    Appliance appliance;
    SportEquipment sportEquipment;

    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",floor,0);
        garaz = new NonHabitableRoom("Garaz",floor,0);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        floor.addRoom(garaz);
        organism = new Dad("Pavel");
        organism.moveToHouse(house);

    }

    @Test
    void moveToHouse() {
        assertEquals(organism.m_House,house);
        House newHouse = new House("house2");
        newHouse.addFloor(floor);

        organism.moveToHouse(newHouse);
        assertEquals(organism.m_House,newHouse);
    }


    @Test
    void setOnFire() {
        assertFalse(organism.actualRoom.isOnFire());
        organism.setOnFire();
        assertTrue(organism.actualRoom.isOnFire());
    }

}