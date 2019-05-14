package Sensors;

import EventsAlerts.*;
import House.House;
import House.Room;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class FireSensor implements AlertGenerator, Sensor {

	private EventReporter eventReporter;

	/**
	 * one electricitySensor serves all rooms in the house
	 * @param house all appliances located in house are attached to this sensor
	 */
	public FireSensor(House house){
		eventReporter = house.getEventReporter();
		for (Room room: house.getRoomList()
			 ) {
			room.attach(this);

		}
	}

	/**
	 * creates new Alert Event informing, that there's fire somewhere in the house
	 * @param observable room which is on fire
	 */
	public void update(Observable observable){
		if(observable instanceof  Room && ((Room) observable).isOnFire())
			newAlert(new Alert(AlertType.fire,this,null,null,null));
	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromAlertGenerator(alert);
	}


	@Override
	public String toString() {
		return "FireSensor";
	}
}