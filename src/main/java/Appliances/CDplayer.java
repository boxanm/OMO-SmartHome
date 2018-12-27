package Appliances;


import EventsAlerts.Info;
import EventsAlerts.InfoType;
import House.HabitableRoom;

/**
 * Rozhraní pro všechny, které umožòují práci s CD.
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:00:41
 */
public abstract class CDplayer extends Appliance{

	public CDplayer(String deviceName, String brand, HabitableRoom location, ConsumptionType consumptionType, double[] consumption) {
		super(deviceName, brand, location, consumptionType, consumption);
	}

	public void ejectCD(){
		newInfo(new Info(InfoType.ejectingCD,this,getActualFloor(),getActualRoom(),this));
	}

	public void insertCD(){
		newInfo(new Info(InfoType.insertingCD,this,getActualFloor(),getActualRoom(),this));
	}

	public void playCD(){
		newInfo(new Info(InfoType.playingCD,this,getActualFloor(),getActualRoom(),this));
	}



}