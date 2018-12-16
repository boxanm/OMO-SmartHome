package House;


/**
 * Abstraktní tøída, mùže být obyvatelná èi neobyvatelná
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public abstract class Room {

	private boolean isFire;
	private int number_of_windows;
	private Window windowsList;

	public Room(){

	}

	public void finalize() throws Throwable {

	}

}