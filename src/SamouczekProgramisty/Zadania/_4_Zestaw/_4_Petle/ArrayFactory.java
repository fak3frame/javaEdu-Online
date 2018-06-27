package SamouczekProgramisty.Zadania._4_Zestaw._4_Petle;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

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
    public static int liczbaBinarna(int x){
        StringBuilder sb = new StringBuilder();
        while (x>0){
            sb.append(x%2);
            x/=2;
        }
        return Integer.valueOf(sb.reverse().toString());
    }
    public static boolean czyPalindrom(String x){
        int licznik = x.length()-1;
        for (int i = 0; i < x.length()/2; i++) {
            if(x.charAt(i)==x.charAt(licznik))
                licznik--;
            else{
                return false;
            }
        }
        return true;
    }
    public static void liczbyWTablicy(int[] tab){
        System.out.print("[");
        for (int i = 0; i < tab.length-1; i++) {
            System.out.print(tab[i]+", ");
        }
        System.out.println(tab[tab.length-1]+"]");
    }
    public static void sortujBabelkowo(int[]tab){
        int licznik = 0;
        while (licznik<tab.length){
            //System.out.println("licznik STARTOWY="+licznik);
            for (int i = 0; i<tab.length-licznik-1; i++){
                //System.out.println("i="+i);
                //System.out.println("tab[i]="+tab[i]);
                //System.out.println("tab[i+1]="+tab[i+1]);
                if(tab[i]>tab[i+1]){
                    //System.out.println("znalazlem wiekszy element");
                    int tmp = tab[i];
                    tab[i]=tab[i+1];
                    tab[i+1]=tmp;
                    //System.out.println("tab["+i+"]="+tab[i]+", tab["+(i+1)+"]="+tab[i+1]);
                }
            }
            licznik++;
        }
    }
    public static void sortujBabelkowo2(int[] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                //System.out.println("tab i["+i+"]="+tab[i]+", tab j["+j+"]="+tab[j]);
                if(tab[i]<tab[j]){
                    //System.out.println("switch");
                    int tmp = tab[j];
                    tab[j]=tab[i];
                    tab[i]=tmp;
                    //System.out.println("after switch: tab i["+i+"]="+tab[i]+", tab j["+j+"]="+tab[j]);
                }
            }
        }
    }
    public static void bubbleSort(int[] unsorted) {
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for(int i = 0; i < unsorted.length - 1; i++) {
                if(unsorted[i] > unsorted[i + 1]) {
                    int temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted[i + 1] = temp;
                    swapped = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        liczbaOdTylu(123);
        System.out.println();
        printCharPerLine(123);
        System.out.println();
        System.out.println(odwrocNapis("kamil"));
        System.out.println(odwrocNapis2("kamil"));
        System.out.println(odwrocNapis3("kamil"));
        System.out.println(liczbaBinarna(21));
        System.out.println(czyPalindrom("kauauak"));
        liczbyWTablicy(new int[]{3,4,5});

        int[]t = new int[]{2,4,1,3,7,1,23,8,4,2,89,3,46,1,5,8,56,34,23,98,5,33,63,90,25,32,76,34,89};
        int[]t2 = new int[]{2,4,1,3,7,1,23,8,4,2,89,3,46,1,5,8,56,34,23,98,5,33,63,90,25,32,76,34,89};
        int[]t3 = new int[]{2,4,1,3,7,1,23,8,4,2,89,3,46,1,5,8,56,34,23,98,5,33,63,90,25,32,76,34,89};

        long czas1 = System.currentTimeMillis();
        sortujBabelkowo(t);
        czas1 = czas1-System.currentTimeMillis();
        System.out.println("CZAS:"+czas1);

        long czas2 = System.currentTimeMillis();
        sortujBabelkowo2(t2);
        czas2 = czas2-System.currentTimeMillis();
        System.out.println("CZAS:"+czas2);

        long czas3 = System.currentTimeMillis();
        bubbleSort(t3);
        czas3 = czas3 - System.currentTimeMillis();
        System.out.println("CZAS:"+czas3);

        System.out.println(Arrays.toString(t));
        System.out.println(Arrays.toString(t2));
        System.out.println(Arrays.toString(t3));


    }
}
