package _1_Obiekty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Obiekty_2 {
    public static void main(String[] args) {
        //------------Metoda hashCode()----------------------

        System.out.println("\n"+"Metoda hashCode()");
        /*
        Metoda hashCode() służy do zwrócenia unikalnej wartości liczbowej
         (typu int) dla każdego unikalnego obiektu. Gdy porownuje dwa
         obiekty za pomoca metody equals() i zwraca true znaczy ze metoda
         hashCode() powinna zwraca taka sama wartosc.

        Metoda hashCode() jest dziedziczona z klasy Object i jesli jej nie
         nadpiszemy to zwroci ona rozne wartosci dla identycznych pod wzgledem,
         wartosci pol obiektow!

        Sluzy ona do wylicznia zwracanej wartosci adresu obiektu. ta sama wartosc
         jest wykorzystywana w toString ale w postaci szesnastkowej

        Deklaracja metody equals - public boolean equals(Object o)

        W tej metodzie musze sprawdzic:
        -czy wywoluje ja na tym samym obiekcie
         if(this == o){
            return true;
         }

        -czy sprawdzam obiekt z obiektem pustym lub czy sa tej samej klasy
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Przydatne jest tez rzutownie w finalnym sprawdzeniu poniewaz metoda
         przyjmuje obiekt klasy Object a wiemy juz ze jest on tej samej klasy
         co obiekt na ktorym ja wywolujemy
        Product product = (Product) o;                                                                                  !

        -na koncu sprawdznie
        return Double.compare(product.price, price) == 0 &&
                numer == product.numer &&
                Objects.equals(name, product.name);
        tutaj wykorzystje metode compare klasy Double w ktorej dwa przyjete argumenty
         jesli bede rowne zwroca wartosc 0 oraz metode equals klasy Objects ktorej
         rowne argumenty String zwroca true, dla sprawdzenia wartosci int mozna
         wokorzystac proste porownanie

        Podsumowujac jesli warunek return bedzie prawdziwy zwroci ture.


        Metoda hashCode ma prosta budowe
        public int hashCode() {
            return Objects.hash(name, price, numer); //zmienne do porownania
        }
        */
        Product prod1 = new Product("Czekolada", 2.99);
        Product prod2 = new Product("Czekolada", 2.99);
        System.out.println(prod1.equals(prod2)); //pokaze ze sa rowne po deklaracji
        System.out.println(prod1.hashCode());
        System.out.println(prod2.hashCode());


        //------------Wyjątki - blok try catch----------------------

        System.out.println("\n"+"Wyjątki - blok try catch");
        int[] tab = {1,2,3};
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj index tablicy 0-2");
        int index = wczytaj.nextInt();
        try{
            System.out.println(tab[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Niepoprawrny rozmiar tablicy, rozmaiar tablicy" +
                    " to : "+tab.length+", wystapil blad : "+ex.getMessage());
        }

        //z wykorzystaniem bufferedReader i pobieraniem az do skutku
        BufferedReader odczyt = new BufferedReader(new InputStreamReader(System.in));
        boolean czyPoprawne = false;
        int index2 = -1;

        while(!czyPoprawne){// dopuki nie zmieni sie z false na true lub true na false
            // w moim przypadku oczekuje zmiany na true                                                                                         !
            try{
                System.out.println("Podaj index tablicy 0-2");
                index2 = Integer.parseInt(odczyt.readLine());
                //probuje przyjac liczbe i zrzutowac ja do int
                // gdy podam np litere powstanie blad i bedzie szukalo obslugi
                // nie przypisujac zmiennej index wartosci
            }
            catch (NumberFormatException ex){
                System.out.println("Niepoprawne dane! " +
                        "\n Który element tablicy chcesz zobaczyć: ");
                //gdy podam np litere
            }
            catch (IOException ex){
                System.out.println("Błąd odczytu danych");
            }
            czyPoprawne = index2 == -1? false : true;
            //jesli index bedzie wynosil -1 (czyli pozostanie niezmieniony)
            // ustawiona zostanie wartosc false czyli nie wyjdzie z while
            //gdy try pryjmie jakas wartosc liczbowa (niewazne czy z zakresu tab)
            // to wyjdzie index zmieni wartosc przez co ustawi sie na true i wyjdzie
            // z while, kolejny blok try/catch sprawdza czy index zawiera sie przedziale
            // rozmiaru tablicy
        }
        try{
            System.out.println(tab[index2]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Niepoprawny parametr, rozmiar tablicy to: "+tab.length);
        }


        //------------Zgłaszanie wyjątków - instrukcja throw----------------------

        System.out.println("\n"+"Zgłaszanie wyjątków - instrukcja throw");



    }
}

//------------Metoda hashCode()----------------------
class Product {
    private String name;
    private double price;
    private int numer; //dla testu
    public Product() {
        this.name = "";
        this.price = 0;
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                numer == product.numer &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, numer);
    }
}

