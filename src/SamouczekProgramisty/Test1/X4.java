package SamouczekProgramisty.Test1;

public class X4<T extends iX> {
    private T o1;
    public X4(T o1){
        this.o1=o1;
        //System.out.println(o1.dajNapis());
    }
    public T getO1() {
        return o1;
    }
    public void setO1(T o1) {
        this.o1 = o1;
    }

    public void metoda1(X4<?>o){
        Object x = o.o1;
    }
    public void metoda2(X4<? extends iX>o){
        //Obiekt o posiada wszystkie pola swojego typu
        // (klasy ktoryej jest typem - X4)
        System.out.println(o1.dajNapis());
        //Metoda nie jest statyczna wiec moge sie odwolac besposrenio
        // do metody na po obiekcie o !!

        Object x2 = o.o1;
        iX x = o.o1;

        System.out.println(x.dajNapis());
        //XimplementsiX x4 = o.o1;
        //XextendsXimplementsiX x5 = o.o1;
        //<? extends iX> moze przyjac wszystko co dziedziczy int. iX
        // lecz przyjety obiekt moze byc teoretycznie tylko intefacu iX
        // badz nizej (tylko klasa Object) - kompilator nie wie czy
        // uzytkownik nie wysle typu wyzej niz bedzie przypisanie


    }
    public void dajNapisObiektu(X4<? extends iX>o){

    }

    public static void main(String[] args) {
        X4<?> test = new X4<>(new XimplementsiX());
        test.metoda2(test);
        X4<XextendsXimplementsiX> test2 = new X4<>(new XextendsXimplementsiX());
        test2.metoda2(test2);
    }
}
