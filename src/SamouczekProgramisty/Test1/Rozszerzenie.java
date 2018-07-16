package SamouczekProgramisty.Test1;

import java.io.*;

public class Rozszerzenie extends Podstawa implements Serializable {
    int x;
    int y;
    public Rozszerzenie(int x, int y){
        this.x = x;
        this.y = y;
    }
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(1234);

        //out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        //in.defaultReadObject();
        x = in.readInt();
        y = in.readInt();
        int xx = in.readInt();

    }

    public static void main(String[] args) {
        Rozszerzenie X1 = new Rozszerzenie(10,15);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("testX1.bin"))){
            out.writeObject(X1);

            out.writeInt(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("testX1.bin"))){
            Rozszerzenie X2 = (Rozszerzenie)in.readObject();
            System.out.println(X2.x);
            System.out.println(X2.y);


            Integer xx = in.readInt();
            System.out.println(xx);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
