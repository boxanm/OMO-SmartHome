package Appliances.ApplianceState;

public class StateOFF extends State{


    public StateOFF(Context context) {
        super(context);
        this.state = ApplianceState.Off;
    }

    protected void changeToNextState() {
        context.setState(new StateON(context));
    }
}
