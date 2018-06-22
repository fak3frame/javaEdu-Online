package SamouczekProgramisty;

public class Wstep {
    public static void main(String[] args) {
        /*
        WSTEP:
        Klasa - projekt/foremka
        Obiekt/instancja - produkt

        Maszyna wirtualna pomaga zarzadzac pamiecia

        wersja programy X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle

        JRE - maszyna wirtualna tylko dla uruchamiania programow

        JDK - zestaw narzedzi zawierajacy takze kompilator javac

        IDE (ang. Integrated Development Environment)

        METODY:

        Metoda - worek do grupujacy zestaw instrukcji. tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc
         */
        System.out.println("METODY:");
        int jakisNumer = 123;
        boolean wynik = czyDuza(jakisNumer);
        System.out.println(wynik);
        class Wew1{
            boolean czyDuza(int liczba){
                return liczba>100;
            }

        }
    }
    static boolean czyDuza(int liczba){
        return liczba>100;
    }

}
