package _1_Obiekty;

public class Wyjatki_2 {
    public static void main(String[] args) {
        //Wyjatek jest to klasa
        //WYRZUCANIE WYJATKOW: (bez obslugi)
        System.out.println("-1-");
        Wyjatki_2 o = new Wyjatki_2();
        o.pokazLiczbeSekund(-2);
        //wyrzuci wyjatek i zakonczy dzialanie programu
    }

    //------1-------
    public int pokazLiczbeSekund(int godziny){
        if(godziny < 0){
            throw new IllegalArgumentException("Musi byc wiecej niz 0 godzin :" + godziny);
            //wyjatek standardowej biblioteki javy
        }
        return godziny*60*60;
    }


}
