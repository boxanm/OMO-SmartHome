package Senzors;

import EventsAlerts.AlertGenerator;
import EventsAlerts.Event;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:18
 */
public class WindSensor implements AlertGenerator, Senzor {

	private boolean wind;

	public WindSensor(){

	}

	public void finalize() throws Throwable {

	}

	public boolean isWind(){
		return false;
	}

	public Event newEvent(){
		return null;
	}

	public void update(){

	}

}