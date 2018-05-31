package _1_Obiekty;

public class Wyjatki_3 {

    public static void main(String[] args) {
        Wyjatki_3 o = new Wyjatki_3();
        o.metoda1();
        System.out.println(".."); //tej instukcji juz nie pokaze
        /*
        Tworze stos wywolan - metody wywoluja sie wzajemnie
        W komunikacie otrzymam stos wywolan w kolejnosci od konca
        tzw. stacktrace
        */
    }
    public void metoda1(){
        metoda2();
    }
    public void metoda2(){
        metoda3();
    }
    public void metoda3(){
        throw new RuntimeException("Cos tam");
        //wyjatek ze standardowej biblioteki javy
    }
}
