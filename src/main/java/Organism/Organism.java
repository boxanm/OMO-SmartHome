package Organism;

import House.Floor;
import House.Room;
import EventsAlerts.Observed;
import House.House;

/**
 * Rozhraní definující spoleèné vlastnosti a metody lidí a zvíøat.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:57
 */
public interface Organism extends Observed {

	Floor actualFloor = null;
	Room actualRoom = null;
	boolean isBusy = false;
	House m_House = null;

	/**
	 * 
	 * @param room
	 */
	public void changeRoom(Room room);

	public void setOnFire();


	public void moveToHouse(House house);

}