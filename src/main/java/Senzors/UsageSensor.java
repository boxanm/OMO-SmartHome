package Senzors;

import EventsAlerts.AlertGenerator;
import EventsAlerts.Consumption;
import EventsAlerts.Event;

/**
 * V pøípadì rozbití spotøebièe generuje alert, jinak pouze informuje o stavu
 * použití.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class UsageSensor implements Sensor, AlertGenerator, Meter {

	public UsageSensor(){

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

	}

	@Override
	public void newConsumption(Consumption consumption) {

	}
}