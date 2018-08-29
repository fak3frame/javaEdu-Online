package SamouczekProgramisty.Test1;

public class PodsumowanieTest {

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

    public static void main(String[] args) {
        String napis = mojaStatycznaMetoda(12);
        System.out.println(napis);

        PodsumowanieTest podsumowanieTest = new PodsumowanieTest();

        podsumowanieTest.metodaZwykla();
        podsumowanieTest.mojaStatycznaMetoda(12);



    }
}
