package Appliances.Creators;


import Appliances.Xbox;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:43
 */
public class XboxCreator extends Xbox {

	public Xbox m_Xbox;

	public XboxCreator(String name, HabitableRoom location){
		new Xbox(name, location);

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}