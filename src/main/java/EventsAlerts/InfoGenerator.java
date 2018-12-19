package EventsAlerts;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface InfoGenerator {

	void newInfo(Info info);

	EventReporter eventReporter = null;
}