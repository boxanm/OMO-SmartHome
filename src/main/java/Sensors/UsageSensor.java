package Sensors;

import Appliances.Appliance;
import Appliances.ConsumptionType;
import EventsAlerts.*;
import House.House;

/**
 * V pøípadì rozbití spotøebièe generuje alert, jinak pouze informuje o stavu
 * použití.
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class UsageSensor implements Sensor, AlertGenerator, Meter {
	private EventReporter eventReporter;

	/**
	 * one UsageSensor serves all appliances in the house
	 * @param house all appliances located in house are attached to this sensor
	 */
	public UsageSensor(House house){
		eventReporter = house.getEventReporter();
		for (Appliance appliance: house.getAppliances()) {
			appliance.attach(this);

		}
	}

	/**
	 * Either creates new Alert about damaged Appliance,
	 * or informs about it's usage state
	 * @param observable Appliance informing about it's usage state
	 */
	public void update(Observable observable){
		if(observable instanceof Appliance){
			if(((Appliance) observable).isBroken())
				newAlert(new Alert(AlertType.broken,(Appliance) observable,((Appliance) observable).getActualFloor(),((Appliance) observable).getActualRoom(),null));
			else
				newConsumption(new Consumption(ConsumptionType.usage,((Appliance) observable).getWearOfDevice(),
						this,((Appliance) observable).getActualFloor(),((Appliance) observable).getActualRoom(),this));
		}
	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromAlertGenerator(alert);

	}

	@Override
	public void newConsumption(Consumption consumption) {
		eventReporter.updateFromMeter(consumption);

	}
}