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
        //Konstruktor StringJoiner przyjmuje albo jeden parametr
        // będący separatorem, albo trzy argumenty (separator, prefix, sufix)

        String napis = joiner.add("napis").add(" napis2").toString();
        //operacje dodawania metoda .add("")
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

    }
}
