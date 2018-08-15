package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner wczytaj = new Scanner(System.in);
        List<String> listaSlow = new LinkedList<>();
        while (true) {
            String noweSlowo = wczytaj.nextLine();
            if (noweSlowo.equals("-")) {
                break;
            } else
                listaSlow.add(noweSlowo);
        }
        listaSlow.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Comparator<String> sort = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };
        listaSlow.sort((wyraz1, wyraz2) -> {
                    if (wyraz1.length() > wyraz2.length())
                        return -1;
                    if (wyraz1.length() < wyraz2.length())
                        return 1;
                    else
                        return 0;
                }
        );
        for(String x : listaSlow){
            System.out.println(x);
        }
    }
}
