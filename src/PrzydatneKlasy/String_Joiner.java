package PrzydatneKlasy;

import javafx.scene.shape.Path;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class String_Joiner {
    public static void main(String[] args) throws URISyntaxException, IOException {
        /*
        StringJoiner rozwiazuje problem ze StringBuilder/Buffer koliduje
         z wyrazeniami lambda oraz z programowniem funckjnym

        StringJoiner upraszcza laczenie Stringow
         */
        StringJoiner joiner = new StringJoiner("");
        //Konstruktor StringJoiner przyjmuje albo jeden parametr
        // będący separatorem, albo trzy argumenty (separator, prefix, sufix)
        //separator - to co oddziela nam napsy - podalem " " czyli nic spacja
        //prefix - to co bedzie na poczatku ciagu
        //sufix - na koncu ciagu
        String napis = joiner.add("napis").add("napis2").toString();
        //operacje dodawania metodaZwykla .add("")
        //moge przypisac do Stringa uzywajac na koncu metody .toString();
        System.out.println(napis);


        /*
        StringJoiner przyda się szczególnie wtedy, gdy będziemy chcieli
         połączyć kilka napisów i dodatkowo rozdzielić je jakimś separatorem
         */
        System.out.println();
        StringJoiner joiner2 = new StringJoiner(",", "{", "}");
        String result = joiner2.add("Ania").add("ma").add("kota").toString();
        System.out.println(result);


        System.out.println();
        /*
        mam do dyspozycji takie metody jak
        join(CharSequence delimiter, CharSequence... elements) oraz
        join(CharSequence delimiter, Iterable<? extends CharSequence> elements)
         */
        List<String> lista = Arrays.asList("kamil","tomek");
        //wykorzystje klase Arrays do uzupelnienia listy
        String wszystkieImiona = "";
        wszystkieImiona = wszystkieImiona.join(", ",lista);
        //pierwszy argument to separato a drugi lista
        System.out.println("wszytskie imiona: "+wszystkieImiona);
        //taka metodaZwykla jest niezbyt dobra poniewaz najpierw musze zainicjowac
        // pustego stringa


        /*
        najbardziej optymalna jest opcja dodania strumieni oraz Collctorow

        Polega to na wyciagnieciu z listy strumienia a nastepnie wykorzystac metode
         collect() do zlaczenia napisow. Wymaga ona obiektu Collector lecz mozna
         skorzystac z metody Collectors.joining() ktora zwraca odpowiedni reduktor
         wykorzystjacy pod soba StringJoiner
         */
        String noweWszystkieImiona =
                lista.stream().collect(Collectors.joining(",","{","}"));
        //w takim przypadku mozemy nawet calkowicie zrezygnowac ze zmiennej string


        /*
        calosc mozna polaczyc takze z klasa Files
         */
        String zbior = Files.lines(Paths.get(ClassLoader.getSystemResource("plik.txt").toURI()))
                .filter(str->str.length()>3)
                .collect(Collectors.joining(", ","{","}"));
        //w tym przypadku odczytuje z pliku ciagi znakow linia po lini o odrzucam
        // te krotsze od dlugosci 3

    }
}
