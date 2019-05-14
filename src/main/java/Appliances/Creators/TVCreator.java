package Appliances.Creators;


import Appliances.ConsumptionType;
import Appliances.TV;
import House.HabitableRoom;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TVCreator extends ApplianceCreator {

	public TVCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected TV createAppliance(String name,String brand) {
		return new TV(name, brand, this.location, ConsumptionType.electricity, tvComsuption);
	}

	public TV createSamsung(String name){
		return createAppliance(name,"Samsung");
	}

}