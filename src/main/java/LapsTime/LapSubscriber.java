package LapsTime;

/**
 * Common interface for every object, which performs an action on the begging of every lap
 */
public interface LapSubscriber {
    /**
     * do some action
     */
    void newLap();
}
