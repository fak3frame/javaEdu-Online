package PrzydatneKlasy;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileMoj {
    public static void main(String[] args) throws IOException {

        if(1>2){
            //stary rodzaj tworzenia plikow
            File plik = new File("C:/Users/Fak3frame/plikTestowy.txt");
            //moge dac sciazke + nazwe
            File plik2 = new File("plikTestowy2.txt");
            //lub sama nazwe
            if(!plik.exists())
                plik.createNewFile();

            //od Javy 7:
            Files.createFile(Paths.get("plikTestowy3.txt"));
            //korzystam bezposrenio z klasy Files oraz metody get klasy Paths
            Files.createFile(Paths.get("C:/Users/Fak3frame/plikTestowy.txt"));
            //jesli plik istnieje wyrzuci wyjatek FileAlreadyExistsException

            //Tworzenie folderu
            Files.createDirectory(Paths.get("Folder"));




        }




    }
}
