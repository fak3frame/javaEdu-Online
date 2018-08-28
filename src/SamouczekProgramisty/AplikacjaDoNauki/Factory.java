package SamouczekProgramisty.AplikacjaDoNauki;

import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.FactoryEntryCategory;
import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Stringi;
import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Strumienie;

import java.util.*;

public class Factory {

    public static void main(String[] args) {
        Strumienie strumienie = new Strumienie();
        Stringi stringi = new Stringi();


        Map<String, Map> baza = new LinkedHashMap<>();
        baza.put(strumienie.nazwa, strumienie.start());
        baza.put(stringi.nazwa, stringi.start());

        Scanner wejscieDoPytania = new Scanner(System.in);

        List<String> listaKategorii = new ArrayList<>();

        int przelacznikKategorii;

        int licznikKategorii;

        while (true) {
            try{
                System.out.println("\n"+"Wybierz Kategorie:");
                System.out.println("0 : Wyjscie");
                licznikKategorii=1;

                for(Map.Entry<String, Map> x : baza.entrySet()){
                    System.out.println(licznikKategorii+" : "+x.getKey());
                    licznikKategorii++;
                }
                System.out.println("licznik kategorii: "+licznikKategorii);

                przelacznikKategorii = wejscieDoPytania.nextInt();
                if(przelacznikKategorii == 0){
                    break;
                }

                for(String x : baza.keySet()){
                    listaKategorii.add(x);
                }

                FactoryEntryCategory entryCategory = new FactoryEntryCategory();
                entryCategory.entryMenu(baza.get(listaKategorii.get(przelacznikKategorii-1)));

            }catch (InputMismatchException e){
                System.out.println("Zly znak");
                wejscieDoPytania.next();
            }
        }
    }
}
