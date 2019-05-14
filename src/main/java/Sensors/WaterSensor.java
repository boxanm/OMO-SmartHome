package Sensors;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import EventsAlerts.Consumption;
import EventsAlerts.EventReporter;
import EventsAlerts.Observable;
import House.House;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class WaterSensor implements Sensor, Meter {
	private EventReporter eventReporter;

	/**
	 * one WaterSensor serves all water appliances in the house
	 * @param house all appliances located in house are attached to this sensor
	 */
	public WaterSensor(House house){
		eventReporter = house.getEventReporter();
		for (Appliance appliance: house.getAppliances()
		) {
			if(appliance.getConsumptionType() == ConsumptionType.water)
				appliance.attach(this);

		}
	}


	/**
	 * creates new Consumption event about water consumption changes
	 * @param observable
	 */
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