package Appliances.Creators;


import Appliances.ComsuptionType;
import Appliances.Xbox;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:43
 */
public class XboxCreator extends ApplianceCreator {

	public XboxCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Xbox createAppliance(String name, String brand) {
		return new Xbox(name, brand, this.location, ComsuptionType.electricity, comsuptionData.getXboxComsuption());
	}

	public Xbox createMicrosoft(String name){
		return createAppliance(name,"Microsoft");
	}

}