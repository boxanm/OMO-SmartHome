package Appliances.ApplianceState;

public class StateIDDLE extends State {

    public StateIDDLE(Context context) {
        super(context);
        this.state = ApplianceState.Iddle;
    }

    protected void changeToNextState() {
        context.setState(new StateOFF(context));
    }
}
