package Organism;

import EventsAlerts.*;
import House.Room;
import House.Floor;
import House.House;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody lid� a zv��at.
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
		this.actualRoom = room;

	}

	public void setOnFire(){
		actualRoom.setOnFire();
	}

	public void setEventReporter(EventReporter eventReporter){
		this.eventReporter = eventReporter;
	}


	public void moveToHouse(House house){
		m_House = house;
	}


	public void newInfo(Info info){
		eventReporter.updateFromOrganism(info);
	}

	public Floor getFloor(){
		return m_House.getFloorOfRoom(actualRoom);
	}

}