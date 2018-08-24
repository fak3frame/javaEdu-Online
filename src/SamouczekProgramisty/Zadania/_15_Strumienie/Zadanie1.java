package SamouczekProgramisty.Zadania._15_Strumienie;

import SamouczekProgramisty.Zadania._13_Lambda.Zadanie2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Zadanie1 {

    public int getZmienna() {
        return zmienna;
    }

    public int zmienna;

    public Zadanie1(int zmienna) {
        this.zmienna = zmienna;
    }

    public static void main(String[] args) {

        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.GAMES) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        System.out.println(bestGame.name);

        //


        BoardGame najlepszaGra =  BoardGame.GAMES.stream()
                .filter(x -> x.name.contains("a"))
                .max(Comparator.comparingDouble(x -> x.rating)).get();
        System.out.println("najlepsza gra: "+ najlepszaGra.name);


        List<Zadanie1> testList = Arrays.asList(new Zadanie1(70), new Zadanie1(20), new Zadanie1(90));

        Zadanie1 numbersStream = testList.stream()
                .max(Comparator.comparingInt(x -> x.zmienna)).get();
        //to działa
        //metoda .max na strumieniu przyjmuje Comparator na ktorym wywoluje metode
        // statyczna comparingInt ktora przyjmuje interface funkcyjny ToIntFunction<T>
        // z meotda int applyAsInt(T value)
        //zmienna numbersStream zawiera teraz tylko jeden element listy i jest nim najwieksza
        // wartosc pola int zmienna
        System.out.println("numbersStream : "+ numbersStream.zmienna);

        testList.stream()
                .max(Comparator.comparingInt(x ->x.zmienna)).get();

        System.out.println("SORT:");
        List<Zadanie1> strumienSort = testList.stream()
                .sorted(Comparator.comparingInt(Zadanie1::getZmienna))
                .collect(toList());
        strumienSort.stream()
                .map(x -> x.zmienna)
                .forEach(System.out::println);

        System.out.println("Sort2:");
        //testList.stream().map(x -> x.zmienna).forEach(System.out::println);


//        Stream<Zadanie1> numbersStream2 = testList.stream()
//                .filter(x -> x.zmienna/10 == 9)
//                .max(Comparator.comparingInt(x -> x.zmienna)).get();
        //to nie dziala

        ToIntFunction<KlasaZLiczba> dajLiczbeKlasy = KlasaZLiczba::getX;
        KlasaZLiczba ob = new KlasaZLiczba(10,"x");
        System.out.println("to liczba z obiektu : "+dajLiczbeKlasy.applyAsInt(ob));

        IntSupplier dajLiczbeObiektu = ob::getX;
        System.out.println("to liczba z obiektu : "+dajLiczbeObiektu.getAsInt());


        System.out.println("Test listy obiektowej");
        List<Zadanie1> listaLiczb = Arrays.asList(new Zadanie1(2), new Zadanie1(1), new Zadanie1(3));
        Stream<Zadanie1> stream = listaLiczb.stream()
                .peek(x -> x.zmienna+=1);
        Stream<Integer> stream1 = stream.map(x -> x.zmienna);
        stream1.forEach(System.out::println);


        System.out.println("Test listy prstej");
        List<Integer> listaProstaLiczba = Arrays.asList(2,5,7,1,9);
        Stream<Integer> streamX = listaProstaLiczba.stream()
                .filter(x -> x<9)
                .sorted();
        Stream<String> streamX2 = streamX
                .map(x -> x.toString());
        streamX2.forEach(System.out::println);


        System.out.println("Test lsty z obiektamy innej klasy:");
        List<KlasaZLiczba> klasaZLiczbaList = new ArrayList<>();
        klasaZLiczbaList.add(new KlasaZLiczba(3, "x"));
        klasaZLiczbaList.add(new KlasaZLiczba(2, "x"));
        klasaZLiczbaList.add(new KlasaZLiczba(5, "x"));
        klasaZLiczbaList.add(new KlasaZLiczba(1, "x"));

        List<KlasaZLiczba> strumien = klasaZLiczbaList.stream()
                .filter(x -> x.getX()>2)
                .sorted(Comparator.comparing(KlasaZLiczba::getX).reversed())
                .collect(toList());
        strumien.forEach(x -> System.out.println(x.getX()));


        ////////////////////////////////////////////////////
        System.out.println("-----------------------------");
        ////////////////////////////////////////////////////


        ////////////////////////////////////////////
        List<Integer> listNumbers = new ArrayList<>();
        listNumbers.add(5);
        listNumbers.add(3);
        listNumbers.add(1);
        listNumbers.add(9);

        List<KlasaZLiczba> listObject = new ArrayList<>();
        listObject.add(new KlasaZLiczba(55,"bb"));
        listObject.add(new KlasaZLiczba(33,"cc"));
        listObject.add(new KlasaZLiczba(11,"dd"));
        listObject.add(new KlasaZLiczba(99,"aa"));
        ////////////////////////////////////////////

        //              SKRÓT                   //
        /* Operacje na strumieniach - interfejsy funkcyjne

        filter //Predicate<T> | boolean test(T t)
        .filter(x -> x.getX()>22) / .filter(x -> x.>22)
        //moge wszedzie, sluzy do filtrowania, sprawdza wybrany warunek
        // w lambdzie

        map //Function<T, R> | R apply(T t)
        .map(x -> x.getX())
        //Uzywam do zmiany typu,
        //Stream<Integer> streamX = lista.stream().map(x -> x.getX());
        //Uzywam na Stream z typem prostym np <Integer> aby zmienic
        // rodzaj pol listy na ten z typu generycznego Strem a nastepnie w
        // forEach w nowej liini odwolac sie besposrewnio do wybranego pola z
        // wyswietlniem z odwolanie do metody ::
        //listaObiekow.stream().map(x -> x.getX());
        //Lub bezposrenim strumieniu na liscie
        // z typem OBIKTOWYM - mapuje zeby wyswietlic zmienna
        // kokretna zmienna np Integer, inaczej bede musial w wyswietleniu
        // forEach odwolac sie do konkretnego pola/pol, natomiast
        // w liscie z elementami prostymi nie musze bo mam
        // np Integer i moge odwolac sie bezposrenio w forEach sout ::
        //List<Integer> listaX = lista.stream().
        //Lub jesli tworze nowa liste z typem prostym aby stworzyc liste
        // pol wybranej kolekcji obiektow

        peek //Consumer<T> | void accept(T t)
        .peek(x -> System.out.println(x))
        .peek(x -> System.out.println(x.getX() + " "+ x.getNapis() ))
        //Sluzy np do wyswietlenia,
        //lista.strem().
        //Uzywam w bezposrednim strumieniu na
        // liscie z elem. prostymi i obiektowymi lub tworzac nowa liste

        forEach //Consumer<T> | void accept(T t)
        integerStream.forEach(System.out::println); //typ prosty/1 rodzaj pola
        klasaZLiczbaStream.forEach(x -> System.out.println(x.getNapis()));
        .forEach(System.out::println); //bezposrenio na stuminiu + mapownie przed
        //sluzy do zamkniecia struminia i np wyswietlenia, uzywam w type
        // Stream TYLKO w oddzielnej linii, na stumieniu bezposrenim (z mapowaniem
        // w przypadku typu obiektowego oby wybrac typ) lub w nowej liscie
        // W ODDZIELNEJ LINII

        limit //moge wszedzie
        count //zwraca liczbe elementow w strumieniu

        sorted
        .sorted()/.sorted(Comparator.reverseOrder) - typy proste
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis).reverseOrder) - typy wlasne

        collect(Collectors.toList()) / collect(toList())
        //gdy przypisuje do listy musze dac na koncu

        .max(Comparator.comparingInt(x->x)).get();
        //na liscie z typami prostymi + przypisanie do zmiennej np Integer
        .max(Comparator.comparing(x -> x.getX())).get();
        //na liscie z typami obiekotwymu + przypsianie do obiektu klasy
        // a nastepnie wypisanie na tym obiekcie metoda get
        int maxIntX = listObject.stream()
                .map(x -> x.getX())
                .max(Comparator.comparing(x -> x)).get();
        //lub z wybraniem z listy obiektow konkretnego pola i jego wartosci
        // max - wymagane mapowanie do wybranego typu

        .allMatch(x -> x>1) //+przypisanie do boolean (lista typ prosty)
        .anyMatch(x -> x.getNapis().equals("aa"))
        //+przypisanie do boolean (lista obiektowa)
         */


        /*Operacja na Stream<T>*/
        /*
        W type generycznym

        -obiektowym prostym Stream<Integer>
        .filter(x -> x>2) \
        .sorted()
        .sorted(Comparator.reverseOrder())
        integerStream.forEach(System.out::println); // w oddzielnej linii

        -obiektowym Stream<KlasaZLiczba>
        .filter(x -> x.getX()>22)
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis))
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis).reverseOrder)
        klasaZLiczbaStream.forEach(x -> System.out.println(x.getNapis()));

        //w oddzielnej linii

        map,peek - bez sensu w Stream<T>
         */
        System.out.println("\n"+"OPERACJE NA STREAM 1:");
        Stream<Integer> integerStream = listNumbers.stream()
                .filter(x -> x>2)
                .sorted(Comparator.reverseOrder());
        integerStream.forEach(System.out::println);


        System.out.println("\n"+"OPERACJE NA STREAM 2:");
        Stream<KlasaZLiczba> klasaZLiczbaStream = listObject.stream()
                .filter(x -> x.getX()>22)
                .sorted(Comparator.comparing(KlasaZLiczba::getNapis).reversed());
                //musi byc okreslone jakie pole sortuje w liscie obiektow wlasnej klasy
        klasaZLiczbaStream.forEach(x -> System.out.println(x.getNapis() + " "+x.getX() ));

        System.out.println("\n"+"OPERACJE NA STREAM 3 + map:");
        Stream<Integer> klasaZliczbaStream1INTEGER = listObject.stream()
                .filter(x -> x.getX()>22)
                .map(x -> x.getX());
        klasaZliczbaStream1INTEGER.forEach(System.out::println);

        System.out.println("\n"+"OPERACJE NA STREAM 4 + peek:");
        Stream<KlasaZLiczba> klasaZliczbaStreamPeak = listObject.stream()
                .peek(x -> System.out.println(x.getX() + " " + x.getNapis()));
        klasaZliczbaStreamPeak.forEach(System.out::println);
        //najpierw wykona peek 55 bb np
        //nastepie adres obiektu SamouczekProgramisty.Zadania._15_Strumienie.KlasaZLiczba@9629756

        //---------

        /*Operacje bezposrenio na liscie listObiektow.stream()*/
        /*
        Na liscie (pracuje na 1 lancuchu)

        -z obiektami prostymi listNumbers.stream()
        .filter(x -> x>2)
        .sorted()
        .sorted(Comparator.reverseOrder())
        .forEach(System.out::println);//nie musze mapowac
        //lub wyswietlenie z peek
        .peek(x -> System.out.println(x)) //po tym musze dac collect
        .collect(toList())

        -z obiektami listObject.stream()
        .filter(x -> x.getX()>22)
        .sorted(Comparator.comparing(KlasaZLiczba::getX))
        .sorted(Comparator.comparing(KlasaZLiczba::getX).reverseOrder())
        .map(x -> x.getX()) //zmieniam typ na int jak ma metoda getX i moge dac forEach
        .forEach(System.out::println); //lub
        .forEach(x -> System.out.println(x.getX()));
        //lub wyswietlenie z peek (nie musze mapowac)
        .peek(x -> System.out.println(x.getX() + " "+ x.getNapis()))//musze po tym dac collect
        .collect(toList());
         */
        System.out.println("\n"+"OPERACJE bezposrenio na liscie 1:");
        listNumbers.stream()
                .filter(x -> x>2)
                .sorted()
                .forEach(System.out::println);//nie musze mapowac bo lista
                // przechowuje typ porsty

        System.out.println("\n"+"OPERACJE bezposrenio na liscie 1 + peak:");
        listNumbers.stream()
                .peek(x -> System.out.println(x))
                .collect(toList());//doda wyswietlenie, bez tego nic nie bedzie na ekranie


        System.out.println("\n"+"OPERACJE bezposrenio na liscie 2:");
        listObject.stream()
                .filter(x -> x.getX()>22)
                .sorted(Comparator.comparing(KlasaZLiczba::getX))
                .map(x -> x.getX()*10)//ZMIENIAM PRZY OKAZJI TYP NA INTEGER ELEMETNOW STRUMIENIA!!
                .forEach(System.out::println);//wiec nie musze sie tutaj juz odnosic do konkretnej zmeinnej
                //.forEach(x -> System.out.println(x.getX()));

        System.out.println("\n"+"OPERACJE bezposrenio na liscie 3:");
        listObject.stream()
                .filter(x -> x.getX()>22)
                .sorted(Comparator.comparing(KlasaZLiczba::getX))
                .forEach(x -> System.out.println("liczba: "+x.getX()+ " napis: "+x.getNapis()));

        System.out.println("\n"+"OPERACJE bezposrenio na liscie 3 + peek:");
        listObject.stream()
                .filter(x -> x.getX()>22)
                .sorted(Comparator.comparing(KlasaZLiczba::getX))
                .peek(x -> System.out.println(x.getX() + " "+ x.getNapis() ))
                .collect(toList());

        //---------

        /*Operacje na nowej liscie List<T> listX = list.stream()*/
        /*
        Z typem

        -Obiektow prostych List<Integer>
        .filter(x -> x>2)
        .sorted(Comparator.reverseOrder())
        .collect(toList()); //wymagane na koncu
        // lub .collect(Collectors.toList());
        listNumbersX.forEach(System.out::println); //w oddzielnej linii
        //lub peek (mam jedna zmeinna wiec proste ::prtintln)
        .peek(System.out::println)

        -Obiektow List<KlasaZLiczba>
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis))
        .collect(toList());
        listObjectX.forEach(x -> System.out.println(x.getX() + " " + x.getNapis() ));
        //lub z konwersja do nowej listy typu generycznego wybranego pola
        List<String> listObjectXMap = listObject.stream()
                .map(x -> x.getNapis())
                .collect(toList());
        listObjectXMap.forEach(System.out::println);
        //juz mam liste z 1 zmienna i moge prosto forEach
        // lub przed .collect(toList()); dac .peek()
        .peek(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()))
         */
        System.out.println("\n"+"OPERACJE na nowej liscie 1:");
        List<Integer> listNumbersX = listNumbers.stream()
                .filter(x -> x>2)
                .sorted(Comparator.reverseOrder())
                .collect(toList());
        listNumbersX.forEach(System.out::println);


        System.out.println("\n"+"OPERACJE na nowej liscie 2:");
        List<KlasaZLiczba> listObjectX = listObject.stream()
                .sorted(Comparator.comparing(KlasaZLiczba::getNapis))
                .collect(toList());
                // lub .collect(Collectors.toList());
        listObjectX.forEach(x -> System.out.println(x.getX() + " " + x.getNapis() ));

        System.out.println("\n"+"OPERACJE na nowej liscie 2 + peak:");
        List<KlasaZLiczba> listObjectXP = listObject.stream()
                .peek(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()))
                .collect(toList());
        //nie musze pisac forEach do wyswietlenia w oddzielnej liscie

        System.out.println("\n"+"OPERACJE na nowej liscie 3 + map:");
        List<String> listObjectXMap = listObject.stream()
                .map(x -> x.getNapis())
                .collect(toList());
        listObjectXMap.forEach(System.out::println);//juz mam liste z 1 zmienna i moge prosto

        System.out.println("\n"+"OPERACJE na nowej liscie 4 + peek:");
        List<KlasaZLiczba> listObjectXPeek = listObject.stream()
                .peek(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()))
                .collect(toList());

        //---------

        /*Operacja wyciagania max / min*/
        /*
        Na liscie z obiektami

        -Prostymi
        .max(Comparator.comparingInt(x->x)).get();
        //+ przypisanie do zmiennej typu protego np Integer

        -Wlasnymi
        .max(Comparator.comparing(x -> x.getX())).get();
        //+ przypisanie do typu Obiektowego wybranej klasy
        // wyswietlenie z metoda get wybranej zmiennej
        .map(x -> x.getX())
        .max(Comparator.comparing(x -> x)).get();
        //lub z mapoweniem to moge przypisac do zmiennej prostej
        // typu wybranego pola obieku z listy

         */

        System.out.println("\n\n"+"Wyciagniecie max do Integer");
        Integer maxInt = listNumbers.stream() //moge tez do int
                .max(Comparator.comparingInt(x->x)).get();
        System.out.println("max Integer : "+maxInt);

        System.out.println("\n"+"Wyciagniecie max do pola klasy z listy obiektow wlasnych");
        KlasaZLiczba maxLiczba = listObject.stream()
                .max(Comparator.comparing(x -> x.getX())).get();
        //teraz zmianna maxLiczba zawiera jeden obiekt z najwieksza liczba i
        // odpowiadajacemu jej napisowi
        System.out.println("Obiekt z najwieksza liczba, liczba: "
                +maxLiczba.getX()+" i odpowiadajacy napis: "+maxLiczba.getNapis());

        System.out.println("\n"+"Wyciagniecie max do pola prostego z listy obiektow wlasnych");
        int maxIntX = listObject.stream()
                .map(x -> x.getX())
                .max(Comparator.comparing(x -> x)).get();
        System.out.print("max liczba z listy : "+ maxIntX);

        //---------

        /*Operacja sprawdznia dopasowania allMatch / anyMatch / noneMatch*/
        /*
        Operacje na liscie z obiektami

        -Prostymi
        .allMatch(x -> x>1);
        //+przypisanie do typu boolean

        -Obiektowymi
        .anyMatch(x -> x.getNapis().equals("aa"))
        //+przypisanie do typu boolean
         */
        System.out.println("\n\n"+"Dopasowanie allMatch typ prosty ");
        boolean czyPasujaProsteAll = listNumbers.stream()
                .allMatch(x -> x>1); //nie pasuje bo jest element = 1
        System.out.println("Czy pasuja wszystkie proste : " + czyPasujaProsteAll);

        System.out.println("\n"+"Dopasowanie anyMatch typ prosty ");
        boolean czyPasujeJakisProstyAny = listNumbers.stream()
                .anyMatch(x -> x>1); //pasuje bo jakis jest > 1
        System.out.println("Czy pasuje chociaz jeden prosty : " + czyPasujeJakisProstyAny);

        System.out.println("\n"+"Dopasowanie noneMatch typ prosty ");
        boolean czyZadenNiePasujeNone = listNumbers.stream()
                .noneMatch(x -> x>1); //nie pasuje bo sa elementy wieksze od 1
        System.out.println("Czy kazdy nie pasuje : " + czyZadenNiePasujeNone);

        System.out.println("\n"+"Dopasowanie anyMatch typ Obiektowy ");
        boolean czyPasujeNapisJednegoObiektu = listObject.stream()
                .anyMatch(x -> x.getNapis().equals("aa"));//true bo jeden napis pasuje
        System.out.println("Czy jakis napis z obiektow pasuje :"+czyPasujeNapisJednegoObiektu);
    }
}


class BoardGame {

    public final String name;
    public final double rating;
    public final BigDecimal price;
    public final int minPlayers;
    public final int maxPlayers;

    public BoardGame(String name, double rating, BigDecimal price, int minPlayers, int maxPlayers) {
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
    }
    public static final List<BoardGame> GAMES = Arrays.asList(
            new BoardGame("Terraforming Mars", 8.38, new BigDecimal("123.49"), 1, 5),
            new BoardGame("Codenames", 7.82, new BigDecimal("64.95"), 2, 8),
            new BoardGame("Puerto Rico", 8.07, new BigDecimal("149.99"), 2, 5),
            new BoardGame("Terra Mystica", 8.26, new BigDecimal("252.99"), 2, 5),
            new BoardGame("Scythe", 8.3, new BigDecimal("314.95"), 1, 5),
            new BoardGame("Power Grid", 7.92, new BigDecimal("145"), 2, 6),
            new BoardGame("7 Wonders Duel", 8.15, new BigDecimal("109.95"), 2, 2),
            new BoardGame("Dominion: Intrigue", 7.77, new BigDecimal("159.95"), 2, 4),
            new BoardGame("Patchwork", 7.77, new BigDecimal("75"), 2, 2),
            new BoardGame("The Castles of Burgundy", 8.12, new BigDecimal("129.95"), 2, 4)
    );
}

class KlasaZLiczba{
    private int x;
    private String napis;

    public String getNapis() {
        return napis;
    }

    public int getX() {
        return x;
    }

    public KlasaZLiczba(int x, String napis) {
        this.x = x;
        this.napis = napis;
    }
}