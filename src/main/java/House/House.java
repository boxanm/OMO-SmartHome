package House;

import Appliances.Appliance;
import EventsAlerts.ControlUnit;
import EventsAlerts.EventReporter;
import LapsTime.LapSubscriber;
import Organism.Organism;
import Reports.HouseReportLayout;
import Organism.Animals.Animal;
import Organism.Persons.Person;
import Sensors.CircuitBreakers;
import Sensors.ElectricitySensor;
import SportsEquipment.SportEquipment;


import java.util.ArrayList;
import java.util.List;

/**
 * Z�kladn� entita. V r�mci domu se mohou pohybovat zv��ata i lid�.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public class House implements LapSubscriber {

	private List<Floor> floorList;
	private List<HouseReportLayout> houseReportLayoutList;

	private EventReporter eventReporter;

	private Outside outside;
	private String name;

	private ControlUnit controlUnit;

	private CircuitBreakers circuitBreakers;

	private ElectricitySensor electricitySensor;

	public House(String name){
		this.name = name;
		this.outside = new Outside();

		floorList = new ArrayList<Floor>();
		houseReportLayoutList = new ArrayList<>();

		controlUnit = new ControlUnit();
		eventReporter = new EventReporter(this);
	}


	@Override
	public void newLap() {
		controlUnit.newLap();
		outside.newLap();
		for (Appliance appliance:getAppliances()) {
			appliance.newLap();
		}
		for (Person person:getPersonList()) {
			person.newLap();
		}
		for (Animal animal:getAnimalList()) {
			animal.newLap();
		}
		electricitySensor.newLap();
		eventReporter.newLap();
	}

	public void addFloor(Floor floor){
		if(! floorList.contains(floor))
	        floorList.add(floor);
	}

	public void setCircuitBreakers(CircuitBreakers circuitBreakers) {
		this.circuitBreakers = circuitBreakers;
	}

	public CircuitBreakers getCircuitBreakers() {
		return circuitBreakers;
	}

	public void setElectricitySensor(ElectricitySensor electricitySensor) {
		this.electricitySensor = electricitySensor;
	}

	public ElectricitySensor getElectricitySensor() {
		return electricitySensor;
	}

	public ControlUnit getControlUnit() {
		return controlUnit;
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

	public Outside getOutside() {
		return outside;
	}
	@Override
	public String toString() {
		return name;
	}

}