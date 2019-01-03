package Sensors;

import Sensors.Strategy.ColdStrategy;
import Sensors.Strategy.FreezingStrategy;
import Sensors.Strategy.HotStrategy;
import Sensors.Strategy.WarmStrategy;
import EventsAlerts.*;
import House.House;

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

    public void runStrategy(int temperature) {
        if (temperature < 10) {
            new FreezingStrategy(this);
        } else if (temperature < 16) {
            new ColdStrategy(this);
        } else if (temperature < 22) {
            new HotStrategy(this);
        } else if (temperature < 28) {
            new WarmStrategy(this);
        }
    }

    @Override
    public void newInfo(Info info) {
        eventReporter.newInfo(info);
    }


    @Override
    public void update(Observable observable) {
        if(observable instanceof Thermostat){
            runStrategy(((Thermostat) observable).getTemperature());
            newInfo(new Info(InfoType.thermostatStrategy,this,null,null,house));
        }
    }

    @Override
    public String toString() {
        return "Thermostat: " + deviceName;
    }
}