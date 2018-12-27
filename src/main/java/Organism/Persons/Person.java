package Organism.Persons;

import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.Room;
import Appliances.Appliance;
import SportsEquipment.SportEquipment;
import Organism.Organism;
import EventsAlerts.AlertHandler;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Rozhraní definující spoleèné vlastnosti a metody rodièù a dìtí.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:03
 */
public abstract class Person extends Organism {


	protected int applianceUsageNumber = 0;
	protected int sportEquipmentUsageNumber = 0;
	private final int foodConsumption = 5;

    public Person(String name) {
        super(name);
    }


	@Override
	public void newLap() {
		if(usingTarget == null){
			nextAction();//TODO preskocit dalsi akci, pokud resi alert
		}
		else{
			usingTarget = usingTarget.use(this);
			if(usingTarget == null)
				isBusy = false;
		}
	}

	public void nextAction(){
		if(!isBusy){
            System.out.println("new action");
			if(applianceUsageNumber <= sportEquipmentUsageNumber){
				List<Appliance> appliances = m_House
						.getAppliances()
						.stream()
						.filter(appliance-> !appliance.isBroken() && !appliance.isBusy())
						.collect(Collectors.toList());
				useAppliance(appliances.get(new Random().nextInt(appliances.size())));
			}
			else{
				List<SportEquipment> sportEquipments = m_House
						.getSportEquipment()
						.stream()
						.filter(sportEquipment -> !sportEquipment.isBusy())
						.collect(Collectors.toList());
				useSportEquipment(sportEquipments.get(new Random().nextInt(sportEquipments.size())));
			}
			isBusy = true;
		}
	}

	/**
	 *
	 * @param room
	 */
	public void callFireman(Room room){
		newInfo(new Info(InfoType.callingFireman, this, getFloor(),actualRoom, room));
	}

	/**
	 *
	 * @param appliance
	 */
	public void useAppliance(Appliance appliance){
		if(appliance != null && !isBusy) {
			newInfo(new Info(InfoType.applianceUsage,this,getFloor(),actualRoom,appliance));
			applianceUsageNumber++;
			usingTarget = appliance.use(this);
		}
	}

	/**
	 *
	 * @param equipment
	 */
	public void useSportEquipment(SportEquipment equipment){
		if(equipment != null && !isBusy){
			newInfo(new Info(InfoType.sportEquipmentUsage, this, getFloor(), actualRoom, equipment));
			sportEquipmentUsageNumber++;
			usingTarget = equipment.use(this);
		}
	}

	public void hangOn() {
		newInfo(new Info(InfoType.hangingOn,this,getFloor(),actualRoom,this));
	}

	public int getFoodConsumption() {
		return foodConsumption;
	}
}