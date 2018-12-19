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
    protected int lapNumber;
    protected EventSource source;
    protected Floor sourceFloor;
    protected Room sourceRoom;
    protected EventTarget target;

    public Event(){

    }

    public void finalize() throws Throwable {

    }

    public static int getEventID() {
        eventID++;
        return eventID;
    }
}