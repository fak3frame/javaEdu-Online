package SamouczekProgramisty;

import SamouczekProgramisty.Silnik.SilnikMoj;
import jdk.nashorn.api.tree.ForInLoopTree;

import java.util.ArrayList;
import java.util.List;

public class Wstep {

    public static void main(String[] args) {
        /*
        Skroty klawiszowe:
        alt + 1 - ukrycie okienka struktury projektu
        alt + strzalka - przleczanie pomiedy zakladkami
        alt + ins - dodanie pliku
        shift + tab - usuniecie wciecia
        ctrl + spacja - podpowiedz
        ctrl + j - podpowiedzi dla klasy
        fori + tab - petla for


         */

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

        Słuza do grupowania i informowania gdzie znajduje sie klasa/interfejs
        /typ wyliczeniowy/adnotacja

        Przyjato ze uzywa sie odwrotnej nazwy domenowej

        package pl.SamouczekProgramisty.Folder1;
        plik klasy znajduje sie w folderze "Folder1" a on w folderze
         "SamouczekProgramisty" a on w "pl"

        import pl.SamouczekProgramisty.Folder1.MojaKlasa;
        importuje klase MojaKlasa z pakietu ->Folder1->
         ->SamouczekProgrmisty->pl


        KLASY:

        Sluzy do grupowania atrybutow i metod

        Jesli utworzymy wlasny konstruktor - kompilator nie doda domyslnego
        ----------------
        private SilnikMoj silnikMoj;

        public Silnik(){
            silnikMoj = new SilnikMoj(20);
        }
        public Silnik(SilnikMoj silnikMoj){
            this.silnikMoj = silnikMoj;
        }
        ----------------
        1 konstruktor tworzacy obiekt klasy SilnikMoj w atrybucie silnikMoj
           klasy Silnik
        2 konstruktor kopiujacy obiekt klasy SilnikMoj do atrybutu silnikMoj
           klasy Silnik
        ----------------
        retrun SilnikMoj getSilnikMoj(){
            return silnikMoj;
        }
        */

        //STRING / TABLICE / ZMIENNE
        //Tblica jest obiektem !
        String a = "213\nwqeqwe";//\n enter
        int aDlugosc = a.length();

        String[] dni = new String[7];
        dni[0] = "Poniedzialek";
        System.out.println(dni.length); //bez () !!
        //w string/kolekcjach jest z ()
        //pokaze ilosc dlugosc tablicy a nie ile ma wypelnionych elem.

        String[] imiona = new String [] {"kamil", "tomek"};



        int liczba = 1234_123;//liczba z literalem - ulatwia czytelnosc
        //pokaze liczbe normalnie
        int liczba2 = -0xFF00;//w systemie szesnastkowym
        int liczba3 = 0777;//w systemie osemkowym (511)
        long liczba4 = 123L;//da informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"










    }
    static boolean czyDuza(int liczba){
        return liczba>100;
    }
    private SilnikMoj silnikMoj;
}
