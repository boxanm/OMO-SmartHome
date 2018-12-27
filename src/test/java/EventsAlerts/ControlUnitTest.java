package EventsAlerts;

import Appliances.ConsumptionType;
import Appliances.Fridge;
import House.*;
import Organism.Persons.Dad;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Senzors.ElectricitySensor;
import Senzors.FireSensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlUnitTest {
    House house;
    Floor floor;
    HabitableRoom obyvak;
    NonHabitableRoom garaz;
    Car car;
    Dad dad;
    Fridge fridge;
    ElectricitySensor sensor;
    FireSensor fireSensor;
    ControlUnit controlUnit;
    double fridgeConsumption[] = new double[] {2, 0.02, 0.0005};


    @BeforeEach
    void setUp() {
        house = new House("house1");
        floor = new Floor("1. patro",house);
        obyvak = new HabitableRoom("obyvak",house,floor,2);
        garaz = new NonHabitableRoom("garaz", house, floor,0);
        car = new Car("volvo",garaz);
        fridge = new Fridge("fridge", "brand",obyvak, ConsumptionType.electricity,fridgeConsumption);
        dad = new Dad("Pavel");
        dad.moveToHouse(house);
        sensor = new ElectricitySensor(house,fridge);
        fireSensor = new FireSensor(house,garaz);

        controlUnit = house.getControlUnit();
//        controlUnit.addAlertHandler(dad);
//        controlUnit.addAlertHandler(fridge);
    }
    @Test
    void newLap() {
        EventReport eventReport = new EventReport();
        for (int i = 0; i < 3; i++){
            controlUnit.newLap();
            fridge.newLap();
            dad.newLap();
            if(i == 1)
                garaz.setOnFire();
            house.getEventReporter().newLap();
            eventReport.generateReport(house);
        }
//        eventReport.generateReport(house);
    }
}