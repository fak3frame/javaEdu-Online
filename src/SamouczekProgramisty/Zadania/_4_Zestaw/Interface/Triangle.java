package SamouczekProgramisty.Zadania._4_Zestaw.Interface;

public class Triangle implements Figure{
    private int a,b;
    double c;
    public Triangle(int a, int b){
        this.a = a;
        this.b = b;
        this.c = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    @Override
    public double getPerimeter() {
        return a+b+c;
    }

    @Override
    public double getArea() {
        return 0.5*a*b;
    }
}
