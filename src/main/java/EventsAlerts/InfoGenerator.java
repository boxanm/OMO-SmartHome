package EventsAlerts;


/**
 * @author Michal Kore�, Mat�j Boxan Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface InfoGenerator {

	void newInfo(Info info);

	EventReporter eventReporter = null;
}