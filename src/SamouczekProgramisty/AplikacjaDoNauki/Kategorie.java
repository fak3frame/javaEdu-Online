package SamouczekProgramisty.AplikacjaDoNauki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kategorie{

    protected String nazwa;
    protected String lokalizacjaPliku;


    Map<Integer, List<String>> zadania = new HashMap<>();
    List<String> zadanieLinie = new ArrayList<>();
    List<String> odpowiedziLinie = new ArrayList<>();

    String linia;
    int startCounter = 0;
    int counter = 0;
    int liczbaZadan = 0;

    boolean odpowiedzSwitch = true;

    Pattern wzorNumeru = Pattern.compile("\\d+\\.");
    Pattern wzorOdpowiedzi = Pattern.compile("Odpowiedz:");
    Matcher dopasowanieNumeru;
    Matcher dopasowanieOdpowiedzi;

    public Map<Integer, List<String>> start(){

        try(BufferedReader czytacz = new BufferedReader(new FileReader(lokalizacjaPliku))){
            while ((linia = czytacz.readLine()) != null){
                dopasowanieNumeru = wzorNumeru.matcher(linia);
                dopasowanieOdpowiedzi = wzorOdpowiedzi.matcher(linia);

                if(!dopasowanieNumeru.matches()){
                    if(!dopasowanieOdpowiedzi.matches() && odpowiedzSwitch){
                        //System.out.println("weszlo");
                        //System.out.println(linia);
                        startCounter = 1;
                        zadanieLinie.add(linia);
                    }
                    else{
                        //System.out.println(linia);
                        odpowiedzSwitch = false;
                        odpowiedziLinie.add(linia);
                    }
                }

                if (dopasowanieNumeru.matches() && startCounter ==1){
                    counter++;
                    liczbaZadan++;
                    zadania.put(counter, zadanieLinie);
                    counter++;
                    zadania.put(counter, odpowiedziLinie);
                    odpowiedzSwitch = true;
                    zadanieLinie = new ArrayList<>();
                    odpowiedziLinie = new ArrayList<>();
                }
            }
            zadania.put(++counter, zadanieLinie);
            zadania.put(++counter, odpowiedziLinie);
            liczbaZadan++;


            System.out.println();

        }catch (FileNotFoundException e){
            System.out.println("nie znaleziono pliku");
        }catch (IOException e){
            System.out.println("Blad wejscia");
        }

        return zadania;
    }
}
