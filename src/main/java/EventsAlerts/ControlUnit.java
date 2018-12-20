package EventsAlerts;


import java.util.ArrayList;

/**
 * Obsluhuje v�echny alerty a rozhoduje, kter� z AlertHandler� je m� vy�e�it.
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