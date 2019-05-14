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
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Mom extends Person implements Adults {

	private static final int cheerUpChildProbability = 90;

	private ArrayList<Child> childList = new ArrayList<Child>();

	public Mom(String name){
        super(name);
    }




	/**
	 * tries to cheerUp child, the probability of success is high
	 * @param child which is sad
	 */
	public void cheerUp(Child child){
		newInfo(new Info(InfoType.cheeringUpChild, this, getFloor(), actualRoom, child));
		child.stopCrying(cheerUpChildProbability);
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
		usingTarget = car.use(this);
	}

	public void addChild(Child child){
		if(! childList.contains(child))
			childList.add(child);
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
						callFireman(rooms.get(new Random().nextInt(rooms.size())));
					return true;
				}
				case babyCrying:{
					List<Child> children = childList
							.stream()
							.filter(Child::isSad)
							.collect(Collectors.toList());
					if(children.size() > 0)
						cheerUp(children.get(new Random().nextInt(children.size())));
					return true;
				}
				case outOfFood: {
					List<Car> cars = m_House
							.getCars()
							.stream()
							.filter(Car::isPresent)
							.collect(Collectors.toList());
					if (cars.size() > 0) {
						useCar(cars.get(new Random().nextInt(cars.size())));
					}
					return true;
				}
			}
		}
	return false;
	}

    @Override
    public void addHandlerToControlUnit(ControlUnit controlUnit) {
        m_House.getControlUnit().addAlertHandler(this);
    }

    @Override
    public void moveToHouse(House house) {
        super.moveToHouse(house);
        addHandlerToControlUnit(house.getControlUnit());
    }

    @Override
    public String toString() {
        return "Mom " + name;
    }
}