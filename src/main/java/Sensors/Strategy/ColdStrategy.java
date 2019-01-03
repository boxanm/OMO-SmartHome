package Sensors.Strategy;

import Sensors.Thermostat;

public class ColdStrategy extends Strategy {

    public ColdStrategy(Thermostat thermostat) {
        super(thermostat);
        controlTemperature();
    }

    @Override
    public void controlTemperature() {
        this.thermostat.setTemperature(this.thermostat.getTemperature() + 5);
    }


    @Override
    public String toString() {
        return "Cold Strategy";
    }
}
