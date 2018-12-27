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
 * @created 16-pro-2018 9:00:42
 */
public class HifiTower extends Appliance implements CDplayer {


	public HifiTower(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] comsumption){
		super(name,brand, location, consumptionType, comsumption);

	}
	@Override
	public Usable use(Person person) {
		Calendar cal = Calendar.getInstance();
		long startTime = cal.getTimeInMillis();
		long currentTime = startTime;
		newInfo(new Info(InfoType.useHifiTower, person, getFloor(), actualRoom, this));
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

	public void newConsumption(){

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
	public void newLap() {

	}


    @Override
    public String toString() {
        return "HiFi Tower " + deviceName;
    }
}