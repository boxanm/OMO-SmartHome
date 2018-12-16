package Appliances;


/**
 * Rozhraní pro všechny, které umožòují práci s CD.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public interface CDplayer {

	public void ejectCD();

	public void insertCD();

	/**
	 * 
	 * @param duration
	 */
	public void playCD(int duration);

}