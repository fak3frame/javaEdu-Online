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
        System.out.println("-1-");
        Punkt punkt1 = new Punkt();
        punkt1.wspX = 10;
        punkt1.wspY = 20;
        System.out.println("Wspolrzedne punktu to: "+punkt1.wspX+" "+punkt1.wspY);

        System.out.println("\n"+"-2-"); //wlasciwy sposob dostepu do pol (zapis odczyt)
        Punkt punkt2 = new Punkt();
        punkt2.ustawX(10);
        punkt2.ustawY(20);
        System.out.println("Wspolrzedne punktu to: "+punkt2.dajX()+" "+punkt2.wspY);

        System.out.println("\n"+"-3-");
        int[][] punkty = new int[3][2];
        punkty[0][0] = 1;
        punkty[0][1] = 5;
        punkty[1][0] = 2;
        punkty[1][1] = 6;
        punkty[2][0] = 3;
        punkty[2][1] = 7;
        Punkt[] punktyKlasy = new Punkt[3];

        for(int i = 0; i < punkty.length; i++){
            punktyKlasy[i]=new Punkt();
            punktyKlasy[i].ustawX(punkty[i][0]);
            punktyKlasy[i].ustawY(punkty[i][1]);
        }
        int i = 0;
        for(Punkt x : punktyKlasy){
            System.out.println("Punkt "+i+" x: "+x.dajX()+" y: "+x.dajY());
            i++;
        }


    }
}

class Punkt{
    int wspX;
    int wspY;
    void ustawX(int x){
        this.wspX = x;
    }
    void ustawY(int y){
        this.wspY = y;
    }
    int dajX(){
        return wspX;
    }
    int dajY(){
        return wspY;
    }
}
