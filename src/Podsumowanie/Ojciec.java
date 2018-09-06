package Podsumowanie;

import java.io.*;

public class Ojciec implements Serializable {
    private static int wartoscStatic = 2;
    private int wartoscInt = 50;
    private String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikObiektowy5.bin";

    public void serializuj(){
        try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja))){
            Ojciec o = new Ojciec();
            o.wartoscInt = 70;
            o.wartoscStatic = 5000;
            strWyj.writeObject(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializuj(){
        try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))){
            Ojciec o2 = (Ojciec)strWej.readObject();
            System.out.println(o2.wartoscInt);
            System.out.println(o2.wartoscStatic);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Ojciec o = new Ojciec();
        //o.serializuj();
        o.deserializuj();

    }

}
