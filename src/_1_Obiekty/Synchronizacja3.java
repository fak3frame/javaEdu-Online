package _1_Obiekty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Synchronizacja3 implements Runnable {
    private String zadanie;

    public Synchronizacja3(String zadanie) {
        this.zadanie = zadanie;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Zaczynam : "+zadanie);
        try{
            Thread.sleep(4000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("Zakonczylem : "+zadanie);
    }
}

class Aplikacja{
    public static void main(String[] args) {
        List<String> zadania = new ArrayList<>();
        zadania.add("czyszczenie");
        zadania.add("sprzatanie");
        zadania.add("odkurzanie");
        zadania.add("mycie");
        zadania.add("szorowanie");

        ExecutorService excutor = Executors.newFixedThreadPool(2);


        excutor.submit(new Synchronizacja3("czyszczenie"));
        excutor.submit(new Synchronizacja3("sprzatanie"));
        excutor.submit(new Synchronizacja3("odkurzanie"));
        excutor.submit(new Synchronizacja3("mycie"));
        excutor.submit(new Synchronizacja3("szorowanie"));

        excutor.shutdown();

        System.out.println("wszystkie zadania przeslane");

        try{
            excutor.awaitTermination(3, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println("Wszystkie zadania zakonczone");


    }
}
