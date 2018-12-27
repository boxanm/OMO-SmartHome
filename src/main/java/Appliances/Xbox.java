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
public class Xbox extends Appliance implements CDplayer {

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public Xbox(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location, consumptionType, consumption);
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
		switch (getApplianceState()){
			case On:
				break;
			case Iddle:
				break;
			case Off:
				break;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Xbox " + deviceName;
	}
}