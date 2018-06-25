package SamouczekProgramisty.Zadania._1_Interface;

public class MyAdd implements Computation{
    @Override
    public double compute(double arg1, double arg2) {
        return arg1+arg2;
    }
}
