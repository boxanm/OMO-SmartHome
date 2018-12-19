package Appliances.WashingMachine;

import Appliances.Appliance;
import Appliances.ApplianceState.State;
import Appliances.ConsuptionType;;
import EventsAlerts.AlertType;
import EventsAlerts.Consumption;
import EventsAlerts.Info;
import EventsAlerts.Observer;
import House.HabitableRoom;

/**
 * Použivá návrhový vzor State machine
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class WashingMachine implements Appliance {

	String name;
	HabitableRoom location;

	IWashingMachineState fillWithLaundry;
	IWashingMachineState cycleStart;
	IWashingMachineState cycleFinish;
	IWashingMachineState takeOutLaundry;

	IWashingMachineState washingMachineState;

	public State m_State;

	public WashingMachine(){

	}

    public WashingMachine(String name, HabitableRoom location) {
		this.name = name;
		this.location = location;

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

	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba){
		return 0;
	}

	public void setOnFire(){

	}

	public void turnIddle(){

	}

	public void turnOFF(){

	}

	public void turnON(){

	}

	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}
	public Consumption newConsuption(){

		return null;
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
}