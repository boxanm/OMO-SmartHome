package Appliances.WashingMachine;

import Appliances.Appliance;
import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;;
import Appliances.ComsuptionType;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.ArrayList;
import java.util.Calendar;

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


	private ArrayList<Observer> observersList = new ArrayList<Observer>();


	public WashingMachine(String name,String brand, HabitableRoom location, ComsuptionType consumptionType, double[] comsuption) {
        super(name,brand,location,consumptionType, comsuption);

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


	public void changeState(){

	}


	public void breakeDown(){

	}

	@Override
	public Usable use(Person person) {
		Calendar cal = Calendar.getInstance();
		long startTime =   cal.getTimeInMillis();
		long currentTime =startTime;
		newInfo(new Info(InfoType.useWashingMachine, person, getFloor(), actualRoom, this));
		wearOfDevice -= 10;
		while(currentTime<startTime+5000){
			isBusy = true;
			if(getApplianceState() == ApplianceState.Off || getApplianceState() == ApplianceState.Iddle){
				this.turnON();
				return this;
			}
		}
		checkWearOfDevice();
		this.turnOFF();
		isBusy = false;
		return null;


	}
	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(Alert alert){

	}
	public void newConsumption(){

	}

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){
		if(!observersList.contains(observer))
			observersList.add(observer);
	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){
		observersList.remove(observer);
	}

	public void announce(){
		for (Observer observer:observersList) {
			observer.update();
		}
	}

	@Override
	public void newLap() {

	}

	@Override
	public String toString() {
		return "WashingMachine " + deviceName;
	}

	@Override
	public void setState(State state) {

	}

	@Override
	public void newInfo(Info info) {

	}
}