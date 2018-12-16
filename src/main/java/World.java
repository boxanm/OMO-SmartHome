import Reports.HouseReportLayout;
import House.House;

/**
 * Pouit návrhovı vzor singleton. Tøída zajišující jednotlivé tahy a vykonání
 * akcí bìhem nich
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:43
 */
public class World {

	private House house;
	private HouseReportLayout report;
	private int time;
	public House m_House;

	public World(){

	}

	public void finalize() throws Throwable {

	}

	public World getInstance(){
		return null;
	}

	public void newLap(){

	}

}