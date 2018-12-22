package Appliances.Creators;


import Appliances.HifiTower;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class HiFiTowerCreator extends ApplianceCreator {

	public HifiTower m_HifiTower;

	public HiFiTowerCreator(String name, HabitableRoom location){
		new HifiTower(name, location);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}