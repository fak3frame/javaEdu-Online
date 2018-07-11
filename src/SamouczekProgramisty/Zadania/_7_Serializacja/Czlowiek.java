package SamouczekProgramisty.Zadania._7_Serializacja;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Czlowiek {

    public static List<String> input(){
        List<String> imiona = new ArrayList();
        String imie;
        Scanner input = new Scanner(System.in);
        while (true){
            imie = input.nextLine();
            if(imie.equals("-"))
                break;
            imiona.add(imie);
        }
        return imiona;
    }


    public static void main(String[] args) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("imionaZadanie.bin"))){
            out.writeObject(input());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("imionaZadanie.bin"))){
            List<String> noweImiona = new ArrayList<>();
            noweImiona = (List<String>) in.readObject();
            System.out.println(noweImiona);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
