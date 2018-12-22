package Organism.Persons;
import EventsAlerts.*;
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
public class Child extends Organism implements Person, Observable {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private int applianceUsageNumber = 0;
	private int sportequipmentUsage = 0;

	private int cryProbability = 30;
	private boolean isSad;

	public Child(String name){
        super(name);
    }


	public void callFireman(Room room){
		newInfo(new Info(InfoType.callingFireman, this, getFloor(),actualRoom, room));

	}

	public boolean cry(){
		announce();
		return new Random().nextInt(100) <= cryProbability;
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
		if(! cry()){
			if(! isBusy){
				if(applianceUsageNumber < sportequipmentUsage){
					List<Appliance> appliances = m_House
							.getAppliances()
							.stream()
							.filter(Appliance->Appliance.getType().equals(ApplianceType.entertainment))
							.collect(Collectors.toList());
					useAppliance(appliances.get(new Random().nextInt(appliances.size())));
				}
				else{
					ArrayList<SportEquipment> sportEquipments = m_House.getSportEquipment();
					useSportEquipment(sportEquipments.get(new Random().nextInt(sportEquipments.size())));
				}
				isBusy = true;
			}
		}
		else{} // child is crying

	}

	public boolean isSad() {
		return isSad;
	}

	/**
	 * 
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance){
		if(appliance != null){
			applianceUsageNumber++;
			appliance.use(this);
			isBusy = true;
		}
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
		isBusy = true;

	}

	@Override
	public void attach(Observer observer) {
		if(! observersList.contains(observer))
			observersList.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observersList.remove(observer);

	}

	@Override
	public void announce() {
		for (Observer observer:observersList) {
			observer.update();

		}
	}


	@Override
	public String toString() {
		return "Child " + name;
	}
}