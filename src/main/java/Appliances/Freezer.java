package Appliances;

import EventsAlerts.AlertType;
import EventsAlerts.Consumption;
import EventsAlerts.Info;
import EventsAlerts.Observer;
import House.HabitableRoom;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Freezer implements FreezingAppliance, Appliance {

	String name;
	HabitableRoom location;

	public Freezer(){

	}

    public Freezer(String name, HabitableRoom location) {

		this.name = name;
		this.location = location;
    }

	public void changeEmpty(){

	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * 
	 * @param food
	 */
	public void eat(int food){

	}

	/**
	 * 
	 * @param food
	 */
	public void fill(int food){

	}

	public void breakeDown(){

	}

	/**
	 * 
	 * @param typSpotreba
	 */
	public int getAktualniSpotreba(ConsuptionType typSpotreba){
		return 0;
	}

	public void setOnFire(){

	}

	public void turnIddle(){

	}

	public void turnOFF(){

	}

	public void turnON(){

	}

    @Override
    public ApplianceType getType() {
        return null;
    }

    @Override
    public boolean isBroken() {
        return false;
    }

    /**
	 * 
	 * @param alert
	 */
	public void handleAlert(AlertType alert){

	}

	public void newConsumption(){

	}

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer){

	}

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer){

	}

	public void announce(){

	}

	public Info newInfo(){

		return null;
	}

    @Override
    public void newInfo(Info info) {

    }
}