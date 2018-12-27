package Sensors;

import EventsAlerts.*;
import House.House;
import House.Outside;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:18
 */
public class WindSensor implements AlertGenerator, Sensor {

	EventReporter eventReporter;


	public WindSensor(House house){
		house.getOutside().attach(this);
		eventReporter = house.getEventReporter();
	}

	public void update(Observable observable){
		if(observable instanceof Outside)
			if(((Outside) observable).getIsWind())
				newAlert(new Alert(AlertType.wind,this,null,null,null));
	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromAlertGenerator(alert);
	}

	@Override
	public String toString() {
		return "WindSensor";
	}
}