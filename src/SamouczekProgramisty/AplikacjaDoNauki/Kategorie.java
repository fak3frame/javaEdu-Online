package SamouczekProgramisty.AplikacjaDoNauki;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

public class Kategorie{
    protected String nazwa;
    protected String lokalizacjaPliku;
    public void start(){
        try(BufferedReader czytacz = new BufferedReader(new FileReader(lokalizacjaPliku))){
            Map<Integer, String> zadania = new HashMap<>();
            System.out.println("X");
            String line;

            while((line = czytacz.readLine()) != null){
                while ((line = czytacz.readLine())=)
            }

        }catch (FileNotFoundException e){
            System.out.println("nie znaleziono pliku");
        }catch (IOException e){
            System.out.println("Blad wejscia");
        }

    }

}
