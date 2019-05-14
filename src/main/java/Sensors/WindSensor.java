package Sensors;

import EventsAlerts.*;
import House.House;
import House.Outside;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:18
 */
public class WindSensor implements AlertGenerator, Sensor {

	EventReporter eventReporter;


	/**
	 * one WindSensor serves the house exterior
	 * @param house house's outside is attached to this sensor
	 */
	public WindSensor(House house){
		house.getOutside().attach(this);
		eventReporter = house.getEventReporter();
	}

	/**
	 * in case of wind creates new alert
	 * @param observable house's outside
	 */
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