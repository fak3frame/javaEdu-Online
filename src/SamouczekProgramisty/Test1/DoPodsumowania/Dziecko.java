package SamouczekProgramisty.Test1.DoPodsumowania;

public class Dziecko extends Ojciec {

    int a;

    void metoda(int a){
        super.metoda(10);
    }

    public Dziecko() {
        //System.out.println();
        System.out.println("dziecko");

    }
    public Dziecko(int a){

        System.out.println("dziecko z param");
        this.a = a;
    }

    public static void main(String[] args) {
        Dziecko d = new Dziecko(2);
        Ojciec o = new Dziecko(2);
        System.out.println(d.a);
        System.out.println(d.x);
    }
}
