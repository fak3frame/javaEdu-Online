package PrzydatneKlasy;

public class StringBuilderBuffer {
    public static void main(String[] args) {
        /*
        kazda modyfikacja stringa to tworznie nowgo obiektu

        String s = "123";
        String s2 = "123"+s;
        w przypadu polaczenia stringow +, najpierwsz tworzy sie
         obiekt StringBuilder, nastepnie dodawany jest ciag poprzez
         .append(nowaWartosc) a nastepnie zamieniony na stringa .toString() na
         obiekcie stringBuildera

         String s = "Kasia";
         s = s+" i Tomek"; // to tak naprawde:
         s = new StringBuilder(s).append(" i Tomek").toString();
         */

         //aby usprawnic mozemy recznie dodac metode toString() po zakonczemniu operacji dodawania
        String s = "napis";
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<1000; i++)
            sb.append("a");
        s = sb.toString();
        System.out.println(s);

        //StringBuffer jest klasa synchronizowana (wolniejsza od Stringbuildera w przypadku
        // dodawania ciagow znakow

    }
}
