package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TV extends Appliance {
    public TV(String name, HabitableRoom location) {
		super(name,location);
    }

	/**
	 * 
	 * @param duration
	 */
	public void watch(int duration){

	}


	@Override
	public Usable use(Person person) {

		return null;
	}

	@Override
	public int getAktualniSpotreba(ConsuptionType typSpotreba) {
		return 0;
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

	@Override
	public void newLap() {

	}
}