package SamouczekProgramisty.Zadania._2_Modyfikatory_Dostepu;

public class KontoBanowe implements Konto {
    private int srodki = 0;

    public int pokazSrodki(){
        return srodki;
    }

    @Override
    public void dodajPieniadze(int wartosc) {
        if(wartosc<=0)
            throw new IllegalArgumentException("wartosc musi byc wieksza od 0");
        else
            srodki+=wartosc;
    }

    @Override
    public void wyplac(int wartosc) {
        if(srodki<wartosc || wartosc<=0)
            throw new IllegalArgumentException("za mala ilosc srodkow");
        else
            srodki-=wartosc;
    }
}
