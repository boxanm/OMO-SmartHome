import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.Creators.FreezerCreator;
import Appliances.Creators.TVCreator;
import Appliances.Creators.WashingMachineCreator;
import Appliances.*;
import Appliances.WashingMachine.WashingMachine;
import House.*;
import Organism.Animals.Cat;
import Organism.Animals.Dog;
import Organism.Animals.Ferret;
import Organism.Organism;
import Organism.Persons.Child;
import Organism.Persons.Dad;
import Organism.Persons.Mom;
import Reports.ActivityAndUsageReport;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Reports.HouseConfigurationReport;
import Sensors.*;
import SportsEquipment.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_1 {

    private final static int lapNum = 10;

    public static void main(String args[]){
        World world = World.getInstance();

        House house1 = new Configuration().getConfiguration1;
        world.addHouse(house1);



        HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
        EventReport eventReport = new EventReport();
        ConsumptionReport consumptionReport = new ConsumptionReport();

        houseConfigurationReport.generateConfigurationReportOnScreen(house1);
        for (int i = 0; i < lapNum; i++){
            world.newLap();
        }

//        eventReport.generateReport(house1);
        consumptionReport.generateReport(house1,1,2);
//        activityAndUsageReport.generateReport(house1);






    }
}
