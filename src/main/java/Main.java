import House.*;
import Reports.ActivityAndUsageReport;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Reports.HouseConfigurationReport;
public class Main {

    private final static int lapNum = 100;



    public static void main(String args[]){
        Configuration configuration = new Configuration();

        World world = World.getInstance();

        House house = configuration.getConfiguration1(); //or getConfiguration2()

        world.addHouse(house);

        HouseConfigurationReport houseConfigurationReport = new HouseConfigurationReport();
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport();
        EventReport eventReport = new EventReport();
        ConsumptionReport consumptionReport = new ConsumptionReport();

        houseConfigurationReport.generateConfigurationReportToFile(house);
        for (int i = 0; i < lapNum; i++){
            world.newLap();
        }

        eventReport.generateReportToFile(house,5,10);
        consumptionReport.generateReportToFile(house,5,10);
        activityAndUsageReport.generateReportToFile(house,5,10);






    }
}
