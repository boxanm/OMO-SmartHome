package EventsAlerts;

import LapsTime.LapSubscriber;
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
public class EventReporter implements LapSubscriber {

	private ArrayList<Event> allEvents = new ArrayList<Event>();
	private int lapNumber;
	private ControlUnit controlUnit;

	public EventReporter(){
		controlUnit = new ControlUnit();
	}

	public ControlUnit getControlUnit() {
		return controlUnit;
	}

	public void newLap(){
	    lapNumber++;

	}


	public void newEvent(Event event){
	    event.setLapNumber(lapNumber);
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
		alert.setTarget(controlUnit);
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

	public ArrayList<Event> getAllEvents() {
		return allEvents;
	}

	@Override
	public String toString() {
		return "EventReporter";
	}
}