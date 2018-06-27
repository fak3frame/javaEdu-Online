package SamouczekProgramisty.Zadania._4_Zestaw._4_Petle;

public class ArrayFactory {
    int x;
    public ArrayFactory(int x){
        this.x=x;
    }

    public int[] oneDimension(){
        return new int[x];
    }
    public int[][] twoDimension(){
        return new int[x][x];
    }
    public static void liczbaOdTylu(int x){
        String s = x+"";
        for (int i = s.length()-1; i>=0; i--) {
            System.out.println(s.charAt(i));
        }
    }
    public static void printCharPerLine(int number) {
        while (number > 0) {
            int reminder = number % 10;
            number /= 10;
            System.out.println(reminder);
        }
    }
    public static String odwrocNapis(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public static String odwrocNapis2(String s){
        String sTemp = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            sTemp= sTemp+s.charAt(i);
        }
        return sTemp;
    }
    public static String odwrocNapis3(String s){
        char[] tab = s.toCharArray();
        String sReturn = "";
        for (int i = tab.length-1; i >= 0; i--) {
            sReturn += tab[i];
        }
        return sReturn;
    }

    public static void main(String[] args) {
        liczbaOdTylu(123);
        System.out.println();
        printCharPerLine(123);
        System.out.println();
        System.out.println(odwrocNapis("kamil"));
        System.out.println(odwrocNapis2("kamil"));
        System.out.println(odwrocNapis3("kamil"));
    }
}
