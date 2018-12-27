package Appliances;

import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.Calendar;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Fridge extends Appliance implements FreezingAppliance {

	private boolean isEmpty = false;


	public Fridge(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption){
		super(name,brand, location, consumptionType, consumption);
	}

	public void changeEmpty(){
		isEmpty = !isEmpty;
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
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
		Calendar cal = Calendar.getInstance();
		long startTime = cal.getTimeInMillis();
		long currentTime = startTime;
		newInfo(new Info(InfoType.useFridge, person, getFloor(), actualRoom, this));
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
	@Override
	public void newLap() {

	}


	@Override
	public String toString() {
		return "Fridge " + deviceName;
	}
}