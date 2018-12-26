package Appliances.Creators;


import Appliances.Appliance;
import Appliances.ComsuptionType;
import Appliances.WashingMachine.WashingMachine;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class WashingMachineCreator extends ApplianceCreator {

	public WashingMachineCreator(HabitableRoom location){
		super(location);
	}

	@Override
	protected Appliance createAppliance(String name, String brand) {
		return new WashingMachine(name,brand, this.location, ComsuptionType.electricity, washingMachineComsuption);
	}


	public WashingMachine createBosch(String name){
		return (WashingMachine) createAppliance(name,"Bosch");
	}

}