package EventsAlerts;


/**
 * C�l alertu, c�lem m��e b�t dosp�l�, spot�ebi� a senzor
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface AlertHandler {

	public AlertHandler listOfAlertHandlers = null;

	/**
	 * 
	 * @param alertType
	 */
	public void handleAlert(AlertType alertType);

}