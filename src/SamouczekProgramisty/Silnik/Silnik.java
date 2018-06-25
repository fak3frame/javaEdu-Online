package SamouczekProgramisty.Silnik;

public class Silnik {
    private int moc;
    public Silnik(){
        System.out.println("konstr. bezp. Silnik");
    }
    public Silnik(int moc){
        this.moc=moc;
    }

    public int getMoc() {
        return moc;
    }

    public void metodaSilnik(){

    }
}
