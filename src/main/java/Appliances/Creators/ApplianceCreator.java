package Appliances.Creators;


import Appliances.Appliance;

import House.HabitableRoom;

/**
 * Factory method
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class ApplianceCreator {

	protected HabitableRoom location;

	protected double fridgeComsuption[] = new double[] {0.8, 0.01, 0.0002};
	protected double playstationComsuption[] = new double[] {0.7, 0.04, 0.0006};
	protected double hifiComsuption[] = new double[] {0.6, 0.07, 0.00009};
	protected double freezerComsuption[] = new double[] {1, 0.02, 0.0005};
	protected double tvComsuption[] = new double[] {0.8, 0.02, 0.0005};
	protected double pcComsuption[] = new double[] {0.9, 0.03, 0.0001};
	protected double xboxComsuption[] = new double[] {0.7, 0.04, 0.0004};
	protected double washingMachineComsuption[] = new double[] {1.3, 0.01, 0.0002};

	public ApplianceCreator(HabitableRoom location){
		this.location = location;
	}

	/**
	* Create a new appliance with specific name and brand
	* @param name, brand
	*
	 */

	protected abstract Appliance createAppliance(String name,String brand);

}