package Animals;

import EventsAlerts.Event;
import EventsAlerts.Info;
import House.Floor;
import House.House;
import House.Room;
import EventsAlerts.Observer;
import Organism.Organism;

import java.util.ArrayList;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Cat extends Organism implements Animal {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	public Cat(Room room){
		actualRoom = room;
	}

	public void finalize() throws Throwable {

	}
	public Event makeSound() {
		return null;
	}


	public Info newInfo(){
		return null;

	}

}