package Sensors;

import EventsAlerts.EventSource;
import EventsAlerts.Observer;
import EventsAlerts.EventTarget;

/**
 * Rozhraní definující spoleèné vlastnosti a metody senzorù.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public interface Sensor extends Observer, EventTarget, EventSource {

}