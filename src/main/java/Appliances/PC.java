package Appliances;

import EventsAlerts.AlertType;
import EventsAlerts.Consumption;
import EventsAlerts.Info;
import EventsAlerts.Observer;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PC implements CDplayer, Appliance {

	String name;
	HabitableRoom location;

	public PC() {

	}

	public PC(String name, HabitableRoom location){
		this.name = name;
		this.location = location;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param duration
	 */
	public void work(int duration){

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

	public Consumption newConsuption(){

		return null;
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



}