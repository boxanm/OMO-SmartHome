package House;

import SportsEquipment.SportEquipmentCreatorBicykle;
import SportsEquipment.SportEquipment;

import java.util.List;

/**
 * Obsahuje Car a SportEquipment
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class NonHabitableRoom extends Room {


	private boolean isFire;
	private int number_of_windows;

	private Car car;
	private SportEquipmentCreatorBicykle sportEquipmentCreator;
	private List<SportEquipment> sportEquipmentList;

	public NonHabitableRoom(String name, House house, Floor floor, int number_of_windows){
		super(name, house, floor, number_of_windows);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void addSportEquipment(SportEquipment sportEquipment){

		sportEquipmentList.add(sportEquipment);
	}
	public void deleteSportEquipment(SportEquipment sportEquipment){
		sportEquipmentList.remove(sportEquipment);
	}
	public void addCar(Car car){
		this.car = car;
	}
	public void deleteCar(Car car){
		this.car = null;
	}

	public Car getCar() {
		return car;
	}

	public List<SportEquipment> getSportEquipmentList() {
		return sportEquipmentList;
	}
}