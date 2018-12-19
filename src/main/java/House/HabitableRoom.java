package House;


import Animals.Animal;
import Appliances.Appliance;
import Organism.Persons.Person;
import Senzors.Senzor;

import java.util.List;

/**
 * Obsahuje spotøebièe
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:42
 */
public abstract class HabitableRoom extends Room {

	private List<Person> personList;
	private List<Animal> animalList;
	private List<Appliance> applianceList;
	private List<Senzor> senzorList;

	public HabitableRoom(String name, House house, Floor floor, int number_of_windows){
		super(name, house, floor, number_of_windows);
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void addPerson(Person person){
		personList.add(person);
	}
	public  void removePerson(Person person){
		personList.remove(person);
	}
	public void addAnimal(Animal animal){
		animalList.add(animal);
	}
	public void removeAnimal(Animal animal){
		animalList.remove(animal);
	}
	public void addAppliance (Appliance appliance){
		applianceList.add(appliance);
	}
	public void deleteAppliance(Appliance appliance){
		applianceList.remove(appliance);
	}
	public void addSenzor(Senzor senzor){
		senzorList.add(senzor);
	}
	public void removeSenzor(Senzor senzor){
		senzorList.remove(senzor);
	}

}