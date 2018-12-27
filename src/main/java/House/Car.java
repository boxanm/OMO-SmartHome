package House;

import EventsAlerts.*;
import Organism.Persons.Adults;
import Organism.Persons.Person;
import Organism.Usable;
import Reports.EventReport;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Car implements EventTarget, Usable, InfoGenerator {

	private EventReporter eventReporter;

	private String brand;
	private NonHabitableRoom location;
	private boolean isPresent = true;

	private final int shoppingDuration = 6;
	private int actualShoppingDuration = 0;

	private final int carStorage = 50;
	private int actualCarStorage = 0;

	public Car(String brand, NonHabitableRoom location){

		this.brand = brand;
		this.location = location;
		location.addCar(this);
		eventReporter = location.getFloor().getHouse().getEventReporter();
	}

	public void goShopping(Adults adult){
		newInfo(new Info(InfoType.goingShopping,adult,location.getFloor(),location,this));
	}

	public boolean isPresent(){
		return isPresent;
	}

	@Override
	public Usable use(Person person) {
		isPresent = false;
		if(actualShoppingDuration < shoppingDuration){
			actualShoppingDuration++;
			if(person instanceof Adults){
				goShopping((Adults) person);
			}
			return this;
		}
		else{
			isPresent = true;
			actualCarStorage = carStorage;
			return null;
		}
	}

	public int getActualCarStorage() {
		return actualCarStorage;
	}

	public void emptyCarStorage(){
		actualCarStorage = 0;
	}
	@Override
	public String toString() {
		return "Car " + brand;
	}

	@Override
	public void newInfo(Info info) {
		eventReporter.newInfo(info);
	}
}