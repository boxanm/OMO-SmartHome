package Reports;

import Appliances.Appliance;
import House.*;
import Organism.Animals.Animal;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class HouseConfigurationReport extends HouseReport {
	final static String name = "HouseConfigurationReport";

	/**
	 * class serving as HouseConfigurationReport generator
	 */
	public HouseConfigurationReport(){}


	/**
	 * @param house generates configuration report of this to Command Line
	 */
	public void generateConfigurationReportToCL(House house){
		PrintWriter writer = new PrintWriter(System.out);

		generateReport(house,writer);
	}

	/**
	 * @param house generates configuration report of this to file
	 */
	public void generateConfigurationReportToFile(House house) {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");

		String timeLog = path + name +"_" + time.format(dtf) + ".txt";
		try {
			PrintWriter writer = new PrintWriter(timeLog, "UTF-8");
			generateReport(house,writer);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void generateReport(House house, PrintWriter writer) {
		writer.println("================House configuration report================");
		writer.println("House: " + house.toString());
		for (Floor floor : house.getFloorList()) {
			writer.println("-Floor: " + floor.toString());
			for (Room room : floor.getRoomList()) {
				writer.println("--Room: " + room.toString());
				int i = 1;
				for (Window window : room.getWindowsList()) {

					writer.print("---" + window.toString());
					if (window.getBlind() != null)
						writer.println(": " + window.getBlind().toString());
					i++;
				}
				if (room instanceof HabitableRoom) {
					for (Appliance appliance : ((HabitableRoom) room).getApplianceList()) {
						writer.println("---Appliance: " + appliance.toString());
					}
				} else if (room instanceof NonHabitableRoom) {
					for (SportEquipment sportEquipment : ((NonHabitableRoom) room).getSportEquipmentList()) {
						writer.println("---Sport Equipment: " + sportEquipment.toString());
					}
				}
			}
		}
		writer.println("...........................................................");
		writer.println("Persons: ");
		for (Person person : house.getPersonList()) {
			writer.println("-" + person.toString());
		}
		writer.println("Animals: ");
		for (Animal animal : house.getAnimalList()) {
			writer.println("-" + animal.toString());
		}
	}

}