import Appliances.Appliance;
import Appliances.Creators.ApplianceCreator;
import House.House;

import House.HabitableRoom;
import House.NonHabitableRoom;
import House.Floor;
import SportsEquipment.*;

public final class Main {

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

        Appliance tv = ApplianceCreator.createAppliance("tv", "Samsung", koupelna);

        tv.turnON();


       // WashingMachine washingMachine = new WashingMachine("praèka", koupelna);

    }
}
