package SamouczekProgramisty.Test1;

import java.io.*;

public class SerializacjaFabryka {
    public static void main(String[] args) {
        Serializacja1 s = new Serializacja1(123);
        System.out.println(s.getWiek());
        try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream("serializacjaTest.bin"))){
            strWyj.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream("serializacjaTest.bin"))){
            Serializacja1 s2 = (Serializacja1) strWej.readObject();
            System.out.println(s2.getWiek());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
