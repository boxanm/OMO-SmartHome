import House.*;
import Reports.ActivityAndUsageReport;
import Reports.ConsumptionReport;
import Reports.EventReport;
import Reports.HouseConfigurationReport;
public class Main {

    private final static int lapNum = 100;
    private final static int from = 0;
    private final static int to = 100;




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

        eventReport.generateReportToFile(house,from,to);
        consumptionReport.generateReportToFile(house,from,to);
        activityAndUsageReport.generateReportToFile(house,from,to);






    }
}
