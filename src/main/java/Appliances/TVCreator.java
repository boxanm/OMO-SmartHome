package Appliances;


import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TVCreator extends TV {

	public TV m_TV;

	public TVCreator(String name, HabitableRoom location){
		new TV(name, location);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}