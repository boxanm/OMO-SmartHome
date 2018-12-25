package Appliances.Manual;


import Appliances.Appliance;

/**
 * Lazy loading
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class Manual implements IManual {

	public Manual(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public Manual getManual(Appliance appliance) {
		return null;
	}

}