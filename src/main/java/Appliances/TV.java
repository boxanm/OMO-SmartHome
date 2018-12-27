package Appliances;

import Appliances.ApplianceState.State;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TV extends Appliance {

	private int maxWatchDuration = 4;
	private int actualWatchDuration = 0;

	public TV(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location, consumptionType, consumption);
    }

	public void watch(){
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
					actualWatchDuration++;
					watch();
					return this;
				}
				else{
					actualWatchDuration = 0;
					turnIdle();
					return null;
				}
		}
		return null;

//		Calendar cal = Calendar.getInstance();
//		long startTime = cal.getTimeInMillis();
//		long currentTime = startTime;
//		newInfo(new Info(InfoType.useTV, person, getFloor(), actualRoom, this));
//		wearOfDevice -= 10;
//		while(currentTime<startTime+5000){
//			isBusy = true;
//			if(getApplianceState() == ApplianceState.Off || getApplianceState() == ApplianceState.Iddle){
//				this.turnON();
//				return this;
//			}
//		}
//		checkWearOfDevice();
//		this.turnOFF();
//		isBusy = false;
//		return null;
	}

	@Override
	public String toString() {
		return "TV " + deviceName;
	}
}