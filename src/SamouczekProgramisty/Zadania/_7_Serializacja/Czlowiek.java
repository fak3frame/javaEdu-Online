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
    Scanner wprowadz = new Scanner(System.in);

    public static void main(String[] args) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("imiona.bin"))){
            System.out.println("Podaj imiona:");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
