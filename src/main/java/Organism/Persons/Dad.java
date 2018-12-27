package Organism.Persons;
import EventsAlerts.*;
import House.House;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import House.Car;
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
public class Dad extends Person implements Adults  {

	private static final int foodConsumption = 7;
	private static final int cheerUpChildProbability = 30;

	private ArrayList<Child> childList = new ArrayList<Child>();

	public Dad(String name){
		super(name);
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param alert
	 */
	public boolean handleAlert(Alert alert){
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
					extinguish(room);
					return true;
				}
				case broken:{
					Appliance appliance = m_House
							.getAppliances()
							.stream()
							.filter(Appliance::isBroken)
							.findFirst()
							.get();
					repair(appliance);
					return true;
				}
				case babyCrying:{
					Child child = childList
							.stream()
							.filter(Child::isSad)
							.findFirst()
							.get();
					cheerUp(child);
					return true;
				}
				case outOfFood: {
					List<Car> cars = m_House
							.getCars()
							.stream()
							.filter(Car::isPresent)
							.collect(Collectors.toList());
					for (Car car: cars) {
						if(car.getActualCarStorage() > 0)
							if(alert.getSource() instanceof FreezingAppliance){
								((FreezingAppliance) alert.getSource()).fill(car.getActualCarStorage());
								car.emptyCarStorage();
							}
					}
					if (cars.size() > 0) {
						useCar(cars.get(new Random().nextInt(cars.size())));
					}
					return true;
				}
			}
		}
		return false;


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
//		appliance.; //TODO stahnout manual a opravit
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
		isBusy = true;
		newInfo(new Info(InfoType.drivingCar, this, getFloor(), actualRoom, car));
		car.goShopping(this);
	}


	public void addChild(Child child){
		if(! childList.contains(child))
			childList.add(child);
	}

    @Override
    public void moveToHouse(House house) {
        super.moveToHouse(house);
        addHandlerToControlUnit(house.getControlUnit());
    }

    @Override
    public void addHandlerToControlUnit(ControlUnit controlUnit) {
	    controlUnit.addAlertHandler(this);
    }

    @Override
    public String toString() {
        return "Dad " + name;
    }

}