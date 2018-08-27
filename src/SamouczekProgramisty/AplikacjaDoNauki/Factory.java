package SamouczekProgramisty.AplikacjaDoNauki;

import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Strumienie;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    public static void main(String[] args) {
        Map<Integer, Kategorie> zadania = new HashMap<>();
        zadania.put(1, new Strumienie());

    }
}
