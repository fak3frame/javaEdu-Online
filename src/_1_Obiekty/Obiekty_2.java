package _1_Obiekty;

import java.util.Objects;

public class Obiekty_2 {
    public static void main(String[] args) {
        //------------Metoda hashCode()----------------------

        System.out.println("\n"+"Metoda hashCode()");
        /*
        Metoda hashCode() służy do zwrócenia unikalnej wartości liczbowej
         (typu int) dla każdego unikalnego obiektu. Gdy poruwnuje dwa
         obiekty za pomoca metody equals() i zwraca true znaczy ze metoda
         hashCode() powinna zwraca taka sama wartosc.

        Metoda hashCode jest dziedziczona z klasy Object i jesli jej nie
         nadpiszemy to zwroci ona rozne wartosci dla identycznych pod wzgledem
         wartosci pol obiektow!

        Sluzy ona do wylicznia zwracanej wartosci adresu obiektu. ta sama wartosc
         jest wykorzystywana w toString ale w postaci szesnastkowej

        Deklaracja metody equals - public boolean equals(Object o)

        W tej metodzie musze sprawdzicz czy wywoluje ja na tym samym obiekcie
         if(this == o){
            return true;
         }

        Musze takze sprawdzic czy sa tej samej klasy lub czy sprawdzam obiekt z
         obiektem pustym
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Przydatne jest tez rzutownie w finalnym sprawdzeniu poniewaz metoda
         przyjmuje obiekt klasy Object a wiemy juz ze jest on tej samej klasy
         co obiekt na ktorym ja wywolujemy
        Product product = (Product) o;

        Na koncu sprawdznie
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
            return Objects.hash(name, price, numer);
        }
        */
        Product prod1 = new Product("Czekolada", 2.99);
        Product prod2 = new Product("Czekolada", 2.99);
        System.out.println(prod1.equals(prod2)); //pokaze ze sa rowne po deklaracji
        System.out.println(prod1.hashCode());
        System.out.println(prod2.hashCode());
    }
}
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