package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

import java.util.*;

public class Sortowanie {
    Scanner sc = new Scanner(System.in);
    List<String> wyrazy = new LinkedList<>();

    public Sortowanie(){
        dodajWyrazy();
        pokazWyrazy();
        System.out.println("Po sortowaniu:");
        sortujWyrazy();
        pokazWyrazy();
    }

    public void dodajWyrazy(){
        String napis;
        while (true){
            napis = sc.nextLine();
            if(!napis.equals("-"))
                wyrazy.add(napis);
            else
                break;
        }
    }

    public void pokazWyrazy(){
        for(String x : wyrazy){
            System.out.println(x);
        }
    }

    public void sortujWyrazy(){
        Collections.sort(wyrazy, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())
                    return 1;
                else if(o1.length()<o2.length())
                    return -1;
                else
                    return 0;
            }
        });
    }

    public static void main(String[] args) {

        Sortowanie s = new Sortowanie();
    }
}
