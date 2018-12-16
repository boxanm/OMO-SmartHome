package EventsAlerts;

import Senzors.Meter;

import java.util.List;

/**
 * Loguje veškeré eventy, které mohou mít nìkolik zdrojù:
 * <ul>
 * 	<li>ObserverEverything</li>
 * 	<li>Meter</li>
 * 	<li>ControlUnit</li>
 * </ul>
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class EventReporter {

	private List AllEvents;
	private int numberOflap;
	public Event m_Event;
	public ObserverEverything m_ObserverEverything;
	public ControlUnit m_ControlUnit;
	public Meter m_Meter;

	public EventReporter(){

	}

	public void finalize() throws Throwable {

	}

	public void newLap(){

	}

	/**
	 * 
	 * @param eventID
	 * @param target
	 */
	public void updateFromControlUnit(int eventID, AlertHandler target){

	}

	/**
	 * 
	 * @param eventID
	 * @param meter
	 */
	public void updateFromMeter(int eventID, Meter meter){

	}

	/**
	 * 
	 * @param eventID
	 * @param source
	 */
	public void updateFromObserver(int eventID, Observed source){

	}

}