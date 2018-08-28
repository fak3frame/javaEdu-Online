package SamouczekProgramisty.WzorceProjektowe.Budowniczy;

public class Fabryka {
    public static void main(String[] args) {
        Samochod s1 = new Samochod.Budowniczy("Audi")
                .kolor("Niebieski")
                .moc(250)
                .buduj();
        System.out.println(s1);
    }
}
