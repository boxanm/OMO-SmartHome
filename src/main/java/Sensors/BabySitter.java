package Sensors;

import EventsAlerts.*;
import House.House;
import Organism.Persons.Child;

import java.util.stream.Collectors;

/**
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class BabySitter implements Sensor, AlertGenerator {
	EventReporter eventReporter;

	/**
	 * Creates new babySitter
	 * One babysitter serves all children located in house
	 * @param house House with location of observed children
	 */
	public BabySitter(House house){
		eventReporter = house.getEventReporter();
		for (Child child: house.getPersonList().stream()
				.filter(Child.class::isInstance)
				.map(Child.class::cast)
				.collect(Collectors.toList())
		) {
			child.attach(this);
		}

	}

	/**
	 * creates new Alert about child state
	 * @param observable child which state has changed
	 */
	public void update(Observable observable){
	    if(observable instanceof Child && ((Child) observable).isSad())
	        newAlert(new Alert(AlertType.babyCrying,this, null, null, null));
	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromAlertGenerator(alert);
	}
	@Override
	public String toString() {
		return "Babysitter";
	}
}