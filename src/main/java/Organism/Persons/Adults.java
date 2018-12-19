package Organism.Persons;

import EventsAlerts.AlertHandler;
import House.Room;
import House.Car;

/**
 * Rozhraní definující spoleèné vlastnosti a metody dospìlých.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public interface Adults extends AlertHandler {


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