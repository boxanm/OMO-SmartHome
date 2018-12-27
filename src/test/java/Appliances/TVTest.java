package Appliances;

import House.*;
import Organism.Persons.Dad;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Sensors.ElectricitySensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TVTest {


    House house;
    Floor floor;
    HabitableRoom obyvak;
    Dad dad;
    TV tv;
    ElectricitySensor sensor;
    double tvConsumption[] = new double[] {1, 0.02, 0.0005};


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",floor,2);
        house.addFloor(floor);
        floor.addRoom(obyvak);
        tv = new TV("televize", "brand",obyvak, ConsumptionType.electricity,tvConsumption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house);



    }
    @Test
    void use() {
        ConsumptionReport consumptionReport = new ConsumptionReport();
        EventReport eventReport = new EventReport();
        int i = 0;
        for (i = 0; i < 6; i++){
            tv.newLap();
            dad.newLap();
            consumptionReport.generateReport(house,0,i);
            house.getEventReporter().newLap();
        }

        for (i=6;i<10;i++){
            tv.newLap();
            consumptionReport.generateReport(house,0,i);
            house.getEventReporter().newLap();
        }
        eventReport.generateReport(house);

    }
}