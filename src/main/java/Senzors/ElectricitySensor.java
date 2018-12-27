package Senzors;


import Appliances.Appliance;
import EventsAlerts.Consumption;
import EventsAlerts.EventReporter;
import House.House;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class ElectricitySensor implements Sensor, Meter {
	private EventReporter eventReporter;
	private Appliance appliance;


	public ElectricitySensor(House house, Appliance appliance){
		eventReporter = house.getEventReporter();
		this.appliance = appliance;
		appliance.attach(this);
	}


	public void update(){
		newConsumption(new Consumption(appliance.getConsumptionType(),appliance.getConsumption(),appliance,appliance.getActualFloor(),appliance.getActualRoom(),this));
	}

	@Override
	public void newConsumption(Consumption consumption) {
		consumption.toString();
		eventReporter.updateFromObserver(consumption);

	}
}