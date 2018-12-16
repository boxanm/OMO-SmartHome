package Organism.Persons;

import House.Room;
import House.Car;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody dosp�l�ch.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public interface Adults {

	public Child childList = null;

	/**
	 * 
	 * @param room
	 */
	public void extinguish(Room room);

	/**
	 * 
	 * @param child
	 */
	public void cheerUp(Child child);

	/**
	 * 
	 * @param car
	 */
	public void useCar(Car car);

}