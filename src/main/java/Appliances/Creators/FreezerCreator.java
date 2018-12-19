package Appliances.Creators;


import Appliances.Freezer;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FreezerCreator extends Freezer {

	public Freezer m_Freezer;

	public FreezerCreator(String name, HabitableRoom location){

		new Freezer(name, location);

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}