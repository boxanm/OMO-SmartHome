package Appliances;

import House.House;
import Organism.Persons.Dad;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Sensors.ElectricitySensor;
import org.junit.jupiter.api.BeforeEach;
import House.*;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class PCTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    Dad dad;
    PC pc;
    ElectricitySensor sensor;
    double pcComsuption[] = new double[] {0.9, 0.03, 0.0001};

    PrintWriter printWriter;




    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",floor,2);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        pc = new PC("pc", "brand",obyvak, ConsumptionType.electricity,pcComsuption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house);
    }

    @Test
    void use() {
        ConsumptionReport consumptionReport = new ConsumptionReport();
        EventReport eventReport = new EventReport();
        for (int i = 0; i < 6; i++){
            pc.newLap();
            dad.newLap();
            consumptionReport.generateReport(house,0,i, printWriter);
            house.getEventReporter().newLap();
        }
        eventReport.generateReport(house,3,5, printWriter);
    }

}