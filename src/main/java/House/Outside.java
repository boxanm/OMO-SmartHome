package House;

import EventsAlerts.Info;
import EventsAlerts.Observable;
import EventsAlerts.Observer;
import LapsTime.LapSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The class representing the exterior.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Outside implements Observable, LapSubscriber {
	private List<Observer> observerList;

	private boolean isWind;

	private int temperature = 20;

	public Outside(){
		observerList = new ArrayList<>();
	}

	public void newLap(){
		isWind = new Random().nextInt(100)<30;
		announce();
	}


	public boolean getIsWind(){
		return isWind;
	}
	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){
		if(! observerList.contains(observer))
			observerList.add(observer);
	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){
		observerList.remove(observer);
	}

	public void announce(){
		for (Observer observer: observerList) {
			observer.update(this);
		}
	}

	public Info newInfo(){

		return null;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
}