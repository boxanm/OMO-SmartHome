package EventsAlerts;


import House.Floor;
import House.Room;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class Info extends Event {

	private InfoType type;

	public Info(InfoType infoType, EventSource source,
				Floor floor, Room room, EventTarget target){
		type = infoType;
		this.source = source;
		this.sourceFloor = floor;
		this.sourceRoom = room;
		this.target = target;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}