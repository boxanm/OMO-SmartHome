package EventsAlerts;


import House.Floor;
import House.Room;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class Alert extends Event {

	private AlertType type;

	public Alert(AlertType alertType, EventSource source,
				 Floor floor, Room room, EventTarget target){
		this.type = alertType;
		this.source = source;
		this.sourceFloor = floor;
		this.sourceRoom = room;
		this.target = target;

	}
	public AlertType getAlertType() {
		return type;
	}


	@Override
	public String toString() {
		return "Alert: " + type.toString() + " | " + source.toString() + " => " + target.toString();
	}
}