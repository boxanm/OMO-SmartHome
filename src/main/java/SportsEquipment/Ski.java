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



	public Ski(String brand, NonHabitableRoom location) {
		super(brand,location);
	}

	@Override
	public void use(Person person) {

	}

	@Override
	public String toString() {
		return "Ski of brand " + brand;
	}


}