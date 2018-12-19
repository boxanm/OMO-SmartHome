package Appliances.Creators;


import Appliances.PlayStation;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PlayStationCreator extends PlayStation {

	public PlayStation m_PlayStation;

	public PlayStationCreator(String name, HabitableRoom location){
		new PlayStation(name, location);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}