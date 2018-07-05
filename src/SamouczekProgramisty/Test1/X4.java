package SamouczekProgramisty.Test1;

public class X4<T extends iX> {
    private T o1;
    public X4(T o1){
        this.o1=o1;
        System.out.println(o1.dajNapis());
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
        iX x = o.o1;
        System.out.println(x.dajNapis());
        Object x2 = o.o1;
    }
    public void dajNapisObiektu(X4<? extends iX>o){

    }

    public static void main(String[] args) {
        X4<?> test = new X4<>(new XimplementsiX());
    }
}
