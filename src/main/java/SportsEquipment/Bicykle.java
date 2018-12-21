package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Adults;
import Organism.Persons.Person;

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

	@Override
	public void use(Person person) {

	}

	public Bicykle(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
	}

}