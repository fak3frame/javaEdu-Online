package SamouczekProgramisty.Zadania._2_Modyfikatory_Dostepu;

public class KontoBanowe implements Konto,Przelew {
    private int srodki;
    private final int PROWIZJA = 1;

    @Override
    public void dodajPieniadze(int wartosc) {
        srodki+=wartosc;
    }

    @Override
    public void wyplac(int wartosc) {
        srodki-=wartosc;
    }

    @Override
    public void wykonajPrzelew(KontoBanowe zKad, KontoBanowe doKad, int wartosc) {
        if(wartosc > (zKad.srodki+PROWIZJA))
            throw new IllegalStateException("za malo pieniedzy");
        else{
            zKad.wyplac(wartosc+PROWIZJA);
            doKad.dodajPieniadze(wartosc);
        }

    }
    public int pokazSrodki(){
        return this.srodki;
    }
}
