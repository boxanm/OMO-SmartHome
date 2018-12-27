package Appliances;

import Appliances.ApplianceState.State;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TV extends Appliance {

	private final static int maxWatchDuration = 4;
	private int actualWatchDuration = 0;

	public TV(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location, consumptionType, consumption);
    }

	public void watch(Person person){
		newInfo(new Info(InfoType.watchingTV,person,getActualFloor(),getActualRoom(),this));
	}


	@Override
	public Usable use(Person person) {
		isBusy = true;

		switch (getApplianceState()){
			case Off:
				turnON();
				return this;
			case Iddle:
				turnON();
				return this;
			case On:
				if(actualWatchDuration < maxWatchDuration){
					if(actualWatchDuration == 0)
						watch(person);
					actualWatchDuration++;
					return this;
				}
				else{
					actualWatchDuration = 0;
					isBusy = false;
					turnIdle();
					return null;
				}
		}
		return null;
	}

	@Override
	public String toString() {
		return "TV " + deviceName;
	}
}