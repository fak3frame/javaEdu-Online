package _1_Obiekty;

public class Synchronizacja2 implements Runnable{
    @Override
    public void run() {
        System.out.println("456");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("123");
    }
}

class Start{
    public static void main(String[] args) {
        Thread t = new Thread(new Synchronizacja2());

        t.start();
    }
}
