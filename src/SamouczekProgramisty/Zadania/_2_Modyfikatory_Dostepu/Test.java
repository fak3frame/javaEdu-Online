package SamouczekProgramisty.Zadania._2_Modyfikatory_Dostepu;

public class Test {
    public static void main(String[] args) {
        Bank b = new Bank();
        KontoBanowe k1 = b.zalozKonto();
        KontoBanowe k2 = b.zalozKonto();

        k1.dodajPieniadze(100);
        k2.dodajPieniadze(200);

        b.wykonajPrzelew(k1,k2,50);

        System.out.println(k1.pokazSrodki());
        System.out.println(k2.pokazSrodki());

    }
}
