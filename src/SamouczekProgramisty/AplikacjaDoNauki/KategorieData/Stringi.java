package SamouczekProgramisty.AplikacjaDoNauki.KategorieData;

import SamouczekProgramisty.AplikacjaDoNauki.Kategorie;


import java.util.List;
import java.util.Map;

public class Stringi extends Kategorie {
    public Stringi() {
        nazwa = "Stringi";
        lokalizacjaPliku = "src/SamouczekProgramisty/AplikacjaDoNauki/KategorieData/Stringi.txt";
    }

    @Override
    public Map<Integer, List<String>> start() {
        return super.start();
    }
}
