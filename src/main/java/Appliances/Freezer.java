package Appliances;

import Appliances.ApplianceState.StateON;
import House.HabitableRoom;

/**
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Freezer extends FreezingAppliance {


    public Freezer(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location,consumptionType, consumption);
		setState(new StateON(this)); // lednice je defaultne zapnuta
    }


	@Override
	public String toString() {
		return "Freezer " + deviceName;
	}

}