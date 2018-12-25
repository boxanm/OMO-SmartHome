package Appliances;

import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;
import Appliances.Strategy.ColdStrategy;
import Appliances.Strategy.FreezingStrategy;
import Appliances.Strategy.HotStrategy;
import Appliances.Strategy.WarmStrategy;
import House.Outside;

public class Thermostat {
    //Status zaøízení
    protected ApplianceState status;
    //Jméno zaøázení
    protected String deviceName;
    private int temperature = 18;
    Outside outside;


    public Thermostat(String deviceName, ApplianceState status, int temperature) {
        this.deviceName = deviceName;
        this.status = status;
        setTemperature(temperature);
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ApplianceState getStatus() {
        return status;
    }

    public void setStatus(ApplianceState status) {
        this.status = status;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void runStategy() {
        if (outside.getTemperature() < 10) {
            new FreezingStrategy(this);
        } else if (outside.getTemperature() < 16) {
            new ColdStrategy(this);
        } else if (outside.getTemperature() < 22) {
            new HotStrategy(this);
        } else if (outside.getTemperature() < 28) {
            new WarmStrategy(this);
        }
    }

}