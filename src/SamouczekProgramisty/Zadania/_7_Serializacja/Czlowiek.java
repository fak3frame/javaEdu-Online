package SamouczekProgramisty.Zadania._7_Serializacja;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Czlowiek {
    List imiona = new LinkedList();
    String imie;
    Scanner wprowadz = new Scanner(System.in);

    public void input(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("imiona.bin"))){
            System.out.println("Podaj imiona:");
            do {
                imie = wprowadz.nextLine();
                if(!imie.equals("-")){
                    imiona.add(imie);
                }
            }while (!imie.equals("-"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
