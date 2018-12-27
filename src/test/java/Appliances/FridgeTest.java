package Appliances;

import House.*;
import Organism.Persons.Dad;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Senzors.ElectricitySensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FridgeTest {


    House house;
    Floor floor;
    HabitableRoom obyvak;
    Dad dad;
    Fridge fridge;
    ElectricitySensor sensor;
    double fridgeConsumption[] = new double[] {2, 0.02, 0.0005};


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,2);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        fridge = new Fridge("fridge", "brand",obyvak, ConsumptionType.electricity,fridgeConsumption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house,fridge);



    }
    @Test
    void use() {
        ConsumptionReport consumptionReport = new ConsumptionReport();
        EventReport eventReport = new EventReport();
        int i = 0;
        for (i = 0; i < 6; i++){
            fridge.newLap();
            dad.newLap();
            consumptionReport.generateReport(house,0,i);
            house.getEventReporter().newLap();
        }
        eventReport.generateReport(house);
    }
}