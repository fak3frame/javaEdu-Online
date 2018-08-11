package SamouczekProgramisty;

import SamouczekProgramisty.Silnik.SilnikMoj;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Wstep {

    public static void main(String[] args) {
        /*
        Skroty klawiszowe:
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


         */

        /*
        WSTEP:
        Klasa - projekt/foremka
        Obiekt/instancja - produkt

        Maszyna wirtualna pomaga zarzadzac pamiecia

        wersja programy X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle

        JRE - maszyna wirtualna tylko dla uruchamiania programow

        JDK - zestaw narzedzi zawierajacy takze kompilator javac

        IDE (ang. Integrated Development Environment)


        METODY:

        Metoda - worek do grupujacy zestaw instrukcji. tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc
        Metody nie powinny przyjmowac duzej ilosc argumentow ("code smell")

        moge operwac na obiekcie tylko jesli przypisany jest do jej referencji cos
        classOne X = new classOne();

         */
        int jakisNumer = 123; //zakres +/- 2,147,483,647
    class Wew1{//////////////////////////
        boolean czyDuza(int liczba){
            return liczba>100;
        }
        void powiedzCos(){
            return;
            //Metoda void moze posiadac slowo retrun ale nie moze nic zwracac
        }
    }/////////////////////////////////

        //Metoda moze takze wywolywac w wyniku inna metode i sprawdzac czy wynik
        // jest taki sam. jesli bedzie taki sam da true
        // return ! metoda();
    class WeW4{////////////////////////////////
        int a;
        public boolean isOdd() {
            return ! isEven();
        }
        public boolean isEven(){
            return a%2==0;
        }
    }//////////////////////////////////////

    class WeW3{//////////////////////////////
        //Metoda zwracajaca tablice:
        public String[] pokazTab(){
            return new String[]{"costma","costam2"};
        }
    }///////////////////////////////////////////



        //WPROWADZANIE DANYCH:
    class wew23{////////////////////////////
    void metoda(){/////////////////////////
        String imie;
        List<String>imiona2 = new LinkedList<>();
        Scanner wprowadz = new Scanner(System.in);
        do{
            imie = wprowadz.nextLine();
            if(!imie.equals("-")){
                imiona2.add(imie);
            }
        }while (!imie.equals("-"));

        //lub samym while

        while (true){
            imie = wprowadz.nextLine();
            if(imie.equals("-"))
                break;
            imiona2.add(imie);
        }
    }    ////////////////////////
    }/////////////////////////////


        /*
        PAKIETY:

        Słuza do grupowania i informowania gdzie znajduje sie klasa/interfejs
        /typ wyliczeniowy/adnotacja

        Przyjato ze uzywa sie odwrotnej nazwy domenowej

        package pl.SamouczekProgramisty.Folder1;
        plik klasy znajduje sie w folderze "Folder1" a on w folderze
         "SamouczekProgramisty" a on w "pl"

        import pl.SamouczekProgramisty.Folder1.MojaKlasa;
        importuje klase MojaKlasa z pakietu ->Folder1->
         ->SamouczekProgrmisty->pl
         Mam dostep dzieki temu takze do wszystkich jej statycznych metod



        KLASY:

        Sluzy do grupowania atrybutow i metod

        Zmienna statyczna dotyczy klasy a nie obiektu lecz moezmy
         na obiekcie sie do niej odwolac



        Jesli utworzymy wlasny konstruktor - kompilator nie doda domyslnego
        ----------------
        private SilnikMoj silnikMoj;

        public Silnik(){
            silnikMoj = new SilnikMoj(20);
        }
        public Silnik(SilnikMoj silnikMoj){
            this.silnikMoj = silnikMoj;
        }
        ----------------
        1 konstruktor tworzacy obiekt klasy SilnikMoj w atrybucie silnikMoj
           klasy Silnik
        2 konstruktor kopiujacy obiekt klasy SilnikMoj do atrybutu silnikMoj
           klasy Silnik
        ----------------
        retrun SilnikMoj getSilnikMoj(){
            return silnikMoj;
        }
        */



        //STRING / TABLICE / ZMIENNE
        //Tblica jest obiektem !
        String a = "213\nwqeqwe";//\n enter
        int aDlugosc = a.length();

        String[] dni = new String[7];
        dni[0] = "Poniedzialek";
        System.out.println("Dlugosc tablicy: "+dni.length); //bez () !!
        //w string/kolekcjach jest z ()
        //pokaze ilosc dlugosc tablicy a nie ile ma wypelnionych elem.

        String[] imiona = new String [] {"kamil", "tomek"};

        int liczba = 1234_123;//liczba z literalem - ulatwia czytelnosc
        //pokaze liczbe normalnie
        int liczba2 = -0xFF00;//w systemie szesnastkowym
        int liczba3 = 0777;//w systemie osemkowym (511)
        long liczba5 = 1232455;//nie musze pisac z koncowka L
        long liczba4 = 123L;//da informacje ze bedzie to typ long
        // mozliwe jest uzycie "l" lecz zalecane jest "L"
        float liczba6 = 123.34F;//musi byc "F" lub "f"
        double liczba7 = 213.45;
        short liczba8 = 234;
        //W przypadku typow prostych jest wykonywany automatyczny autoboxing

        int liczbaBox1 = new Integer(12);
        //wykonuje operacje odwrotna czyli autounboxing

        final int LICZBA_FINALNA;
        LICZBA_FINALNA = 10;
        //liczbaFinalna = 12; - blad - liczbe finalna mozemy przypisac 1 raz
        // lecz mozna ja zadeklarowac bez nadawania wartosci TYLKO LOKALNIE!!!
        //Gdy jest to zmienna lokalna musze nadac jej wartosc lub utworzyc
        // jej ndadanie wartosci w konstruktorze!!!

        Date data1 = new Date(); //data1 zawiera aktualana date
        System.out.println(data1);



        //INTERFACE
        /*
        API (ang. Application Programming _1_Interface)
        Jest to zestaw metod bez ich implementacji
        Wszystkie metody interfacu sa publiczne przez co implemetrujac je w
         klasach musi byc modyfikator public!!
        Interface moze zawierac metody domyslne,statyczne oraz zmienne stałe
         finalne publiczne

        Metoda domyslna to taka ktora posiada cialo i zaczyna sie od slowa
         default, mozna je nadpisywac

        default String getName(){
            return "Napis";
        }

        Klasa implementujaca interface musi implementowac wszystkie jego
         metody za wyjatkiem klas abstrakcyjnych, lecz jesli klasa abstrakcyjna
         zaimplemetuje metode interfejsu ktory implemetuje to klasy dziedziczace
         ta klase abstrakcyjna juz nie bede musialy implementowac metody
         tego interfejsu

        Interfejs moze rozszerzac inne interfejsy i klasa implementujaca
         taki interface musi metody z wszytskich tych interfejsow implementowac

        Intefejs bez metod jest interfejsem znacznikowym ktory sluzy do oznaczania
         danej klasy dzieki czemu moge przekazac dodatkowe informacje. Moge np
         powiedziec kompilatrowi ze dana klasa jest serializowana

        Poprzez tworzenie obiektu typu interfacu moge ograniczyc widzialnosc metod



        //DZIEDZICZENIE
        Szmochod - nadklasa/klasa bazowa/ SUV - podklasa/klasa pochodna

        public - dostepny wszedzie
        protected - dostepne wewnatrz obiektu, pakietu oraz klas pochodnych
        brak modyfikatora - dostepny tylko w pakiecie
        private - dostepne wewnatrz obiektu, klasy pochodne nie maja dostepu

        klasa moze byc poprzedzona modyfikatorem public lub zadnym

        SYGNATURA METODY jest to nazwa metody oraz jaki typ przyjmuje
        public int mojaMetoda(int nazwa)
        jej sygantura: mojaMetoda(int)

        //Przeciazenia vs Przesloniecie
        Przesloniecie metody (override) wystepuje gdy klasa pochodna
         nadpisuje metode klasy bazowej.

        Przeciazenie metody (overload) jest gdy tworze metody o takiej samej
         nazwie ale przyjmujacej inne argumenty

        //Dziedzieczenie cd.
        metoda super.metoda(); wywoluje metode klasy bazowej o nazwie metoda();

        public Konstruktor()
            return this(new Klasa);
        ten konstruktor wywola konstruktor przyjmujacy przyjmujacy
         jako argument obiekt klasy Klasa

        instrukcja super(); w konstruktorze klasy pochodnej wywoluje
         konstruktor klasy bazowej. ilosc wyslanych parametrow np.
         super(10, 12) decyduje ktory konstruktor zostanie wywolany

        Tworzac obiekt klasy pochodnej ZAWSZE wywola sie jakis konstruktor
         klasy bazowej(tej ktora rozszerza) w pierwszej kolejnosci.
         Niewazne czy typ bedzie klasy pochodnej czy bazowej !!
        Gdy dodamy w klasie bazowej konstrukotr z 1 param. ten bezparametrowy
         zostanie usuniety przez co bede musial sie do niego (badz innego)
         odwolac tworzac obiekt podklasy!! - poniewaz w pierwszej kolejnosci
         musi wywoalc sie konstrukotr klasy po ktorej dziedziczy.
        Moge utworzyc recznie konstuktor bezperam. w klasie bazowej lub
         uzyc instukcji super(costam); w konstr. klasy pochodnej dostajac
         sie do wybrnaego konstruktora klasy pochodnej.

        Metody finalne nie moga byc nadpisywane a klasy finalne
         rozszerzane

        Kompozycja to stworzenie atrybutu (pola) klasy ktory jest
         innym obiektem

        Gdy tworze obiekt polimorficznie mam dostep do metod wszystkich
         klas lecz wywolujac metody podklasy musze rzutowac
        Animal a1 = new Human():
        a1.beAnimal();
        ((Human)a1).beHuman();

        Gdy tworze obiekt bez polimorfizmu nie musze rzutowac
        Human h1 = new Human();
        h1.beHuman();
        h1.beAnimal();

        Do metody toString() nie musze robic rzutowania



        //WYJATKI

        Wyjatek jest klasa.

        void metoda1()
            metoda2();
        void metoda2()
            metoda3();
        void metoda 3()
            throw new IllegalArgumentException("Liczba za mala");

        Wywolujac metode 1 w wyniku (stacktrace) otrzymamy najpierw
         otrzymamy wyjatek a nastpnie wywolanie metod od konca(metoda 3-2-1)
         jest to STOS WYWOLAN

        Exception in thread "main" java.lang.IllegalArgumentException: Liczba za mala
        at folder.nazwaKlasy.metoda3(nazwaKlasy.java:18)
        at folder.nazwaKlasy.metoda2(nazwaKlasy.java:14)
        at folder.nazwaKlasy.metoda1(nazwaKlasy.java:10)

         */
        try {
            throw new IllegalArgumentException();
        }
        catch (ArithmeticException exception) {
            // 1
        }
        catch (RuntimeException exception) {
            // 2
        }
        catch (Exception exception) {
            // 3
        }
        /*
        Blok 1 nie wykona sie bo w hierarhii IllegalArgumentException
         nie ma ArithmeticException ale za to jest RuntimeException
         wiec wykona sie blok 2, pozostale ponizej sa pomijane

        Do obslugi kilku wyjatkow w jednym catch uzywam |
        catch(RuntimeException | Exception ex){
            //hundle exception
        }

        Drugim sposobem na obsluge wyjatkow jest klauzla thorws
        */
    class Test2{
        Test2 t1 = new Test2();
        void metodaZWyjatkiem()throws IOException{
            throw new IOException();
        }
        void start(){
            try{
                t1.metodaZWyjatkiem();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally {
                //to zawsze bedzie wykonane
                //blok try/catch nie musi zawierac
                // catch jesli posiada finally
            }
        }
        //przyklad 2: //wyliczenie pierwiastka
        void start2(){
            Scanner sc = new Scanner(System.in);
            int liczba = 0;
            while (true){
                try{
                    liczba = sc.nextInt();
                    break;
                }
                catch (InputMismatchException e){
                    //zla liczba
                    sc.next(); //!!!?
                }
            }
            if(liczba < 0)
                throw new IllegalArgumentException("liczba mniejsza od 0");
        }
    }

        /*
        Rodzaje wyjątków: CHECKED oraz UNCHECKED
        Kazdy wyjatek dziedziczy po klasie Throwable

        Wyjatek checked musi byc obluzony np. IOException
         natomiast unchecked np. IllegalArgumentException

        Jesli wyjatek ma w swojej hierarchii TYLKO Exception/Throwable
         musi byc obsluzony, jesli cos wiecej to juz nie

        Hierarchia dziedziczenia wyjatkow:
        Throwable <- Exception <- RuntimeException <- IllegalArgumentException



        //STERTA / REFERENCJA / GC
        Gdy tworze obiekty rezerowana jest pamiec (STERTA) - HEAP SPACE
        JVM rezrwuje pamiec RAM
        Zmienne trzymane sa na STOSIE - STACK
        Zmienne, które wskazują na obiekty na stercie zawierają referencje
        Gdy zajme caly stos zostanie wyrzucony wyjatek
         java.lang.OutOfMemoryError
        Null jest typem ktory nie moze posiadac nazwy przez co nie mozna
         utworzyc zmiennej tego typu



        //KONWERSJA I RZUTOWANIE
        Rzutowanie (cast)
        Możemy rzutować wyłącznie na typ, który znajduje się hierarchii
         dziedziczenia danego obiektu inaczej wyrzuci wyjatek
         java.lang.ClassCastException
        Rzutowanie jest to konwersja jawna
        Konwersja niejawna zachodzi gdzy wysylam do metody przyjmujacej
         typ zmiennej long - typ int. Nie dochodzi do utraty informacji
        Gdy np. przekrocze typ int przy konwersji moze pokazac wartosc -1
        Komnwersji moge uzyc gdy chce obiciac reszte z liczby zmiennoprzecinkowej
         rzutujac np double na int
         int intValue = (int) 123.123F;
        Moge to zrobic takze przez przypisanie zmiennej float do int
         float x = 10.2F; int y = x;
        double>float>long>int hierarchia gdy wykonuje np operacje artmetyczne
         i jeden z argumanetow bedzie innego typu

        UNBOXING:
        int zmienna = new Integer(123);
        przypisanie do zmiennej prostej - zmiennej obiektowej
        BOXING:
        Integer zmienna = 10;
        przypisanie do zmeinnej obiektowej - zmiennej prostej



        //TYPY GENERYCZNE
        /*
        Typ generyczny jest szablonem pozwalajacym uniknac rzutowania
        Kazda tablice obiektow mozna uogolnic do Object lecz wszystko
         trzeba bedzie rzutowac
         */
        class Apple{
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
            // (apple/Orange)
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

            FruitBox fruitBox = new FruitBox(new Orange());
            //Uogolniam przyjmowany typ do Object aby mogl przyjac obiekt
            // Apple oraz Orange lecz wywolujac metode getFrui() chcac
            // dostac sie do pola musze rzutowac
            Orange fruit1 = (Orange) fruitBox.getFruit();


        class BoxOnSteroids<T> {
            public T fruit;
            public BoxOnSteroids(T fruit) {
                this.fruit = fruit;
            }
            public T getFruit() {
                return fruit;
            }
        }

        BoxOnSteroids<Apple> BoxOnSteroidsApple = new BoxOnSteroids<Apple>(new Apple());
        //<T> jest parametrem - moze on przyjac tylko typ Obiektowy
        //Parametryzuje typ generyczny T poprzez ustawienie go jako konkretnej
        // klasy np Apple
        //Uzywam typu generycznego aby nie powtrzac kodu jak w klasach
        // OrangeBox oraz AppleBox
        //Dzieki temu wywolujac metode getFruif() mam gwarancje ze zwrocony
        // zostanie poprawny obiekt
        //Nie musze w <> wpisywac ponownie Apple przy wywolaniu konstruktora
        // BoxOnSteroidsk
        //Moge takze stworzyc obiekt tej klasy bez deklaracji typu generycznego
        //BoxOnSteroids boxWithoutType = new BoxOnSteroids(new Apple());
        BoxOnSteroids<Apple> BoxOnSteroidsApple2 = new BoxOnSteroids<>(new Apple());
        BoxOnSteroids<Orange> BoxOnSteroidsOrange = new BoxOnSteroids<>(new Orange());

        Orange fruit = BoxOnSteroidsOrange.getFruit();
        //Moge skorzystac z metody bez rzutowania!


        BoxOnSteroids boxWithoutType = new BoxOnSteroids(new Apple());
        //Tworze obiekt bez deklaracji typu generycznego

        BoxOnSteroids<Apple> boxWithApple = boxWithoutType;
        BoxOnSteroids<Orange> boxWithOrange = boxWithoutType;
        //Przypisuje obiekt Apple do typu generycznego Orange aby zmienic go
        // z Object na Apple lub Orange
        //Jest to mozliwe - lecz gdy bede chcial przypisac obiekt do
        // referencji innej klasy niz jest jest obiekt wyrzuci
        // wyjatek ClassCastException

        Apple apple = boxWithApple.getFruit();
        //Przypisuje boxWithoutType z obiektem Apple typu Object
        // na boxWithApple z typem Apple. Jest to poprawne poniwaz
        // obiekt zawiera typ Apple

        //Orange orange = boxWithOrange.getFruit(); // wyjatek ClassCastException
        //Jest blad poniewaz boxWithOrange posiada obiekt typu Apple


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

        Pair<BoxOnSteroids<Apple>,BoxOnSteroids<Orange>> para = new Pair<>(
                new BoxOnSteroids<>(new Apple()),
                new BoxOnSteroids<>(new Orange())
        );


        //Extends
        /* - implementacja na koncu
        interface Figura{
            String dajNazwe();
        }
        */
        class Kolo implements Figura{
            @Override
            public String dajNazwe() {
                return "kolo";
            }
        }
        class pudelkoFigur <T extends Figura>{
            //Nie musze implemenetowac metod z int Figura!!
            //Klasa parametryzujaca T musi rozszerzac Figure lub rozszerzac
            // klase ktora go implementuje !!
            // wiec bede mogl na polu z paramtrem T wywolac
            // metody z tego interfejsu ktore nadpisza
            // parametryzujace klasy!
            private T figura;
            public pudelkoFigur(T figura){
                this.figura = figura;
            }
            public T getFigura() {
                return figura;
            }
            public String dajNazwe(){
                return figura.dajNazwe();//!!
                //Wywola metode dajNazwe z klasy ktorej bedzie
                // parmatryzowac typ generyczny czyli np. Kolo!!
            }
        }
        pudelkoFigur<Kolo> kola = new pudelkoFigur<>(new Kolo());
        kola.dajNazwe();
        //Gdy parametr klasy generycznej jest ograniczony do klasy/interfejsu
        // to moge na atrybucie klasy generycznej typu generycznego wywolac
        // metode klasy/interfejsu ktorego ogranicza typ generyczny

        //pudelkoFigur<Apple> jablka = new pudelkoFigur<Apple>(new Apple());
        //Blad kompilacji - Apple nie implementuje Figury ani nie rozszerza
        // klasy implementujacych go!!


        //Dziedziczenie klas generycznych
        class Prostokat implements Figura{
            @Override
            public String dajNazwe() {
                return "prostokat";
            }
        }
        class Kwadrat extends Prostokat{
            //Nie musze implementowac metod figury
            public String dajNazwe(){
                return "kwadrat";
            }
        }
        Prostokat p1 = new Kwadrat();//moge bo rozszerza
        pudelkoFigur<Prostokat> p3 = new pudelkoFigur<>(new Prostokat());

        //pudelkoFigur<Prostokat> p4 = new pudelkoFigur<Kwadrat>(new Kwadrat());
        //Blad - nie moge przypisac tak referncji - paramtryzowanie innym typem
        // nawet jesli rozszerza typ!!

        pudelkoFigur<Prostokat> p2 = new pudelkoFigur<>(new Kwadrat());
        //Ale po mimo tego ze parametryzuje go typem Prostokat to mege przypisac
        // obiekt Kwadrat poniwaz dziedziczy
        System.out.println("p2 daj nazwe: "+p2.dajNazwe());//Da kwadrat tylko
        // dlatego ze metoda Prostokata jest nadpisywana
        System.out.println(p2.getClass()); //da pudelkoFigur tylko


        class ZwyklePudelko<T>{
            private T zmienna;
            ZwyklePudelko(T zmienna){
                this.zmienna=zmienna;
            }
            public T getZmienna() {
                return zmienna;
            }
        }
        class InnePudelko<T> extends ZwyklePudelko<T>{
            public InnePudelko(T zmienna){
                super(zmienna);
            }
            void powiedzCos(){
                System.out.println("moje "+getZmienna()+" jest super");
            }
        }
        InnePudelko<String> ip = new InnePudelko<>("cos");
        ip.powiedzCos();
        InnePudelko<Apple> ip2 = new InnePudelko<>(new Apple());
        ip2.powiedzCos();
        //pokaza "moje SamouczekProgramisty.Wstep$1Apple@7921b0a2 jest super"


        //Metody z argumentami Generycznymi - WILDCARDS
        class InnePudelko2<T>{
            private T zmienna;
            InnePudelko2(T zmienna) {
                this.zmienna=zmienna;
            }
            public void metoda1(InnePudelko2<?> pudelko2){
                Object o = pudelko2.zmienna;
                //<?> parametryzujac moge tylko przypisac
                // przyjety obiekt (pudelko2) tylko do typu
                // Object poniewaz tylko on gwarantuje ze kazdy
                // przyjety typ bedzie zgodny
                //Nie moge dac typu wyzej np Apple poniewaz
                // gdy uzytkownik poda Apple bedzie zgodne lecz
                // gdy podam String juz wystapi blad !
                System.out.println("daj obiekt metody1: "+o);
            }
            public void uzyjeMetody1(){
                metoda1(new InnePudelko2<>(new Apple()));
                //w main InnePudelko2<?> pudelko3 =
                // new InnePudelko2<>(new Apple());
                metoda1(new InnePudelko2<>(new Kwadrat()));
                metoda1(new InnePudelko2<>(new Object()));
            }
        }
        InnePudelko2<Object> pudelko4 = new InnePudelko2<>(new Object());
        InnePudelko2<Apple> pudelko5 = new InnePudelko2<>(new Apple());
        pudelko4.zmienna = new Apple(); //poprawne dla referencji Object
        // poniewaz jest ona wyzej
        pudelko5.zmienna = new Apple();

        //Parametryzujac <?>
        InnePudelko2<?> pudelko3 = new InnePudelko2<>(new Apple());
        InnePudelko2<?> pudelko2 = new InnePudelko2<>("napis");
        pudelko2.zmienna = null;
        //pudelko2.zmienna = "costam";

        pudelko3.zmienna = null;
        //pudelko3.zmienna = new Apple(); //nawet jesli jest w nim
        // Apple

        //Klasa parametryzowana <?> - jej pola typu tego parametru moga
        // przyjac tylko null!! i moge je przypisac do pol typu Object
        // poniewaz <?> jest typem nieokreslonym klasy a kazda klasa
        // dziedziczy po Object a kompilator musi miec gwaracje w metodzie
        // ze bede przypisywal referencje do wlasciwego typu


        //f(klasa<? extends Figure> obiekt) - “upper bound”
        //W takim przypadku moze przyjac tylko obekt klasy Figura badz
        // dziedziczaca ja bezposrenio lub posrenio
        // InnePudelko3<Prostokat>, InnePudelko3<Kwadrat> czyli w dol

        //f(klasa<Figura> obiekt) - W takim przypadku moge dac tylko parametryzowany
        // obiekt klasy Figura - InnePudelko3<Figura>

        class InnePudelko3<T>{
            private T zmienna;
            public InnePudelko3(T zmienna){
                this.zmienna=zmienna;
            }
            public T getZmienna() {
                return zmienna;
            }
            public void setZmienna(T zmienna) {
                this.zmienna = zmienna;
            }
            public void metoda1(InnePudelko3<? extends Figura> obiekt){
                //Zmienna tymczasowa obiekt moze byc teoretycznie najwyzej typu
                // Figura wiec moge przypisac go tylko do klasy Figura lub "nizej"
                // czyli tylko Object dlatego ze kompilator musi miec pewnosc
                // ze przypisze w metodzie referencje do dobrego typu
                // (moge wyslac Kwadrat ale i Figur) o czym kompilator
                // nie wie
                Object o = obiekt.getZmienna();
                Figura f = obiekt.getZmienna();
                Kwadrat k = (Kwadrat) obiekt.getZmienna();
                //Musze rzutowac poniewaz nie mam pewnosci czy nie przysle
                // np Figury

                //obiekt.setZmienna(new Prostokat());
                //Blad przypisania wartosci
                // moze przyjac tylko null
                //Zmienna lokalna "obiekt" TERETYCZNIE moze byc tylko typu
                // Figura a nie "wyzej" wiec nie moge przypisac do tej zmiennej
                // Prostokatu lub kwadratu a kompiltaor w metodzie musi
                // miec pewnosc przypisania dobrej referncji CHYBA ze zrobie
                // rzutowanie!
            }
            public void metoda2(InnePudelko3<Figura> obiekt){
                Object o = obiekt.getZmienna();
                Figura f = obiekt.getZmienna();
            }
        }
        InnePudelko3<Figura> test = new InnePudelko3<>(new Prostokat());

        //<? extends Figura> moze przyjac klasy dziedziczace Figure
        InnePudelko3<Object> x5 = new InnePudelko3<>(new Object());
        InnePudelko3<Figura> x2 = new InnePudelko3<>(new Kwadrat());
        InnePudelko3<Prostokat> x3 = new InnePudelko3<>(new Kwadrat());
        InnePudelko3<Kwadrat> x4 = new InnePudelko3<>(new Kwadrat());

        //test.metoda2(x5); //blad - KLASA WYZEJ
        test.metoda1(x2);
        test.metoda1(x3);
        test.metoda1(x4);

        test.metoda2(x2);
        //test.metoda2(x3); - blad moze byc tylko typ parametru figura
        // (InnePudelko3<Figura>)


        //f(klasa<? super Prostokat> obiekt) - “lower bound”
        //Ta metoda moze operwac tylko na obiektach typu klasy WYZEJ Prostokatu
        // tzn InnePudelko4<Object>,<Figura>,<Prostokat>
        class InnePudelko4<T> {
            private T zmienna;
            public InnePudelko4(T zmienna) {
                this.zmienna = zmienna;
            }
            public T getZmienna() {
                return zmienna;
            }
            public void setZmienna(T zmienna) {
                this.zmienna = zmienna;
            }
            public void metoda1(InnePudelko4<? super Prostokat> obiekt){
                Object o =  obiekt.zmienna;//tylko dla klasy Object mam
                // pewnosc ze nie zostanie przyslane nic wyzej !!

                //Prostokat p = (Prostokat) obiekt.zmienna;
                //Uzytkosnik moze wyslac typ Object wiec ew musialbym rzutowac!!
                //WYRZUCI WYJATEK!!!
                //Kwadrat k = (Kwadrat) obiekt.zmienna;
                //Podownie tutaj

                obiekt.setZmienna(new Prostokat());
                obiekt.setZmienna(new Kwadrat());
                //Moge przypisac poniewaz przyslany typ na pewno bedzie
                // wyzej niz klasy z rodziny Prostokatu
                //obiekt.setZmienna(new Kolo()); //inny typ
                //obiekt.setZmienna(new Object()); //klasa wyzej
                obiekt.setZmienna(null);
            }
        }
        InnePudelko4<Prostokat> test2 = new InnePudelko4<>(new Prostokat());

        InnePudelko4<Object>x9 = new InnePudelko4<>(new Object());
        InnePudelko4<Figura>x10 = new InnePudelko4<>(new Prostokat());
        InnePudelko4<Prostokat>x6 = new InnePudelko4<>(new Prostokat());
        InnePudelko4<Prostokat>x7 = new InnePudelko4<>(new Kwadrat());
        InnePudelko4<Kwadrat>x8 = new InnePudelko4<>(new Kwadrat());

        test2.metoda1(x9);
        test2.metoda1(x10);
        test2.metoda1(x6);
        test2.metoda1(x7);
        //test2.metoda1(x8); // klasa WYZEJ



        //POROWNYWANIE TYPOW PROSTYCH
        /*
        Sluzy do tego operato == lub !=

        Operator +/-/* ma wiekszy priorytet niz ==
        2+3==10 // najpierw doda a potem porowna

        Nalezy nie laczyc operaci sumownia tekstu + i porownywania dlatego
         ze pierwszenstwo mialoby dodawania a nie mozna tego zrobic z teksem
         dletego ze porownywalibysmy String z int!!
        "10 == 10: " + 10 == 10 // compilation error!
        "10 == 10: " + (10 == 10)

        Liczby zmienno przyecinkowe porownujemy poprzez odjecie
         ich od siebie w wartosci bezwzglednej a nastepnie sprawdzenie czy
         sa one wieksze od liczby 0.0..1 w zaleznosci od jakiej dokladnosci
         chcemy
        Math.abs(0.3 - (0.1 + 0.2)) < 0.000001)

        //POROWNYWANIE OBIEKTOW
        /*
        String jest charakterystycznym obiektem poniewaz ta sama jego wartosc
         jest alokowana w tym samym adresue GDY PRZYPISUJE GO POPRZEZ =
         */
        String napis1 = "test";
        String napis2 = "test";
        String napis3 = new String("test");
        //Tutaj rezerwuje specjalnie oddzielnie miejsce w pamieci

        System.out.println("Porownanie napis1 i napis2: "+(napis1==napis2));
        //Pamietam o nawiasie bo inaczej doda moj "" do napis1 a nastepnie
        // porowna z napis2
        System.out.println("Porownanie napis1 i napis3: "+(napis1==napis3));

        //Porownujac zmienne obiektowe poprzez == porownuje ich adresy!!


        //METODA EQUALS i HASHCODE
        /*
        Jest ona w klasie Object wiec mozemy ja wywolac na kazdym obiekcie ze
         wzgledu na dziedziczenie kazdej klasy z Object
        Domyslna implementacja metody equals zachowuje sie jak ==
         */
        class Krzeslo{
            String producent;
            int dataProdukcji;
            double waga;
            Krzeslo(String producent, int dataProdukcji, double waga){
                this.producent = producent;
                this.dataProdukcji = dataProdukcji;
                this.waga = waga;
            }
            @Override
            public boolean equals(Object obj) {
                if(obj == null)
                    return false;
                //Zamiast sprawdzania instance of moge sprawdzic czy metoda
                // getClass() wywolana na obu obiektach zwroci ta sama
                // wartosc
                //if(obj.getClass() != this.getClass())
                //    return false;
                //Musze zrobic to porownanie aby miec pewnosc czy nie zostanie
                // wyrzucony wyjatek ClassCastException
                if(obj instanceof  Krzeslo){
                    Krzeslo k = (Krzeslo)obj;
                    return this.producent.equals(k.producent) &&
                            this.dataProdukcji==k.dataProdukcji &&
                            Double.compare(this.waga, k.waga)==0;
                            //Metoda compare z klasy double zwraca
                            // 0 gdy oba sa rowne
                }
                else return false;
            }
            @Override
            public int hashCode() {
                return Objects.hash(producent,dataProdukcji,waga);
                //W nawiasie wpisuje zmienne do sprawdzenia
                //Moge takze pomozyc wybrane pola przez liczbe pierwsza i
                // dodac do siebie
                //retrun 17*producent.hashCode()+7*dataProdukcji.hashCode();
            }
        }
        Krzeslo k1 = new Krzeslo("BRW", 2010, 12.5);
        Krzeslo k2 = new Krzeslo("BRW", 2010, 12.5);
        Krzeslo k3 = new Krzeslo("BRW", 2010, 13);
        System.out.println("Porownuje krzeslo k1 z k2: "+k1.equals(k2));
        System.out.println("Porownuje krzeslo k2 z k3: "+k2.equals(k3));
        System.out.println("Porownuje krzeslo k1 z k3: "+k1.equals(k3));


        //KOLEKCJE
        /*
        Kolekcja to sposob grupownia obiektow, jest ona struktura danych
        lang.Iterable -> util.Collection -> util.List, util.Set, util.Queue
        util.Map


        //Lista
        Charakteryzuje sie tym ze jej rozmiar moze sie zmieniac, dobra praktyka
         jest dlekarowanie ich jako typ List (ArrayList,LinkedList) aby
         mozna byloby je potem bez problemu zmienic jedna na druga

        -Moga przechowywac ten sam obiekt kilka raz
        -Kolejnosc jest wazna

        Dzielimy je na:
        -LinkedList - gdy chce czesto dodawac/usuwac elementy
        -ArrayList - gdy chce  czesto miec dostep do elementow
         */

        //Deklaracja
        List<String> lista1 = new ArrayList<>(3);
        //Tylko w ArrayList moge podac wstepny rozmiar
        List<String> lista2 = new LinkedList<>(lista1);
        //W konstrukotrze LinkeList moge podac inna kolekcje
        // aby zostala ona przpisana do nowej LinkedLIsty

        //Metdoy:
        lista1.add("kamil"); // dodanie elementu
        lista1.add(1,"kamil");
        lista1.addAll(lista2);// dodanie wszystkich elementow z jednej kolekcji
        // do drugiej, nie nadpisze istenijacych tylko polaczy obie listy jedna
        // po drugiej
        lista1.remove("Tomek");
        lista1.remove(0);
        String wezElement = lista1.get(0);// pobierze element z pozycji 0 listy
        boolean czyZawiera = lista1.contains("kamil");// zwraca flage czt kolekcja
        // zawiera dany element
        boolean czyPusta = lista1.isEmpty();// zwraca flage czy lista jest pusta
        int liczbaElementow = lista1.size();// zwraca liczbe elementow w liscie
        // nie jaki jest rozmiar wstepny (w przypadku ArrayList)
        int pierwszeWystapienie = lista1.indexOf("kamil");
        int ostatnieWystapienie = lista1.lastIndexOf("kamil");


        //Zbior
        /*
        Sluzy do przyechowywania unikalnych elementow, mozemy wykorzystac je
         takze aby pozbyc sie duplikatow a Liscie dodajac wszystkie elementy
         do nowego zbioru.

        -Kolejnosc nie jest istotna
        -Kazdy element jest unikatowy

        Aby miec pewnosc ze element jest juz w zbioerze nalezy zaimpelementowac
         metode hashCode oraz Equals

        Zbiory dzielimy na
        -HashSet
        -TreeSet
        -LinkedHashSet
         */

        //Deklaracja
        Set<String> zbior1 = new HashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar
        Set<String> zbior2 = new TreeSet<>(zbior1);
        //Konstruktor moze przekopiowac kolekcje do nowej
        Set<String> zbior3 = new LinkedHashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar

        //Metody:
        zbior1.add("kamil");
        zbior1.addAll(zbior2);
        zbior1.remove("kamil");
        boolean czyZawiera2 = zbior1.contains("Kamil");
        boolean czyPusta2 = zbior1.isEmpty();
        int iloscElementow = zbior1.size();


        //Mapy
        /*
        -Kolejnosc nie jest istotna
        -Kazdy element jest unikatowy

        Mapa jest kolekcja pozwalajaca przechowywac odwzorowanie zbioru
         kluczy na liste wartosci. Klucze sa unikalne. Kluczami pownny byc
         obiekty ktorych nie mozna zmienic (Immutable) czyli np String
         lub Integer.
        Klasy kluczy powinny miec poprawna implementacje metod HashCode oraz
         equals.
        Dodanie istniejacego klucza do kolekcji z wartoscia nadpisze istniejaca
         wartosc starego klucza na nowa.

        Mapy dzielimy na:
        -HashMap
        -TreeMap
        -LinkedHashMap
         */

        //Deklaracja
        Map<Integer, String> mapa1 = new HashMap<>(2);
        //Konstruktor zawiera wstepny rozmiar
        Map<Integer, String> mapa2 = new TreeMap<>(mapa1);
        //Konstruktor moze przkopiowac mape
        Map<Integer, String> mapa3 = new LinkedHashMap<>(23);
        //Konstruktor zawiera wstepny rozmiar

        //Metody:
        mapa1.put(0,"kamil");
        mapa1.putAll(mapa2);
        mapa1.get(0);// zwroci wartosc z klucza "0"
        mapa1.remove(0);// usunie klucz "0" i jego wartosc
        boolean czyKluczIstanieje = mapa1.containsKey(0);// czy mapa zawiera
        // klucz "0"
        boolean czyWartoscInsteniej = mapa1.containsValue("kamil");
        boolean czyPusta3 = mapa1.isEmpty();
        int iloscElementow2 = mapa1.size();
        Set<Map.Entry<Integer,String>> zbiorKluczWartosc = mapa1.entrySet();
        //Zwroci klucze i wartosci do zbioru przechowywyjacego go

        //Iterowanie
        mapa1.put(0,"kamil");
        mapa1.put(1,"tomek");
        for (Integer x : mapa1.keySet()){
            System.out.println(x +": "+ mapa1.get(x));
        }
        for (String x :mapa1.values()){
            System.out.println(x);
        }
        Set<Map.Entry<Integer,String>> zbiorKluczWartosc2 = mapa1.entrySet();
        for(Map.Entry<Integer,String> x : zbiorKluczWartosc){
            System.out.println(x.getKey()+": "+x.getValue());
        }



        //OPERACJE NA PLIKACH:
        /*
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

        Tryby dosteou do plikow dzieliy na:
        -do odczytu
        -do zapisu - kasuje plik jesli istnieje i utworzenie nowego lub
          utowrzenie nowego jesli nie istnieje - domyslny tryb
        -w trybie dolaczania - dopisuje do istniejacego pliku nowa wartosc


        Klasa File zawiera postawowe operacje na plikach i przyjmowana jako
         parametr moze posluzyc do utworzenia unstancji innej klasy np:
        -FileReader - odczyt pliku znak po znaku
        -BufferReade - odczyt linijka po linijce
        new BufferedReader(new FileReader(new File("/path/to/text/file.txt")));

        Jest to dostanie sie do pliku "warstwa po warstwie"
        Mozna wykorzystac do tego konstruktory nie tworzac instancji klasy File
        new BufferedReader(new FileReader("/path/to/text/file.txt"));

        Klasy plikow maja wskaznik ktory po odczytaniu danych zostaje przesuniety
         na miejsce gdzie ostatnio czytalismy plik

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

        -DataOutputStrea - zapis binarny do pliku tekstowego
        DataOutputStream strumienWyjsciowy = new DataOutputStream(new FileOutputStream(lokalizacja2));
        //FileOutputStream zapisuje dane bajt po bajcie
        //DataOutputStream zapewnia bunarny zapis typow prymitywnych
        strumienWyjsciowy.writeInt(12355);
        //Ta metoda zapisze typy proste jak int w sposob binarny
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
    class Wew34{///////////////////////////////////////////////
    void metoda() throws IOException {/////////////////////////
        String lokalizacja = "/folder1/plik.txt";
        int liczba = 2134;
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(lokalizacja);
            fileWriter.write(Integer.toString(liczba));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null)
                fileWriter.close();
        }

        String lokalizacja2 = "/folder1/plik.txt";
        int liczba2;
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(lokalizacja2));
            String napis = fileReader.readLine();
            liczba2 = Integer.parseInt(napis);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
    }///////////////////////
    }///////////////////////

        //Obsluga plikow binarnych
    class Wew52{////////////////////////////////////////////
    void metoda() throws IOException {//////////////////////
        //ZAPIS:
        String lokalizacja2 = "/folder1/plik.txt";
        int liczba = 2134;
        DataOutputStream strumienWyjsciowy = null;
        try{
            strumienWyjsciowy = new DataOutputStream(new FileOutputStream(lokalizacja2));
            strumienWyjsciowy.writeInt(liczba);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(strumienWyjsciowy != null)
                strumienWyjsciowy.close();
        }
        //ODCZYT
        int liczba2;
        DataInputStream strumienWejsciowy = null;
        try{
            strumienWejsciowy = new DataInputStream(new FileInputStream(lokalizacja2));
            liczba2 = strumienWejsciowy.readInt();
        }finally {
            if(strumienWejsciowy != null)
                strumienWejsciowy.close();
        }
    }/////////////////////////////////////////////////
    }/////////////////////////////////////////////////



        //TRY WTIH RESOURCES
        /*
        boilerplate code - powtarzenie kodu
        try-with-resources - cukier syntaktyczny - syntactic sugar

         */
    class Wew71{/////////////////////////////
    void metoda(){//////////////////////////
        BufferedReader fileReader = null;
        String inputPath = "plik.txt";
        try {
            fileReader = new BufferedReader(new FileReader(inputPath));
            fileReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //Mozna zastapic to:
        try(BufferedReader fileReader2 = new BufferedReader(new FileReader(inputPath))) {
            //Deklaruje zmienna fileReade2 w bloku try ktora zostanie automatycznie
            // zamknieta
            fileReader2.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Oprocz tego moge stworzyc zagniezdzony blok try/catch aby takze
        // nie uzywac metody close();
        //Moge uzyc w nim deklaracji try w () kilku zmiennych np do odczyctu pliku i zapisu
        // a nastepnie w ciele try skorzystac z nich
        String outputPath = "plik.txt";
        try(BufferedReader fileReader3 = new BufferedReader(new FileReader(inputPath));
            BufferedWriter fileWriter3 = new BufferedWriter(new FileWriter(outputPath)))
        {
            String line = fileReader3.readLine();
            fileWriter3.write(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Calosc dziala poniewaz klasy BufferedReader i BufferedWriter implementuja
        // interfejs java.lang.AutoCloseable
        //Wszytskie klasy do obslugi strumieni implementuja ten interfejs, aby to
        // dzialalo zmienne musza byc umieszczone w () w konstukcji try/catch

        //Moge stworzyc takze wlasne dzilanie klasy AutoCloseable !
        class MojContextManager implements AutoCloseable{
            public MojContextManager(String s){
                System.out.println("tworze "+s);
            }
            public void zrobCos(){
                System.out.println("robie cos");
            }
            @Override
            public void close() {
                System.out.println("zamykam");
            }
        }
        class MojContextManagerMain {
            public void main(String[] args) {
                try (MojContextManager manager = new MojContextManager("cos")) {
                    manager.zrobCos();
                    //wywola sie:
                    //tworze cos
                    //robie cos
                    //zamykam
                }
            }
        }
    }/////////////////////////////////
    }///////////////////////////////////



        //SERIALIZACJA
        /*
        Serializacja to binarny zapis drzewa obiektow
        Zserializowane obiekty mozna przeslac i zdeserializowac na innej
         maszynie wirtualnej tworzac nowe obiekty - obie maszyny musze miec
         dostep do skompilowanych wersji klas

        Aby klasa mogla byc seriaizowana musi implmemntowac intefejs znacznikowy
         (nie posiadajacy zadnej metody) java.io.Serializable ktory ma za zadanie
         informowac ze instancje tej klasy moga byc serializowane
        Jesli zserializuje instanjce klasy bez tego interfejsu zostanie wyrzucony wyjatek
         NotSerializableException.

        WYMOGI:
        Klasa ktora jest rozszerzana przez klase ktora bedzie serializowana MUSI
         miec konstrukotr bezparametrowy!
        public class Fruit {} //klasa musi miec konstr. bezparam.
        public class Apple extends Fruit implements Serializable {}//nie musi miec
        // konstr. bezparam.
        public class Tomato implements Serializable {}//nie musi miec konstr. bezparam.
        // bo dziecziczy po object ktora posiada konstr. bezparametrowy

        Wymagana jest kolejnosc serializacji zgodna z deserializacja. Jesli dodaje
         do strumienia najpierw liste a potem zmienna int to w deserializacj najpierw
         bede musial odczytac liste a potem obiekt bo inaczej wyrzuci wyjatek
         java.io.OptionalDataException

        Transient
        Gdy chcemy aby jakis pole klasy nie bylo serializowane np sekundy
         od urodzenia osoby - wynik zdeserializowany na innej JVM bylby
         bledny uzywamy przez zmienna parametru transient

         */
    class Wew25 {//////////////////////////////////
    void metoda(){///////////////////////////////////
        try(ObjectOutputStream strumienWyjsciowy = new ObjectOutputStream(new FileOutputStream("plik.bin"))){
            strumienWyjsciowy.writeObject(Integer.valueOf(4321));
            //Zapisuje obiekt do stumienia metoda writeObject ktora zapisuje ta
            // zmienna jako Object wiec w odzycie bede musial RZUTOWAC!!
            //Ta metoda moze przyjac wszystko
            strumienWyjsciowy.writeObject(Integer.parseInt("1234"));
            //moge takze uzyc metody writeInt aby zamisac zmienne jako int
            strumienWyjsciowy.writeInt(1234);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream strumienWejsciowy = new ObjectInputStream(new FileInputStream("plik.bin"))){
            Integer numer = (Integer)strumienWejsciowy.readObject();
            //Odczytuje pierwszy OBIEKT i zapisuje go do zmiennej obiektowej
            // musze rzutowac poniewaz jest to typ Object - metoda readObject();
            //Obiekty/zmienne zostaja zapisane w kolejnosci w jakiej byly dodane czyly 1,2
            System.out.println("numer 1: "+numer);
            numer = (Integer)strumienWejsciowy.readObject();
            System.out.println("numer 2: "+numer);
            int zmiennaInt = strumienWejsciowy.readInt();
            //odczytuje zmienna metoda readInt wiec nie musze rzutowac
            System.out.println("zmienna INT: "+zmiennaInt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }///////////////////////////
    }////////////////////////
        Wew25 wew25 = new Wew25();
        wew25.metoda();


        //Serializacja drzewa obiektow
        //Obiekt serializowany i zdeserializowany beda mialy inny adres referncji
        class Opona implements Serializable{
            int rozmiar;
            public Opona(int rozmiar){this.rozmiar=rozmiar;}
            public int getRozmiar() {
                return rozmiar;
            }
        }
        class Silnik implements Serializable{
            String nazwa;
            public Silnik(String nazwa){this.nazwa=nazwa;}
            public String getNazwa() {
                return nazwa;
            }
        }
        class Samochod implements Serializable{
            Opona[] opony;
            Silnik silnik;
            public Samochod(Silnik silnik, Opona[] opony){
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
        class Fabryka{
            void main(){
                Opona[] opony = new Opona[]{new Opona(12),new Opona(15)};
                Silnik silnik = new Silnik("Diesel");
                Samochod serializowanySamochod = new Samochod(silnik,opony);
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream("obiekty.bin"))){
                    strWyj.writeObject(serializowanySamochod);
                    //Zapisuje obiekt
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream("obiekty.bin"))){
                    Samochod zdeserializowanySamochod = (Samochod)strWej.readObject();
                    System.out.println(zdeserializowanySamochod.getSilnik().getNazwa());
                    //Na obiekcie zdeser. wywoluje metode getSilinik bo jest typu Samochod
                    // i zwraca ona obiekt Silnik a potem moge na nim wywolac metode
                    // getNazwa z klasy Silnik
                    System.out.println(zdeserializowanySamochod.getOpony().length);
                    //Tutwaj mam tablice wiec moge wywolac tylko jej dlugosc
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        Fabryka f = new Fabryka();
        f.main();


        //Zachowanie atrybytow transient oraz static po deserializacji
        /*
        W przypadku serializowania pol statycznych beda one po serializacji mialy taka
         sama wartosc jak w deklaracji pola klasy poniewaz dotycza one klasy a nie obiektu
         UWAGA ! w jednym main jesli zrobimy serializacje i deserializacje pola statycznego
         ze zmiana w obiekcie - pokaze po deserializacji takze zmieniona wartosc
         */
        class Czlowiek implements Serializable{
            private transient Integer identyfikator;
            private transient int wiek;
            private String imie;
            public Czlowiek(int wiek, String imie, Integer identyfikator){
                this.wiek = wiek;
                this.imie = imie;
                this.identyfikator = identyfikator;
            }
            public String getImie() {
                return imie;
            }
            public int getWiek() {
                return wiek;
            }
            public Integer getIdentyfikator() {
                return identyfikator;
            }
        }
        class CzlowiekFabryka{
            void main(){
                Czlowiek c1 = new Czlowiek(20,"kamil", 2314);
                //Nadaje wartosc takze polu transient int wiek;
                // oraz transient Integer (zmienna obiektowa)
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream("c1.bin"))){
                    strWyj.writeObject(c1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream("c1.bin"))){
                    Czlowiek c2 = (Czlowiek) strWej.readObject();
                    System.out.println(c2.getImie());
                    System.out.println(c2.wiek);
                    //Po deserializacji wartosci pola transient int wynosi 0
                    // nawej jesli podczas deklaracji pola w klasie nadamy jemu
                    // wartosc a nie po utworzeniu obiektu
                    System.out.println(c2.getIdentyfikator());
                    //Natomiast zmiennej obiektowej Integer wynosi null
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        CzlowiekFabryka faabryka = new CzlowiekFabryka();
        faabryka.main();


        //Specjalna obsługa serializacji/deserializacji
        /*
        Moge dodac wlasne metody readObject oraz writeObject aby zmodyfikowac
         jak ma byc serializowany OBIEKT metoda writeObject(obiekt) tzn
         jakie jego pola maja byc serializowane!

        W zaleznosci od ilosci pol klasy moge dodac do strumienia pojedyncze jej
         pola - w takim przypadku na strumieniu WYJSCIA wywoluje konkretna metode:
         strWyj.writeUTF(stringTans); / strWyj.writeInt(liczba+10); itp
        Jesli we wlasnej metodzie writeObject dodam do strumienia pole transient, ono takze
         zostanie zserializowane
        Analogicznie w metodzie deserializacji readObject:
         zmienna = strWej.readInt(); - nie musze deklarwoac zmiennej poniweaz
         mam dostep do pol danej klasy i przypisuje im pola nadane w metodzie writeObject.

        Moge takze zachowac standardowe dodawanie obieku do strumienia dodajac metode
         strWyj.defaultReadObject(); to automatycznie wszystkie pola obiektu zostana
         dodane do stumienia.
        Analogicznie w metodzie deserializacji readObject BEDE MUSIAL dodac:
         strWej.defaultReadObject();

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
         mogl w takim przypadku dostac sie do niej w bloku try w deserializacji. Dodanie
         do strumienia zmiennej metoda writeInt nie ma nic wspolengo z moja metoda
         writeObject()!!
         Zmienne dodane w metodzie writeObject sa dostepne tylko w metodzie readObject!!

        Natomiast w deserializacji (blok try w metodzie) w takim przypadku moge tylko
         wyciagnac ze struminia obiekt/zmienne dodane tylko w bloku try serializacj
         a nie w metdozie writeOject! i zapisac go do nowego obieku -
         Silnik = (Silnik)strWej.readObject(); chyba ze w bloku try dodalem dodatkowo do
         strumienia zmienna np int - strWyj.writeInt(12354); to w deserializacji
         bede mogl sie do niej odwolac - int nowaZM = strWej.readInt();


        Moge wykorzystac to na przykladzie gdy bede chcial zapisac do strumienia aktualny wiek
         i po zdeserializowniu otrzymac aktualny wiek zgodny z aktualnym rokiem

         w metodzie writeObject:
         strWyj.defaultWriteObject(); - zapisuje standardowe dane obiektu
         int wiekUrodzenia = Calendar.getInstance().get(Calendar.YEAR) - wiek
          //odejmuje od aktualnego wieku serializacji - wiek zapisanego obiektu (27)
          // i wychodzi 1991
         strWyj.writeInt(wiekUrodzenia) - zapisuje dodatkowo do strumienia zmienna

         w metodzie readObject:
        strWej.defaultReadObject(); - wczytuje standardowe dane obiektu - wszystkie pola
         obiektu klasy jesli zostanie on dodany do strumienia
        int wiek = Calendar.getInstance().get(Calendar.YEAR) - strWej.readInt();
        //Tworze zmienna lokalna i odejmuje w niej aktualny rok od roku urodzenia
        // zapisanego do strumienia w metodzie writeObject. dostaje sie do niego
        // metoda strWej.readInt() - nie musze podawac nazwy bo dane wyciagane
        // sa w kolejnosci dodania - musze o niej pamietac oraz rodzaju zmiennej
        // aby uzyc poprawnej metody na strumieniu wejsciowym
         */
        class SerializacjaUnikalna implements Serializable{
            private transient String stringTans;
            private String stringNormalny;
            private int liczba;
            public SerializacjaUnikalna(String stringTans, String stringNormalny, int liczba){
                this.stringTans = stringTans;
                this.stringNormalny = stringNormalny;
                this.liczba = liczba;
            }
            private void readObject(ObjectInputStream strWej) throws IOException, ClassNotFoundException {
                stringTans = strWej.readUTF(); //mam dostep do pol klasy wiec nie musze ich deklarowac
                stringNormalny = strWej.readUTF();
                liczba = strWej.readInt();
                //Dodajew szystkie przyspisania do pol klasy ale moge zrobic to jedna metoda
                // strWej.defaultReadObject(); - jest to standardowa metoda dzialania metody
                // readObject jesli jej nie zadeklaruje czyli dodanie wszystkich pol obiektu
                // klasy do strumienia OBIEKTU
            }
            private void writeObject(ObjectOutputStream strWyj) throws IOException {
                //Na poczatku moge dodac strWyj.defaultWriteObject() aby
                // zostal zapisany obiekt w calosci (wszystkie jego pola automatycznie)
                // czyli to co ponizej
                //Jest to standardowa metoda writeObject jesli nie stworze jej wlasnej
                // deklaracji
                strWyj.writeUTF(stringTans);
                //wybrana metoda zapisu zalezna od rodzaju zmiennej
                //moge nawet zapisac zmienna z parametrem Transient
                strWyj.writeUTF(stringNormalny);
                strWyj.writeInt(liczba+10);
            }
        }
        class SerializacjaUnikalnaFabryka{
            void main(){
                SerializacjaUnikalna s = new SerializacjaUnikalna("napT", "napN", 10);
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream("SU"))){
                    strWyj.writeObject(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream("SU"))){
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
        SerializacjaUnikalnaFabryka ts = new SerializacjaUnikalnaFabryka();
        ts.main();

        //Dziedziczenie w serializacji
        /*
        Klasa ktora rozszerza klase implementujaca inteface Serializable
         automatycznie takze go implementuje wiec takze jest serializowana!!

        Jesli chce aby klasa nie byla serializowna moge nadpisac metody
         private void readObject(ObjectInputStream strWej) lub/oraz
         void writeObject(ObjectOutputStream strWyj)
         i wyrzucic w nich odpowienio podpisany wyjatek NotSerializableException
         */
        class Chinczyk extends Czlowiek{

            public Chinczyk(int wiek, String imie, Integer identyfikator) {
                super(wiek, imie, identyfikator);
            }
            private void writeObject(ObjectOutputStream strWyj) throws IOException {
                throw new NotSerializableException("Nie serialzuje Chinczyka");
            }
            private void readObject(ObjectInputStream strWej) throws IOException {
                throw new NotSerializableException("Nie serialzuje Chinczyka");
            }
        }


        //Interface Externalizable
        /*
        Klasa implementujaca ten interface musi posiadac konstruktor bezparametrowy
         oraz implementowac wlasne metody strumienia wyjscia i wejscia
         writeExternal oraz readExternal deklarujace dzialanie strumieniow
        W tych metodach nie ma metody defaultWrite/ReadObject !! wiec musze
         sam zadklarwoac wszystko co chce odczytac i zapisac do strumienia z Obiektu
         */
        class PelnaKontrola implements Externalizable{

            private String napis;
            public PelnaKontrola(){

            }
            public PelnaKontrola(String napis){
                this.napis=napis;
            }
            @Override
            public void writeExternal(ObjectOutput out) throws IOException {
                out.writeUTF(napis);
            }
            @Override
            public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
                napis = in.readUTF();
            }
            void main(){
                PelnaKontrola pK = new PelnaKontrola("testuje Pelna konrole");
                try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pelnaKontrola.bin"))){
                    out.writeObject(pK);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("pelnaKontrola.bin"))){
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
        PelnaKontrola pK = new PelnaKontrola("213");
        pK.main();


        //Pole serialVersionUID
        /*
        Tworze je aby sprawdzic poprawnosc serializacji i deserializacji
        private static long serialVersionUID;
        Moge nadac jej wartosc sam lub kompilator zrobi to za mnie
         */



        //ENUM TYP WYLICZENIOWY
        /*
        Sluzy do grupownia znanych nam wartosci - latwo je rozbudowywac

        Wartosci typu wyliczniowego maja atrybut public static final !
         wiec odwolujac sie do nich podaje nazwe typu wyliczeniowego
         np zmienna w klasie:
         private mojEnum zmiennaEnum = mojEnum.XL;

        Wartosci pisze wielkimi literami

        Enum nie mozna rozszerzac - jest jako final ! i nie moze dziedziczyc
         poniewaz dziedzicy po java.lang.Enum

        Wartosci enum mozna porownywac ==

        Nie mozna tworzyc instancji enum

        W instrukcji switch(zmiennaEnum){
            case S: //uzywam samych wartosci enum
                break;

        Konstruktor jest zawsze private ! - nie musze tego modyfikatora pisac


        Enum moze byc prosty lub rozszerzony:

        Prosty sklada sie z podanych wartosci bez specyfikacji (podwartosci)
        public enum mojEnum{
        S,M,L,XL
        }
        Wartosci oddzielamy przecinkiem, jesli nie ma nic na po nich nie stawiem
         srednika
        Zmiennym typu enum przypisuje wartosci pelna nazwa enuma:
         mojEnum zmienna = mojEnum.S;
        a wyswietlajac je w sout otrzymam samo:
         S

        Rozszerzony moze posiadac podwartosci kazdej wartosci ktore
         przypisuje do oddzielnych pol i nadaje im wartosci w konstruktorze
        Tyle ile podam podwartosci w kazdej zmiennej tylu parametrowy konstruktor
         musze stworzyc!
        Robie to poniweaz chcac sie dostac do podwartosci zmiennej moge to
         zrobic tylko za pomoca geterow nowych pol ktore maja przypisane
         podwartosci kazdej zmiennej
        sout(rozszerzonyEnum.S);
         pokaze : S
        sout(rozszerzonyEnum.S.getChestWidth());
         pokaze podwartosci S - w tym przypadku pierwsza czyli 10

        public enum rozszerzonyEnum{
            S(10,20,30), //3 wartosci wiec 3 param. konstr. musze stworzyc
            M(20,30,40),
            L(30,40,50); //SREDNIK JESLI JEST COS PO WARTOSCIACH!

            //tworze 3 zmienne poniewaz kazna zmienna ma 3 "podwartosci"
            // i przypisuje im wartosci w konstruktorze:
            private int chestWidth;
            private int shirtLength;
            private int sleeveLength;

            //konstruktor jest zawsze private!
            rozszerzonyEnum(int chestWidth, int shirtLength, int sleeveLength)
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


        Metody:
        mojEnum.vaues(); - metoda statyczna - wywolywana na nazwie enum/klasy
         zwraca wartosci w fotmie tabeli typu wyliczeniowego:
         mojEnum.S, mojEnum.M itp., mozna
         uzyc do wypisania wartosci w petli foreach
         Petla za x mojEnum.S, mojEnum.M itp.
        na kazdym wyliczeniu w for mozna wywolac metode enuma np get
        for(KoszulkaRozmiarDokladnie x : KoszulkaRozmiarDokladnie.values()){
            sout(x) //pokaze samo S
            sout(x.getZmienna)// pokaze jedna z podwartosci S ktore sa
             //przypisane do poszczegolnych zmiennych

        mojEnum.valueOf("WARTOSC"); - przyjmuje ciag znakow i zwraca odpowiadajaca
         jej wartosc typu enum czyli np. WARTOSC

        mojEnum.S.ordinal(); - zwroci ktory numer ma podana wartosc S (liczy od 0)

        mojEnum.S.name(); - zwroci nazwe wartosci enum w formie samej nazwy
         czyli S


        Enum moze posiadac metody abstrakcyjne ktore sluza do stworzenia definicji
         metody ktorych cialo deklaruje w wartociach po nazwie w {}
        Wywoluje je podajac nazwe enuma z wartoscia i na koncu metode dzieki czemu
         mam rozne implementacje dla moich metod
        mojEnum.IMIE.format("kamil"); //zwroci string "Witaj kamil"
        Moge to zapisac w zmiennej np. String napis;

        public enum mojEnum{
            IMIE{
                public String dajDane(String napis)
                    return "Witaj " + napis;
            },
            NAZWISKO{
                public String dajDane(String napis)
                    return "Masz na nazwisko: " + napis;
            };
            public abstract String dajDane(String napis);
        }
         */

        class Koszulka{
            private KoszulkaRozmiar rozmiar; // deklaruje zmienna typu
            // typu wylczniowego
            //przykladowe nadanie wartosci:
            private KoszulkaRozmiar rozmiar2 = KoszulkaRozmiar.L;
            //nadaje tak poniewaz pola enum sa public static final
            private String producent;
            public Koszulka(){}
            public Koszulka(KoszulkaRozmiar rozmiar, String producent){
                this.rozmiar = rozmiar;
                this.producent = producent;
            }
            void main(){
                Koszulka k1 = new Koszulka(KoszulkaRozmiar.L, "Adidas");
                //zmienne typu typu wyliczniowego nadaje z nazwa enum oraz po kropce
                // jego zmienna
                System.out.println("rozmiar koszuliki: "+k1.rozmiar);
                //wyswietli "L"

                switch (k1.rozmiar){
                    case S:
                        System.out.println("wybrales rozmiar S");
                        break;
                    case M:
                        System.out.println("wybrales rozmiar M");
                        break;
                    case L:
                        System.out.println("wybrales rozmiar L");
                        break;
                    case XL:
                        System.out.println("wybrales rozmiar XL");
                        break;
                }
            }
        }
        /*
        enum KoszulkaRozmiar{ //implementacja dodana na koncu kodu
            S,M,L,XL// bez ; na koncu
            //wartosci deklaruje drukownymi literami
            //srednik na koncu stawiem gdy chce dodac jeszcze pola i konstruktor
        }*/
        Koszulka run = new Koszulka();
        run.main();
        /*
        enum KoszulkaRozmiarDokladnie{
            S(48, 71, 36),//jesli okresle wartosci w typie enum bede musial
            // stowrzyc konstruktor z tyloma parametrami i moge stowrzyc zmienne
            // w enum do korych przypisze wartosci tym konstruktorze
            M(52, 74, 38),
            L(56, 76, 41),
            XL(61, 79, 41);

            private int szerokoscKlatki; //tworze 3 wartosci bo tyle ma typ enum
            private int wysokoscKoszulki;
            private int dlugoscRekawa;

            //jesli enum ma metody/konstruktor to wartoci musza znajdowac sie na poczaktu
            //konstruktor ma domuslne private i nie mozna tworzyc instancji enum
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
        }*/
        class Koszulka2{
            KoszulkaRozmiarDokladnie rozmiar;
            void main(){
                System.out.println();
                System.out.println("KoszulkaRozmiarDokladnie.valueOf(''S'')");
                //zwroci S
                System.out.println(KoszulkaRozmiarDokladnie.valueOf("S"));

                System.out.println();
                System.out.println("KoszulkaRozmiar.valueOf(''S'')");
                //zwroci S
                System.out.println(KoszulkaRozmiar.valueOf("S"));

                System.out.println();
                System.out.println("pokazuje w sout KoszulkaRozmiarDokladnie.XL");
                System.out.println(KoszulkaRozmiarDokladnie.XL);

                System.out.println();
                System.out.println("pokazuje w sout KoszulkaRozmiarDokladnie.XL.dajdlugoscRekawa()");
                System.out.println(KoszulkaRozmiarDokladnie.XL.dajdlugoscRekawa());

                System.out.println();
                System.out.println("KoszulkaRozmiarDokladnie x : KoszulkaRozmiarDokladnie.values()");
                for(KoszulkaRozmiarDokladnie x : KoszulkaRozmiarDokladnie.values()){
                    //za x podsawi KoszulkaRozmiarDokladnie.S itp
                    System.out.println("Rozmiar: " + x + " posiada: ");
                    System.out.println("dlugosc rekawa: "+x.dajdlugoscRekawa());
                    System.out.println("szerokosc klatki: "+x.dajSzerokoscKlatki());
                    System.out.println("wysokosc koszuli: "+x.dajwysokoscKoszulki());
                    System.out.println("i jest wartoscia numer: "+x.ordinal());
                }
                System.out.println();
                rozmiar = KoszulkaRozmiarDokladnie.XL;
                System.out.println("XL jest numerem enum :" + rozmiar.ordinal());
                System.out.println("XL ma nazwe w enum: " + rozmiar.name());
            }
        }
        Koszulka2 run2 = new Koszulka2();
        run2.main();

        /*
        enum EnumDoTekstu{
            SPOKOJNY{
                public String format(String wiadomosc){
                    return "To twoja wiadomosc spokojna: " + wiadomosc;
                }
            },
            NERWOWY {
                public String format(String wiadomosc) {
                    return "To twoja wiadomosc nerwowa: " + wiadomosc;
                }
            };
            public abstract String format(String wiadomosc);
        }*/
        class TestEnumDoTekstu{
            String zmienna;
            void main(){
                zmienna = EnumDoTekstu.NERWOWY.format("costam");
                System.out.println();
                System.out.println("Enum do tekstu: "+ zmienna);
            }
        }
        TestEnumDoTekstu testEnumDoTekstu = new TestEnumDoTekstu();
        testEnumDoTekstu.main();


        
        //ADNOTACJE / DYREKTYWA JavaDoc
        /*
        JavaDoc to standardowy mechanizm generowania dokumentacji, jest
         on w specjalnym komentarzu wieloliniowym zaczynajacym sie od /**
         z * na poczatku kazdej linii
        Sa w nim dyrektywy takie jak @param czy @retrun oraz opis
        Moga byc takrze @see, @author czy @version
        /**
         * Multipies number by 2 // co robi metoda
         * @param parameter number that should be multipied // co sie stanie
         * // z parametrem ktory przyjmie
         * @return parameter multipied by 2// to co zwraca i jak
         */

        //public int timesTwo(int param){
        //    return param * 2;
        //}


        /*
        Adnotacje przekazuja dodatkowe informacje na temat kodu
        Przekazuja dane o danych - kodzie zrodlowym
        Sa one specjalnym interfejsem
        Umieszczamy je przed konkretnym elementem np. klasa/zmienna/metoda

        Mozemy je stosowac do:
        -metody
        -klasy
        -pola/atrybutu klasy
        -parametru metody(to co przyjmuje)
        -zmiennej lokalnej
        -konstruktora
        -adnotacji typu


        //Zastosowanie adnotacji:

        //-Dodatkowa informacja dla kompilatora
        np @override informuje kompilator ze metoda jest przeslonita
         w nadklasie lub interfejsu
        Moge to wykorzystac np dodajac przed jakas metoda i jesli
         nie jest ona przeslonieciem innej metody kompilator wyswietli
         blad
        np:
        @Override
        public boolean equal(Object obj)
            return true;
        //bedzie blad poniwaz brakuje "s" i metoda nie przeslania metody
           w podklasie
        */


        //-Adnotacje przetwarzane w trakcie kompilacji
        List listOfUndefinedObjects = new ArrayList();
        List<Integer> listOfIntegers = (List<Integer>) listOfUndefinedObjects;
        /*
        kompilator moze nas ostrzec ze jesli dodamy do listy listOfUndefinedObjects
         typ inny niz Integer to chca zrzutowac do Integer wyrzuc blad (np String)
         ClassCastException
         "Warning:(10, 56) java: unchecked cast
         required: java.util.List<java.lang.Integer>
         found: java.util.List"

        Aby zapobiec takiemu ostrzeganiu dodaje przed rzutowaniem @SuppressWarnings
         i moge ja przypisac do typu, atrybutu, metody, parametru metody,
         konstruktora czy zmiennej lokalnej np listy
        */
        List listOfUndefinedObjects2 = new ArrayList();
        @SuppressWarnings("unchecked")
        List<Integer> listOfIntegers2 = (List<Integer>) listOfUndefinedObjects;
        /*
        Kompilator nie bedzie nas ostrzegal przed zagrozeniami typu unchecked przy
         konkretnej zmiennej


        //-Adnotacje w trakcie uruchomienia programu
        Sluzy do tego mechanizm refleksji, moge w trakcie dzialania
         programu pobierac informacje o skompilowanym kodzie czyli np klasie/jej metodach
         czy zmiennych
        np. @PostConstruct


        //Definiowanie adnotacji

        np:
        @Retention(RetentionPolicy.SOURCE) - adnotacja bedzie tylko w kodzie zrodlowym
        @Target(ElementType.FIELD) - moze byc uzyta wylacznie na atrutach klasy
        public @interface SampleFieldAnnotation {
            String id(); - to jest element "id" (przyjmie argument podczas uzcia adnotacji
        }                                        czyli jest "argumentem")

        Adnotacja powinna miec informacje: (przed definicja)
        -do jakiche elementow moze byc stosowana np. @Target(ElementType.METHOD)
         jesli jej nie okresle to bede mogl jej uzywac wszedzie z wyjatkiem typow
         typ wyliczniowy : ElementType

        -jak dlugo dane o adnotacji powinny byc przechowywane / gdzie beda wykrywane
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


        Adnotacja moze przyjac tzw argument podczas wywolania np @SuppressWarnings("unchecked");
        to adnotacja SuppressWarnings przyjmie String

        PRZYKLADOWA DEKLARACJA:
        @Retention(RetentionPolicy.RUNTIME)
        @Target({ElementType.METHOD, ElementType.FIELD})
        public @interface MyAnnotation {
            String A();
            String B();
        }
        W kodzie programu (przed metoda lub polem - okresoly element target):
        @MyAnnotation(A = "", B = "")//przypisuje wartosci zmiennym w adnotacji
        void simpleMethod() {
        }


        public @interface Retention {
            RetentionPolicy value();
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


        Wartosci domyslne adnotacji:
        @Retention(RetentionPolicy.RUNTIME)
        //nformacja o tej adnotacji jest dostępna w trakcie wykonania programu.
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



        //KLASY WEWNETRZNE I ANONIMOWE

        /*
        Istnieje kilka typow klas wewnetrznych:
        -standardowe
        -statyczne
        -lokalne
        -anonimowe

        Klasa wewnetrzna NIELOKALNA moze miec kazdy modyfikator

        Klasa wewnetrzna ma dostep do wszytkich atrybutow i metod klasy zewnetrznej


        Wewnetrzene interfejsy i typy wyliczneniowe sa ZAWSZE statyczne!
         i nie moga byc lokalne to jest w metodzie/bloku if


        Klasa lokalna jest zdefiniowana wewnatrza bloku (metoda, blok if itp)
         i nie moze zawierac zadnego modyfikatora (public/private/protected)

        Klasa wewnetrzna lokalna moze korzystac ze ZMIENNYCH LOKALNYCH (gdy definiuja ja w metodzie)
         TYLKO gdy sa one finalne lub nie zmieniam ich wartosci po jednym ustaleniu wartosci
         w deklaracji! - opis dzialania ponizej

        Dostep do klas lokalnych jest tylko w bloku w ktorym zostaly zdefiniowane!

        */
        class KlasaZew{
            class KlasaWew{
            }

            public KlasaWew rozpocznij(){ //METODA
                return new KlasaWew();
                //nie musze pisac return this.new KlasaWew();
            }

            //Tworznie instancji klasy wewnetrznej
            public void main(){
                //TWORZENIE OBIEKTU gdy klasa wewnetrzna jest NIESTATYCZNA!
                KlasaZew klasaZew = new KlasaZew();
                //1 tworze obiekt klasy ZEW
                KlasaZew.KlasaWew instancja1 = klasaZew.new KlasaWew();
                //2 tworze obekt typu KLASA_ZEW.KLASA_WEW i wywoluje na obiekcie klasy
                // zewnetrznej konstruktor klasy wewnetrzej
                KlasaZew.KlasaWew instancja2 = klasaZew.rozpocznij(); // za pomoca metody

                //INNA METODA: (gdy klasa wewnetrzna JEST STATYCZNA!)
                //np w innej klasie
                //KlasaZew.KlasaWew obiekt = new KlasaZew.KlasaWew();

                //INNA METODA2:(gdy klasa wewnetrza jest STATYCZNA i TYLKO W KLASIE
                // W MAIN TEJ SAMEJ KLASY!! moge tworzyc bezposrenio obiekt klasy wew
                KlasaWew obWew2 = new KlasaWew();


                //Klasa wewnetrzna lokalna
                final int liczba = 10;
                int liczbaNieFinalna = 10; // nie zadeklarowalem final
                // lecz gdy ja potem zmienie to wystapi blad (jesli jej uzyje
                // w klasie lokalnej)
                //Tworze klase wewnetrzna wewnatrz metody - ma dostep takze do zmiennych lokalnych
                class KlasaWMetodzie{
                    void powiedzCos(){
                        System.out.println(liczba);
                        System.out.println(liczbaNieFinalna);
                    }
                }
                //liczbaNieFinalna = 20; - nie moge zmienic bo klasa wew korzysta
                // ze zmiennej lokalnej!!
            }
        }


        System.out.println();
        Map<String, Integer> dniWMiesiacy = new HashMap<>();
        dniWMiesiacy.put("styczen", 31);
        dniWMiesiacy.put("luty", 28);
        dniWMiesiacy.put("marzec", 31);
        //Kazda instancja obiekty typu Map ma metode entrySet ktora
        // zwraca typ Set<Map.Entry<K, V>>
        //Klasa Map posiada interface Entry ktory przyjmuje zbior
        // Set<Map.Entry<K,V>> i iterujac po elementach
        // mam dostep do metod getKey() oraz getVaule()
        for(Map.Entry<String, Integer> x : dniWMiesiacy.entrySet() ){
            System.out.println(x.getKey() + " ma " + x.getValue() + " dni");
        }


        //Klasy anonimowe:
        /*
        Jest to klasa definiowana w kodzie ktora posiada doklasnie 1 instancje
        Klasa anonimowa zawsze jest klasa wewnetrzna i polaczona jest z tworzeniem
         jej jednej instancji

        Na poczatku tworze intefrfejs z metoda i "tworze jego instancje", w metodzie
         interfacu dodajac jej dzialanie w {pelna definicja} - tak naprawde jest to klasa
         z nazwa klasy zewnetrznej z dodaniem na koncu $ z liczba klasy anonimowej
         w danej klasie

        //deklracja na koncu:
        interface Powitanie{
           void powiedzCzesc();
        }
         */
        //Tworzenie klasy anonimowej implementujacej intefejs Powitanie oraz
        // utworzenie jej jednej instancji za pomoca slowa new
        Powitanie powitanie = new Powitanie() {
            @Override
            public void powiedzCzesc() {
                System.out.println("witaj");
            }//ta metoda musi byc!!
            //Moge takze w niej definiowac zmeinne i metody lecz glownie polega
            // to na tym ze wykorzysstuje ja tylko do zaimplementowania interfesju
            int zmienna = 123;
            int metoda(){
                return zmienna;
            }
        };//nie zapominam o sredniku
        //Klasa anoniomowa ma nazwe klasy w ktorej jest umieszczona oraz po "$" numer klasy
        // anonimowej ktora zostala stworzona w danej klasie np:
        System.out.println(powitanie.getClass());
        //class SamouczekProgramisty.Wstep$1


        //Przykladowe uzycie wewnetrznej klasy anonimowej z interfejsem
        /*
        public class AnonymousClasses {
            public static class RobotStatyczny {
            //KLASA WEW JEST STATYCZNA!! wiec deklaruje jej obiek bezposrenio
            // tj. KlasaZew.KlasaWew ob = new KlasaZew.KlasaWew(new AnonymousClasses.GreetingModule() {
            // deklaracja metody interfacu});
            // lub bezposrenio bez pomocy klasy zew: KlasaWew ob = new KlasaWew(new GreetingModule(){
            // deklaracja metody interfacu}); -tak moge tylko w metodzie TEJ SAMEJ KLASY
            // oraz w konstruktorze podaje takze TYLKO new z samym interfacem new GreetingModule()
                private final GreetingModule greetingModule;
                //Tworze zmienna final bez deklaracji i moge to zrobic tylko
                // dlatego ze deklaracja jest w konstruktorze

                public Robot(GreetingModule greetingModule) {
                    this.greetingModule = greetingModule;
                    //Przypisuje zmiennej typu interfejsu wartosc
                    // lecz nie uzywam slowa new wiec nie musze deklarwac
                    // tresci metody int. tylko tam gdzie bede tworzyl obiekt
                }

                public void saySomething() {
                    greetingModule.sayHello();
                    //Na polu klasy moge wywolac metode intefejsu poniewaz
                    // tworza instancje klasy anonimowej jest ona odzielna
                    // klasa implementujaca ten interfejs
                }
            }
            public class RobotNieStatyczny{ //klasa NIESTATYCZNA
            // do tworzenia isntancji klasy wew posrwnio
                private final GreetingModule greetingModule;
                public Robot(GreetingModule greetingModule) {
                    this.greetingModule = greetingModule;
                }
                 public void saySomething() {
                    greetingModule.sayHello();
                }
            }

            public interface GreetingModule { //INTERFEJS WEWNETRZNY
                void sayHello();
            }

            public static void main(String[] args) {
                //1 W main (dowolnej klasy) tworze BESPOSRENIO obiekt klasy
                //   wewnetrznej (musi byc ona statyczna)
                AnonymousClasses.RobotStatyczny ob1 = new AnonymousClasses.RobotStatyczny(
                    new AnonymousClasses.GreetingModule(){
                    //w konstruktorze przekazuje klase anonimowa z uczyciem klasy ZEW!
                    @Override
                    public void przywitanie() {
                        System.out.println("czesc statycznie");
                    }
                });
                ob1.saySomething();

                //2 W main TYLKO TEJ SAMEJ KLASY tworze BESPOSREENIO obiekt klasy
                //   wewnetrznej BEZ POMOCY klasy zewnetrznej
                RobotStatyczny ob2 = new RobotStatyczny(new GreetingModule() {
                    //w konstruktorze przekazuje klase anonimowa bez uzycia klasy ZEW!
                    @Override
                    public void sayHello() {
                        System.out.println("dzien dobry");
                    }
                });
                ob2.saySomething();

                //3 W main (dowolnej klasy) tworze posrenio obiekt klasy
                //   wewnetrznej (nie moze byc ons statyczna)
                AnonymousClasses obZew = new AnonymousClasses():
                AnonymousClasses.RobotNieStatyczny ob3 = obZew.new RobotNieStatyczny(
                    new AnonymousClasses.GreetingModule(){
                    @Override
                    public void przywitanie() {
                        System.out.println("czesc statycznie");
                    }
                });
                ob3.saySomething();
            }
        }
        */

        //Sortowanie z uzycem Collection.sort i interfacem Comparator
        // z klasa anonimowa
        /*
        Collection.sort przyjmuje sama tablice lub tablice z Comparatorem

        Jesli przyjmie sama tablice to TYP zmiennych tablicy (jesli jest mojej
         wlasnej klasy np List<MojaKlasa>) musi implementowac intefrace Comparable i
         nadpisac metode int compareTo(MojaKlasa o) ktora zwraca >=1 gdy zmienna z this.
         np this.wiek jest wieksza od o.wiek, gdy odwrotnie to <0 i gdy rowne
         to 0. Zmienne brane sa po kolei z Listy - this.wiek jest wiekiem
         elementu 0 a o.wiek jest wiekiem elementu 1. Jesli lista ma typ
         String to moge wywolywac na elementach metody np this.legth() lub porownywac
         je metoda this.compareTo(o) -> wszytsko w metodzie int compare(String o)

        Jesli metoda Collection.sort przyjmie takze komparator to moge zrobic to
         dodajac nowa Klase implementujaca int. Comparator<KlasaDoSortowania> i w niej
         metode int compare(KlasaDoSortowania o1, KlasaDoSortowania o2)
         to metoda sort bedzie wygladala:
         Collection.sort(lista, KlazaZKomparatorem)
        Lub jesli chce zrobic unikalne sortowanie to moge
         wykorzystac klase anonimowa z interfejsem Comparator ktory posiada
         metode int compare(Klasa o1, Klasa o2) to metoda sort bedzie wygladala:
         Collection.sort(lista, new Comparator())...deklaracja compare

        Jesli lista posiada typ String to w klasie anonimowej z Comparatorem metoda
         compare podstawi przyjmowane obiekty za String
         Collections.sort(wyrazy, new Comparator<String>() {
         int compare (String o1, String o2); i moge posortowac
         je wg dlugosci if(o1.legth()>o2.length())retrun 1; itp.
         lub w skrocie return o1.length()-o2.legth(); wtedy gdy 1 element bedzie
         dluzszy to zwroci >=1 wiec tez poprawnie
        Moge takze zrobic sortowanie alfabetyczne elementow string to deklaracja
         int compare (String o1, String o2) { return o1.compareTo(o2);}
         */
        class Sortowanie{
            List<String> wyrazy = new LinkedList<>();
            public Sortowanie(){
                dodajWyrazy();
                pokazWyrazy();
                sortujWyrazy();
                pokazWyrazy();
            }
            void dodajWyrazy(){
//                Scanner sc = new Scanner(System.in);
//                String wyraz;
//                while (true){
//                    wyraz = sc.nextLine();
//                    if(!wyraz.equals("-"))
//                        wyrazy.add(wyraz);
//                    else
//                        break;
//                }
                wyrazy.add("sdafasdadsasdgargg");
                wyrazy.add("sdafga");
                wyrazy.add("sdafgdasdasdasdasdasdargg");
                wyrazy.add("dasasdasdasdd");
            }
            void pokazWyrazy(){
                System.out.println("TO SA MOJE WYRAZY");
                for (String x : wyrazy)
                    System.out.println(x);
            }
            void sortujWyrazy(){
                System.out.println("SORTUJE!");
                Collections.sort(wyrazy, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //za o1 podstawia jeden element tablicy i sortuje
                        // je wg dlugosci
                        if(o1.length()>o2.length())
                            return 1;
                        else if(o1.length()<o2.length())
                            return -1;
                        else
                            return 0;
                    }
                });
            }
        }
        Sortowanie s = new Sortowanie();
        System.out.println();



        //Test Driven Development TDD
        /*
        Test jednostkowy jest sposoboem testowania programy ktory polega na wydzieleniu
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

        Założeniem TDD jest pisanie testow do jak najkrotszej ilosci kodu

        Dobra praktyka jest jednego dnia napisania testow zeby kolejnego
         rozpoczac pisanie samej funkcjonalnosci
         */

        //Testy jednostkowe z JUnit
        /*
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


        PRZYKŁADOWE TESTY:

        //Tworze obiekt i sprawdzam czy metoda klasy zwroci true
        @Test
        public void czyLiczba12JestWPrzedziale(){
            One o = new One(10,15);
            assertTrue(o.czyJestWPrzedziale(12));
        }

        //Sprawdzam czy metoda zwroci wyjatek IllegalArgumentException
        @Test(expected = IllegalArgumentException.class) //test przejdzie
        // jesli zostanie wyrzucony podany wyjatek
        public void czyWyrzicWyjatekZlychParametrow(){
            new One(20,10); //wyjatek jest w konstruktorze klasy One
        }

        //Sposob 2
        @Test
        public void czyWyrzicWyjatekZlychParametrow2(){
            try{
                new One(20,10);
                fail("Wyjatek nie zostal rzucony");
                //wywola wyrzucenie wyjatku AssertionError z napisem
                //test nie przejdzie
            }
            catch (IllegalArgumentException ex){
                assertEquals("dolny przedzial jest wiekszy niz gorny!",ex.getMessage());
                //jesli metoda wyrzuci DOKŁADNIE TAKI wyjatek to test przejdzie
                //jesli nie to test nie przejdzie
            }
        }


        Przed testami moge dodac zmienna Obiektu klasy np
        One one;
        i stworzyc jej obiekt na potzeby testow dodajac metode z adnotacja
        @Before ktora jest wywolywana przed kazdym testem

        @Before
        public start(){
            one = new One(10,20);
        }
        i korzystac w kazdym tescie zmiennej one z podanymi parametrami

        Istnieja takze metody
        @After - uruchamina po kazdym tescie
        @BeforeClass - uruchamiana przed wszystkimi testame
        @AfterClass - uruchamiana po wszytkich testach

         */



        //WYRAŻENIA REGULARNE
        /*
        Wyrażenie regularne (ang. regular expression) to „wzorzec”, który opisuje grupę
         łańcuchów znaków i jest nastepnie kompilowany przez
         silnik wyrażeń regularnych do wewnętrznej postaci.

        W praktyce jednym z głównych zastosowań jest weryfikacja czy dany łańcuch znaków
         pasuje do wzorca. Wzorcem tym jest wyrażenie regularne.

        W Javie wyrazenia rgularne wykorzystuje klasy Pattern i Matcher

        Na poczatku deklaruje wzorzec
         Pattern wzorzec = Pattern.compile("costam")
        Nastepnie z pomoca obiektu wzorca deklaruje wybrane dopaseowanie
         Matcher dopasowanie = wzorzec.matcher("pisze costam")
        Aby sprawdzic dopasowanie dokladne uzywam metody matches(); na obiekcie
         Matcher tj. dopasowanie.matches(); - zwroci false poniewaz sie nie zgadza
        Aby spawdzic czy jakakolwiek czesc ciegu dopsowania pasuje do wzorca uzywam
         metody find(); tj. dopasownie.find(); - zwroci true poniwaz "costam"
         znajduje sie w dopasowaniu ciagu "pisze costam"

        Znaki biale:
        \n - nowa linia
        \r - usuniecie wszystkiego do poczatku linii
        \t - tabulacja
        \f - strzalka w gore (napisana doslowanie jako obrazek)
        \x0B - wertykalny tabulator
         */

        //POMOC W IDE
        //moge na deklaracji wzorca uzyc <alt + enter> i dac Check RegExp aby na szybko
        // sprawdzic czy podany wpisany w okno wzorzec pasuje

        Pattern compiledPattern = Pattern.compile("Marcin");
        //Tworze wzorzec ktorym jest slowo "Marcin"
        Matcher matcher = compiledPattern.matcher("Nazywam sie Marcin Pietraszek");
        //Tworze dopasowanie ktore bedzie sprawdzne do wzroca

        System.out.println("\n"+"matcher.find()");
        System.out.println(matcher.find());
        //Sprawdzam czy w ciagu znakow z dopasowania jest ciag ze wzorca
        //Zwroci true poniewaz jest
        System.out.println("matcher.matches()");
        System.out.println(matcher.matches());
        //Sprawdzam czy ciag dopasania jest taki sam jak wzrorzec
        //Zwroci false

        /*
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
        */

        //POWTORZENIA:
        //znak ? - element przed ? (1 litera ciagu) moze wystapic 0 lub 1 raz,
        //          pozostala czesc przed nim musi byc niezmieniona np. kr?at
        //(0 - 1 wystapien)
        //Poprawnie : krat, kat
        //Blednie : rkat, at, wkrat
        Pattern wzorKrat = Pattern.compile("kr?at");

        System.out.println("\n"+"krat:");//jest r - true
        Matcher dopasowanie = wzorKrat.matcher("krat");
        System.out.println(dopasowanie.matches());
        System.out.println("kat:");//brak r jest k - true
        Matcher dopasowanie2 = wzorKrat.matcher("kat");
        System.out.println(dopasowanie2.matches());
        System.out.println("rkat:");//brak r ale przed k jest litera - false
        Matcher dopasowanie5 = wzorKrat.matcher("rkat");
        System.out.println(dopasowanie5.matches());
        System.out.println("at:");//brak r ale i brak k - false
        Matcher dopasowanie3 = wzorKrat.matcher("at");
        System.out.println(dopasowanie3.matches());
        System.out.println("wkrat:");//jest k i r ale przed jest jeszcze w - false
        Matcher dopasowanie4 = wzorKrat.matcher("wkrat");
        System.out.println(dopasowanie4.matches());


        //znak * - to co jest przed nim moze zostac pomienita
        //          lub wystapic dowlona ilosc razy np uwa*ga
        //(0 - nieskonczon. wystapien)
        //Poprawnie : uwga, uwaga, uwaaaaga
        //Blednie : auwaga


        //znak + - dziala jak * tylko ze wystapienie musi byc CO NAJMNIEJ jedno
        //          np de+bil
        //(1 - nieskonczonosci wystapien)
        //Poprawnie : debil, deeeebil
        //Blednie : dbil, edebil,


        /*
        Dokladniejsze powtorzenia:
        {x} - oznacza że element poprzedzający musi wystąpić dokładnie x razy,
        {x,y} - oznacza, że element poprzedzający musi wystąpić od x do y razy,
        {x,} - oznacza, że element poprzedzający musi wystąpić co najmniej x razy,
        {,y} - oznacza, że element poprzedzający musi wystąpić co najwyżej y razy.
        Moge zastapic proste na te z {}:
        a*la -> a{0,}la
        a+la -> a{1,}la
        a?la -> a{0,1}la
         */

        //znak . - na miejscu . MUSI wystapic dowolny 1 ZNAK poza znakiem konca lini
        //          np: ko.ek chyba ze jest przed nim np * czyli .* to moze wystapic
        //          dowolny ciag lub jego brak! lub + czyli .+ to musi byc dowolny znak
        //          lub ciag
        //          Przykad ko.ek :
        //Poprawnie : kotek, koDek
        //Blednie : koek, ktek
        Pattern mp2 = Pattern.compile("ko.+ek");
        Matcher mm2 = mp2.matcher("koDDsddek");
        System.out.println("matcher . : " + mm2.matches());

        Pattern mp3 = Pattern.compile("ko{1}ek");
        Matcher mm3 = mp3.matcher("koek");
        System.out.println("matcher {} : " + mm3.matches());

        Pattern mp4 = Pattern.compile("[a-dx-]ek");
        Matcher mm5 = mp4.matcher("-ek");
        System.out.println("matcher [] : " + mm5.matches());
        //          Przyklad ko.*ek :
        //Poprawnie : kotek, koDDddek, koek
        //Blednie : kotekk
        //          Przyklad ko.+ek :
        //Poprawnie : kotek, koDDsddek
        //Blednie : kotekk, koek

        //Kompbinacja k+a.*ta:
        //k+ (k musi wystapic conajmniej 1 raz, przed nim nic)
        //.* (musze wstawic 1 znak poza koncem lini lecz jest po nim * co łaczy sie
        // przez co moge tam wstawic dowolny znak lub ciag znakow lub nic
        //Poprawne wyrazenia: kata, kkax&dta, kaRta, kaSIA MA KOta, kkkka#$*&JHDFTATAta
        //Bledne : ata (brak k na poczatku), kta (brak a po pierwszym k)
        Pattern mp1 = Pattern.compile("k+a.*ta");
        Matcher mm1 = mp1.matcher("kkax&dta");
        System.out.println("XXXXXXX : "+mm1.matches());


        //Kombinacja .+@.+\.pl (wyrazenie regularne maila)
        /*
        .+ - dowolny symbol lub ciag użyty co najmniej raz,
        @ - małpa,
        .+ - ponownie dowolny symbol lub ciag użyty co najmniej raz,
        \. - kropka rozumiana dosłownie (nie jako specjalny znak wyrażenia regularnego),
        pl - następujące po sobie litery p i l.
        */
        Pattern mailPattern = Pattern.compile(".+@.+\\.pl");
        Matcher mm4 = mailPattern.matcher("kamil7745@gmail.pl");
        System.out.println("mail pattern: : "+mm4.matches());

        /*
        Klasy w wyrazeniach regularnych oznaczaja grupy symboli w []
         np [rtmp]aca oznacza ze musimy wykorzystac JEDEN z sumboli w [] nie
         wiecej
        Poprawnie : raca, taca, maca
        Błednie : praca -> 2 litery wkorzystane, pacanow -> czesc po sie nie zgadza

        Mozna wykorzystac takze zakres alfabetyczny lub liczbowy, musze umieciec -
         w innym miejscu niz na koncu
         np [a-d]uma
        Poprawnie : auma, buma, cuma
        Blednie : fuma, abuma->2 litery
         lub [0-7]xyz
        Poprawnie : 0xyz, 1xyz
        Blednie : 8xyz, 07xyz->2 cyfry
         lub [a-z]+ -> musi byc dowolna mala litera conajmniej raz


        Aby - byl iterpretowany doslownie musze go umieciec na koncu klasy np [abc-]xyz

        Mozna takze laczyc przedzialy z - i moge wykorzystac JEDEN z nich np [a-cA-C0-3]bum
        Poprawnie : abum, Bbum, 0bum
        Blednie : dbum, aA0bum -> 2 z przedzialow


        Negacje: (dopasowanie wszystko oprocz przedzialu klasy, przedzial ze znakiem ^ na poczatku)
        np [^xyz]awa
        Poprawnie : kawa, pawa, Wawa
        Blednie : zawa, yawa, yzawa

        Aby ^ byl itrerpretowany doslownie musze umiescic go w innym miejscu niz na poczatku np [x^yz]awa


        Klasy predefiniowane (w skrocie) np \d (w string musze dac podwojne \)-> \\d
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

        Przyklada predefiniowanych w kombinacji np \d\w\d
        Pattern pattern = Pattern.compile("\\d\\w\\d");
        assertTrue(pattern.matcher("0_0").matches()); +
        assertTrue(pattern.matcher("0X1").matches()); +
        assertFalse(pattern.matcher("a0b").matches()); -
        assertFalse(pattern.matcher("0 0").matches()); -

        Przykład daty :  \d{2}-\d{2}-\d{2}
        \d{4} - cztery cyfry oznaczające rok,
        - - minus oddzielający rok od miesiąca,
        \d{2} - dwie cyfry oznaczające miesiąc,
        - - minus oddzielający miesiąc od dnia,
        \d{2} - dwie cyfry oznaczające dzień.


        //Grupy
        Sluza do wyluskania z lancucha znakow wybranej czesci

        Grupy rozpoczynaja sie w ()

        Numerowane sa od 1

        Jezeli dany lancuch pasuje do wyrazenia regularnego to
         znajduje sie w grupie z numerem 0

        Na grupach operuje klasa Matcher

        metody:
        groupCount() - zwraca liczbe grup w wyrazeniu regularnym
         (pomija ta z indeksem 0)
        group(int numerGrupy) - zwraca grupe z konkretnym numerem

        Po przypisaniu wzorca i dopasowania musze wywolac metode
         na zmiennej dopasowania .matches(); aby moc sprawdzic
         co znajduje sie w danej grupie

        Jesli nie bedzie nic w grupie a bede chcial sie do niej dostac wyrzuci
         wyjatek IllegalStateException

        Np: "mam kota o imieniu --Lucky--. kot jest czarny"
         */
        Pattern kotPattern = Pattern.compile("[^-]+--(\\w+)--.*");
        //[^-]* dowolne znaki za wyjatkiem - (musi to byc aby moc oddzielic pierwsze wystapienie -)
        // nie zadziala gdy bede mial tylko jeden - przed -- poniewaz po pierwszym - bedzie szukalo
        // dwoch --
        //(\\w+) grupa w ktorej bedzie szukalo conajmniej 1 znaku
        //-- doslownie
        //.* dowolne znaki badz ich brak do konca
        Matcher kotMatcher = kotPattern.matcher("mam kota o imieniu --Lucky--. kot jest czarny");
        kotMatcher.matches();
        System.out.println("Imie kota : "+kotMatcher.group(1));

        //inny przyklad \w+ \((\w+)\) \w+
        // \w+ : cyfry, litery lub podkreslnikj uzyte conajmniej raz (NIE ODSTEP!!)
        //  : JEDEN odstep
        // \( : ( uzyty doslownie
        // (\w+\\) : gdupa w ktorej cyfry, litery lub podkreslnikj sa uzyte conajmniej raz
        // oraz \\ ktory oznacz doslowne wystapienie \
        // \) : doslwnie )
        //  : odstep
        // \w+ : cyfry, litery lub podkreslnikj uzyte conajmniej raz (NIE ODSTEP!!)
        //WSZEDZIE WE WZORCU MUSZE DAC 2x\ !!!
        Pattern wzorNazwyKsiazki = Pattern.compile("\\w+ \\((\\w+\\\\)\\) \\w+");
        Matcher dopasowanieNazwyKsiazki = wzorNazwyKsiazki.matcher("jacek (debil\\) pawlak");
        //musze uzyc 2x \ aby bylo interpretowane doslownie w lancuchu
        dopasowanieNazwyKsiazki.matches();
        System.out.println(dopasowanieNazwyKsiazki.group(1));

        //ZADANIA
        /* ZAD 1
        Sprawdza czy liczba zmiennoprzecinkowa podana przez użytkownika
         ma poprawny format. Na przykład liczba 123,2341515132135 czy -10
         są poprawne ale 18-12 czy 123, już nie,
         */
        Pattern wzorzecZad1 = Pattern.compile("-?\\d+(,\\d+)?");


        /* ZAD 2
        Sprawdza czy numer domu jest w formacie numer\numer.
         Poprawnym numerem jest 123\2A, 24B\3 czy 12\5, ale
         już numer abc\cba nie,
         */
        Pattern wzorzecZad2 = Pattern.compile("\\d+[a-zA-Z]?\\\\\\d+[a-zA-Z]?");

        /* ZAD 3
        Sprawdza czy użytkownik wprowadził poprawną nazwę miasta.
         Na przykład Wrocław, Zielona Gora czy Bielsko-Biala jest ok,
         jednak Ptysiow123 już nie. Dla uproszczenia załóżmy, że
         żadna nazwa miejscowości nie zwiera polskich znaków.\
        */
        Pattern wzorzecZad3 = Pattern.compile("[A-Z][a-z]+([ -][A-Z][a-z]+)?");


        //Zachłanność wyrażeń regularnych

        //Przyklad z bledem - chce wylapac to co jest w <>
        Pattern wzorzecZachlanny = Pattern.compile("<(.+)>");
        //wylapie najwiecej ile to mozliwe w dopasoaniu
        Matcher dopasowanieWZ = wzorzecZachlanny.matcher("<em>jakis podkreslony tekst</em>gdfgdfg");
        dopasowanieWZ.find();
        System.out.println("znacznik podkreslenia 1 : "+dopasowanieWZ.group(1));
        //Poprawnie:
        Pattern wzorzecZachlannyPoprawny = Pattern.compile("<([^>]+)>");
        Matcher dopasowanieWZP = wzorzecZachlannyPoprawny.matcher("<em>jakis podkreslony tekst</em>");
        dopasowanieWZP.find();
        System.out.println("znacznik podkreslenia 2 : "+dopasowanieWZP.group(1));
        //Symbole powtórzeń {}, ?, * czy + dopasowują zawsze najwięcej jak tylko się da
        //Istenieje przelacznik ktory zmienia zachowanie powtorzenia i jest to znak ? czyli
        // wylapuje najmniej jak to mozliwe
        Pattern wzorzecZachlanny2 = Pattern.compile("<(.+?)>"); //moze tez byc "<(.*?)>" tylko moze zostawic puste <>
        Matcher dopasowanieWZ2 = wzorzecZachlanny2.matcher("<em>jakis podkreslony tekst</em>gdfgdfg");
        dopasowanieWZ2.find();
        System.out.println("znacznik podkreslenia 3 : "+dopasowanieWZ2.group(1));
        //jednak {} nie jest zachlanny i w find {3,5} znajdzie wszystko od 3 do 5 znakow a z ? tylko to co ma 3
        Pattern wzorzecNieZachlanny = Pattern.compile("(.{3,5}?)");
        Matcher dopazsowanieWNZ = wzorzecNieZachlanny.matcher("123123");
        dopazsowanieWNZ.find();
        System.out.println("Dopasownie niezachlanne {} : "+dopazsowanieWNZ.group(1));


        //Alternatywa
        Pattern wzorzecAlternatywy = Pattern.compile("skrec w (lewo|prawo)");
        //ograniczam wybor w ()
        Matcher dopasowanieWA = wzorzecAlternatywy.matcher("skrec w prawo");
        dopasowanieWA.find(); // moze byc tez matches();
        System.out.println("Wzorzec alternatywny : "+dopasowanieWA.group(1));

        Pattern wzorzecAlternatywy2 = Pattern.compile("pies|lew|kot");
        //moge uzyc wiecej
        Matcher dopasowanieWA2 = wzorzecAlternatywy2.matcher("lew");
        dopasowanieWA2.matches();
        System.out.println("Wzorzec alternatywny 2 : "+dopasowanieWA2.group());
        //UZYWAM BEZ NUMERU GRUPY PONIEWAZ NIE MA ZADNEJ GRUPY WE WZORCU !


        //Pomijanie grup
        Pattern wzorzecPomijaniaGrupy = Pattern.compile("(?:Tomek|Kamil) ma (kota|psa)");
        Matcher dopasowanieWPG = wzorzecPomijaniaGrupy.matcher("Kamil ma kota");
        dopasowanieWPG.matches();
        System.out.println("Gupa ktora nie zostala pominieta : "+dopasowanieWPG.group(1));


        //Nazywanie grup
        Pattern wzorzecNazywaneGupy = Pattern.compile("(?<dzien>\\d{2})\\.(?<miesiac>\\d{2})\\.(?<rok>\\d{4})");
        //nazwa grypu jest na poczatku nawiasu w klauzuli ?<nazwaGrupy>
        Matcher dopasowanieWNG = wzorzecNazywaneGupy.matcher("04.01.2017");
        dopasowanieWNG.matches();
        System.out.println("grupa 1 : "+dopasowanieWNG.group(1));
        System.out.println("grupa 1 : "+dopasowanieWNG.group("dzien"));
        System.out.println("grupa 3 : "+dopasowanieWNG.group(3));
        System.out.println("grupa 3 : "+dopasowanieWNG.group("rok"));


        //Ponowne uzycie grup
        //"<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>"
        //chce do pierwszej grupy dac znacznik p
        //do 2 to co jest pomiedzy <p></p>
        Pattern wzorzecUzyciaGrup = Pattern.compile("<(.+?)>(.+?)</p");
        Matcher dopasowanieWUG = wzorzecUzyciaGrup.matcher("<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>");
        dopasowanieWUG.find();
        System.out.println("wzorzecUzyciaGrup grupa 1 : " + dopasowanieWUG.group(1));
        System.out.println("wzorzecUzyciaGrup grupa 2 : " + dopasowanieWUG.group(2));

        //moge uzyc zawartosci innej grupy juz we wzorcu w klauzuli \\NR_GRUPY
        Pattern wzorzecUzyciaGrup2 = Pattern.compile("<(.+?)>(.+?)</\\1");
        // \\1 to p wiec bedzie uniwersalne dla znacznika
        Matcher dopasowanieWUG2 = wzorzecUzyciaGrup2.matcher("<p>Some paragraph <em>emphasized</em></p><p>Other paragraph</p>");
        dopasowanieWUG2.find();
        System.out.println("wzorzecUzyciaGrup grupa 1 : " + dopasowanieWUG2.group(1));
        System.out.println("wzorzecUzyciaGrup grupa 2 : " + dopasowanieWUG2.group(2));


        //Kotwice
        /*
        ^ oznacza początek łańcucha znaków,
            np c^
            true : csd, csdg
            false : dsdfc
        $ oznacza koniec łańcucha znaków.
            np d$
            true : qwd, qasd
            false : asfdf
        */
        Pattern wzorzecLiczb = Pattern.compile("\\d+");//musza byc same liczby
        //moge dac "\\d+?" to find znajdzie 1 liczbe
        Matcher dopasowanieLiczb = wzorzecLiczb.matcher("abc123def");
        System.out.println("find : "+dopasowanieLiczb.find()); // true
        System.out.println("pierwsza liczba : "+dopasowanieLiczb.group());
        //DO GRUPY BEDE MOGL SIE DOSTAC JESLI OSTATNIA METODA NA DOPASOWANIU
        // BEDZIE TRUE (find lub matches) INACZEJ BEDZIE BLAD !
        System.out.println("matches : "+dopasowanieLiczb.matches()); // false

        Pattern wzorzecKotwicy = Pattern.compile("\\d+$");//liczby na koncu
        Matcher dopasowanieWK = wzorzecKotwicy.matcher("abc123");
        //matches bedzie flase
        dopasowanieWK.find();
        //jesli na koncu dam litere tj abc123x to find takze bedze false
        System.out.println("liczby z konca : "+dopasowanieWK.group());



        //Java z linii polecen
        /*
        Instalujac JRE mam komende java ktoa uruchamia maszyne wirtualna wywolujac
         metode main w odpowieniej klasie a instalujac JDK mam dostep do javac ktora
         ktora jest kompilatorem ktory tworzy plik class z pliku java a jar jest to
         narzedzie ktore tworzy pliki jar

        Instrukcja dodawania zmiennej srodowiskowej JDK w windows 10
         PS -> System -> Zaawansowane ustaiwnia systemu -> Zmienne środowiskowe
         W dziale Zmienne systemowe dodaje nowa zmienna lub edytuje o nazwie Path
         Nastepnie dodaje wybieram Nowy i wklejam lokalizjacje folderu bin JDK np"
         C:\Program Files\Java\jdk-10.0.2\bin

        -Kompilacja:
          Ide do lokalizacji pliku .java i wpisuje komende javac plik.java
          ! plik.java musi nazywac sie tak jak nazwa klasy z metoda main !
          Ta komenda tworzy w tym folderze plik plik.class np
          javac plik.java
        -Uruchomienie:
          Wpisuje komende java i nazwe pliku .class BEZ ROZSZERZENIA! np:
          java plik

        Jesli chce uruchomic i skompilowac plase w jakims podfolderze wpisauje
         javac pl\samouczekprogramisty\commandline\DisplayName.java
        Jesli chce uruchomic skompilowana klase, wpisuje java z classpath
         czyli zamiast \ wpisuje . oraz w pliku klasu musi byc lokalizacja
         package miejsca w ktorym bede uruchamial kompilacje!! np:
         package pl.naukajavy.liniapolecen;
        Uruchomienie bedzie wiec wygladalo:
         java pl.samouczekprogramisty.commandline.DisplayName


        CLASSPATH jest sciezka gdzie java szuka klas potrzebnych do skompilowania
         jak i uruchomienia i sluzy do tego komenda -cp

        Jesli uzywam zewnetrznej biblioteki to musze sciagnac jej plik jar i
         umiescic go w folderze glownym (tam gdzie uruchamiam kompilacjie)
         oraz dodac import w kodzie

        W przypadku bibliotek wbudowanych w jave nie musze uzywac -cp i wstarczyc
         sam import w kodzie np import java.util.Scanner;

        W przypadku kompilacji z biblioteka zew. komenda wyglada nastepujaco:
         javac NazwaPlikuJar.jar folder1\folder2\Klasa.java

        W przypadku uruchomienia po -cp musze wpisac lokalizacje z .
         np:
         java .;PlikBibliotekiZew.jar folder1.folder2.Klasa
         gdzie . oznacza ze skompilowanej klasy ma wyszkiwac w aktualnym katalogu
          badz nizej
         ; oddziela lokalizacje
         po ; jest plik jar i w nim ma szukac biblioteki zewnetrznej a w niej
          dodatkowych klas

        Przyklad:
         kompilacja:
         javac -cp commons-lang3-3.5.jar pl.naukajavy\liniapolecen\WyswietlImie.java
         uruchomienie:
         java -cp .;commons-lang3-3.5.jar pl.naukajavy.liniapolecen.WyswietlImie


         PLIKI JAR
         jest to archiwum ze skompilowanymi klasami. klasy wewnatrz archiwum
          znajduja sie w odpowiednich katalogach

         Uruchamianie pliku jar:
         java -jar aplka.jar

         Program jar moze tworzyc jak i wyswietlac zawartosc archiwum
         Wyswietlenie :
         jar tf plikJar.jar
         Utworzenie :
         jar cf <nazwa pliku wyjściowego> <lista katalogów, klas do umieszczenia w pliku JAR>
         np: jar cf PierwszyPlikJar.jar . (kropka oznacza zeby spakowalo wszystko)

         moge takze dodac domyslna klase do uruchomienia pliku jar komenda:
         jar -cfe plik.jar jakasNazwa Klasa.class



         //Aplikacje webowe - INFO
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
         odpowiedziec
        Odpowienikiem jar - skompilowanych klas webowych jest plik WAR (web archive)
         miedzy innymi sa to serwlety. Moga znajdowac sie w nim takze pliki JAR
         zawierajace niezbedne zaleznosci potrzebne do dzialania aplikacji webowej!

        Plik war instaluje sie na konterze serwletow (deploy) ktory posredniczy
         w obludze zapytan.

        1. wysłanie żądania z przeglądarki do serwera (maszyny)
        2. przekazanie żądania do kontenera serwletów/serwera aplikacji
        3. przetworzenie żądania przez serwlet/aplikację webową
        4. przekazanie odpowiedzi z kontenera serwletów do serwera
        5. wysłanie odpowiedzi do klienta (przeglądarki internetowej)

        Jednymi z najpopularniejszych serwerow aplikacji i kontenerow serwletow sa:
        Tomcat, Jetty, Glassfish, WildFly, Weblogic
          */



        //String cache i StringBuilder
        /*
        Literal znakowy jest to ciag znakow w "" np instancja klasy String.
        Intancja klasy String nie musi byc tworzeona ze slowem new
        Jesli stringi zawieraja taki sam literal to sa przechowywane w tym
         samym miejscu w pamieci chyba ze uzyjemy slowa new String("napis);

        Jest takze metoda .intern();
        Jesli wywolam ja na Stringu z konstruktorem new String("wartosc");
         i wystapi String z takim samym literalem to zostanie on "podpiety"
         pod tem sam adres (miejsce w cache) pomimo uzycia alokacji
         pamieci z uzyem slowa new np:
         */
        String mojLiteral = "jakis napis";
        String mojLiteralKopia = new String("jakis napis").intern();
        /*
        String przetrzymuje znaki w tablicy znakow char[]
        Instancje klasy String sa niemutowalne czyli kazda zmiana
         powoduje stworzenie nowego obiektu klasy String
         */

        //Przyklady metod wywolywanych na obiektach String:
        //-replace("cel","zamiana");
        //zwraca literal z zamienionymi ciagami
        mojLiteral = mojLiteral.replace("napis", "CIAG");
        //-substring(start, koniec); -substrin(start);
        //zwraca wybrana czesc lansucha
        mojLiteral = mojLiteral.substring(2,10);
        mojLiteral = mojLiteral.substring(1);
        //-toLowerCase();
        //zamienia wielkie litery na male
        mojLiteral = mojLiteral.toLowerCase();
        //-toUpperCase();
        //zamienia wszystkie litery na wielkie
        mojLiteral = mojLiteral.toUpperCase();
        //-trim();
        //obcina biale znaki na poczatku i koncu
        //-concat("ciag");
        //laczenie jak +
        String mojLiteral2 = "-nowy napis-";
        mojLiteral2 = mojLiteral.concat(mojLiteral2).concat(" dodatek-prosty ").concat(" 123 ");
        System.out.println(mojLiteral2);

        //Biblioteka zawierajaca wiele metod dla Stringa jest bo commons-lang a w niej
        // np klasa StringUtils zawierajaca wiele metod dla lancuchow znakow


        //Konkatenacja (laczenie stringow)
        /*
        Uzywany jest znak + lecz laczy on lewostronnie np
        1 + 2 + "test" // 3test
        "test" + 1 + 2 // test12
        Wyswietlajac jakas instancje klasy uzywana jest metoda tej klasy toString
         */


        //StringBuilder
        /*
        Ta klasa takze zawiera ciag w tablicy znakow char[] lecz mozna
         ja zmieniac i konwertowac do String uzywajac toString
         */
        StringBuilder mojSB = new StringBuilder("123");
        //Konstruktor moze przyjac wartosc ciagu lub jesli podam liczbe to jego
        // pojemnosc (capacity)
        StringBuilder mojSB2 = new StringBuilder();
        mojSB2.append(2).append("123").append(mojLiteral).append(12.3);
        //append moze przyjac dowolny typ


        //StringBuffer
        /*
        Mozna uzywac go bezpiecznie nawet w aplikacjach wielowoatkowych
        Jej instancje nie powinny byc wspoldzielone pomiedzy watkami
        Klasa StringBuffer ma synchronicje przez co jest wolniejsza!
         */


        //StringJouner
        //Wykorzystuje do laczenia strumieni



        //Formatter - formatowanie łańcuchów znaków



        String xyz = new Object() + " 123";
        System.out.println(xyz);
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
    static boolean czyDuza(int liczba){
        return liczba>100;
    }
    private SilnikMoj silnikMoj;
}
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
    SPOKOJNY{
        public String format(String wiadomosc){
            return "To twoja wiadomosc spokojna: " + wiadomosc;
        }
    },
    NERWOWY {
        public String format(String wiadomosc) {
            return "To twoja wiadomosc nerwowa: " + wiadomosc;
        }
    };
    public abstract String format(String wiadomosc);
}

interface Powitanie{
    void powiedzCzesc();
}