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
        Metody nie powinny przyjmowac duzej ilosc argumentow ("code smell")
        Metoda void moze posiadac slowo retrun ale nie moze nic zwracac
         */
        System.out.println("METODY:");
        int jakisNumer = 123; //zakres +/- 2,147,483,647
        class Wew1{
            boolean czyDuza(int liczba){
                return liczba>100;
            }
            void powiedzCos(){
                return;
            }
        }
        boolean wynik = czyDuza(jakisNumer);
        System.out.println(wynik);

        /*
        PAKIETY:

        Package - informuje gdzie znajduje sie klasa/interfejs/typ wyliczeniowy

        package SamouczekProgramisty.folder1;
        plik klasy znajduje sie w folderze "folder1" a on w folderze
         SamouczekProgramisty

         */


    }
    static boolean czyDuza(int liczba){
        return liczba>100;
    }
}
