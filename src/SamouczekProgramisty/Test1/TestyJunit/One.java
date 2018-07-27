package SamouczekProgramisty.Test1.TestyJunit;

public class One {
    private int a,b;

    public One(int a, int b) {
        if(a>b)
            throw new IllegalArgumentException("dolny przedzial jest wiekszy niz gorny!");
        this.a = a;
        this.b = b;
    }

    public boolean czyJestWPrzedziale(int liczba){
        if(liczba>a && liczba<b)
            return true;
        else return false;
    }
}
