package Appliances;

import Appliances.ApplianceState.ApplianceState;
import Appliances.ApplianceState.State;
import Appliances.ApplianceState.StateON;
import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Usable;

import java.util.Calendar;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class Freezer extends Appliance implements FreezingAppliance {


	private int food;
	private boolean isEmpty = false;
	private final int MAX_CAPACITY = 100;

    public Freezer(String name, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(name,brand,location,consumptionType, consumption);
		setState(new StateON(this)); // lednice je defaultne zapnuta
    }

	@Override
	public void changeEmpty() {
		isEmpty = !isEmpty;
	}
	@Override
	public boolean isEmpty() {
		return isEmpty;
	}


	/**
	 *
	 * @param quantity
	 */
	@Override
	public void eat(int quantity) {
		if (getFood() > quantity && quantity > 0 && quantity < 10){
			food -= quantity;
			newInfo(new Info(InfoType.eatFoodFridge,this,getActualFloor(),getActualRoom(),this));
			if(food <= 0){
				newAlert();
				food = 0;
				changeEmpty();
			}
		}else{
			newAlert();
		}
	}


	/**
	 *
	 * @param quantity
	 */
	@Override
	public void fill(int quantity) {
		if(quantity > 0){
			if(food + quantity < MAX_CAPACITY){
				food += quantity;
			} else{
				food = MAX_CAPACITY;
		}
		}
	}

	@Override
	public Usable use(Person person) {
		switch (getApplianceState()){
			case Off:
			case Iddle:
				turnON();
			case On:
				eat(person.getFoodConsumption());
				break;
		}
		return null;
	}

	public int getFood() {
		return food;
	}

	@Override
	public String toString() {
		return "Freezer " + deviceName;
	}

	@Override
	public void newAlert() {
		if(getFood() <= 0)
			eventReporter.updateFromAlertGenerator(new Alert(AlertType.outOfFood,this,getActualFloor(),getActualRoom(),null));

	}
}