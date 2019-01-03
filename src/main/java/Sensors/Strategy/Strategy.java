package Sensors.Strategy;

import EventsAlerts.EventTarget;
import Sensors.Thermostat;

public abstract class Strategy implements EventTarget {

    protected Thermostat thermostat;

    public Strategy(Thermostat thermostat){
        this.thermostat = thermostat;
    }

    /**
     * Control of temperature
     */
    public abstract void controlTemperature();

}
