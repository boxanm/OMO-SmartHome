package EventsAlerts;


/**
 * Observer je dvou typù:
 * 
 * <ul>
 * 	<li>Sensor - poèítá a reaguje na události</li>
 * 	<li>ObserverEverything - zaznamenává veškeré eventy</li>
 * </ul>
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface Observer {

	public void update();

}