package House;

import Appliances.Appliance;
import EventsAlerts.EventReporter;
import Organism.Organism;
import Reports.HouseReportLayout;
import Organism.Animals.Animal;
import Organism.Persons.Person;
import SportsEquipment.SportEquipment;


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
	private List<Room> roomList;
	private ArrayList<Appliance> applianceList;;
	private ArrayList<SportEquipment> sportEquipmentList;
	private ArrayList<Car> carList;
	private List<HouseReportLayout> houseReportLayoutList;

	private EventReporter eventReporter;

	private String name;

	public House(String name){
		this.name = name;

		personList = new ArrayList<Person>();
		animalList = new ArrayList<Animal>();
		floorList = new ArrayList<Floor>();
		roomList = new ArrayList<Room>();
		applianceList = new ArrayList<>();
		sportEquipmentList = new ArrayList<>();
		carList = new ArrayList<Car>();
		houseReportLayoutList = new ArrayList<>();
	}

	public void finalize() throws Throwable {

	}

	public void addFloor(Floor floor){
		if(! floorList.contains(floor))
	        floorList.add(floor);
	}

	public List<Floor> getFloorList(){
		return floorList;
	}

	public List<Room> getRoomList(){
        ArrayList<Room> rooms = new ArrayList<>();
        for (Floor floor: floorList) {
            rooms.addAll(floor.getRoomList());
        }
        return rooms;
	}

	public List<Person> getPersonList(){
	    ArrayList<Person> persons = new ArrayList<>();
        for (Room room:getRoomList()) {
            for (Organism organism: room.getOrganismList()) {
                if(organism instanceof Person)
                    persons.add((Person) organism);
            }
        }
		return persons;
	}
	public List<Animal> getAnimalList(){

        ArrayList<Animal> animals = new ArrayList<>();
        for (Room room:getRoomList()) {
            for (Organism organism: room.getOrganismList()) {
                if(organism instanceof Animal)
                    animals.add((Animal) organism);
            }
        }
        return animals;

	}

	public ArrayList<Appliance> getAppliances(){
		ArrayList<Appliance> appliances = new ArrayList<>();
		for (Floor floor: floorList) {
			ArrayList<Room> rooms = floor.getRoomList();
			for (Room room:rooms) {
				if(room instanceof HabitableRoom){
					appliances.addAll(((HabitableRoom) room).getApplianceList());
				}
			}

		}
		return appliances;
	}
	public ArrayList<SportEquipment> getSportEquipment(){
		ArrayList<SportEquipment> sportEquipment = new ArrayList<>();
		for (Floor floor: floorList) {
			ArrayList<Room> rooms = floor.getRoomList();
			for (Room room:rooms) {
				if(room instanceof NonHabitableRoom){
					sportEquipment.addAll(((NonHabitableRoom) room).getSportEquipmentList());
				}
			}

		}
		return sportEquipment;
	}

	public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for(Room room:getRoomList()){
            if(room instanceof NonHabitableRoom)
                cars.add(((NonHabitableRoom) room).getCar());
        }
        return cars;

	}

	public EventReporter getEventReporter() {
		return eventReporter;
	}

	public void setEventReporter(EventReporter eventReporter){
		this.eventReporter = eventReporter;
	}

	public void addHouseReport(HouseReportLayout houseReportLayout){
		if(! houseReportLayoutList.contains(houseReportLayout))
			houseReportLayoutList.add(houseReportLayout);
	}

	@Override
	public String toString() {
		return name;
	}
}