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
        //metodaZwykla .max na strumieniu przyjmuje Comparator na ktorym wywoluje metode
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
        .filter(x -> x.getX()>22) // typ listy obiektowy
        .filter(x -> x>22) //typ listy prosty lub po mapowaniu
        //moge wszedzie, sluzy do filtrowania, sprawdza wybrany warunek
        // w lambdzie


        map //Function<T, R> | R apply(T t)
        .map(x -> x.getX())
        //Uzywam do zmiany typu,

       -//Stream<Integer> streamX = listaObiektow.stream().map(x -> x.getX());
        // streamX.forEach(System.out::println);
        //Uzywam na Stream z typem prostym np <Integer> aby zmienic
        // rodzaj pol listy Obiektow na ten z typu generycznego Strem a nastepnie w
        // forEach w nowej liini odwolac sie besposrewnio do wybranego pola z
        // wyswietlniem z odwolanie do metody ::

       -//listaObiekow.stream().map(x -> x.getX()).forEach(System.out::println);
        //Lub bezposrenim strumieniu na liscie
        // z typem OBIKTOWYM - mapuje (opcjonalnie) zeby wyswietlic zmienna
        // kokretna zmienna np Integer, inaczej bede musial w wyswietleniu
        // forEach odwolac sie do konkretnego pola/pol,
        // *listaObiekow.stream().forEach(x -> System.out.println(x.getX() + " "+ x.getNapis()));
        // * bez mapowaania
        // natomiast w liscie z elementami prostymi nie musze mapowac bo mam
        // np Integer i moge odwolac sie bezposrenio w forEach sout ::

       -//List<Integer> listaX = listaObiektow.stream().map(x -> x.getX()).collect(toList());
        //Lub jesli tworze nowa liste z typem prostym aby wybrac pola
        // z listy obiektow i odwolac sie za pomoca :: w sout
        // NIE ZAPOMINAM O .collect(toList()); na koncu!


        peek //Consumer<T> | void accept(T t)
        .peek(x -> System.out.println(x))
        .peek(x -> System.out.println(x.getX() + " "+ x.getNapis() ))
        //Sluzy np do wyswietlenia,

       -//listaZIntegerani.strem().peek(System.out::println).collect(toList())
        //listaZObiektami.strem().peek(x -> System.out.println(x.getX() + " "+ x.getNapis())).collect(toList())
        //Uzywam w bezposrednim strumieniu na liscie z elem. prostymi lub
        // obiektowymi MUSZE NA KONCU .collect(toList())!

       -//List<Integer> listInteger = listNumber.stream()
        // .peek(System.out::println)
        // .collect(toList());
       -//List<KlasaObiektow> listObjectX = listObject.stream()
        // .peek(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()))
        // .collect(toList());
       -//List<String> listString = listObject.stream()
        // .map(x -> x.getNapis())
        // .peek(System.out::println)
        // .collect(toList());
        //Lub tworzac nowa liste, NA KONCU .collect(toList());!


        forEach //Consumer<T> | void accept(T t)
        strumienZInteger.forEach(System.out::println); //typ prosty/1 rodzaj pola
        strumienZObiektami.forEach(x -> System.out.println(x.getNapis()));
        .forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));//bezposrenio na stuminiu
        .forEach(System.out::println); //bezposrenio na stuminiu z 1 typem zmiennych
        //Sluzy do zamkniecia struminia i np wyswietlenia

       -//Stream<Integer> integerStream = listaInt.stream();
        // integerStream.forEach(System.out::println) //ODZIELNA LINIA!
       -//Stream<MojaKlasa> obiektyStream = listaOb.stream();
        // obiektyStream.forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));
        //Uzywam w type Stream TYLKO w oddzielnej linii

       -//listaInteger.stream().forEach(System.out::println);
       -//listaObiektow.stream().forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));
       -//listaObiektow.stream().map(x -> x.getX()).forEach(System.out::println);
        //Lub na stumieniu bezposrenim (moge z mapowaniem w przypadku typu obiektowego
        // aby wybrac typ i odwolac sie besrednio z :: do konkretnego pola)

       -//List<Integer> listaX = listaInteger.stream().collect(toList());
        // listaX.forEach(System.out::println) //ODDZIELNA LINIA!
       -//List<KlasaObiektow> listaO = listaObiektow.stream().collect(toList());
        // listaO.forEach(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()));
       -//List<Stream> listaS = listaObiektow.stream().map(x -> x.getNapis()).collect(toList());
        // listaS.forEach(System.out::println);
        //Lub w nowej liscie W ODDZIELNEJ LINII, na koncu stream() musze dac Collect(toList())!!


        limit //moge wszedzie


        count //zwraca liczbe elementow w strumieniu


        sorted
        .sorted()/.sorted(Comparator.reverseOrder) - typy proste
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis).reverseOrder) - typy wlasne


        collect
        .collect(Collectors.toList()) / collect(toList())
       -//List<KlasaZLiczba> listObjectX = listObject.stream().collect(toList());
        //Gdy przypisuje do listy DOWOLNEJ musze dac na koncu
       -//listObject.stream().peek(x -> System.out.println(x.getX() + " "+ x.getNapis() )).collect(toList());
        //Lub gdy uzywam peek bezposrednio na strumieniu listy (bez tego zadziala ale nie wyswietli


        max
        .max(Comparator.comparingInt(x->x)).get(); //po mapowaniu do typu zwyklaego + przypisanie do typu zwyklego
        .max(Comparator.comparing(KlasaZLiczba::getX)).get
       -//KlasaZLiczba zmiennaO = listaObiektow.stream().max(Comparator.comparing(KlasaZLiczba::getX)).get();
        // System.out.println(zmiennaO.getX());
        //Uzywam na zmiennej Obiektowej WLASNEJ klasy i przypisuje jej
        // wybrane pole max odwolujac sie w Comparatorze do getera :: + metodaZwykla get()!!
        // *NIE MAPUJE bo przypisuje do typu KlasaZLiczba!
       -//Integer liczbaMax3 = listObject.stream()
                .map(x -> x.getX())//mapuje bo z listy obiektow przypisuje do int
                .max(Comparator.comparing(x -> x)).get();//WPISUJE x->x bez get bo mapowalem
                // lub .max(Comparator.comparing(Integer::compare)).get();
                // lub moge skorzystac z metody Integer::compare w max bo przemapowalem do Integer
                // .max(Integer::compare).get();
                // lub jesli przypisuje do String tylko inna metodaZwykla
                // .max(String::valueOf).get();
        // System.out.println(liczbaMax3);
        //Lub na zmiennej prostej wybranego typu pola z klasy np int,
        // uzywam z mapowanie bo musze wyciagnac jeden rodzaj zmiennej z
        // LISTY OBIEKTOW a nastepnie w comparing zapisuje x->x bez get.
        // lub Integer::compare ew dla String String::valueOf, moge takze
        // nie uzywac Comparator.comparing tylko w max od razu Integer::compare
        // po tym nie zapominam o get() na koncu!!

       -//Integer liczbaMax4 = listNumbers.stream().max(Comparator.comparing(x -> x)).get();
       -//Integer liczbaMax4 = listNumbers.stream().max(Integer::compare).get();
        // jesli typ prosty np Integer moge uzyc metody jej klasy w max Integer::compare
        // System.out.println(liczbaMax4);
        //Lub tez z przypisaniem do typ prostego ale
        // z listy z ELEMENTAMI PROSTYMI wiec nie musze
        // mapowac

       -//Comparator<KlasaZLiczba> comparatorInt = (x1, x2) -> Integer.compare(x1.getX(), x2.getX());
        //Comparator<KlasaZLiczba> comparatorString = (x1, x2) -> x1.getNapis().compareTo(x2.getNapis());
        //KlasaZLiczba najmniejszyWyraz = listObject.stream()
                .min(comparatorString).get();
        //System.out.println("najmniejszyWyraz : "+najmniejszyWyraz.getNapis());
        //KlasaZLiczba najmniejszaLiczba = listObject.stream()
                .min(comparatorInt).get();
        //System.out.println("najmniejszaLiczba: "+najmniejszaLiczba.getX());
        //Lub z uzyciem zmiennej Comparatora

       -//Integer[] numbers = {4,1,10,2,3};
        //System.out.println("Stream.min(): " + Arrays.stream(numbers).min(Integer::compare).get());
        //Lub z uzyciem tablicy


        all/any/noneMatch
        .allMatch(x -> x>1) //+przypisanie do boolean (lista typ prosty)
        .anyMatch(x -> x.getNapis().equals("aa"))
        // +przypisanie do boolean (lista obiektowa)
       -//boolean czyCokolwiekPasuje = listInteger.stream().anyMatch(x->x>1);
        //Uzywam gdy chce sprawdzic czy jakikolwiek element z listy
        // typow prostych pasuje do wzorca x>1
       -//boolean czyWszystkoPasuje = listObject.stream()
                .allMatch(x -> x.getX()>1);
        //Lub gdy chce na liscie OBIEKTOW to musze odwolac
        // sie do kokretnego pola getem


        sum
        .sum();
        -int suma = liczbyLista.stream().mapToInt(Integer::intValue).sum();
        //Metoda sumuje liczby strumienia, MUSI byc zmapowane z metoda mapToInt
        // + moge wykorzystac metode klasy Integer zwracajaca int;
         */

        //                   END                     //



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
        .map(x -> x.getX()) //zmieniam typ na int jak ma metodaZwykla getX i moge dac forEach
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
                .peek(System.out::println)
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

        System.out.println("\n\n"+"OPERACJE na nowej liscie 4 + peek 2:");
        List<Integer> listInteger = listNumbers.stream()
                .peek(System.out::println)
                .collect(toList());

        System.out.println("\n\n"+"OPERACJE na nowej liscie 4 + peek 3:");
        List<String> listString = listObject.stream()
                .map(x -> x.getNapis())
                .peek(System.out::println)
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
        // wyswietlenie z metodaZwykla get wybranej zmiennej
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


        System.out.println("TEEEEEEEEEEST");
        Integer mojMax = listInteger.stream()
                .max(Integer::compare).get();
        System.out.println(mojMax);

        Integer mojMax2 = listObject.stream()
                .map(KlasaZLiczba::getX)
                .max(Integer::compare).get();
        System.out.println(mojMax2);

        String maxNapis = listObject.stream()
                .map(KlasaZLiczba::getNapis)
                //.max(Comparator.comparing(x -> x)).get();
                .max(Comparator.comparing(String::valueOf)).get();
        System.out.println("max napis: "+maxNapis);

        Comparator<KlasaZLiczba> comparatorInt = (x1, x2) -> Integer.compare(x1.getX(), x2.getX());
        Comparator<KlasaZLiczba> comparatorString = (x1, x2) -> x1.getNapis().compareTo(x2.getNapis());

        KlasaZLiczba najmniejszyWyraz = listObject.stream()
                .min(comparatorString).get();
        System.out.println("najmniejszyWyraz : "+najmniejszyWyraz.getNapis());

        KlasaZLiczba najmniejszaLiczba = listObject.stream()
                .min(comparatorInt).get();
        System.out.println("najmniejszaLiczba: "+najmniejszaLiczba.getX());

        Integer[] numbers = {4,1,10,2,3};
        System.out.println("Stream.min(): " + Arrays.stream(numbers).min(Integer::compare).get());


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
/*
INTERFEJSY FUNKCYJNE:

BiFunction<T, U, R> | R apply(T t, U u)

BiFunction<Integer, String, KlasaMoja> obiektInterfejsu = KlasaMoja::new;
KlasaMoja nowyObiektMojejKlasy = obiektInterfejsu("wartosc", 123)
---------------
Function <T, R> | R apply(T t)

//na strumieniu: (map) x -> x.name//x -> x.name.toUpperCase()
Function<String, Integer> zmianaSILambda = zmiennaString -> Integer.parseInt(zmiennaString);
int L1 = zmianaSILambda.apply("12");
---------------
ToIntFunction<T> | int applyAsInt(T t)

ToIntFunction<Integer> toIntFunction = x -> x+12;
int y = toIntFunction.applyAsInt(22);
---------------
ToDoubleFunction<T> | double applyAsDouble(T t)

ToDoubleFunction<Double> toDoubleFunction = x -> x+12.3;
double y = toIntFunction.applyAsInt(34.5);
---------------
UnaryOperator<T> | T apply (T t)

UnaryOperator<Integer> pomnozPrzezDwaLambda = liczbaDoMnozenia -> liczbaDoMnozenia*2;
System.out.println("liczba 14 pomnozona przez 2  w lambdzie: "+pomnozPrzezDwaLambda.apply(14));
---------------
Supplier<T> | T get()

Supplier<Integer> pokazInteger10Lambda = () -> 10;
System.out.println("pokaz 10 Integer z lambdy : "+pokazInteger10Lambda.get());
---------------
IntSuplier | int getAsInt()

IntSupplier pokaz10lambda = () -> 10;
System.out.println("pokazuje 10 int z lambdy : "+pokaz10lambda.getAsInt());
---------------
BiPredicate<T, R> | boolean test (T t, R r)

BiPredicate<Integer, Integer> czyRowne = (x,y) -> x==y;
System.out.println(czyRowne.test(20,30));
---------------
Predicate<T> | boolean test(T t)

//na strumieniu : (filter) x -> x.rating > 8//x -> new BigDecimal(150).compareTo(x.price) > 0
Predicate<Integer> czyParzystaLambda2 = liczbaDoSprawdzenia -> liczbaDoSprawdzenia % 2 == 0;
System.out.println("Czy liczba 15 jest parzysta : "+czyParzystaLambda2.test(15));
---------------
Consumer<T> | void accept(T t)

//na strumieniu (forEach) System.out::println*po mapowaniu na jeden element z listy np name
Consumer<Integer> pokazILambda = jakasLiczba -> System.out.println("liczba metody accept: "+jakasLiczba);
pokazILambda.accept(123);

Consumer<Integer> listaLiczbConsumer = x -> System.out.print(x+" ");
listaLiczb.forEach(listaLiczbConsumer);
listaLiczbConsumer.accept(listaLiczb.get(0));

-------------------------------------------------------------------------------------------------------------

ODWOLYWANIE SIE DO METOD :: :

ToIntFunction<Object> obiekt = Object::hashCode;
ToIntFunction<KlasaZLiczba> dajLiczbeKlasy = KlasaZLiczba::getX; //int applyAsInt(T t)
KlasaZLiczba ob = new KlasaZLiczba(10);
System.out.println("to liczba z obiektu : "+dajLiczbeKlasy.applyAsInt(ob));

IntSupplier obiekt= obiekt::hashCode;
IntSupplier dajLiczbeObiektu = ob::getX; //int getAsInt()
System.out.println("to liczba z obiektu : "+dajLiczbeObiektu.getAsInt());

IntSupplier dajLiczbeObiektu = KlasaZLiczba::getX; //gdy metodaZwykla getX jest static
System.out.println("to liczba z obiektu : "+dajLiczbeObiektu.getAsInt());

//z konstruktorami

BiFunction<Integer, String, KlasaMoja> obiektInterfejsu = KlasaMoja::new;
KlasaMoja nowyObiektMojejKlasy = obiektInterfejsu("wartosc", 123)


METODY NA STRUMIENIACH:


 */