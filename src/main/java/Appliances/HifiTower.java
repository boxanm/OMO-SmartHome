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
public class HifiTower extends CDplayer {

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public HifiTower(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] comsumption){
		super(name,brand, location, consumptionType, comsumption);

	}



	@Override
	public Usable use(Person person) {
		switch (getApplianceState()){
			case Off:
				turnON();
				return this;
			case Iddle:
				turnON();
				return this;
			case On:
				if(actualPlayDuration<maxPlayDuration){
					if(actualPlayDuration == 0)
						insertCD();
					playCD();
					return this;
				}
				else{
					ejectCD();
					return null;
				}
		}
		return null;
	}


	@Override
    public String toString() {
        return "HiFi Tower " + deviceName;
    }
}