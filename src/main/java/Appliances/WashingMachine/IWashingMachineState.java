package Appliances.WashingMachine;


/**
 * Návrhový vzor state machine
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public interface IWashingMachineState {

    public void fillWithLaundry();

    public void cycleStart();

    public void cycleFinish();

    public void takeOutLaundry();

}