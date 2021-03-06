package SamouczekProgramisty.Zadania._12_WyrazeniaRegularne1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class One {
    public static void main(String[] args) {
        /* ZAD 1
        Sprawdza czy liczba zmiennoprzecinkowa podana przez użytkownika
         ma poprawny format. Na przykład liczba 123,2341515132135 czy -10
         są poprawne ale 18-12 czy 123, już nie,
         */
        Pattern wzorzecZad1 = Pattern.compile("-?\\d+(,\\d+)?");


        /* ZAD 2
        Sprawdza czy numer domu jest w formacie numer\numer.
         Poprawnym numerem jest 123\2A, 24B\3 czy 12\5, ale
         już numer abc\cba nie,
         */
        Pattern wzorzecZad2 = Pattern.compile("\\d+[a-zA-Z]?\\\\\\d+[a-zA-Z]?");

        /* ZAD 3
        Sprawdza czy użytkownik wprowadził poprawną nazwę miasta.
         Na przykład Wrocław, Zielona Gora czy Bielsko-Biala jest ok,
         jednak Ptysiow123 już nie. Dla uproszczenia załóżmy, że
         żadna nazwa miejscowości nie zwiera polskich znaków.\
        */
        Pattern wzorzecZad3 = Pattern.compile("[A-Z][a-z]+([ -][A-Z][a-z]+)?");
    }
}
