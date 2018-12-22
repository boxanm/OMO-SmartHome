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
	public ObserverEverything m_ObserverEverything;
	private ControlUnit controlUnit;
	public Meter m_Meter;

	public EventReporter(){

	}

	public void newLap(){

	}


	public void newEvent(Event event){
		allEvents.add(event);
	}


	public void updateEvent(Event event){
		allEvents.set(allEvents.indexOf(event),event);
	}
	/**
	 *
	 * @param alert
	 */
	public void updateFromAlertGenerator(Alert alert){
		controlUnit.handleAlert(alert);
		if(! allEvents.contains(alert))
			newEvent(alert);
		else
			updateEvent(alert);
	}

	/**
	 *
	 * @param consumption
	 */
	public void updateFromMeter(Consumption consumption){

	}

	/**
	 *
	 * @param event
	 */
	public void updateFromObserver(Event event){
		newEvent(event);

	}
	/**
	 *
	 * @param event
	 */
	public void updateFromOrganism(Event event){
		newEvent(event);
	}

}