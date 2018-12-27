package Appliances.Manual;


import Appliances.Appliance;

/**
 * Lazy loading
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class Manual {

	private Manual manual = null;
	private String descripton;

	public Manual(){
		descripton = "Manual Manual Manual";
	}

	public Manual getManual() {
		if(manual == null){
			manual = new Manual();
		}
		return manual;
	}

}