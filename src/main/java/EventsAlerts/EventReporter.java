package EventsAlerts;

import Senzors.Meter;

import java.util.ArrayList;
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

	private ArrayList<Event> allEvents = new ArrayList<Event>();
	private int lapNumber;
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
	 * @param target
	 */
	public void updateFromControlUnit(AlertHandler target){

	}

	/**
	 *
	 * @param meter
	 */
	public void updateFromMeter(Meter meter){

	}

	/**
	 *
	 * @param source
	 */
	public void updateFromObserver(Observed source){

	}

}