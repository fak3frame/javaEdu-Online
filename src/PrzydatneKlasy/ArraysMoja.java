package PrzydatneKlasy;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMoja {
    public static void main(String[] args) {
        /*
        Klase Arrays mozemy uzyc jesli chcemy skorzystac i metod
         sortowania na naszych tablicach. Sa one w wersji statycznej

        Aby sortowac obiekty, klasa musi implementowac interfejs
         Comparable oraz posiadac deklaracje metody compareTo()
         porownujaca 2 obiekty

        Klasa Arrays posiada takze metodaZwykla asList() ktora zwraca
         tablice w formie listy

        Najpopulrniejsze metody:
        -asList();
        -binarySearch();
        -equals(); porownuje dwie tablice dowolnych typow
        -fill(); metodaZwykla pozwala uzupelnic tablice paramtrem podanym
         w tej metodzie
        -sort();
        */
        Pracownik krzysiek = new Pracownik("Krzysiek", "Piotrowicz", 2000);
        Pracownik piotrek = new Pracownik("Piotrek", "Wolny", 3000);
        Pracownik kasia = new Pracownik("Kasia", "Krotwicka", 2500);
        Pracownik wlodek = new Pracownik("Wlodek", "Zieba", 2300);

        Pracownik[] pracownicy = {krzysiek,piotrek,kasia,wlodek};
        //uzupelniam tablice obiektami
        mojKomparator komp = new mojKomparator();
        //tworze obiekt komparatora ktory bedzie potrzebny w sortowniu
        Arrays.sort(pracownicy, komp);
        //wywoluje metode sort ktora zmodyfikowalem dla wartosci wyplaty
        pokazPracownikowPosortowanych(pracownicy);
        //wyswietlam pracownikow z tablicy za pomoca metody toString z klasy Pracownik

    }

    //metodaZwykla wyświetlajca tablicę w ładnej formie
    public static void pokazPracownikowPosortowanych(Pracownik[] pracownicy){
        for(Pracownik p : pracownicy){
            System.out.println(p);
        }
    }
}

class Pracownik {
    private String imie;
    private String nazwisko;
    private double wyplata;

    public Pracownik(String imie, String nazwisko, double wyplata){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    String getImie(){ return imie; }
    String getNazwisko(){ return nazwisko; }
    double getWyplata(){ return wyplata; }

    public String toString() {
        return "Imię: "+imie+", Nazwisko: "+nazwisko+", Wypłata: "+wyplata;
        //naspisuje metode toString aby wyswietlajac obiekt bezposrenio
        // mogl widziec co zawiera
    }
}
class mojKomparator implements Comparator<Pracownik>{
    //do sortowania musze stworzyc wlasny komparator implementujacy
    // interfejs Comparator z typ generycznym mojej klasy
    public int compare(Pracownik o1, Pracownik o2){
        //musze stworzyc deklaracje metody compare przyjmujaca dwa
        // obiekty
        if(o2 == null) return -1;
        //najpierw sprawdzam czy drugi obiekt jest pusty
        if(o1.getWyplata() > o2.getWyplata()) return 1;
        //jesli nie to czy wybrana wartosc 1 obiektu jest wieksza
        // od tej samej wartosci drugiego obiektu i jesli tak to
        // zwracam 1
        else if(o1.getWyplata() < o2.getWyplata()) return -1;
        //w przeciwnym wypadku -1
        else return 0;
        //jesli zaden warunek nie jest prawdziwy zwracam 0 co znaczy
        // zeby nie sortowac drugiego obiektu z 1
    }
}