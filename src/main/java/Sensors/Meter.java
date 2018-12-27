package Sensors;


import EventsAlerts.Consumption;

/**
 * Rozhraní obsahující spoleèné vlastnosti a metody pro všechny mìøící senzory.
 * Mùže informat EventReporter s údaji o zmìnì spotøeby.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public interface Meter {

	void newConsumption(Consumption consumption);


}