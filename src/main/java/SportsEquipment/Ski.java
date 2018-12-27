package SportsEquipment;


import House.NonHabitableRoom;
import Organism.Persons.Person;
import Organism.Persons.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class Ski extends SportEquipment {

	private final int maxSkiingDuration = 3;
	private int actualSkiingDuration = 0;


	/**
	* Creates new ski
	 * @param brand - ski brand
	 * @param location - NonHabitable room of ski location
	* */
	public Ski(String brand, NonHabitableRoom location) {
		super(brand,location);
	}


	/**
	 * Usage of skies
	 * @param person - who is using it
	 * @return return this if still being used, null otherwise
	 * */
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