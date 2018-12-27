package Appliances;

import Appliances.Creators.WashingMachineCreator;
import Appliances.WashingMachine.WashingMachine;
import House.HabitableRoom;
import House.House;
import House.Floor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WashingMachineTest {

    HabitableRoom room;
    House house;
    Floor floor;
    WashingMachineCreator washingMachineCreator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        house = new House("house1");
        floor = new Floor("prizemi", house);
        room = new HabitableRoom("koupelna", floor, 1);
        washingMachineCreator = new WashingMachineCreator(room);


    }

    @Test
    public void createBosch(){
        WashingMachine bosch = washingMachineCreator.createBosch("wasshingmachine1");
        assertEquals(bosch.getBrand(), "Bosch");
    }
}