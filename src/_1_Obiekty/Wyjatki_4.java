package _1_Obiekty;

import java.io.IOException;

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
           catch (IllegalArgumentException || ArithmeticException ex){}
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

    }

    public int pokazLiczbeSekund(int godziny){
        if(godziny < 0){
            throw new IllegalArgumentException("Musi byc wiecej niz 0 godzin :" + godziny);
            //wyjatek standardowej biblioteki javy
        }
        return godziny*60*60;
    }
    public void jakasMetodaZCheckedException()throws IOException{
        //ta metoda wyrzuca wyjatek checked czyli taki jaki musiby obluzyc
        throw new IOException();
    }
}
