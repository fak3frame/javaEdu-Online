package SamouczekProgramisty.Silnik;

public class SilnikMoj {
    public static void main(String[] args) {
        System.out.println("Tworze obiekt diesel diesel bezparam");
        Diesel d1 = new Diesel();
        d1.metodaDiesel();
        d1.metodaSilnik();

        System.out.println("Tworze obiekt silnik diesel bezparam");
        Silnik s1 = new Diesel();
        s1.metodaSilnik();
        ((Diesel) s1).metodaDiesel();

        System.out.println("Tworze obiekt diesel diesel param");
        Diesel d2 = new Diesel("ropa");
        d2.metodaDiesel();
        d2.metodaSilnik();

        System.out.println("Tworze obiekt silnik diesel param");
        Silnik s2 = new Diesel("ropa");
        ((Diesel) s2).metodaDiesel();
        s2.metodaSilnik();
    }
}
