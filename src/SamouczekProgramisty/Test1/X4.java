package SamouczekProgramisty.Test1;

public class X4<T extends iX> {
    private T o1;
    public X4(T o1){
        this.o1=o1;
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

    public static void main(String[] args) {

    }
}
