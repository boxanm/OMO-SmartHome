package EventsAlerts;


/**
 * Observer je dvou typ�:
 * 
 * <ul>
 * 	<li>Sensor - po��t� a reaguje na ud�losti</li>
 * 	<li>ObserverEverything - zaznamen�v� ve�ker� eventy</li>
 * </ul>
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface Observer {

	public void update();

}