package House;


import Organism.Persons.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Základní entita
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class Floor {

	private String name;
	private House house;
    private int number_of_rooms;
	private ArrayList<Room> roomList;
	public Room m_Room;

	public Floor(String name, House house){
		this.name = name;
		this.house = house;
		this.roomList = new ArrayList<Room>();
		house.addFloor(this);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * Add room on the floor
	 * @param room
	 */
	public void addRoom(Room room) {
		if(! roomList.contains(room))
			roomList.add(room);
	}
	public void deleteRoom(Room room){
		roomList.remove(room);
	}

	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public House getHouse() {
		return house;
	}

	@Override
	public String toString() {
		return name;
	}
}