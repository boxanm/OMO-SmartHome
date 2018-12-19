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

import java.util.ArrayList;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Dad implements Person, Adults {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private Room actualRoom = null;
	private boolean isBusy = false;
	private House m_House = null;
	private String name = null;

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private Child childList = null;

	public Dad(String name, Room room){
		this.name = name;
		this.actualRoom = room;
	}

	public void moveToHouse(House house){
		m_House = house;
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
	 * @param room
	 */
	public void changeRoom(Room room){

	}

	public void setOnFire(){

	}

	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}
	public void attach(Observer observer){
		if(!observersList.contains(observer))
			observersList.add(observer);
	}

	public void detach(Observer observer){
		observersList.remove(observer);
	}

	public void announce(){
		for(Observer observer: observersList)
			observer.update();
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