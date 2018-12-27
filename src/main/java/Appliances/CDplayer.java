package Appliances;


import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Persons.Usable;

/**
 * Rozhraní pro všechny, které umožòují práci s CD.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class CDplayer extends Appliance{

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public CDplayer(String deviceName, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(deviceName, brand, location, consumptionType, consumption);
	}

	public void ejectCD(){
		newInfo(new Info(InfoType.ejectingCD,this,getActualFloor(),getActualRoom(),this));
	}

	public void insertCD(){
		newInfo(new Info(InfoType.insertingCD,this,getActualFloor(),getActualRoom(),this));
	}

	public void playCD(){
		newInfo(new Info(InfoType.playingCD,this,getActualFloor(),getActualRoom(),this));
	}


	@Override
	public void changeWearOfDevice() {
		wearOfDevice -= 5;
		if(wearOfDevice < 0){
			wearOfDevice = 0;
			breakDown();
		}
		announce();
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
						playCD();
					actualPlayDuration++;
					return this;
				}
				else{
					ejectCD();
					changeWearOfDevice();
					return null;
				}
		}
		return null;
	}


}