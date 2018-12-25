package Reports;


import Appliances.Appliance;
import EventsAlerts.*;
import House.House;
import Organism.Animals.Animal;
import Organism.Organism;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;

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

	@Override
	public void generateReport(House house) {//TODO porovnavat primo INFO, ne string

		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		System.out.println("==================Activity and usage report==================");
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
            System.out.println();
            System.out.println("..................Usages..................");

            Organism source = (Organism) usages.get(0).getSource();
            Appliance targetAppliance = (Appliance) usages.get(0).getTarget();
            int counter = 0;


            System.out.println("Person: " + source.toString());
            for (Info info:usages) {
                if(info.getSource() != source) {
                    System.out.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");
                    targetAppliance = (Appliance) info.getTarget();
                    source = (Organism) info.getSource();
                    System.out.println("Person: " + source.toString());
                    counter = 0;
                }

                if(info.getTarget() != targetAppliance){
                    System.out.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");
                    targetAppliance = (Appliance) info.getTarget();
                    counter = 1;
                }
                else counter++;
            }
            System.out.println("---Used appliance: " + targetAppliance.toString() + " " + counter + " times");


            System.out.println();
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
            System.out.println("..................Sport activities..................");


            Organism source = (Organism) sportActivities.get(0).getSource();
            SportEquipment targetSport = (SportEquipment) sportActivities.get(0).getTarget();
            int counter = 0;


            System.out.println("Person: " + source.toString());
            for (Info info:sportActivities) {
                if(info.getSource() != source) {
                    System.out.println("---Used sport equipment: " + targetSport.toString() + " " + counter + " times");
                    targetSport = (SportEquipment) info.getTarget();
                    source = (Organism) info.getSource();
                    System.out.println("Person: " + source.toString());
                    counter = 0;
                }

                if(info.getTarget() != targetSport){
                    System.out.println("---Used sport equipment: " + targetSport.toString() + " " + counter + " times");
                    targetSport = (SportEquipment) info.getTarget();
                    counter = 1;
                }
                else counter++;
            }
            System.out.println("---Used appliance: " + targetSport.toString() + " " + counter + " times");
            System.out.println();

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
            System.out.println("..................Animal activities..................");
            Organism source = (Organism) animalActivities.get(0).getSource();
            InfoType infoType = animalActivities.get(0).getType();
            int counter = 0;


            System.out.println("Animal: " + source.toString());
            for (Info info:animalActivities) {
                if(info.getSource() != source) {
                    System.out.println("---Did: " + infoType.toString() + " " + counter + " times");
                    infoType = info.getType();
                    source = (Organism) info.getSource();
                    System.out.println("Animal: " + source.toString());
                    counter = 0;
                }

                if(info.getType() != infoType){
                    System.out.println("---Did: " + infoType.toString() + " " + counter + " times");
                    infoType = info.getType();
                    counter = 1;
                }
                else counter++;
            }
            System.out.println("---Did: " + infoType.toString() + " " + counter + " times");

            System.out.println();
            System.out.println();

        }


	}
}