package Animals;

import EventsAlerts.Event;
import EventsAlerts.Info;
import House.Floor;
import House.House;
import House.Room;
import EventsAlerts.Observer;

import java.util.ArrayList;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Dog implements Animal {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private Floor actualFloor = null;
	private Room actualRoom = null;
	private boolean isBusy = false;
	private House m_House = null;

	public Dog(Room room, Floor floor){
		actualFloor = floor;
		actualRoom = room;
	}
	public Event makeSound() {
		return null;
	}
	public void finalize() throws Throwable {

	}

	public void moveToHouse(House house){
		m_House = house;
	}
	/**
	 * 
	 * @param room
	 */
	public void changeRoom(Room room){
		actualFloor = m_House.getFloorOfRoom(room);
		actualRoom = room;

	}

	public void setOnFire(){

	}

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){
		if(!observersList.contains(observer))
			observersList.add(observer);
	}

	public void detach(Observer observer){
		observersList.remove(observer);
	}

	public void announce(){
		for(Observer observer: observersList)
			observer.update();
	}

	public Info newInfo(){
		return null;

	}

}