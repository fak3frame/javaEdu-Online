package SamouczekProgramisty.AplikacjaDoNauki;

import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Strumienie;

import java.util.*;

public class Factory {

    public static void main(String[] args) {
        Strumienie s = new Strumienie();
        Map<String, Map> baza = new HashMap<>();
        baza.put(s.nazwa, s.start());


        Scanner wejscie = new Scanner(System.in);
        int przelacznik;
        int counter;
        while (true) {
            try{
                System.out.println("Wybierz Kategorie:");
                System.out.println("0 : Wyjscie");
                counter=1;
                for(Map.Entry<String, Map> x : baza.entrySet()){
                    System.out.println(counter+" : "+x.getKey());
                    counter++;
                }

                przelacznik = wejscie.nextInt();
                if(przelacznik == 0){
                    break;
                }
                switch (przelacznik){
                    case 1:
                        System.out.println("Wybierz zadanie:");

//                        for(Map.Entry<String, Map> x : baza.entrySet()){
//                            for(int j = 1; j <x.getValue().values().size(); j++){
//                                System.out.println(x.getValue().get(j));
//                            }
//                        }
                        List<String> xx = (List)baza.get("Strumienie").get(1);
                        System.out.println(xx.get(1));
                        System.out.println(xx.get(2));
                        System.out.println(xx.get(3));

                        System.out.println("Wcisniej enter zeby poznac odpowiedz");


                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("Zly znak");
                wejscie.next();
            }
        }
    }
}
