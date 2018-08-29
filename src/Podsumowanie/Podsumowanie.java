package Podsumowanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Podsumowanie {
    public static void main(String[] args) {
        /*
        -----SKTORY KLAWISZOWE-----

        alt + 1 - ukrycie okienka struktury projektu
        alt + strzalka - przleczanie pomiedy zakladkami
        alt + ins - dodanie pliku
        alt + del - cofniecie usuniecia
        ctrl + y - usuniecie lini


        //skok kursora
        ctrl + lewo/prawo - skok o cale slowo
        ctrl + gora/dow - skroll gora dol

        shift + enter - enter i skok do nowej linii
        ctrl + enter - enter ponizej zostajac w tej samej linii
        ctrl + alt + enter - enter linie wyzej, ide do tej linii

        shift + tab - usuniecie wciecia
        ctrl + del - usuniecie slowa lub wszytkich pustych znako
         i skok do liini wyzej

        //zaznaczaanie
        shit + strzalka - zaznaczenie pojedynczego znaku
        shift + ctrl + stralka - zaznaczenie wyrazu


        ctrl + spacja - podpowiedz
        ctrl + j - podpowiedzi dla klasy
        fori + tab - petla for



        -----OGOLNE-----

        Klasa - projekt/foremka
        Obiekt/instancja - produkt

        Maszyna wirtualna pomaga zarzadzac pamiecia

        Wersja programu X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle

        JRE - maszyna wirtualna tylko dla uruchamiania programow

        JDK - zestaw narzedzi zawierajacy takze kompilator javac

        IDE (ang. Integrated Development Environment)



        -----ZMIENNE PROSTE-----
        */

        int zmiennaInt = 123;
        //zakres +/- 2,147,483,647
        int zmiennaInt2 = 123_123;
        //zapis z literalem, pokaze normalnie, ulatwia czytelnosc

        int liczba = 1234_123;//liczba z literalem - ulatwia czytelnosc
        //pokaze liczbe normalnie
        int liczba2 = -0xFF00;//w systemie szesnastkowym
        int liczba3 = 0777;//w systemie osemkowym (511)

        long liczba5 = 1232455;//nie musze pisac z koncowka L
        long liczba4 = 123L;//da informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"

        float liczba6 = 123.34F;//musi byc "F" lub "f"

        double liczba7 = 213.45;//opcjonalnie z d lub D

        short liczba8 = 234;

        boolean prawdaFalsz = true;
        //zakres true/false

        String napis = "asd\n123";


        //W przypadku typow prostych jest wykonywany automatyczny autoboxing

        int liczbaBox1 = new Integer(12);
        //wykonuje operacje odwrotna czyli autounboxing


        //Zmienne finalne
        final int LICZBA_FINAL;
        LICZBA_FINAL = 12;
        /*
        liczba finalana musi miec zadeklarowana wartosc chyba ze:
         -jej przypisanie wartosci jest w konstruktorze klasy
         -jest zadeklarowana lokalnie(w metodzie)

        wartosc liczby finalnej NIE MOZNA zmienic



        -----METODY-----

        Metoda - worek do grupujacy zestaw instrukcji. Tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc

        Metoda moze byc zwykla(odnoaszaca sie do instancji klasy) lub
         statyczna(odnoszaca sie do klasy)
         */
class Wew1{/////////////////////////////////////////////////////
        public String metodaDajacaString(int liczba){
            return String.valueOf(liczba);
        }
        public int metodaDajacaInt(String napis){
            return Integer.parseInt(napis);
        }
}////////////////////////////////////////////////////////////////

        /*
        Metody deklaruje TYLKO w klasie (nie w innych metodach)

        Metody nie powinny przyjmowac duzej ilosc argumentow ("code smell")

        Metode moge wywolac na obiekcie lub bezposrenio
         mojObiekt.mojaMetoda();
         mojaMetoda();

        W statycznej metodzie(np main) NIE MOGE odwolac sie bezposrenio
         do niestatycznej metody!!

        Metoda nie zwracajac nic void moze posiadac slowo return ale
         nie moze nic zwracac
         */
class Wew2{/////////////////////////////////////////////////////
        public void metodaNicNieZwracajaca(){
            return;
        }
}////////////////////////////////////////////////////////////////
        /*



        -----WPROWADZANIE DANYCH-----
        */
class Wew3{/////////////////////////////////////////////////////
        void start(){
            String imie;
            List<String> imiona = new ArrayList<>();
            Scanner wejscie = new Scanner(System.in);
            do{
                imie = wejscie.nextLine();
                if(!imie.equals("-"))
                    imiona.add(imie);

            }while (!imie.equals("-"));

            //lub w samym while
            while (true){
                imie = wejscie.nextLine();
                if(imie.equals("-"))
                    break;
                imiona.add(imie);
            }
        }
}//////////////////////////////////////////////////////////////
        /*



        -----PAKIETY-----

        Słuza do grupowania i informowania gdzie znajduje sie klasa/interfejs
        /typ wyliczeniowy/adnotacja

        Przyjato ze uzywa sie odwrotnej nazwy domenowej

        package pl.SamouczekProgramisty.Folder1;
         Plik klasy znajduje sie w folderze "Folder1" a on w folderze
         "SamouczekProgramisty" a on w "pl"

        import pl.SamouczekProgramisty.Folder1.MojaKlasa;
        importuje klase MojaKlasa z pakietu ->Folder1->
         ->SamouczekProgrmisty->pl
         Mam dostep dzieki temu takze do wszystkich jej statycznych metod



         -----KLASY-----

        Sluza do grupowania atrybutow/pol i metod

        Tworzenie instancji klasy

        Podsumowanie obiekt = new Podsumowanie();

        Aby operwac na obiekcie musze przypisac cos do jej referencji
         np wywoluja konstruktor klasy slowem new

        Slowo new wywoluje konstruktor klasy

        W nawiasie wpisuje paramtry jakie chce wyslac do konstruktora
         a ich ilosc decyduje jaki konstruktor zostanie wywolany

        -----
        Konstruktor jest to metoda ktora nazywa sie tak samo
         jak klasa i nie ma okreslonego jaki typ zwraca
         oraz nie moze nic zwracac

        public Podsumowanie(){
        }

        Standardowo kazda klasa ma swoj konstrukor bezparametrowy
         bez znaczenia czy go zadeklaruje

        Jesli zadeklaruje konstruktor z jakims parametrem to
         ten bezparametrowy zostaje usuniety

        -----
        Podsumowanie obiekt = new Podsumowanie(12);

        public Podsumowanie(int a)[
        }

        -----
        Moge w jednym konstruktorze odwolac sie do innego np
         w jedno lub bez parametrowym odwolac sie do dwuparamterowego
         sluszy do tego slowo this

        int a;
        public Podsumowanie(){
            this(20);
            //wysylam 1 zmienna czyli do konstruktora
            // 1 parametrowego
        }
        public Podsumowanie(int a){
            this.a = a;
        }

        -----
        //konstruktor kopiujacy
        private Podsumowanie podsumowanie;

        public Podsumowanie(Podsumowanie podsumowanie){
            this.podsumowanie = podsumowanie;
        }

        -----
        Zmienna statyczna dotyczy klasy a nie obiektu lecz moge
         na obiekcie sie do niej odwolac

class Wew4{///////////////////////////////////////////////////////
        staric int a = 10;

        main(){
            Wew4 obiekt = new Wew4();
            System.out.println(obiekt.a);
        }
}/////////////////////////////////////////////////////////////////

         */
    }
}

