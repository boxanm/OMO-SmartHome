package Reports;


import EventsAlerts.*;
import House.House;
import Organism.Animals.Animal;
import Organism.Organism;
import Organism.Persons.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
	public void generateReport(House house) {//TODO

		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		System.out.println("==================Activity and usage report==================");
		System.out.println();
		System.out.println("..................Usages..................");
		ArrayList<Info> usages = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Organism)
				.filter(info -> info.getType().equals(InfoType.applianceUsage))
				.sorted(Comparator.comparing(info -> info.getSource().toString()))
				.collect(Collectors.toList());

		for (Info info:usages
			 ) {
			System.out.println(info.toString());
		}
//		Map<String, Long> usagesStrings = usages
//				.stream()
//				.map(info -> info.getSource())
//				.collect(Collectors.groupingBy(source->source.toString(),Collectors.counting()));


		System.out.println();
		System.out.println("..................Sport activities..................");
		ArrayList<Info> sportActivities = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Person)
				.filter(info -> info.getType().equals(InfoType.sportEquipmentUsage))
				.sorted(Comparator.comparing(info -> info.getSource().toString()))
				.collect(Collectors.toList());

		System.out.println();
		System.out.println("..................Animal activities..................");
		ArrayList<Info> animalActivities = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.filter(info -> info.getSource() instanceof Animal)
				.sorted(Comparator.comparing(info -> info.getSource().toString()))
				.collect(Collectors.toList());

		System.out.println();
		System.out.println();
	}
}