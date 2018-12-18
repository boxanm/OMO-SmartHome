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
public interface Observed extends InfoGenerator, Target {

	public Observer observersList = null;

	/**
	 * 
	 * @param observer
	 */
	public void attach(Observer observer);

	/**
	 * 
	 * @param observer
	 */
	public void detach(Observer observer);


	public void announce();

}