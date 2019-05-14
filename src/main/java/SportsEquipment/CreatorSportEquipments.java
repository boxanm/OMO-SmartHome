package SportsEquipment;


import House.NonHabitableRoom;

/**
 * Pattern factory method
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class CreatorSportEquipments {

	protected NonHabitableRoom location;

	/**
	 * Sport equipment factory
	 * @param location all equipments are located in defined NonhabitableRoom location
	 */
	public CreatorSportEquipments(NonHabitableRoom location){
		this.location = location;
	}

	/**
	 * Creates sport equipment of defined brand
	 * @param brand sport equipment brand
	 * @return concrete sport equipment
	 */
	protected abstract SportEquipment createEquipment(String brand);
}