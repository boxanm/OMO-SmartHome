package Appliances;

import EventsAlerts.AlertType;
import EventsAlerts.Observer;
import House.HabitableRoom;

/**
 * Použivá návrhový vzor State machine
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class WashingMachine implements Appliance {

	String name;
	HabitableRoom location;

	public State m_State;

	public WashingMachine(){

	}

    public WashingMachine(String name, HabitableRoom location) {
		this.name = name;
		this.location = location;
    }

    public void finalize() throws Throwable {

	}

	public void changeState(){

	}

	public void wash(){

	}

	public void breakeDown(){

	}

	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba){
		return 0;
	}

	public void setOnFire(){

	}

	public void turnIddle(){

	}

	public void turnOFF(){

	}

	public void turnON(){

	}

	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}

	public void newConsuption(){

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

	public void newInfo(){

	}

}