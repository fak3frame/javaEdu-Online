package _1_Obiekty;

public class Synchronizacja {
    private int licznik;

    public static void main(String[] args) {
        Synchronizacja synchronizacja = new Synchronizacja();
        synchronizacja.licz();
        //synchronizacja.test();
    }

    private void test(){
        Runnable runnable = () -> {
            for(int i = 0; i < 5000; i++){
                licznik++;
            }
        };
        System.out.println(licznik);
        runnable.run();
        System.out.println(licznik);
    }

    private void licz(){
        Runnable runnable = () -> {
            for(int i = 0; i < 5000; i++){
                licznik++;
            }
        };

        Thread watek1 = new Thread(runnable);
        Thread watek2 = new Thread(runnable);

        watek1.start();
        watek2.start();

//        try{
//            watek1.join();
//            watek2.join();
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }


        System.out.println(licznik);
    }
}
