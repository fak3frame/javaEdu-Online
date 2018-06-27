package SamouczekProgramisty.Zadania._4_Zestaw._4_Petle;

public class Petle {
    public static void main(String[] args) {
        kolejneLiczby(10);
        System.out.println();
        kolejneLiczby2(8);
    }
    public static void kolejneLiczby(int X){
        for (int i = 0; i <= X; i++) {
            System.out.print(i+" ");
        }
    }
    public static void kolejneLiczby2(int X){
        int i = 0;
        while (X>=i){
            System.out.print(i++ +" ");
        }
    }
}
