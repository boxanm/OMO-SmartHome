package Appliances.WashingMachine;


/**
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class CycleStart implements IWashingMachineState {

	WashingMachine washingMachine;

	public CycleStart(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}


	public void fillWithLaundry() {
		System.out.println("Nelze otev��t pra�ku se zapnut�m cyklem");
	}

	public void cycleStart() {
		System.out.println("Prac� cyklus je ji� zapnut");
	}

	public void cycleFinish() {
		System.out.println("Cyklus se dokon�uje...");
		washingMachine.setWashingMachineState(washingMachine.getCycleFinish());

	}

	public void takeOutLaundry() {
		System.out.println("Nem��e� vyndat pr�dlo, kdy� pra�ka pere");
	}
}