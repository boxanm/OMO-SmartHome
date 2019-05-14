package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.PlayStation;
import House.HabitableRoom;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PlayStationCreator extends ApplianceCreator {

	public PlayStationCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new PlayStation(name,brand, this.location, ConsumptionType.electricity, playstationComsuption);
	}

	public PlayStation createSony(String name) {
		return (PlayStation) createAppliance(name,"Sony");
	}

}