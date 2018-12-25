package Appliances;

import Appliances.ApplianceState.ApplianceState;
import EventsAlerts.*;
import House.Floor;
import House.Room;
import House.HabitableRoom;
import LapsTime.LapSubscriber;
import Organism.Persons.Person;
import Organism.Usable;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class Appliance implements AlertHandler, ConsuptionGenerator, Observable, InfoGenerator, LapSubscriber, Usable {

	private int consuptionIddle = 0;
	private int consuptionOFF = 0;
	private int consuptionON = 0;
	private ApplianceState applianceState = null;

	private Floor actualFloor = null;
	private HabitableRoom actualRoom = null;
	private ConsuptionType consumptionType = null;
	private boolean isBroken = false;
	private boolean isBusy = false;

	private String name;


	public Appliance(String name, HabitableRoom location){
		this.name = name;
		this.actualRoom = location;
		actualRoom.addAppliance(this);
	}

	public void breakDown(){
		isBroken = true;
	}

	public abstract Usable use(Person person);
	/**
	 * 
	 * @param typSpotreba
	 */
	public abstract int getAktualniSpotreba(ConsuptionType typSpotreba);

	public void setOnFire(){
		actualRoom.setOnFire();
	}

	public void turnIddle(){}//todo podle ApplianceState
	public void turnOFF(){}
	public void turnON(){}

	public boolean isBroken(){
		return isBroken;
	}

	public boolean isBusy() {
		return isBusy;
	}

	@Override
	public String toString() {
		return name + " of " + getClass();
	}

}