package SamouczekProgramisty.Zadania._4_Zestaw._5_TypyProste;

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
    public void sortujTablice(int[] x){
        int licznik = x.length;
        while (licznik>0){
            if(x[licznik]>x[licznik+1]){
                int tmp=x[licznik];
                x[licznik]=x[licznik+1];
                x[licznik+1]=
            }
        }
    }

    public static void main(String[] args) {
        naBinarny(28);
    }
}
