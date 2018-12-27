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
public class EventReport extends HouseReport {

	public EventReport(){}

	public void generateReport(House house){
		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		System.out.println("==================Event report==================");
		System.out.println();
		System.out.println("..................Infos..................");
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
				System.out.println("-" + info.toString());
			}
		}
		System.out.println();
		System.out.println("..................Alerts..................");
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
				System.out.println("-" + alert.toString());
			}
		}
		System.out.println();
		System.out.println();
	}

	public void generateEventReportToFile(House house) {
		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");

		String timeLog = "src/main/java/Reports/EvenReport " + time.format(dtf) + ".txt";
		try {
			PrintWriter writer = new PrintWriter(timeLog, "UTF-8");
			writer.println("==================Event report==================");
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

			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}