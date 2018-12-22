package SportsEquipment;

import EventsAlerts.EventTarget;
import Organism.Persons.Adults;
import House.NonHabitableRoom;
import Organism.Persons.Person;

/**
 * Abstraktn� t��da, jednotliv� spotovn� vybaven� se vyv��� pomoc� n�vrhov�ho
 * vzoru factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class SportEquipment implements EventTarget {

	protected boolean isBusy = false;
	protected NonHabitableRoom location;
	protected String brand;

	public SportEquipment(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
	}

	/**
	 * 
	 * @param person
	 */
	public abstract void use(Person person);



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

	@Override
	public abstract String toString();
}