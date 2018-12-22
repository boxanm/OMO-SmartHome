package SportsEquipment;


import House.NonHabitableRoom;

/**
 * Návrhový vzor factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class CreatorSportEquipments {

	protected NonHabitableRoom location;

	public CreatorSportEquipments(NonHabitableRoom location){
		this.location = location;
	}


	protected abstract SportEquipment createEquipment(String brand);
}