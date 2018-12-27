package Appliances;

import Appliances.ApplianceState.*;
import Appliances.Manual.Manual;
import EventsAlerts.*;
import House.Floor;
import House.Room;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Persons.Usable;

import java.util.ArrayList;
import java.util.Random;

import static Appliances.ApplianceState.ApplianceState.Iddle;
import static Appliances.ApplianceState.ApplianceState.Off;
import static Appliances.ApplianceState.ApplianceState.On;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class Appliance implements AlertHandler, Observable, InfoGenerator, Usable, Context, EventSource {

	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	protected EventReporter eventReporter;

	private Floor actualFloor = null;
	protected Room actualRoom;
	private ConsumptionType consumptionType;
	private boolean isBroken = false;
	public boolean isBusy = false;

	private int fireProbability  = 1;

	// Jmeno zaøízení
	protected String deviceName;
	//Znacka zarizeni
	private String brand;
	//status zaøízení
	private State state = new StateOFF(this);
	//opotøebení, max 100
	protected int wearOfDevice;
	//device manual
	protected String deviceManual = null;
	//spotreba, prvni cislo v zapnutem, druhe v iddle a treti ve vypnutem stavu
	protected double[] consumption;

	public Appliance(String deviceName, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption){
		this.deviceName = deviceName;
		this.brand = brand;
		this.actualRoom = location;
		this.consumptionType = consumptionType;
		this.consumption = consumption;

		wearOfDevice = 100;
		location.addAppliance(this);

		addHandlerToControlUnit(location.getFloor().getHouse().getControlUnit());
		eventReporter = location.getFloor().getHouse().getEventReporter();
	}

	public void breakDown(){
		isBroken = true;
	}

	@Override
	public boolean handleAlert(Alert alert) {
		if(alert.getAlertType() == AlertType.circuitBreakers){
			newInfo(new Info(InfoType.turningOffAppliance,this,actualFloor, actualRoom, this));
			turnOFF();
			announce();
			return true;
		}
		return false;
	}

	public abstract void changeWearOfDevice();

	@Override
	public void newInfo(Info info) {
		eventReporter.newInfo(info);
	}

	public abstract Usable use(Person person);

	public void newLap(){
		if(new Random().nextInt(50) < fireProbability)
			setOnFire();
		announce();
	}

	public double getConsumption(){
		if(this.state.getStatus() == On){
			return this.consumption[0];
		} else if (this.state.getStatus() == Iddle){
			return this.consumption[1];
		} else if (this.state.getStatus() == Off){
			return this.consumption[2];
		} else {
			return 0;
		}
	}

    public int getWearOfDevice() {
        return wearOfDevice;
    }

    public void setComsuption(double [] consumption){
		if(consumption.length == 3){
			this.consumption = consumption;
		} else{
			System.out.println("Špatná délka pole, musí být 3 - consuptionOn, consuptionIddle, consuptionOff");
		}

	}



	public void setOnFire(){
		actualRoom.setOnFire();
	}

	public void turnON(){
		eventReporter.newInfo(new Info(InfoType.turningOnAppliance,this,actualFloor,actualRoom,this));
		setState(new StateON(this));
	}
	public void turnIdle(){
		eventReporter.newInfo(new Info(InfoType.turningIdleAppliance,this,actualFloor,actualRoom,this));
		setState(new StateIDDLE(this));
	}
	public void turnOFF(){
		eventReporter.newInfo(new Info(InfoType.turningOffAppliance,this,actualFloor,actualRoom,this));
		setState(new StateOFF(this));
	}

	public Manual getDeviceManual(){
        return new Manual();
    }

    public void repairAppliance(){
	    wearOfDevice = 100;
    }

	@Override
	public void setState(State state) {
		this.state = state;
	}

	public boolean isBroken(){
		return isBroken;
	}

	@Override
	public String toString() {
		return brand + " of " + getClass();
	}

	public Floor getActualFloor() {
		return actualFloor;
	}

	public Room getActualRoom() {
		return actualRoom;
	}

	public ConsumptionType getConsumptionType() {
		return consumptionType;
	}

	public ApplianceState getApplianceState(){
		return state.getStatus();
	}

	public State getState() {
		return state;
	}

	public Floor getFloor(){
		return actualRoom.getFloor();
	}

	public boolean isBusy() {
		return isBusy;
	}

	public String getBrand() {
		return brand;
	}



	public void printInformation(){
		System.out.println("DEVICE: " + this.deviceName + " " + "INFORMATION");
		System.out.println("===");
		System.out.println("BRAND: " + this.brand);
		System.out.println("STATUS: " + this.state.getStatus());
		System.out.println("CONSUMPTION: " + this.getConsumption());
		System.out.println("LOCATION - FLOOR: " + this.getActualFloor());
		System.out.println("LOCATION - ROOM: "  + this.getActualRoom());
		System.out.println("WEAR OF DEVICE: " + this.wearOfDevice + " " + "%");
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
			observer.update(this);
		}
	}

	@Override
	public void addHandlerToControlUnit(ControlUnit controlUnit) {
		controlUnit.addAlertHandler(this);
	}
}