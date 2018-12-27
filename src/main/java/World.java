import LapsTime.LapSubscriber;
import Reports.HouseReportLayout;
import House.House;
import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * Pouit návrhovı vzor singleton. Tøída zajišující jednotlivé tahy a vykonání
 * akcí bìhem nich
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:43
 */
public class World implements LapSubscriber {

	private List<House> houseList;
	private int time;

	private static World instance;

	private World(){
		houseList = new ArrayList<House>();
		time = 0;
	}


	public static World getInstance(){
		if(instance == null)
			instance = new World();
		return instance;

	}

	public void addHouse(House house){
		if(! houseList.contains(house))
			houseList.add(house);
	}

	public void removeHouse(House house){
		houseList.remove(house);
	}

	public void newLap(){
		for (House house:houseList
			 ) {
			house.newLap();
		}
	}
}