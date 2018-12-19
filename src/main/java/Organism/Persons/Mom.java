package Organism.Persons;
import EventsAlerts.AlertType;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import EventsAlerts.Observer;
import House.Car;
import House.House;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import Organism.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Mom extends Organism implements Adults, Person {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private Child childList = null;

	public Mom(String name, Room room){
		this.name = name;
		this.actualRoom = room;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param child
	 */
	public void cheerUp(Child child){
		newInfo(new Info(InfoType.cheeringUpChild, this, getFloor(), actualRoom, child));
		child.stopCrying(90);
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

	/**
	 * 
	 * @param room
	 */
	public void callFireman(Room room){
		newInfo(new Info(InfoType.callingFireman, this, getFloor(),actualRoom, room));
	}

	public void nextAction(){
		if(! isBusy){
			if(applianceUsageNumber < sportequipmentUsage){
				List<Appliance> kitchenAppliances = m_House
						.getAppliances()
						.stream()
						.filter(Appliance->Appliance.getType().equals(ApplianceType.kitchen))
						.collect(Collectors.toList());


				useAppliance(kitchenAppliances.get(new Random().nextInt(kitchenAppliances.size())));
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

	}

	public Info newInfo(){
		return null;
	}

}