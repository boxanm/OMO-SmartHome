package EventsAlerts;


import java.util.ArrayList;

/**
 * Obsluhuje v�echny alerty a rozhoduje, kter� z AlertHandler� je m� vy�e�it.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class ControlUnit implements AlertGenerator{

	private ArrayList<AlertHandler> listOfAlertHandlers;
	private ArrayList<Alert> alerts;

	public ControlUnit(){
		listOfAlertHandlers = new ArrayList<>();
		alerts = new ArrayList<>();

	}


	public void handleAlerts(){
		for (AlertHandler alertHandler: listOfAlertHandlers) {
//			alertHandler.handleAlert(alert.getAlertType());

		}

	}

	@Override
	public void newAlert() {

	}
}