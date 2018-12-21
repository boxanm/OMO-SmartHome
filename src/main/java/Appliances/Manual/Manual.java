package Appliances.Manual;


/**
 * Lazy loading
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class Manual extends VirtualManual {

	public Manual(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}