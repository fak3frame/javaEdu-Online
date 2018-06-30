package SamouczekProgramisty.Zadania._4_Zestaw.Interface;

import java.util.Scanner;

public class FigureFactory {
    public static void main(String[] args) {
        Figure[] figures = new Figure[3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj promien kola:");
        figures[0] = new Circle(sc.nextInt());

        System.out.println("Podaj 2 długości boków trójkąta prostokątnego (boki przy kącie prostym):");
        figures[1] = new Triangle(sc.nextInt(),sc.nextInt());

        System.out.println("Podaj długość boków prostokąta:");
        figures[2] = new Rectangle(sc.nextInt(),sc.nextInt());

        for(Figure x : figures){
            System.out.println("Pole figury wynosi: "+x.getArea());
            System.out.println("Obwod figury wynosi: "+x.getPerimeter());
        }


    }
}
