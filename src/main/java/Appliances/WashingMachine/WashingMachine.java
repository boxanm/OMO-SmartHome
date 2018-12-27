package Appliances.WashingMachine;

import Appliances.Appliance;
;
import Appliances.ConsumptionType;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * Použivá návrhový vzor State machine
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class WashingMachine extends Appliance {

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	String name;
	HabitableRoom location;

	IWashingMachineState fillWithLaundry;
	IWashingMachineState cycleStart;
	IWashingMachineState cycleFinish;
	IWashingMachineState takeOutLaundry;

	IWashingMachineState washingMachineState;

	public WashingMachine(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] comsuption) {
        super(name,brand,location,consumptionType, comsuption);

		fillWithLaundry = new FillWithLaudry(this);
		cycleStart = new CycleStart(this);
		cycleFinish = new CycleFinish(this);
		takeOutLaundry = new TakeOutLaudry(this);

		washingMachineState = takeOutLaundry;


    }

	@Override
	public void changeWearOfDevice() {
		wearOfDevice -= 7;
		if(wearOfDevice < 0){
			wearOfDevice = 0;
			breakDown();
		}
		announce();

	}

	public void setWashingMachineState(IWashingMachineState newWashingMachineState){
		washingMachineState = newWashingMachineState;
	}

	public IWashingMachineState getWashingMachineState(){
		return washingMachineState;
	}

	public void fillWithLaundry(){
		newInfo(new Info(InfoType.fillingWithLaundry, this,getActualFloor(),getActualRoom(), this));
		washingMachineState.fillWithLaundry();
	}

	public void cycleStart(){
		newInfo(new Info(InfoType.cycleStart, this, getActualFloor(), getActualRoom(), this));
		washingMachineState.cycleStart();
	}

	public void cycleFinish(){
		newInfo(new Info(InfoType.cycleFinish, this, getActualFloor(), getActualRoom(), this));
		washingMachineState.cycleFinish();
	}

	public void takeOutLaundry(){
		newInfo(new Info(InfoType.takingOutLaundry, this, getActualFloor(), getActualRoom(), this));
		washingMachineState.takeOutLaundry();
	}

	public IWashingMachineState getFillWithLaundry(){return fillWithLaundry;}
	public IWashingMachineState getCycleStart(){return cycleStart;}
	public IWashingMachineState getCycleFinish(){return cycleFinish;}
	public IWashingMachineState getTakeOutLaundry(){return takeOutLaundry;}


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
				if(actualPlayDuration <maxPlayDuration){
					if(actualPlayDuration == 0)
						getFillWithLaundry();
					getCycleStart();
					return this;
				}
				else{
					getTakeOutLaundry();
					getCycleFinish();
					changeWearOfDevice();
					return null;
				}
		}
		return null;
	}


	@Override
	public String toString() {
		return "WashingMachine " + deviceName;
	}

}