package Appliances.WashingMachine;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public class TakeOutLaudry implements IWashingMachineState {

	WashingMachine washingMachine;

	public TakeOutLaudry(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}


	public void fillWithLaundry() {
		System.out.println("Naplòuji praèku prádlem...");
		washingMachine.setWashingMachineState(washingMachine.getFillWithLaundry());
	}

	public void cycleStart() {
		System.out.println("Zapínám cyklus...");
		washingMachine.setWashingMachineState(washingMachine.getCycleStart());
	}

	public void cycleFinish() {
		System.out.println("Cyklus nebyl zapnut");
	}

	public void takeOutLaundry() {
		System.out.println("Praèka je prázdná");
	}
}