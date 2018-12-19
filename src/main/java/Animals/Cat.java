package Animals;

import EventsAlerts.Event;
import EventsAlerts.Info;
import House.Floor;
import House.House;
import House.Room;
import EventsAlerts.Observer;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Cat implements Animal {


	Floor actualFloor = null;
	Room actualRoom = null;
	boolean isBusy = false;
	House m_House = null;

	public Cat(Room room, Floor floor){
		actualFloor = floor;
		actualRoom = room;
	}

	public void finalize() throws Throwable {

	}
	public Event makeSound() {
		return null;
	}
	/**
	 * 
	 * @param room
	 */
	public void changeRoom(Room room){
		actualFloor = m_House.getFloorOfRoom(room);
		this.actualRoom = room;

	}

	public void moveToHouse(House house){
		m_House = house;
	}
	public void setOnFire(){

	}

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){

	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){

	}

	public void announce(){

	}

	public Info newInfo(){
		return null;

	}

}