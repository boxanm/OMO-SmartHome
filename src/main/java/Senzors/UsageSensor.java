package Senzors;

import EventsAlerts.AlertGenerator;
import EventsAlerts.Event;

/**
 * V p��pad� rozbit� spot�ebi�e generuje alert, jinak pouze informuje o stavu
 * pou�it�.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class UsageSensor implements Senzor, AlertGenerator, Meter {

	public UsageSensor(){

	}

	public void finalize() throws Throwable {

	}

	public void update(){

	}

	public Event newEvent(){
		return null;
	}

	/**
	 * 
	 * @param eventID
	 */
	public void informObserverReport(int eventID){

	}

}