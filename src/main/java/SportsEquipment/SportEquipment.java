package SportsEquipment;

import Organism.Persons.Adults;
import House.NonHabitableRoom;

/**
 * Abstraktn� t��da, jednotliv� spotovn� vybaven� se vyv��� pomoc� n�vrhov�ho
 * vzoru factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class SportEquipment {

	public SportEquipment(){

	}

	/**
	 * 
	 * @param person
	 */
	abstract void useEquipment(Adults person);

}