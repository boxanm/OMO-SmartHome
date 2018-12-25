package EventsAlerts;

import House.Floor;
import House.Room;

/**
 * Vygenerovaný EventGenerátorem (zdroj generování mùže být outside, spotøebiè,
 * organismus). Popis vlastností:
 * <ul>
 * 	<li>type - info se pouze ukládá, alert øeší ControlUnit</li>
 * 	<li>source - zdroj eventu</li>
 * 	<li>sourceFloor - ve kterém podlaží se nacházel zdroj eventu</li>
 * 	<li>sourceRoom - ve kterém pokoji se nacházel zdroj eventu</li>
 * 	<li>target - cíl eventu</li>
 * 	<li>eventID - identifikátor eventu</li>
 * 	<li>consuption - záznam o zmìnì spotøeby (v pøípadì, že source je spotøebiè,
 * jinak null)</li>
 * </ul>
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public abstract class Event {

    private static int eventID;
    private int lapNumber;
    Floor sourceFloor;
    Room sourceRoom;
    EventSource source;
    EventTarget target;

    public Event(){

    }

    public static int getEventID() {
        eventID++;
        return eventID;
    }

    public EventSource getSource() {
        return source;
    }

    public EventTarget getTarget() {
        return target;
    }

    public int getLapNumber() {
        return lapNumber;
    }

    public Floor getSourceFloor() {
        return sourceFloor;
    }

    public Room getSourceRoom() {
        return sourceRoom;
    }

    public void setTarget(EventTarget target) {
        this.target = target;
    }

    public void setLapNumber(int lapNumber) {
        this.lapNumber = lapNumber;
    }
}