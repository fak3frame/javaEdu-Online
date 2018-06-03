package _1_Obiekty;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Wyjatki_4 {
    public static void main(String[] args) {
        //LAPANIE WYJATKOW
        Wyjatki_4 o = new Wyjatki_4();
        int godziny = -3;
        int sekundy = 0;
        try{
            sekundy = o.pokazLiczbeSekund(godziny);
        }
        catch (IllegalArgumentException ex){
            sekundy = o.pokazLiczbeSekund(godziny * -1);
        }
        System.out.println(sekundy);

        /*Moge obsluzyc kilka wyjatkow w catch jesli nie sa we wspolnej klasie bazowej
           catch (IllegalArgumentException | ArithmeticException ex){}
          Wyróżniamy dwa rodzaje wyjątków, tak zwane “checked exceptions” oraz
           “unchecked exceptions”.
          checked exceptions musza byc obluzone przez programiste np IOException
          unchecked exeption to np. IllegalArgumentException

          Hierarchia dziedziczenia wyjątków Throwable <- Exception <- RuntimeException <-
          <- IllegalArgumentException

          W przypadku gdy wyjatek dziedziczy po Exception a nie ma RuntimeException jest
           wyjatkiem checked, w kazdym innym przypadku jest typu unchecked
          Wyjatki checked uzywmy gdy chcemy miec mozliwosc naprwienia bledy programie

          Wyjatki mozna obluzyc na 2 sposoby, jeden to poprzez blok try/catch a drugi
           to zepchniecie go na poziom nizej czyli do metody wywolujacej za pomoca
           klauzuli throws
        */
        try {
            o.jakasMetodaZCheckedException();
        }
        catch (IOException e){
            e.printStackTrace(); //metoda pokazuje stos wywolania
        }
        finally {
            System.out.println("to sie wykona zawsze");
        }
        /*
        Dobre praktyki:
        -blok try powinien byc jak najmniejszy - dobra czytelnosc
        -blok finally jest czesto niezbedny gdy operujemy na obiektach
        -nalezy uzywac dopasowanych klas wyjatkow do sytouacji lub stworzyc wlasba
         klase wyjatku
        -podawac szczegolowy opis przechwyconego wyjatku
        */

        //PRZYKLAD:
        System.out.println("Podaj liczbę: ");
        Scanner wczytaj = new Scanner(System.in);
        double mojaLiczba = 0;
        while (true) {
            try {
                mojaLiczba = wczytaj.nextDouble();
                break;//wyjdzie z while
            }
            catch (InputMismatchException e) {
                System.out.println("Podaj poprawną liczbę!");
                // ignoring wrong token
                wczytaj.next();
            }
        }

        if (mojaLiczba < 0) {
            throw new IllegalArgumentException(String.format("Pierwiastek kwadratowy" +
                    " z liczby rzeczywistej %.4f nie istnieje!", mojaLiczba));
            //komenda wyrzuci wyjatek i pokaz odpwoeidni komunikat
        }

        System.out.print(String.format("Pierwieastek z %.4f to %.4f.", mojaLiczba, Math.sqrt(mojaLiczba)));
    }


    public int pokazLiczbeSekund(int godziny){
        if(godziny < 0){
            throw new IllegalArgumentException("Musi byc wiecej niz 0 godzin :" + godziny);
            //wyjatek standardowej biblioteki javy
        }
        return godziny*60*60;
    }
    public void jakasMetodaZCheckedException()throws IOException{
        //ta metoda MOZE dac wyjatek checked czyli taki jaki musiby obsluzyc
        //nie obsluguje go wewnatrz
        throw new IOException();
    }
}
