package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.HifiTower;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class HiFiTowerCreator extends ApplianceCreator {



	public HiFiTowerCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new HifiTower(name,brand, this.location, ConsumptionType.electricity, hifiComsuption);
	}

	public HifiTower createSencor(String name){
		return (HifiTower) createAppliance(name,"Sencor");
	}

}