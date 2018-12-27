package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ConsumptionType;
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
		return new Freezer(name,brand, this.location, ConsumptionType.electricity, freezerComsuption);
	}

	public Appliance createCandy(String name){
		return (Freezer)createAppliance(name,"Candy");
	}


}