package PrzydatneKlasy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfaceList {
    public static void main(String[] args) {
        /*
        Jedna ze struktur danych sa listy w ktorych wyrozniamy najlpopularniejsze
         ArrayList - implemenacja tablicowa oraz LinkedList -/- dowiazana
        ArrayList uzywamy gdy mamy czesty dostep do elementow natomiast
         LikedListy gdy bedziemy czesto wynonywac operacje takie jak dodawanie
         usuwanie elementow itp

        Dobra praktyka jest deklarowanie ich jako List aby moc w przyszlosci
         podmienic implementajce
        */
        List lista1 = new ArrayList(32); // w przypadku listy tablicowej dobrze
         // jest dodac domyslny poczatkowy rozmiar
        List lista2 = new LinkedList();
        /*
        Podstawowe operacje:
        add(obj);
        remove(obj);
        remove(int);
        size();
        get(int);
        */

        List lista3 = new ArrayList<>(3);
        lista3.add("Kamil");
        lista3.add("Tomek");
        String imie = (String)lista3.get(1);//musze wykorzystac rzutowanie poniewaz
        //probowalbym przypisac Object do String
        System.out.println(imie);

        /*
        Listy sa klasami generycznymi to znaczy ze powinnismy nadac jej typ
         posiadanych zmiennych w <> - List<String> lista3 = new ArrayList<>
        Dzieki okresleniu typu listy nie bede musial uzywac rzutowania aby odwolac
         sie do elementu listy utworzonej polimoficznie
        String imie = lista3.get(1);
        */








    }
}
