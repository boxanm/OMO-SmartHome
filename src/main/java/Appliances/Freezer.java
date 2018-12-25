package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Freezer extends Appliance implements FreezingAppliance {

    public Freezer(String name, HabitableRoom location) {
		super(name,location);
    }

	public void changeEmpty(){

	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * 
	 * @param food
	 */
	public void eat(int food){

	}

	/**
	 * 
	 * @param food
	 */
	public void fill(int food){

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

	public Info newInfo(){

		return null;
	}

    @Override
    public void newInfo(Info info) {

    }

	@Override
	public void newLap() {

	}
}