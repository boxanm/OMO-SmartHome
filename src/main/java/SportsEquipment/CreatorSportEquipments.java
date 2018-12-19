package SportsEquipment;


import House.NonHabitableRoom;
import org.jetbrains.annotations.NotNull;

/**
 * Návrhový vzor factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public abstract class CreatorSportEquipments {

	public static SportEquipment createEquipment(String criteria, String brand, NonHabitableRoom location) {
		if (criteria.equals("ski")) {
			return new SportEquipmentCreatorSki(brand, location);
		} else if (criteria.equals("bicykle")) {
			return new SportEquipmentCreatorBicykle(brand, location);
		}
		return null;

	}
}