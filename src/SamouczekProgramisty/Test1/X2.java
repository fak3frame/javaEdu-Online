package SamouczekProgramisty.Test1;

public class X2 extends X1 implements Rideable {
    int xx2;
//    public X2(int xx2) {
//        super(213,21);
//        this.xx2=xx2;
//    }
    public void metoda(){
        xx2++;
        System.out.println(xx2);
    }
    int weight = 2;
    public String getGait() { return " mph, lope"; }
    void go(int speed) {
        ++speed; weight++;
        int walkrate = speed * weight;
        System.out.print(walkrate + getGait());
    }
}
