package SamouczekProgramisty.AplikacjaDoNauki;

import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.FactoryEntryCategory;
import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Strumienie;

import java.util.*;

public class Factory {

    public static void main(String[] args) {
        Strumienie s = new Strumienie();

        Map<String, Map> baza = new HashMap<>();
        baza.put(s.nazwa, s.start());

        List<String> listaCzytajaca = new ArrayList<>();

        Scanner wejscieDoPytania = new Scanner(System.in);
        Scanner  wejscieDoOdpowiedzi = new Scanner(System.in);

        int przelacznikKategorii;
        String przelacznikPokazOdpowiedz;
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

                przelacznikKategorii = wejscieDoPytania.nextInt();
                if(przelacznikKategorii == 0){
                    break;
                }

                FactoryEntryCategory entryCategory = new FactoryEntryCategory();
                entryCategory.entryMenu(baza.get("Strumienie"), przelacznikKategorii);

//                System.out.println("Wybierz zadanie:"+"\n");
//                listaCzytajaca = (List)baza.get("Strumienie").get(przelacznikKategorii);
//                for (int i=0; i<listaCzytajaca.size(); i++){
//                    System.out.println(listaCzytajaca.get(i));
//                }
//
//                System.out.println("\n"+"Wcisnij \"-\" zeby poznac odpowiedz");
//                przelacznikPokazOdpowiedz = wejscieDoOdpowiedzi.nextLine();
//                if(przelacznikPokazOdpowiedz.equals("-")){
//                    //listaCzytajaca = new ArrayList<>();
//                    listaCzytajaca = (List)baza.get("Strumienie").get(przelacznikKategorii+1);
//                    for(int i = 0; i<listaCzytajaca.size(); i++){
//                        System.out.println(listaCzytajaca.get(i));
//                    }
//                }

            }catch (InputMismatchException e){
                System.out.println("Zly znak");
                wejscieDoPytania.next();
            }
        }
    }
}
