package SamouczekProgramisty;

import SamouczekProgramisty.Silnik.SilnikMoj;
import jdk.nashorn.api.tree.ForInLoopTree;

import javax.swing.*;
import java.io.IOException;
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
    class Wew1{
        boolean czyDuza(int liczba){
            return liczba>100;
        }
        void powiedzCos(){
            return;
            //Metoda void moze posiadac slowo retrun ale nie moze nic zwracac
        }
    }

        //Metoda moze takze wywolywac w wyniku inna metode i sprawdzac czy wynik
        // jest taki sam. jesli bedzie taki sam da true
        // return ! metoda();
    class WeW4{
        int a;
        public boolean isOdd() {
            return ! isEven();
        }
        public boolean isEven(){
            return a%2==0;
        }
    }

        //Metoda zwracajaca tablice:
    class WeW3{
        public String[] pokazTab(){
            return new String[]{"costma","costam2"};
        }
    }



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


        //Lista
        Charakteryzuje sie tym ze jej rozmiar moze sie zmieniac

        -Moga przechowywac ten sam obiekt kilka raz
        -Kolejnosc jest wazna

        Dzielimy je na:
        -LinkedList - gdy chce czesto dodawac/usuwac elementy
        -ArrayList - gdy chce  czesto miec dostep do elementow
         */

        //Metdoy:
        List<String> lista1 = new ArrayList<>(3);
        //Tylko w ArrayList moge podac wstepny rozmiar
        List<String> lista2 = new LinkedList<>(lista1);
        //W konstrukotrze LinkeList moge podac inna kolekcje
        // aby zostala ona przpisana do nowej LinkedLIsty

        lista1.add("kamil"); // dodanie elementu
        lista1.addAll(lista2);// dodanie wszystkich elementow z jednej kolekcji
        // do drugiej, nie nadpisze istenijacych tylko polaczy obie listy jedna
        // po drugiej
        String wezElement = lista1.get(0);// pobierze element z pozycji 0 listy
        boolean czyZawiera = lista1.contains("kamil");// zwraca flage czt kolekcja
        // zawiera dany element
        boolean czyPusta = lista1.isEmpty();// zwraca flage czy lista jest pusta
        int liczbaElementow = lista1.size();// zwraca liczbe elementow w liscie
        // nie jaki jest rozmiar wstepny (w przypadku ArrayList)
        int pierwszeWystapienie = lista1.indexOf("kamil");
        int ostatnieWystapienie = lista1.lastIndexOf("kamil");





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
