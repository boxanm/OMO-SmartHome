package Organism;

import EventsAlerts.EventReporter;
import EventsAlerts.InfoGenerator;
import House.Room;
import House.House;

/**
 * Rozhraní definující spoleèné vlastnosti a metody lidí a zvíøat.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:57
 */
public abstract class Organism implements InfoGenerator {
	EventReporter eventReporter;


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

}