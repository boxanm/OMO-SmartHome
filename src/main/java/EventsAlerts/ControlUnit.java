package EventsAlerts;


import java.util.ArrayList;

/**
 * Obsluhuje všechny alerty a rozhoduje, který z AlertHandlerù je má vyøešit.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class ControlUnit {

	private ArrayList<AlertHandler> listOfAlertHandlers;
	public AlertHandler m_AlertHandler;

	public ControlUnit(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(Alert alert){
		for (AlertHandler alertHandler: listOfAlertHandlers) {
			alertHandler.handleAlert(alert.getAlertType());

		}

	}

}