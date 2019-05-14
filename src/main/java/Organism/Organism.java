package Organism;


import EventsAlerts.*;
import House.Room;
import House.Floor;
import House.House;
import LapsTime.LapSubscriber;
import Organism.Persons.Usable;

import java.util.Random;

/**
 * Rozhraní definující spoleèné vlastnosti a metody lidí a zvíøat.
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:57
 */
public abstract class Organism implements InfoGenerator, EventSource, EventTarget, LapSubscriber {
	protected EventReporter eventReporter;


	protected String name;
	protected Room actualRoom = null;
	protected boolean isBusy = false;
	protected House m_House = null;

	protected Usable usingTarget = null;

	public Organism(String name){
		this.name = name;
	}

	/**
	 * 
	 * @param room moves to room
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

    /**
     * moves organism to defined house and random room
     * @param house
     */
	public void moveToHouse(House house){
		m_House = house;
		actualRoom = house.getRoomList().get(new Random().nextInt(house.getRoomList().size()));
		actualRoom.addOrganism(this);
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

	@Override
	public abstract void newLap();

	@Override
	public String toString() {
		return name;
	}
}