package Appliances.WashingMachine;


/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class CycleFinish implements IWashingMachineState {

	WashingMachine washingMachine;

	public CycleFinish(WashingMachine newWashingMachine){
		washingMachine = newWashingMachine;
	}

	public void fillWithLaundry() {
		System.out.println("Praèka už je plná prádla");
	}

	public void cycleStart() {
		System.out.println("Zapínám cyklus...");
		washingMachine.setWashingMachineState(washingMachine.getCycleStart());
	}

	public void cycleFinish() {
		System.out.println("Cyklus byl dokonèen");
	}

	public void takeOutLaundry() {
		System.out.println("Vybírám prádlo....");
		washingMachine.setWashingMachineState(washingMachine.getTakeOutLaundry());
	}
}