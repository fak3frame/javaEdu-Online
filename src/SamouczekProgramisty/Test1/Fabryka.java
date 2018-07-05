package SamouczekProgramisty.Test1;

public class Fabryka {
    public static void main(String[] args) {

        X1<X1Rozszerzenie> xR = new X1<>(new X1Rozszerzenie());
        System.out.println(xR.dajNapis());
        X1<X31> xR2 = new X1<>(new X31());

        X3<Object> o1 = new X3<>(new Object());
        //X1 testRef = new X2();
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
