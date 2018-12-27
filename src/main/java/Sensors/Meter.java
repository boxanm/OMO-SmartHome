package Sensors;


import EventsAlerts.Consumption;

/**
 * Rozhran� obsahuj�c� spole�n� vlastnosti a metody pro v�echny m���c� senzory.
 * M��e informat EventReporter s �daji o zm�n� spot�eby.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public interface Meter {

	void newConsumption(Consumption consumption);


}