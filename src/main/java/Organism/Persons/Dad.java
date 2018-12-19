package Organism.Persons;
import EventsAlerts.AlertType;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import EventsAlerts.Observer;
import House.Floor;
import House.House;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import House.Car;
import Organism.Organism;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Dad extends Organism implements Person, Adults  {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private ArrayList<Child> childList = new ArrayList<Child>();

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
		newInfo(new Info(InfoType.callingFireman, this, getFloor(),actualRoom, room));
	}

	public void nextAction(){
		if(! isBusy){
			if(applianceUsageNumber < sportequipmentUsage){
				ArrayList<Appliance> appliances = m_House.getAppliances();
				useAppliance(appliances.get(new Random().nextInt(appliances.size())));
			}
			else{
				ArrayList<SportEquipment> sportEquipments = m_House.getSportEquipment();
				useSportEquipment(sportEquipments.get(new Random().nextInt(sportEquipments.size())));
			}
			isBusy = true;
		}

	}

	/**
	 * 
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance){
		applianceUsageNumber++;
		newInfo(new Info(InfoType.applianceUsage, this, getFloor(), actualRoom, appliance));

	}

	/**
	 * 
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment){
		sportequipmentUsage++;
		newInfo(new Info(InfoType.sportEquipmentUsage, this, getFloor(), actualRoom, equipment));

	}

	public void hangOn() {

	}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){
		switch (alert){
			case fire:
			case broken:
			case babyCrying:
				//TODO kde zjisti, na jakem objektu alert probiha?
		}

	}

	/**
	 * 
	 * @param child
	 */
	public void cheerUp(Child child){
		newInfo(new Info(InfoType.cheeringUpChild, this, getFloor(), actualRoom, child));
		child.stopCrying(50);
	}

	/**
	 * 
	 * @param room
	 */
	public void extinguish(Room room){
		if(actualRoom == room){
			newInfo(new Info(InfoType.extinguishingFire, this, getFloor(), actualRoom, room));
			room.extinguishFire();
		}
		else
			changeRoom(room);
	}

	/**
	 * 
	 * @param car
	 */
	public void useCar(Car car){

	}

}