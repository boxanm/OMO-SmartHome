package Appliances;

import Appliances.ApplianceState.*;
import EventsAlerts.*;
import House.Floor;
import House.Room;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.ArrayList;

import static Appliances.ApplianceState.ApplianceState.Iddle;
import static Appliances.ApplianceState.ApplianceState.Off;
import static Appliances.ApplianceState.ApplianceState.On;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class Appliance implements AlertHandler, ConsuptionGenerator, Observable, InfoGenerator, Usable, Context {

	private ApplianceState applianceState;

	private Floor actualFloor = null;
	private Room actualRoom;
	public ComsuptionType consumptionType;
	private boolean isBroken = false;
	public boolean isBusy = false;

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

	public Appliance(String deviceName, String brand, HabitableRoom location, ComsuptionType consumptionType, double[] consumption){
		this.deviceName = deviceName;
		this.brand = brand;
		this.actualRoom = location;
		this.consumptionType = consumptionType;
		this.consumption = consumption;
		wearOfDevice = 100;
		location.addAppliance(this);
	}

	public void breakDown(){
		isBroken = true;
	}

	public abstract Usable use(Person person);

	public abstract void newLap();

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
		setState(new StateON(this));
	}
	public void turnIddle(){
		setState(new StateIDDLE(this));
	}
	public void turnOFF(){
		setState(new StateOFF(this));
	}


	public boolean isBroken(){
		return isBroken;
	}

	@Override
	public String toString() {
		return brand + " of " + getClass();
	}

	public ApplianceState getApplianceState() {
		return applianceState;
	}

	public Floor getActualFloor() {
		return actualFloor;
	}

	public Room getActualRoom() {
		return actualRoom;
	}

	public ComsuptionType getConsumptionType() {
		return consumptionType;
	}

	public void checkWearOfDevice()
	{
		//if(this.wearOfDevice == 0) //todo až bude brokenDeviceEvent tak dodìlat

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
		this.checkWearOfDevice();
	}
}