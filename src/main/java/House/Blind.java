package House;

import EventsAlerts.AlertHandler;
import EventsAlerts.AlertType;

/**
 * Žaluzie se zatahují pøi vìtru
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:41
 */
public class Blind implements AlertHandler {

	private boolean isPulled;

	public Blind(){

	}

	public void pull(){
		isPulled = !isPulled;
	}



	@Override
	public void handleAlert(AlertType alertType) {
		if(alertType == AlertType.wind && !isPulled)
			pull();

	}

	@Override
	public String toString() {
		if(isPulled)
			return "Blind is pulled";
		else
			return "Blind is not pulled";
	}
}