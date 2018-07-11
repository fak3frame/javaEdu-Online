package SamouczekProgramisty.Zadania._7_Serializacja;

import java.util.Calendar;

public class Czlowiek2 {
    String imie;
    int wiek;
    Czlowiek2(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }



    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        Czlowiek2 c1 = new Czlowiek2("kamil",27);
        Czlowiek2 c2 = new Czlowiek2("tomek",29);

    }
}
