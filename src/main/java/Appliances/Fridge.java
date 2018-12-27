package Appliances;

import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;
import Appliances.ApplianceState.StateON;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.Calendar;
import java.util.Map;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Fridge extends FreezingAppliance {


	public Fridge(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption){
		super(name,brand, location, consumptionType, consumption);
		setState(new StateON(this)); // lednice je defaultne zapnuta
	}


	@Override
	public String toString() {
		return "Fridge " + deviceName;
	}
}