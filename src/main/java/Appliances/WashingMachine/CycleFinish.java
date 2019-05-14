package Appliances.WashingMachine;


/**
 * @author Michal Kore�, Mat�j Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class CycleFinish implements IWashingMachineState {

	WashingMachine washingMachine;

	public CycleFinish(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}

	public void fillWithLaundry() {
		System.out.println("Pra�ka u� je pln� pr�dla");
	}

	public void cycleStart() {
		System.out.println("Zap�n�m cyklus...");
		washingMachine.setWashingMachineState(washingMachine.getCycleStart());
	}

	public void cycleFinish() {
		System.out.println("Cyklus byl dokon�en");
	}

	public void takeOutLaundry() {
		System.out.println("Vyb�r�m pr�dlo....");
		washingMachine.setWashingMachineState(washingMachine.getTakeOutLaundry());
	}
}