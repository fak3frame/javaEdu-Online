package SamouczekProgramisty.Zadania._8_Enum;

public class KalkulatorTest {
    public static void main(String[] args) {
        System.out.println(Kalkulator.DODAJ.wykonaj(10,20));
        System.out.println(Kalkulator.ODEJMIJ.wykonaj(20, 5));
        System.out.println(Kalkulator.POMNOZ.wykonaj(2,3));
        System.out.println(Kalkulator.PODZIEL.wykonaj(9,3));
    }
}
