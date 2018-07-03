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


    public static void main(String[] args) {
        new X2().go(8);
        new X2().metoda();
        for (int i = 0; i < 3; i++) {
            System.out.println("\n"+"for i zew: "+i+"\n");
            for (int j = 0; j < 3; j++) {
                System.out.println("FOR J WEW "+j);
                if(i == 1){
                    break;
                }
            }
        }

    }
}
