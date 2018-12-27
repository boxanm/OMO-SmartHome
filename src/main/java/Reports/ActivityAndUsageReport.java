package Reports;


import Appliances.Appliance;
import EventsAlerts.*;
import House.House;
import Organism.Animals.Animal;
import Organism.Organism;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class ActivityAndUsageReport extends HouseReport {

	public ActivityAndUsageReport(){

	}

	public void generateReportToFile(House house, int start, int end){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");

        String timeLog = "src/main/java/Reports/ActivityAndUsageReport " + time.format(dtf) + ".txt";
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

	public void generateReport(House house, int start, int end, PrintWriter writer) {

		List<Event> allEvents = house
                .getEventReporter()
                .getAllEvents()
                .stream()
                .filter(event -> event.getLapNumber() >= start && event.getLapNumber() < end)
                .collect(Collectors.toList());
		writer.println("==================Activity and usage report from lap "+start+" to " + end + "==================");
		ArrayList<Info> usages = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Organism)
				.filter(info -> info.getType().equals(InfoType.applianceUsage))
				.sorted(Comparator.comparing((Info info) -> info.getSource().toString())
						.thenComparing(info -> info.getTarget().toString()))
				.collect(Collectors.toList());

		if(usages.size() > 0){
            writer.println();
            writer.println("..................Usages..................");

            Organism source = (Organism) usages.get(0).getSource();
            Appliance targetAppliance = (Appliance) usages.get(0).getTarget();
            int counter = 0;


            writer.println("Person: " + source.toString());
            for (Info info:usages) {
                if(info.getSource() != source) {
                    writer.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");
                    targetAppliance = (Appliance) info.getTarget();
                    source = (Organism) info.getSource();
                    writer.println("Person: " + source.toString());
                    counter = 0;
                }

                if(info.getTarget() != targetAppliance){
                    writer.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");
                    targetAppliance = (Appliance) info.getTarget();
                    counter = 1;
                }
                else counter++;
            }
            writer.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");


            writer.println();
        }

		ArrayList<Info> sportActivities = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Person)
				.filter(info -> info.getType().equals(InfoType.sportEquipmentUsage))
                .sorted(Comparator.comparing((Info info) -> info.getSource().toString())
                        .thenComparing(info -> info.getTarget().toString()))
				.collect(Collectors.toList());

        if(sportActivities.size() > 0){
            writer.println("..................Sport activities..................");


            Organism source = (Organism) sportActivities.get(0).getSource();
            SportEquipment targetSport = (SportEquipment) sportActivities.get(0).getTarget();
            int counter = 0;


            writer.println("Person: " + source.toString());
            for (Info info:sportActivities) {
                if(info.getSource() != source) {
                    writer.println("---Used sport equipment: " + targetSport.toString() + " " + counter + " times");
                    targetSport = (SportEquipment) info.getTarget();
                    source = (Organism) info.getSource();
                    writer.println("Person: " + source.toString());
                    counter = 0;
                }

                if(info.getTarget() != targetSport){
                    writer.println("---Used sport equipment: " + targetSport.toString() + " " + counter + " times");
                    targetSport = (SportEquipment) info.getTarget();
                    counter = 1;
                }
                else counter++;
            }
            writer.println("---Used appliance: " + targetSport.toString() + " " + counter + " times");
            writer.println();

        }


		ArrayList<Info> animalActivities = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Animal)
                .sorted(Comparator.comparing((Info info) -> info.getSource().toString())
                        .thenComparing(info -> info.getType().toString()))
				.collect(Collectors.toList());

        if(animalActivities.size() > 0){
            writer.println("..................Animal activities..................");
            Organism source = (Organism) animalActivities.get(0).getSource();
            InfoType infoType = animalActivities.get(0).getType();
            int counter = 0;


            writer.println("Animal: " + source.toString());
            for (Info info:animalActivities) {
                if(info.getSource() != source) {
                    writer.println("---Did: " + infoType.toString() + " " + counter + " times");
                    infoType = info.getType();
                    source = (Organism) info.getSource();
                    writer.println("Animal: " + source.toString());
                    counter = 0;
                }

                if(info.getType() != infoType){
                    writer.println("---Did: " + infoType.toString() + " " + counter + " times");
                    infoType = info.getType();
                    counter = 1;
                }
                else counter++;
            }
            writer.println("---Did: " + infoType.toString() + " " + counter + " times");

            writer.println();
            writer.println();

        }


	}
}