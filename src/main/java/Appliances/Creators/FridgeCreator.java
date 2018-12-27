package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.Fridge;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FridgeCreator extends ApplianceCreator {

	public FridgeCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new Fridge(name,brand, this.location, ConsumptionType.electricity, fridgeComsuption);
	}

	public Fridge createWhirlpool(String name){

		return (Fridge) createAppliance(name,"Whirlpool");
	}

}