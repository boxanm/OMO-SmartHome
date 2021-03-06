package SportsEquipment;


import House.NonHabitableRoom;

/**
 * Pattern factory method, concrete Bike factory
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:22
 */
public class SportEquipmentCreatorBicycle extends CreatorSportEquipments {

	public SportEquipmentCreatorBicycle(NonHabitableRoom location){
		super(location);
	}

	@Override
	public Bicycle createEquipment(String brand) {
		return new Bicycle(brand,location);
	}

	public Bicycle createMerida(){
		return createEquipment("Merida");
	}

	public Bicycle createApache() {
		return createEquipment("Apache");
	}

}