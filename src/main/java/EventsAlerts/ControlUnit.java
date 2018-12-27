package EventsAlerts;


import LapsTime.LapSubscriber;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Obsluhuje všechny alerty a rozhoduje, který z AlertHandlerù je má vyøešit.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class ControlUnit implements EventTarget, LapSubscriber {

	private ArrayList<AlertHandler> listOfAlertHandlers;
	private Queue<Alert> alerts;

	public ControlUnit(){
		listOfAlertHandlers = new ArrayList<>();
		alerts = new PriorityQueue<>();
	}

	public void handleAlert(Alert alert){
		if(! alerts.contains(alert))
			alerts.add(alert);
	}

	public void addAlertHandler(AlertHandler alertHandler){
		if(! listOfAlertHandlers.contains(alertHandler))
			listOfAlertHandlers.add(alertHandler);
	}


	@Override
	public void newLap() {
		boolean freeAlertHandlers = true;
		Alert alert = alerts.peek();
		while(freeAlertHandlers && alert != null){
			for (AlertHandler alertHandler:listOfAlertHandlers
			) {
				freeAlertHandlers = alertHandler.handleAlert(alert);
			}
			alerts.remove();
			alert = alerts.peek();
		}
	}
	@Override
	public String toString() {
		return "ControlUnit";
	}

}