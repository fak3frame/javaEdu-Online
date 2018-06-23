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
        long liczba5 = 1232455;//nie musze pisac z koncowka L
        long liczba4 = 123L;//da informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"
        float liczba6 = 123.34F;//musi byc "f" lub "F"
        double liczba7 = 213.45;
        short liczba8 = 234;
        //W przypadku typow prostych jest wykonywany automatyczny autoboxing

        int liczbaBox1 = new Integer(12);
        //wykonuje operacje odwrotna czyli autounboxing

        final int liczbaFinalna;
        liczbaFinalna = 10;
        //liczbaFinalna = 12; - blad - liczbe finalna mozemy przypisac 1 raz
        // lecz mozna ja zadeklarowac bez nadawania wartosci



        //INTERFACE
        /*
        API (ang. Application Programming Interface)
        Jest to zestaw metod bez ich implementacji
        Wszystkie metody interfacu sa publiczne
        Interface moze zawierac metody domyslne,statyczne oraz zmienne stałe
         finalne publiczne

        Metoda domyslna to taka ktora posiada cialo i zaczyna sie od slowa
         default, mozna je nadpisywac

        default String getName(){
            return "Napis";
        }

        Klasa implementujaca interface musi implementowac wszystkie jego
         metody za wyjatkiem klas abstrakcyjnych

        Interfejs moze rozszerzac inne interfejsy i klasa implementujaca
         taki interface musi metody z wszytskich tych interfejsow implementowac

        Intefejs bez metod jest interfejsem znacznikowym ktory sluzy do oznaczania
         danej klasy dzieki czemu moge przekazac dodatkowe informacje. Moge np
         powiedziec kompilatrowi ze dana klasa jest serializowana

        Poprzez tworzenie obiektu typu interfacu moge ograniczyc widzialnosc metod



         */









    }
    static boolean czyDuza(int liczba){
        return liczba>100;
    }
    private SilnikMoj silnikMoj;
}
