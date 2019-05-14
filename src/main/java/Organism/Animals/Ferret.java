package Organism.Animals;

import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.Room;
import House.Floor;
import EventsAlerts.Observer;
import Organism.Organism;

import java.util.ArrayList;

/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public class Ferret extends Animal {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	public Ferret(String name){
		super(name);
	}

	public void makeSound() {
		newInfo(new Info(InfoType.animalSound, this, getFloor(), actualRoom, this));
	}

	@Override
	public String toString() {
		return "Ferret";
	}


}