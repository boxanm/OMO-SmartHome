package Organism.Animals;

import EventsAlerts.*;
import House.Floor;
import House.Room;
import Organism.Organism;


/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Cat extends Animal {

	public Cat(String name){
		super(name);
	}


	public void makeSound() {
		newInfo(new Info(InfoType.animalSound, this, getFloor(), actualRoom, this));
	}


	@Override
	public String toString() {
		return "Cat";
	}
}