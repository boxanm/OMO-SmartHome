package Organism.Persons;
import EventsAlerts.*;
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

	private int cheerUpChildProbability = 90;

	private ArrayList<Child> childList = new ArrayList<Child>();

	public Mom(String name){
        super(name);
    }

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param child
	 */
	public void cheerUp(Child child){
		newInfo(new Info(InfoType.cheeringUpChild, this, getFloor(), actualRoom, child));
		child.stopCrying(cheerUpChildProbability);
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
		newInfo(new Info(InfoType.drivingCar, this, getFloor(), actualRoom, car));//TODO menit pokoj vzdy pred akci?
		car.goShopping(this);
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
				List<Appliance> appliances = m_House
						.getAppliances()
						.stream()
						.filter(Appliance-> !Appliance.isBroken())
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

	/**
	 * 
	 * @param appliance
	 */

	/**
	 *
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance){

		if(appliance != null) {
			applianceUsageNumber++;
			appliance.use(this);
			isBusy = true;
		}
//		applianceUsageNumber++;
//		newInfo(new Info(InfoType.applianceUsage, this, getFloor(), actualRoom, appliance));
//		switch (appliance.getType()){
//			case freezing:
//				FreezingAppliance freezingAppliance = (FreezingAppliance) appliance;
//				if(! freezingAppliance.isEmpty())
//					freezingAppliance.eat(foodConsumption);
//				else{
//					Car car = m_House
//							.getCars()
//							.stream()
//							.filter(Car::isPresent)
//							.findAny()
//							.get();
//					useCar(car);
//					freezingAppliance.fill(50 + new Random().nextInt(50));//TODO probehne ve stejnem tahu?
//				}
//				break;
//			case entertainment:
//		}
	}

	/**
	 * 
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment){
		sportequipmentUsage++;
		newInfo(new Info(InfoType.sportEquipmentUsage, this, getFloor(), actualRoom, equipment));

	}

	public void hangOn() {	}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(Alert alert){ //TODO mozna prebirat rovnou alert?
		if(! isBusy){
			isBusy = true;
			switch (alert.getAlertType()){
				case fire:{
					Room room = m_House
							.getRoomList()
							.stream()
							.filter(Room::isOnFire)
							.findFirst()
							.get();
					callFireman(room);
					break;
				}
				case babyCrying:{
					Child child = childList
							.stream()
							.filter(Child::isSad)
							.findFirst()
							.get();
					cheerUp(child);
					break;
				}
			}
		}

	}

    @Override
    public String toString() {
        return "Mum " + name;
    }
}