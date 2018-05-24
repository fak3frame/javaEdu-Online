package _1_Obiekty;

public class Obiekty_1 {

    public static void main(String[] args) {
        //----KLASY METODY I OBIEKTY-----
        /*
        metody i pola static sa zwiazane z klasa a nie jej obiektem
        Obiekt jest naturalna reprezentacja klasy, przechowuje informacje
         o zmiennych oraz mozemy sie do nich odwolac, mozemy za pomoca
         obiektow wywolac metody jej klasy

        */
        Punkt punkt1 = new Punkt();
        punkt1.wspX = 10;
        punkt1.wspY = 20;
        System.out.println("Wspolrzedne punku to: "+punkt1.wspX+" "+punkt1.wspY);
    }
}

class Punkt{
    int wspX;
    int wspY;
}
