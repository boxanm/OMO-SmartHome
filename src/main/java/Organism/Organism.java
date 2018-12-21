package Organism;

import EventsAlerts.*;
import House.Room;
import House.Floor;
import House.House;

/**
 * Rozhraní definující spoleèné vlastnosti a metody lidí a zvíøat.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:57
 */
public abstract class Organism implements InfoGenerator, EventSource, EventTarget {
	protected EventReporter eventReporter;


	protected String name = null;
	protected Room actualRoom = null;
	protected boolean isBusy = false;
	protected House m_House = null;


	/**
	 * 
	 * @param room
	 */
	public void changeRoom(Room room){
		actualRoom.removeOrganism(this);
		actualRoom = room;
		actualRoom.addOrganism(this);
	}

	public void setOnFire(){
		actualRoom.setOnFire();
	}

	public void setEventReporter(EventReporter eventReporter){
		this.eventReporter = eventReporter;
	}


	public void moveToHouse(House house){
		m_House = house;
		setEventReporter(house.getEventReporter());
	}


	public void newInfo(Info info){
		eventReporter.updateFromOrganism(info);
	}

	public Floor getFloor(){
		return actualRoom.getFloor();
	}

	public boolean isBusy(){
		return isBusy;
	}

}