package SamouczekProgramisty.Zadania._2_Modyfikatory_Dostepu;

public class Test {
    public static void main(String[] args) {
        KontoBanowe k1 = new KontoBanowe();
        KontoBanowe k2 = new KontoBanowe();
        k1.dodajPieniadze(100);
        k2.dodajPieniadze(200);
        k1.wyplac(20);//80
        //k1.wykonajPrzelew(k1,k2,100);
        k1.wykonajPrzelew(k1,k2,50);//30-1/250
        System.out.println(k1.pokazSrodki());
        System.out.println(k2.pokazSrodki());
    }
}
