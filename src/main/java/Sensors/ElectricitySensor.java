package Sensors;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import EventsAlerts.Consumption;
import EventsAlerts.EventReporter;
import EventsAlerts.Observable;
import EventsAlerts.Observer;
import House.House;
import LapsTime.LapSubscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class ElectricitySensor implements Sensor, Meter, Observable, LapSubscriber {
	private EventReporter eventReporter;
	private double lapElectricityConsumption;
	List<Observer> observers;
	public ElectricitySensor(House house){
		observers = new ArrayList<>();
		eventReporter = house.getEventReporter();
		house.setElectricitySensor(this);
		if(house.getCircuitBreakers() != null)
		    attach(house.getCircuitBreakers());
		for (Appliance appliance: house.getAppliances()) {
			if(appliance.getConsumptionType() == ConsumptionType.electricity)
				appliance.attach(this);

		}
	}


	public void update(Observable observable){
		if(observable instanceof Appliance){
			newConsumption(new Consumption(ConsumptionType.electricity,((Appliance) observable).getConsumption(),
					(Appliance) observable,((Appliance) observable).getActualFloor(),
					((Appliance) observable).getActualRoom(),this));

			lapElectricityConsumption += ((Appliance) observable).getConsumption();
			announce();
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

	@Override
	public void attach(Observer observer) {
		if(!observers.contains(observer))
			observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void announce() {
		for (Observer observer:observers) {
			observer.update(this);

		}
	}

	public double getLapElectricityConsumption() {
		return lapElectricityConsumption;
	}

	@Override
	public void newLap() {
		lapElectricityConsumption = 0;
	}
}