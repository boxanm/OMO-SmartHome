package Appliances;

import House.House;
import Organism.Persons.Dad;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Senzors.ElectricitySensor;
import org.junit.jupiter.api.BeforeEach;
import House.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XboxTest {

    House house;
    Floor floor;
    HabitableRoom obyvak;
    Dad dad;
    Xbox xbox;
    ElectricitySensor sensor;
    double xboxComsuption[] = new double[] {0.7, 0.04, 0.0004};


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,2);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        xbox = new Xbox("xbox", "brand",obyvak, ConsumptionType.electricity,xboxComsuption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house);
    }

    @Test
    void use(){
        ConsumptionReport consumptionReport = new ConsumptionReport();
        EventReport eventReport = new EventReport();
        for (int i = 0; i < 6; i++){
            xbox.newLap();
            dad.newLap();
            consumptionReport.generateReport(house,0,i);
            house.getEventReporter().newLap();
        }
        eventReport.generateReport(house);
    }

}