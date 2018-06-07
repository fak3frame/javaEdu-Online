package PrzydatneKlasy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class InterfaceMap {
    public static void main(String[] args) {
        /*
        Interfejs Map nie implementuje interfejsu Collection
        Sa w nim przechowywane elementy w postaci klucz-wartosc
         gdzie oba moga byc dowolnym typem obikeotwym
        Jako klucz moze byc przypisana tylko unikalna wartosc, gdy
         dodamy nowa, stara o takiej samej wartosci zostanie nadpisana

        HashMap (klasa) podobnie jak HashSet oparta jest o tablice
         mieszajaca przez co nie mamy ustalonej kolejnosci

        TreeMap (klasa) posiada dodatkowo sortowanie dzieki poprawnej
         implementacji interfejsu Comparable lub zdefiniowanego Comparatora

        LinkedHashMap (klasa) zapamietuje kolejnosc dodawania elementow
         co moze byc przydatne przy iteracji. Wykorzystuje tablice
         mieszajaca oraz liste wiazana

        Klasa definiujaca klucz wymaga prawidlowej implementacji equals()
         oraz hashCode();

        ROZNICE:
        HashMap posiada podstawowa implementacji, TreeMap sortuje elementu
         wedlug kluczy natomiats LinkedHashMap gdy bedziemy chcieli iterowac
         po elementach w kolejnosci w jakiej zostaly dodane

        METODY:
        Przez to ze Map nie implementuje Collection nie ma metody add();

        put(K key, V value) - wstawia do mapy wartość 'v' przypisaną do klucza 'k'
        get(Object key) - zwraca wartość przypisaną do klucza 'key' lub null jeśli
         do takiego klucza nie jest przypisana żadna wartość
        remove(Object key) - usuwa z mapy wartość przypisaną do klucza 'key'
        isEmpty() - sprawdza, czy mapa jest pusta
        size() - zwraca rozmiar (ilość elementów) mapy
        keySet() - zwraca zbiór kluczy
        values() - zwraca kolekcję wartości
        Set<Map.Entry<K,V>> entrySet() - zwraca zbiór obiektów typu Map.Entry,
         które reprezentują kolejne rekordy w mapie na zasadzie klucz-wartość

        W TreeMap znajdziemy dodatkowe metody wynikające z implementacji takie
         jak firstEntry(), czy firstKey()
         */

        Map<Integer, String> pracownicy = new TreeMap<>();
        pracownicy.put(1,"Kamil");
        pracownicy.put(1,"Kamil2");//nadpisuje
        pracownicy.put(2,"Tomek");
        pracownicy.put(3,"Tomek");//doda obu, unikalnosc id
        pracownicy.put(4,"Przemek");

        System.out.println("ilosc pracownikow: "+pracownicy.size());
        System.out.println("pracownik o id 1: "+pracownicy.get(1));
        pracownicy.remove(4);
        System.out.println("ilosc pracownikow 2: "+pracownicy.size());
        System.out.println("klucze: "+pracownicy.keySet()); //zbior kluczy w []



        //Set<Map.Entry>
    }
}
