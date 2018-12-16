package Appliances;


/**
 * Návrhový vzor state machine
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public interface IWashingMachineState {

    public void cycleFinish();

    public void cycleStart();

    public void fillWithLaundry();

    public void takeOutLaundry();

}