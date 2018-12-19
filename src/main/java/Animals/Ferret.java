package Animals;

import EventsAlerts.Event;
import EventsAlerts.Info;
import House.House;
import House.Room;
import House.Floor;
import EventsAlerts.Observer;
import Organism.Organism;

import java.util.ArrayList;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Ferret extends Organism implements Animal {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	public Ferret(Room room){
		actualRoom = room;
	}

	public Event makeSound() {
		return null;
	}

	public void finalize() throws Throwable {

	}


	public Info newInfo(){
		return null;
	}

}