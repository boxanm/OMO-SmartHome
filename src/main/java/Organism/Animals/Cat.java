package Organism.Animals;

import EventsAlerts.*;
import House.Floor;
import House.Room;
import Organism.Organism;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Cat extends Organism implements Animal {

	public Cat(Room room){
		actualRoom = room;
	}

	public void finalize() throws Throwable {

	}
	public void makeSound() {
		Floor floor = m_House.getFloorOfRoom(actualRoom);
		newInfo(new Info(InfoType.animalSound, this, floor, actualRoom, this));
	}

}