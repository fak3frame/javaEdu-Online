package PrzydatneKlasy;

import java.util.StringJoiner;

public class String_Joiner {
    public static void main(String[] args) {
        /*
        StringJoiner rozwiazuje problem ze StringBuilder/Buffer koliduje
         z wyrazeniami lambda oraz z programowniem funckjnym

        StringJoiner upraszcza laczenie Stringow
         */
        StringJoiner joiner = new StringJoiner("");
        //musi byc cos w konstruktorze StringJoinera

        String napis = joiner.add("napis").add(" napis2").toString();
        //operacje dodawania metoda .add("")
        //moge przypisac do Stringa uzywajac na koncu metody .toString();

        /*
        StringJoiner przyda się szczególnie wtedy, gdy będziemy chcieli
         połączyć kilka napisów i dodatkowo rozdzielić je jakimś separatorem



         */

    }
}
