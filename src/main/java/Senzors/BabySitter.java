package Senzors;

import EventsAlerts.*;
import House.Room;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class BabySitter implements Senzor, AlertGenerator {
	EventReporter eventReporter;

	private Room room;

	public BabySitter(){

	}

	public void finalize() throws Throwable {

	}

	public void update(){


	}

	public Event newEvent(){
		return null;
	}

	@Override
	public void newAlert() {
		eventReporter.updateFromObserver(new Alert(AlertType.babyCrying,this, null, null, null));
	}
	@Override
	public String toString() {
		return "Babysitter in " + room.toString();
	}
}