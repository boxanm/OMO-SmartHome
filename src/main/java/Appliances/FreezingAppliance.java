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
	 * @param food
	 */
	public void eat(int food);

	/**
	 * 
	 * @param food
	 */
	public void fill(int food);

	public void changeEmpty();

}