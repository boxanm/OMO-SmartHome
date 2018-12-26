package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ComsuptionType;
import Appliances.Freezer;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FreezerCreator extends ApplianceCreator {

	public FreezerCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new Freezer(name,brand, this.location, ComsuptionType.electricity, comsuptionData.getFreezerComsuption());
	}

	public Freezer createCandy(String name){
		return (Freezer) createAppliance(name,"Candy");
	}


}