package Appliances;


import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FridgeCreator extends Fridge {

	public Fridge m_Fridge;

	public FridgeCreator(String name, HabitableRoom location){

		new Fridge(name, location);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}