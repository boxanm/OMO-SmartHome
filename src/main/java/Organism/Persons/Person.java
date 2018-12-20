package Organism.Persons;

import House.Room;
import Appliances.Appliance;
import SportsEquipment.SportEquipment;
import Organism.Organism;
import EventsAlerts.AlertHandler;

/**
 * Rozhraní definující spoleèné vlastnosti a metody rodièù a dìtí.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public interface Person {


	public int applianceUsageNumber = 0;
	public int sportequipmentUsage = 0;
	int foodConsumption = 0;

	/**
	 * 
	 * @param room
	 */
	public void callFireman(Room room);

	public void nextAction();

	/**
	 * 
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance);

	/**
	 * 
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment);

	public void hangOn();

}