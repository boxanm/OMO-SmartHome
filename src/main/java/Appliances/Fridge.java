package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Fridge extends Appliance implements FreezingAppliance {

	public Fridge(String name, HabitableRoom location){
		super(name,location);
	}

	public void finalize() throws Throwable {

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