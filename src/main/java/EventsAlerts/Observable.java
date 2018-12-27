package EventsAlerts;


/**
 * Rozhran� pro v�echny entity generuj�c� event. Event m��e b�t:
 * 
 * <ul>
 * 	<li>zm�na stavu spot�ebi�e</li>
 * 	<li>jak�koliv akce �lov�ka nebo zv��ete</li>
 * 	<li>zm�na po�as� venku</li>
 * </ul>
 * 
 * Na rozhran� je napojen� Observer dle n�vrhov�ho vzoru Observer
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:01:36
 */
public interface Observable extends EventTarget {

	void attach(Observer observer);

	void detach(Observer observer);

	void announce();

}