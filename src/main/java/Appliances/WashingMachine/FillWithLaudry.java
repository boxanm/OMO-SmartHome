package Appliances.WashingMachine;


/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public class FillWithLaudry implements IWashingMachineState {

	WashingMachine washingMachine;

	public FillWithLaudry(WashingMachine newWashingMachine){

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
		if(washingMachine.getWashingMachineState() == washingMachine.cycleStart){
			System.out.println("Cyklus byl dokonèen");
			washingMachine.setWashingMachineState(washingMachine.takeOutLaundry);
		}else{
			System.out.println("Cyklus nebyl zapnut");
		}

	}

	public void takeOutLaundry() {
		System.out.println("Vybírám prádlo....");
		washingMachine.setWashingMachineState(washingMachine.getTakeOutLaundry());

	}
}