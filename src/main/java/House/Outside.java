package House;

import EventsAlerts.Info;
import EventsAlerts.Observed;
import EventsAlerts.Observer;

/**
 * Tøída pøedstavující exteriér.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Outside implements Observed {

	private boolean isWind;

	public Outside(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){

	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){

	}

	public void announce(){

	}

	public Info newInfo(){

		return null;
	}

}