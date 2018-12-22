package Reports;

import Appliances.Appliance;
import House.*;
import Organism.Animals.Animal;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class HouseConfigurationReport extends HouseReportLayout {

	public HouseConfigurationReport(){}

	/**
	 * 
	 * @param house
	 */
	public void generateConfigurationReport(House house){
		System.out.println("================House configuration report================");
		System.out.println("House: " + house.toString());
		for (Floor floor:house.getFloorList()) {
			System.out.println("-Floor: " + floor.toString());
			for (Room room:floor.getRoomList()) {
				System.out.println("--Room: " + room.toString());
				int i = 1;
				for (Window window:room.getWindowsList()) {

					System.out.print("---" + window.toString() + " " + i + ": " );
					if(window.getBlind() != null)
						System.out.println(" | " + window.getBlind().toString());
					i++;
				}
				if(room instanceof HabitableRoom){
					for (Appliance appliance:((HabitableRoom) room).getApplianceList()){
						System.out.println("---Appliance: " + appliance.toString());
					}
				}
				else if(room instanceof NonHabitableRoom){
					for (SportEquipment sportEquipment:((NonHabitableRoom) room).getSportEquipmentList()) {
						System.out.println("---Sport Equipment: " + sportEquipment.toString());
					}
				}
			}
		}
		System.out.println("...........................................................");
		System.out.println("Persons: ");
		for (Person person:house.getPersonList()) {
			System.out.println("-" + person.toString());
		}
		System.out.println("Animals: ");
		for (Animal animal:house.getAnimalList()) {
			System.out.println("-" + animal.toString());
		}
	}

}