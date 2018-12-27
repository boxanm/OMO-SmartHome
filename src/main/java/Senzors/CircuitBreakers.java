package Senzors;

import EventsAlerts.Alert;
import EventsAlerts.AlertGenerator;
import EventsAlerts.Event;
import EventsAlerts.Observable;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class CircuitBreakers implements Sensor, AlertGenerator {

	private boolean triped;

	public CircuitBreakers(){

	}


	public boolean isTriped(){
		return false;
	}

	public void update(){

	}

	public Event newEvent(){
		return null;
	}


	@Override
	public void newAlert(Alert alert) {

	}

	@Override
	public void update(Observable observable) {

	}
}