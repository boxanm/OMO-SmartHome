import Appliances.*;
import Appliances.Creators.*;
import Appliances.WashingMachine.WashingMachine;
import House.*;
import Organism.Animals.Cat;
import Organism.Animals.Dog;
import Organism.Animals.Ferret;
import Organism.Organism;
import Organism.Persons.Child;
import Organism.Persons.Dad;
import Organism.Persons.Mom;
import Sensors.*;
import SportsEquipment.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Configuration {
    public Configuration(){}

    public House getConfiguration1(){
        House house1 = new House("house1");

        Floor basement = new Floor("basement",house1);
        Floor floor1 = new Floor("floor1", house1);
        Floor floor2 = new Floor("floor2", house1);

        NonHabitableRoom garage1 = new NonHabitableRoom("garage1",basement,0);
        NonHabitableRoom garage2 = new NonHabitableRoom("garage2",basement,0);
        NonHabitableRoom gym = new NonHabitableRoom("gym", basement, 2);

        Car car1 = new Car("Volvo", garage1);
        Car car2 = new Car("VW", garage2);

        SportEquipmentCreatorBicycle factoryBicycle = new SportEquipmentCreatorBicycle(gym);
        SportEquipmentCreatorSki factorySki = new SportEquipmentCreatorSki(gym);

        Bicycle bicycle1 = factoryBicycle.createEquipment("Merida");
        Bicycle bicycle2 = factoryBicycle.createEquipment("Apache");
        Ski ski1 = factorySki.createEquipment("Atomic");
        Ski ski2 = factorySki.createEquipment("Fischer");

        List<SportEquipment> sportEquipments = new ArrayList<>(Arrays.asList(bicycle1,bicycle2,ski1,ski2));

        for (SportEquipment equipment:sportEquipments) {
            gym.addSportEquipment(equipment);
        }

        HabitableRoom livingRoom = new HabitableRoom("living room",floor1,3);
        HabitableRoom kitchen = new HabitableRoom("kitchen",floor1,2);
        HabitableRoom bathroom = new HabitableRoom("bathroom",floor1,1);
        HabitableRoom bedRoom1 = new HabitableRoom("bedroom1",floor2,2);
        HabitableRoom bedRoom2 = new HabitableRoom("bedroom2",floor2,2);
        HabitableRoom bedRoom3 = new HabitableRoom("bedroom3",floor2,2);
        HabitableRoom bedRoom4 = new HabitableRoom("bedroom4",floor2,1);

        double tvConsumption[] = new double[] {1, 0.2, 0.005};
        double pcConsumption[] = new double[] {2, 0.5, 0.002};
        double xboxConsumption[] = new double[] {1, 0.1, 0.001};
        double playstationConsumption[] = new double[] {1.1, 0.05, 0.002};
        double fridgeConsumption[] = new double[] {5, 0.5, 0};
        double freezerConsumption[] = new double[] {3, 0.5, 0};
        double hifiConsumption[] = new double[] {0.7, 0.1, 0.005};
        double washingMachineConsumption[] = new double[]{8, 0.2, 0.04};


        TVCreator tvCreator = new TVCreator(livingRoom);
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new TV("tv1","Samsung",livingRoom, ConsumptionType.electricity,tvConsumption));
        appliances.add(new TV("tv2","Samsung",bedRoom1,ConsumptionType.electricity,tvConsumption));


        appliances.add(new PC("pc1","Dell",livingRoom,ConsumptionType.electricity,pcConsumption));
        appliances.add(new PC("pc2","Samsung",bedRoom1,ConsumptionType.electricity,pcConsumption));
        appliances.add(new PC("pc3","Apple",bedRoom2,ConsumptionType.electricity,pcConsumption));
        appliances.add(new PC("pc4","HP",bedRoom3,ConsumptionType.electricity,pcConsumption));
        appliances.add(new PC("pc5","Lenovo",bedRoom4,ConsumptionType.electricity,pcConsumption));

        appliances.add(new Xbox("xbox1","Microsoft",livingRoom,ConsumptionType.electricity,xboxConsumption));
        appliances.add(new Xbox("xbox2","Microsoft",bedRoom3,ConsumptionType.electricity,xboxConsumption));

        appliances.add(new PlayStation("playstation1","Sony",livingRoom,ConsumptionType.electricity,playstationConsumption));
        appliances.add(new PlayStation("playstation2","Sony",bedRoom4,ConsumptionType.electricity,playstationConsumption));

        appliances.add(new Fridge("fridge1","Samsung",kitchen,ConsumptionType.electricity,fridgeConsumption));
        appliances.add(new Fridge("fridge2","Mille",kitchen,ConsumptionType.electricity,fridgeConsumption));

        appliances.add(new Freezer("freezer1","Freezer",kitchen,ConsumptionType.electricity,freezerConsumption));
        appliances.add(new Freezer("freezer2","Freezer",bathroom,ConsumptionType.electricity,freezerConsumption));

        appliances.add(new HifiTower("hifi1","HIFI",bedRoom2,ConsumptionType.electricity,hifiConsumption));
        appliances.add(new HifiTower("hifi2","HIFI",bedRoom3,ConsumptionType.electricity,hifiConsumption));
        appliances.add(new HifiTower("hifi3","HIFI",bathroom,ConsumptionType.electricity,hifiConsumption));

        appliances.add(new WashingMachine("washing machine1", "Bosch", bathroom,ConsumptionType.water,washingMachineConsumption));
        appliances.add(new WashingMachine("washing machine2", "Bosch", kitchen,ConsumptionType.water,washingMachineConsumption));

        Dog dog = new Dog("Rex");
        Ferret ferret = new Ferret("Ferret");
        Cat cat = new Cat("Tiger");

        Dad dad1 = new Dad("Matej");
        Dad dad2 = new Dad("Michal");

        Mom mom1 = new Mom("Elizabeth");
        Mom mom2 = new Mom("Melanda");

        Child child1 = new Child("Jack");
        Child child2 = new Child("Anna");

        dad1.addChild(child1);
        mom1.addChild(child1);

        dad2.addChild(child2);
        mom2.addChild(child2);

        List<Organism> organisms = new ArrayList<>(Arrays.asList(dog, ferret, cat, dad1, dad2, mom1, mom2, child1, child2));
        for (Organism organism: organisms) {
            organism.moveToHouse(house1);
        }

        FireSensor fireSensor = new FireSensor(house1);
        WindSensor windSensor = new WindSensor(house1);
        BabySitter babySitter = new BabySitter(house1);
        UsageSensor usageSensor = new UsageSensor(house1);
        WaterSensor waterSensor = new WaterSensor(house1);
        Thermostat thermostat = new Thermostat("thermostat1", house1);
        ElectricitySensor electricitySensor = new ElectricitySensor(house1);

        return house1;
    }

    public House getConfiguration2(){

        House house = new House("house1");

        Floor prvni = new Floor("1. patro",house);

        HabitableRoom chodba = new HabitableRoom("Chodba", prvni, 2);
        HabitableRoom koupelna = new HabitableRoom("Koupelna", prvni, 1);
        HabitableRoom kuchyn = new HabitableRoom("Kuchyn", prvni, 3);
        HabitableRoom detskyPokoj = new HabitableRoom("Detsky pokoj", prvni, 4);
        HabitableRoom loznice = new HabitableRoom("Loznice", prvni, 4);
        HabitableRoom obyvak = new HabitableRoom("Obyvak", prvni, 3);

        NonHabitableRoom garaz = new NonHabitableRoom("garaz", prvni, 0);
        NonHabitableRoom technikaMistnost = new NonHabitableRoom("technicka", prvni, 0);

        SportEquipmentCreatorSki creatorSki = new SportEquipmentCreatorSki(technikaMistnost);
        SportEquipmentCreatorBicycle creatorBicycle = new SportEquipmentCreatorBicycle(technikaMistnost);
        Ski lyze = creatorSki.createAtomic();
        Ski lyze2 = creatorSki.createHead();
        Bicycle bicycle = creatorBicycle.createApache();
        Bicycle bicycle2 = creatorBicycle.createMerida();
        Car auto = new Car("Skoda", garaz);

        technikaMistnost.addSportEquipment(lyze);
        technikaMistnost.addSportEquipment(lyze2);
        technikaMistnost.addSportEquipment(bicycle);
        technikaMistnost.addSportEquipment(bicycle2);

        garaz.addCar(auto);

        Dog pes = new Dog("Punta");
        Cat kocka = new Cat("Micka");
        Dad tata = new Dad("Adam");
        Mom mama = new Mom("Eva");
        Child dite = new Child("Adela");
        Child dite2 = new Child("Jan");

        tata.addChild(dite);
        mama.addChild(dite);

        tata.addChild(dite2);
        mama.addChild(dite2);

        List<Organism> organisms = new ArrayList<>(Arrays.asList(pes, kocka, tata, mama, dite, dite2));
        for (Organism organism: organisms) {
            organism.moveToHouse(house);
        }

        FridgeCreator fridgeCreator = new FridgeCreator(kuchyn);
        HiFiTowerCreator hiFiTowerCreator = new HiFiTowerCreator(loznice);
        PCCretator pcCretator = new PCCretator(obyvak);
        PlayStationCreator playStationCreator = new PlayStationCreator(detskyPokoj);
        TVCreator tvCreator = new TVCreator(detskyPokoj);
        WashingMachineCreator washingMachineCreator = new WashingMachineCreator(koupelna);
        XboxCreator xboxCreator = new XboxCreator(loznice);
        FreezerCreator freezerCreator = new FreezerCreator(chodba);

        List<Appliance> appliances = new ArrayList<>();

        appliances.add(fridgeCreator.createWhirlpool("Whirpool"));
        appliances.add(hiFiTowerCreator.createSencor("Sencor"));
        appliances.add(pcCretator.createZalman("Zalman"));
        appliances.add(playStationCreator.createSony("Sony"));
        appliances.add(tvCreator.createSamsung("Samsung"));
        appliances.add(washingMachineCreator.createBosch("Bosch"));
        appliances.add(xboxCreator.createMicrosoft("Microsoft"));
        appliances.add(freezerCreator.createCandy("Candy"));


        FireSensor fireSensor = new FireSensor(house);
        WindSensor windSensor = new WindSensor(house);
        BabySitter babySitter = new BabySitter(house);
        UsageSensor usageSensor = new UsageSensor(house);
        WaterSensor waterSensor = new WaterSensor(house);
        Thermostat thermostat = new Thermostat("thermostat1", house);
        ElectricitySensor electricitySensor = new ElectricitySensor(house);





        return house;
    }
}
