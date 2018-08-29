package _1_Obiekty;

import java.util.List;

public class Polimorfizm {
    public static void main(String[] args) {
        //Przyklad:
        String s1 = new String("napis1");
        Object o1 = new String("napis2");

        X[]tab = new X[2];
        tab[0] = new X1();
        tab[1] = new X2();

        for(X x : tab){
            x.zrobCos();
        }


        //---------2---------
        A obiekt = new B(); //przypisuje obiekt B do referecji typu A
        obiekt.x();//metodaZwykla wspolna
        //obiekt.y(); blad poniewaz refencja wskazyje na klase w ktorej
        // nie ma tej metody, mozna wykorzystac rzutowanie
        ((B)obiekt).y();


        //------Klasy abstrakcyjne----------
        /*
        -moga zawierac metody abstrakcyjne (takie ktore klasy dziedziczace
          musza implementowac)
        -moga zawierac stale (public static final)
        -moga zawierac swoje metody
        -metody abstrakcyjne nie moga byc statyczne poniewaz nie podiadaja
          implementacji
        -nie da sie tworzyc ich instacji
        */
    }
}
interface X{
    public void zrobCos();
}
class X1 implements X{
    @Override
    public void zrobCos() {
        System.out.println("X1");
    }
}
class X2 implements X{
    @Override
    public void zrobCos() {
        System.out.println("X2");
    }
}
class XListy {
    public void doSomething1(List<String> list) {
        //Dzieki zastosowaniu List a nie ArrayList mam zabezpeczenie gdybym chcial
        // wyslac do niej ArrayList lub LinkedList
    }
}
//---------2---------
interface A{
    public void x();
}
class B implements A{
    @Override
    public void x() {

    }
    public void y(){

    }
}

//------Klasy abstrakcyjne----------
abstract class Emeryt{
    public static final int ILOSC_OCZU = 2;//stala
    public abstract String krzyczNaDzieci();
    //metodaZwykla abstrakcyjna bez ciała
    public void biegnijDoKlepiu(int odleglosc, int predkosc){
        double czas = (double)odleglosc / predkosc;
        System.out.println("czas: "+czas);
    }
}
class Dziadek extends Emeryt{
    @Override
    public String krzyczNaDzieci() { //musze zaimplementowac
        return null;
    }

    @Override
    public void biegnijDoKlepiu(int odleglosc, int predkosc) {
        //moge ja nadpisac

        super.biegnijDoKlepiu(odleglosc, predkosc);
        //wywoluje metode klasy abstrakcyjnej bez jej zmiany
    }
}