import House.*;

public class HouseConfig {

    public House config1(){

        House house = new House("house1");

        Floor prvni = new Floor("1. patro",house);
        Floor druhe = new Floor("2. patro", house);

        HabitableRoom chodba = new HabitableRoom("Chodba", prvni, 2);
        HabitableRoom koupelna = new HabitableRoom("Koupelna", prvni, 1);
        HabitableRoom kuchyn = new HabitableRoom("Kuchy�", prvni, 3);
        HabitableRoom detskyPokoj = new HabitableRoom("D�tsk� pokoj", prvni, 4);
        HabitableRoom loznice = new HabitableRoom("Lo�nice", prvni, 4);
        HabitableRoom obyvak = new HabitableRoom("Ob�v�k", druhe, 3);

        NonHabitableRoom garaz = new NonHabitableRoom("Gar�", prvni, 0);
        NonHabitableRoom technickaMistnost = new NonHabitableRoom("Technick� m�stnost", prvni, 0);

        return house;
    }

}
