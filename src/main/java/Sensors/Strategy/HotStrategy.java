package Sensors.Strategy;

import Sensors.Thermostat;

public class HotStrategy extends Strategy {

    public HotStrategy(Thermostat thermostat) {
        super(thermostat);
        controlTemperature();
    }

    @Override
    public void controlTemperature() {
        this.thermostat.setTemperature(19);
    }

    @Override
    public String toString() {
        return "Hot Strategy";
    }
}
