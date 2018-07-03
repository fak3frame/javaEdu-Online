package SamouczekProgramisty.Test1;

public class X2 extends X1 {
    int xx2;
    public X2(int xx2) {
        super(213,21);
        this.xx2=xx2;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("for i zew: "+i);
            for (int j = 0; j < 3; j++) {
                System.out.println("FOR J WEW "+j);
                if(i == 1){
                    break;
                }
            }
        }

    }
}
