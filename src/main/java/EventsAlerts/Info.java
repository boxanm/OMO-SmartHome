package EventsAlerts;


import House.Floor;
import House.Room;

/**
 * @author Michal Koreš, Matìj Boxan Koreš, Matìj Boxan
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

	@Override
	public String toString() {
		return "Info: " + type.toString() + " | " + source.toString() + " => " + target.toString();
	}

	public InfoType getType() {
		return type;
	}

	@Override
	public EventSource getSource() {
		return super.getSource();
	}
}