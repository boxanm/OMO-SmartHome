package Senzors;

import EventsAlerts.*;
import House.House;
import House.Room;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class FireSensor implements AlertGenerator, Senzor {

	EventReporter eventReporter;

	private Room room;

	public FireSensor(House house, Room room){
		eventReporter = house.getEventReporter();
		this.room = room;
	}


	public void update(){
		if(room.isOnFire())
			newAlert();
	}

	@Override
	public void newAlert() {
		eventReporter.updateFromAlertGenerator(new Alert(AlertType.fire,this,null,null,null));
	}
}