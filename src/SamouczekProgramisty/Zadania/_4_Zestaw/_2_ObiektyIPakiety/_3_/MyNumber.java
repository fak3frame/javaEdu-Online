package SamouczekProgramisty.Zadania._4_Zestaw._2_ObiektyIPakiety._3_;

public class MyNumber {
    private int a;

    public MyNumber(int a){
        this.a=a;
    }

    public boolean isOdd() {
        return ! isEven();
    }
    public boolean isEven(){
        return a%2==0;
    }
    public double sqrt(){
        return Math.sqrt(a);
    }
    public double pow(MyNumber x){
        return Math.pow(a,x.a);
    }
    public int add(MyNumber x){
        return a+x.a;
    }
    public int subtract(MyNumber x){
        return a-x.a;
    }


}
