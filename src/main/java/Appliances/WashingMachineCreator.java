package Appliances;


import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class WashingMachineCreator extends WashingMachine {

	public WashingMachineCreator(String name, HabitableRoom location){
		new WashingMachine(name, location);
	}

}