package House;

import EventsAlerts.*;
import Reports.EventReport;

/**
 * Žaluzie se zatahují pøi vìtru
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:41
 */
public class Blind implements AlertHandler, InfoGenerator, EventSource, EventTarget {

	private EventReporter eventReporter;
	private boolean isPulled = false;
	private Window window;

	public Blind(Window window){
		this.window = window;
		eventReporter = window.getRoom().getFloor().getHouse().getEventReporter();
		addHandlerToControlUnit(window.getRoom().getFloor().getHouse().getControlUnit());
	}

	/**
	 * Pulling blinds when wind
	 */
	public void pull(){
		newInfo(new Info(InfoType.pullingBlind,this,window.getRoom().getFloor(),window.getRoom(),this));
		isPulled = !isPulled;
	}

	public boolean isPulled(){
		return isPulled;
	}

	@Override
	public boolean handleAlert(Alert alert) {
		if(alert.getAlertType() == AlertType.wind && !isPulled){
			pull();
			return true;
		}
		return false;
	}

	@Override
	public void addHandlerToControlUnit(ControlUnit controlUnit) {
		controlUnit.addAlertHandler(this);
	}

	@Override
	public String toString() {
		return "Blind";
	}

	@Override
	public void newInfo(Info info) {
		eventReporter.newInfo(info);
	}
}