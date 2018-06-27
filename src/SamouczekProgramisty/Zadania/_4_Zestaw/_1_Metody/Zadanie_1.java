package SamouczekProgramisty.Zadania._4_Zestaw._1_Metody;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Zadanie_1 {
    public static void main(String[] args) {
        System.out.println(dajWiek());
        System.out.println(dajImie());
        kalkulator(10,3);
        System.out.println(czyParzysta(9));
        System.out.println(czyPodzielna3i5(9));
        System.out.println(potegaX3(2));
        System.out.println(pierwiastek(9));
        System.out.println(czyKwadratProst(3,4,5));

    }
    public static int dajWiek (){
        return 27;
    }
    public static String dajImie(){
        return "Kamil";
    }
    public static void kalkulator(int a, int b){
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
    }
    public static boolean czyParzysta(int a){
        return a%2==0;
    }
    public static boolean czyPodzielna3i5(int a){
        return a % 3 == 0 && a % 5 ==0;
    }
    public static double potegaX3(int a){
        return Math.pow(a,3);
    }
    public static double pierwiastek(int a){
        return Math.sqrt(a);
    }
    public static boolean czyKwadratProst(int a, int b, int c){
        int[] boki = new int[]{a,b,c};
        Arrays.sort(boki);
        return (Math.pow(boki[0],2)+Math.pow(boki[1],2))==Math.pow(boki[2],2);
    }
}
