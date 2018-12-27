package Organism.Persons;
import EventsAlerts.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public class Child extends Person implements Observable {
	private ArrayList<Observer> observersList = new ArrayList<Observer>();

	private static final int cryProbability = 30;
	private boolean isSad;

	public Child(String name){
        super(name);
    }


	/**
	 * every child is crying with certain probability
	 * @return if child is crying
	 */
	private boolean cry(){
		return new Random().nextInt(100) <= cryProbability;
	}

	/**
	 * if random <= chance, child stops crying
	 * @param chance probability of cheeringUp
	 */
	void stopCrying(int chance){
		if(isSad){
			if(new Random().nextInt(100) <= chance){
				isSad = false;
			}
		}
		else{
			cry();
		}
	}

	/**
	 * do nextAction only if not crying
	 */
	public void nextAction(){
		if(!cry()){
		    super.nextAction();
		}
		else{
			isSad = true;
			announce();
		}

	}

	public boolean isSad() {
		return isSad;
	}

	public void hangOn(){
		isBusy = true;

	}

	@Override
	public void attach(Observer observer) {
		if(!observersList.contains(observer))
			observersList.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observersList.remove(observer);

	}

	@Override
	public void announce() {
		for (Observer observer:observersList) {
			observer.update(this);
		}
	}


	@Override
	public String toString() {
		return "Child " + name;
	}
}