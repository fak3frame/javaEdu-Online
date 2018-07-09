package SamouczekProgramisty.Zadania._6_TryWithRescources;

public class Fabryka {
    public static void main(String[] args) {
        try (
                HtmlTag h1 = new HtmlTag("h1");
                HtmlTag em = new HtmlTag("em")
        ) {
            em.body("moj tekst");
        }

    }
}
