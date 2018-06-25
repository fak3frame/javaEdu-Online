package SamouczekProgramisty.Zadania._3_Dziedzieczenie;

public class Human extends Mammal {
    @Override
    public String toString() {
        return "Im human "+super.toString();
    }
}
