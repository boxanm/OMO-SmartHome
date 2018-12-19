package Appliances;

import Appliances.WashingMachine.WashingMachine;
import House.HabitableRoom;
import House.House;
import House.Floor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WashingMachineTest {

    House house = House.getInstance();
    Floor floor = new Floor("Prvn� patro", house);

    HabitableRoom koupelna = new HabitableRoom("koupelna", house, floor, 2);
    WashingMachine washingMachine = new WashingMachine("pra�ka", koupelna);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {


    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        washingMachine.setWashingMachineState(washingMachine.getFillWithLaundry());
       assertEquals(washingMachine.getWashingMachineState(), washingMachine.getFillWithLaundry());
    }
}