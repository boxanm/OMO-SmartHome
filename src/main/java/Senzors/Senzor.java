package Senzors;

import House.Room;
import EventsAlerts.Observer;
import EventsAlerts.Target;
import EventsAlerts.Observed;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody senzor�.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public interface Senzor extends Observer, Target {

	public Room m_Room = null;

}