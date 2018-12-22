package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PlayStation extends Appliance implements CDplayer{
	public PlayStation(String name, HabitableRoom location){
		super(name,location);
	}

	public void finalize() throws Throwable {

	}

	public void ejectCD(){

	}

	public void insertCD(){

	}

	/**
	 * 
	 * @param duration
	 */
	public void playCD(int duration){

	}


	@Override
	public void use(Person person) {

	}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(Alert alert){

	}

	public void newConsumption(){

	}

	public Info newInfo(){

		return null;
	}
	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){

	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){

	}

	public void announce(){

	}


	@Override
	public void newInfo(Info info) {

	}
}