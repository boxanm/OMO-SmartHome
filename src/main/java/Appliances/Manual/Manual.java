package Appliances.Manual;


/**
 * Lazy loading
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class Manual {

	private static Manual manual;
	private String descripton;

	private Manual(){
		descripton = "Manual Manual Manual";
	}

	public static Manual getManual() {
		if(manual == null){
			manual = new Manual();
		}
		return manual;
	}

}