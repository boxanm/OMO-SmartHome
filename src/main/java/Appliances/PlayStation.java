package Appliances;

import House.HabitableRoom;

/**
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PlayStation extends CDplayer{

	private final static int maxPlayDuration = 4;
	private int actualPlayDuration = 0;

	public PlayStation(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] comsuption){
	    super(name, brand, location, consumptionType, comsuption);
	}



	public void newConsumption(){

	}

	@Override
	public void newLap() {

	}

	@Override
	public String toString() {
		return "PlayStation " + deviceName;
	}
}