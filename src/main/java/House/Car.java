package House;

import EventsAlerts.EventTarget;
import Organism.Persons.Adults;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Car implements EventTarget {

	private String brand;
	private NonHabitableRoom location;
	private boolean isPresent = true;

	public Car(String brand, NonHabitableRoom location){

		this.brand = brand;
		this.location = location;
	}

	/**
	 * 
	 * @param adults
	 */
	public void goShopping(Adults adults){//todo kde kontrolovat, jestli je auto dostupne?
		isPresent = false;
	}

	public boolean isPresent(){
		return isPresent;
	}

	@Override
	public String toString() {
		return "Car " + brand;
	}
}