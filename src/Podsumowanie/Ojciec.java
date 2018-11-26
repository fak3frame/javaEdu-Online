package Podsumowanie;


import java.util.Random;

class Ojciec{
     void metoda(){

    }

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i<50; i++){
            System.out.println(random.nextInt(4));
        }
    }
}




