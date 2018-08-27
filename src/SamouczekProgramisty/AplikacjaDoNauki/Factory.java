package SamouczekProgramisty.AplikacjaDoNauki;

import SamouczekProgramisty.AplikacjaDoNauki.KategorieData.Strumienie;

import java.util.*;

public class Factory {

    public static void main(String[] args) {
        Strumienie s = new Strumienie();
        Map<String, Map> baza = new HashMap<>();
        baza.put(s.nazwa, s.start());

        List<String> listaCzytajaca = new ArrayList<>();

        Scanner wejscie = new Scanner(System.in);
        int przelacznik;
        String pokazOdpowiedz;
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

                System.out.println("Wybierz zadanie:"+"\n");
                listaCzytajaca = (List)baza.get("Strumienie").get(przelacznik);
                for (int i=0; i<listaCzytajaca.size(); i++){
                    System.out.println(listaCzytajaca.get(i));
                }

                System.out.println("\n"+"Wcisnij \"-\" zeby poznac odpowiedz");
                pokazOdpowiedz = wejscie.nextLine();
                if(pokazOdpowiedz.equals("-")){
                    listaCzytajaca = (List)baza.get("Strumienie").get(przelacznik+1);
                    for(int i = 0; i<listaCzytajaca.size(); i++){
                        System.out.println(listaCzytajaca.get(i));
                    }
                }

            }catch (InputMismatchException e){
                System.out.println("Zly znak");
                wejscie.next();
            }
        }
    }
}
