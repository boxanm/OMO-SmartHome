package Reports;


import EventsAlerts.EventReporter;
import House.House;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class EventReport extends HouseReport {

	public EventReport(){

	}

	@Override
	public void generateReport(House house){
		EventReporter eventReporter = house.getEventReporter();
		

	}
}