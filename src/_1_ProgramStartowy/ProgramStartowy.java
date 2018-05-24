package _1_ProgramStartowy;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.Math.*;

public class ProgramStartowy {
    public static void main(String[] args) {

        //-----------ZMIENNE------------
        System.out.println("---Zmienne----");
        System.out.println("-1-");
        System.out.println("Hello World");
        /*
        byte - 1 bajt - zakres od -128 do 127
        short - 2 bajty - zakres od -32 768 do 32 767
        int - 4 bajty - zakres od -2 147 483 648 do 2 147 483 647
        long - 8 bajtów - zakres od -2^63 do (2^63)-1 (posiadają przyrostek L, lub l)

        float - 4 bajty - max ok 6-7 liczb po przecinku (posiadają przyrostek F, lub f)
        double - 8 bajtów - max ok 15 cyfr po przecinku (posiadają przyrostek D, lub d)

        BigDecimal
        BigInteger

        char - pojedynczy znak lub numer Unicode w systemie dziesietnym np '\u0061'
        znaki specjalne: \t - tab, \n - nowa linia, \r - powrót karetki, \" - cudzysłów, \' - apostrof
         \\ - backslash

         boolean - true/false
         */
        System.out.println("\n"+"-2-");
        float liczbaZm = 3.4f;//kropka + f
        int liczba = 5;
        String mojaLiczbaSlownie = Integer.toString(liczba); //wykorzystuje klase oslonowa Integer                      !
        // posiadajaca metody takie jak toString();
        System.out.println(mojaLiczbaSlownie);

        System.out.println("\n"+"-3-");
        char x1 = 'a';
        char x2 = '\u0061';
        System.out.println(x1+" "+x2);
        System.out.println('a'+'f');//zamieni na standardowy typ int, typ char jest zamienny na int
        System.out.println("a"+"f");

        final double LICZBA_PI=3.14; //zmienna stala, nie mozna jej juz zmienic



        //-----------------STRING-----------------------

        System.out.println("\n"+"---String---");
        System.out.println("-1-");
        String hello = "Witaj ";
        String world = "Świecie!";
        String powitanie = hello+world; //łączenie Stringów                                                             !
        System.out.println(powitanie);

        /*
        inne metody Stringa:

        str1 = str1.trim();  usunie biale znaki na poczaku i koncu Stringa

        str1 = str1.toUpperCase(); zamieni wszystkie znaki na duże
        str1 = str1.toLowerCase(); zamieni wszystkie znaki na male

        Boolean f1 = str1.isEmpty(); zwraca flage true jesli String jest pusty
        Boolean f1 = str1.isNotEmpty(); zwraca flage true jesli String nie jest pusty

        int dlugosc = str1.length(); zwraca liczbe znakow Stringa

        char[] tab = str1.toCharArray(); wypelni tablice znakow podzielonym Stringiem na poj. litery

        str1 = str1.substring(1, 2); pobierze od 2 do 3 znaku ze Stringa, mozna tez uzyc tylko pozycji
         startowej str1.substring(1); (zamienne z str.subSequence(1, 2);)

        String[] tab = str1.split(" "); podzieli Stringa w miejscu wystapienia " " i uzupelni nim tablice
        String[] tab = str1.split([0-9]); podzieli Stringa w miejscu wystapienia znakow od 0 do 9 i uzupelni
         nim tablice ([0-9] wyrazenie regularne)
        String[] tab = str1.split("", 4); podzieli Stringa na pojedyncze znaki (uzycie "") oraz ograniczy
         podzial do 4 podzialu i jako ostatni element doda cala reszte Stringa

        String str1 = str1.replace("aa", "A"); zemini ciag "aa" na "A"
        String str1 = str1.replaceFirst("a", "A"); zamieni pierwsze wystapienie "a" na "A"
        String str1 = str1.replaceAll([0-9], "x"); moze przyjac wyrazenie regularne

        boolean b = str1.matches("aa(.*)"); na podstawie wyrazenia regularnego sprawdza czy pasuje

        int pozycja = str1.indexOf("a"); pozycja pierwszego wystapienia "a"
        int pozycja = str1.indexOf("a",2); pozycja pierwszego wystapienia "a", rozpoczyna wyszukiwanie
         od 2 elementu Stringa
        int pozycja = str1.lastIndexOf("a"); pozycja ostatniego wystapienia "a"

        boolean czyRowne = str1.equals("aa2aaa"); sprawdzi czy str1 jest rowny podanemu ciagowi znakow
        boolean czyRowne = str1.equals(str2); sprawdzi czy str1 jest rowny str2
        boolean czyRowne = str1.equalsIgnoreCase(str2); sprawdzi czy str1 jest rowny str2 pomijajac
         wielkosci znakow

        str1 = str1.concat("10").concat("20").concat(str2); laczenie stringow, moze byc zastapione +

        boolean czyZaczyna = str1.startsWith("aa"); sprawdza czy String zaczyna sie od podanego ciagu
        boolean czyZaczyna = str1.startsWith("aa", 1); sprawdza czy od pozycji 1 wystapi podany ciag

        boolean czyKonczy = str1.endsWith("aa"); sprawdza czy String konczy sie podanym ciagiem

        boolean czyZawiera = str1.contains("aa"); sprawdza czy String zawiera podany ciag

        int porownanie = str1.compareTo(str3); wyrzuca -1 jesli str1 > str3, 0 jesli str1=str3
         oraz 1 jesli str1 < str3, mozna zignorowac wielkosc liter str1.compareToIgnoreCase(str3)

        byte[] b = str1.getBytes(); zamieni Stringa na tablice bajtow, kazdy elem. to jeden znak
        */

        //------------------STRING BUILDER-----------------------

        System.out.println("\n"+"---StringBuilder---");
        /*
        Klasa String jest niemodyfikalna przez co zmiana Strina wiaze sie z utworzeniem noweg obiektu, przydatne
         w mapach
         String value = "Java";
         value = value + " Rocks";
        StringBuilder jest modyfikowalny przez co laczenie jego obiektow nie wymaga tworzenia nowego obiektu
        StringBuilder wykorzystuje bufor ktory mozna okreslic za pomoca konstruktora lub metody ensureCapacity();
        StringBuilder sb1 = new StringBuilder(23);
        sb1.ensureCapacity(10);
        StringBildera nalezy uzywac gdy chcemy laczyc wiele stringow natomiast StringBuffera w aplikacjach
         wielowatkowych
         */
        System.out.println("-1-");
        StringBuilder sb = new StringBuilder(); //tworze pusty bufor, moze przyjac w nawiasie wartosc
        sb.append("Java").append(" ").append("Rocks! ");//                                                              !
        sb.append(69); //dzieki przeciązeniu metod moge dodac dowolny typ (wywoluje metode toString)
        System.out.println(sb);
        String s = sb.toString();//zapisuje do Stringa gotowa wartosc                                                   !

        /*
        inne metody:
        sb.insert(0, "Java Rocks"); doda w miesce 0 podany napis
         w przypadku bledu (dodanie wartosci po za zakres bufora powatanie blad IndexOutOfBoundsException
        sb.replace(0, 6, "Zmiana"); zmieni przedzial bufora od 0 do 6 na napis "Zmiana"
        sb.delete(0,6); usunie ciag od pozycji 0 do 6
        sb.reverse(); odwroci ciag
        sb.capacity(); zwroci liczbowy aktualny rozmiar bufora
        sb.length(); zwroci rozmiar przechowywanego ciagu znakow
        sb.charAt(1); zwroci znak przechowywany na pozycji 1
        sb.substring(0,4); zwroci ciag znakow z przedzialu od 0 do 4
         */
        System.out.println(sb.capacity());
        System.out.println(sb);



        //---------OPERATORY MATEMATYCZNE I LOGICZNE-----------

        System.out.println("\n"+"---OPERATORY MATEMATYCZNE I LOGICZNE---");
        System.out.println("-1-");
        int a = 5;
        System.out.println(a++);//zwiekszam po wyswietleniu
        System.out.println(a);
        System.out.println(++a);//zwiekszam przed wyswietlaniem

        System.out.println("\n"+"-2-");
        boolean czyPrawda = (5>6) || (5>4);
        System.out.println("czyPrwda = "+czyPrawda);

        System.out.println("\n"+"-23");
        String ja = "kamil";
        String ty = "kamil";
        System.out.println(ja==ty);//pokaze true ale tylko dla Stringa poniewaz Java przypisuje ten sam
        // adres pamieci (ta sama referencja) dla takich samych stringow
        System.out.println(ja.equals(ty));//wlasciwe porownanie



        //--------FUNKCJE MATEMATYCZNE I WIELKIE LICZBY------------

        System.out.println("\n"+"---FUNKCJE MATEMATYCZNE I WIELKIE LICZBY---");
        System.out.println("-1-");
        System.out.println(Math.abs(9));

        //Mozna zaimportowac biblioteke Math statycznie aby wykonywac operacje bez nazwy klasy Math
        //import static java.lang.Math.*;
        System.out.println("\n"+"-2-");
        System.out.println(pow(2,3));

        System.out.println("\n"+"-3-");
        System.out.println("PI = "+PI+ " E = "+E);


        System.out.println("\n"+"-4-");
        /*Do przechowywyania wielkich liczb sluzy BigInteger (liczby calkowite) oraz BigDecimal
           (liczby zmiennoprzecinkowe)
        */
        BigInteger bi = new BigInteger("10");//podaje w "" ale moge takze w formie liczby
        // BigInteger bi4 = BigInteger.valueOf(123534);
        // lecz tylko w zakresie long poniewaz wykorzystywana jest konwersja valueOf()

        //operacje na wielkich liczbach:
        BigInteger bi2 = BigInteger.valueOf(5);
        BigInteger bi3 = bi.add(bi2);//musze podac obiekt a nie wartosc
        System.out.println(bi3); //10 + 5
        System.out.println(bi3.subtract(bi)); //15 - 10                                                                 !
        System.out.println(bi3.multiply(bi2)); //15 * 5
        System.out.println(bi3.divide(bi2)); //15 / 5



        //----------KONWERSJA I RZUTOWNIE TYPOW-----------------

        System.out.println("\n"+"---KONWERSJA I RZUTOWNIE TYPOW---");
        /*
            Priorytety typow prostych: int<double<float<long
         */
        System.out.println("-1-");
        int a1 = 5;
        double b = 3;
        System.out.println(a1/b);//przkonwertuje na double
        System.out.println((int)(a1/b));//sztywne rzutowanie, pokaze bez reszty
        System.out.println( (a1/b) - (int)(a1/b)); // sama reszta
        System.out.println(Math.round(a1/b)); //wykorzystanie funkcji round() do obciecia reszty                        !

        //---------ZAPIS I KONWENCJA NAZEWNICTWA----------------
        /*
        Nazwa klas z duzej litery
        class MojaKlasa(){} - uzywam nazewnictwa PascalCase (zaczynam z duzej litery i kazdy
         kolejny wyraz takze z duzej)

        metody i zmienne z malej
        public void dodajLiczby(int x){} - uzywam camelCase - zaczynam od malej litery -/-
        int mojeImie;

        static final int MOJA_ZMIENNA
         zmienne finalne tylko z duzej a kolejne slowa oddzielam "_"
         */


        //-------------PODSTAWOWE TERMINY-----------------------
        /*
        Klasa jest to przestrzen w ktorej umieszczamy inne elementy, przechowujemy informacje
         oraz przetwarzamy je. Jest ona tzw foremka do tworzenia obiektow

        Obiekt jest reprezentacja klasy i jej nosnikiem. Poprzez obiekt mozemy sie odwolac do
         zmiennych i metod zawartych w klasie

         Klasa funkcja(){return new Klasa;}//metoda zwroci nowy obiekt klasy Klasa
        */



        //------------INSTRUKCJE STARUJACE-----------------

        System.out.println("\n"+"---INSTRUKCJE STARUJACE---");
        System.out.println("-1-");
        if(5>6){
            System.out.println("Instrukcja 1 jesli prawda");
        }
        else{
            System.out.println("Instrukcja 2 gdy 1 falszywa");
        }
        if(6>7){
            System.out.println("Instrukcja 3 jesli prawda");
        }
        else if(3>2){
            System.out.println("Instrukcja 4 jesli prawda  && jesli 3 falszywy");
        }

        System.out.println("\n"+"-2-");
        String imie = "kamil";
        switch(imie){
            case "kamil":
                System.out.println("jest kamil");
                break;
            case "tomek":
                System.out.println("jest tomek");
                break;
            default:
                System.out.println("nie ma kamila ani tomka");
        }

        System.out.println("\n"+"-3-");
        int liczba2 = 5;

        if(liczba%2==0 || liczba2%5==0)
            System.out.println("liczba 2 jest podzialna przez 2 lub 5");




        //----------ZAPIS I ODCZYT Z PLIKOW------------------------

        System.out.println("\n"+"---ZAPIS I ODCZYT Z PLIKOW---");
        System.out.println("-1-");
        //import java.io.File;
        File plik = new File("moj_plik.txt");
        //if(!plik.exists()) {//czy plik NIE istnieje                                                                   !
            try {
                plik.createNewFile();//tworze plik
                System.out.println("stworzylem plik");
                Scanner wczytajZPliku = new Scanner(plik); //tworze obiekt wczytaj typu Scanner posiadajacy
                // plik
                String daneZPliku = wczytajZPliku.nextLine();
                System.out.println(daneZPliku);
            } catch (IOException e) {
                System.out.println("Plik juz byl, " + e.getMessage());
            } catch (NoSuchElementException ex){
                System.out.println("Pusty plik "+ex.getMessage());
            }
        //}
        try{
            PrintWriter zapis = new PrintWriter("moj_plik.txt");//usunie cala zawartosc pliku
            zapis.println("moje zdanie"); //doda zdanie
            zapis.println("moje zdanie 2");
            zapis.close();//musze zamknac strumien
        }
        catch (FileNotFoundException ex){
            System.out.println("Nie znalazlem pliku "+ex.getMessage());
        }


        //----------------PĘTLE----------------------------------
        System.out.println("\n"+"---PĘTLE---");
        System.out.println("-1-");



        //----------PODSTAWOWE WEJSCIE / WYJSCIE-----------------

        System.out.println("\n"+"---PODSTAWOWE WEJSCIE / WYJSCIE---");
        System.out.println("-1-");
        String imie2;
        //nalezy zaimportowac klase Scanner
        Scanner odczyt = new Scanner(System.in); //tworze obiekt typu Scanner i jako parametr
        // konstruktowa uzywam strumien wejscia System.in

        System.out.println("Podaj imie:");

        imie2 = odczyt.nextLine();//wykorzystyje obiekt Scanner do wywolania metody nextLine()
        // przyjmuje ona ciag znakow i czeka na zakoncznie poprzez klawisz enter
        //moge wykorztac do liczba metode nextInt() lub nextDouble()`

        System.out.println("Witaj "+ imie2);


        /*
        System.out.println("\n"+"-x-");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Podaj imie:");
            String imie = br.readLine();

            System.out.println("Podaj wiek: ");
            int wiek = Integer.parseInt(br.readLine());//wczytuje standardowo String dzieki wiec
             //musze uzyc klasy oslonowej Integer z metoda paraseInt() aby zapisac do zmiennej int

            System.out.println("Podaj cyfre od 0 do 9: ");
            String l = br.readLine();
            int liczba2 = 0;
            if(l.length()==1&&Character.isDigit(l.charAt(0))){
                //Character.isDigit() - sprawdza czy znak jest liczba
                //nazwaZmiennejString.charAt(index) - pokazuje znak z konkretnej pozycji
                System.out.println("podales cyfre!");
                liczba2 = Integer.parseInt(l);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("blad numeru: "+ ex.getMessage());
        }
        catch (IOException ex){
            System.out.println("blad wprowadznia: "+ ex.getMessage());
        }
        */


    }

}
