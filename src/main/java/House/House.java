package House;

import EventsAlerts.EventReporter;
import Reports.HouseReportLayout;
import Animals.Animal;
import Organism.Persons.Person;


import java.util.ArrayList;
import java.util.List;

/**
 * Základní entita. V rámci domu se mohou pohybovat zvíøata i lidé.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class House {

	private List<Person> personList;
	private List<Animal> animalList;
	private List<Floor> floorList;
	private EventReporter eventReporter;
	private static House instance;
	public Floor m_Floor;
	public HouseReportLayout m_HouseReportLayout;
	public EventReporter m_EventReporter;

	public House(){

		personList = new ArrayList<Person>();
		animalList = new ArrayList<Animal>();
		floorList = new ArrayList<Floor>();
	}

	public void finalize() throws Throwable {

	}

	public static House getInstance(){
		if(instance == null){
			instance = new House();
			return instance;
		}
		else return instance;
	}

	public void addFloor(Floor floor){
		floorList.add(floor);
	}

	public List<Floor> getFloRoomList(){
		return floorList;
	}
	public List<Person> getPersonList(){
		return personList;
	}
	public List<Animal> getAnimalList(){
		return getAnimalList();
	}

	public Floor getFloorOfRoom(Room room){
		return null; // vrati podlazi, ve kterem se nachazi zadana room
	}


}