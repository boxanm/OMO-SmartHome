package House;

import EventsAlerts.EventReporter;
import Reports.HouseReportLayout;

/**
 * Základní entita. V rámci domu se mohou pohybovat zvíøata i lidé.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class House {

	private EventReporter eventReporter;
	private static Floor floorsArray;
	private static House instance;
	public Floor m_Floor;
	public HouseReportLayout m_HouseReportLayout;
	public EventReporter m_EventReporter;

	public House(){

	}

	public void finalize() throws Throwable {

	}

}