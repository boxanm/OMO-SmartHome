package EventsAlerts;


/**
 * C�l alertu, c�lem m��e b�t dosp�l�, spot�ebi� a Sensor
 * @author Michal Kore�, Mat�j Boxan Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface AlertHandler {
	boolean handleAlert(Alert alert);//returns true if alert handler handles alert

	void addHandlerToControlUnit(ControlUnit controlUnit);

}