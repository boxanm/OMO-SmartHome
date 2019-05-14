package EventsAlerts;


import Appliances.ConsumptionType;
import House.Floor;
import House.Room;

/**
 * @author Michal Koreš, Matìj Boxan Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class Consumption extends Event {

	private double consumption;
	private ConsumptionType type;

	public Consumption(ConsumptionType consumptionType, double consumption, EventSource source,
					   Floor floor, Room room, EventTarget target){

		this.type = consumptionType;
		this.source = source;
		this.sourceFloor = floor;
		this.sourceRoom = room;
		this.target = target;
		this.consumption = consumption;

	}

	public double getConsumption() {
		return consumption;
	}

	@Override
	public String toString() {
		return "Consumption: " + consumption + " | " + source.toString() + " => " + target.toString();
	}

	public ConsumptionType getType() {
		return type;
	}
}