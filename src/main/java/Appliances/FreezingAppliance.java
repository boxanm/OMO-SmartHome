package Appliances;


/**
 * Rozhraní definující spoleèné vlastnosti a metody lednice a mrazáku
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public interface FreezingAppliance {

	public int food = 0;
	public boolean isEmpty = false;

	/**
	 * 
	 * @param food - amount of food from 1 to 10 eaten from the fridge
	 */
	public void eat(int food);

	/**
	 * 
	 * @param food - amount of food from 1 to 10 added to the fridge
	 */
	public void fill(int food);

	public void changeEmpty();

	public boolean isEmpty();

}