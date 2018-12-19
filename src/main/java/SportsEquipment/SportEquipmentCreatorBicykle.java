package SportsEquipment;


import House.NonHabitableRoom;

/**
 * Návrhový vzor factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class SportEquipmentCreatorBicykle extends Bicykle {

	public SportEquipmentCreatorBicykle(String brand, NonHabitableRoom location){
		new Bicykle(brand, location);
	}


}