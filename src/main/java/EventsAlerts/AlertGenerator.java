package EventsAlerts;


/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody v�ech entit, kter� generuj�
 * alerty. Alerty d�le obsluhuje ControlUnit.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface AlertGenerator {

	public Alert m_Alert = null;
	public ControlUnit m_ControlUnit = null;

	public void newAlert();

}