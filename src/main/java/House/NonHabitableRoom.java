package House;

import SportsEquipment.SportEquipmentCreatorBicycle;
import SportsEquipment.SportEquipment;

import java.util.ArrayList;

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
	private SportEquipmentCreatorBicycle sportEquipmentCreator;
	private ArrayList<SportEquipment> sportEquipmentList;

	public NonHabitableRoom(String name, Floor floor, int number_of_windows){
		super(name, floor, number_of_windows);
		sportEquipmentList = new ArrayList<>();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Add sports equipment in the room
	 * @param sportEquipment
	 */
	public void addSportEquipment(SportEquipment sportEquipment){
		if(! sportEquipmentList.contains(sportEquipment))
			sportEquipmentList.add(sportEquipment);
	}

	/**
	 * Remove sports equipment in the room
	 * @param sportEquipment
	 */
	public void deleteSportEquipment(SportEquipment sportEquipment){
		sportEquipmentList.remove(sportEquipment);
	}

	/**
	 * Add car in the room
	 * @param car
	 */
	public void addCar(Car car){
		this.car = car;
	}

	/**
	 * Remove car in the room
	 * @param car
	 */
	public void deleteCar(Car car){
		this.car = null;
	}

	public Car getCar() {
		return car;
	}

	public ArrayList<SportEquipment> getSportEquipmentList() {
		return sportEquipmentList;
	}
}