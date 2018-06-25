package SamouczekProgramisty.Silnik;

public class Diesel extends Silnik{
    private String rodzajPaliwa;
    public Diesel(){
        System.out.println("konstr. bezp. Diesel");
    }
    public Diesel(String rodzajPaliwa){
        this.rodzajPaliwa=rodzajPaliwa;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void metodaDiesel(){

    }
}
