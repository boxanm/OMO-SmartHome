package House;


import Appliances.Appliance;
import Senzors.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * Obsahuje spotøebièe
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class HabitableRoom extends Room {

	private ArrayList<Appliance> applianceList;
	private List<Sensor> sensorList;

	public HabitableRoom(String name, House house, Floor floor, int number_of_windows){
		super(name, house, floor, number_of_windows);
		applianceList = new ArrayList<>();
		sensorList = new ArrayList<>();
	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public void addAppliance (Appliance appliance){
		if(! applianceList.contains(appliance))
			applianceList.add(appliance);
	}
	public void deleteAppliance(Appliance appliance){
		applianceList.remove(appliance);
	}
	public void addSenzor(Sensor sensor){
		if(! sensorList.contains(sensor))
			sensorList.add(sensor);
	}
	public void removeSenzor(Sensor sensor){
		sensorList.remove(sensor);
	}

	public ArrayList<Appliance> getApplianceList(){
		return applianceList;
	}
}
