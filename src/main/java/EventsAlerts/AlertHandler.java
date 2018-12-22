package EventsAlerts;


/**
 * Cíl alertu, cílem mùže být dospìlí, spotøebiè a senzor
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