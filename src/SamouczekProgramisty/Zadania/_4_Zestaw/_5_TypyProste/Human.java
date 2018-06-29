package SamouczekProgramisty.Zadania._4_Zestaw._5_TypyProste;

import java.util.Arrays;

public class Human {

    private Integer wiek;
    private Integer waga;
    private Integer wzrost;
    private String imie;
    private Character plec;

    public Integer getWiek(){
        return wiek;
    }
    public Integer getWaga(){
        return waga;
    }
    public Integer getWzrost(){
        return wzrost;
    }
    public String getImie(){
        return imie;
    }
    public Character getPlec(){
        return plec;
    }

    public static void naBinarny(Integer x){
        String out = "";
        while (x>0){
            out+=x%2;
            x/=2;
        }
        System.out.println(new StringBuilder(out).reverse());
    }
    public static void sortujTablice(int[] x){
        int licznik = x.length-1;
        while (licznik>0){
            for (int i = 0; i < licznik; i++) {
                if()
            }
        }
    }

    public static void main(String[] args) {

        naBinarny(28);

        int[] tab = new int[]{1,5,7,2,5,3,6,8};
        sortujTablice(tab);
        System.out.println(Arrays.toString(tab));
    }
}
