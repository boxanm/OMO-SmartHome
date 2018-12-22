package House;


import EventsAlerts.EventTarget;
import Organism.Organism;
import Organism.Persons.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraktní tøída, mùže být obyvatelná èi neobyvatelná
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public abstract class Room implements EventTarget {

	private ArrayList<Organism> organismList;
	private String name;
	private House house;
	private Floor floor;

	private boolean isOnFire = false;
	private int number_of_windows;
	private List<Window> windowsList;

	public Room(String name, House house, Floor floor, int number_of_windows){
		this.name = name;
		this.house = house;
		this.floor = floor;
		this.number_of_windows = number_of_windows;
		windowsList = new ArrayList<Window>();
		for (int i = 0; i < number_of_windows; i++){
			windowsList.add(new Window(this,new Blind()));
		}
		floor.addRoom(this);
		organismList = new ArrayList<>();
	}

	public void setOnFire(){
		this.isOnFire = true;
	}

	public void extinguishFire(){
		this.isOnFire = false;
	}

	public boolean isOnFire(){
		return isOnFire;
	}

	public Floor getFloor() {
		return floor;
	}


	public void addOrganism(Organism organism){
		if(! organismList.contains(organism))
			organismList.add(organism);
	}
	public  void removeOrganism(Organism organism){
		organismList.remove(organism);
	}

	public ArrayList<Organism> getOrganismList(){
		return organismList;
	}

    public List<Window> getWindowsList() {
        return windowsList;
    }

    @Override
	public String toString() {
		return name;
	}
}