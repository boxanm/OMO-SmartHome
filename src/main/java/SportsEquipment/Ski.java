package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Adults;
import Organism.Persons.Person;

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

	@Override
	public void use(Person person) {

	}

	public Ski(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
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