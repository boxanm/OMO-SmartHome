package EventsAlerts;

import House.Floor;
import House.Room;

/**
 * Vygenerovan� EventGener�torem (zdroj generov�n� m��e b�t outside, spot�ebi�,
 * organismus). Popis vlastnost�:
 * <ul>
 * 	<li>type - info se pouze ukl�d�, alert �e�� ControlUnit</li>
 * 	<li>source - zdroj eventu</li>
 * 	<li>sourceFloor - ve kter�m podla�� se nach�zel zdroj eventu</li>
 * 	<li>sourceRoom - ve kter�m pokoji se nach�zel zdroj eventu</li>
 * 	<li>target - c�l eventu</li>
 * 	<li>eventID - identifik�tor eventu</li>
 * 	<li>consuption - z�znam o zm�n� spot�eby (v p��pad�, �e source je spot�ebi�,
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