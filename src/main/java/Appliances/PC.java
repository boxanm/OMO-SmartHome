package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Persons.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PC extends CDplayer {

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public PC(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] comsuption) {
		super(name,brand,location, consumptionType, comsuption);
	}
	public void work(){
		newInfo(new Info(InfoType.workingOnPC,this,getActualFloor(),getActualRoom(),this));

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
					if(actualPlayDuration == 1)
						work();
					actualPlayDuration++;
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
	public void newLap() {

	}


	@Override
	public String toString() {
		return "PC " + deviceName;
	}
}