package PrzydatneKlasy;

import java.util.Random;

public class RandomMoj {
    public static void main(String[] args) {

        Random generator = new Random();

        //metody:
        boolean losPrawdaFalsz = generator.nextBoolean();
        double losZmiennoprzecinkowa = generator.nextDouble();
        System.out.println(losZmiennoprzecinkowa);

        for(int i=0; i<5; i++){
            losPrawdaFalsz = generator.nextBoolean();
            System.out.println(losPrawdaFalsz);
        }
    }
}
