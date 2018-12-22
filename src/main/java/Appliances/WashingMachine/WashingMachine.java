package Appliances.WashingMachine;

import Appliances.Appliance;
import Appliances.ApplianceState.State;
import Appliances.ApplianceType;
import Appliances.ConsuptionType;;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;

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

	public State m_State;


    public WashingMachine(String name, HabitableRoom location) {
        super(name,location);

		fillWithLaundry = new FillWithLaudry(this);
		cycleStart = new CykleStart(this);
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



    public void finalize() throws Throwable {

	}

	public void changeState(){

	}

	public void wash(){

	}

	public void breakeDown(){

	}

	@Override
	public void use(Person person) {

	}


	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(Alert alert){

	}
	public void newConsumption(){

	}

	public Info newInfo(){

		return null;
	}
	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){

	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){

	}

	public void announce(){

	}

	@Override
	public void newInfo(Info info) {

	}
}