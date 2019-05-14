package SportsEquipment;

import House.NonHabitableRoom;
import SportsEquipment.CreatorSportEquipments;
import SportsEquipment.Ski;

/**
 * Pattern factory method, concrete Ski factory
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class SportEquipmentCreatorSki extends CreatorSportEquipments {


	public SportEquipmentCreatorSki(NonHabitableRoom location){
		super(location);
	}

	@Override
	public Ski createEquipment(String brand) {
		return new Ski(brand,location);
	}

	public Ski createAtomic(){
		return createEquipment("Atomic");
	}

	public Ski createHead() {
		return createEquipment("Head");
	}
}