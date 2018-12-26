import Appliances.Appliance;
import Appliances.Creators.ApplianceCreator;
import Appliances.Creators.FreezerCreator;
import House.House;
import LapsTime.LapSubscriber;
import SportsEquipment.SportEquipment;
import SportsEquipment.SportEquipmentCreatorSki;

import House.HabitableRoom;
import House.NonHabitableRoom;
import House.Floor;

import java.util.ArrayList;

public final class Main_Laps {

    private House house;

    public static void main(String args[]){
        World world = World.getInstance();
        House house = new House("house1");

        world.addHouse(house);

        Floor floor = new Floor("První patro", house);

        HabitableRoom koupelna = new HabitableRoom("koupelna", house, floor, 2);
        NonHabitableRoom technicka = new NonHabitableRoom("technicka", house, floor, 0);

        SportEquipmentCreatorSki skiFactory = new SportEquipmentCreatorSki(technicka);
        SportEquipment lyze = skiFactory.createAtomic();

        FreezerCreator freezerCreator = new FreezerCreator(koupelna);
        Appliance chladnicka = freezerCreator.createCandy("chladnicka1");

        chladnicka.turnON();


        ArrayList<LapSubscriber> lapSubscribers = new ArrayList<>();
     //   lapSubscribers.add(chladnicka);
        for (LapSubscriber sub:lapSubscribers) {
            sub.newLap();
        }

    }
}
