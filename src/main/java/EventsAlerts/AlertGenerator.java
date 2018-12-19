package EventsAlerts;


/**
 * Rozhraní definující spoleèné vlastnosti a metody všech entit, které generují
 * alerty. Alerty dále obsluhuje ControlUnit.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface AlertGenerator {

	public Alert m_Alert = null;
	public ControlUnit m_ControlUnit = null;

	public void newAlert();

}