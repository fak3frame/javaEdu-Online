package SamouczekProgramisty.Zadania._6_TryWithRescources;

public class Fabryka {
    public static void main(String[] args) {
        try (
                HtmlTag h1 = new HtmlTag("h1");
                HtmlTag em = new HtmlTag("em")
        ) {
            em.body("moj tekst");
        }
        HtmlTag h1 = new HtmlTag("123");
        System.out.println(h1.zmiennaStatic);
        h1.zmiennaStatic = 200;
        System.out.println(h1.zmiennaStatic);
    }

}
