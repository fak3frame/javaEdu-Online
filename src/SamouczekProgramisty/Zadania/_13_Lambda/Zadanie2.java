package SamouczekProgramisty.Zadania._13_Lambda;

import java.util.Objects;
import java.util.function.*;

public class Zadanie2 {
    public static int metoda(){
        return 10;
    }
    public static void main(String[] args) {
        /*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        Supplier<Object> supplier1 = Object::new;

        ToIntFunction<Tmp> intSupplier = Tmp::metodaTmp;
        Tmp tmp = new Tmp();
        //ToIntFunction<Tmp> intFunction = tmp::metodaTmp;

        Tmp z2 = new Tmp();
        IntSupplier intSupplier1 = z2::metodaTmp;
        IntSupplier intSupplier2 = Tmp::metodaTmpStatic;
        */
        Object object = new Object();
        Predicate<Object> predicate = object::equals;
        //boolean test (T t)
        BiPredicate<Object, Object> biPredicate = Object::equals;
        //boolean test (T t, R r)


    }
}
/*
class Tmp{
    int x;
    public  Tmp(){}
    public Tmp(int x){this.x = x;}
    public int metodaTmp(){
        return 10;
    }
    public static int metodaTmpStatic(){
        return 11;
    }
}
*/
