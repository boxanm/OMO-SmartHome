package Sensors.Strategy;

import Sensors.Thermostat;

public abstract class Strategy {

    protected Thermostat thermostat;

    public Strategy(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    /**
     * Control of temperature
     */
    public abstract void controlTemperature();
}
