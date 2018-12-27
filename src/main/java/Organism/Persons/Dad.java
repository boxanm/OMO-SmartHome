package Organism.Persons;
import EventsAlerts.*;
import House.House;
import House.Room;
import Appliances.*;
import SportsEquipment.*;
import House.Car;
import Organism.Organism;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
	 * decides, what to do with parsed alert
	 * @param alert dad handles only alerts of certain types
	 */
	public boolean handleAlert(Alert alert){
		if(! isBusy){
			isBusy = true;
			switch (alert.getAlertType()){
				case fire:{
					List<Room> rooms = m_House
							.getRoomList()
							.stream()
							.filter(Room::isOnFire)
							.collect(Collectors.toList());
					if(rooms.size() > 0)
						extinguish(rooms.get(new Random().nextInt(rooms.size())));
					return true;
				}
				case broken:{
					List <Appliance> appliances = m_House
							.getAppliances()
							.stream()
							.filter(Appliance::isBroken)
							.collect(Collectors.toList());
					if(appliances.size() > 0)
						repair(appliances.get(new Random().nextInt(appliances.size())));
					return true;
				}
				case babyCrying:{
					List<Child> children = childList
							.stream()
							.filter(Child::isSad)
							.collect(Collectors.toList());
					if(children.size()>0)
						cheerUp(children.get(new Random().nextInt(children.size())));
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
				case circuitBreakers:{
					if(m_House.getCircuitBreakers().isTriped()){
						m_House.getCircuitBreakers().replace();
					}
					return true;
				}
			}
		}
		return false;


	}

	/**
	 * tries to cheerUp child, but dad's probability is fairly low
	 * @param child which is sad
	 */
	public void cheerUp(Child child){
		newInfo(new Info(InfoType.cheeringUpChild, this, getFloor(), actualRoom, child));
		child.stopCrying(cheerUpChildProbability);
	}

	/**
	 * get's manual and repairs appliance
	 * @param appliance to be repaired
	 */
	public void repair(Appliance appliance){
		newInfo(new Info(InfoType.repairingAppliance, this, getFloor(), actualRoom, appliance));
		appliance.getDeviceManual();
		appliance.repairAppliance();
	}
	/**
	 * 
	 * @param room which is on fire
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
	 * inform about car usage and go shopping
	 * @param car must is present in nonhabitable room
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