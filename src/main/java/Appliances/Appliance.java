package Appliances;

import Appliances.ApplianceState.ApplianceState;
import House.Floor;
import House.Room;
import EventsAlerts.AlertHandler;
import EventsAlerts.ConsuptionGenerator;
import EventsAlerts.Observed;
import House.HabitableRoom;

/**
 * Rozhraní definicí spoleèné vlastnosti a metody všech spotøebièù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public interface Appliance extends AlertHandler, ConsuptionGenerator, Observed {

	public int consuptionIddle = 0;
	public int consuptionOFF = 0;
	public int consuptionON = 0;
	public ApplianceState applianceState = null;

	public Floor actualFloor = null;
	public Room actualRoom = null;
	public ConsuptionType consumptionType = null;
	public boolean isBroken = false;
	public boolean isBusy = false;
	public HabitableRoom m_HabitableRoom = null;

	public void breakeDown();

	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba);

	public void setOnFire();

	public void turnIddle();

	public void turnOFF();

	public void turnON();

}