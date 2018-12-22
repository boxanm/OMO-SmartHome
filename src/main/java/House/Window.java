package House;


import EventsAlerts.AlertHandler;
import EventsAlerts.AlertType;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Window  {

	private Blind blind;
	private Room room;

	public Window(Room room){
		this.room = room;
		this.blind = new Blind();

	}

	public Blind getBlind() {
		return blind;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}