package Organism.Persons;

import EventsAlerts.AlertHandler;
import EventsAlerts.EventSource;
import House.Room;
import House.Car;

/**
 * Rozhraní definující spoleèné vlastnosti a metody dospìlých.
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public interface Adults extends AlertHandler, EventSource {

	int cheerUpChildProbability = 0;

	/**
	 * 
	 * @param room extinguish fire in defined room
	 */
	public void extinguish(Room room);

	/**
	 * 
	 * @param child if sad, cheer it up!
	 */
	public void cheerUp(Child child);

	/**
	 * 
	 * @param car use Car and go shopping
	 */
	public void useCar(Car car);

	/**
	 *
	 * @param child take care of one more Child
	 */
	public void addChild(Child child);

}