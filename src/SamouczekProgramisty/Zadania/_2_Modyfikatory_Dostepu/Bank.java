package SamouczekProgramisty.Zadania._2_Modyfikatory_Dostepu;

public class Bank implements Przelew {
    public final int PROWIZJA = 1;

    public KontoBanowe zalozKonto(){
        return new KontoBanowe();
    }

    @Override
    public void wykonajPrzelew(KontoBanowe zKad, KontoBanowe doKad, int wartosc) {
        zKad.wyplac(wartosc+1);
        doKad.dodajPieniadze(wartosc);
    }
}
