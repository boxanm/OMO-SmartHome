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
		if(isPulled == true){
			isPulled = false;
		} else{
			isPulled = true;
		}
	}



	/**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}

}