package Senzors;

import EventsAlerts.*;
import House.House;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class CircuitBreakers implements Sensor, AlertGenerator {

	private boolean tripped;
	private EventReporter eventReporter;
	private final static double maxElectricalCapacity = 50;

	public CircuitBreakers(House house){
		house.setCircuitBreakers(this);
		eventReporter = house.getEventReporter();
	}

	public void replace(){
		tripped = false;
	}

	public boolean isTriped(){
		return tripped;
	}

	@Override
	public void update(Observable observable) {
		if(observable instanceof ElectricitySensor
				&& ((ElectricitySensor) observable).getLapElectricityConsumption() > maxElectricalCapacity){
			tripped = true;
			newAlert(new Alert(AlertType.circuitBreakers,this,null,null,null));
		}
	}

	@Override
	public void newAlert(Alert alert) {
		eventReporter.updateFromAlertGenerator(alert);
	}
	
	

}