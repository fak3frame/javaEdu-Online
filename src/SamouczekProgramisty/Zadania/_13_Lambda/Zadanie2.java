package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

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

        IntSupplier<> intSupplier = Tmp::metodaTmp;
        System.out.println(intSupplier.getAsInt());
    }
}

class Tmp{
    int x;
    public Tmp(int x){this.x = x;}
    public int metodaTmp(){
        return 20;
    }
}
