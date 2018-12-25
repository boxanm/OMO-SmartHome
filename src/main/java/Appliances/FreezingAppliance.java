package Appliances;
/**
 * Rozhraní definující spoleèné vlastnosti a metody lednice a mrazáku
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public interface FreezingAppliance {

	/**
	 * 
	 * @param quantity - amount of food from 1 to 10 eaten from the fridge
	 */
	public void eat(int quantity);

	/**
	 * 
	 * @param quantity - amount of food from 1 to 10 added to the fridge
	 */
	public void fill(int quantity);

	public void changeEmpty();

	public boolean isEmpty();

}