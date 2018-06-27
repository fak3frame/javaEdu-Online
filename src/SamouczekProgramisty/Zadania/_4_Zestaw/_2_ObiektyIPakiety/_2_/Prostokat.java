package SamouczekProgramisty.Zadania._4_Zestaw._2_ObiektyIPakiety._2_;

public class Prostokat {
    private int dlugosc,szerokosc;

    public int liczObwod(){
        return 2*(dlugosc+szerokosc);
    }

    public int liczPole(){
        return dlugosc*szerokosc;
    }

    public double liczPrzekatna(){
        return Math.sqrt(Math.pow(dlugosc,2) + Math.pow(szerokosc,2));
    }
}
