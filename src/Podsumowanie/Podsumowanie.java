package Podsumowanie;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.List;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class Podsumowanie {
    public static void main(String[] args) throws IOException {
        /*
        --------------SKTORY KLAWISZOWE-------------------

        alt + 1 - ukrycie okienka struktury projektu
        alt + strzalka - przleczanie pomiedy zakladkami
        alt + ins - dodanie pliku
        alt + del - cofniecie usuniecia
        ctrl + y - usuniecie lini


        //skok kursora
        ctrl + lewo/prawo - skok o cale slowo
        ctrl + gora/dow - skroll gora dol

        shift + enter - enter i skok do nowej linii
        ctrl + enter - enter ponizej zostajac w tej samej linii
        ctrl + alt + enter - enter linie wyzej, ide do tej linii

        shift + tab - usuniecie wciecia
        ctrl + del - usuniecie slowa lub wszytkich pustych znako
         i skok do liini wyzej

        //zaznaczaanie
        shit + strzalka - zaznaczenie pojedynczego znaku
        shift + ctrl + stralka - zaznaczenie wyrazu


        ctrl + spacja - podpowiedz
        ctrl + j - podpowiedzi dla klasy
        fori + tab - petla for



        //------------------------------------------------------------------------
        -------------------------------OGOLNE-------------------------------------

        Klasa - projekt/foremka/schemat

        Na jej podstawie tworzone sa jej obiekty, zawiera pola oraz metody
         jakie bedzie mozna wykonywac np przez jej obiekt


        Obiekt/instancja - produkt

        Jest to jednostka zawierajaca stan zapisanych pol oraz zachowania definiowane
         przez metody. Metody odpowiadaja za operacje wykonywane na wewnetrznych stanach
         obiektu oraz komunikacje pomiedzy dwoma roznymi obiektami



        Maszyna wirtualna pomaga zarzadzac pamiecia

        Wersja programu X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle, jest to "procesor" wykonujacy
               skompilowany kod javy (kod bajtowy), dziala ona wyzej niz poziom
               maszynowy aby mogla byc uruchomiona na kazdej platformie
               Jest w niej np Garbage Collector

        JRE - maszyna wirtualna w ktorej programy javy sa uruchamiane

        JDK - zestaw narzedzi zawierajacy takze kompilator javac, maszyne wyrtualna
               do uruchomienia kodu bajtowego javy (JRE), narzedzia tekie jak JavaDoc
               czy Debugger

        IDE (ang. Integrated Development Environment)

        GarbageCollector wykonywany w maszynie wirtualnej Javy JVM i pozbywa sie
         nieuzwyanych przez aplikacje obiektow aby zwolnic pamiec dla nowych.
        Kompaktowanie pamieci jest to ustawienie w pamieci obiektow obok siebie
         aby dostep do nich szybki i prosty


        Hermetyzajca/Enkapsulacja - ustawianie pol klas jako prywatne/protected
         i dostep do niech poprzez akcesory i mutatory

        Rekursja - odwolanie sie do innego konstruktora


        Porowynyanie == porownuje miejsce w pamieci

        Metoda equals porownuje obiekty przez ustalone kryteria i jest zwarta w klasie
         Object wiec moze zostac nadpisana przez moje klasy w celu specyficznego
         porownywania obiektow (ich pol)


        Java 8 wprowadzila:

        -Wyrazenia Lambda
        -Strumienie
        -Meotdy statyczne i podstawowe(default) w interfejsach



        //------------------------------------------------------------------------
        ---------------------------WZORCE PROJEKTOWE------------------------------

        Model MVC - Model View Controller

        Wsorzec dzieli sie na:

        -View - to co widac na stronie, odpowiada za interakcje z uzytkownikiem,
                 wyswietla dane z Modelu
        -Model - przechowuje dane ktore bede wyswieltac w widoku (View) i modyfikowac
                  i komunikuje sie z baza danych np mapowanie tabel
        -Controller - mozg zaplikacji, zawiera logike biznesowa, przetwarza zadania
                       z widoku i przetwarza dane otrzymane z modelu, posrednik
                       pomiedy widokiem i modelem

                  Uzytkownik
                   <-akcja->
                     WIDOK
              <-Aktualizacja widoku-
                -Akcja uzytkownika->
                   KONTROLER
                 <-odczyt danych-
              -Aktualizacja danych->
                      Model

        ----
        Singleton

        Jest to klasa ktorej moge utworzyc jeden obiekt w aplikacji

        Taka klasa posiada:

        -prywatne statyczne pole typu instancji tej klasy kotrej przypisuje
          wartosc poprzez wywolanie jej konstruktora
        //private static MojaKlasaSingleton instance = new MojaKlasaSingleton();

        -prywatny konstruktor nie robiacy nic
        //private MojaKlasaSingleton(){};

        -PUBLICZNA statyczna metode o nazwie getInstance() zwracajaca wartosc
          pola instancji
        //public static MojaKlasaSingleton getInstance(){
            return instnce;
          }

        *W przypaku lazy singletona przypisuje wartosc pola instancji null oraz
          w metodzie ktora ja zwraca dodaje warunek jesli wynosi null to
          przypisuje jej wartosc z konstruktora i nastepnie (po za if) zwracam


        ----
        Singleton do aplikacji wielowatkowych

        Tworze Enum dla klasy np EnumKlasa

        dodaje wartosc
        //INSTANCE;

        nastepnie dodaje prywatne pola klasy np
        //private String imie;

        oraz seter do nich
        //public void setImie(String imie){ this.imie = imie;}

        nastepnie metode w kotrej moge dodac warunki uzaleznione od wartosci moich pol np:
        //public void kimJestes(){
            if(imie == null){ System.out.println("jestes nikim");}
            else{ System.out.println("jestes "+imie);}
          }


        W klasie pordukcyjnej tworze obiekt typu Singleton i przypsiuje wartosc
         z wartosci Enuma
        //EnumKlasa singleton = EnumKlasa.INSTNACE;

        nastepnie na tym obiekcie moge wywolac metode oraz setery
        //singleton.kimJestes();
        //singleton.setImie("kamil");

        UWAGA
        po serializacji wartosci pol zostana wyzerowane!


        ----
        Obserwator

        Popularny w palikacjach z rozbudowanym interfejsem graficznym

        Wystepuje obiekt (subject)

        Akcje moga sie wydarzyc w dowolnym momencie (np wcisniecie dowolnego guzika)
         dlatego caly czas musi dzialac menager zdarzen (Obserwator/Listener)
        Przez caly czas nasluchuje i jesli przycisk zostanie wcisniety podejmuje
         konkretna akcjie
        Jest to programowanie sterowane zdarzeniami Event Driven Programming

        Przyklad:
        Wyslany mail (zdarzenie) przez uzytkownika (podmiot) do prcownika (obserator)
         ktory wykonuje odpowiednie zadanie


        ----
        Schemat fabryk (Factory Pattern)

        Wykorzystuje gdy chce tworzyc duza ilosc obiektow implemtujacych ten sam
         interfejs lub rozszerzajacy jedna klase

        Przydatne takze jesli chce przekazac duza ilosc parametrow do konstruktora


        Implementacja:
        Klaca bazowa ma unikalna metode klasy po ktorej dziedziczy lub interfejsu
         (metody w klasach maja unikalna funkcjonalnosc) np work()

        Tworze klase Fabryki np RobotFactory w ktorej dodaje publiczna
         metode np makeRobot zwracajaca obiekt typu interfejsu lub klasy po kotrej
         moje klasy dziedzicza np Robot ktora jaka poarametr przyjmuje zmienna
         ktorej wartosc bedzie okreslala jaki obiekt zwrocic metoda
        //pubic Robot makeRobot(String robotType){
        W ciele metody podaje warunku dla zmiennej robotType aby wybrac jakiego
         typu ma zostac obiekt obiekt zwrocony np:
        //if(robotType == "DRILLING ROBOT"){ return new DrillingRobot();}
        Po za warunkami daje return null

        W klasie gdzie tworze obiekty - tworze jeden obiekt klasy fabryki
        //RobotFactory robotFactory = new RobotFactory();
        Nastepnie twrze obiekty typu interfejsu lub klasy po ktorej moje klasy
         dziedzicza i przypisuje im wartosc porzez wywolanie na obiekcie fabryki
         metody i przekazanie jako parametr wartosc ktora wybierze typ obiektu np:
        //Robot drillingRobot1 = robotFactory.makeRobot("DRILLING ROBOT");
        //Robot badJokeRobot = robotFactory.makeRobot("BAD JOKE ROBOT");

        Na koniec na kazdym z tych obiektow moge wywolac wspolna metode
         ktora zosatanie wybrana z odpowiedniej klasy na podstawie typu obiektu
        //drillingRobot1.work();
        //badJokeRobot.work();


        ----
        Fabryka Abstrakcyjna (Abstract Factory)

        Sluzy do tego aby stowrzyc kolejny poziom Fabryk na zasadzie wzorca Fabryki


        ----
        Builder

        Uzywany gdy tworzony obiekt ma wiele parametrow



        Klasa bazowa posiada prywatne pole ustawione na null/0 + setery i getery
         np Burger

        Tworze interfejs do tej klasy np BurgerBuilder zawierajacy metody
        -tworzenie obiektu klasy
          //Burger build()
        -zwracanie obiektu interfejsu z nazwa setera i przyjmujaca odpowiedni
          parametr adekwatny do zmiennej klasy bazowej np:
          //BurgerBuilder setMeat(final String meat);
          //BurgerBuilder setSauce(final String sauce);

        Tworze klase ktora bedzie imlemntowac ten interfejs i deklarwoac
         dzialanie metod np: BurgerBuilderImpl implements BurgerBuilder
        Zawierac ona prywane pole obiektu klasy bazowej bez przypisanej wartosci
         oraz konstruktor bezparametrowy ktory przypisze mu wartosc poprzez
         wywolanie konstruktora klasy bazowej
         //private Burger buger;
         //public BurgerBuilderImpl(){ burger = new Burger();}
        Przykladowa implementacja metod:
         //public Burger build(){ return burger;}
         //public BurgerBuilder setMeat(String meat){
             burger.setMeat(meat);
             return this;}

         W klasie produkcyjnej tworze obiekt interfejsu ktoremu przypisuje
          wartosc poprzez wywolanie konstruktora klasy ktora go implementuje
         //BurgerBuilder builder = new BurgerBuilderImpl();
         Nastepnie na tym obiekcie operuje poprzez jego metody (metody klasy impl)
         //builder.setBread("White");
         //builder.setSauce("BBQ");
         Nastepnie tworze obiekt klasy bazowej i przupisuje mu wartosc poprzez wywolanie
          na obiekcie builder metody build
         //Burger burger = builder.build();


        ----
        DAO

        Data Access Object - sluzy do stworznie abstrakcyjen wartwy aplikacji
         rozdzielajacej logike biznesowa od bazy danych

        Klasa DAO implementuje interfejs DAO ktory zawiera wszystkie metody (statyczne)
         operacji na bazach danych CRUD (crate, retrive, update, delete) i tworzy
         ich implemetacje

        Klasa logki biznesowej (np Kontroller) wykorzystje metody intefejsu
         do dzialania na bazach dancyh nie ingerujac w ich implementacje
         dzieki czemu jesli wykonam jakas akcje na bazie danych to logika
         biznesowa pozostanie bez zmian

        Dane przkazywanie danych sluza beany

        Wywoluje metody interfejsu DAO w aplikacji i wysylam lub otrzymuje
         bean/y np FakturaDAO.utworzFakture()


        ----
        SOLID

        Sa to zasady projektowania aplikacji

        S - Single Rensponsibility Principle (SRP) zasada jednej odpowidzialnosci

        O - Open Closed Desig Principle (OCD) zasada otwarty-zamkniety

        L - Liskov Substitution Principle (LSP) zasada podstawienia Liskov

        I - Interface Segregation Principle (ISP) zasada segregacji interfejsow

        D - Dependency Inversion Principle (DIP) zasada osrocenia zaleznosci









        //------------------------------------------------------------------------
        --------------------------SPRING TEORIA ----------------------------------

        Bean jest to podstawowy obiekt do przekazywania danych pomiedzy poszczegolnymi
         czesciami aplikacji

        Skladaja sie z prwyatnych pol, seterow, geterow oraz pustego konstruktora

        Przykladem jest Spring Bean na kotrym operuje Spring Framework


        Spring jest to framerwork stworzony glownie do aplikacji webowych

        Mozemy w nim latwo laczyc dane pomiedzy komponentami za pomoca wstrzykiwania
         zaleznosci

        Spring jest lekki (podstawa ok 2MB)

        Posiada Odwrocenie sterownia (Inversion of Control) - polega to na tym ze
         funkcja sterowania przeplywam jest sterowana przez Springa ktory
         oddziela "co zrobic" od "kiedy zrobic"

        Spring posiada kontener w ktorym przechowywane sa Spring Beany

        Spring pozwala na tworzenie aplikacji opartch o model MVC, tzn
         mozna tworzyc aplikacje webowe oraz oraz web serwisy (Restful web services)

        W Springu latwo pisac testy poniewaz logika biznesowa nie zawiera bezposrenich
         zaleznosci przez co testy pisane sa za pomoca mockowych (pozornych) beanow


        Wstrzykiwanie zaleznosci pozwala na luzne laczenie obiektow aplikacji aby
         mogly ze soba wspolpracowac (loosecoupling)
        Dzieki temu sa one niezalezne
        Aplikacje latwo rozbudowywac
        Latwo wykonywac testy

        Wstrzykiwanie zaleznosci realizuje poprzez adnotacjie @Autowired bezposrenio
         do pol lub za pomoca konstruktora/setera


        Spring Beany sa to obiekty zarzadzane przez kontener Springa, tworzone sa
         za pomoca plikow xml, lub przy pomocy klas konfiguracyjnych @Configration
         z adnotacja @Bean


        Zasieg Beana:
        -singleton - zawsze bede operowal na tym samym beanie
        -prototype - gdy bede pobieral beana bede otrzymywal nowa jego kopie
        -request - w aplikacjach webowych, bean bedzie na nowo tworzony za kazdym
          zapytaniem http
        -session - w aplikacjach webowych, bean bedzie raz tworzony w sesji http
        -global-session - j.w. bedzie tworzony w golbalnej sesji


        Wstrzykiwanie moze byc realizowane na podstawie:
         -typu danych
         -nazwy
         -konstruktora
         -autodetekcje


         Spring Security

         Jest to wewnetrzny framewrk springa ktory odpowiada za uwierzytelnianie
          i autoryzacje

         Dziala na zasadzie filtrow ktore musi przejsc kazde zapytanie do aplikacji


        //------------------------------------------------------------------------
        -----------------------------ZMIENNE PROSTE-------------------------------

        Zmienne dzielimy na prymitywne i zlozone (nie-prymitywne np String, Array, List)

        Zmienne prymitywne zapisuje mala litera a zlozone duza

        Podstawowe zmienne prymitywne:
        -boolean
        -char
        -byte
        -short
        -int
        -long
        -float

        */

        int zmiennaInt = 123; //nie moze miec koncowki i/I
        //zakres +/- 2,147,483,647

        int liczba = 1234_123;//liczba z literalem - ulatwia czytelnosc
        //pokaze liczbe normalnie
        int liczba2 = -0xFF00;//w systemie szesnastkowym
        int liczba3 = 0777;//w systemie osemkowym (511)

        long liczba5 = 1232455;//opcjonalnie L
        long liczba4 = 123L;//daje informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"

        float liczba6 = 123.34F;//MUSI byc "F" lub "f" na koncu!

        double liczba7 = 213.45;//opcjonalnie z d lub D

        short liczba8 = 234; //nie moze miec koncowki s/S

        boolean prawdaFalsz = true;
        //zakres true/false

        String napis = "asd\n123";


        //-----
        //BOXING unboxing

        /*
        Klasy typu Boolean/Float to klasy wrapperclass

        Dzieki nim moge uzywac typow prymitywnych np w listach/mapach
        */

        Integer zmiennaIntegerBox = 12;


        //Autoboxing jest to automatyczne konwertowanie typu prostego do wrappera
        Integer zmiennaIntegerX = new Integer(123);

        //Autounboxing jest to przypisanie zmiennej Obiektowej np Integer do int
        int zmiennaIntX = zmiennaIntegerX;


        //----
        /*Zmienne finalne

        liczba finalana musi miec zadeklarowana wartosc od razu chyba ze:
         -jej przypisanie wartosci jest w konstruktorze klasy
         -jest zadeklarowana lokalnie(w metodzie)

        wartosc liczby finalnej raz zadeklraowanej NIE MOZNA zmienic

        zalecane jest pisanie wszystkiego WIELKIMI_LITERAMI i oddzielac
         slowa "_"
        */

        final int LICZBA_FINAL; //deklaracaj lokalna czyli w metodzie(teraz main)
        // wiec nie musze nadawac wartosci odrazu

        LICZBA_FINAL = 12;

        /*




        //------------------------------------------------------------------------
        ----------------------POROWNYWANIE TYPOW PROSTYCH-------------------------

        Oparator == lub !=


        -----kolejnosc operatorow
        Operator +/-/* ma wiekszy priorytet niz ==!
        2+3==10; //najpierw doda a potem porowna

        "10 == 10: " + 10 == 10 // compilation error!
         najpierw String "10 == 10: " dodaje do 10 czyli wychodzi
         "10 == 10: 10" a nastepnie porownuje go z intem 10 - BLAD!

        "10 == 10: " + (10 == 10)
        //da wynik 10 == 10: true


        -----
        porownywanie liczb zmiennoprzecinkowych polega
         na odjeciu ich od siebie w wartosci bezwzglednej
         z dodaniem dokladnosci */
        System.out.println(Math.abs(0.7 - 0.7) < 0.00001);

        System.out.println("10 == 10: " + (10 == 10));
        /*

        -----
        Moge takze porownac elementy wykorzysttujac metrody compare/compareTo/equals*/
        KlasaDoSortowania obiektKlasy = new KlasaDoSortowania("asd");
        String string1 = "asd";
        String string2 = "asd";
        Integer mojInteger = 1234;
        int[] intsTab = {1234,2134};

        Integer.compare(1,2);
        Character.compare('c','d');
        Double.compare(23.2, 234.2);
        Arrays.compare(intsTab,intsTab);
        //uzywam tej metody w klasie sortujacej i implementujacej Comparator<klasa>
        //Collections.sort(listaObiektow, new obiektKlasySortujacej())

        string1.compareTo(string2);
        string1.compareToIgnoreCase(string2);
        mojInteger.compareTo(mojInteger);
        obiektKlasy.compareTo(obiektKlasy);//klasa musi miec ta metode w deklaracji!!
        // + implementowac interace Comparable
        //Collections.sort(listaObiektow)

        Objects.equals(string1, string2); //dla Stringow
        Arrays.equals(intsTab, intsTab); //dla tablic
        string1.equals(string2);
        mojInteger.equals(mojInteger);
        intsTab.equals(intsTab);
        obiektKlasy.equals(obiektKlasy);//klasa musi miec metode equals w ktorej
        // wybieram jakie pola klasy bede porownywal
        /*



        //------------------------------------------------------------------------
        --------------------------------ZMIENNA STRING----------------------------

        String jest to klasa w pakiecie java.lang

        Literal znakowy jest to ciag znakow w "" np instancja klasy String.

        String jest specyficzna zmienna obiektowa

        Intancja klasy String nie musi byc tworzeona ze slowem new

        String w odroznieniu od typow prymitywnych ma swoje miejsce w pamieci
         lokalnej - string pool

        Jesli stringi zawieraja taki sam literal to sa przechowywane w tym
         samym miejscu w pamieci chyba ze uzyjemy slowa new String("napis)

        Jesli zadeklaruje zmienna String bez slowa new wyladuje ona w pamieci
         lokalnej w kontenerze o nazwie String pool, jesli z to w pamieci
         lokalnej bezposrednio

        W Stringu nie powiniennem przechowywac hasel poniewaz przez proste
         przypisanie obiekt String laduje w string pool z dluzsza zywotnoscia
         niz w pamieci lokalnej (heap) przez co uzytkownik z dostepem
         do pamieci moze taki obiekt przechwycic
        Dodatkowo nie mozna pozbyc sie zawartosci obiektu String (immutable)
        Hasla powinny byc przechowywane w tablicy znakow char[]


        String itern:

        Jest takze metodaZwykla .intern();

        Jesli wywolam ja na Stringu z konstruktorem new String("wartosc");
         i wystapi String z takim samym literalem to zostanie on "podpiety"
         pod tem sam adres (miejsce w cache) pomimo uzycia alokacji
         pamieci z uzyem slowa new np:
         */
        String mojLiteral = "jakis napis";
        String mojLiteralNiePodpiety = new String("jakis napis");
        String mojLiteralKopia = new String("jakis napis").intern();

        System.out.println();
        System.out.println("porownanie bez itern : "+(mojLiteral==mojLiteralNiePodpiety));
        System.out.println("porownanie z itern : "+(mojLiteral==mojLiteralKopia));
        System.out.println();



        /*
        String przetrzymuje znaki w tablicy znakow char[]


        Instancje klasy String sa niemutowalne czyli kazda zmiana
         powoduje stworzenie nowego obiektu klasy String

        Zwiazane jest to z:
         -bezpiczenstwem - dane typu nazwa uzytkownika / haslo polaczone z baza danych nie
                            jest tak latwo zmienic przez co jest wieksze bezpieczenstwo
         -synchronizacja - w programach wielowatkowych niezmienialnosc stringa
                            rozwiazuje problem z synchronizacja
         -zarzadzanie pamiecia - jesli obiekty maja ta sama wartosc moga byc
                                  umieszczone w jedym miejscu w pamieci


         */

        //----
        //Przypisywanie wartosci
        String jakisString = "costam";
        String jakisStringZLiczba = "costam123";
        //String liczbaString = 123; - blad
        String laczonyString = "costam123" + 123;
        // z konkatenacja moge polaczayc z intem, moge nawet polaczyc z pustym
        // Stringiem tj "" lub moge wykorzystac metode valueOf()
        String laczonyString2 = laczonyString + 345;


        /*
        String jest charakterystycznym obiektem poniewaz ta sama jego wartosc
         jest alokowana w tym samym adresie w pamieci lokalnej w string pool
         GDY PRZYPISUJE GO POPRZEZ =
         */
        String napis1 = "test";
        String napis2 = "test";

        String napis3 = new String("test");
        //Tutaj rezerwuje specjalnie oddzielnie miejsce w pamieci (lokalnej)
        // poza string pool
        // wiec po mimo tej samej wartosci napis3 i napis1/2 porownanie proste
        // == da false, wiec nalezy porownac to metoda .equals()

        // porownanie == porownuje adresy a string przypisany za pomoca "="
        // jesli ma wartosc rowna innemu stringowi przypisanemu za pomoca "="
        // to laduje w tym samym miejscu w pamieci (string pool) wiec porownanie
        // == da wynik true

        System.out.println("Porownanie napis1 i napis2: " + (napis1 == napis2));
        //Pamietam o nawiasie bo inaczej doda moj "" do napis1 a nastepnie
        // porowna z napis2!
        System.out.println("Porownanie napis1 i napis3: " + (napis1 == napis3));

        //Porownujac zmienne obiektowe poprzez == porownuje ich adresy!!
        // a wiec pokaze false poniewaz dalem new String.
        //Poprawnym porownaniem jest metoda equals() ktora porownuje obiekty

        System.out.println("Poprawne porownanie napis 1 i napis 3: " + napis1.equals(napis3));


        //Konkatenacja (laczenie stringow)
        /*
        Kazda modyfikacja stringa to tworznie nowgo obiektu
        String x = "Kasia"
        String s = x+" i Tomek"; // to tak naprawde:
        s = new StringBuilder(x).append(" i Tomek").toString();


        Uzywany jest znak + lecz laczy on lewostronnie np
        1 + 2 + "test" // 3test
        "test" + 1 + 2 // test12
        Wyswietlajac jakas instancje klasy uzywana jest metodaZwykla tej klasy toString
        */


        //metoda String.valueOf(); - PRZYJMUJE int/Integer/String, ZWRACA String
        Integer integer4 = new Integer(1354);

        String stringZInta = String.valueOf(integer4);
        String stringZInta2 = String.valueOf(1234);
        String stringZeString = String.valueOf("123d4");


        //----
        //Biblioteka zawierajaca wiele metod dla Stringa jest bo commons-lang a w niej
        // np klasa StringUtils zawierajaca wiele metod dla lancuchow znakow

        //Popularna metody Stringa:
        String str = "132";
        String strX = "132";

        str = str.trim(); //usuniecie bialych znakow na poczaku i koncu
        str = str.toUpperCase().toLowerCase();
        boolean b1 = str.isEmpty();
        int i1 = str.length();
        char[] t1 = str.toCharArray();
        char ch1 = str.charAt(0);

        str = str.substring(1, 2);//wyciaga przedzial stringa od poz 1 do 2(nr pozycji w int)
        str = str.substring(1);//wyciagnie przedzial od poz 1 do konca
        String[] t2 = str.split("asd");//podzieli tam gdzie wystapi "asd"
        str = str.replace("asd", "asd");
        boolean b2 = str.matches("test");
        int i2 = str.indexOf("1");
        i2 = str.lastIndexOf("1");

        boolean b3 = str.equals(str);
        str = str.concat("123").concat(str);
        boolean b4 = str.startsWith("123");
        boolean b5 = str.endsWith("123");
        boolean b6 = str.contains("123");

        byte[] t3 = str.getBytes();
        int i3 = str.compareTo(strX);//porowna alfabetycznie
        //gdy str bedzie "wiekszy" zwroci -1, gdy "mniejszy" 1 i gdy rowny to 0


        //----
        //Moge przeniesc zawartosc listy do Stringa za pomoca metody join
        List<String>auta = Arrays.asList("audi","mercedes");
        //Wykorzystuje metode asListy klasy Arrays
        String autaString = "";//musze zainicjowac wartoscia do metody join
        autaString = autaString.join(",",auta);
        //przypisuje do Stringa z metodaZwykla join()
        System.out.println("String zrobiony z listy: "+autaString);

        //Bardziej zaawansownym uzyciem metody join jest uzycie strumienia
        // oraz metody collect() w ktorej uzyje klasy Collectors z metodaZwykla
        // joining() w ktorej okresle co ma oddzielac napisy oraz jak ciag
        // ma sie zaczynac i konczyc
        String autaString2 = auta.stream().collect(Collectors
                .joining(", ","{","}"));
        System.out.println("String zrobiony ze strumienia: "+autaString2);



        /*------------------------------------------------------------------------
        -----------------StringBuilder/StringBuffer/StringJouner------------------

        StringBuilder,StringBuffer sa klasami ktorych obiekty sa zmienialne,
         obiekty sa umieszczane w pamieci lokalnej a nie w String pool,
         obiekty tworze ze slowem new, StringBuffer i String sa bezpieczne
         wielowatkowo, StringBuilder ma najwyzsza wydajnosc

        Klasy String, StringBuilder, StringBuffer sa final przez co nie moga
         byc rozszerzane natomiast nie ma to znaczenia jesli chodzi o
         modyfikowalnosc ich obiektow


        StringBuilder
        Ta klasa takze zawiera ciag w tablicy znakow char[] lecz mozna
         ja zmieniac i konwertowac do String uzywajac toString
        */
        StringBuilder mojSB = new StringBuilder("123");
        StringBuilder mojSBpojemnosc = new StringBuilder(123);
        //Konstruktor moze przyjac wartosc ciagu lub jesli podam liczbe to jego
        // pojemnosc (capacity)

        StringBuilder mojSB2 = new StringBuilder();
        mojSB2.append(2).append("123").append(mojLiteral).append(12.3);
        //append moze przyjac dowolny typ

        //metody:
        mojSB.ensureCapacity(13);//z zakresem 16/34/dokladnym
        mojSB.append("123").append(str);
        mojSB.replace(0,1,"123");
        mojSB.insert(0, "123");
        mojSB.reverse();
        mojSB.delete(0,1);
        int i4 = mojSB.indexOf("x");
        int i5 = mojSB.capacity();
        int i6 = mojSB.length();
        char c = mojSB.charAt(0);
        String str2 = mojSB.substring(1,2);
        String strS = mojSB.toString();


        /*----
        StringBuffer

        Mozna uzywac go bezpiecznie nawet w aplikacjach wielowoatkowych

        Jej instancje nie powinny byc wspoldzielone pomiedzy watkami

        Klasa StringBuffer ma synchronicje przez co jest wolniejsza!


        ----
        StringJoiner

        Wykorzystuje do laczenia strumieni
        Rozwiazuje problem wyrazen lambda oraz upraszcza laczenie Stringow
        */

        System.out.println("StringJoiner");
        StringJoiner joiner = new StringJoiner("");
        //Musze okreslic w konstruktorze 1 lub 3 parametry, gdy podam jeden
        // bedzie to separator oddzielajacy stringi, gdy podam 3 bedzie to
        // separator, prefix(to co na poczatku ciagu) i suffix(na koncu)

        StringJoiner joiner2 = new StringJoiner(",","{","}");

        joiner2.add("napis").add("napis2");
        String napisSJ = joiner2.toString();
        //Nie ma metody substring();
        System.out.println("Dlugosc StringJoinera: "+joiner2.length());
        System.out.println("StringJoiner na String: "+napisSJ);



        //------------------------------------------------------------------------
        /*-------------------------ZMIENNA INTEGER--------------------------------
         */
        Integer integer = 123; //boxing
        Integer integer1 = new Integer("123123");
        Integer integer2 = new Integer(12345);


        //metoda Ingeger.parseInt(); - PRZYJMUJE String, zwraca int/Integer
        int intZeString = Integer.parseInt("1234");
        Integer IntegerZeString = Integer.parseInt("1234");


        //metoda Integer.valueOf() PRZYJMUJE int/Integer/String, ZWRACA int/Integer
        int intZInta = Integer.valueOf(123);
        int intZInt4 = Integer.valueOf("1345");
        //jesli bedzie niepoprawne wywali wyjatek NumberFormatException
        Integer intZInta3 = Integer.valueOf(123);
        Integer intZInta4 = Integer.valueOf(new Integer(1234));


        //metoda Character.getNumericValue() PRZYJMUJE char, ZWRACA int/Integer
        int znak = Character.getNumericValue('a');//pojedynczy ''!
        // znak = 10, niezaleznie od wielkosci


        Integer.compare(integer1, integer2 );
        //Zwroci 1 gdy integer2 wiekszy, -1 gdy mniejszy i 0 gdy rowny
        //Przydante podczas tworzenia metod compare() oraz compareTo()

        integer1.compareTo(integer2);
        //Zwroci 1 gdy integer2 wiekszy, -1 gdy mniejszy i 0 gdy rowny




        //------------------------------------------------------------------------
        /*----------------------KLASA MATH I BIGINTEGER---------------------------
         */
        Math.abs(9);
        Math.pow(2,2);
        Math.sqrt(4);
        Math.round(9.26134); //zaokrlaglenie
        Math.min(10,12);
        Math.max(10,12);


        BigInteger bi = new BigInteger("1234");
        BigInteger bi2 = BigInteger.valueOf(1234);
        BigDecimal bd = new BigDecimal("123132.3244");

        bi.add(bi2);
        bi.subtract(bi2);
        bi.multiply(bi2);
        bi.divide(bi);



        //------------------------------------------------------------------------
        /*------------------------------KLASA RANDOM------------------------------
        */
        Random random = new Random();
        boolean prawdaCzyFalsz = random.nextBoolean();
        double los = random.nextDouble();
        // pokaze od 0 do 1 (0+jakies liczby po przecinku), moge pomnozyc aby przesunac ,
        float los2 = random.nextFloat();//mniejszy zakres
        int los3 = random.nextInt();//standardowo pokaze z calego zakresu
        // int lecz moge to zawezic podajac liczbe w paramterze np:
        int los4 = random.nextInt(10); //wylosuje liczbe z zakresu 0-9



        //------------------------------------------------------------------------
        /*--------------Formatter - formatowanie łańcuchów znaków-----------------

        Do formatowania moge uzyc:
        -PrintWriter.format - metodaZwykla ktora wywoluje na obiekcie Formatter
         a nastepnie moge na tym obiekcie wywolac toString

        -System.out.format - statyczna metodaZwykla w klasie String dziala jak ta
         na obiekcie Formatter lecz wyswietla bezposrednio na ekran
         */

        //Przyklady:
        Formatter mojFormatter = new Formatter();
        mojFormatter.format("Urodzilem sie w %d i mam na imie %s", 1991, "Kamil");
        String formatterString = mojFormatter.toString();
        System.out.println(formatterString);

        //lub z uzyciem system.out.format
        System.out.format("Urodzilem sie w %d i mam na imie %s", 1991, "Kamil");


        /*----
        Sekwencje
        Sekwencje ktore uzupelniamy maja wzor:
        %[indeks argumentu$][flagi][szerokość][.precyzja]konwersja

        W pierwszym przykladzie uzylem %d i %s i sa to same flagi d i s;

        Znaczniki:
        %b - wartosc logiczna
        %s - lancuch znakow
        %d - liczba calkowita
        %o - liczba calkowita w systemie osemkowym
        %x - liczba calkowita w systemie szesnastkowym
        %f - liczba zmiennoprzecinkowa
        bez argumentow:
        %% - doslowne umieszczenie %
        %n - dodanie nowej linii

        //-Indeks argumentu [liczba$] - sluzy do tego aby uzyc jednego argumentu kilka razy
        liczone od 1!
        np */
        System.out.println("\n");
        System.out.format("[%2$s] [%1$s] [%1$s]", "pierwszy argument", "drugi argument");
        //2$ - oznacza ze uzyje 2 argumentu
        //s - oznaczajaca ze to ciag znakow
        //wynik:
        //[drugi argument] [pierwszy argument] [pierwszy argument]

        //-Szerodkosc [liczba] (minimalna)
        //np:
        System.out.println();
        System.out.format("[%10s] [%3s]", "test", "test");
        //10 - szerokosc 10 znakow (uzupelni pustymi znakami od lewej
        //3 - szerokosc ale ciag jest dluzszy wiec zapisze wszystko!
        //wynik
        //[      test] [test]

        //-Precyzja [.liczba] (dokladnosc dla liczb zmiennoprzecinkowych)
        //np:
        double dd = 1.1234567;
        System.out.println();
        System.out.format("[%.10f] [%.3f] [%f]", dd, dd, dd);
        //.10 - wyswietli 10 miejsc po przecinku, jak brakuje to doda 0
        //.3 - wyswwietli 3 miejsca, reszte obetnie
        //bez niczego - wyswietli calosc
        //wynik:
        //[1.1234567890] [1.123] [1.123457]

        /*
        -Flagi (dodatkowe zachowanie znacnzikow konwersji)
        - szerokosc bedzie powiekszana z prawej strony : "|%-10d|",3 -> |3         |
        + liczba zawsze będzie zawierała znak (nawet jeśli jest dodatnia) : "%+d",3 -> +3
        0 liczba będzie uzupełniona 0 do żądanej szerokości : "%010d",3 -> 0000000003
        ( liczby ujemne nie będą prezentowane ze znakiem : "%(d",-323 -> (323)
        // tylko liczby ujemna da w nawias
        , użyj separatora do grupowania liczb : "%,d",1000000 -> 1 000 000
         */

        //Lokalizacja [Locale.KRAJ/forLanguageTag("KRAJ")]
        double someNumber = 12345.12;
        System.out.println();
        System.out.format(Locale.US, "%,.2f%n", someNumber);
        //12,345.12
        System.out.format(Locale.GERMAN, "%,.2f%n", someNumber);
        //12.345,12
        System.out.format(Locale.forLanguageTag("PL"), "%,.2f%n", someNumber);
        //12 345,12


        //----
        /*Kombinacja %3$(,08.3f
        3$ - 3 argument
        ( - otocznie ujemnych liczb nawiasami
        , - seperacja liczb
        0 - uzupelnienie zerami do konca szerokosci
        8 - szerokosc
        .3 - 3 miejsca po przcinku
        f - liczba zmiennoprzecinkowa



        //------------------------------------------------------------------------
        //-------------------------PETLE I WARTUNKI-------------------------------
        */
        //Switch
        int a = 10;
        switch (a){
            case 2:
                //zrob cos
                break;//bez break wykona kolejny case
            case 11:

                break;
            default:
                //nie musze dawac break, wykona sie jak zaden case nie bedzie pasowac
        }


        //----
        //while
        while (true){
            //zrob cos
            break;
        }

        int aWhile = 10;
        while(aWhile>0){
            System.out.println("Drukuje napis while :"+aWhile);
            //10-1
            aWhile--;
        }


        //----
        //do while
        do{
            System.out.println("robie do : "+aWhile);
            //0-9
            aWhile++;
        }while (aWhile<10);//SRENIK!


        //----
        //for
        for (int i = 0; i < 10; i+=10) {
            if(a>10){
                break;//opcjonalne wyjscie z petli for
            }
        }




        //------------------------------------------------------------------------
        /*---------------------------------METODY---------------------------------

        Metoda - worek do grupujacy zestaw instrukcji. Tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc

        Metoda moze byc zwykla(odnoaszaca sie do instancji klasy/obiektu) lub
         statyczna(odnoszaca sie do klasy)

        Metoda finalna nie moze byc przeslonieta! (nadpisana w innej klasie dziedziczacej)
         final void metoda();

        Klasa moze posiadac tez metode staric ktora wykona sie po skompilowaniu klasy

        private static Map<String, Imie> pracownicy = new HashMap<>();
        static{
            pracownicy.put("Pawel", new Imie("pawel));
        }
        private static Optional<Imie> znajdz(String imie){
            return Optional.ofNullable(pracownicy.get(imie));
        }
        //teraz wywolujac metode statyczna w innej klasie mam dostep do statycznych
          pol jak np mapa
        Optional<Imie> pracownik = PracownikRepository.znajdz("Pawel");

         */
        class Wew1 {
            public /* static */String metodaDajacaString(int liczba) {
                //nie moge dac static bo jetsem w main
                return String.valueOf(liczba);
            }

            public int metodaDajacaInt(String napis) {
                return Integer.parseInt(napis);
            }

            public boolean czyDobraLiczba(int x) {
                boolean czyParzysta = x % 2 == 0;
                boolean czyWiekszaOd0 = x > 0;
                boolean czyMniejszaOd10 = x < 10;

                return (czyMniejszaOd10 && czyWiekszaOd0) || czyParzysta;
                //metoda da true jesli podana liczba bedzie wieksza od 0 i
                // mniejsza od 10 LUB bedzie parzysta!
            }
        }

        /*
        Metody DEKLARUJE TYLKO w klasie (nie w innych metodach)

        Metody nie powinny przyjmowac duzej ilosc argumentow ("code smell")

        Metode moge wywolac tylko w innej metodziena chyba ze deklaruje zmienna i
         przypisuje za pomoca metody wartosc "int zm = metodaDajInt();

         Metody wywoluje na obiekcie lub bezposrenio lub z pomoca klasy w ktorej
          sie znajduje jesli jest statyczna:

         mojObiekt.mojaMetoda();
         mojaMetoda();
         Klasa.mojaStatycznaMetoda();

        W statycznej metodzie(np main) NIE MOGE odwolac sie bezposrenio
         do niestatycznej metody poniewaz main jest statyczny!!

        Metoda nie zwracajac nic void moze posiadac slowo return ale
         nie moze nic zwracac
         */
        class Wew2 {
            public void metodaNicNieZwracajaca() {
                return;
            }
        }
        /*

        Metoda moze przyjac nieokreslona liczbe argumentow poprzez zastosowanie ...
        */
        class Wew34{
            void main(){
                metodaSumujaca(1,2,3,4);
                int[] tabInt = {1,2,3,4};
                metodaSumujaca(tabInt);

            }
            public int metodaSumujaca(int...tab){
                int suma = 0;
                for(int x:tab){
                    suma+=x;
                }
                return suma;
            }
        }
        /*


        -----
        Przeciazenie metody (overload) jest gdy ta sama klasa
         ma kilka metod o tej samej nazwie ale przyjmujace inne
         parametry

        public void metoda(){}
        public void metoda(int a){}


        ------
        Przesloniecie metody (override) gdy klasa pochodna ma taka
          metode z taka sama nazwe i taka sama ilosc i rodzaj parametrow



        //------------------------------------------------------------------------
        --------------------------WPROWADZANIE DANYCH-----------------------------
        */
        class Wew3 {
            void start() throws IOException {
                String imie;
                List<String> imiona = new ArrayList<>();
                Scanner wejscie = new Scanner(System.in);

                //przyklad:
                do {
                    imie = wejscie.nextLine();
                    //wpisuje imie
                    if (!imie.equals("-"))
                        //jesli nie wpisalem - doda do listy
                        imiona.add(imie);

                } while (!imie.equals("-"));
                //wyjscie z petli

                //lub w samym while
                while (true) {
                    imie = wejscie.nextLine();
                    if (imie.equals("-"))
                        break;
                    imiona.add(imie);
                }

                //inny przyklad
                while (true) {
                    try {
                        imie = wejscie.nextLine();
                        if (imie.equals("-")) {
                            break;
                        }
                        if (imie.equals("Kamil")) {
                            throw new IllegalArgumentException("jest juz kamil!");
                        }
                        imiona.add(imie);
                    } catch (InputMismatchException e) {
                        wejscie.next();
                    }
                }

                //inny przyklad z hasNext
                String s = "Hello World! 3 + 3.0 = 6";
                Scanner scanner = new Scanner(s);
                //umieszczam w scanner moj napis
                System.out.println("" + scanner.hasNext());
                //sprawdza czy skaner ma token(cos dalej) - true
                System.out.println("" + scanner.nextLine());
                //wypisuje na ekran zawartosc i przesowna token na ostatnia pozycje
                System.out.println("" + scanner.hasNext());
                //token jest na koncu - false
                scanner.close();
                //zamykam

                //inny przyklad z hasNext z czytaniem pliku
                Scanner scanner2 = new Scanner(new File("filepath"));
                //skaner zawiera teraz plik
                ArrayList<String> list = new ArrayList<>();
                while (scanner2.hasNext()){
                    //jesli token jest na koncu (koniec pliku) wychodzi z petli
                    list.add(scanner2.next());
                    //umieszczam elementy do listy. kazdy element z pliku
                    // jest oddzielony spacja (metoda next)
                    // tj. pierwszy wyraz element 0 , 2 ->1 itp.
                }
                scanner2.close();//musze zamknac


                //-----
                //Z BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int x = Integer.parseInt(br.readLine());
                String y = br.readLine();

            }
        }



        //------------------------------------------------------------------------
        /*------------------------Modyfikatory dostepu----------------------------

        Public / Protected / Private / Brak


        Pole - brak/**public/**protected/**private/*final
         *jesli zmienna globalna - musze zadeklarowac wartosc lub
         *przypisac ja w konstruktorze, jesli zmienna lokalna - nie musze
         *od razu przypisywac wartosci!
         **tylko dla zmiennych globalnych!

        Klasa - brak/public/**private/**protected/final*
         *nie mozna jej w takim wypadku rozszerzac!
         **tylko dla klas wewnetrznych NIELOKLNYCH
         ***klasa wewnetzna LOKLANA nie moze miec modyfikatora!

        Metoda -  brak/public/protected/private/*final
         *nie mozna jej nadpisac
         ** nie deklaruje metod w metodach!


        ----
        Public - dostepny wszedzie (klasa / pola / metody / typ wewnetrzny)

        Protecetd - dostepny dla METOD / POL / TYPOW WEWNETRZNYCH (NIE MOZNA DO KLAS!)
         pozwala na dostep w klasach nizej i nawet w innych pakietach
         Dane z tym modyfikatorem dostepne sa takze w tym samym pakiecie!!

        Brak modyfikatora - dostepny dla wszystkiego, dostep tylko w tym samym pakiecie

        Private - dostepny dla klas wewnetrznych NIELOKALNYCH / metod / pol


        OGOLNA TABELA MODYFIKATOROW
        Modyfikator	        Klasa	Pakiet	Podklasa	Inni	Poprawny dla klas
        public	            tak	    tak	    tak	        tak	    tak
        protected	        tak	    tak	    tak	        nie	    nie
        brak modyfikatora	tak	    tak	    nie	        nie	    tak
        private	            tak	    nie	    nie	        nie	    nie


        Enkapsulajca / hermetyzacja - jest to spsob ukrycia elementow klasy
        Zalecane sa jak najbardziej restrykcyjne modyfikatory dostepu cyzli
         private do wszystkich pol i metod ktore beda uzywane wewnatrz klasy,
         w pozostalych przypadkach public. Protected uzywam w zlozonych
         relacjach lub brak modyfikatora.


        Interface oraz jego metody jesli nie maja modyfikatora sa PUBLICZNE

        Typ wyliczeniowy oraz jego pola jesli nie maja modyfikatora sa PUBLICZNE


        W przypadku dziedzicznia mozliwe jest nadpisywanie metod tzn jesli
         jest mozliwosc nadpisania metody z nadklasy to w podklasie bede mogl
         ustawic dowolny modyfikator i nawet wywolac ja metodaZwykla super.metodaZwykla();

        Aby uniknac mozliwosci nadpisania metody lub rozszerzenia klasy uzywam
         modyfikatora final


        ----
        Mechanizm refleksji

        Nie jest zazwyczaj stosowany w kodzie produkcyjnym. Sluzy on do tego
         aby miec dostep do dowolnego elementu klasy pomijajac modyfikatory
         dostepu
         */
        class BankAccount {

            private int balance = 100;

            public int getBalance() {
                return balance;
            }
        }
        // w klasie zlodzieja
        BankAccount account = new BankAccount();
        System.out.println("\n" + "Stan konta: " + account.getBalance());

        try {
            Field balance = BankAccount.class.getDeclaredField("balance");
            //Definiuje obiekt klasy refleksji
            //Wywoluje na niej NazweKlasy potem class i na koncu metode
            // np getDeclaredField("nazwaPola") w nawiasie podaje nazwe
            // pola
            balance.setAccessible(true);
            //na zmiennej klasy refleksji zmianiam modyfikator wybranej
            // wczesniej zmiennej
            balance.set(account, -5000);
            //Za pomoca metody na obiekcie klasy reflekcji set
            // moge ustawic nowa wartosc wybranego pola

        } catch (NoSuchFieldException | IllegalAccessException x) {
            System.out.println(x.getMessage());
        }

        System.out.println("Stan konta po zmianie: " + account.getBalance()); /*


        //------------------------------------------------------------------------
        ----------------------------------PAKIETY--------------------------------

        Słuza do grupowania i informowania gdzie znajduje sie klasa/interfejs
        /typ wyliczeniowy/adnotacja

        Przyjato ze uzywa sie odwrotnej nazwy domenowej

        package pl.SamouczekProgramisty.Folder1;
         Plik klasy znajduje sie w folderze "Folder1" a on w folderze
         "SamouczekProgramisty" a on w "pl"

        import pl.SamouczekProgramisty.Folder1.MojaKlasa;
        importuje klase MojaKlasa z pakietu ->Folder1->
         ->SamouczekProgrmisty->pl
         Mam dostep dzieki temu takze do wszystkich jej statycznych metod



        //------------------------------------------------------------------------
         ------------------------KLASY I INTEFEJSY--------------------------------

        /* Interfejsy

        Jest to typ refencyjny

        Moze zawierac zmienne ktore sa finalne i statyczne

        Moze zawierac deklaracje metod (jej nazwa oraz to co zwraca i przyjmuje bez
         deklracaji ciala)

        Klasa moze ich implementowac dowlona ilosc a rozszerzac moze tylko jedna klase

        Intefejsy moga ROZSZERZAC inne INTERFEJSCY - dowolna ich ilosc


        W javie 8 powstaly interfejsy z metodami domyslnymi (default) oraz statycznymi
         i moga one zawierac cialo



        ---------
        /* Klasy:

        Sluza do grupowania atrybutow/pol i metod

        Klasa moze miec modyfikator dostepu public lub zaden!

        Klasa moze byc zwykla/abstract/final!


        /* Klasa abstrakcyjna:

        Klasa abstrakcyjna moze miec metody abstrakcyjne i zwykle (z cialem)

        Metody abstrakcyjne nie zawieraja ciala tylko jej szkielet

        Klasa dziedziczaca po klasie abstrakcyjnej musi zawierac
         implementacje wszystkich jej metod ABSTRAKCYJNYCH lub takze byc
         abstrakcyjna

        NIE DA SIE twrozyc instancji klas abstrakcyjnych

        Klasa abstrakcyjna w odroznieniu od interfejsu moze rozszerzac inna klase


        /* Klasy zwykle:

        Klasa finalna nie moze byc rozszerzana!


        //Tworzenie instancji klasy

        MojaKlasa obiekt = new MojaKlasa();

        Aby operwac na obiekcie musze przypisac cos do jej referencji
         np wywoluja konstruktor klasy slowem new

        Slowo new wywoluje konstruktor klasy

        W nawiasie wpisuje paramtry jakie chce wyslac do konstruktora
         a ich ilosc decyduje jaki konstruktor zostanie wywolany


        -----
        Konstruktor jest to metoda ktora nazywa sie tak samo
         jak klasa i nie ma okreslonego jaki typ zwraca
         oraz nie moze nic zwracac
        Moze byc on public/protected/private (private - nie moge stworzyc tego
         konstruktora w innej klasie!)

        public Podsumowanie(){ //konstruktor bezparametrowy
        }

        Standardowo kazda klasa ma swoj konstrukor bezparametrowy
         bez znaczenia czy go zadeklaruje

        Jesli zadeklaruje konstruktor z jakims parametrem to
         ten bezparametrowy zostaje usuniety!!


        -----
        //stworznie obiektu z wywolanie konstruktora z jedyn parametrem
        */
        class MojaKlasa {
            private int a;

            public MojaKlasa(int a) {
                this.a = a;
            }
        }

        MojaKlasa obiektMK = new MojaKlasa(10);
        //MojaKlasa obiektMK2 = new MojaKlasa();
        // blad - po zadeklarowaniu konstruktora 1 parametrowego ten bezparametowy
        // przestal istniec!


        /*
        -----
        Moge w jednym konstruktorze odwolac sie do innego np
         w jedno lub bez parametrowym odwolac sie do dwuparamterowego
         sluszy do tego slowo this i MUSI BYC ONO NA POCZATKU
         KODU KONSTRUKTORA!

        int a;
        int b;
        public MojaKlasa(){
            this(20,30);
            //wysylam wysylam wlasne domyslne wartosci do konstruktora
            // 2 parametrowego
        }
        public MojaKlasa(int a, int b){
            this.a = a;
            this.b = b;
        }
        main(){
            MojaKlasa obiekt = new MojaKlasa();
            //wartosci a i b obiektu beda wynosic 20 i 30
        }


        -----
        //konstruktor kopiujacy (obiekt)
        private MojaKlasa mojaKlasaObiekt;

        public Podsumowanie(MojaKlasa mojaKlasaObiekt){
            this.mojaKlasaObiekt = mojaKlasaObiekt;
        }

        main(){
            MojaKlasa obiekt = new MojaKlasa(innyObiektMojejKlasy);
        }


        -----
        Zmienna statyczna dotyczy klasy a nie obiektu lecz moge
         na obiekcie sie do niej odwolac. Jesli zmienie jej wartosc
         to na kazdym obiekcie takze dokona sie jej zmiena!

class Wew4{
        staric int a = 10;

        main(){
            Wew4 obiekt = new Wew4();
            System.out.println(obiekt.a); //wywoluje zmienna statyczna na
            // obiekcie - jest to mozliwe
            //pokaze 10
            WeW4.a = 20;
            System.out.println(obiekt.a);
            //pokaze 20!!
            System.out.println(WeW4.a);
            //to samo
        }
}


         -----
         W przypadku dziedziczenia moge odwolac sie z konstruktora
          podklasy do konstruktora klasy bazowej tylko zamiast
          slowa this uzywam super i musi ono byc NA POCZATKU
          konstruktora!

         public MojaPodKlasa(int x){//konstruktor
            super(12);//odwolanie do kosntruktora 1 parametrowego klasy Bazowej
            this.x = x;
         }


         -----
         //metoda toString

         Kazda klasa powinna miec metode toString aby moc wyswietlic obiekt
          w System.out zamiast adresu referencji

         public String toString(){
            return "zmienna a = " + a;
         }
         //zmienna a jest intem lecz dzieki konkatenacji "+" z innym stringiem
         // wszystko zostaje przypisane do stringa i jest poprawnie zwrocony typ
         // w ratrun
         //W innym przypadku moge uzyc metody klasy Integer.valueOf(a);



        //------------------------------------------------------------------------
        -------------------------METODA EQUALS I HASHCODE-------------------------

        Sa one w klasie Object wiec moge je wywolac na kazdym
         obiekcie.
        Domyslna implementacja equals zachowuje sie jak ==

        Metode equals deklaruje w klasach poniewaz jesli bede chcial porownac obiekty
         mojej klasy to nie bede porowynwac ich adresow(domyslna implementacja) tylko
         wartoci pol tych obiektow. W metodzie equals moge wybrac jakie pola
         maja byc porownywane!

        Metoda hashCode sluzy do tego aby zwrocic liczbe int wygenerowana z obiektu
         na podstawie WYBRANYCH pol ktore wpisuje w metodzie Objects.hash() metody
         hashCode(). Przydaje sie to np w zbiorach aby sprawdzic czy nie ma juz takiego
         samego obiektu (w zbiorach kazdy element jest unikalny)!
        */

        class Krzeslo {
            private String producent;
            private Date dataProdukcji;
            private int cena;
            private double waga;

            public Krzeslo(String producent, Date dataProdukcji, int cena, double waga) {
                this.producent = producent;
                this.dataProdukcji = dataProdukcji;
                this.cena = cena;
                this.waga = waga;
            }

            //konstrukcja equals z rozynymi zmiennymi (umieszczone sa wszystkie z klasy)
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                //musze sprawdzic czy nie sprawdzam tego samego obiektu
                if (o == null || getClass() != o.getClass()) return false;
                //musze sprawdzic czy nie porownuje z nullem lub czy obiekty nie sa innych
                // klas
                Krzeslo krzeslo = (Krzeslo) o;
                //Przypisuje typ przyslnego obiektu z Object do wybranej klasy dla czytelniejszego
                // pozniejszego zapisu
                return cena == krzeslo.cena &&
                        //porownywanie int prosto
                        Double.compare(krzeslo.waga, waga) == 0 &&
                        //porownywanie double - korzystam z klasy Double
                        // metoda compare zwraca 0 gdy rowne i porownuje
                        // do 0!
                        Objects.equals(producent, krzeslo.producent) &&
                        Objects.equals(dataProdukcji, krzeslo.dataProdukcji);
                //porownywanie String i Date w Objects, metdoa
                // equals zwraca bezposrednio true/false
            }

            @Override
            public int hashCode() {
                return Objects.hash(producent, dataProdukcji, cena, waga);
            }
        }

        Krzeslo k1 = new Krzeslo("BRW", new Date(), 12, 12.5);
        Krzeslo k2 = new Krzeslo("BRW", new Date(), 12, 12.5);
        Krzeslo k3 = new Krzeslo("BRW", new Date(), 12, 80.5);

        System.out.println("\n" + "-------------------");
        System.out.println("Porownuje krzeslo k1 z k2: " + k1.equals(k2));
        System.out.println("Porownuje krzeslo k2 z k3: " + k2.equals(k3));
        System.out.println("Porownuje krzeslo k1 z k3: " + k1.equals(k3));
        System.out.println("-------------------");


        //------------------------------------------------------------------------
        /* ------------------------------DZIEDZICZENIE----------------------------

         Samochod - nadklasa/klasa bazowa
         SUV - podklasa/klasa pochodna/potomna

         Obiekt klasy ktora dziedziczy ma dostep do wszystkich pol
          i metod klasay bazowej

         Klasy rozszerzajace klase implementujaca interface nie musza
          implementowac metody intefracu! lecz maja do niej dostep
         interface X{
            void metodaX();
         }
         class One implements X{
            void metodaX(){} //musi miec
         }
         class Two extedns One{
            void metodaX(){} //opcjonalna, niewymagana, jest do niej dostep
         }


         -----
         //modyfikatory
         public - dostepny wszedzie
         protected - dostepne wewnatrz obiektu, PAKIETU oraz klas pochodnych
         brak modyfikatora - dostepny tylko w pakiecie(tym samym folderze)
         private - dostepne wewnatrz klasy, klasy pochodne nie maja dostepu


         -----
         //Slowo super

         Moge odwolac sie do takiej samej meody klasy bazowej uzywajac metody super,
          moze byc ona w dowolnym miejscu kodu metody

         void metoda(){
            System.out.println("Porownuje krzeslo k2 z k3: " + k2.equals(k3));
            super.metoda();
            System.out.println("Porownuje krzeslo k2 z k3: " + k2.equals(k3));
         }


         Moge odwolac sie do takiego samego konstruktora klasay bazowej uzywajac instrukcji
          super() i musi byc ona NA POCZATKU kody konstruktora

         public Podklasa(){
            super();
         }


         -----
         //Wywolywanie konstruktorow

         Jesli klasa dziedziczy to przy tworzenie jej instancji niewazne czy typu
          klasy bazowej czy pochodnej najpierw wywola sie konstuktor klasy bazowej!
          Dziala to tak ze w konstruktorze klasy pochodnej ZAWSZE jest na poczatku jest
          instrukcja super(); ktora wykonuje sie pierwsza. Nie musimy jej deklarowac.
          Za pomoca jej moge wybrac jaki konstruktor klasy bazowej ma sie wywolac np
          super(12, 30); wywolam najpierw konstruktor 2 parametrowy i wysle do niego
          te zmienne a nastepnie wywolaja sie instrukcje kontruktora klasy pochodnej

         Dziecko d = new Dziecko();
         Ojciec o = new Dziecko();

         Musze pamietac ze jesli zadeklaruje konstruktor z parametrami to ten
          bezparametrowy (ukryty) przestaje isniec!


         -----
         Klasy z modyfikatorem final nie moga byc rozszerzana!
         Metody z modyfikatorem final nie moga byc nadpisywane!


         -----
         //kompozycja i dziedzicznie

         W dziedziczniu moge stworzyc polimorficznie obiekt klasy
          pochodnej w typie klasy bazowej
         Ojciec obiekt = new Dziecko();

         W kompozycji moge w klasie stworzyc zmienna/atrybut/pole typu
          innej klasy np
         class Czlowiek{
            public Zwierze zwierze;
            public Budynek b = new Budynek;
         }


         -----
         //Polimorfizm

         W Javie wszytkie Klasy sa polimorficzne poniewaz kazda dziedziczy po
          Object

         Tworze obiekt polimorficznie (typ rodzic - obiekt dziecko)
          aby moc w typie rodzica umiesciec inne klasy pochodne rodzica.

         Rodzic r = new Dziecko();

         Jesli stworze tak obiekt do dostep do metod DZIECKA bede mial tylko
          z rzutowaniem! do metod rodzica mam dostep normalnie

         ((Dziecko) r).metodaDziecka();


         -----
         //metoda toString

         W klasie pochodznej zwracam jej zmienne i na koncu dodaje + super.toString()
          i w klasie bazowej zwracam zmienne klasy bazowej



        //------------------------------------------------------------------------
         ----------------------------WIELOWATKOWOSC-------------------------------

         Java jest jezykiem wielowatkowym wiec mozna jednoczenie wykonywac dwie
          lub wiecej czesci programu jednosczenie przez procesory wielordzeniowe
          /wielowatkowe

         Proces - program

         Watek - najmniejsza czesc programu mogaca pracowac jednoczesnie z innymi
                  watkami (obiekt klasy Thread)


         Klasa wielowatkowa posiada implementacje metody run() ktora wywolujemy za
          pomoca metody start() na obiekcie klasy aby stworzyc nowy watek
         Wywolanie bezposrednio metody run() nie stworzy nowego watku


         W Javie moge tylko raz uruchomic jeden watek, jesli wywolam metode .start()
          na tym samym watku zostanie wyrzucony wyjatek IllegalThreadStateException


         Intefejs Callable w odroznieniu od Runnable jest w stanie zwrocic wartosc
          typu Future oraz wyrzucic wyjatek.
         Obiekt Future pozwala na spradzenie czy dana operacja sie skonczyla przez co
          wiemy ze mozemy pobrac wartosc ktora istenieje



         Sa dwa rodzaje implementacji watkow w Javie:

         1 - klasa roszerza klase Thread

        class WatekOne extends Thread{

            @override
            public void run(){
                System.out.println("watek 1");
            }
        }

        W main klasy glownej tworze obiekty tej klasy i wywoluje metode start():

        WatekOne o1 = new WatekOne();
        WatekOne o2 = new WatekOne();
        WatekOne o3 = new WatekOne();

        o1.start();
        o2.start();
        o3.start();


        2 - Klasa implementuje interfejs Runnable (metoda zalecana poniewaz moge moge
             rozszerzac inna klase)

        class WatekTwo implements Runnable{

            @override
            public void run(){
                System.out.println("watek 1");
            }
        }

        W main klasy glownej tworze obiekty klasy Thread i jako paraetr konstruktora
         wysylam nowy obiek mojej klasy po czym na obiektach Thread wywoluje metode
         start()

        Thread t1 = new Thread(new WatekTwo());
        Thread t2 = new Thread(new WatekTwo());
        Thread t3 = new Thread(new WatekTwo());

        t1.start();
        t2.start();
        t3.start();


        1)
        Interfejs funkcyjny Runnable zawiera metode run() ktora nic nie przyjmuje
         i nic nie zwraca wiec wiec tworzac jego obiekt deklaruje dzialanie
         metody run
        2)
        Nastepnie moge wyslac go w parametrze konstruktora tworzac
         obiekt Thread
        3)
        I na koniec wywolac metode .start() na obiekcie Thread aby wywolac
         metode run ktora zadeklarowalem tworzac obiekt Runnable w nowym
         watku

        1)-----------
            Runnable mojRun = () -> {
                   for(int i=0; i<10; i++){
                       System.out.println("x");
                   }
            };
        2)------------
            Thread t1 = new Thread(mojRun)
        3)------------
            t1.start();
        --------------


        Metoda .join()

        Wywolana na watku (w bloku try obslugujacym wyjatek InterruptedException)
         informuje program ze zanim przejdzie do dalszej czesci polecen musi
         poczekac na wykonie operacji na danym watku


        Metoda z parametrem synchronized

        Kazdy obiekt w Javie posiada monitor lock (zamek)
        Jesli wykonuje na obiekcie watku jakas metode synchronized to pobierany jest
         jego (obiektu) klucz SynchronizedMethod
        Synchronizacja pobiera zamek i zwalnia go tylko po wykoaniu czynnosci przez
         co dopiero w tedy inny watek moze skorzystac z tej metody


        Obiekt lub kod jest bezpiczny do pracy z watkami (Thread safety) jesli
         bedzie dzialal wedlug oczekiwan jesli kilka roznych watkow bedzie
         z nim wspolpracowac
        StringBuffer jest zsynchronizowany (przez to wolniejszy) przez co mozna
         z niego korzystac w aplikacjach wielowatkowych


        .sleep(200);

        Klasa rozszerzajaca Thread lub implementujaca Runnable w metodzie run
         moze w bloku try (wyjatek do obsluzenia - InterrptedException) wywolac
         na watku (zmienna Thread) metode sleep() i w jej parametrze podac czas
         przerwy

        @Override
        public void run() {
            System.out.println("456");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("123");
        }


        Zmienna z parametrem volatile

        Jesli dodam prez typem zmiennej slowo valitile to watki korzystjace z niej
         beda korzystac z tej samej kopii zmiennej oraz zapis bedzie zawsze
         przed oczytem
        W przypadku jesli tego nie zadeklaruje to zmieniajac ja watek moze operowac na
         jej kopii jej wartosci przez miana i nie widziec zmiany


        Pula watkow (Thread Pool) / Klasa ExecutorService/Executors

        Moge stowrzyc pule watkow ktore beda wykonywaly sie jednoczesnie
        Robie to w klasie aplikacji
        Aby to zrobic deklaruje zmienna ExecutorService i przisuje jej pule
         wywolujac statyczne metode newFixedThreadPool() z klasy Exectors
         gdzie jako parametr podaje liczbe watkow w puli

        ExecutorService excutor = Executors.newFixedThreadPool(2);

        Nastepnie aby wywolac metode run() z klasy watka (implementujacej Runnable)
         na obiekcie executor (typ ExecutorService) wywoluje metode .submit() i jako
         parametr przekazuje nowy obiekt klasy watku
        Moge kilka razy wywolac metode submit i beda sie one wywolywane grupami
         pol jak okreslilem wczesniej

        excutor.submit(new Synchronizacja3("czyszczenie"));
        excutor.submit(new Synchronizacja3("sprzatanie"));
        excutor.submit(new Synchronizacja3("odkurzanie"));
        excutor.submit(new Synchronizacja3("mycie"));
        excutor.submit(new Synchronizacja3("szorowanie"));

        /*
        / W przypadku gdy deklarowalem watek porzez typ Thread :
        / Thread t1 = new Thread(new Watek());
        / t1.start();
        */
        /*


        Aby zakonczyc watek typu ExecutorService wywoluje na jego obiekcie
         metode .shutdown()

        excutor.shutdown();


        Aby zatrzymac dalszy kod przed zakonczeniem watku ExeturService moge
         dodac w bloku try (catch (InterruptedException ex)) metode .awaitTermination()
         gdzie jako parametr podaje liczbe i typ czasu jaki ma czekac gdyby watek sie
         nie zakonczyl do momentu az automatycznie przejdzie do dalszej czesci kodu

        try{
            excutor.awaitTermination(3, TimeUnit.SECONDS);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }





        //------------------------------------------------------------------------
         ---------------------------WYJATKI + BLOK TRY CATCH----------------------

         Wyrzucac wyjatki moge za pomoca throw new np:
          throw new IllegalArgumentException();

         Lub throws w metodach np:
         void metodaZWyjatkiem()throws ArithmeticException{
            if(y==0){
                    throw new ArithmeticException("nie moge dzilic przez 0");
                }
         }


         ----
         Wyjatki dzielimy na CHECKED I UNCHECKED i dziedzicza one po klasie
          Throwable


         Checked - sprawdzony - powstaje w wyniku kompilacji, trzeba go obsluzyc
          lub wyzucic poziom wyzej za pomoca throws (np IOException)

         Unchecked - niesprawdzony - powstaje w wyniku bledu po uruchomieniu porgramu
          np dzielenie przez zero lub wskazanie na null, nie musi zostac obsluzony
          (np IllegalArgumentException)


         Jesli wyjatek ma w swojej hierarchii TYLKO Exception/Throwable
          musi byc obsluzony, jesli cos wiecej to juz nie

         Hierarchia dziedziczenia wyjatkow:
          Throwable <- Exception <- RuntimeException <- IllegalArgumentException

         Wyjatki mozna obluzyc na 2 sposoby, jeden to poprzez blok try/catch a drugi
          to zepchniecie go na poziom nizej czyli do metody wywolujacej za pomoca
          klauzuli throws


         -----
         Do oblusgi kilku wyjatkow w klauzuli try/catch moge zapisac
          je w oddzielnym catch lub uzywajac |

         Dodatkowo mozna dodac blok finally ktory bedzie
          sie wykonywal zawsze

         Blok try moze byc bez catch ale musi byc finally

         try {
            throw new IllegalArgumentException();
         }
         catch (ArithmeticException ex) {}
         catch (RuntimeException ex) {}

         try{
            throw new IllegalArgumentException();
         }
         catch(ArithmeticException | RuntimeException ex){}
         finally{}



        //------------------------------------------------------------------------
         -----------------------STERTA + REFERENCJA + GC--------------------------

         Gdy tworze obiekty rezerowana jest pamiec (STERTA) - HEAP SPACE
         Zmienne, które wskazują na obiekty na stercie zawierają referencje

         JVM rezrwuje pamiec RAM

         Zmienne trzymane sa na STOSIE - STACK

         Gdy zajme caly stos zostanie wyrzucony wyjatek
          java.lang.OutOfMemoryError

         Null jest typem ktory nie moze posiadac nazwy przez co nie mozna
          utworzyc zmiennej tego typu



        //------------------------------------------------------------------------
          -------------------------KONWERSJA I RZUTOWANIE-------------------------

          Rzutowanie (cast) - konwersja JAWNA

          Możemy rzutować wyłącznie na typ, który znajduje się hierarchii
           dziedziczenia danego obiektu (to co jest "wyzej) inaczej wyrzuci
           wyjatek java.lang.ClassCastException

          Konwejsa niejawna gdy chce przypisac int do long i nie trace informacji
           inaczej tj grzy przekrocze zakres np long do int moze pokazac -1

          Konwersji poprzez rzutowanie moge uzcyc gdy chce np obciac reszte

          int intValue = (int) 123.123F;



        //------------------------------------------------------------------------
        ----------------------------TYPY GENERYCZNE------------------------------

        Typ generyczny jest szablonem pozwalajacym uniknac rzutowania
        Kazda tablice obiektow mozna uogolnic do Object lecz wszystko
         trzeba bedzie rzutowac
         */
        class Apple {
        }
        class AppleBox {
            private Apple apple;

            public AppleBox(Apple apple) {
                this.apple = apple;
            }

            public Apple getApple() {
                return apple;
            }
        }

        class Orange {
        }
        class OrangeBox {
            private Orange orange;

            public OrangeBox(Orange orange) {
                this.orange = orange;
            }

            public Orange getOrange() {
                return orange;
            }
        }

        class FruitBox {
            private Object fruit; //Aby moc przyjac obiekt kazdej klasy

            // (Apple/Orange) polimoficznie
            // wykorzustuje nadklase kazdej klasy (Object)
            // ale wszystkie metody na jego obiekcie bede musial rzuotwac
            // co jest niezalecane
            public FruitBox(Object fruit) {
                this.fruit = fruit;
            }

            public Object getFruit() {
                return fruit;
            }
        }
        FruitBox pudelkoZOwocami = new FruitBox(new Orange());
        Object orange = (Orange) pudelkoZOwocami.getFruit();
        //musze rzutowac


        //-----
        class BoxOnSteroids<T> {
            public T fruit;

            public BoxOnSteroids(T fruit) {
                this.fruit = fruit;
            }

            public T getFruit() {
                return fruit;
            }
        }
        BoxOnSteroids<Apple> pudelkoZJabkami = new BoxOnSteroids<>(new Apple());
        Apple jablko = pudelkoZJabkami.getFruit();
        //Orange pomarancza = pudelkoZJabkami.getFruit(); - blad, wykryje go IDE
        /*
        Za zmienna T podstawiam typ Apple ktory przypisywany jest do zmiennej fruit
         w konstruktorze, nie musze juz rzutowac
         */

        BoxOnSteroids pudelkoBezTypu = new BoxOnSteroids<>(new Apple());
        //moge zrobic bez podania typu generycznego ale bedzie on Object
        // wiec chcac przypisac juz bede musial rzutowac!
        Apple apple = (Apple) pudelkoBezTypu.getFruit();
        BoxOnSteroids<Apple> nowePudelkoZJablkami = pudelkoBezTypu;
        //teraz typ jest Apple po ponownym przypisaniu

        //Musze pamietac ze jest w nim apple gdy bede chcial przypisac
        // pudelkoBezTypu do Orange
        //Orange orange1 = (Orange)pudelkoBezTypu.getFruit();
        //wyjatek java.lang.ClassCastException


        //-----
        //Zagniezdzone klasy generyczne
        class Pair<T, S> {
            private T first;
            private S second;

            public Pair(T first, S second) {
                this.first = first;
                this.second = second;
            }

            public T getFirst() {
                return first;
            }

            public S getSecond() {
                return second;
            }
        }

        Pair<BoxOnSteroids<Apple>, BoxOnSteroids<Orange>> para = new Pair<>(
                new BoxOnSteroids<>(new Apple()),
                new BoxOnSteroids<>(new Orange())
        );


        //------
        //Extends
        /*
        interface Figura{
            String dajNazwe();
        }
        */
        class Kolo implements Figura {
            @Override
            public String dajNazwe() {
                return "kolo";
            }
        }
        class PudelkoFigur<T extends Figura> {
            //Nie musze implemenetowac metod z int Figura

            //Klasa parametryzujaca T musi rozszerzac Figure lub rozszerzac
            // klase ktora go implementuje !!

            // wiec bede mogl na polu z paramtrem T wywolac
            // metody z tego interfejsu ktore nadpisza
            // parametryzujace klasy!
            private T figura;

            public PudelkoFigur(T figura) {
                this.figura = figura;
            }

            public T getFigura() {
                return figura;
            }

            public String dajNazwe() {
                return figura.dajNazwe();//!!
                //Wywola metode dajNazwe z klasy ktorej bedzie
                // parmatryzowac typ generyczny czyli np. Kolo!!
            }
        }
        PudelkoFigur<Kolo> kola = new PudelkoFigur<Kolo>(new Kolo());
        kola.dajNazwe();

        //pudelkoFigur<Apple> jablka = new pudelkoFigur<Apple>(new Apple());
        //Blad kompilacji - Apple nie implementuje Figury ani nie rozszerza
        // klasy implementujacych go!!


        //------------------------------------------------------------------------
        //------------------DZIEDZIECZENIE KLAS GENERYCZNYCH----------------------

        class Prostokat implements Figura {
            @Override
            public String dajNazwe() {
                return "prostokat";
            }
        }
        class Kwadrat extends Prostokat {
            //Nie musze implementowac metod figury
            public String dajNazwe() {
                return "kwadrat";
            }
        }
        Prostokat p1 = new Kwadrat();//moge bo rozszerza
        PudelkoFigur<Prostokat> p3 = new PudelkoFigur<Prostokat>(new Prostokat());

        //pudelkoFigur<Prostokat> p4 = new pudelkoFigur<Kwadrat>(new Kwadrat());
        //Blad - nie moge przypisac tak referncji - paramtryzowanie innym typem
        // nawet jesli rozszerza typ!!

        PudelkoFigur<Prostokat> p2 = new PudelkoFigur<Prostokat>(new Kwadrat());
        //Ale po mimo tego ze parametryzuje go typem Prostokat to mege przypisac
        // obiekt Kwadrat poniwaz dziedziczy
        System.out.println("p2 daj nazwe: " + p2.dajNazwe());//Da kwadrat tylko
        // dlatego ze metodaZwykla Prostokata jest nadpisywana
        System.out.println(p2.getClass()); //da pudelkoFigur tylko


        //-----
        class ZwyklePudelko<T> {
            private T zmienna;

            ZwyklePudelko(T zmienna) {
                this.zmienna = zmienna;
            }

            public T getZmienna() {
                return zmienna;
            }
        }
        class InnePudelko<T> extends ZwyklePudelko<T> {
            public InnePudelko(T zmienna) {
                super(zmienna);
            }

            void powiedzCos() {
                System.out.println("moje " + getZmienna() + " jest super");
            }
        }
        InnePudelko<String> ip = new InnePudelko<>("cos");
        ip.powiedzCos();
        //pokaze : moje cos jest super
        InnePudelko<Apple> ip2 = new InnePudelko<>(new Apple());
        ip2.powiedzCos();
        //pokaza "moje SamouczekProgramisty.Wstep$1Apple@7921b0a2 jest super"


        ZwyklePudelko<Object> zwyklePudelko = new ZwyklePudelko<>(new Object());
        zwyklePudelko.zmienna = new Apple();// poprawne - klasa dziedziczy;
        ZwyklePudelko<Apple> zwyklePudelko1 = new ZwyklePudelko<>(new Apple());
        zwyklePudelko1.zmienna = new Apple();


        //----Paramtryzowanie <?> obiektow klas
        ZwyklePudelko<?> zwyklePudelko2 = new ZwyklePudelko<>(new Apple());
        ZwyklePudelko<?> zwyklePudelko3 = new ZwyklePudelko<>(new Object());
        //jesli uzyje parametryzacaji <?> nie bede mogl zmienic pola tylko
        // przypisac wartosc null;
        // pudelkoWildcards2/3 = new Apple/Object(); - blad
        zwyklePudelko2 = null;


        //------------------------------------------------------------------------
        //-----------METODY Z ARGUEMNTAMI GENERYCZNYMI - WILDCARDS----------------

        class PudelkoWildcards<T> {
            private T zmienna;

            PudelkoWildcards(T zmienna) {
                this.zmienna = zmienna;
            }

            public void metoda1(PudelkoWildcards<?> pudelko) {
                //przyjeta zmienna pudelko jest to obiekt typu
                // PudelkoWildcards
                Object o = pudelko.zmienna;
                //<?> moge parametryzowac wszystkim ale przypisac
                // moge tylko do Object poniewaz jesli dam:
                //Apple o = pudelko.zmienna
                // bede mogl przypisac za <?> Apple i bedzie poprawne
                // lecz <?> moze przyjac tez String i bedzie blad;
                //W metodzie musi byc kod zakladajacy dzialanie
                // w kazdym przypadku
                System.out.println("obiekt metody przyjmujacek <?> : " + o);
            }
        }
        System.out.println("-------------------");
        PudelkoWildcards<Object> pudelkoWildcards = new PudelkoWildcards<>(new Object());
        pudelkoWildcards.metoda1(pudelkoWildcards);
        pudelkoWildcards.metoda1(new PudelkoWildcards<>(new Object()));
        pudelkoWildcards.metoda1(new PudelkoWildcards<>(new Apple()));

        PudelkoWildcards<Apple> pudelkoWildcards2 = new PudelkoWildcards<>(new Apple());
        pudelkoWildcards2.metoda1(new PudelkoWildcards<>(new Object()));


        //-----metody wildcard
        class PudelkoWildcards3<T> {
            private T zmienna;

            public PudelkoWildcards3(T zmienna) {
                this.zmienna = zmienna;
            }

            public T getZmienna() {
                return zmienna;
            }

            public void setZmienna(T zmienna) {
                this.zmienna = zmienna;
            }

            public void metoda(PudelkoWildcards3<Figura> obiekt) {
                //metoda przyjmuje obiekt ktory moze byc typu
                // figura(nie moze bo to interface) lub "nizej"
                // czyli kwadrat/prostokat
                Object o = obiekt.getZmienna();
                Figura f = obiekt.getZmienna();
                //Przyjety obiekt moge zapisac do zmiennej
                // nizej czyli odwrotnie zeby miec gwaranje ze
                // cokolwiek bym wyslal (Figura moze byc klasa)
                // bedzie przypisane dobrze polimoficznie!

                //Kwadrat k = (Kwadrat) obiekt.getZmienna();
                // juz musze rzutowac bo metoda nie wie czy
                // wysle Kwadrat czy Prostokat, jesli
                // dam ta instukcje i wysle Prostokat to wyrzuci
                // wyjatek!
            }
        }
        PudelkoWildcards3<Object> test2 = new PudelkoWildcards3<>(new Object());

        test2.metoda(new PudelkoWildcards3<>(new Kwadrat()));
        test2.metoda(new PudelkoWildcards3<>(new Prostokat()));
        //test2.metoda(new PudelkoWildcards3<>(new Object()));
        //blad - wysylam cos wyzje niz figura


        //-----metody "upper bound" ? extedns
        class PudelkoWildcards2<T> {
            private T zmienna;

            public PudelkoWildcards2(T zmienna) {
                this.zmienna = zmienna;
            }

            public T getZmienna() {
                return zmienna;
            }

            public void setZmienna(T zmienna) {
                this.zmienna = zmienna;
            }

            public void metoda(PudelkoWildcards2<? extends Kwadrat> obiekt) {
                //W tej metodzie przyjety obiekt musi rozszerzac figure(interface)
                // wiec wyslac do niego moge TYLKO cos co rozszrza figure!
                //Przypisac do nowego obiektu mozna w druga strone czyli musze miec
                // gwarancje ze obiekt bazowy jest Figura wiec moge dac typ
                // obiektu "wyzej" figury czyli Object lub Figura aby byla
                // pewnosc ze wysle dobry typ.
                Object o = obiekt.getZmienna();
                Figura f = obiekt.getZmienna();
                Kwadrat k = (Kwadrat) obiekt.zmienna;
                //Na sile rzutuje ale jesli ktos wysle do metody
                // prostokat bedzie clad classCastException dlatego moge
                // przypisac obiekt tylko do typu Figury badz "wyzej"
            }
        }
        PudelkoWildcards2<Object> test = new PudelkoWildcards2<>(new Object());
        PudelkoWildcards2<Prostokat> test3 = new PudelkoWildcards2<>(new Prostokat());

        test.metoda(new PudelkoWildcards2<>(new Kwadrat()));
        //test.metoda(new PudelkoWildcards2<>(new Prostokat()));
        // blad poniewaz w metodzie na sile przypisuje obiek do kwadratu
        // a probuje wyslac prostokat


        //-----metody "lower bound" ? super
        class PudelkoWildcards4<T> {
            private T zmienna;

            public PudelkoWildcards4(T zmienna) {
                this.zmienna = zmienna;
            }

            public T getZmienna() {
                return zmienna;
            }

            public void setZmienna(T zmienna) {
                this.zmienna = zmienna;
            }

            public void metoda(PudelkoWildcards4<? super Prostokat> obiekt) {
                //Metoda moze przyjac Prostokat badz "wyzej" czyli
                // Figure lub Object
                Object o = obiekt.getZmienna();
                Figura f = (Figura) obiekt.getZmienna();
                //Przypisac moge tylko do Object poniewaz
                // jesli wysle Object to niebde mogl przypisac go
                // do Figury
            }
        }
        PudelkoWildcards4<Object> test4 = new PudelkoWildcards4<>(new Object());

        test4.metoda(new PudelkoWildcards4<>(new Prostokat()));
        test4.metoda(new PudelkoWildcards4<>(new Kwadrat()));
        //test4.metoda(new PudelkoWildcards4<>(new Object()));
        //blad bo w metodzie NA SILE przypisuje Object do Figury



        //------------------------------------------------------------------------
        /*--------------------------KLASA ARRAYS----------------------------------
         */
        //metody:
        // .asList(); //zamiana tablicy na kolekcje
        List<String>imionaLista1 = Arrays.asList("kamil","tomek");
        String[] imionaTablica = {"kamil","tomek"};
        List<String>imionaLista2 = Arrays.asList(imionaTablica);

        //.equals(); - porownywanie tablic
        int[] tabEquals1 = {1,2,3,4};
        int[] tabEquals2 = {1,2,3,5};
        int[] tabEquals3 = {1,2,3,4};
        System.out.println("Porownanie tablic 1:");
        System.out.println(Arrays.equals(tabEquals1,tabEquals2));
        System.out.println("Porownanie tablic 2:");
        System.out.println(Arrays.equals(tabEquals1,tabEquals3));

        //.toString() //pokazuje tablice z elementami w [] i elementy oddzielone sa ,
        int[] tabToString = {1,5,3,62};
        System.out.println("Arrays.toString():");
        System.out.println(Arrays.toString(tabToString));
        String tabToStringX = Arrays.toString(tabToString);
        //zapisze do stringa tablice w [] oddzielajac elem ,
        System.out.println("xxxxxx: "+tabToStringX);
        //zeby wybrac co ma oddzielac mozna uzyc metody join
        // deklaracja wczesniej

        //.copyOf();
        int[] tabCopyOf = Arrays.copyOf(tabToString, tabToString.length);
        System.out.println("copyOf():");
        System.out.println(Arrays.toString(tabCopyOf));

        //.fill();//tylko dla tablic!
        Arrays.fill(imionaTablica, "xD");

        //.sort();
        int[] tabSort = {2,5,1,8};
        Arrays.sort(tabSort);
        System.out.println("Sort klasy Arrays:");
        for(int x:tabSort)
            System.out.print(x+" ");


        /*----
        Tablice z obiektami sortuje tak samo jak kolekcje tzn uzywam
         tablicy obiektow (klasa musi implementowac interface Comparable
         oraz metode compareTo) w metodzie sort
        Arrays.sort(tablicaObiektow)

         lub dodaje jeszcze obiekt klasy sortujacej implementujacej inteface
          Comparator<klasaDoSoretowania> i metode compare
         Arrays.sort(tablicaObiektow, new KlasaSortujaca())

         lub bezposrednio deklarjue dzialanie sortowanie z uzyciem klasy anonimowej
          tzn w metodzie sort oprocz tablicy obiektow tworze obiekt interfacu
          Comparator<KlasaDoSortowania>
         Arrays.sort(tablicaObiektow, new Comparator<Klasa Obiektow>(){
            public int compare(KlasaArrays2 o1, KlasaArrays2 o2) {
                //wartunki
            }
         )};
         */



        //------------------------------------------------------------------------
        /*----------------------------KOLEKCJE------------------------------------

        ----
        /* Iterator

        Jest to interfejs posiadajacy metody potrzebne do iterowania kazdej z kolekcji

        Mozemy dzieki niemu przeprowadzic operacjie takie jak usuniecie czy odczyt

        Iterator przeszukuje liste w jedna strone i pozwala tylko na usuniecie

        ListIterator pozwala na przeszukiwanie listy w obie strony i moze byc uzywany
         tylko do list, pozwala na dodawanie, zmiane oraz usuniecie wartosci




        ----

        Kolekcja to sposob grupownia obiektow, jest ona struktura danych

        Kolekcja jest to obiek pozwalajacy na grupowanie obiektow

        W odrownieniu od tablic nie maja sztywno okreslonego rozmiaru

        Framework kolekcji - struktura kolekcji jest to zbior struktur danych oraz
         algorytmow do operacji na nich (dodawanie, usuwanie, przeszukiwanie itp)
        Jest on wbudowany w JDK

        Najpopularniejsze:
        -Collection
        – List
        – Set
        – SortedSet
        – Map
        – SortedMap

        Kolekcje poprawiaja szybkosc dzialania oraz jakosc oprogramowania.

        Collection jest to glowny interfejs kolekcji

        Collections jest to klasa ktora posiada statyczne metody do operacji
         na kolekcjach takie jak sortowanie, wyszukiwanie elementu etc.


        -Collection(i)
            -List(i)
                -ArrayList(k)
                -LinkedList(k)
            -Set(i)
                -HashSet(k)
                    -LinkedHashSet(k)
                -SortedSet(i)
                    -NavigableSet(i)
                        -TreeSet(k)
            -Queue(i)
                -PriorityQueue(k)
                -BlockingQueue(k)

        -Map(i)
            -SortedMap(i)
                -TreeMap(k)
            -AbstractMap(k)
                -TreeMap(k)
                -HashMap(k)
                    -LinkedHashMap(k)
                -HashTable(k)


        -----
        Lista

        Głowne Listy dzielimy na:
        -LinkedList - gdy chce czesto dodawac/usuwac elementy - implemenacja dowiazana
        -ArrayList - gdy chce  czesto miec dostep do elementow - implemenacja tablicowa

        -Moga przechowywac ten sam obiekt kilka razy
        -Kolejnosc jest wazna
        -Moda dynamicznie zmieniac swoj rozmiar


        Dobra praktyka jest dlekarowanie ich jako typ List
         (List<String> list = new ArrayList<>();
         aby mozna byloby je potem bez problemu zmienic jedna na druga


        ArrayList przechowuje pod jakim ideksem jest dany element
        LinkedList przechowuje informacje o nastepnym elemencie

        Odczyt - ArrayList jest dzieki indeksom szybszy poniewaz w LinkedList trzeba
                 przeiterowac cala kolekcje aby znalezc element

        Usuwanie - W LinkedList zmienia sie tylko odnosnik do kolejnego elementu przez
                    co jest szybsze od ArrayList gdzie musi sie zmienic polozenie wszystkich
                    elementow za usunietym

        Dodawnia - W LikedList nie istnieje ryzyko powiekszenia tablcy i kopiowania zawartosci
                   do nowej listy, w ArrayList jesli przekrocze rozmiar to stworzona zostanie
                   nowa lista i wszystkie elementy zostana przekopiowane
                   Dodatkowo jesli dodam element w innym miejscu niz na koncu, wszystkie
                   elementy po nim beda musialy zostac przesuniete

        Pamiec - w LinkedList przechowuje adres i dane poprzedniego i kolejnego elementu
                 natomiast w ArrayList tylko index elementu i jego wartosc


        */

        List<String> lista1 = new ArrayList<>(3);
        //Tylko w ArrayList w konstruktorze moge podac wstepny rozmiar
        List<String> lista2 = new LinkedList<>(lista1);
        List<String> lista3 = Arrays.asList("Pawel", "Lukas", "Janek");
        //W konstrukotrze LinkeList moge podac inna kolekcje
        // aby zostala ona przpisana do nowej LinkedLIsty


        //----
        //Metody:
        lista1.add("Kamil"); // dodanie elementu
        lista1.add(1, "Tomek");//index musi byc poprawny (nie moze byc pustego
        // elementu) bo wyrzuci wyjatek IndexOutOfBoundsException
        //dodaje na pozycje 2 element "kamil", iteracja od 0
        lista1.addAll(lista3);// dodanie wszystkich elementow z jednej kolekcji
        // do drugiej, nie nadpisze istenijacych tylko polaczy obie listy jedna
        // po drugiej!
        lista1.remove("Kamil");//usuwam element pierwszy i element drugi przeskakuje
        // na 1 (0)
        lista1.remove(1);
        lista2.clear();
        String wezElement = lista1.get(0);// pobierze element z pozycji 0 listy
        boolean czyZawiera = lista1.contains("kamil");// zwraca flage czt kolekcja
        // zawiera dany element
        boolean czyPusta = lista1.isEmpty();// zwraca flage czy lista jest pusta
        int liczbaElementow = lista1.size();// zwraca liczbe elementow w liscie
        // nie jaki jest rozmiar wstepny (w przypadku ArrayList)
        int pierwszeWystapienie = lista1.indexOf("kamil");
        int ostatnieWystapienie = lista1.lastIndexOf("kamil");



        /*----
        Zbior


        -Kolejnosc nie jest istotna
        -Kazdy element jest unikatowy

        Moge pozbyc sie duplikatow elementow z Listy zamieniajac ja na Zbior
         z uzyciem metody addAll()

        Aby miec pewnosc ze element jest juz w zbioerze nalezy zaimpelementowac
         metode hashCode oraz Equals !! Metoda hashCode w klasie oblicza wartosc
         liczbowa obiektu na podstawie wartosci jego WYBRANYCH pol i przez te
         wartosci wie ze obiekt jest w zbiorze

        Zbiory glownie dzielimy na:
        -HashSet - w srodku umieszczona jest tablica mieszajaca, wymaga
         implementacji hashCode oraz equals,
         MOZE przechowywac wartosc null
         Ma stala szybkosc dzialania

        -TreeSet - uporzadkowywwuje elementy wg naturalnego porzedku, wymagane
         jest do tego implementacja interfejsu Comparable lub uzycie odpowiedniego
         Comparatora lub ustalic specyfikacje w konstruktorze
         NIE MOZE przechowywac wartosci null
         Szybkosc dzialanie jest wyliczana logarytmicznie

        -LinkedHashSet - dodatkowo zapamietuje kolejnosc dodawnych elementow
         */
        Set<String> zbior1 = new HashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar
        Set<String> zbior2 = new TreeSet<>(zbior1);
        //Konstruktor moze przekopiowac kolekcje do nowej
        Set<String> zbior3 = new LinkedHashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar

        /*
        Aby wypisac elementy ze zbioru wykorzystuje iterator lub petle for (Enhanced For Loop)


         */


        //-----
        //Metody:
        zbior1.add("kamil");
        zbior1.addAll(zbior2);
        zbior1.remove("kamil");
        boolean czyZawiera2 = zbior1.contains("Kamil");
        boolean czyPusta2 = zbior1.isEmpty();
        int iloscElementow = zbior1.size();
        Iterator iterator = zbior1.iterator();

        //*dodatkowo w TreeSet mamy dodatkowo mozliwosc zworcenia "najmniejszego"
        //  elementu first() oraz najwiekszego last()



        /*---
        Kolejka (Queue)

        Kolejka sluzy do przechowywyanie obiektow w wybranej kolejnosci do przetworzenia

        -FIFO - Obiekt pierwszy dodany zostaje pierwszy przetworzony ("rurka") - kolejka
        -LIFO - Obiekt ostatni dodany zostaje pierwszy przetworzony ("pojemnik") - sterta(stack)

        W klasie PriorityQueue porzadkuje za pomoca obiektu klasy Comparatora lub
         naturalnego kolejkowania

         */



        /*----
        Map

        -Map(i)
            -SortedMap(i)
                -TreeMap(k)
            -AbstractMap(k)
                -TreeMap(k)
                -HashMap(k)
                    -LinkedHashMap(k)
                -HashTable(k)

        Map jest to obiekt ktory mapuje klucz do wartosci - klucze sa unikalne, wartosci
         moga sie powtarzac

        Interfejs Map znajduje sie we frameworku kolekcji ale nie implementuje
         interfejsu Collection! Wiaze sie to z tym ze elementy ze implementacje
         Collection posiadaja pojedyncze elemety a Map pary w formie klucz-wartosc
         przez co funkcje Collection nie sa kompatybilne z mapami!

        -Kolejnosc nie jest istotna
        -Kazdy element kluczy jest unikatowy

        Mapa pozwala przechowywac odwzorowanie zbioru kluczy na liste wartosci.
        Kluczami pownny byc obiekty ktorych nie mozna zmienic (Immutable) czyli np String
         lub Integer.
        Klasy kluczy powinny miec poprawna implementacje metod HashCode oraz
         equals.
        Dodanie istniejacego klucza do kolekcji z wartoscia nadpisze istniejaca
         wartosc starego klucza na nowa!

        Podstawowe impementacjie Map dzielimy na:
        -HashMap - posiada tablice mieszajaca i kolejnosc elementow nie jest
                    ustalona
        -TreeMap - Dodatkowo posiada sortowanie, wymagana implementacja interfejsu
                    Comprable lub implementacji Comparatora
        -LinkedHashMap - zapamietuje dodatkowo kolejnosc dodawanych elementow,
                         wykorzystuje liste wiazana. Prdzydatne przy iteracji


        HashTable jest synchronizowane wiec uzywane jest w aplikacjach wielowatkowych
         (jest wolniejsza przez to) oraz nie zwzwala na posiadanie elementu i klucza null
         Do iterowania wykorzystuje enumator
         HashTable moze byc zastapiane przez szybsze ConcurrentHashMap

        HashMap pozwala na uzycie jednego klucza null i nieograniczonej ilosci wartosci
         null, do iterowania wykorzystuje iterator, jest duzo szybsza od HashTable


        HashMapa sklada sie z Bucketow i ma ograniczona ich ilosc

        Jesli w jednym puckecie jest wiecej niz jeden obiekt (kolizja) tworzona jest
         w Bucketach LinkedLista na obiekty typu Entry
        Jesli chce wyciagnac obiekt z takiej listy HashMap wywoluje na kazdym elemencie
         metode equals i porownje hash obiektu jaki chcemy wyciagnac z obiektami z listy
         i jesli wynik da true obiekt bedzie wyciagniety

        HashMap podczas wkladania obiektu put() wywolywana jest metoda hashCode()
         na kluczu i wywoluje na hashu wlasna metode hashujaca aby znalezc
         miejsce w BUCKETcie na obiekt typu Entry
        Klucz i wartosc jest przechowywana jako Map.Entry w Bucket-cie

        Podczas proby wyciagniecia obiektu z Mapy get() generowany jest takze jego hashcode
         ktory pozwoli wyciagnac poprawny obiekt z Bucketu

         */
        Map<Integer, String> mapa1 = new HashMap<>(2);
        //Konstruktor zawiera wstepny rozmiar
        Map<Integer, String> mapa2 = new TreeMap<>(mapa1);
        //Konstruktor moze przkopiowac mape
        Map<Integer, String> mapa3 = new LinkedHashMap<>(23);
        //Konstruktor zawiera wstepny rozmiar

        mapa3.put(0, "Kamil");
        mapa3.put(3, "Tomek");
        mapa3.put(9, "Pawel");
        mapa3.put(12, "Jan");
        mapa3.put(2, "Krzysztof");


        //-----
        //metody:
        mapa1.clear();
        mapa1.put(0, "Przemek");
        mapa1.putAll(mapa2);
        String imiePod0 = mapa1.get(0);// zwroci wartosc z klucza "0"
        mapa1.remove(0);// usunie klucz "0" i jego wartosc
        boolean czyKluczIstanieje = mapa1.containsKey(0);// czy mapa zawiera
        // klucz "0"
        boolean czyWartoscInsteniej = mapa1.containsValue("kamil");
        boolean czyPusta3 = mapa1.isEmpty();
        int iloscElementow2 = mapa1.size();
        Set<Integer> zbiorKluczy = mapa3.keySet();
        Set<Integer> zbiorKluczySortowany = new TreeSet<>(mapa3.keySet());
        //beda posortowane

        Collection<String> kolekcjaWartosci = mapa3.values();
        //moge dac bezposreniednio tylko do Collection bo taki typ zwraca
        // metoda values()
        List<String> zbiorWartosci = new LinkedList<>(mapa3.values());
        //musze dac w konstruktorze bo metoda .values() zwraca typ Collection

        Set<Map.Entry<Integer, String>> zbiorKluczWartosc = mapa3.entrySet();
        //kazdy element zbioru bedzie skladal sie z klucza i wartosci,
        //Metoda entrySet() zwraca zbior


        //-----
        //Iterowanie:
        mapa1.clear();
        mapa1.put(0, "kamil");
        mapa1.put(1, "tomek");

        System.out.println("-------------------");
        System.out.println("KLUCZE:");
        for (Integer x : mapa1.keySet()) {
            System.out.println(x + ": " + mapa1.get(x));
        }

        System.out.println("WARTOSCI");
        for (String x : mapa1.values()) {
            System.out.println(x);
        }

        System.out.println("ZBIOR KLUCZ WARTOSC");
        Set<Map.Entry<Integer, String>> zbiorKluczWartosc2 = mapa1.entrySet();
        for (Map.Entry<Integer, String> x : zbiorKluczWartosc2) {
            System.out.println(x.getKey() + ": " + x.getValue());
        }

        //lub bez deklaracji oddzielnego zbioru wywolujac na mapie bezposrenio metode
        // entrySet() w petli
        System.out.println("ZBIOR KLUCZ WARTOSC 2");
        for(Map.Entry<Integer, String> x : mapa1.entrySet()){
            System.out.println("klucz nowy: "+x.getKey());
            System.out.println("wartosci nowa: "+x.getValue());
        }



        /*-------------------------------------------------------------------------
        -----------------SORTOWANIE KOLEKCJI COMPARABLE COMPARATOR-----------------


        Sortowanie z uzycem Collections.sort, Arrays.sort i interfacem Comparator
         z klasa anonimowa

        Metoda Collection.sort lub Arrays.sort przyjmuje sama Kolekcje lub Kolekcje z Comparatorem!

        Jesli metoda przyjmuje:

        -TYLKO kolekcje z typem generycznym mojej klasy
        //Collections.sort(listaDoSortowania);
        To moja klasa musi implementowac interface Comparable<KlasaDoSortowania> z metoda
         int compareTo(KlasaDoSortowania o). Metoda zwraca >0 gdy this.wartosc jest wieksze
         od o.wartosc, <0 gdy odwrtnie i 0 gdy rowne
        Zmienne brane sa po kolei z Listy - this.wartosc jest wartoscia
         elementu 0 a o.wartosc jest wartoscia elementu 1.
        */
        List<KlasaDoSortowania> listaDoSortowania = Arrays.asList(
                new KlasaDoSortowania("dddd"),
                new KlasaDoSortowania("aaaaaa"),
                new KlasaDoSortowania("ee"),
                new KlasaDoSortowania("cccccccc"),
                new KlasaDoSortowania("f"),
                new KlasaDoSortowania("b")
        );
        class KlasaDoSortowania2 implements Comparable<KlasaDoSortowania2> {
            public String napis;

            public KlasaDoSortowania2(String napis) {
                this.napis = napis;
            }

            @Override
            public int compareTo(KlasaDoSortowania2 o) {
                return this.napis.length() - o.napis.length();
            }

        }
        Collections.sort(listaDoSortowania);
        System.out.println("Sortowanie 1 wg dlugosci:");
        for (KlasaDoSortowania x : listaDoSortowania) {
            System.out.print(x.napis + " ");
        }
        /*
        --
        Jesli klasa ma zmienna typu String to moge takze sprawdzic dlugosc
         napisu wykorzystujac lenght

         public int compareTo(KlasaDoSortowania o) {
                return this.napis.length() - o.napis.length();
         }
        --
         Lub jesli chce posortowac Stringi wedlug naturalnego porzadku to
          moge uzyc metody metody compareTo w compareTo!

         public int compareTo(KlasaDoSortowania o) {
                return this.napis.compareTo(o.napis);
         }
        --
         Lub jesli mam imie i nazwiko jako pola to moge zrobic
          sortowanie po nazwisku a jesli rowne to po imieniu

         public int compareTo(Czlowiek o){
            int wyjscie = this.nazwisko.compareTo(o.nazwisko);
            if(wyjscie==0)
                return this.imie.compareTo(o.imie);
            //jesli takie samo nazwisko to sortuje po imieniu
            else
                return wyjscie;
        }


         -Kolekcje z typem generycznym mojej klasy ORAZ komparator
          Collections.sort(listaDoSortowania, new KlasaSortujaca());
         1. Moge stworzyc nowa klasa implementujaca interfejs
         Comparator<KlasaDoSortowania> i w niej metode interfejsu
         int compare (KlasaDoSortowania o1, KlasaDoSortowania o2)
         */
        class KlasaSortujaca2 implements Comparator<KlasaDoSortowania> {
            @Override
            public int compare(KlasaDoSortowania o1, KlasaDoSortowania o2) {
                int wyjscie = o1.napis.compareTo(o2.napis);
                if(wyjscie == 0){
                    //jesli napisy beda rowne
                    return o1.compareTo(o2);
                    //wykorzystam sortowanie Comparable z klasy obiektow
                }
                else
                    return wyjscie;
            }
        }
        Collections.sort(listaDoSortowania, new KlasaSortujaca());
        System.out.println("\n" + "Sortowanie 2 wg naturalnego porzadku:");
        for (KlasaDoSortowania x : listaDoSortowania) {
            System.out.print(x.napis + " ");
        }
          /*

          --
          2. Moge takze stworzyc unikalne sortowanie uzywjaac klasy anonimowej
           i definicje sortowania w wywolaniu metody sort*/

          Collections.sort(listaDoSortowania, new Comparator<KlasaDoSortowania>() {
            @Override
            public int compare(KlasaDoSortowania o1, KlasaDoSortowania o2) {
                return o1.napis.compareTo(o2.napis);
            }
          });




        /*--------------------------------------------------------------------
        ----------------------OPERACJE NA PLIKACH-----------------------------
        lokalizacje plikow w systemach
         Windows: C:\katalog\plik.txt
         Linux: /katalog/plik.txt

        Sciezka w Javie zapisana do string bedzie nastepujaca:
         "C:\\katalog\\plik.txt"

        Sciezki mozemy podzielic na relatywne i absolutne
        Absolutna jest pelna sciezka
         C:\folder_2\folder_2_a\plik_2_a.txt
        Relatywna jest ta z ktorego miejsca sie odnosimy
         folder_2_a\plik_2_a.txt


        Tryby dostepu do plikow dzieliy na:
        -do odczytu
        -do zapisu - kasuje plik jesli istnieje i utworzenie nowego lub
          utowrzenie nowego jesli nie istnieje - domyslny tryb
        -w trybie dolaczania - dopisuje do istniejacego pliku nowa wartosc

        Klasa File zawiera postawowe operacje na plikach i przyjmowana jako
         parametr moze posluzyc do utworzenia unstancji innej klasy np:
        -FileReader - odczyt pliku znak po znaku
        -BufferReader - odczyt linijka po linijce
        new BufferedReader(new FileReader(new File("/path/to/text/file.txt")));

        Jest to dostanie sie do pliku "warstwa po warstwie"
        Mozna wykorzystac do tego konstruktory nie tworzac instancji klasy File
        new BufferedReader(new FileReader("/path/to/text/file.txt"));

        Klasy plikow maja wskaznik ktory po odczytaniu danych zostaje przesuniety
         na miejsce gdzie ostatnio czytalismy plik!

        Zmienna klasowa (FileWriter itp) tworze przed blokiem try/catch a w nim
         przypisuje ich wartosc oraz wywoluje konkretna metode.
        Oprocz tego w bloku finally musze zamknac strumien

        Przydatne klasy:
        -FileWriter - zapis do pliku tekstowego
        FileWriter fileWriter = new FileWriter("/folder1/plik.txt");
        fileWriter.write("napis");
        if (fileWriter != null) {
            fileWriter.close();
        }

        -BufferedReader - odczyt pliku
        BufferedReader fileReader = new BufferedReader(new FileReader("/folder1/plik.txt"));
        String linia = fileReader.readLine();
        //Metoda zapisze cala linie z pliku tekstowego, moge umiescic to w while(true)
        // i sprawdzic kiedy bedzie linie pusta if(linia == null){break;}
        int liczbowo = Integer.parseInt(napis);
        if (fileReader != null) {
            fileReader.close();
        }

        -DataOutputStream - zapis binarny do pliku tekstowego
        DataOutputStream strumienWyjsciowy = new DataOutputStream(new FileOutputStream(lokalizacja2));
        //FileOutputStream zapisuje dane bajt po bajcie
        //DataOutputStream zapewnia bunarny zapis typow prymitywnych
        strumienWyjsciowy.writeInt(12355);
        //Ta metodaZwykla zapisze typy proste jak int w sposob binarny
        if (strumienWyjsciowy != null) {
            strumienWyjsciowy.close();
        }

        -DataInputStream - odczyt binarnych danych
        DataInputStream strumienWejsciowy = new DataInputStream(new FileInputStrem(lokalizacja));
        int liczba = strumienWejsciowy.readInt();
        if (strumienWejsciowy != null) {
            strumienWejsciowy.close();
        }
         */

        class Wew4 {
            void metoda() {
                //zapis
                String loklizacja = "src/Podsumowanie/PlikiTestowe/plik1.txt";
                int liczbaDoZapisu = 12345;
                FileWriter zapis = null;
                //musi byc deklaracja do null zeby zamknac w finally!
                try {
                    zapis = new FileWriter(loklizacja);
                    zapis.write(Integer.toString(liczbaDoZapisu));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (zapis != null) {
                        try {
                            zapis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //odczyt
                int liczbaDoOdczytu;
                BufferedReader odczyt = null;
                try {
                    odczyt = new BufferedReader(new FileReader(loklizacja));
                    String tmp = odczyt.readLine();
                    liczbaDoOdczytu = Integer.parseInt(tmp);
                    System.out.println("-------------------");
                    System.out.println("Odczytana liczba z pliku: " + liczbaDoOdczytu);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (odczyt != null) {
                        try {
                            odczyt.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        Wew4 wew4 = new Wew4();
        wew4.metoda();


        //-----
        //Pliki binarne

        class Wew5 {
            void metoda() {
                //zapis
                String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikBinarny1.txt";
                int liczbaDoZapisu = 25152424;
                DataOutputStream strumienWyjsciowy = null;
                try {
                    strumienWyjsciowy = new DataOutputStream(new FileOutputStream(lokalizacja));
                    strumienWyjsciowy.writeInt(liczbaDoZapisu);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (strumienWyjsciowy != null) {
                        try {
                            strumienWyjsciowy.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //odczyt
                int liczbaDoOczytu;
                DataInputStream strumienWejsciowy = null;
                try {
                    strumienWejsciowy = new DataInputStream(new FileInputStream(lokalizacja));
                    liczbaDoOczytu = strumienWejsciowy.readInt();
                    System.out.println("-------------------");
                    System.out.println("Odczytana liczba z binarnego pliku: " + liczbaDoOczytu);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (strumienWejsciowy != null) {
                        try {
                            strumienWejsciowy.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        Wew5 wew5 = new Wew5();
        wew5.metoda();


        //-----
        //TRY WTIH RESOURCES
        /*
        w tym przypadku nie musze juz zamykac strumienia

        boilerplate code - powtarzenie kodu
        try-with-resources - cukier syntaktyczny - syntactic sugar
         */
        class Wew6 {
            void metoda() {
                String lokalizacja = "src/Podsumowanie/PlikiTestowe/plik2.txt";
                String napisDoZapisu = "Try with resorces";
                try (BufferedWriter zapisz = new BufferedWriter(new FileWriter(lokalizacja))) {
                    zapisz.write(napisDoZapisu);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //lub jednoczesny zapis i odczyt w () try
                //zrobie kopie poprzedniego pliku do nowego plik3.txt
                String lokalizacja2 = "src/Podsumowanie/PlikiTestowe/plik3.txt";
                try (BufferedReader wczytaj = new BufferedReader(new FileReader(lokalizacja));
                     //pamietam o ; po 1 instrukcji w try!
                     BufferedWriter zapisz = new BufferedWriter(new FileWriter(lokalizacja2))) {
                    zapisz.write(wczytaj.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        Wew6 wew6 = new Wew6();
        wew6.metoda();


        //----
        //Tworzenie folderu/pliku Klasycznie
        //-tworznie pliku
        String lokalizacja3 = "src/Podsumowanie/PlikiTestowe/plik5.txt";
        if(!Files.exists(Paths.get(lokalizacja3)))
            Files.createFile(Paths.get(lokalizacja3));
        //lub
        String lokalizacja4 = "src/Podsumowanie/PlikiTestowe/plik6.txt";
        File file = new File(lokalizacja4);
        if(!file.exists())
            file.createNewFile();

        //tworznie folderu
        String lokalizacja = "src/Podsumowanie/PlikiTestowe/MojFolder";
        new File(lokalizacja).mkdir();

        //lub
        String lokalizacja2 = "src/Podsumowanie/PlikiTestowe/MojFolder2";
        if(!Files.exists(Paths.get(lokalizacja2)))
            Files.createDirectory(Paths.get(lokalizacja2));


        //----
        //Kopiowanie pliku
        String gdzieSkopiowac = "src/Podsumowanie/PlikiTestowe/MojFolder/plikSkopiwoany.txt";
        //nazywam plik tam gdzie ma byc skopiowany
        Files.copy(Paths.get(lokalizacja3)
                ,Paths.get(gdzieSkopiowac)
                ,StandardCopyOption.REPLACE_EXISTING);
        //Prenosszenie pliku
        String gdziePrzeniesc = "src/Podsumowanie/PlikiTestowe/MojFolder2/plikPrzeniesiony.txt";
        Files.move(Paths.get(lokalizacja4),
                Paths.get(gdziePrzeniesc),
                StandardCopyOption.REPLACE_EXISTING);


        //----
        //Ze strumieniami

        String adresPliku = "src/Podsumowanie/PlikiTestowe/plik4.txt";
        try(Stream<String> stream = Files.lines(Paths.get(adresPliku))) {
            //umieszczam w zmiennej Stream plik, kazda linia to jeden
            // element strumienia
            System.out.println("Linie mojego pliku");
            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //moge takze uzyc filtracji
        try(Stream<String> stream = Files.lines(Paths.get(adresPliku))) {

            List<String> linie = new ArrayList<>();
            linie = stream
                    .filter(x->!x.startsWith("linia 2"))
                    //nie zaczyna sie na "linia 2"
                    .map(String::toUpperCase)
                    .collect(toList());
            System.out.println("Linie po filtracji + zmiana liter na duze");
            linie.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //moge uzyc BufferedReader
        try(BufferedReader br = new BufferedReader(new FileReader(adresPliku))){
            List<String> linie = new ArrayList<>();
            linie = br.lines().collect(toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*-------------------------------------------------------------------------
        -----------------------------SERIALIZACA-----------------------------------

        Serializacja jest proces w ktorym zapisuje obiekt na sekwencje bitow,
         aby obiekt danej klasy mogl byc serializowany musi ona implementowac
         interfejsc Serializable


        Serializacja to binarny zapis drzewa obiektow
        Zserializowane obiekty mozna przeslac i zdeserializowac na innej
         maszynie wirtualnej tworzac nowe obiekty - obie maszyny musze miec
         dostep do skompilowanych wersji klas

        Wymagana jest kolejnosc serializacji zgodna z deserializacja. Jesli dodaje
         do strumienia najpierw liste a potem zmienna int to w deserializacj najpierw
         bede musial odczytac liste a potem int bo inaczej wyrzuci wyjatek
         java.io.OptionalDataException
        */
        class Wew7 {
            void metoda() {
                String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikObiektowy1.bin";
                int liczbaDoZapisu = 32167;
                String napisDoZapisu = "5 black dragons";
                int liczba2DoZapisu = 69;
                try (ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja))) {
                    strWyj.writeObject(liczbaDoZapisu);
                    //zapisuje jako Object wiec bedzie mialo typ Object
                    strWyj.writeObject(napisDoZapisu);
                    strWyj.writeInt(liczba2DoZapisu);
                    //zapisuje jako int wiec w odczycie nie bede musial rzutowac
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))) {
                    int licbzaOdczytana = (Integer) strWej.readObject();
                    String napisOdczytany = (String) strWej.readObject();
                    int liczba2Odczytana = strWej.readInt();
                    System.out.println("-------------------");
                    System.out.println("licbzaOdczytana : " + licbzaOdczytana);
                    System.out.println("napisOdczytany : " + napisOdczytany);
                    System.out.println("liczba2Odczytana : " + liczba2Odczytana);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        Wew7 wew7 = new Wew7();
        wew7.metoda();


        /*-----
        Serializacja drzewa obiektow
        Obiekt serializowany i zdeserializowany beda mialy inny adres referncji

        Aby klasa mogla byc seriaizowana musi implmemntowac intefejs znacznikowy
         (nie posiadajacy zadnej metody) java.io.Serializable ktory ma za zadanie
         informowac ze instancje tej klasy moga byc serializowane
        Jesli zserializuje instanjce klasy bez tego interfejsu zostanie wyrzucony wyjatek
         NotSerializableException.

        UWAGA! Jesli chce serializwoac moja klase ktora rozszerza inna to musze odwolac sie
         w konstruktorze mojej klasy do konstruktora innej + ta inna klasa musi miec
         konstruktor BEZPARAMETROWY, chyba ze posiada ona konstruktor
         bezparamtrowy to nie musze (wykona sie niejawne wywolanie odwolanie do konstruktora
         bezparametrowegeo super(); )
        */

        class Auto { // ta klasa nie musi implementwoac intef. Serializable
            private String marka;

            public Auto() {
            }//ta klasa musi miec konstruktor bezparametowy! - bezwglednie

            public Auto(String marka) {
                this.marka = marka;
            }
        }
        class Audi extends Auto implements Serializable {
            private int moc;

            public Audi(String marka, int moc) {
                super(marka);
                this.moc = moc;
            }
        }
        class Factory {
            String lokalizacjaX = "src/Podsumowanie/PlikiTestowe/plikObiektowy4.bin";

            void seriazlize() {
                try (ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacjaX))) {
                    Audi audi = new Audi("audi", 120);
                    strWyj.writeObject(audi);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            void deserialize() {
                try (ObjectInputStream strWyj = new ObjectInputStream(new FileInputStream(lokalizacjaX))) {
                    Audi audi2 = (Audi) strWyj.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        Factory factory = new Factory();
        factory.seriazlize();
        factory.deserialize();


        //----

        class Opona implements Serializable {
            int rozmiar;

            public Opona(int rozmiar) {
                this.rozmiar = rozmiar;
            }

            public int getRozmiar() {
                return rozmiar;
            }
        }
        class Silnik implements Serializable {
            String nazwa;

            public Silnik(String nazwa) {
                this.nazwa = nazwa;
            }

            public String getNazwa() {
                return nazwa;
            }
        }
        class Samochod implements Serializable {
            Opona[] opony;
            Silnik silnik;

            public Samochod(Silnik silnik, Opona[] opony) {
                this.silnik = silnik;
                this.opony = opony;
            }

            public Silnik getSilnik() {
                return silnik;
            }

            public Opona[] getOpony() {
                return opony;
            }
        }
        class FabrykaSamochodow {
            void main() {
                System.out.println("-------------------");
                String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikObiektowy2.bin";
                Opona[] opony = new Opona[]{new Opona(12), new Opona(15)};
                Silnik silnik = new Silnik("Boxer");
                Samochod samochod = new Samochod(silnik, opony);
                try (ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja));
                     ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))) {
                    //zapis
                    strWyj.writeObject(samochod);

                    //odczyt
                    Samochod noweAuto = (Samochod) strWej.readObject();
                    //musze rzutowac
                    System.out.println("nazwa silnika: " + noweAuto.silnik.getNazwa());
                    Opona[] noweOpony = noweAuto.getOpony();
                    for (int i = 0; i < noweAuto.opony.length; i++) {
                        System.out.println("Opona " + (i + 1) + " ma rozmiar : " + noweOpony[i].rozmiar);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        FabrykaSamochodow fabrykaSamochodow = new FabrykaSamochodow();
        fabrykaSamochodow.main();


        //-----
        //Zachowanie atrybytow transient oraz static po deserializacji
        /*
        Transient
        Gdy chcemy aby jakis pole klasy nie bylo serializowane,
         np sekundy od urodzenia osoby - wynik zdeserializowany na innej JVM bylby
         bledny uzywamy przez zmienna parametru transient

        W przypadku serializowania pol statycznych beda one po serializacji mialy taka
         sama wartosc jak w deklaracji pola klasy poniewaz dotycza one klasy a nie obiektu
         tzn beda mialy taka wartosc jak klasa ktora je deserialzuje!
         UWAGA ! w jednym main jesli zrobimy serializacje i deserializacje pola statycznego
         ze zmiana w obiekcie - pokaze po deserializacji takze zmieniona wartosc
         */
        class Czlowiek implements Serializable {
            private transient Integer identyfikator;
            private transient int wiek;
            private String imie;

            public Czlowiek(Integer identyfikator, int wiek, String imie) {
                this.identyfikator = identyfikator;
                this.wiek = wiek;
                this.imie = imie;
            }
        }
        class CzlowiekFabryka {
            String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikObiektowy3.bin";

            void zapisz() {
                Czlowiek c1 = new Czlowiek(2341, 27, "Kamil");
                try (ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja))) {
                    strWyj.writeObject(c1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            void oczytaj() {
                try (ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))) {
                    Czlowiek c2 = (Czlowiek) strWej.readObject();
                    System.out.println("----------------------------");
                    System.out.println("czlowiek identyfikator : " + c2.identyfikator);
                    //pokaze null
                    System.out.println("czlowiek wiek : " + c2.wiek);
                    System.out.println("czlowiek imie : " + c2.imie);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        CzlowiekFabryka czlowiekFabryka = new CzlowiekFabryka();
        czlowiekFabryka.zapisz();
        czlowiekFabryka.oczytaj();


        //----
        //Specjalna (wlasna) obsługa serializacji/deserializacji
        /*
        Moge dodac wlasne metody (PRIVATE VOID!) readObject oraz writeObject aby zmodyfikowac
         jak ma byc serializowany OBIEKT polega to na stworzeniu w serializowanej
         klasie metody writeObject/readObject przyjmujacej artgument ObjectOutputStream
         lub ObjectInputStream i wyrzuca wyjatki IOException a readObjet takze
         ClassNotFoundException.
        W Ciele metdody deklaruje co strumien ma zapisywac lub jak maja zachowywac
         sie jego elementy przy odczycie.

        W przypadku metody writeObject wybieram pola klasy jakie maja zapisane i
         do odpowiedniego typu pola wybieram odpowiednia metode np:
         strWyj.writeUTF(stringTans); - dla String
         //UWAGA ! ZMIENNA TRANSIENT ZOSTANIE TAKZE ZAPISANA DO STRIMIENIA
         strWyj.writeInt(liczba+10); - dla int
        W metodzie readObject analogiczne odczytuje i przypisuje do pol to
         co chce
         stringTans = strWej.readUTF();
         liczba = strWej.readInt();

        Jesli do ktorejs z metod dodam strWyj.defaultReadObject() lub
          strWej.defaultReadObject(); to wszystkie pola klasy zostana
          zserializwoane oraz zdeserializowane i przypisane do wartosci pol.

        Moge rowniez dodac NOWE swoje zmienne w tej metodzie i zmieniac ich wartosc oraz
         modyfikowac zmienne serializowanego obiektu - wszystko dotyczylo bedzie
         serializowanego OBIEKTU!!
        W takim przypadku jesli bede chcial dodac dodatkowa zmianna do strumienia
         w metodzie writeObject bede mogl uzyc
         metody np. dla int - int nowaZmienna =10; strWyj.writeInt(nowaZeminna); i zostanie
         dodana kolejna zmienna zapisana w struminiu (kolejnosc zapisu musi byc
         taka sama jak kolejnosc odczytu!!)
         UWAGA!!
         Do zmiennej dodatkowej dodanej do strumienia w metodzie writeObject bede mogl
         dostac sie tylkow metodzie readObject a nie w dodatkowej metodzie
         strWej.readInt(); w bloku try!!
        Wiec jesli na poczatku metody mialem strWyj.defaultReadObject() a nastepnie dodalem
         zmienna int do stumienia strWyj.writeInt(nowaZeminna) to w metodzie odczytu
         readObject takze bede musial na poczatku dac strWej.defaultReadObject();
         i opcjonalnie dostac sie do dodatkowej zmiennej int zapisanej do niej
         system.out.println(strWej.readInt());
        Dodatkowe zmienne w metodach write/readObject dotycza zapisu zmiennych w obiekcie!!

        W serializacji bloku try dodaje obiekt do stumienia strWyj.readObject(silnik) oraz
         moge dodatkowo dodac do strumienia zmienna int - strWyj.writeInt(zmiennaInt) i bede
         mogl w takim przypadku dostac sie do niej w bloku try w deserializacji.
         Dodanie do strumienia zmiennej metodaZwykla writeInt nie ma nic wspolengo z moja
         meotda writeObject()!! poniewaz dotycza one zapisywanego obiektu!
         Zmienne dodane w metodzie writeObject sa dostepne tylko w metodzie readObject!!
        UWAGA!
         Kolejnosc dodawania elementow do strumienia W BLOKU TRY ma znaczenie!
         Jelis dam najpierw w bloku try w serializacji:
         strWyj.writeObject(obiekt);
         strWyj.writeInt(123);
         to w deserializacji bloku try bede musial dac w takiej kolejnosci:
         Klasa obiekt = (Klasa)strWej.readObject();
         int x = strWej.readInt();
         */
        class SerializacjaUnikalna implements Serializable {
            private transient String stringTans;
            private String stringNormalny;
            private int liczba;

            public SerializacjaUnikalna(String stringTans, String stringNormalny, int liczba) {
                this.stringTans = stringTans;
                this.stringNormalny = stringNormalny;
                this.liczba = liczba;
            }

            private void readObject(ObjectInputStream strWej) throws IOException, ClassNotFoundException {
                stringTans = strWej.readUTF(); //mam dostep do pol klasy wiec nie musze ich deklarowac
                stringNormalny = strWej.readUTF();
                liczba = strWej.readInt();
                //Dodajew wszystkie przyspisania do pol klasy ale moge zrobic to jedna metodaZwykla
                // strWej.defaultReadObject(); - jest to standardowa metodaZwykla dzialania metody
                // readObject jesli jej nie zadeklaruje czyli dodanie wszystkich pol obiektu
                // klasy do strumienia OBIEKTU
            }

            private void writeObject(ObjectOutputStream strWyj) throws IOException {
                //Na poczatku moge dodac strWyj.defaultWriteObject() aby
                // zostal zapisany obiekt w calosci (wszystkie jego pola automatycznie)
                // czyli to co ponizej
                //Jest to standardowa metodaZwykla writeObject jesli nie stworze jej wlasnej
                // deklaracji
                strWyj.writeUTF(stringTans);
                //wybrana metodaZwykla zapisu zalezna od rodzaju zmiennej
                //moge nawet zapisac zmienna z parametrem Transient
                strWyj.writeUTF(stringNormalny);
                strWyj.writeInt(liczba + 10);
            }
        }
        class SerializacjaUnikalnaFabryka {
            void main() {
                SerializacjaUnikalna s = new SerializacjaUnikalna("napT", "napN", 10);
                try (ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream("SU"))) {
                    strWyj.writeObject(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (ObjectInputStream strWej = new ObjectInputStream(new FileInputStream("SU"))) {
                    SerializacjaUnikalna s2 = (SerializacjaUnikalna) strWej.readObject();
                    System.out.println(s2.stringTans);
                    System.out.println(s2.stringNormalny);
                    System.out.println(s2.liczba);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


        //----

        //Dziedziczenie w serializacji
        /*
        Klasa ktora rozszerza klase implementujaca inteface Serializable
         automatycznie takze go implementuje wiec takze jest serializowana!!

        Jesli chce aby klasa nie byla serializowna moge nadpisac metody
         private void readObject(ObjectInputStream strWej) lub/oraz
         void writeObject(ObjectOutputStream strWyj)
         i wyrzucic w nich odpowienio podpisany wyjatek NotSerializableException
         */
        class Chinczyk extends Czlowiek {

            public Chinczyk(Integer identyfikator, int wiek, String imie) {
                super(identyfikator, wiek, imie);
            }

            private void writeObject(ObjectOutputStream strWyj) throws IOException {
                throw new NotSerializableException("Nie serialzuje Chinczyka");
            }

            private void readObject(ObjectInputStream strWej) throws IOException {
                throw new NotSerializableException("Nie serialzuje Chinczyka");
            }
        }


        //----

        //Interface Externalizable
        /*
        Klasa implementujaca ten interface musi posiadac konstruktor bezparametrowy
         oraz implementowac wlasne metody strumienia wyjscia i wejscia
         writeExternal oraz readExternal deklarujace dzialanie zapisu obiektow do strumienia
        W tych metodach nie ma metody defaultWrite/ReadObject !! wiec musze
         sam zadklarwoac wszystko co chce odczytac i zapisac do strumienia z Obiektu
         */
        class PelnaKontrola implements Externalizable {

            private String napis;

            public PelnaKontrola() {

            }

            public PelnaKontrola(String napis) {
                this.napis = napis;
            }

            @Override
            public void writeExternal(ObjectOutput out) throws IOException {
                out.writeUTF(napis);
            }

            @Override
            public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
                napis = in.readUTF();
            }

            void main() {
                PelnaKontrola pK = new PelnaKontrola("testuje Pelna konrole");
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pelnaKontrola.bin"))) {
                    out.writeObject(pK);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pelnaKontrola.bin"))) {
                    PelnaKontrola pKnew = (PelnaKontrola) in.readObject();
                    System.out.println(pKnew.napis);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }


        //----

        //Pole serialVersionUID
        /*
        Tworze je aby sprawdzic poprawnosc serializacji i deserializacji
        private static long serialVersionUID;
        Moge nadac jej wartosc sam lub kompilator zrobi to za mnie
         */



         /*-------------------------------------------------------------------------
        ------------------------ENUM TYP WYLICZENIOWY-------------------------------

        Sluzy do grupownia znanych nam wartosci - latwo je rozbudowywac

        Wartosci typu wyliczniowego maja atrybut public static final !
         wiec odwolujac sie do nich podaje nazwe typu wyliczeniowego
         np zmienna w klasie:
        */
        KoszulkaRozmiar rozmiar = KoszulkaRozmiar.M;
        System.out.println("------------------");
        System.out.println(rozmiar);
        //pokaze sama wartosc Enum czyli M!

         /*
        Wartosci pisze wielkimi literami

        Enum nie mozna rozszerzac - jest jako final ! i nie moze dziedziczyc
         poniewaz dziedzicy po java.lang.Enum

        Wartosci enum mozna porownywac ==

        Nie mozna tworzyc instancji enum

        Przyklad uzycia w switch: */
        switch (rozmiar) {
            case L://pisze sama wartosc bez nazwy klasy!
                System.out.println("mam rozmiar l");
                break;
        }

         /*
        Konstruktor Enum jest zawsze private ! - nie musze tego modyfikatora pisac


        Enum moze byc prosty lub rozszerzony:

        -Prosty:
        Sklada sie z podanych wartosci bez specyfikacji (podwartosci)
        public enum mojEnum{
            S,M,L,XL
        }
        Wartosci oddzielamy przecinkiem, jesli nie ma nic na po nich nie stawiem
         srednika


         -Rozszerzony:
        Kazda wartosc Enuma moze posiadac podwartosci ktore przypisuje
         do oddzielnych prywatnych pol Enuma i nadaje im wartosci w konstruktorze
        Tyle ile podam podwartosci w kazdej zmiennej tylu parametrowy konstruktor
         musze stworzyc oraz tyle prywanych zmiennych stworzyc!
        W konstruktorze decyduje ktore pole Enuma jest przyporzedkowane
         ktorej zmiennej!
        Robie to poniweaz chcac sie dostac do podwartosci zmiennej moge to
         zrobic tylko za pomoca geterow nowych pol ktore maja przypisane
         podwartosci kazdej zmiennej */

        System.out.println("Rozszerzony Enum:");
        System.out.println(KoszulkaRozmiarDokladnie.S);
        //pokaze samo S
        System.out.println(KoszulkaRozmiarDokladnie.S.dajSzerokoscKlatki());
        //pokaze podwartosc jednego z wartosci - 48

        /*
        public enum KoszulkaRozmiarDokladnie{
            S(10,20,30), //3 wartosci wiec 3 param. konstr. musze stworzyc
            M(20,30,40), // oraz 3 prywatne pola Enuma
            L(30,40,50); //SREDNIK JESLI JEST COS PO WARTOSCIACH!

            //tworze 3 zmienne poniewaz kazna zmienna ma 3 "podwartosci"
            // i przypisuje im wartosci w konstruktorze:
            private int chestWidth;
            private int shirtLength;
            private int sleeveLength;

            //konstruktor jest zawsze private!
            KoszulkaRozmiarDokladnie(int chestWidth, int shirtLength, int sleeveLength)
                this.chestWidth = chestWidth;
                this.shirtLength = shirtLength;
                this.sleeveLength = sleeveLength;
            }

            //oraz tworze getery do tych pol
            // aby moc sie do nich odwolac na poszczegolnych wartosciach
            // np: mojEnum.S.getPodZmeinna1(); - w sout pokaze wybrana podwartosc
            // podZmiennej1 np: 30;
            public int getChestWidth() {
                return chestWidth;
            }
            public int getShirtLength() {
                return shirtLength;
            }
            public int getSleeveLength() {
                return sleeveLength;
            }
        }
         */


        //----

        //Metody:

        //.vlues() - metoda statyczna wywolywana na nazwie Enuma, pokaze wartosci
        //          jakie ma Enum, mozna wyswoetlic w foreach
        System.out.println("Wartosci Enuma porstego");
        for (KoszulkaRozmiar x : KoszulkaRozmiar.values()) {
            System.out.print(x + " ");
        }
        System.out.println("\n\n" + "Wartosci Enuma rozszerzonego");
        for (KoszulkaRozmiarDokladnie x : KoszulkaRozmiarDokladnie.values()) {
            System.out.print("\n" + x + " ");
            System.out.print(x.dajSzerokoscKlatki() + " ");
            System.out.print(x.dajwysokoscKoszulki() + " ");
            System.out.print(x.dajdlugoscRekawa());

        }


        //.valueOf("WARTOSC") - metoda statyczna wywolywana na nazwie enuma, pokaze
        //                       wartosc wpisanej w "" wartosci
        System.out.println("\n" + KoszulkaRozmiarDokladnie.valueOf("S"));
        //pokaze samo S
        System.out.println(KoszulkaRozmiar.valueOf("S"));
        //pokaze samo S


        //.ordinal(); - metoda wywolywana na zmiennej typu Enum,
        //              pokaze numer kolejnosci zmiennej Enuma
        //              ktora posiada wybrana zmienna (liczone od 0)
        KoszulkaRozmiar koszulka3 = KoszulkaRozmiar.XL;
        System.out.println("Numer zmiennej Enuma koszulki 3 : " + koszulka3.ordinal());
        //3 (XL jest 4 ale liczy od 0)


        //.name() - metoda wywolywana na zmiennej typu Enum,
        //           zwroci wartosc zmiennej na jakiej zostanie wywowlana metoda
        KoszulkaRozmiar koszulka1 = KoszulkaRozmiar.S;
        System.out.println("koszulka1 : " + koszulka1.name());
        //S
        KoszulkaRozmiarDokladnie koszulka2 = KoszulkaRozmiarDokladnie.M;
        System.out.println("koszulka2 : " + koszulka2.name());
        //M


        //----
        /*Metody abstrakcyjne Enuma:
        Sluza do stworzenia definicji metody ktorych cialo deklaruje w wartociach
         po nazwie w {}

        Metoda abstakcujna nie posiada ciala tylko definicje (co przyjmuje i
         jaki typ zwraca)
        Wartosci enuma moga posiadac podwartosci w () i metody w {}
        Metoda musi pasowac do metody abstakcyjnej tj typ przyjmowany,
         jej nazwa i to co zwraca + tutaj deklaruje cialo!
         */
        String enumText;
        enumText = EnumDoTekstu.IMIE.format("Kamil");
        enumText = enumText.concat(EnumDoTekstu.NAZWISKO.format("Zajac"));
        System.out.println(enumText);
        /*
        enum EnumDoTekstu{
            IMIE{
                public String format(String wiadomosc){
                    return "Czesc " + wiadomosc;
                }
            },
            NAZWISKO {
                public String format(String wiadomosc) {
                    return " " + wiadomosc;
                }
            };
            public abstract String format(String wiadomosc);
        }
         */



         /*-------------------------------------------------------------------------
        ------------------------ADNOTACJE / DYREKTYWA JavaDoc-----------------------

        JavaDoc to standardowy mechanizm generowania dokumentacji, jest
         on w specjalnym komentarzu wieloliniowym zaczynajacym sie od /**
         z * na poczatku kazdej linii
        Sa w nim dyrektywy takie jak @param czy @retrun oraz opis
        Moga byc takrze @see, @author czy @version
        /**
         * Multipies number by 2 // co robi metodaZwykla
         * @param parameter number that should be multipied // co sie stanie
         * // z parametrem ktory przyjmie
         * @return parameter multipied by 2// to co zwraca i jak
         */
         /*
        public int timesTwo(int param){
            return param * 2;
        }


        //----
        //Adnotacje
        Przekazuja dodatkowe informacje na temat kodu
        Przekazuja dane o danych - kodzie zrodlowym
        Sa one specjalnym interfejsem
        Umieszczamy je przed konkretnym elementem np. klasa/zmienna/metodaZwykla

        Mozemy je stosowac do:
        -metody
        -klasy
        -pola/atrybutu klasy
        -parametru metody(to co przyjmuje)
        -zmiennej lokalnej
        -konstruktora
        -adnotacji typu


        Adnotacja powinna miec informacje: (przed definicja)
        -@Target (ElementType.METHOD/TYPE/ANNOTATION_TYPE/CONSTRUCTOR/FIELD/
                              LOCAL_VARIABLE/MODULE/PACKAGE)
         Czyli do jakich elementow moze byc stosowana np.
         @Target(ElementType.METHOD)
         jesli jej nie okresle to bede mogl jej uzywac wszedzie z wyjatkiem typow
         typ wyliczniowy : ElementType

        -@Retention (RetentionPolicy.RUNTIME/CLASS/SOURCE)
         Czyli jak dlugo dane o adnotacji powinny byc przechowywane / gdzie beda wykrywane
         adnotacje - jest to retencja
         np: @Retention(RetentionPolicy.SOURCE)
         typ wyliczniowy: RetentionPolicy
        Informacje o odnotacji moga byc:
          * usuwane przez kompilator w trakcie kompilacji - tylko w kodzie zrodlowym .SOURCE
          * umieszczone w skompilowanej klasie ale nie dostepne w uruchomionym progr .CLASS
          * dostepne w trakcie uruchomionego programu .RUNTIME
         Jesli potrzebuje wykorzystac ja tylko w trakcie kompilacji to wygeneruje
          to mniejszy bajtkod

         Jesli nie okresle retencji wlasnej adnotacji (nie dodam @Retention) to przyjmie
          ona wartosc domyslna @Retention(RetentionPolicy.CLASS) czyli sa zapisane w pliku
          class ale nie sa dostpene w trakcie uruchomienia porgramu


        //----
        //Zastosowanie adnotacji:

        -Dodatkowa informacja dla kompilatora
        np @override informuje kompilator ze metodaZwykla jest przeslonita
         w nadklasie lub interfejsu
        Moge to wykorzystac np dodajac przed jakas metodaZwykla i jesli
         nie jest ona przeslonieciem innej metody kompilator wyswietli
         blad
        np:
        @Override
        public boolean equal(Object obj){
            return true;}
        //bedzie blad poniwaz brakuje "s" i metodaZwykla nie przeslania metody
           w podklasie


        -Adnotacje przetwarzane w trakcie kompilacji */
        List listOfUndefinedObjects = new ArrayList();
        List<Integer> listOfIntegers = (List<Integer>) listOfUndefinedObjects;
        //pokazuje ostrzerzenie jak najade myszka poswietlony tekst na zolto
        /*
        kompilator moze nas ostrzec ze jesli dodamy do listy listOfUndefinedObjects
         typ inny niz Integer to chca zrzutowac do Integer wyrzuc blad (np String)
         ClassCastException
         "Warning:(10, 56) java: unchecked cast
         required: java.util.List<java.lang.Integer>
         found: java.util.List"

        Aby zapobiec takiemu ostrzeganiu dodaje przed rzutowaniem adnotacje
         @SuppressWarnings i moge ja przypisac do typu, atrybutu, metody,
         parametru metody, konstruktora czy zmiennej lokalnej np listy
        */
        List listOfUndefinedObjects2 = new ArrayList();
        @SuppressWarnings("unchecked")
        List<Integer> listOfIntegers2 = (List<Integer>) listOfUndefinedObjects;
        /*
        Kompilator nie bedzie nas ostrzegal przed zagrozeniami typu unchecked przy
         konkretnej zmiennej


        -Adnotacje w trakcie uruchomienia programu
        Sluzy do tego mechanizm refleksji, moge w trakcie dzialania
         programu pobierac informacje o skompilowanym kodzie czyli np klasie/jej metodach
         czy zmiennych
        np. @PostConstruct


        //-----
        //Definiowanie wlasnej adnotacji

        np:
        @Retention(RetentionPolicy.SOURCE) - adnotacja bedzie tylko w kodzie zrodlowym
        @Target(ElementType.FIELD) - moze byc uzyta wylacznie na atrutach klasy
        public @interface SampleFieldAnnotation {
            String id(); - to jest element "id" (przyjmie argument podczas uzcia adnotacji
        }                                        czyli jest "argumentem")
        gdybym chcial jej uzyc musialbym wyslac jakis String do niej
        @SampleFieldAnnotation("napis")



        Adnotacja moze przyjac tzw argument podczas wywolania np @SuppressWarnings("unchecked");
        to adnotacja SuppressWarnings przyjmie String

        PRZYKLADOWA DEKLARACJA:
        @Retention(RetentionPolicy.RUNTIME)
        @Target({ElementType.METHOD, ElementType.FIELD})
        public @interface MyAnnotation {
            String A();
            String B();
        }
        a w kodzie programu (przed metodaZwykla lub polem - okreslony element target):
        @MyAnnotation(A = "", B = "")//przypisuje wartosci zmiennym w adnotacji
        void simpleMethod() {
        }


        //----
        public @interface Retention {
            RetentionPolicy value(); //przyjmuje typ RetentionPolicy wiec musze taki wyslac
                                     // podczas uczycia
        }
        Deklaracja:
        @Retention(RetentionPolicy.SOURCE)
        @Retention(value=RetentionPolicy.SOURCE) - przypisuje wartosc lecz
          zadziala jak linijka wyzej poniewaz retencje mam juz okreslona

        Moge takze przyjac tablice do jakich elementow ma byc stosowana
        public @interface Target {
            ElementType[] value();
        }
        Deklaracja (4 rozne sposoby tego samego dzialania):
        @Target(ElementType.FIELD) - 1 element tablicy
        @Target(value=ElementType.FIELD) - -//-
        @Target({ElementType.FIELD}) - tutaj wymieniam po , bo jest tablica
        @Target(value={ElementType.FIELD}) - -//-


        //----
        Wartosci domyslne adnotacji:
        @Retention(RetentionPolicy.RUNTIME)
        //informacja o tej adnotacji jest dostępna w trakcie wykonania programu.
        @Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD})
        //Adnotację tę możemy stosować do atrybutów klasy, konstruktorów i metod.
        // wymieniam je po przecinku w {} - przyjmuje tablice typu enum ElementType

        public @interface AnnotationWithDefaultValues {
            String firstElement() default "someDefaultValue";
            int [] secondElement() default {1, 2, 3};
            float thirdElement();
        }
        //W takim przypadku podczas deklaracji adnaotacji w kodzie
        // nie musze przypisywac wartosci z atrybutem default ale moge
        */



        /*-------------------------------------------------------------------------
        ------------------------KLASY WEWNETRZNE I ANONIMOWE-----------------------

        Istnieje kilka typow klas wewnetrznych:
        -standardowe
        -statyczne
        -lokalne
        -anonimowe

        Klasa wewnetrzna NIELOKALNA moze miec kazdy modyfikator
        Klasa wewnetrzna ma dostep do wszytkich atrybutow i metod klasy zewnetrznej

        Wewnetrzene interfejsy i typy wyliczneniowe sa ZAWSZE STATYCZNE!
         i nie moga byc lokalne to jest w metodzie/bloku if

        Klasa lokalna jest zdefiniowana wewnatrza bloku (metodaZwykla, blok if itp)
         i nie moze zawierac zadnego modyfikatora (public/private/protected)

        Dostep do klas lokalnych jest tylko w bloku w ktorym zostaly zdefiniowane!
        */
        class KlasaGlowna {

            /*static*/ class KlasaWewnetrznaStatyczna {
            }

            class KlasaWewnetrzna {
            }
            //koniec klasy wewnetrznej!

            public KlasaWewnetrzna rozpocznij() {//metoda
                return new KlasaWewnetrzna();
                //nie musze pisac return this.new KlasaWeWnetrznaZwykla();
            }

            //Tworznie instancji klasy wewnetrznej
            public void main() {
                //metoda 1 gdy klasa jest niestatyczna (KlasaWewnetrzna)
                KlasaGlowna klasaGlowna = new KlasaGlowna();

                KlasaGlowna.KlasaWewnetrzna klasaWewnetrzna = klasaGlowna.new KlasaWewnetrzna();
                //1 tworze obiekt klasy ZEW
                //2 tworze obekt typu KLASA_ZEW.KLASA_WEW i wywoluje na obiekcie klasy
                // zewnetrznej konstruktor klasy wewnetrzej
                KlasaGlowna.KlasaWewnetrzna klasaWewnetrzna2 = klasaGlowna.rozpocznij();
                //lub za pomoca metody


                //INNA METODA: (gdy klasa wewnetrzna JEST STATYCZNA!)
                //np w innej klasie - bezposrednio
                //KlasaGlowna.KlasaWewnetrznaStatyczna obiekt = new KlasaGlowna.KlasaWewnetrznaStatyczna();


                //INNA METODA2:(gdy klasa wewnetrza jest STATYCZNA i TYLKO W KLASIE
                // W MAIN TEJ SAMEJ KLASY!! moge tworzyc bezposrenio obiekt klasy wew
                KlasaWewnetrznaStatyczna obWew2 = new KlasaWewnetrznaStatyczna();


                //----
                final int liczba = 10;
                int liczbaNieFinalna = 20;
                //liczbaNieFinalna = 40; BLAD!! jesli klasa wewnatrz metody (lokalna)
                // korzysta ze zmiennych moge TYLKO RAZ zadeklarawoac jej wartosc!

                class KlasaWeWLokalna {//jestem w main

                    void powiedzCos() {
                        System.out.println(liczba);
                        System.out.println(liczbaNieFinalna);
                    }
                }
            }
        }


        //----
        System.out.println();
        Map<String, Integer> dniWMiesiacu = new HashMap<>();
        dniWMiesiacu.put("styczen", 31);
        dniWMiesiacu.put("luty", 28);
        dniWMiesiacu.put("marzec", 31);

        for (Map.Entry<String, Integer> x : dniWMiesiacu.entrySet()) {
            //interface Entry<K, V> - deklaracja intefejsu klasy Map - Entry
            //Set<Map.Entry<K, V>> entrySet() - deklaracja entrySet()
            System.out.println(x.getKey() + " ma " + x.getValue() + " dni");
        }


        //----
        /* Klasy anonimowe:
        Jest to klasa definiowana w kodzie ktora posiada dokladnie 1 instancje
        Klasa anonimowa zawsze jest klasa wewnetrzna i polaczona jest z tworzeniem
         jej jednej instancji

        Na poczatku tworze interface z metoda (co przyjmuje, co zwraca i jak sie nazywa)
        Nastpenie tworze instancje tego interfacu i wpisuje dzialanie jego metody
         (typ przyjmowany i zwracany musi sie zgadzac!)
        Teoretycnie nie tworze jego instancji tylko instancje klasy Anonimowej
         typu tego Interfacu.
        Klasa anonimowa sklada sie z nazwy klasy w ktorej jest tworzona z dodaniem
         $ i numeru ktory jest numerem klasy anonimowej w kodzie liczonej od 1!
         np:Podsumowanie$1

         //deklracja na koncu:
        interface Powitanie{
           void powiedzCzesc();
        }
         */
        Powitanie powitanie = new Powitanie() {
            @Override
            public void powiedzCzesc() {
                System.out.println("Czesc, jestem z klasy anonimowej");
            }

            //Moge takze w tej klasie definiowac zmeinne i metody lecz glownie polega
            // to na tym ze wykorzysstuje ja tylko do zaimplementowania interfesju
            int zmienna = 123;

            int metoda() {
                return zmienna;
            }
        };//nie zapominam o sredniku
        System.out.println();
        powitanie.powiedzCzesc();//na obiekcie klasy wywoluje metode tego interfacu



        /*-------------------------------------------------------------------------
        ------------------------TEST DRUVEN DEVELOPMENT TDD------------------------

        Test jednostkowy jest sposoboem testowania programu ktory polega na wydzieleniu
         czesci funkcjonalnosci programu i testowaniu go w odosobnieniu.
        Test jednostkowy to metoda testujaca metode/jednostke w innej klasie z dodana
         adnotacja @Test

        TDD sklada sie z 3 faz:
        -Red : napisanie testow funckjinalnosci przed napsianiem kodu.
        Napisany test nie moze sie powiesc bo nie napisalem jeszcze funkcjonalnosci
        Testy jednostkowe podkreslone sa w IDE na czerwono jesli nie przechodza
        Kod moze sie nawet nie kompilowac jesli napislem test dla metody
         ktora jeszcze nie istanieje
        -Greeen : napisanie funkcjonalnosci "na szybko" ktora sprawi ze testy
        zostana zaliczone
        Musze napisac kod ktory zaliczy wszystkie testy
        -Refactor : Zmieniam kod aby byl "czysty" np dodanie metody ktora
        bedzie spelniac funkcjonalnosci aby nie powtrzac kodu czy stworzenie innej
        klasy.

        Przed napisaniem funkcjonalnosci nalezy najpierw napisac testy do niej

        Klasa testujaca inna klase nazwya sie tak samo jak ta klasa z dopisanym Test i
         powinna byc w innym folderze niz klasa np wszystkie klasy testowe moge byc w folderze
         Test

        Metody testujace powinny nazywac sie tak aby zrozumiec co testuja
        np
        @Test
        public void czyLiczba12JestWPrzedziale(){
            One o = new One(10,15);
            assertTrue(o.czyJestWPrzedziale(12));
        }

        Założeniem TDD jest pisanie testow do jak najkrotszej ilosci kodu

        Dobra praktyka jest jednego dnia napisania testow zeby kolejnego
         rozpoczac pisanie samej funkcjonalnosci


        ----
        Testy jednostkowe z JUnit

        CTR+F5 uruchomi ostatni test/testy

        Asercje to metody JUnit ktore przyjmuja rozne wartosci i koncza test
         wynikiem pozytywnym lub negatywnym


        Sa to metody statyczne z klasy Assert. Moge miec do nich dostep poprzez
         import statyczny tej klasy
         import static org.junit.Assert.*; i pisze po prostu assertTrue(costam());
         lub pisania ich po nazwie klasy np. Assert.assertTrue(costam());

        Najczestsze metody:
        assertTrue()
        assertFalse()
        assertNull()
        assertNotNull()
        assertEquals()
        assertNotEquals()
        assertSame() - sprawdza adresy obiektow
        assertNotSame()


        ----
        PRZYKŁADOWE TESTY:

        -Tworze obiekt i sprawdzam czy metodaZwykla klasy zwroci true
        @Test
        public void czyLiczba12JestWPrzedziale(){
            One o = new One(10,15);
            assertTrue(o.czyJestWPrzedziale(12));
        }

        -Sprawdzam czy metodaZwykla zwroci wyjatek IllegalArgumentException
        @Test(expected = IllegalArgumentException.class) //test przejdzie
        // jesli zostanie wyrzucony podany wyjatek
        public void czyWyrzicWyjatekZlychParametrow(){
            new One(20,10); //wyjatek jest w konstruktorze klasy One
        }

        Sposob 2:
        @Test
        public void czyWyrzicWyjatekZlychParametrow2(){
            try{
                new One(20,10); //tutaj powinno wyrzucic wyjatek i w catch
                //go porownam z oczekiwanym

                //jesli jednak to sie nie stanie wywoluje metode fail
                fail("Wyjatek nie zostal rzucony"); //czyli test nie przeszedl
                //wywola wyrzucenie wyjatku AssertionError z napisem
                //test nie przejdzie
            }
            catch (IllegalArgumentException ex){
                assertEquals("dolny przedzial jest wiekszy niz gorny!",ex.getMessage());
                //jesli metodaZwykla wyrzuci DOKŁADNIE TAKI wyjatek to test przejdzie
                //jesli nie to test nie przejdzie
            }
        }


        ----
        Przed testami moge dodac zmienna Obiektu klasy np
        One one;
        i stworzyc jej obiekt na potzeby testow dodajac metode z adnotacja
        @Before ktora jest wywolywana przed kazdym testem

        @Before
        public start(){
            one = new One(10,20);
        }
        i korzystac w kazdym tescie zmiennej one z podanymi parametrami


        ----
        Istnieja takze metody:
        @After - uruchamina po kazdym tescie
        @BeforeClass - uruchamiana przed wszystkimi testame
        @AfterClass - uruchamiana po wszytkich testach
        */



        /*-------------------------------------------------------------------------
        ----------------------------WYRAŻENIA REGULARNE----------------------------

        Wyrażenie regularne (ang. regular expression) to „wzorzec”, który opisuje grupę
         łańcuchów znaków i jest nastepnie kompilowany przez
         silnik wyrażeń regularnych do wewnętrznej postaci.

        W praktyce jednym z głównych zastosowań jest weryfikacja czy dany łańcuch znaków
         pasuje do wzorca. Wzorcem tym jest wyrażenie regularne.

        W Javie wyrazenia rgularne wykorzystuje klasy Pattern i Matcher
        */

        //DEKLARACJA
        //Na poczatku deklaruje wzorzec
        Pattern wzorzec = Pattern.compile("costam");
        //Nastepnie z pomoca obiektu wzorca deklaruje wybrane dopaseowanie
        // czyli to co chce sprawdzic (np moge wprowadzic wlasny text)
        Matcher dopasowanie = wzorzec.matcher("pisze costam");
        //Aby sprawdzic dopasowanie dokladne uzywam metody matches() ktora
        // zwraca true albo false. Wywoluje ja na obiekcie Matcher:
        dopasowanie.matches(); //zwroci false poniewaz moj tekst nie pasuje
        // w poelni do wzorca "pisze costam" =/= "costam"
        // Aby spawdzic czy jakakolwiek czesc ciegu dopsowania pasuje do wzorca
        // uzywam metody find()
        dopasowanie.find();//teraz da true poniewaz czesc teksu pasuje do wzorca
        //"pisze costam" =/= "costam" ale "costam" = "costam"

        /*

        Znaki biale:
        \n - nowa linia
        \r - usuniecie wszystkiego do poczatku linii
        \t - tabulacja
        \f - strzalka w gore (napisana doslowanie jako obrazek)
        \x0B - wertykalny tabulator


        POMOC W IDE
        moge na deklaracji wzorca uzyc <alt + enter> i dac Check RegExp aby na szybko
         sprawdzic czy podany wpisany w okno wzorzec pasuje


        Gdy chce aby w ciagu znakow 2 + 3 = 5 nie bylo brane "+" jako
         dodoawanie musze dodac \przed+ : 2 \+ 3 = 5
         jednak w javie wyrazenia regularne sa jako Strng wiec
         pojedynczy \ jest interpretowany specjalnie jak np \t - tabulator
         czy \n nowa linia dlatego nalezy dodac podwojny \\
         2 \\+3 = 5


        W przypadku gdy chce pominac dzialanie "\" w liczbie z tym
         znakiem np 123\4 musze dodac pojedynczy \ przed \ czyli
         123\\4 a nastepnie przed kazdym \ dodac ponownie kolejny
         czyli 123\\\\4


        ----
        POWTORZENIA:
        znak ? - element przed ? (standardowo 1 litera ciagu) moze wystapic
                 0 lub 1 raz, pozostala czesc przed i po nim musi byc niezmieniona
                 np. kr?at
        -(0 - 1) wystapien
        Poprawnie : krat, kat
        Blednie : rkat, at, wkrat, rat
         */
        Pattern wzorKrat = Pattern.compile("kr?at");
        Matcher dopasowanie2 = wzorKrat.matcher("krat");
        System.out.println(dopasowanie2.matches());//true


        /*
        znak * - to co jest przed nim moze zostac pomienita lub wystapic dowlona
                 ilosc razy
                 np uwa*ga
        -(0 - nieskonczonosci) wystapien
        Poprawnie : uwga, uwaga, uwaaaaga
        Blednie : auwaga, waga


        znak + - dziala jak * tylko ze wystapienie musi byc CO NAJMNIEJ jedno
                 np de+bil
        -(1 - nieskonczonosci) wystapien
        Poprawnie : debil, deeeebil
        Blednie : dbil, edebil

        ----
        znak . - na miejscu . MUSI wystapic dowolny JEDEN ZNAK poza znakiem konca lini
                  Przykad ko.ek :
        Poprawnie : kotek, koDek
        Blednie : koek, ktek
                  Jest tez mozliwosc wstawinia po nim powtorzenia np * czyli .* to moze
                  wystapic dowolny ciag lub jego brak w miejscu kropki! lub + czyli .+
                  wiec MUSI byc dowolny znak lub ciag!
                  Przyklad ko.*ek
        Poprawnie : koek, kotek, koDDDDek
        Blednie : ktek
                  Przyklad ko.+ek
        Poprawnie : kotek, kottttttek, koDDDDDek
        Blednie : koek, ktek


        ----
        Dokladniejsze powtorzenia:
        -{x} - oznacza że element poprzedzający musi wystąpić dokładnie x razy,
        np. kr{3}at -> krrrat.
        -{x,y} - oznacza, że element poprzedzający musi wystąpić od x do y razy,
        np. kr{2,3}at -> krrrat, krrat.
        -{x,} - oznacza, że element poprzedzający musi wystąpić co najmniej x razy,
        np. kr{1,} -> krat, krrrrat, krrrrrrrat...
        -{,y} - oznacza, że element poprzedzający musi wystąpić co najwyżej y razy.
        np. kr{,2}at -> ????????????

        Moge zastapic proste na te z {}:
        a*la -> a{0,}la
        a+la -> a{1,}la
        a?la -> a{0,1}la


        ----
        Kompbinacja k+a.*ta:
        k+ (k musi wystapic conajmniej 1 raz, przed nim nic)
        .* (moge wstawic dowolny ciag lub nic, UWAGA! łaczone z *! bez * bylby to 1 znak!
        Poprawne : kata, kkax&dta, kaRta, kaSIA MA KOta, kkkka#$*&JHDFTATAta
        Bledne : ata (brak k na poczatku), kta (brak a po pierwszym k)

        Kombinacja .+@.+\.pl (wyrazenie regularne maila)
        .+ - dowolny symbol lub ciag użyty co najmniej raz,
        @ - małpa,
        .+ - ponownie dowolny symbol lub ciag użyty co najmniej raz,
        \. - kropka rozumiana dosłownie
        pl - pl doslownie


        ----
        Klasy w wyrazeniach regularnych
        Oznaczaja grupy symboli w [] - moge umiescic w nim pojedynczo symbole lub zakres/y
         z - np[rtmp] lub [a-c] lub [a-dA-D] i moge wykorzystac tylko JEDEN Z SYMBOLI!
         UWAGA! jesli uzyje powtorzenia +/* to bede mogl uzic ciagu z tych symboli!!
        Aby - byl iterpretowany doslownie musze go umieciec na koncu klasy np [abc-]xyz

         np [rtmp]aca
        Poprawnie : raca, taca, maca
        Błednie : praca -> 2 litery wkorzystane, pacanow -> czesc po sie nie zgadza

        Mozna wykorzystac takze zakres alfabetyczny lub liczbowy,
          np [a-d]uma
        Poprawnie : auma, buma, cuma
        Blednie : fuma, abuma->2 litery

         np [0-7]xyz
        Poprawnie : 0xyz, 1xyz
        Blednie : 8xyz, 07xyz->2 cyfry

         np [a-z]+ -> musi byc dowolna MAŁA litera conajmniej raz ALE moge uzyc
                      dowolna ilosc razy kazdej z nich!
        Poprawnie : abcdeeee, a
        Blednie : abCCd2, 3d, ,


         np [a-cA-C0-3]bum
        Poprawnie : abum, Bbum, 0bum
        Blednie : dbum, aA0bum -> 2 z przedzialow


        ----
        Negacje: (dopasowanie wszystko oprocz przedzialu klasy, przedzial ze znakiem ^
         na poczatku) Aby ^ byl itrerpretowany doslownie musze umiescic go w innym
          miejscu niz na poczatku np [x^yz]awa
            np [^xyz]awa
        Poprawnie : kawa, pawa, Wawa
        Blednie : zawa, yawa, yzawa

        Lub z wykorzystniem powtorzenia +/*
            np [xyz]+awa
        Poprawnie : xxxyyyyzzzzzyyyawa, xawa
        Blednie : awa, kawa


        ----
        Klasy predefiniowane (w skrocie) np \d (w string musze dac podwojne \d-> \\d)
        \d - jakakolwiek cyfra [0-9] np \\d
        Poprawnie : 1,2,6
        Blednie : d,_,.,D
        \D - jakikolwiek znak, który nie jest cyfrą [^0-9] np \\D
        Poprawnie : _,d,D
        Blednie : 2,4
        \w znak używany w słowach [a-zA-Z0-9_] (_ na koncu jest brany doslownie)
        Poprawnie : d,S,3,_
        Blednie : .,?,-
        \W znak NIE używany w słowach [^a-zA-Z0-9_]
        Poprawnie : .,?,-
        Blednie : d,D,3,_
        \s znaki biale np tabulacja [ \t\n\r\f\x0B]
        \S neegacja \s [^ \t\n\r\f\x0B]


        Przykład daty :  \\d{4}-\\d{2}-\\d{2}
        \d{4} - cztery cyfry oznaczające rok,
        - - minus oddzielający rok od miesiąca,
        \d{2} - dwie cyfry oznaczające miesiąc,
        - - minus oddzielający miesiąc od dnia,
        \d{2} - dwie cyfry oznaczające dzień.


        ----
        Grupy
        Sluza do wyluskania z lancucha znakow wybranej czesci

        Grupy rozpoczynaja sie w () np. (\w+) - dowolny znak/liczba conajmniej raz,
         ciag ktory bedzie pasowal zostanie umieszczony w grupie numer 1

        Numerowane sa od 1

        Jezeli dany lancuch pasuje do wyrazenia regularnego to
         znajduje sie w grupie z numerem 1

        Po przypisaniu wzorca i dopasowania musze wywolac metode
         na zmiennej dopasowania .matches(); aby moc sprawdzic
         co znajduje sie w danej grupie!

        Jesli jednak calosc chce sprawdzic moge wywolac metode .matches()
         i w wyswietleniu uzyje .group() - bez numeru grupy!!

        Jesli nie bedzie nic w grupie a bede chcial sie do niej dostac wyrzuci
         wyjatek IllegalStateException

        Metody:
        .groupCount() - zwraca liczbe grup w wyrazeniu regularnym
         (pomija ta z indeksem 0)
        .group(numerGrupy) - zwraca grupe z wybranym numerm (ciag znakow jaki
          sie w niej znajduje)


        */
        Pattern kotPattern = Pattern.compile("[^-]+--(\\w+)--.*");
        //[^-]* dowolne znaki za wyjatkiem - (musi to byc aby moc oddzielic pierwsze wystapienie -)
        // nie zadziala gdy bede mial tylko jeden - przed -- poniewaz po pierwszym - bedzie szukalo
        // kolejnego -
        //(\\w+) grupa w ktorej bedzie szukalo conajmniej 1 znaku
        //-- doslownie
        //.* dowolne znaki badz ich brak do konca
        Matcher kotMatcher = kotPattern.matcher("mam kota o imieniu --Lucky--. jest super");
        kotMatcher.matches();//konieczne aby umiescilo w grupy
        System.out.println();
        System.out.println("Imie kota : " + kotMatcher.group(1));

        /*
        przyklad \w+ \((\w+)\) \w+ (WSZEDZIE WE WZORCU MUSZE DAC 2x\ !!)
         \w+ : cyfry, litery lub podkreslnikj uzyte conajmniej raz (NIE ODSTEP!!)
               poniewaz jesli dam odstep to bedzie juz szukalo \( bo odstep jest
               kolejnym znakiem w moim wzorcu + odstep nie pasuje do \w!!
          : JEDEN odstep
         \( : ( uzyty doslownie
         (\w+\\) : gdupa w ktorej cyfry, litery lub podkreslnikj sa uzyte conajmniej raz
         oraz \\ ktory oznacz doslowne wystapienie \
         \) : doslwnie )
          : odstep
         \w+ : cyfry, litery lub podkreslnikj uzyte conajmniej raz (NIE ODSTEP!!)
         Poprawnie : Kamil (kicu) Zajac
          w grupie z numerem 0 jest "kicu"


         przyklad -?[1-9]+\d*(,\d+)? - liczba zmiennoprzecinkowa
         -? : - moze byc jeden raz lub w ogole
         [1-9]+ : liczba/y z przedzialu 1-9 musza byc na poczatku zeby nie bylo 0!
         \d* : dodaje aby byla mozliwosc wstawinia po pierwszej liczbie zera

         przyklad [1-9]+\d*[a-zA-Z]?\\[1-9]+\d*[a-zA-Z]? - numer domu w formacie 12a\3a
          moze byc 12\2, 2a\3, 2\3a ale blednie a\2, 2\d

         przyklad [A-Z][a-z]+([ -][A-Z][a-z]+)? - nazwa miasta
          Na przykład Wrocław, Zielona Gora czy Bielsko-Biala jest ok,
          jednak Ptysiow123 już nie.


        ----
        Zachłanność wyrażeń regularnych (dla .find())

        .+/?/* - wylapie najwiecej jak to mozliwe
        .+? - wylapie najmniej jak to mozliwe
        (.+)</p - wez wszystko do ostanitego wystapienia </p
        (.+?)</p - wez wszystko do 1 wystapienia </p

        Np chce umiescic w grupie to co jest pomiedzy <> i uzywam
         find zeby zlapalo cokolwiek */
        Pattern wzorzecZachlanny = Pattern.compile("<(.+)>");
        Matcher dopasowanieWZ = wzorzecZachlanny.matcher("<em>jakis podkreslony tekst</em>gdfgdfg");
        dopasowanieWZ.find(); //UZYWAM FIND!
        System.out.println("znacznik podkreslenia 1 : " + dopasowanieWZ.group(1));
        //znacznik podkreslenia 1 : em>jakis podkreslony tekst</em - BLAD

        Pattern wzorzecZachlanny2 = Pattern.compile("<([^>]+)>"); //poprawne
        Matcher dopasowanieWZ2 = wzorzecZachlanny2.matcher("<em>jakis podkreslony tekst</em>");
        dopasowanieWZ2.find();
        System.out.println("znacznik podkreslenia 2 : " + dopasowanieWZ2.group(1));
        //znacznik podkreslenia 2 : em

        /*
        Symbole powtórzeń {}, ?, * czy + dopasowują zawsze najwięcej jak tylko się da
        Istenieje przelacznik ktory zmienia zachowanie powtorzenia i jest to znak ? czyli
         wylapuje najmniej jak to mozliwe

        <(.+?)> - poprawne


        {} tez jest zachlanny i w find {3,5} znajdzie wszystko od 3 do 5 znakow a z ? tylko
            3 pierwsze znaki
        */
        Pattern wzorzecNieZachlanny = Pattern.compile("(.{3,5})");
        Matcher dopazsowanieWNZ = wzorzecNieZachlanny.matcher("123123");
        dopazsowanieWNZ.find(); //123
        System.out.println("Dopasownie niezachlanne {} : " + dopazsowanieWNZ.group(1));


        /*----
        -Alternatywa
        W grupie moge wpisac | to wybierze jedno z ciagu
            np "skrec w (lewo|prawo)" lub jedno z kilku pies|lew|kot


        ----
        -Pomijanie grup
        Moge pominac jedna z grup uzywajac na poczatku niej ?:
            np: (?:Tomek|Kamil) ma (kota|psa) - w grupie 1 bedzie kota/psa


        ----
        -Nazwyanie grup
        Umieszcz na poczatku grupy ?<nazwaGruoy>
            np (?<dzien>\d{2})
        Moge potem wyswietlic numerem lub nazwa .group("dzien")


        ----
        Ponowne uzycie grup
        Aby uzyc zawartosci innej gdupy we wzorcu moge dac \\nrGrupy

        "<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>"
        chce do pierwszej grupy dac znacznik p
        do 2 to co jest pomiedzy PIERWSZYM <p></p>


        "<(.+?)>(.+?)</p"

        < : doslownie
        (.+?)> : wezmie do pierwszej gdupy to co jest przed PIERWSZYM >
                 czyli samo "p"
        (.+?)</p : wezmie wszystko do 1 WYSTAPIENIA </p gdybym dal bez ?
                    tj. (.+)</p to wzieloby do OSTNIEGO WYSTAPIENIA </p!

        Moge takze wykorzystac zawartosc 1 grupy czyli "p"
         "<(.+?)>(.+?)</\\1"
         < : doslownie
         (.+?)> : wezmie do pierwszej gdupy to co jest przed PIERWSZYM >
                  czyli samo "p"
         (.+?)</\\1> : wezmie wszystko do 1 WYSTAPIENIA </ + zawartosc 1 grupy
                       oznaczona \\1 czyli p co -> </p jak w przykladzie wyzej


        ----
        Kotwice
         ^ oznacza poczatek lancucha znakow
            np c^
            true : csd, csdg (DLA FIND!!)
            false : dsdfc
        $ oznacza koniec łańcucha znaków.
            np d$
            true : qwd, qasd
            false : asfdf
         */
        Pattern wzorzecLiczb = Pattern.compile("\\d+");//musza byc same liczby
        //moge dac "\\d+?" to find znajdzie 1 liczbe
        Matcher dopasowanieLiczb = wzorzecLiczb.matcher("abc123def");
        System.out.println("find : " + dopasowanieLiczb.find()); // true
        System.out.println("pierwsza liczba : " + dopasowanieLiczb.group());
        //DO GRUPY BEDE MOGL SIE DOSTAC JESLI OSTATNIA METODA NA DOPASOWANIU
        // BEDZIE TRUE (find lub matches) INACZEJ BEDZIE BLAD !
        System.out.println("matches : " + dopasowanieLiczb.matches()); // false

        Pattern wzorzecKotwicy = Pattern.compile("\\d+$");//liczby na koncu
        Matcher dopasowanieWK = wzorzecKotwicy.matcher("abc123");
        //matches bedzie flase
        dopasowanieWK.find();
        //jesli na koncu dam litere tj abc123x to find takze bedze false
        System.out.println("liczby z konca : " + dopasowanieWK.group());



        /*-------------------------------------------------------------------------
        ----------------------------Java z linii polecen---------------------------

        Instalujac JRE mam komende java ktoa uruchamia maszyne wirtualna wywolujac
         metode main w odpowieniej klasie a instalujac JDK mam dostep do javac ktora
         jest kompilatorem ktory tworzy plik class z pliku java a jar jest to
         narzedzie ktore tworzy pliki jar

        Instrukcja dodawania zmiennej srodowiskowej JDK w windows 10
         PS -> System -> Zaawansowane ustaiwnia systemu -> Zmienne środowiskowe
         W dziale Zmienne systemowe dodaje nowa zmienna lub edytuje o nazwie Path
         Nastepnie dodaje wybieram Nowy i wklejam lokalizjacje folderu bin JDK np"
         C:\Program Files\Java\jdk-10.0.2\bin

        -Kompilacja:
          Ide do lokalizacji pliku .java i wpisuje komende javac plik.java
          UWAGA! plik.java musi nazywac sie tak jak nazwa klasy z metodaZwykla main !
          Ta komenda tworzy w tym folderze plik plik.class :

        -Uruchomienie:
          Wpisuje komende java i nazwe pliku .class BEZ ROZSZERZENIA! np:
          java plik

        Jesli chce skompilowac klase w jakims podfolderze wpisauje
         javac pl\samouczekprogramisty\commandline\DisplayName.java
        Jesli chce uruchomic skompilowana klase, wpisuje java z classpath
         czyli zamiast \ wpisuje . oraz w pliku klasu musi byc lokalizacja
         package miejsca w ktorym bede uruchamial kompilacje!! np:
         package pl.naukajavy.liniapolecen;
        Uruchomienie bedzie wiec wygladalo:
         java pl.samouczekprogramisty.commandline.DisplayName


        ----
        Aby skompilowac i uruchomic klase z zewnetrzna biblioteka uzywam polecenia
         -cp

        Przyklad:
         kompilacja:
         javac -cp commons-lang3-3.5.jar pl.naukajavy\liniapolecen\WyswietlImie.java
         uruchomienie:
         java -cp .;commons-lang3-3.5.jar pl.naukajavy.liniapolecen.WyswietlImie

        Jesli uzywam zewnetrznej biblioteki to musze sciagnac jej plik jar i
         umiescic go w folderze glownym (tam gdzie uruchamiam kompilacjie)
         oraz dodac import w kodzie


        ----
        PLIKI JAR
        jest to archiwum ze skompilowanymi klasami. klasy wewnatrz archiwum
         znajduja sie w odpowiednich katalogach

        Program jar moze tworzyc jak i wyswietlac zawartosc archiwum
         Wyswietlenie :
         jar tf plikJar.jar
         Utworzenie :
         jar cf <nazwa pliku wyjściowego> <lista katalogów, klas do umieszczenia w pliku JAR>
         np: jar cf PierwszyPlikJar.jar . (kropka oznacza zeby spakowalo wszystko)

        Uruchamianie pliku jar:
         java -jar aplka.jar

        moge takze dodac domyslna klase do uruchomienia pliku jar komenda:
         jar -cfe plik.jar jakasNazwa Klasa.class



        /*-------------------------------------------------------------------------
        --------------------------Aplikacje webowe - INFO--------------------------

        Aplikacje webowe DLA KIENTA nie potrzebuja plikow do dzialania co daje
          im przewage nad aplikacjami desktopowymi. Sa instalowane na serwerze
          i dostep do nich jest za posrednictwem internetu przez przegladarke int.
          z poziomu komoutera/telefonu/tabletu.
         Zaleta jest takze poprawianie bledu, w przypadku aplikacji desktopowych
          uzytkownik musi instalowac aktualizacje a aplikacje webowe sa aktualizowane
          na serwerze co zwalnia uzytkownika z jakichkolwiek dzialan i sa one
          niewidoczne

         Serwerm jest maszana badz aplikacja na komputerze np Apache HTTP Server
          czy nginx, sa to serwery HTTP. Jesli klient wpisze adres w przegladarce
          wysle zapytanie do serwera (aplikacja na serwerze) odpowie odczytujac swoje
          pliki z dysku serwera - serwowanie plikow statycznych.
         Aplikacje webowe pokazuja zawartosc ktora jest zmienna czyli np z komentarzami
          ktore dodaj klient

         Aplikacja webowa iterpretuje zapytanie wyslane przez przegladarke klienta i
          odpowiada dynamicznie plikiem ktory jest zrozumialy dla przegladarki klienta


         Serwlet to klasa ktora obsluguje zapytanie wyslane do serwera i moze na nie
          odpowiedziec dpowienikiem jar - skompilowanych klas webowych jest plik WAR
          (web archive) miedzy innymi sa to serwlety. Moga znajdowac sie w nim takze
          pliki JAR zawierajace niezbedne zaleznosci potrzebne do dzialania aplikacji
          webowej!

         Plik war instaluje sie na konterze serwletow (deploy) ktory posredniczy
          w obludze zapytan.

         1. wysłanie żądania z przeglądarki do serwera (maszyny)
         2. przekazanie żądania do kontenera serwletów/serwera aplikacji
         3. przetworzenie żądania przez serwlet/aplikację webową
         4. przekazanie odpowiedzi z kontenera serwletów do serwera
         5. wysłanie odpowiedzi do klienta (przeglądarki internetowej)

         Jednymi z najpopularniejszych serwerow aplikacji i kontenerow serwletow sa:
          Tomcat, Jetty, Glassfish, WildFly, Weblogic



        /*-------------------------------------------------------------------------
        --------------------------WYRAZENIA LAMBDA---------------------------------

        ogolna składnia:
        <lista parametrów> -> <ciało wyrażenia>

        (x) -> x * x
        wyrazenie lambda podnoszace liczbe do dwadratu
        x -> x * x
        Nawiasy takze sa opcjonalne jesli przyjmowany parametr jest tylko 1

        () -> "napis"
        wyrazenie nie przyjmuje parametrow ale zwraca instancje klasy String

        Nie musze podawac typow paramatrow ale jest to mozliwe
        (Integer x, Long y) -> System.out.println(x * y)
        (x, y) -> System.out.println(x * y)
        metdoa przyjmuje Integer i Long i nie zwraca nic!

        Zazwyczaj wyrazenie lambda to 1 linia kodu lecz jesli jest wiecej to
         uzywam nawiasow {}


        Zamiana klasy anonimowej na lambde:

        interface CzyParzysta<T>{
            boolean sprawdz(T obiekt);
        }//deklaracja na koncu  */


        CzyParzysta<Integer> czyParzystaAnonim = new CzyParzysta<Integer>() {
            @Override
            public boolean sprawdz(Integer obiekt) {
                return obiekt % 2 == 0;
            }
        };
        System.out.println();
        System.out.println("Czy liczba 15 jest parzysta : " + czyParzystaAnonim.sprawdz(15));
        System.out.println("Czy liczba 20 jest parzysta : " + czyParzystaAnonim.sprawdz(20));

        //to samo w labda:
        CzyParzysta<Integer> czyParzystaLambda = obiekt -> obiekt % 2 == 0;
        System.out.println("Czy liczba 15 jest parzysta: " + czyParzystaAnonim.sprawdz(15));
        System.out.println("Czy liczba 20 jest parzysta: " + czyParzystaAnonim.sprawdz(20));



        /*-------------------------------------------------------------------------
        --------------------------Interface funkcyjny---------------------------------

        To taki interface ktory posiada jedna metode abstrakcyjna i adnotacje @FunctionalInterface

        Przykladem moze byc interface spradzajacy czy liczba jest parzysta:

        @FunctionalInterface
        interface CzyParzysta<T>{
            boolean sprawdz(T obiekt);
        }


        ----
        Java posiada zestaw gotowych interfejsow funkcjonalnych
         w pakiecie java.util.function, najwazniejsze z nich to:

         */


        //-BiFunction<T, U, R> - R apply(T t, U u)
        //moge odwolac sie konstruktora klasy z 2 zmiennymi ::new
        // + przypisanie wartosci tej klasy w wywolaniu na obiekcie bifunction metody apply i
        // wyslaniu do niej wartosci jako parametry - to przypisuje do nowego obiektu tej klasy
        BiFunction<String, Integer, KlasaMoja> obiektInterfejsu = KlasaMoja::new;
        KlasaMoja obKlasaMoja = obiektInterfejsu.apply("wartosc", 123);

        //-Function<T, R> - R apply (T t)
        //na strumieniu: (map) x -> x.name//x -> x.name.toUpperCase()
        Function<String, Integer> zmianaSILambda = zmiennaString -> Integer.parseInt(zmiennaString);
        int L1 = zmianaSILambda.apply("12");

        //-ToIntFunction<T> | int applyAsInt(T t)
        ToIntFunction<Integer> toIntFunction = x -> x + 12;
        int y = toIntFunction.applyAsInt(22);

        //-ToDoubleFunction<T> | double applyAsDouble(T t)
        ToDoubleFunction<Double> toDoubleFunction = x -> x + 12.3;
        double y2 = toDoubleFunction.applyAsDouble(34.5);

        //-UnaryOperator<T> | T apply (T t)
        UnaryOperator<Integer> pomnozPrzezDwaLambda = liczbaDoMnozenia -> liczbaDoMnozenia * 2;
        System.out.println("14*2  w lambdzie: " + pomnozPrzezDwaLambda.apply(14));

        //-Supplier<T> | T get()
        //moge odwolac sie konstruktora klasy ::new
        Supplier<Integer> pokazInteger10Lambda = () -> 10;
        System.out.println("pokaz 10 Integer z lambdy : " + pokazInteger10Lambda.get());

        //-IntSuplier | int getAsInt()
        IntSupplier pokaz10lambda = () -> 10;
        System.out.println("pokazuje 10 int z lambdy : " + pokaz10lambda.getAsInt());

        //-BiPredicate<T, R> | boolean test (T t, R r)
        BiPredicate<Integer, Integer> czyRowne = (g, h) -> g == h;
        System.out.println(czyRowne.test(20, 30));

        //-Predicate<T> | boolean test(T t)
        //na strumieniu : (filter) x -> x.rating > 8
        //x -> new BigDecimal(150).compareTo(x.price) > 0
        Predicate<Integer> czyParzystaLambda2 = liczbaDoSprawdzenia -> liczbaDoSprawdzenia % 2 == 0;
        System.out.println("Czy liczba 15 jest parzysta : " + czyParzystaLambda2.test(15));

        //-Consumer<T> | void accept(T t)
        //na strumieniu (forEach) System.out::println
        //*po mapowaniu na jeden element z listy np name
        Consumer<Integer> pokazILambda = jakasLiczba -> System.out.println("jakasLiczba");
        pokazILambda.accept(123);
        //przyklad z foreach
        Consumer<Integer> listaLiczbConsumer = x -> System.out.print(x + " ");
        List<Integer> listaLiczb = Arrays.asList(4, 2, 5, 7, 0);
        listaLiczb.forEach(listaLiczbConsumer);
        System.out.println();
        listaLiczbConsumer.accept(listaLiczb.get(0));


        //----
        //Przyklady zastosowan:
        //Wypisanie liczb z kolekcji
        List<Integer> listaLiczb2 = Arrays.asList(2, 4, 6, 8, 7);
        Consumer<Integer> listaLiczbConsumer2 = x -> System.out.print(x + " ");
        //-Consumer<T> | void accept(T t)
        listaLiczb.forEach(listaLiczbConsumer);
        //petla forEach dziala tyle obrotow ile lista posiada elementow
        //wysyla przy kazdym obrocie swoj elelement czyli w tym przypadku
        // element typu integer
        System.out.println();
        listaLiczbConsumer.accept(listaLiczb.get(0));

        //lub w skrocie z mechanizmem odwolania sie do metod
        System.out.println();
        listaLiczb.forEach(System.out::print);
        //wysylam kaxdy element do Klasy System.out z odwolasniem sie do jego
        // metody print


        //----
        //Odwolywanie sie do metod :: na obiektach
        Object obiekt = new Object();
        //Tworze obiekt klasy np Object w ktorej jest metodaZwykla hashcode() zwracajaca int
        IntSupplier zmiennaIntInterace = obiekt::hashCode;
        //-IntSuplier | int getAsInt()
        //Tworze zmienna klasy anonimowej ktora w swojej metodzie nie przyjmuje nic ale
        // zwraca int.
        //Wykorzystuje to z obiektem klasy Object ktory ma w swojej klasie
        // metode hashcode zwracajaca int laczac to z metodaZwykla interacu tez zwracajac int
        //Od tej pory metoda obiektu klasy anonimowej getAsInt bezie zwracac
        // hashCode() obiektu obiekt

        //lub w lambdzie:
        IntSupplier zmiennaIntInterfaceLambda = () -> obiekt.hashCode();

        System.out.println("test hashcode :: : " + zmiennaIntInterace.getAsInt());
        System.out.println(obiekt.hashCode());//to samo
        System.out.println(zmiennaIntInterfaceLambda.getAsInt());

        //Jesli odwoluje sie poprzez obiekt (jak wyzej) moge to zrobic tylko na interfejsie funkcyjnym
        // ktorego metoda zgadza sie z metoda jaka wywoluje po :: oraz interface funkcyjny NIE MOZE
        // przyjmowac typu generycznego!! jak np IntSuplier | int getAsInt()

        //Chyba ze metoda jest statyczna to moge na takim interfejsie funkcjyjnym (bez typu
        // generycznego) odwolac sie do metody poprzez Klasa a nie obiekt tj:
        IntSupplier zmiennaIntInteraceX = KlasaZMetodaReturnInt::staticDajInt;

        //Gdy interface przyjmuje typ generyczny (klasy z jakiej bede wywolywal metode)
        // to moge sie odwolac do metody NIESTATYCZNEJ na podstawie NAZWY KLASY!
        ToIntFunction<Object> bezInstancji = Object::hashCode;


        //inny przyklad
        Wiek obiektWiek = new Wiek(10);
        IntSupplier wiekSupplier = obiektWiek::getWiek;
        System.out.println("podany obiekt wiek ma wiek : " + wiekSupplier.getAsInt());
        //zwroci 10


        //Odwolywanie sie do metod :: bez podania instancji klasy a po prostu Klasy
        ToIntFunction<Object> bezInstancji2 = Object::hashCode;
        /* -ToIntFunction<T> | int applyAsInt(T t)
        Od tej pory wywyolujac metode applyAsInt na obiekcie "bezInstancji" klasy anonimowej
         ToIntFunction bede mogl wyslac dowolny obiekt klasy typu generycznego
         czyli w tym przypadku Object bezInstancji.applyAsInt(instncjaObiektu)
        Jesli odwoluje sie poprzez Klase moge to zrobic tylko na interfejscie funkcyjnym
         ktorego typ zwracany metody zgadza sie z typem zwracanym metody jaka wywoluje po ::
         oraz interface funkcyjny musi przyjmowac typ generyczny
         */
        Object instncjaObiektu = new Object();
        //Tworze instancje tej klasy
        System.out.println("Odwolanie do metody ze podania instancji : " +
                bezInstancji.applyAsInt(instncjaObiektu));

        //inny przykład
        ToIntFunction<Wiek> wiekToIntFunction = Wiek::getWiek;
        Wiek obiektWiek2 = new Wiek(20);
        System.out.println("Wiek toIntFunction : " + wiekToIntFunction.applyAsInt(obiektWiek2));


        //----
        //Odwolanie sie do konstruktora
        Supplier<Object> objectSupplier = Object::new;
        //-Supplier<T> | T get()
        //Metoda tego interfacu zwraca generyk taki jaki przyjmuje
        System.out.println(objectSupplier.get());
        //pokazuje refernecje nowego obiektu czyli:
        System.out.println(new Object());



        /*-------------------------------------------------------------------------
        ----------------------------------STRUMIENIE-------------------------------

        Strumienie sluza do przetwarzania danych np z kolekcji czy wyrazen regulrnych

        Nie sa struktrami danych! Struktury służą do przechowywania danych a strumienie
         służą do opisywania algorytmów, operacji na danych.

        Moga zrownoleglic prace na danych dzieki czemu mozliwe jest szybkie
         przetwarzanie duzych zbiorow danych


        Strumien nie moze modyfikowac danych! */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);
        numbers.add(8);
        List<Wiek> listaWiek = new ArrayList<>();
        listaWiek.add(new Wiek(15));
        listaWiek.add(new Wiek(3));
        listaWiek.add(new Wiek(12));
        listaWiek.add(new Wiek(8));
        List<Imie> listaImie = new ArrayList<>();
        listaImie.add(new Imie("kamil"));
        listaImie.add(new Imie("adam"));
        listaImie.add(new Imie("pawel"));
        listaImie.add(new Imie("gracjan"));

        numbers.stream()
                .map(v -> numbers.add(v) ? 1 : 0)
        //chce dodac do listy elementy - BLAD ConcurrentModificationException
        //.forEach(System.out::println);
        ;


        //----
        //Operacje na strumieniach

        //-Tworzenie strumienia
        Stream<Integer> strumien1 = numbers.stream();
        listaWiek.stream().forEach(x -> System.out.print(" wiek : "+x.getWiek()));
        List<Integer> wieks = listaWiek.stream().map(Wiek::getWiek).collect(toList());


        //-Przetwarzanie danych wewnatrz strumienia
        Stream<Integer> strumien2 = numbers.stream()
                .filter(x -> x > 10);

        Stream<Wiek> strumien3 = listaWiek.stream()
                .filter(x -> x.getWiek() > 10);
        strumien3.map(x -> x.getWiek() * 2);

        Stream<Imie> strumien4 = listaImie.stream();
        strumien4.map(x -> x.getImie().toUpperCase());
        //musze zrobic w oddzielnej linii


        //-Zakonczenie strumienia
        strumien1.forEach(System.out::println);
        listaWiek.stream().forEach(x -> System.out.print(" wiek2 : "+x.getWiek()));
        wieks.forEach(x -> System.out.println(x));



        //----
        //Tworzenie strumienia:

        //-Na podstawie kolekcji
        Stream<Integer> strumien6 = new LinkedList<Integer>().stream();
        Stream<Integer> strumien5 = numbers.stream();

        //-Na podstawie tablicy
        Stream<Integer> strumien7 = Arrays.stream(new Integer[]{});

        //-Na podstawie lancucha znakow rozdzielanego przez wyrazenie regularne
        Stream<String> strumien8 = Pattern.compile(".").splitAsStream("some longer sentence");

        //-Strumien typow prstych
        DoubleStream randomDoubles = new Random().doubles();
        IntStream randomInts = new Random().ints();
        LongStream randomLongs = new Random().longs();

        //- Strumien pusty
        Stream.empty();

        //-Strumien danych z pliku
        try (Stream<String> lines = new BufferedReader(new FileReader("plik1.txt")).lines()) {
            //zrob cos
        } catch (FileNotFoundException e) {
        }


        //----
        /*Operacje:

        -filter - zwraca strumien zawierajacy tylko te elemnty dla ktorych
                  filtr zwrocil wartosc true
                  Predicate<T> | boolean test(T t)*/
        numbers.stream().filter(x -> x > 10);
        listaWiek.stream().filter(x -> x.getWiek() > 10);/*

        -map - kazdy z elementow moze zostac zmieniony do innego typu, nowy obiekt zwarty
               jest w nowym strumieniu, uzywam aby zmiec typ
               Function <T, R> | R apply(T t)*/
        Stream<Integer> strumien9 = listaWiek.stream()
                .map(x -> x.getWiek());
        strumien9.forEach(System.out::println);
        listaWiek.stream().map(Wiek::getWiek).forEach(System.out::println);

        Map<String, Integer> strumienMapa = new HashMap<>();
        strumienMapa.put("a", 1);
        strumienMapa.put("b", 2);
        strumienMapa.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("x : " + strumienMapa.values());/*

        -peek - pozwala przeprowadzic operacje na kazdym elemencie w stumieniu, zwraca
                stumien z tymi samymi elemntami
                Consumer<T> | void accept(T t)*/
        numbers.stream().peek(System.out::println).collect(toList());
        listaWiek.stream().peek(x -> System.out.print(x.getWiek())).collect(toList());
        /*musi byc collect(toList()) bo inaczej nic nie wyswietli

        -limit - zwraca strumien ograniczony do zadanej liczby elementow, pozostale sa
                ignorowane*/
        numbers.stream().limit(2);/*

        -sum - sumuje wartosci ze strumienia - MUSZA BYC MAPOWANE SPECJALNA METODA
               mapToInt!*/
        int slowNumber3 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();/*

        -collect - moge uzyc do wyswietlenie w toString
        rycerze.stream().map(Objects::toString).collect(Collectors.joining(","));



        //----
        /*Konczenie strumienia:

        Operacje konczaace nie moga zwracac typu Strem oraz nie musza zwracac nic.
        Jesli odwolam sie do zamknietego strumienia wyrzuci blad:
        IllegalStateException: stream has already been operated upon or closed

        Przyklady zamkniec strumieni:

        - forEach - wykonuje zadaną operację dla każdego elementu
                    Consumer<T> | void accept(T t) */
        Stream<Wiek> filtrowanyStrumien = listaWiek.stream()
                .filter(x -> x.getWiek() > 4);
        //strumien typu Wiek filtruje
        Stream<Integer> liczbyZeStrumienia = filtrowanyStrumien
                .map(x -> x.getWiek());
        //map zmieniam strumien Wiek na Integer to znaczy
        // elementy zapisuje do strumienia tylko elementy typu Integer
        liczbyZeStrumienia.forEach(System.out::println);/*
                        //posiadajac typ Integer w stumieniu moge wywolac sout


        - count - zwraca liczbę elementów w strumieniu (strumien nie moze byc zamkniety!)*/
        Stream<Wiek> stumienWieks = listaWiek.stream();
        System.out.println("ilosc elem w strumieniu : " + stumienWieks.count());/*


        - allMatch - zwraca flagę informującą czy wszystkie elementy spełniają warunek.
                      Przestaje sprawdzać na pierwszym elemencie, który tego warunku nie spełnia
                      //Predicate<T> | boolean test(T t)*/
        boolean czyWszystkoWiekszeOdZera = listaWiek.stream().allMatch(x -> x.getWiek() > 0);/*


        -collect - pozwala na utworzenie nowego typu na podstawie elementów strumienia.
                    Przy pomocy tej metody można na przykład utworzyć listę. Klasa Collectors
                    zawiera sporo gotowych implementacji.*/
        Stream<Integer> strumienNaInt = listaWiek.stream().map(x -> x.getWiek());
        List<Integer> listaZeStrimienia = strumienNaInt.collect(Collectors.toList());


        //----
        //Wlasciewosci strumieni

        //Metoda konczonca dopiero rozpoczyna przetwazranie elementow

        System.out.println();
        IntStream strumienLiczb = IntStream.range(0, 8);
        //tworze strumien z liczbami 0 - 7
        System.out.println("Przed");
        strumienLiczb = strumienLiczb.filter(x -> x % 2 == 0);
        //filtruje i zapisuje tylko liczby parzyste do strumienia
        System.out.println("W trakcie 1");
        strumienLiczb = strumienLiczb.map(x -> {
            System.out.println("> " + x);
            //wyswietlam ">" i liczbe
            return x;
            //+ zwracam ta liczba
            //operacja map jest rozbudowana o wyswietlenie
            // ale musi tez zwracac
        });
        System.out.println("W trakcie 2");
        strumienLiczb = strumienLiczb.limit(2);
        //obcinam liczby do 2
        System.out.println("W trakcie 3");
        strumienLiczb.forEach(System.out::println);
        //metodaZwykla konczaca wyswietla strumien
        System.out.println("PO");


        /*----
        Strumienie przetwarzane sa sekwencyjnie w metodzie stream()
         lub rownolegle (uruchamiany w kilku watkach) metodaZwykla parallelStrem

        Strumien sekwencyjny mozna przlaczyc na rownolegly uzywjac na nim
         metody parallel lub odwrotnie sequential


        ----
        Przyklad zastosowania - gdy chce sie pozbyc if:

        for (BoardGame x : games) {
                    if (x.maxPlayers > 4) {
                        if (x.rating > 8) {
                            if (new BigDecimal(150).compareTo(x.price)>0) {
                                //nie moge porownac int 150 z bigDecimal wiec musze stworzyc
                                // lokalna zmienna BigDecimal z wartoscia 150 oraz wywolac
                                // metode compareTo

        moge zastapic to strumieniem:
        games.stream()
                     .filter(x -> x.maxPlayers > 4)
                     .filter(x -> x.rating > 8)
                     .filter(x -> new BigDecimal(150).compareTo(x.price) > 0)
                     .map(x -> x.name.toUpperCase())
                     .forEach(System.out::println);


        /*----
        Dobre praktyki:

        - Filtrowanie na poczatku
        */
        List<Integer> liczbyy = Arrays.asList(3, 4, 5);
        int slowNumber = liczbyy.stream()
                .mapToInt(Integer::intValue)
                //musze dac metode mapToInt aby uzyc sum()!
                .filter(x -> x > 4)
                .sum();
        //lepiej dac filtrowanie na poczatku aby nie mapowac
        // niepotrzebnych elementow
        int slowNumber2 = liczbyy.stream()
                .filter(x -> x > 4)
                .mapToInt(Integer::intValue)
                .sum();/*


        - Unikanie skomplikowanych wyrazen lambda
        Lepiej jest stworzyc oddzielna metode do tego

        IntStream.range(1950, 2150)
            .filter(y -> (y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            .forEach(System.out::println);

        //lepiej zmienic kod na bardziej czytelny:
        IntStream.range(1950, 2150)
            .filter(StreamsGoodPractices::isLeapYear)
            //za pomoca metody klasy
            .forEach(System.out::println);

        public static boolean isLeapYear(int year) {
            boolean every4Years = year % 4 == 0;
            boolean notEvery100Years = year % 100 != 0;
            boolean every400Years = year % 400 == 0;

            return (every4Years && notEvery100Years) || every400Years;
        }


        ----
        Operacje na strumieniach - dokladny opis + interfejsy funkcyjne

        Tworzac obiekt interfejsu funkcujnego moge na nim pozniej wywolac jego
         metode

        Runnable o1 = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("x");
            }
        };
        p1.run();


        filter //Predicate<T> | boolean test(T t) //Stream + bezposrednio + nowa lista
        .filter(x -> x.getX()>22) // typ listy obiektowy
        .filter(x -> x>22) //typ listy prosty lub po mapowaniu
        //Sluzy do filtrowania, sprawdza wybrany warunek
        // w lambdzie, elementy ktore na wartunek beda true zostana w strumieniu


        map //Function<T, R> | R apply(T t) //Stram + bezposrednio + nowa lista
        .map(x -> x.getX())
        .mapToInt(Integer::intValue) //na potrzeby sum();
        //Uzywam do zmiany typu,

       -//Stream<Integer> streamX = listaObiektow.stream().map(x -> x.getX());
        // streamX.forEach(System.out::println);
        //Uzywam na Stream z typem prostym np <Integer> aby zmienic
        // rodzaj pol listy Obiektow na ten z typu generycznego Strem a nastepnie w
        // forEach moge wyswietlic elementy strumienia z odwolaniem do metody
        // System.out::println bo mam juz elementy w strumieniu typu prostego,
        // moge takze bez mapowania wyswielic w forEach lecz gdy bede mial strumien
        // z obiektami bede musial odwolac sie do pol .forEach(x -> System.out.println(x.getX());

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

       -//int sumaInt = liczbyy.stream()
        //        .mapToInt(Integer::intValue)
        //        //musze dac metode mapToInt aby uzyc sum()!
        //        .filter(x -> x>4)
        //        .sum();
        //Metoda .mapToInt przypisuje zmienne strumienia do int przez co moge
        // uzyc metody sum

       -//return rycerze.stream().map(Objects::toString).collect(Collectors.joining(","));
       //W metodzie toString moge tak wyswielic kolekcje obiektow


        peek //Consumer<T> | void accept(T t) //bezposrednio + nowa lista
        .peek(x -> System.out.println(x))
        .peek(x -> System.out.println(x.getX() + " "+ x.getNapis() ))
        //Sluzy np do wyswietlenia, musze na koncu dac .collect(toList())! bo nic nie wyswietli

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


        forEach //Consumer<T> | void accept(T t) //Stream + bezposrednio + nowa lista
        strumienZInteger.forEach(System.out::println); //typ prosty/1 rodzaj pola
        strumienZObiektami.forEach(x -> System.out.println(x.getNapis()));
        .forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));//bezposrenio na stuminiu
        .forEach(System.out::println); //bezposrenio na stuminiu z 1 typem zmiennych
        //Sluzy do zamkniecia struminia i np wyswietlenia

       -//Stream<Integer> integerStream = listaInt.stream();
        // integerStream.forEach(System.out::println) //NOWA LINIA
       -//Stream<MojaKlasa> obiektyStream = listaOb.stream();
        // obiektyStream.forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));

       -//listaInteger.stream().forEach(System.out::println); //JEDNA LINIA
       -//listaObiektow.stream().forEach(x -> System.out.println(x.getNapis()+" "+x.getLiczba()));
       -//listaObiektow.stream().map(x -> x.getX()).forEach(System.out::println);
        //Lub na stumieniu bezposrenim (moge z mapowaniem w przypadku typu obiektowego
        // aby wybrac typ i odwolac sie besrednio z :: do konkretnego pola)

       -//List<Integer> listaX = listaInteger.stream().collect(toList());
        // listaX.forEach(System.out::println) //NOWA LINIA
       -//List<KlasaObiektow> listaO = listaObiektow.stream().collect(toList());
        // listaO.forEach(x -> System.out.print("x: "+x.getX()+" napis: "+x.getNapis()));
       -//List<Stream> listaS = listaObiektow.stream().map(x -> x.getNapis()).collect(toList());
        // listaS.forEach(System.out::println);
        //Lub w nowej liscie W ODDZIELNEJ LINII, na koncu stream() musze dac Collect(toList())!!


        limit //Stream + bezposrednio + nowa lista
        .limit(liczba)
        //ograniczam liczbe elementow w strumieniu

       -Stream<Wiek> strumienWiek = listaWiek.stream().limit(2);
       -listaWiek.stream().limit(2);
       -List<Wiek> listaWiekLimit = listaWiek.stream().limit(2).collect(toList());


        count //zwraca liczbe elementow w strumieniu

       -System.out.println(strumien1.count());


        sorted //Stream + bezposrednio + nowa lista
        .sorted()/.sorted(Comparator.reverseOrder) - typy proste
        .sorted(Comparator.comparing(KlasaZLiczba::getNapis).reverseOrder) - typy wlasne

       -Stream<Wiek> strumienWiekSorted = listaWiek.stream().sorted(Comparator.comparing(Wiek::getWiek));
       -strumienWiekSorted.sorted(Comparator.comparing(Wiek::getWiek));
       -List<Wiek> listaWiekSorted = strumienWiekSorted.sorted(Comparator.comparing(Wiek::getWiek)).collect(toList());


        collect
        .collect(Collectors.toList()) / collect(toList())
        .collect(Collectors.joining(", ","{","}"));
       -//List<KlasaZLiczba> listObjectX = listObject.stream().collect(toList());
        //Gdy przypisuje do listy DOWOLNEJ musze dac na koncu
       -//listObject.stream().peek(x -> System.out.println(x.getX() + " "+ x.getNapis() )).collect(toList());
        //Lub gdy uzywam peek bezposrednio na strumieniu listy (bez tego zadziala ale nie wyswietli

       -//String autaString2 = auta.stream().collect(Collectors.joining(", ","{","}"));
        //Przypisuje do stringa zawartosc kolekcji
       -//rycerze.stream().map(Objects::toString).collect(Collectors.joining(","));
        // moge uzyc w toString do zwrocenia kolekcji z mapowaniem


        max //przypisuje do zmiennej
        .max(Comparator.comparingInt(x->x)).get(); //po mapowaniu do typu zwyklaego + przypisanie do typu zwyklego
        .max(Comparator.comparing(KlasaZLiczba::getX)).get();
       -//KlasaZLiczba zmiennaO = listaObiektow.stream().max(Comparator.comparing(KlasaZLiczba::getX)).get();
        // System.out.println(zmiennaO.getX());
        //Uzywam na zmiennej Obiektowej WLASNEJ klasy i przypisuje jej
        // wybrane pole max odwolujac sie w Comparatorze do getera :: + metodaZwykla get()!!
        // *NIE MAPUJE bo przypisuje do typu KlasaZLiczba!
       -//Integer liczbaMax3 = listObject.stream()
                .map(x -> x.getX())//mapuje bo z listy obiektow przypisuje do int
                .max(Comparator.comparing(x -> x)).get();//WPISUJE x->x bez getX bo mapowalem
                // lub .max(Comparator.comparing(Integer::compare)).get();
                // lub .max(Integer::compare).get();
                // tzn. moge skorzystac z metody Integer::compare w max bo przemapowalem do Integer
                // lub .max(String::valueOf).get();
                // tzn. jesli przypisuje do String tylko inna metodaZwykla
        // System.out.println(liczbaMax3);
        //Lub na zmiennej prostej wybranego typu pola z klasy np int,
        // uzywam z mapowanie bo musze wyciagnac jeden rodzaj zmiennej z
        // LISTY OBIEKTOW a nastepnie w comparing zapisuje x->x bez getX.
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
        // tworze zmienna comparatora ktora potem wykorzytsam w metodzie min
        //KlasaZLiczba najmniejszaLiczba = listObject.stream()
                .min(comparatorInt).get();
        //System.out.println("najmniejszaLiczba: "+najmniejszaLiczba.getX());
       -//Comparator<KlasaZLiczba> comparatorString = (x1, x2) -> x1.getNapis().compareTo(x2.getNapis());
        //KlasaZLiczba najmniejszyWyraz = listObject.stream()
                .min(comparatorString).get();
        //System.out.println("najmniejszyWyraz : "+najmniejszyWyraz.getNapis());
        //Lub z uzyciem zmiennej Comparatora

       -//Integer[] numbers = {4,1,10,2,3};
        //System.out.println("Stream.min(): " + Arrays.stream(numbers).min(Integer::compare).get());
        //Lub z uzyciem tablicy i klasy Arrays


        all/any/noneMatch //przypisuje do zmiennej
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


        sum //przypisuje do zmiennej
        .sum();
        -int suma = liczbyLista.stream().mapToInt(Integer::intValue).sum();
        //Metoda sumuje liczby strumienia, MUSI byc zmapowane z metoda mapToInt!
        // + moge wykorzystac metode klasy Integer zwracajaca int;
         */



        /*-------------------------------------------------------------------------
        --------------------------KLASA Optional-----------------------------------

        Klasa Optional to generyczny pojemnik ze zmeinna dowolnego typu ktora moze
         miec wartosc null.

        W javie 9 moge stworzyc strumien z optionala

        Metody:
        - empty() - tworzy pusty Optional z wartością null w środku.
        - of(T value) - tworzy Optional z podaną wartością. W przypadku przekazania
           null dostaniemy nullPointerException.
        - ofNullable(T value) - również tworzy Optional z podaną wartością, ale w
           przypadku przekazania null nie zostanie zgłoszony wyjątek.
        - Optional(T value) - konstruktor rzucający błąd w przypadku przekazania
           wartości null.
        - isPresent() - zwraca boolean mówiący czy w środku znajduje się jakaś
           wartość czy też null.
        - get() - pobranie przechowywanego obiektu. Jeżeli takiego nie
           ostaniemy: NoSuchElementException


        Uzycie:
        */
        Map<String, Imie> mapaOptional = new HashMap<>();
        mapaOptional.put("Pawel", new Imie("pawel"));
        mapaOptional.put("Tomek", new Imie("tomek"));

        //OF
        Optional<Imie> optionalOfPawel = Optional.of(mapaOptional.get("Pawel"));
        //Optional<Imie> optionalPusty = Optional.of(mapaOptional.get("Kamil"));
        //Optional<Imie> optionalPusty2 = Optional.of(null);
        //Metoda of Zwraca optionala z wybranym obiektem ale zaklada ze NIE BEDZIE
        // W ARGUMENCIE PRZESLANY NULL!
        //Obydwie metody stworza wyjatek nullpointexception

        //OFNULLABLE
        Optional<Imie> optionalPawel = Optional.ofNullable(mapaOptional.get("Pawel"));
        Optional<Imie> optionalKamil = Optional.ofNullable(mapaOptional.get("Kamil"));//brak
        Optional<Imie> optionalNull = Optional.ofNullable(null);
        //Metoda ofNullable nie wyrzuca wyjatku w przyslania nulla tylko tworzy pusty
        // obiekt Optional
        //TA METODA JEST BARDZIEJ ZALECANA!

        //EMPTY
        Optional<Imie> optionalEmpty = Optional.empty();
        //zwraca pusty optional


        //GET
        Imie nowyPracownik = optionalPawel.get();
        //Metoda get wyciaga obiekt z Opbtional

        //Imie nowyPracownik2 = optionalNull.get();
        //zwroci wyjatek bo jest null wiec moge uzyc metody isPresent() poniewaz
        // zwraca true jesli NIE MA w sobie nulla

        //ISPRESENT
        //metoda zwroci true jesli Optional ma cos w srodku
        if(optionalPawel.isPresent()){
            Imie nowyPracownik3 = optionalPawel.get();
            System.out.println("Imie optional pawel: "+nowyPracownik3.getImie());
        }

        //IFPRESENT
        optionalPawel.ifPresent(x -> System.out.println(x.getImie()));
        //metoda ifPresent zadziala jesli w Optionalu jest obiekt oraz przyjmuje
        // consumer czyli moze cos wyswietlic

        Optional<String> optionalString = optionalPawel
                .map(x -> x.getImie());
        //w mapoweniu nie moge dac Wiek::getWiek bo metoda nie jest statyczna
        // jak mapa w srodku optionala!!
        optionalString.ifPresent(System.out::println);

        optionalPawel
                .map(x -> x.getImie())
                .ifPresent(System.out::println);
        //UWAGA maptownie zmieni tylko TYP GENERYCZNY OPTIONALA!!

        //Moge takze filtrowac
        optionalPawel
                .filter(x -> x.getImie().equals("Pawel"))
                .map(x -> x.getImie())
                .map(String::toUpperCase)
                .ifPresent(System.out::println);


        //ORELSE
        //Jesli nie bedzie obiektu w Optional lub nie przjedzie filtr moge
        // uzyc orElse() ktora zwroci STRING!
        String imiePracownika = optionalPawel
                .filter(x->x.getImie().equals("Pwl"))
                .map(x -> x.getImie())
                .orElse("Brak pracownika");
                //.orElseThrow(()-> new RuntimeException("brak prownika"));
                //lub z wyrzuceniem wyjatku


        //Java 9:

        //OR
        //Metoda wykonuje sie jesli w Optional jest null i zawiera interfaca
        // supplier czyli nic nie przujmuje a zwraca cos
        //Moge jestli Optional ma null do stworzenia obiektu i moge
        // wykorzystac metode of Optional
        optionalNull
                .or(()->Optional.of(new Imie("Kamil")))
                .map(x->x.getImie())
                .ifPresent(System.out::println);

        //IFPRESENTORELSE
        //Metoda wykona 1 z 2 instrukcji:
        //Moze wyswietlic (consumer) jesli cos jest w Optional lub jesli jest null
        // wykona sie druga instrukcja (runnable - nic nie przyjmuje nic nie zwraca)
        // np wyswietlenie napisu
        optionalNull
                .or(()->Optional.of(new Imie("Janusz")))
                .filter(x -> x.getImie().equals("Jan"))
                .map(x -> x.getImie())
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("brak Jana")
                );




        /*-------------------------------------------------------------------------
        -----------------------------KLASA ROBOT-----------------------------------

        Klasa robot sluzy do automatycznego uzywania klawiatury, myszy,
         robienia zrzutow ekranu i odczytywaniu informacji o pixelach

        METODY:
        keyPress(int keycode) np keyPress(KeyEvent.VK_C)
        keyRelease(int keycode)
        mousePress(int buttons) - podaje stale z klasy InputEvent:
         (BUTTON1_MASK, BUTTON2_MASK, BUTTON3_MASK)
        mouseRelease(int buttons)
        createScreenCapture(Rectangle screenRect)
        delay(czas) - opoznienie

         */
        try {
            Robot mojRobot = new Robot();
            //robot moze byc umieszczony w klasie jako zmienna Robot robot;
            mojRobot.delay(1000);
            int[]tabPrzyciskow={KeyEvent.VK_C,KeyEvent.VK_Z,KeyEvent.VK_E,
                    KeyEvent.VK_S,KeyEvent.VK_C};
            for (int i=0;i<0;i++){
                mojRobot.keyPress(tabPrzyciskow[i]);
                mojRobot.delay(100);
            }
        }catch (AWTException e){
            System.out.println("Co on robi?");
            e.printStackTrace();
        }


    }



    //ALGORYTMY:

    //Metoda dzielaca liczbe na czesci i pokazujaca ja od tylu
    public void printCharPerLine(int number) {
        while (number > 0) {
            int reminder = number % 10;
            number /= 10;
            System.out.println(reminder);
        }
    }
    //lub
    public void liczbaOdTylu(int x){
        String s = x+"";
        for (int i = s.length()-1; i>=0; i--) {
            System.out.println(s.charAt(i));
        }
    }

    //Metoda odwracajaca napis:
    public static String odwrocNapis(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public static String odwrocNapis2(String s){
        String sTemp = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            sTemp= sTemp+s.charAt(i);
        }
        return sTemp;
    }
    public static String odwrocNapis3(String s){
        char[] tab = s.toCharArray();
        String sReturn = "";
        for (int i = tab.length-1; i >= 0; i--) {
            sReturn += tab[i];
        }
        return sReturn;
    }

    //Metoda zwracajaca liczbe binarna:
    public static int liczbaBinarna(int x){
        StringBuilder sb = new StringBuilder();
        while (x>0){
            sb.append(x%2);
            x/=2;
        }
        return Integer.valueOf(sb.reverse().toString());
    }
    public static void naBinarny(Integer x){
        String out = "";
        while (x>0){
            out+=x%2;
            x/=2;
        }
        System.out.println(new StringBuilder(out).reverse());
    }

    //Metoda spawdzajaca czy napis jest palimdromem:
    public static boolean czyPalindrom(String x){
        int licznik = x.length()-1;
        for (int i = 0; i < x.length()/2; i++) {
            if(x.charAt(i)==x.charAt(licznik))
                licznik--;
            else{
                return false;
            }
        }
        return true;
    }

    //Metoda sortujaca babelkowo:
    public static void sortujBabelkowo(int[]tab) {
        int licznik = 0;
        while (licznik < tab.length) {
            for (int i = 0; i < tab.length - licznik - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                }
            }
            licznik++;
        }
    }
    public static void sortujBabelkowo3(int[] x){
        int licznik = x.length-1;
        while (licznik>0){
            for (int i = 0; i < licznik; i++) {
                if(x[i]>x[i+1]){
                    int tmp = x[i+1];
                    x[i+1]=x[i];
                    x[i]=tmp;
                }
            }
            licznik--;
        }
    }
    public static void sortujBabelkowo2(int[] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                //System.out.println("tab i["+i+"]="+tab[i]+", tab j["+j+"]="+tab[j]);
                if(tab[i]<tab[j]){
                    //System.out.println("switch");
                    int tmp = tab[j];
                    tab[j]=tab[i];
                    tab[i]=tmp;
                    //System.out.println("after switch: tab i["+i+"]="+tab[i]+", tab j["+j+"]="+tab[j]);
                }
            }
        }
    }

}

//------------------------KLASY POMOCNICZE DO KODU MAIN----------------------

interface Figura{
    String dajNazwe();
}
enum KoszulkaRozmiar{
    S,M,L,XL
}
enum KoszulkaRozmiarDokladnie{
    S(48, 71, 36),
    M(52, 74, 38),
    L(56, 76, 41),
    XL(61, 79, 41);

    private int szerokoscKlatki;
    private int wysokoscKoszulki;
    private int dlugoscRekawa;

    KoszulkaRozmiarDokladnie(int szerokoscKlatki, int wysokoscKoszulki, int dlugoscRekawa){
        this.szerokoscKlatki = szerokoscKlatki;
        this.wysokoscKoszulki = wysokoscKoszulki;
        this.dlugoscRekawa = dlugoscRekawa;
    }
    int dajSzerokoscKlatki(){
        return szerokoscKlatki;
    }
    int dajwysokoscKoszulki(){
        return wysokoscKoszulki;
    }
    int dajdlugoscRekawa(){
        return dlugoscRekawa;
    }
}

enum EnumDoTekstu{
    IMIE{
        public String format(String wiadomosc){
            return "Czesc " + wiadomosc;
        }
    },
    NAZWISKO {
        public String format(String wiadomosc) {
            return " " + wiadomosc;
        }
    };
    public abstract String format(String wiadomosc);
}

interface Powitanie{
    void powiedzCzesc();
}

class KlasaDoSortowania implements Comparable{
    public String napis;
    public KlasaDoSortowania(String napis) {
        this.napis = napis;
    }
    @Override
    public int compareTo(Object o) {
        KlasaDoSortowania x = (KlasaDoSortowania)o;
        return this.napis.length() - x.napis.length();
    }
}
class KlasaSortujaca implements Comparator<KlasaDoSortowania>{
    @Override
    public int compare(KlasaDoSortowania o1, KlasaDoSortowania o2) {
        return o1.napis.compareTo(o2.napis);
    }
}
interface CzyParzysta<T>{
    boolean sprawdz(T obiekt);
}
class KlasaMoja{
    int liczba;
    String napis;

    public KlasaMoja(String napis, int liczba) {
        this.liczba = liczba;
        this.napis = napis;
    }
}
class KlasaZMetodaReturnInt{
    static int staticDajInt(){
        return 50;
    }
}

class Wiek{
    int wiek;
    public int getWiek() {
        return wiek;
    }
    public Wiek(int wiek) {
        this.wiek = wiek;
    }
}
class Imie{
    String imie;
    public String getImie() {
        return imie;
    }
    public Imie(String imie){
        this.imie =imie;
    }
}

//WAZNE INFO OGOLNE DO ZAPAMIETANIA!!
/*
zmienna final OBIEKTOWA nie musi posiadac nadanwej wartosci
 nawet w kosntruktorze
zmeinna final prosta JESLI jest zadeklarwoana GLOBALNIE
 musi miec nadana wartosc CHYBA ZE nadadnie wartosci jest
 w konstruktorze tej klasy
zmienna final zadeklarowana LOKALNIE nie musi miec nadanej
 wartosci

 */