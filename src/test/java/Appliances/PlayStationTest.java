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

class PlayStationTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    Dad dad;
    PlayStation playStation;
    ElectricitySensor sensor;
    double playstationComsuption[] = new double[] {0.7, 0.04, 0.0006};

    PrintWriter printWriter;


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",floor,2);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        playStation = new PlayStation("ps", "brand",obyvak, ConsumptionType.electricity,playstationComsuption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house);
    }

    @Test
    void use() {
        ConsumptionReport consumptionReport = new ConsumptionReport();
        EventReport eventReport = new EventReport();
        for (int i = 0; i < 6; i++){
            playStation.newLap();
            dad.newLap();
            consumptionReport.generateReport(house,0,i, printWriter);
            house.getEventReporter().newLap();
        }
        eventReport.generateReport(house, 1, 3, printWriter);
    }

}