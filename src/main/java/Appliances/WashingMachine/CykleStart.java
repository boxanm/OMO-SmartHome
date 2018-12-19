package Appliances.WashingMachine;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class CykleStart implements IWashingMachineState {

	WashingMachine washingMachine;

	public CykleStart(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}


	public void fillWithLaundry() {
		System.out.println("Nelze otevøít praèku se zapnutým cyklem");
	}

	public void cycleStart() {
		System.out.println("Prací cyklus je již zapnut");
	}

	public void cycleFinish() {
		System.out.println("Cyklus se dokonèuje...");
		washingMachine.setWashingMachineState(washingMachine.getCycleFinish());

	}

	public void takeOutLaundry() {
		System.out.println("Nemùžeš vyndat prádlo, když praèka pere");
	}
}