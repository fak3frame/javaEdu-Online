package PrzydatneKlasy;

import java.util.Set;
import java.util.TreeSet;

public class InterfaceSet {
    public static void main(String[] args) {
        /*
        Set reprezentuje kolekcje unikalnych obiektow ale
         bez okreslenia ich kolejnosci poniewaz zalezy to
         juz od konkretnej implementacji

        Set jest typem generycznym przez co okreslamy jaki
         typ elem. bedzie przechowywal dzieki czemu unikniemy
         rzutowania

        HashSet klasa zapewniajaca unikalnosc elementow bez
         gwarancji ich kolejnosci. wewnatrz wykorzystywana jest
         tablica mieszajaca co wymaga poprawnej implementacji
         metod hashCode oraz equals()

        TreeSet jest klasa oprocz unikalnosci elementow gwarantuje
         uporzadkowanie zgodne z "naturalnym porzadkiem"
        Porzadek ten jest ustalany przez odpowiednia implementacje
         interfejsu Comparable lub zastosowanie odpowiedniego
         Comparatora

        LinkedHashSet klasa wykorzystujac tablice mieszajaca oraz
         liste podwojnie wiazana dzieki czemu zagwarantowana jest
         unikalnosc elementow oraz kolejnosc w jakiej zostaly dodane.

        HashSet jest podstawową implementacją, która zapewnia jedynie
         unikalność elementów, TreeSet gwarantuje dodatkowe sortowanie,
         a LinkedHashSet pamięta  dodatkowo kolejnoś wstawiania.

        Najważniejsze metody w interfejsie Set to odziedziczone z
         interfejsu Collection:

        boolean add(E e) - dodaje unikalny element do zbioru, w przypadku,
         gdy element się powtarza dodawanie jest ignorowane. Unikalność jest
         sprawdzana na podstawie metod hashCode() i equals(). Do zbioru można
         dodać jedną wartość null
        boolean contains(Object o) - sprawdza, czy obiekt 'o' znajduje się w zbiorze
        boolean isEmpty() - sprawdza, czy zbiór jest pusty
        Iterator iterator() - zwraca iterator. Kolejność elementów jest zależna od
         tego z jakiej implementacji korzystamy
        boolean remove(Object o) - usuwa element 'o' ze zbioru
        int size() - zwraca rozmiar (ilość elementów) zbioru

        W TreeSet mam metodę first(), która zwraca "najmniejszy" obiekt w rozumieniu
         naturalnego porządku, oraz last(), która zwraca największy z nich

         */
        Set<String> zbior = new TreeSet<>();
        zbior.add("Kamil");
        zbior.add("Tomek");
        zbior.add("Tomek");
        zbior.add("Przemek");
        zbior.add("Janusz");
        zbior.add("Janusz");

        int size = zbior.size();
        System.out.println(size);




    }
}
