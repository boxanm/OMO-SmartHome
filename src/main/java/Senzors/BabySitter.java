package Senzors;

import EventsAlerts.*;
import House.House;
import House.Room;
import Organism.Persons.Child;
import Organism.Persons.Person;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class BabySitter implements Sensor, AlertGenerator {
	EventReporter eventReporter;

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

	public void update(Observable observable){


	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromObserver(new Alert(AlertType.babyCrying,this, null, null, null));
	}
	@Override
	public String toString() {
		return "Babysitter";
	}
}