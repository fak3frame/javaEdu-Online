package SamouczekProgramisty.Zadania._3_Dziedzieczenie;

public class Factory {
    public static void main(String[] args) {
        Animal a1 = new Human();
        Animal a2 = new Goldfish();
        Human h1 = new Human();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(h1);
    }
}
