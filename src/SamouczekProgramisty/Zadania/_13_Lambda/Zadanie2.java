package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Zadanie2 {
    public static int metoda(){
        return 10;
    }
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Supplier<Object> supplier1 = Object::new;

        ToIntFunction<Tmp> intSupplier = Tmp::metodaTmp;
        IntSupplier intSupplier1 = Zadanie2::metoda;
    }
}

class Tmp{
    int x;
    public Tmp(int x){this.x = x;}
    public boolean metodaTmp(){
        return true;
    }
}
