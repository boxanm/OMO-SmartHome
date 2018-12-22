package EventsAlerts;


/**
 * Rozhraní pro všechny entity generující event. Event mùže být:
 * 
 * <ul>
 * 	<li>zmìna stavu spotøebièe</li>
 * 	<li>jakákoliv akce èlovìka nebo zvíøete</li>
 * 	<li>zmìna poèasí venku</li>
 * </ul>
 * 
 * Na rozhraní je napojený Observer dle návrhového vzoru Observer
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface Observable extends InfoGenerator, EventTarget {

	Observer observersList = null;

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer);

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer);


	public void announce();

}