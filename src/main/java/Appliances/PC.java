package Appliances;

import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PC extends Appliance implements CDplayer {

	private ArrayList<Observer> observersList = new ArrayList<Observer>();


	public PC(String name,String brand, HabitableRoom location, ComsuptionType consumptionType, double[] comsuption) {
		super(name,brand,location, consumptionType, comsuption);
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


	@Override
	public Usable use(Person person) {
		Calendar cal = Calendar.getInstance();
		long startTime = cal.getTimeInMillis();
		long currentTime = startTime;
		newInfo(new Info(InfoType.usePC, person, getFloor(), actualRoom, this));
		wearOfDevice -= 10;
		while(currentTime<startTime+5000){
			isBusy = true;
			if(getApplianceState() == ApplianceState.Off || getApplianceState() == ApplianceState.Iddle){
				this.turnON();
				return this;
			}
		}
		checkWearOfDevice();
		this.turnOFF();
		isBusy = false;
		return null;
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
		if(!observersList.contains(observer))
			observersList.add(observer);
	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){
		observersList.remove(observer);
	}

	public void announce(){
		for (Observer observer:observersList) {
			observer.update();
		}
	}


	@Override
	public void newInfo(Info info) {

	}

	@Override
	public void newLap() {

	}

	@Override
	public void setState(State state) {

	}

	@Override
	public String toString() {
		return "PC " + deviceName;
	}
}