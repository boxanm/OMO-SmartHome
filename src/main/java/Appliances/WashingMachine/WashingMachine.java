package Appliances.WashingMachine;

import Appliances.Appliance;
;
import Appliances.ConsumptionType;
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

    public void setWashingMachineState(IWashingMachineState newWashingMachineState){
		washingMachineState = newWashingMachineState;
	}

	public IWashingMachineState getWashingMachineState(){
		return washingMachineState;
	}

	public void fillWithLaundry(){
		washingMachineState.fillWithLaundry();
	}

	public void cycleStart(){
		washingMachineState.cycleStart();
	}

	public void cycleFinish(){
		washingMachineState.cycleFinish();
	}

	public void takeOutLaundry(){
		washingMachineState.takeOutLaundry();
	}

	public IWashingMachineState getFillWithLaundry(){return fillWithLaundry;}
	public IWashingMachineState getCycleStart(){return cycleStart;}
	public IWashingMachineState getCycleFinish(){return cycleFinish;}
	public IWashingMachineState getTakeOutLaundry(){return takeOutLaundry;}


	@Override
	public Usable use(Person person) {


	    return null;
	}


	@Override
	public String toString() {
		return "WashingMachine " + deviceName;
	}

}