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

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Dad implements Person, Adults {

	Room actualRoom = null;
	boolean isBusy = false;
	House m_House = null;
	public String name = null;

	public int applianceUsageNumber = 0;
	public int sportequipmentUsage = 0;

	public Child childList = null;

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