package PrzydatneKlasy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotMoj {
    public static void main(String[] args) {
        /*
        klasa robot sluzy do automatycznego uzycia klawiatury,
         kursora oraz robienia zrzutow ekranu i odczytywaniu informacji
         o pikselach.

        najwazniejsze metody:
        keyPress(int keycode), keyRelease(int keycode)
        mousePress(int buttons), mouseRelease(int buttons) - jako
         argumenty podajemy stałe zdefiniowane w klasie InputEvent
         (BUTTON1_MASK, BUTTON2_MASK, BUTTON3_MASK)
        mouseMove(int x, int y)
        createScreenCapture(Rectangle screenRect)
        delay(int time) - wstrzymanie wykonywanego wątku w ms.
         */


        //Program piszacy Czesc a nastepnie wykoanuje zrzut ekranu i
        // zapisuje go na dysku

        RobotMoj test = new RobotMoj();
        test.robot.delay(10);//timer od uruchomienia
        test.piszTekst();
    }
    Robot robot;
    public RobotMoj(){
        try{
            robot = new Robot();
        }catch (AWTException e){
            System.out.println("Co on robi?");
            e.printStackTrace();
        }
    }

    //metoda drukownia napisu
    public void piszTekst(){
        int[] napis = {KeyEvent.VK_C,KeyEvent.VK_Z,KeyEvent.VK_E,
                KeyEvent.VK_S,KeyEvent.VK_C,};
        //dodanie odstepu czasowego w wyswieleniu
        for(int i=0;i<napis.length;i++){
            robot.keyPress(napis[i]);
            robot.delay(200);
        }
    }
}
