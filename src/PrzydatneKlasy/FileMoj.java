package PrzydatneKlasy;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

public class FileMoj {
    public static void main(String[] args) throws IOException, URISyntaxException {

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

            BasicFileAttributeView atrybutPodglad = Files
                    .getFileAttributeView(Paths.get("plik.txt"), BasicFileAttributeView.class);
            BasicFileAttributes atrybuty = atrybutPodglad.readAttributes();
            System.out.println("Rozmiar pliku: "+atrybuty.size());
            System.out.println("Ostatnia modyfikacja: "+atrybuty.lastModifiedTime());

            //Wczytywanie pliku i zapis wierszy do listy (niezalecane do dlugich plikow
            List<String> listaWierszy = Files
                    .readAllLines(Paths.get("plik.txt"), Charset.forName("UTF-8"));
            for(String x : listaWierszy){
                System.out.println(x);
            }

            //Wczytywanie pliku i zapis go do stringa
            String zbior = Files.lines(Paths.get(ClassLoader.getSystemResource("plik.txt").toURI()))
                    .filter(str->str.length()>3)
                    .collect(Collectors.joining(", ","{","}"));
            //w tym przypadku odczytuje z pliku ciagi znakow linia po lini o odrzucam
            // te krotsze od dlugosci 3

            //kopiowanie pliku z nadpisaniem starego
            Files.copy(Paths.get("plik.txt"),
                    Paths.get("C:/Users/Fak3frame/plik.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
            //przenoszenie pliku z nadpisaniem starego
            Files.move(Paths.get("plik.txt"),
                    Paths.get("C:/Users/Fak3frame/plik.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            //Wszystkie atrybuty kontroli dostepu
            AclFileAttributeView kontrolaDostepuPodglad = Files.getFileAttributeView(Paths
                    .get("plik.txt"), AclFileAttributeView.class);
            List<AclEntry> listaKontoliDostepu = kontrolaDostepuPodglad.getAcl();
            for (AclEntry x : listaKontoliDostepu){
                x.flags().forEach(System.out::println);
                x.permissions().forEach(System.out::println);
                System.out.println(x.principal().getName());
            }
        }


    }
}
