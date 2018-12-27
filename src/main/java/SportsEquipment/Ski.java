package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Adults;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class Ski extends SportEquipment {

	private final int maxSkiingDuration = 3;
	private int actualSkiingDuration = 0;


	public Ski(String brand, NonHabitableRoom location) {
		super(brand,location);
	}

	@Override
	public Usable use(Person person) {
		isBusy = true;
		if(actualSkiingDuration < maxSkiingDuration){
			actualSkiingDuration++;
			return this;
		}
		actualSkiingDuration = 0;
		return null;
	}

	@Override
	public String toString() {
		return "Ski of brand " + brand;
	}


}