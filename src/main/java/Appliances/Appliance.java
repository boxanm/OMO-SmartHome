package Appliances;

import Appliances.ApplianceState.ApplianceState;
import EventsAlerts.*;
import House.Floor;
import House.Room;
import House.HabitableRoom;
import Organism.Persons.Person;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class Appliance implements AlertHandler, ConsuptionGenerator, Observable, InfoGenerator, ArrayIndexable {

	public int consuptionIddle = 0;
	public int consuptionOFF = 0;
	public int consuptionON = 0;
	public ApplianceState applianceState = null;

	public ApplianceType type = null;

	public Floor actualFloor = null;
	public HabitableRoom actualRoom = null;
	public ConsuptionType consumptionType = null;
	public boolean isBroken = false;
	public boolean isBusy = false;

	String name;

	private static int instanceCounter;
	private int index;

	public Appliance(String name, HabitableRoom location){
		this.name = name;
		this.actualRoom = location;
		actualRoom.addAppliance(this);
		index = instanceCounter;
		instanceCounter++;
	}

	public void breakDown(){
		isBroken = true;
	}

	public abstract void use(Person person);
	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba){//todo
		return 0;
	}

	public void setOnFire(){
		actualRoom.setOnFire();
	}

	public void turnIddle(){}//todo podle ApplianceState
	public void turnOFF(){}
	public void turnON(){}

	public ApplianceType getType(){
		return type;
	}

	public boolean isBroken(){
		return isBroken;
	}

	@Override
	public String toString() {
		return name + " of " + getClass();
	}

	public int getIndex() {
		return index;
	}
}