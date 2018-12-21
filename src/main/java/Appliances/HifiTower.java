package Appliances;

import EventsAlerts.AlertType;
import EventsAlerts.Consumption;
import EventsAlerts.Info;
import EventsAlerts.Observer;
import House.HabitableRoom;
import Organism.Persons.Person;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class HifiTower extends Appliance implements CDplayer {
	public HifiTower(String name, HabitableRoom location){
		super(name,location);

	}


	@Override
	public void use(Person person) {

	}

	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

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
	public void newInfo(Info info) {

	}
}