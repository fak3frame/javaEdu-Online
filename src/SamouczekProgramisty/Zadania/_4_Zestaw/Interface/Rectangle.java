package SamouczekProgramisty.Zadania._4_Zestaw.Interface;

public class Rectangle implements Figure {
    private int a,b;

    public Rectangle(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return 2*a+2*b;
    }

    @Override
    public double getArea() {
        return a*b;
    }
}
