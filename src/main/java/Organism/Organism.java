package Organism;

import House.Floor;
import House.Room;
import EventsAlerts.Observed;
import House.House;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody lid� a zv��at.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:57
 */
public interface Organism extends Observed {

	public Floor actualFloor = null;
	public Room actualRoom = null;
	public boolean isBusy = false;
	public House m_House = null;

	/**
	 * 
	 * @param room
	 */
	public void changeRoom(Room room);

	public void setOnFire();



}