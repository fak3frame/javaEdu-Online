package SamouczekProgramisty.Zadania._4_Zestaw._3_Tablice;

import java.util.Arrays;

public class Tablice {
    public String[] litery(){
        return new String[]{"a","b","c","d","e"};
    }
    public static String[] odwrocTab(String[] tab){
        String[] tmp = new String[tab.length];
        int conuter = tab.length-1;
        for (int i = 0; i < tab.length ; i++) {
            tmp[i] = tab[conuter];
            conuter--;
        }
        return tmp;
    }

    public static void main(String[] args) {
        String[] imiona = {"kamil","tomek","daniel","pawel"};
        imiona = odwrocTab(imiona);
        System.out.println(Arrays.toString(imiona));
    }
}
