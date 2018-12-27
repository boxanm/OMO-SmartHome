package Senzors;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import EventsAlerts.Consumption;
import EventsAlerts.EventReporter;
import EventsAlerts.Observable;
import House.House;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class ElectricitySensor implements Sensor, Meter {
	private EventReporter eventReporter;

	public ElectricitySensor(House house){
		eventReporter = house.getEventReporter();
		for (Appliance appliance: house.getAppliances()
			 ) {
			if(appliance.getConsumptionType() == ConsumptionType.electricity)
				appliance.attach(this);

		}
	}


	public void update(Observable observable){
		if(observable instanceof Appliance){
			newConsumption(new Consumption(ConsumptionType.electricity,((Appliance) observable).getConsumption(),
					(Appliance) observable,((Appliance) observable).getActualFloor(),
					((Appliance) observable).getActualRoom(),this));
		}
	}

	@Override
	public void newConsumption(Consumption consumption) {
		eventReporter.updateFromMeter(consumption);
	}

	@Override
	public String toString() {
		return "Electricity sensor";
	}
}