package SamouczekProgramisty.Zadania._8_Enum;

public class Czlowiek {
    String imie;
    int wiek;
    Kolory kolorOczu;
    Kolory kolorWlosow;
    Czlowiek(String imie, int wiek, Kolory kolorOczu, Kolory kolorWlosow){
        this.imie = imie;
        this.wiek = wiek;
        this.kolorOczu = kolorOczu;
        this.kolorWlosow = kolorWlosow;
    }

    public static void main(String[] args) {
        Czlowiek c1 = new Czlowiek("kamil", 20, Kolory.ZIELONY, Kolory.BRAZOWY);
        System.out.println(c1.imie);
        System.out.println(c1.wiek);
        System.out.println("kolor oczu :" + c1.kolorOczu);
        System.out.println("kolor wloasow :" + c1.kolorWlosow);
    }
}
