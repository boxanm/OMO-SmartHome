package Appliances.ApplianceState;

public class StateON extends State {

    public StateON(Context context) {
        super(context);
        this.state = ApplianceState.On;
    }

    protected void changeToNextState() {
        context.setState(new StateIDDLE(context));
    }
}
