package Appliances.Creators;


import Appliances.Appliance;
import House.HabitableRoom;

/**
 * Factory method
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class ApplianceCreator {

	public ApplianceCreator(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 *
	 * @param type
	 */
	public static ApplianceCreator createAppliance(String type, String name, HabitableRoom location){
		if(type.equals("waching machine")){
		    return new WashingMachineCreator(name, location);
        } else if(type.equals("tv")){
		    return new TVCreator(name, location);
        } else if(type.equals("xbox")){
		    return new XboxCreator(name, location);
        } else if(type.equals("playstation")){
		    return new PlayStationCreator(name, location);
        } else if (type.equals("hifi")){
		    return new HiFiTowerCreator(name, location);
        } else if (type.equals("pc")){
		    return new PCCretator(name, location);
        } else if (type.equals("freezer")){
		    return new FreezerCreator(name, location);
        } else if (type.equals("fridge")){
		    return new FridgeCreator(name, location);
        }

        return null;
	}

}