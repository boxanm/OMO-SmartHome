package Organism.Animals;

import Organism.Organism;

/**
 * Rozhraní definující spoleèné vlastnosti a metody zvíøat.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:08
 */
public abstract class Animal extends Organism {

	public Animal(String name) {
		super(name);
	}

	/**
	 * Every animal makes a specific sound
	 */
	abstract void makeSound();


	@Override
	public void newLap() {
		makeSound();
	}

}