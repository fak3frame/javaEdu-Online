package SamouczekProgramisty.Test1;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        int liczbaLos = r.nextInt(2);
        System.out.println(liczbaLos);
    }
}
