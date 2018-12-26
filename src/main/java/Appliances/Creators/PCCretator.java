package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ComsuptionType;
import Appliances.PC;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PCCretator extends ApplianceCreator {

	public PCCretator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new PC(name,brand, this.location, ComsuptionType.electricity, comsuptionData.getPcComsuption());
	}



	public PC createZalman(String name){
		return (PC) createAppliance(name,"Zalman");
	}

}