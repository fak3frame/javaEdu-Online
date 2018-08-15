package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Zadanie3 {
    private int age;
    private String name;



    public Zadanie3(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        BiFunction<Integer, String, Zadanie3> biFunction = Zadanie3::new;
        Zadanie3 czlowiek1 = biFunction.apply(27, "kamil");

    }
}
