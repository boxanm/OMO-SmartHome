import House.*;

public class DataSetUp {

    public House firstConfiguration(){

        House house = new House("house1");

        Floor prvni = new Floor("1. patro",house);
        Floor druhe = new Floor("2. patro", house);

        HabitableRoom chodba = new HabitableRoom("Chodba", house, prvni, 2);
        HabitableRoom koupelna = new HabitableRoom("Koupelna", house, prvni, 1);
        HabitableRoom kuchyn = new HabitableRoom("Kuchyò", house, prvni, 3);
        HabitableRoom detskyPokoj = new HabitableRoom("Dìtský pokoj", house, prvni, 4);
        HabitableRoom loznice = new HabitableRoom("Ložnice", house, prvni, 4);
        HabitableRoom obyvak = new HabitableRoom("Obývák", house, druhe, 3);

        NonHabitableRoom garaz = new NonHabitableRoom("Garáž", house, prvni, 0);
        NonHabitableRoom technikaMistnost = new NonHabitableRoom("Technická místnost", house, prvni, 0);

        return house;
    }

}
