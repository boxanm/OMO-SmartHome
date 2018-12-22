package Appliances.Creators;


import Appliances.Freezer;
import House.HabitableRoom;
import Organism.Animals.Animal;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FreezerCreator extends ApplianceCreator {

	public Freezer m_Freezer;

	public FreezerCreator(String name, HabitableRoom location){

		new Freezer(name, location);

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}