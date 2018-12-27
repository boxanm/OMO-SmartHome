import Appliances.Appliance;
import Appliances.ConsumptionType;
import Appliances.Creators.FreezerCreator;
import Appliances.Creators.WashingMachineCreator;
import House.House;

import House.HabitableRoom;
import House.NonHabitableRoom;
import House.Floor;
import Organism.Organism;
import Organism.Persons.Dad;
import SportsEquipment.*;

public final class Main {

    private House house;

    public static void main(String args[]){
        World world = World.getInstance();
        House house = new House("house1");

        ConsumptionType elek = ConsumptionType.electricity;

        world.addHouse(house);

        Floor floor = new Floor("První patro", house);

        HabitableRoom koupelna = new HabitableRoom("koupelna", floor, 2);
        NonHabitableRoom technicka = new NonHabitableRoom("technicka", floor, 0);

         Organism dad = new Dad("Honza");

        SportEquipmentCreatorSki skiFactory = new SportEquipmentCreatorSki(technicka);
        SportEquipment lyze = skiFactory.createAtomic();

        FreezerCreator freezerCreator = new FreezerCreator(koupelna);
        Appliance chladnicka = freezerCreator.createCandy("chladnicka1");

        WashingMachineCreator washingMachineCreator = new WashingMachineCreator(koupelna);
        Appliance washing = washingMachineCreator.createBosch("pracka");
        dad.moveToHouse(house);
        dad.changeRoom(koupelna);

         ((Dad) dad).useAppliance(washing);


       // chladnicka.consumptionType;



       // WashingMachine washingMachine = new WashingMachine("praèka", koupelna);

    }
}
