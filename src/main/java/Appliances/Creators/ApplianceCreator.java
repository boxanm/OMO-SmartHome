package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ComsuptionData;
import Appliances.ComsuptionType;
import House.HabitableRoom;

/**
 * Factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class ApplianceCreator {

	protected HabitableRoom location;
	protected ComsuptionData comsuptionData;

	public ApplianceCreator(HabitableRoom location){
		this.location = location;
	}

	protected abstract Appliance createAppliance(String name,String brand);

}