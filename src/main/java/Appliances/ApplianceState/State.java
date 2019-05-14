package Appliances.ApplianceState;


/**
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:00:42
 */
public abstract class State {

	protected Context context;
	protected ApplianceState state;

	public State(Context context) {
		this.context = context;
	}

	abstract protected void changeToNextState();

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public ApplianceState getStatus() {
		return state;
	}

}