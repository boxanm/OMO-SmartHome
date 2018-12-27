package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class Bicycle extends SportEquipment {

	private final int maxRideDuration = 3;
	private int actualRideDuration = 0;
	public Bicycle(String brand, NonHabitableRoom location) {
		super(brand,location);
	}

	@Override
	public Usable use(Person person) {
		isBusy = true;
		if(actualRideDuration < maxRideDuration){
			actualRideDuration++;
			return this;
		}
		actualRideDuration = 0;
		return null;
	}

	@Override
	public String toString() {
		return "Bicycle of brand " + brand;
	}
}