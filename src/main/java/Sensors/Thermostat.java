package Sensors;

import Sensors.Strategy.*;
import EventsAlerts.*;
import House.House;
import House.Outside;

/**
 * t��da implementuj�c� vzor strategy a observer.
 * Sleduje venkovn� teplotu a p�i jej� zm�n� m�n� strategii vyt�p�n� domu
 */
public class Thermostat implements Sensor, InfoGenerator {
    //Jm�no za��zen�
    protected String deviceName;
    private int temperature = 18;
    private House house;
    private EventReporter eventReporter;


    public Thermostat(String deviceName, House house) {
        this.deviceName = deviceName;
        this.house = house;
        eventReporter = house.getEventReporter();
        house.getOutside().attach(this);
        setTemperature(house.getOutside().getTemperature());

    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Strategy runStrategy(int temperature) {
        if (temperature < 10) {
            return new FreezingStrategy(this);
        } else if (temperature < 16) {
            return new ColdStrategy(this);
        } else if (temperature < 22) {
            return new WarmStrategy(this);
        } else
            return new HotStrategy(this);
    }

    @Override
    public void newInfo(Info info) {
        eventReporter.newInfo(info);
    }


    @Override
    public void update(Observable observable) {
        if(observable instanceof Outside){
            Strategy strategy = runStrategy(((Outside) observable).getTemperature());
            newInfo(new Info(InfoType.thermostatStrategy,this,null,null,strategy));
        }
    }

    @Override
    public String toString() {
        return "Thermostat: " + deviceName;
    }
}