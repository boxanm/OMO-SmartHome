package EventsAlerts;


/**
 * Cíl alertu, cílem mùže být dospìlí, spotøebiè a senzor
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface AlertHandler {
	/**
	 * 
	 * @param alert
	 */
	public boolean handleAlert(Alert alert);//returns true if alert handler handles alert

	public void addHandlerToControlUnit(ControlUnit controlUnit);

}