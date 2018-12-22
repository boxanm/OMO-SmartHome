package Appliances;

import Appliances.ApplianceState.ApplianceState;
import House.Floor;
import House.Room;
import EventsAlerts.AlertHandler;
import EventsAlerts.ConsuptionGenerator;
import EventsAlerts.Observable;
import House.HabitableRoom;
import Organism.Persons.Person;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class Appliance implements AlertHandler, ConsuptionGenerator, Observable {

	public int consuptionIddle = 0;
	public int consuptionOFF = 0;
	public int consuptionON = 0;
	public ApplianceState applianceState = null;

	public ApplianceType type = null;

	public Floor actualFloor = null;
	public Room actualRoom = null;
	public ConsuptionType consumptionType = null;
	public boolean isBroken = false;
	public boolean isBusy = false;

	String name;

	public Appliance(String name, HabitableRoom location){
		this.name = name;
		this.actualRoom = location;
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
		return name + " of " + type;
	}
}