package SportsEquipment;

import House.Floor;
import House.House;
import House.NonHabitableRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportEquipmentCreatorSkiTest {

    NonHabitableRoom room;
    House house;
    Floor floor;
    SportEquipmentCreatorSki skiFactory;
    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("prizemi", house);
        room = new NonHabitableRoom("garaz", house, floor, 0);
        skiFactory = new SportEquipmentCreatorSki(room);
    }

    @Test
    void createAtomic() {
        Ski atomic = skiFactory.createAtomic();
        assertEquals(atomic.getBrand(),"Atomic");
    }

    @Test
    void createHead() {
        Ski head = skiFactory.createHead();
        assertEquals(head.getBrand(),"Head");
    }
}