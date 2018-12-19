package EventsAlerts;


/**
 * Zaznamenává veškeré eventy a informuje tøídu EventReporter.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public class ObserverEverything implements Observer {
	private EventReporter eventReporter;

	public ObserverEverything(EventReporter eventReporter){
		this.eventReporter = eventReporter;
	}

	public void update(){

	}

}