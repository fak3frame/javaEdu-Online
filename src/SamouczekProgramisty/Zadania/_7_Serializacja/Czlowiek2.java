package SamouczekProgramisty.Zadania._7_Serializacja;

import java.io.*;
import java.util.Calendar;

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
    }


    public static void main(String[] args) {
        Czlowiek2 c1 = new Czlowiek2("kamil",27);
        Czlowiek2 c2 = new Czlowiek2("tomek",29);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("wiek.bin"))){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
