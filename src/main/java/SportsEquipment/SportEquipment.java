package SportsEquipment;

import EventsAlerts.EventTarget;
import Organism.Persons.Adults;
import House.NonHabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * Abstraktní tøída, jednotlivá spotovní vybavení se vyváøí pomocí návrhového
 * vzoru factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class SportEquipment implements EventTarget, Usable {

	protected boolean isBusy = false;
	protected NonHabitableRoom location;
	protected String brand;

	/**
	 * Creates some new sport equipment
	 * @param brand - equipment brand
	 * @param location - NonHabitable room of equipment location
	 * */
	public SportEquipment(String brand, NonHabitableRoom location) {
		this.brand = brand;
		this.location = location;
	}

	/**
	 * sport equipment can be used by Person
	 * @param person
	 */
	public abstract Usable use(Person person);



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

	public boolean isBusy() {
		return isBusy;
	}
}