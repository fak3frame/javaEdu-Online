package PrzydatneKlasy;

import java.util.Random;

public class RandomMoj {
    public static void main(String[] args) {

        Random generator = new Random();

        //metody:
        boolean losPrawdaFalsz = generator.nextBoolean();
        double losZmiennoprzecinkowa = generator.nextDouble()*10;
        //zwroci liczbe z przedzialu od 0 do 1
        System.out.println(Math.round(losZmiennoprzecinkowa));



        for(int i=0; i<5; i++){
            losZmiennoprzecinkowa = generator.nextDouble();
            System.out.println(losZmiennoprzecinkowa);
        }
    }
}
