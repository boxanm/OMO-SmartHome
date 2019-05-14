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
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:17
 */
public class ElectricitySensor implements Sensor, Meter, Observable, LapSubscriber {
	private EventReporter eventReporter;
	private double lapElectricityConsumption;
	private List<Observer> observers;

	/**
	 * one electricitySensor serves all appliances in the house
	 * it announces changes of lapElectricityConsumption, total electricity consumption in actual lap
	 * @param house all appliances located in house are attached to this sensor
	 */
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

	/**
	 * announces changes of lapElectricityConcumption to observers
	 * and creates new Consumption Event about Consumption changes
	 * @param observable
	 */
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