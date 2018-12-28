package Reports;


import Appliances.Appliance;
import EventsAlerts.*;
import House.House;
import Organism.Animals.Animal;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class EventReport extends HouseTimeReport {
	final static String fileName = "EventReport";

	/**
	 * class serving as Event generator
	 */
	public EventReport(){
		name = fileName;
	}


	public void generateReport(House house, int start, int end, PrintWriter writer){
		List<Event> allEvents = house
				.getEventReporter()
				.getAllEvents()
				.stream()
				.filter(event -> event.getLapNumber() >= start && event.getLapNumber() < end)
				.collect(Collectors.toList());

		writer.println("==================Event report from lap "+start+" to " + end + "==================");
		writer.println();
		writer.println("..................Infos..................");
		ArrayList<Info> infos = (ArrayList<Info>) allEvents
				.stream()
				.filter(Info.class::isInstance)
				.map(Info.class::cast)
				.collect(Collectors.toList());

		Map<InfoType, List<Info>>infoMap= infos
				.stream()
				.collect(Collectors.groupingBy(Info::getType));
		for (Map.Entry<InfoType, List<Info>> entry:infoMap.entrySet()) {
			for (Info info:entry.getValue()) {
				writer.println("-" + info.toString());
			}
		}
		writer.println();
		writer.println("..................Alerts..................");
		ArrayList<Alert> alerts = (ArrayList<Alert>) allEvents
				.stream()
				.filter(Alert.class::isInstance)
				.map(Alert.class::cast)
				.collect(Collectors.toList());
		Map<AlertType, List<Alert>> alertMap= alerts
				.stream()
				.collect(Collectors.groupingBy(Alert::getAlertType));
		for (Map.Entry<AlertType, List<Alert>> entry:alertMap.entrySet()) {
			for (Alert alert:entry.getValue()) {
				writer.println("-" + alert.toString());
			}
		}
		writer.println();
		writer.println();
	}

}