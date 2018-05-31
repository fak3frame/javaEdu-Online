package _1_Obiekty;

public class Wyjatki_2 {
    public static void main(String[] args) {
        //Wyjatek jest to klasa
        Wyjatki_2 o = new Wyjatki_2();
        o.pokazLiczbeSekund(-2);
    }

    public int pokazLiczbeSekund(int godziny){
        if(godziny < 0){
            throw new IllegalArgumentException("Musi byc wiecej niz 0 godzin :" + godziny);
        }
        return godziny*60*60;
    }
}
