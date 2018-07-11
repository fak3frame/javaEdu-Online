package SamouczekProgramisty.Zadania._7_Serializacja;

import java.io.*;
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
            out.writeObject(imiona);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("imiona.bin"))){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
