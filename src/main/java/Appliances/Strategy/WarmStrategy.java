package Appliances.Strategy;

import Appliances.Thermostat;

public class WarmStrategy extends Strategy{

    public WarmStrategy(Thermostat thermostat) {
        super(thermostat);
        controlTemperature();
    }

    @Override
    public void controlTemperature() {
        this.thermostat.setTemperature(this.thermostat.getTemperature() - 5);
    }
}
