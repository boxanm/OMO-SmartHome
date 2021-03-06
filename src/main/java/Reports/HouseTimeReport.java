package Reports;

import House.House;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Abstract class for all reports restricted by lap time
 * files are generated based on name
 */
public abstract class HouseTimeReport extends HouseReport {
    protected String name;
    public abstract void generateReport(House house, int start, int end, PrintWriter writer);



    public void generateReportToFile(House house, int start, int end){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");

        String timeLog = path + name +"_" + time.format(dtf) + ".txt";
        try {
            PrintWriter writer = new PrintWriter(timeLog, "UTF-8");
            generateReport(house,start,end,writer);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReportToCL(House house, int start, int end){
        PrintWriter writer = new PrintWriter(System.out);
        generateReport(house,start,end,writer);
    }

}
