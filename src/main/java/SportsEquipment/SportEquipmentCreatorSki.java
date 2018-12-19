package SportsEquipment;

import House.NonHabitableRoom;
import SportsEquipment.CreatorSportEquipments;
import SportsEquipment.Ski;

/**
 * Návrhový vzor factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class SportEquipmentCreatorSki extends Ski {

	public SportEquipmentCreatorSki(String brand, NonHabitableRoom location) {
		new Ski(brand, location);
	}
}