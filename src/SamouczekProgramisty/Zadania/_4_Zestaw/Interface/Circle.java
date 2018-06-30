package SamouczekProgramisty.Zadania._4_Zestaw.Interface;

public class Circle implements Figure{

    private int r;
    public Circle(int r){
        this.r = r;
    }
    @Override
    public double getPerimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public double getArea() {
        return Math.PI*(Math.pow(r,2));
    }
}
