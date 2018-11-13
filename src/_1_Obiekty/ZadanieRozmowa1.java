package _1_Obiekty;

public class ZadanieRozmowa1 {

    public static void liczby(){
        for(int i = 1; i < 100; i++){
            if(i%3==0 && i%5==0){
                System.out.println("AB");
            }
            else if(i%3==0){
                System.out.println("A");
            }
            else if(i%5==0){
                System.out.println("B");
            }
            else{
                System.out.println(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        liczby();
    }
}
