package House;

import SportsEquipment.SportEquipmentCreatorBicykle;
import SportsEquipment.SportEquipment;

/**
 * Obsahuje Car a SportEquipment
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class NonHabitableRoom extends Room {

	private Car car;
	private SportEquipmentCreatorBicykle sportEquipmentCreator;
	private SportEquipment sportEquipmentList;
	public Car m_Car;

	public NonHabitableRoom(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}