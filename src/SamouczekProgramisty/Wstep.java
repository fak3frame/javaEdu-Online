package SamouczekProgramisty;

import SamouczekProgramisty.Silnik.SilnikMoj;
import jdk.nashorn.api.tree.ForInLoopTree;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Wstep {

    public static void main(String[] args) {
        /*
        Skroty klawiszowe:
        alt + 1 - ukrycie okienka struktury projektu
        alt + strzalka - przleczanie pomiedy zakladkami
        alt + ins - dodanie pliku
        alt + del - cofniecie usuniecia

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
        // lecz mozna ja zadeklarowac bez nadawania wartosci

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

        instrukcja super() w konstruktorze klasy pochodnej wywoluje
         konstruktor klasy bazowej. ilosc wyslanych parametrow np.
         super(10, 12) decyduje ktory konstruktor zostanie wywolany

        Tworzac obiekt klasy pochodnej ZAWSZE wywola sie jakis konstruktor
         klasy bazowej w pierwszej kolejnosci. Gdy dodamy w klasie bazowej
         konstrukotr z 1 param. tez bezparametrowy zostanie usuniety przez
         co bede musial sie do niego (badz innego) odwolac tworzac obiekt
         podklasy

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
        Jesli zserializuje instanjce klasy bez tego int. zostanie wyrzucony wyjatek
         NotSerializableException.

        WYMOGI:
        Klasa ktora jest rozszerzana przez klase ktora bedzie serializowana MUSI
         miec konstrukotr bezparametrowy!

        public class Fruit {} //klasa musi miec konstr. bezparam.
        public class Apple extends Fruit implements Serializable {}//nie musi miec
        public class Tomato implements Serializable {}//nie musi miec bo dziecziczy
         //po object ktora posiada konstr. bezparametrowy

        Transient
        Gdy chcemy aby jakis pole klasy nie bylo serializowane np sekundy
         od urodzenia osoby - wynik zdeserializowany na innej JVM bylby
         bledny uzywamy przez zmienna parametru transient

         */
    class Wew25 {//////////////////////////////////
    void metoda(){///////////////////////////////////
        try(ObjectOutputStream strumienWyjsciowy = new ObjectOutputStream(new FileOutputStream("plik.bin"))){
            strumienWyjsciowy.writeObject(Integer.valueOf(1));
            //Zapisuje obiekt do stumienia
            strumienWyjsciowy.writeObject(Integer.valueOf(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream strumienWejsciowy = new ObjectInputStream(new FileInputStream("plik.bin"))){
            Integer numer = (Integer)strumienWejsciowy.readObject();
            //Odczytuje pierwszy obiekt i zapisuje go do zmiennej obiektowej
            // musze rzutowac!
            //Obiekty zostaja zapisane w kolejnosci w jakiej byly dodane czyly 1,2
            System.out.println(numer);
            numer = (Integer)strumienWejsciowy.readObject();
            System.out.println(numer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }///////////////////////////
    }////////////////////////

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
                    // a potem getNazwa z klasy Silnik
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
         ich dzialanie, nazwa zmiennych nie bedzie miala znaczenia
         ObjectInputStream strWej lub ObjectOutputStream strWyj

        W zaleznosci od zmeinnych moge dodac do strumienia pojedyncze zmienne
         pol - w takim przypadku na strumieniu WYJSCIA wywoluje konkretna metode:
         strWyj.writeUTF(stringTans); / strWyj.writeInt(liczba+10); itp

        Jesli we wlasnej metodzie dodam do strumienia pole transient, ono takze
         zostanie zserializowane

        Moge takze zachowac standardowe dodawanie obieku do strumienia dodajac metode
         strWyj.defaultReadObject();

        Moge rowniez dodac swoje zmienne w tej metodzie lub zmienic wartosc tych dodawanych


        Moge wykorzystac to na przykladzie gdy bede chcial zapisac do strumienia aktualny wiek
         i po zdeserializowniu otrzymac aktualny wiek zgodny z aktualnym rokiem

         w metodzie writeObject:
         strWyj.defaultWriteObject(); - zapisuje standardowe dane obiektu
         int wiekUrodzenia = Calendar.getInstance().get(Calendar.YEAR) - wiek
          //odejmuje od aktualnego wieku serializacji - wiek zapisanego obiektu
          // i wychodzi np 1991
         strWyj.writeInt(wiekUrodzenia) - zapisuje dodatkowo do strumienia zmienna

         w metodzie readObject:

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
                stringTans = strWej.readUTF();
                stringNormalny = strWej.readUTF();
                liczba = strWej.readInt();
            }
            private void writeObject(ObjectOutputStream strWyj) throws IOException {
                //Na poczatku moge dodac strWyj.defaultWriteObject() aby
                // zostal zapisany obiekt w calosci (wszystkie jego pola automatycznie)
                strWyj.writeUTF(stringTans);
                //wybrany typ do rodzaju zmiennej
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
         automatycznie takze go implementuje wiec takze jest serializowana

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
         writeExternal oraz readExternal
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


        String x = new Object() + "123";
        System.out.println(x);
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
