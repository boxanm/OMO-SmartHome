package Appliances.Strategy;

import Appliances.Thermostat;

public class HotStrategy extends Strategy {

    public HotStrategy(Thermostat thermostat) {
        super(thermostat);
        controlTemperature();
    }

    @Override
    public void controlTemperature() {
        this.thermostat.setTemperature(19);
    }
}
