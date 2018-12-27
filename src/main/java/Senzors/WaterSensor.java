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
public class WaterSensor implements Sensor, Meter {
	private EventReporter eventReporter;

	public WaterSensor(House house){
		eventReporter = house.getEventReporter();
		for (Appliance appliance: house.getAppliances()
		) {
			if(appliance.getConsumptionType() == ConsumptionType.water)
				appliance.attach(this);

		}
	}



	public void update(Observable observable){
		if(observable instanceof Appliance){
			newConsumption(new Consumption(ConsumptionType.water,((Appliance) observable).getConsumption(),
					(Appliance) observable,((Appliance) observable).getActualFloor(),
					((Appliance) observable).getActualRoom(),this));
		}
	}

	@Override
	public void newConsumption(Consumption consumption) {
		eventReporter.updateFromMeter(consumption);
	}
}