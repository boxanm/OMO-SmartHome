package Organism.Persons;
import EventsAlerts.AlertType;
import EventsAlerts.Info;
import EventsAlerts.Observer;
import House.Floor;
import House.House;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import House.Car;
import Organism.Organism;

import java.util.ArrayList;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Dad extends Organism implements Person, Adults  {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private Child childList = null;

	public Dad(String name, Room room){
		this.name = name;
		this.actualRoom = room;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void finalize() throws Throwable {

	}

	public void callFireman(Room room){

	}

	public void nextAction(){

	}

	/**
	 * 
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance){

	}

	/**
	 * 
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment){

	}

	public void hangOn() {

	}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}

	public Info newInfo(){
		return null;
	}

	/**
	 * 
	 * @param child
	 */
	public void cheerUp(Child child){

	}

	/**
	 * 
	 * @param room
	 */
	public void extinguish(Room room){

	}

	/**
	 * 
	 * @param car
	 */
	public void useCar(Car car){

	}

}