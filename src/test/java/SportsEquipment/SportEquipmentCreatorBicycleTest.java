package SportsEquipment;

import House.House;
import House.NonHabitableRoom;
import org.junit.jupiter.api.BeforeEach;
import House.Floor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SportEquipmentCreatorBicycleTest {

    NonHabitableRoom room;
    House house;
    Floor floor;
    SportEquipmentCreatorBicycle bicykleFactory;
    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("prizemi", house);
        room = new NonHabitableRoom("garaz",  floor, 0);
        bicykleFactory = new SportEquipmentCreatorBicycle(room);
    }

    @Test
    void createMerida() {
        Bicycle merida = bicykleFactory.createMerida();
        assertEquals(merida.getBrand(),"Merida");
    }

    @Test
    void createApache() {
        Bicycle apache = bicykleFactory.createApache();
        assertEquals(apache.getBrand(),"Apache");
    }

}