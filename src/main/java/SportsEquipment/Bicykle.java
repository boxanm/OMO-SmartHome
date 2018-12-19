package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Adults;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class Bicykle extends SportEquipment {

	String brand;

	private boolean isBusy = false;
	public NonHabitableRoom location;

	public Bicykle() {

	}

	public Bicykle(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
	}

	void useEquipment(Adults person) {

	}
}