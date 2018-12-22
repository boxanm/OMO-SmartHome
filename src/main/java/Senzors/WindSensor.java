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

	public WindSensor(House house){
		this.outside = house.getOutside();
		eventReporter = house.getEventReporter();
	}

	public void update(){
		if(outside.getIsWind())
			newAlert();
	}

	@Override
	public void newAlert() {
		eventReporter.updateFromAlertGenerator(new Alert(AlertType.wind,this,null,null,null));
	}

	@Override
	public String toString() {
		return "WindSensor";
	}
}