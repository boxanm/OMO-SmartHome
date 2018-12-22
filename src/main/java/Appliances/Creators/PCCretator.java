package Appliances.Creators;


import Appliances.PC;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class PCCretator extends ApplianceCreator {

	public PC m_PC;

	public PCCretator(String name, HabitableRoom location){
		new PC(name, location);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}