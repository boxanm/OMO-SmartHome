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
public interface Observable extends EventTarget {

	void attach(Observer observer);

	void detach(Observer observer);

	void announce();

}