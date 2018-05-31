package _1_Obiekty;

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