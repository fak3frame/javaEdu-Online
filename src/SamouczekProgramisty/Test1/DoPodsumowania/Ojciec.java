package SamouczekProgramisty.Test1.DoPodsumowania;

public class Ojciec {
    int x;

    void metoda(int a){

    }

    public Ojciec() {
        System.out.println("ojciec");
    }

    public Ojciec(int x) {
        System.out.println("ojciec z param");
        this.x = x;
    }
}
