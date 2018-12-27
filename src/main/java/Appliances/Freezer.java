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
public class Freezer extends Appliance implements FreezingAppliance {


	private int food;
	private boolean isEmpty = false;
	private final int MAX_CAPACITY = 100;

    public Freezer(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location,consumptionType, consumption);
    }

	@Override
	public void changeEmpty() {
		isEmpty = !isEmpty;
	}
	@Override
	public boolean isEmpty() {
		return isEmpty;
	}


	/**
	 *
	 * @param quantity
	 */
	@Override
	public void eat(int quantity) {
		if (getFood() > quantity && quantity > 0 && quantity < 10){
			food -= quantity;
			if(food <= 0){
				changeEmpty();
			}
		}else{
			System.out.println("Nelze");
		}
	}


	/**
	 *
	 * @param quantity
	 */
	@Override
	public void fill(int quantity) {
		if(quantity > 0){
			if(food + quantity < MAX_CAPACITY){
				food += quantity;
			} else{
				System.out.println("Nevejde se");
		}
		}
	}

	@Override
	public Usable use(Person person) {
		Calendar cal = Calendar.getInstance();
		long startTime = cal.getTimeInMillis();
		long currentTime = startTime;
		newInfo(new Info(InfoType.useFreezer, person, getFloor(), actualRoom, this));
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
		announce();
	}



	public void newConsumption(){

	}



	public int getFood() {
		return food;
	}

	@Override
	public String toString() {
		return "Freezer " + deviceName;
	}
}