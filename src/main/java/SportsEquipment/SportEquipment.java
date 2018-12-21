package SportsEquipment;

import EventsAlerts.EventTarget;
import Organism.Persons.Adults;
import House.NonHabitableRoom;
import Organism.Persons.Person;

/**
 * Abstraktní tøída, jednotlivá spotovní vybavení se vyváøí pomocí návrhového
 * vzoru factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class SportEquipment implements EventTarget {

	public SportEquipment(){

	}

	/**
	 * 
	 * @param person
	 */
	public abstract void use(Person person);

}