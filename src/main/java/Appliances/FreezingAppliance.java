package Appliances;

import EventsAlerts.*;
import House.HabitableRoom;
import Organism.Persons.Person;
import Organism.Persons.Usable;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody lednice a mraz�ku
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class FreezingAppliance extends Appliance implements AlertGenerator {

	private int food;
	private boolean isEmpty = false;
	private final int MAX_CAPACITY = 100;


	public FreezingAppliance(String deviceName, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(deviceName, brand, location, consumptionType, consumption);
		food = MAX_CAPACITY;
	}

	/**
	 *
	 * @param quantity
	 */
	public void eat(int quantity) {
		if (getFood() > quantity && quantity > 0 && quantity < 10){
			food -= quantity;
			newInfo(new Info(InfoType.eatFood,this,getActualFloor(),getActualRoom(),this));
			if(food <= 0){
				newAlert(new Alert(AlertType.outOfFood,this,getActualFloor(),getActualRoom(),null));
				food = 0;
				changeEmpty();
			}
		}else{
			newAlert(new Alert(AlertType.outOfFood,this,getActualFloor(),getActualRoom(),null));
		}
	}


	/**
	 *
	 * @param quantity
	 */
	public void fill(int quantity) {
		if(quantity > 0){
			newInfo(new Info(InfoType.fillingFood,this,getActualFloor(),getActualRoom(),this));
			if(food + quantity < MAX_CAPACITY){
				food += quantity;
			} else{
				food = MAX_CAPACITY;
			}
		}
	}

	public void changeEmpty() {
		isEmpty = !isEmpty;
	}
	public boolean isEmpty() {
		return isEmpty;
	}




	public int getFood() {
		return food;
	}

	@Override
	public void changeWearOfDevice() {
		wearOfDevice -= 1;
		if(wearOfDevice < 0){
			wearOfDevice = 0;
			breakDown();
		}
		announce();
	}

	@Override
	public Usable use(Person person) {
		switch (getApplianceState()){
			case Off:
			case Iddle:
				changeWearOfDevice();
				turnON();
			case On:
				eat(person.getFoodConsumption());
				break;
		}
		return null;
	}

	@Override
	public void newAlert(Alert alert) {
		if(food <= 0)
			eventReporter.updateFromAlertGenerator(alert);

	}
}