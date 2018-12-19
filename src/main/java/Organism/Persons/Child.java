package Organism.Persons;
import EventsAlerts.AlertType;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import EventsAlerts.Observer;
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
public class Child extends Organism implements Person {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private boolean isSad;

	public Child(String name, Room room){
		this.name = name;
		this.actualRoom = room;
		isSad = false;
	}

	public void finalize() throws Throwable {

	}


	public void callFireman(Room room){
		newInfo(new Info(InfoType.callingFireman, this, getFloor(),actualRoom, room));

	}

	public boolean cry(){
		return new Random().nextInt(100) <= 30;
	}

	public boolean stopCrying(int chance){
		if(isSad){
			if(new Random().nextInt(100) <= chance){
				isSad = false;
				return true;
			}
		}
		else{
			cry();
		}
		return false;
	}
	public void nextAction(){
		if(cry()){} // child is crying

		else{
			if(! isBusy){
				if(applianceUsageNumber < sportequipmentUsage){
					List<Appliance> entertainments = m_House
							.getAppliances()
							.stream()
							.filter(Appliance->Appliance.getType().equals(ApplianceType.entertainment))
							.collect(Collectors.toList());


					useAppliance(entertainments.get(new Random().nextInt(entertainments.size())));
				}
				else{
					ArrayList<SportEquipment> sportEquipments = m_House.getSportEquipment();
					useSportEquipment(sportEquipments.get(new Random().nextInt(sportEquipments.size())));
				}
				isBusy = true;
			}
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

	public void hangOn(){

	}

	/**
	 *
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}


}