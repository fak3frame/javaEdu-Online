package PrzydatneKlasy;

import java.util.Random;

public class RandomMoj {
    public static void main(String[] args) {

        Random generator = new Random();

        //metody:
        boolean losPrawdaFalsz = generator.nextBoolean();

        double losZmiennoprzecinkowa = generator.nextDouble();
        //zwroci liczbe z przedzialu od 0 do 1
        //mozna zmienic zakres mnozac przez cos np generator.nextDouble()*10
        // pokaze wiec liczbe od 0 - 10 z liczbami po przecinkuu
        //mozna w takim przypadku urzyc rzutowania na int aby pokazalo bez
        // reszty

        float lozZmiennoprzecinkowa2 = generator.nextFloat();
        //mniejsza ilosc liczb po ,


        int zmiennaZwyklaBadzUjemna = generator.nextInt();
        //standardowo pokaze liczby ujemne i dodanie z calego zakresu int
        //mozna zawezic zakres podajac liczbe int w parametrze metody
        // np.10 generator.nextInt(10) to zawezi losowane liczby od 0 do 9




        for(int i=0; i<50; i++){
            zmiennaZwyklaBadzUjemna = generator.nextInt();
            System.out.println(zmiennaZwyklaBadzUjemna);
        }
    }
}
