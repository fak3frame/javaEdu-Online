package SamouczekProgramisty.AplikacjaDoNauki.KategorieData;

import SamouczekProgramisty.AplikacjaDoNauki.Kategorie;

import java.util.List;
import java.util.Map;

public class Strumienie extends Kategorie {
    public Strumienie() {
        nazwa = "Strumienie";
        lokalizacjaPliku = "src/SamouczekProgramisty/AplikacjaDoNauki/KategorieData/Strumienie.txt";
    }

    @Override
    public Map<Integer, List<String>> start() {
        return super.start();
    }
}
