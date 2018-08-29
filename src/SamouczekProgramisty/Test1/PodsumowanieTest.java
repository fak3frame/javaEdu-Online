package SamouczekProgramisty.Test1;

public class PodsumowanieTest {

    static int a = 10;

    int xD;


    final static int liczbaX = 40;

    public static String mojaStatycznaMetoda(int liczba){
        //metodaZwykla();
        metodaStatic();


        return String.valueOf(liczba);

    }

    public int mojaZwyklAMetoda(String napis){

        metodaStatic();
        metodaZwykla();
        return Integer.parseInt(napis);
    }

    public static void metodaStatic(){

    }

    public void metodaZwykla(){

    }

    public PodsumowanieTest(){
        this(20);
    }

    public PodsumowanieTest(int xD){
        this.xD = xD;
    }

    public PodsumowanieTest(String napisXX, int liczbaXX){


    }

    public static void main(String[] args) {
        String napis = mojaStatycznaMetoda(12);
        System.out.println(napis);

        PodsumowanieTest podsumowanieTest = new PodsumowanieTest();

        podsumowanieTest.metodaZwykla();
        podsumowanieTest.mojaStatycznaMetoda(12);

        System.out.println(podsumowanieTest.a);



    }
}
