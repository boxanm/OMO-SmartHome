package EventsAlerts;


import java.util.ArrayList;

/**
 * Obsluhuje v�echny alerty a rozhoduje, kter� z AlertHandler� je m� vy�e�it.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class ControlUnit{

	private ArrayList<AlertHandler> listOfAlertHandlers;
	private ArrayList<Alert> alerts;

	public ControlUnit(){
		listOfAlertHandlers = new ArrayList<>();
		alerts = new ArrayList<>();
	}

	public void handleAlert(Alert alert){
		for (AlertHandler alertHandler: listOfAlertHandlers){
			alertHandler.handleAlert(alert);
		}
	}

	public void addAlertHandler(AlertHandler alertHandler){
		if(! listOfAlertHandlers.contains(alertHandler))
			listOfAlertHandlers.add(alertHandler);
	}


}