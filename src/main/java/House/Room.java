package House;


import EventsAlerts.EventTarget;

import java.util.List;

/**
 * Abstraktní tøída, mùže být obyvatelná èi neobyvatelná
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public abstract class Room implements EventTarget {

	private String name;
	private House house;
	private Floor floor;

	private boolean isFire;
	private int number_of_windows;
	private List<Window> windowsList;

	public Room(String name, House house, Floor floor, int number_of_windows){
		this.name = name;
		this.house = house;
		this.floor = floor;
		this.number_of_windows = number_of_windows;
		this.isFire = false;
		floor.addRoom(this);
	}

	public void setOnFire(){
		this.isFire = true;
	}

	public void extinguishFire(){
		this.isFire = false;
	}

}