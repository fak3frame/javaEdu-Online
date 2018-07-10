package SamouczekProgramisty.Test1;

import java.io.Serializable;

public class Serializacja1 implements Serializable {
    private static int wiek;
    public Serializacja1(int wiek){
        this.wiek = wiek;
    }
    public static int getWiek() {
        return wiek;
    }
}
