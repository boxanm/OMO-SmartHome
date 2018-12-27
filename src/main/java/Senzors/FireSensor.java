package Senzors;

import EventsAlerts.*;
import House.House;
import House.Room;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class FireSensor implements AlertGenerator, Sensor {

	private EventReporter eventReporter;

	public FireSensor(House house){
		eventReporter = house.getEventReporter();
		for (Room room: house.getRoomList()
			 ) {
			room.attach(this);

		}
	}


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