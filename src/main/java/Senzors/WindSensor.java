package Senzors;

import EventsAlerts.*;
import House.House;
import House.Outside;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:18
 */
public class WindSensor implements AlertGenerator, Senzor {

	EventReporter eventReporter;

	private Outside outside;
	private boolean wind;

	public WindSensor(House house){
		this.outside = house.getOutside();
		eventReporter = house.getEventReporter();
	}

	public Event newEvent(){
		return null;
	}

	public void update(){
		if(outside.getIsWind())
			newAlert();
	}

	@Override
	public void newAlert() {
		eventReporter.newEvent(new Alert(AlertType.wind,this,null,null,null));
	}
}