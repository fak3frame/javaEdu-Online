package PrzydatneKlasy;

import java.util.StringJoiner;

public class String_Joiner {
    public static void main(String[] args) {
        /*
        StringJoiner rozwiazuje problem ze StringBuilder/Buffer koliduje
        z wyrazeniami lambda oraz programowniem funckjnym

        StringJoiner upraszcza laczenie Stringow
         */
        StringJoiner joiner = new StringJoiner("");
        //musi byc cos w konstruktorze StringJoinera

        String napis = joiner.add("napis").add(" napis2").toString();

    }
}
