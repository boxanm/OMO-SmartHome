package Organism.Animals;

import Organism.Organism;

/**
 * Rozhran� definuj�c� spole�n� vlastnosti a metody zv��at.
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