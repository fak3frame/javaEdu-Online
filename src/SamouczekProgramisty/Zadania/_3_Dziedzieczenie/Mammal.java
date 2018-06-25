package SamouczekProgramisty.Zadania._3_Dziedzieczenie;

public abstract class Mammal extends Animal{
    @Override
    public String toString() {
        return "and im mammal "+super.toString();
    }
}
