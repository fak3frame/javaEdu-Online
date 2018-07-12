package SamouczekProgramisty.Zadania._7_Serializacja;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Czlowiek2 implements Serializable {
    String imie;
    int wiek;
    Czlowiek2(String imie, int wiek){
        this.imie = imie;
        this.wiek = wiek;
    }

    private void writeObject(ObjectOutputStream out)throws IOException{
        out.defaultWriteObject();
        int wiekUrodzenia = Calendar.getInstance().get(Calendar.YEAR) - wiek;
        out.writeInt(wiekUrodzenia);
        System.out.println("zapisuje zmienna: "+wiekUrodzenia);
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        int wiekUrodzenia = in.readInt();
        System.out.println("Odejmuje aktualny rok: "+Calendar.getInstance().get(Calendar.YEAR)+
        " - "+wiekUrodzenia);
        wiek = Calendar.getInstance().get(Calendar.YEAR) - wiekUrodzenia;
    }


    public static void main(String[] args) {
        Czlowiek2 c1 = new Czlowiek2("kamil",27);
        Czlowiek2 c2 = new Czlowiek2("tomek",29);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("wiek.bin"))){
            List<Czlowiek2> czlowiek2Lista = new LinkedList<>();
            czlowiek2Lista.add(c1);
            czlowiek2Lista.add(c2);
            out.writeObject(czlowiek2Lista);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("wiek.bin"))){
            List<Czlowiek2> nowaLista = new LinkedList<>();
            nowaLista = (List<Czlowiek2> ) in.readObject();
            for(Czlowiek2 x : nowaLista){
                System.out.println(x.imie);
                System.out.println(x.wiek);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
