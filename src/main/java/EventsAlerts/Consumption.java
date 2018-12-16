package EventsAlerts;


import Appliances.ConsuptionType;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class Consumption extends Event {

	private int consuption;

	public Consumption(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba){
		return 0;
	}

}