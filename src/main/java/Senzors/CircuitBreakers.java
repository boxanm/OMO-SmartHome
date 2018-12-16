package Senzors;

import EventsAlerts.AlertGenerator;
import EventsAlerts.Event;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class CircuitBreakers implements Senzor, AlertGenerator {

	private boolean triped;

	public CircuitBreakers(){

	}

	public void finalize() throws Throwable {

	}

	public boolean isTriped(){
		return false;
	}

	public void update(){

	}

	public Event newEvent(){
		return null;
	}

}