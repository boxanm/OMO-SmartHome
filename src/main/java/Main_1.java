import House.*;
import Reports.ActivityAndUsageReport;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Reports.HouseConfigurationReport;
public class Main_1 {

    private final static int lapNum = 100;

    public static void main(String args[]){
        World world = World.getInstance();

        House house1 = new Configuration().getConfiguration1();
        world.addHouse(house1);

        HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
        EventReport eventReport = new EventReport();
        ConsumptionReport consumptionReport = new ConsumptionReport();

//        houseConfigurationReport.generateConfigurationReportToCL(house1);
        houseConfigurationReport.generateConfigurationReportToFile(house1);
        for (int i = 0; i < lapNum; i++){
            world.newLap();
        }

        eventReport.generateReportToFile(house1,5,10);
        consumptionReport.generateReportToFile(house1,5,10);
        activityAndUsageReport.generateReportToFile(house1,5,10);






    }
}
