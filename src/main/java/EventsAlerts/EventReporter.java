package EventsAlerts;

import House.House;
import LapsTime.LapSubscriber;

import java.util.ArrayList;

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

	public EventReporter(House house){
	    this.controlUnit = house.getControlUnit();
	}

    public ControlUnit getControlUnit() {
		return controlUnit;
	}

	public void newLap(){
	    lapNumber++;
	}


	private void newEvent(Event event){
	    event.setLapNumber(lapNumber);
//	    System.out.println(event.toString());
		allEvents.add(event);
	}


	public void updateEvent(Event event){
		if(allEvents.contains(event))
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
		newEvent(consumption);
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

	public void newInfo(Info info){
		newEvent(info);
	}

	public ArrayList<Event> getAllEvents() {
		return allEvents;
	}

	@Override
	public String toString() {
		return "EventReporter";
	}
}