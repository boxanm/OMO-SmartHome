package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Adults;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class Ski extends SportEquipment {

	private boolean isBusy = false;
	private NonHabitableRoom location;
	private String brand;

	public Ski() {

	}

	public Ski(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
	}

	void useEquipment(Adults person) {

	}

	public NonHabitableRoom getLocation() {
		return location;
	}

	public void setLocation(NonHabitableRoom location) {
		this.location = location;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}