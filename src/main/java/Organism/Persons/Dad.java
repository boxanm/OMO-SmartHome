package Organism.Persons;
import EventsAlerts.AlertType;
import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import House.Car;
import Organism.Organism;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Dad extends Organism implements Person, Adults  {

	private int applianceUsageNumber = 0;
	private int sportEquipmentUsageNumber = 0;
	private int foodConsumption = 7;
	private int cheerUpChildProbability = 30;

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
		if(appliance instanceof FreezingAppliance) //TODO
		switch (appliance.getType()){
			case freezing:
				FreezingAppliance freezingAppliance = (FreezingAppliance) appliance;
//				((FreezingAppliance) appliance).eat(10);
				if(! freezingAppliance.isEmpty())
					freezingAppliance.eat(foodConsumption);
				else{
					Car car = m_House
						.getCars()
						.stream()
						.filter(Car::isPresent)
						.findAny()
						.get();
					useCar(car);
					freezingAppliance.fill(50 + new Random().nextInt(50));//TODO probehne ve stejnem tahu?
				}
		}
	}

	/**
	 * 
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment){
		sportEquipmentUsageNumber++;
		newInfo(new Info(InfoType.sportEquipmentUsage, this, getFloor(), actualRoom, equipment));

	}

	public void hangOn() {}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){
		if(! isBusy){
			isBusy = true;
			switch (alert){
				case fire:{
					Room room = m_House
							.getRoomList()
							.stream()
							.filter(Room::isOnFire)
							.findFirst()
							.get();
					extinguish(room);
					break;
				}
				case broken:{
					Appliance appliance = m_House
							.getAppliances()
							.stream()
							.filter(Appliance::isBroken)
							.findFirst()
							.get();
					repair(appliance);
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
	 * @param appliance
	 */
	public void repair(Appliance appliance){
		newInfo(new Info(InfoType.repairingAppliance, this, getFloor(), actualRoom, appliance));
//		appliance.(); //TODO stahnout manual a opravit
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
		newInfo(new Info(InfoType.drivingCar, this, getFloor(), actualRoom, car));
		car.goShopping(this);
	}

}