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

        StringBuilder sb2 = new StringBuilder(12);
        sb.ensureCapacity(13);//z zakresem 16/34/dokladnym
        sb.append("123").append("123");
        sb.replace(0,1,"123");
        sb.insert(0, "123");
        sb.reverse();
        sb.delete(0,1);
        int i4 = sb.indexOf("x");
        int i5 = sb.capacity();
        int i6 = sb.length();
        char c = sb.charAt(0);
        String str2 = sb.substring(1);
        String strS = sb.toString();

    }
}
