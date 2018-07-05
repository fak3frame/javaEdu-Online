package SamouczekProgramisty.Test1;

public class X1 <T extends iX> {
    private int xx1;
    private T zmienna;
    public X1(){

    }
    public X1(T zmienna){
        this.zmienna=zmienna;
    }

//    public X1(int xx1){
//        this.xx1=xx1;
//    }
//    public X1(int xx1, int xx11){
//        this(xx1);
//        xx11 = xx1;
//        System.out.println("konstuktor z 1 param klasy nadrzednej");
//    }


    public String dajNapis() {
        return zmienna.dajNapis();
    }
}
