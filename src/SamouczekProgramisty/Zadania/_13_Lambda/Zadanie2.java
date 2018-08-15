package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.function.Supplier;

public class Zadanie2 {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Supplier<Object> supplier1 = Object::new;
    }
}
