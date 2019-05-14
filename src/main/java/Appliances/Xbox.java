package Appliances;

import House.HabitableRoom;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class Xbox extends CDplayer {

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public Xbox(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location, consumptionType, consumption);
    }


	@Override
	public String toString() {
		return "Xbox " + deviceName;
	}
}