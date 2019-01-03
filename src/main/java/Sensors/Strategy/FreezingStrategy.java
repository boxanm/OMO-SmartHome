package Sensors.Strategy;

import Sensors.Thermostat;

public class FreezingStrategy extends Strategy{

    public FreezingStrategy(Thermostat thermostat) {
        super(thermostat);
        controlTemperature();
    }

    @Override
    public void controlTemperature() {
        this.thermostat.setTemperature(23);
    }
}
