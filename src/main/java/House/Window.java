package House;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Window {

	private Blind blind;
	private Room room;

	public Window(Room room, Blind blind){
		this.room = room;
		this.blind = blind;

	}

	public Blind getBlind() {
		return blind;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}