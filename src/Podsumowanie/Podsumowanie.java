package Podsumowanie;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Podsumowanie {
    public static void main(String[] args) {
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

        Klasa - projekt/foremka
        Obiekt/instancja - produkt

        Maszyna wirtualna pomaga zarzadzac pamiecia

        Wersja programu X.Y.Z
        X-wersja
        Y-funkcjonalonsci
        Z-latki

        JVM - maszyna witrualna javy np Oracle

        JRE - maszyna wirtualna tylko dla uruchamiania programow

        JDK - zestaw narzedzi zawierajacy takze kompilator javac

        IDE (ang. Integrated Development Environment)



        //------------------------------------------------------------------------
        -----------------------------ZMIENNE PROSTE-------------------------------
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
        //boxing unboxing

        //Boxing jest to przypisywanie zmiennej prostej do obiektowej
        Integer zmiennaIntegerBox = 12;

        //W przypadku typow prostych jest wykonywany automatyczny autoboxing

        int liczbaBox1 = new Integer(12);
        //operacja odwrotna czyli autounboxing
        //przypisywanie do zmiennej prostej zmiennej obiektowej

        //Zmienne finalne
        //zalecane jest pisanie wszystkiego WIELKIMI_LITERAMI i oddzielac
        // slowa "_"
        final int LICZBA_FINAL; //deklaracaj lokalna czyli w metodzie(teraz main)
        // wiec nie musze nadawac wartosci odrazu
        LICZBA_FINAL = 12;
        /*
        liczba finalana musi miec zadeklarowana wartosc chyba ze:
         -jej przypisanie wartosci jest w konstruktorze klasy
         -jest zadeklarowana lokalnie(w metodzie)

        wartosc liczby finalnej NIE MOZNA zmienic



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



        //------------------------------------------------------------------------
        --------------------------------ZMIENNA STRING----------------------------
        */

        //String jest specyficzna zmienna obiektowa


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
         jest alokowana w tym samym adresue GDY PRZYPISUJE GO POPRZEZ =
         */
        String napis1 = "test";
        String napis2 = "test";
        String napis3 = new String("test");
        //Tutaj rezerwuje specjalnie oddzielnie miejsce w pamieci
        // wiec po mimo tej samej wartosci napis3 i napis1/2 porownanie prost
        // == da false, wiec nalezy porownac to metoda .equals()

        System.out.println("Porownanie napis1 i napis2: " + (napis1 == napis2));
        //Pamietam o nawiasie bo inaczej doda moj "" do napis1 a nastepnie
        // porowna z napis2!
        System.out.println("Porownanie napis1 i napis3: " + (napis1 == napis3));

        //Porownujac zmienne obiektowe poprzez == porownuje ich adresy!!
        // a wiec pokaze false poniewaz dalem new String.
        //Poprawnym porownaniem jest metoda equals() ktora porownuje obiekty

        System.out.println("Poprawne porownanie napis 1 i napis 3: " + napis1.equals(napis3));


        //metoda String.valueOf(); - PRZYJMUJE int/Integer/String, ZWRACA String
        Integer integer4 = new Integer(1354);

        String stringZInta = String.valueOf(integer4);
        String stringZInta2 = String.valueOf(1234);
        String stringZeString = String.valueOf("123d4");



        //------------------------------------------------------------------------
        /*-------------------------ZMIENNA INTEGER--------------------------------
         */
        Integer integer = 123; //boxing
        Integer integer1 = new Integer("123123");
        Integer integer2 = new Integer(12345);


        //metoda Ingeger.parseInt(); - przyjmuje String, zwraca int/Integer
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



        //------------------------------------------------------------------------
        /*---------------------------------METODY---------------------------------

        Metoda - worek do grupujacy zestaw instrukcji. Tworzymy je
         aby zaoszczedzic pisania kodu oraz poprawic jego czytelnosc

        Metoda moze byc zwykla(odnoaszaca sie do instancji klasy/obiektu) lub
         statyczna(odnoszaca sie do klasy)

        Metoda finalna nie moze byc przeslonieta! (nadpisana w innej klasie dziedziczacej)
         final void metoda();

         */
        class Wew1 {
            public /* static */String metodaDajacaString(int liczba) {
                //nie moge dac static bo jetsem w main
                return String.valueOf(liczba);
            }

            public int metodaDajacaInt(String napis) {
                return Integer.parseInt(napis);
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
            void start() {
                String imie;
                List<String> imiona = new ArrayList<>();
                Scanner wejscie = new Scanner(System.in);

                //przyklad:
                do {
                    imie = wejscie.nextLine();
                    if (!imie.equals("-"))
                        imiona.add(imie);

                } while (!imie.equals("-"));

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
                        if(imie.equals("-")) {
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
            }
        }
        /*



        //------------------------------------------------------------------------
        -----------------------------------PAKIETY--------------------------------

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
         ------------------------------------KLASY--------------------------------

        Sluza do grupowania atrybutow/pol i metod

        Klasa moze miec modyfikator dostepu public lub zaden!

        Klasa moze byc zwykla/abstract/final!


        Klasa abstrakcyjna moze miec metody abstrakcyjne i zwykle i
         NIE DA SIE twrozyc instancji jej obiektow!

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
        class MojaKlasa{
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

        System.out.println("-------------------");
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

         Checked - musi byc obluzony np IOException

         Unchecked - nie musi np IllegalArgumentException

         Jesli wyjatek ma w swojej hierarchii TYLKO Exception/Throwable
          musi byc obsluzony, jesli cos wiecej to juz nie

         Hierarchia dziedziczenia wyjatkow:
          Throwable <- Exception <- RuntimeException <- IllegalArgumentException


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
        /*----------------------------KOLEKCJE------------------------------------

        Kolekcja to sposob grupownia obiektow, jest ona struktura danych

        lang.Iterable -> util.Collection -> util.List, util.Set, util.Queue
        util.Map


        -----
        Lista

        Charakteryzuje sie tym ze jej rozmiar moze sie zmieniac, dobra praktyka
         jest dlekarowanie ich jako typ List (List<String> list = new ArrayList<>();
         aby mozna byloby je potem bez problemu zmienic jedna na druga

        -Moga przechowywac ten sam obiekt kilka razy
        -Kolejnosc jest wazna

        Dzielimy je na:
        -LinkedList - gdy chce czesto dodawac/usuwac elementy
        -ArrayList - gdy chce  czesto miec dostep do elementow
        */

        List<String> lista1 = new ArrayList<>(3);
        //Tylko w ArrayList w konstruktorze moge podac wstepny rozmiar
        List<String> lista2 = new LinkedList<>(lista1);
        //W konstrukotrze LinkeList moge podac inna kolekcje
        // aby zostala ona przpisana do nowej LinkedLIsty


        //----
        //Metody:
        lista1.add("Kamil"); // dodanie elementu
        lista1.add(1, "Tomek");//index musi byc poprawny (nie moze byc pustego
        // elementu) bo wyrzuci wyjatek IndexOutOfBoundsException
        //dodaje na pozycje 2 element "kamil", iteracja od 0
        lista1.addAll(lista2);// dodanie wszystkich elementow z jednej kolekcji
        // do drugiej, nie nadpisze istenijacych tylko polaczy obie listy jedna
        // po drugiej!
        String wezElement = lista1.get(0);// pobierze element z pozycji 0 listy
        boolean czyZawiera = lista1.contains("kamil");// zwraca flage czt kolekcja
        // zawiera dany element
        boolean czyPusta = lista1.isEmpty();// zwraca flage czy lista jest pusta
        int liczbaElementow = lista1.size();// zwraca liczbe elementow w liscie
        // nie jaki jest rozmiar wstepny (w przypadku ArrayList)
        int pierwszeWystapienie = lista1.indexOf("kamil");
        int ostatnieWystapienie = lista1.lastIndexOf("kamil");
        lista1.remove("Kamil");//usuwam element pierwszy i element drugi przeskakuje
        // na 1 (0)
        lista1.remove(0);


        /*----
        Zbior

        Sluzy do przyechowywania unikalnych elementow, mozemy wykorzystac je
         takze aby pozbyc sie duplikatow a Liscie dodajac wszystkie elementy
         do nowego zbioru.

        -Kolejnosc nie jest istotna
        -Kazdy element jest unikatowy

        Aby miec pewnosc ze element jest juz w zbioerze nalezy zaimpelementowac
         metode hashCode oraz Equals !!

        Zbiory dzielimy na
        -HashSet - w srodku umieszczona jest tablica mieszajaca, wymaga
         implementacji hashCode oraz equals

        -TreeSet - uporzadkowywwuje elementy wg naturalnego porzedku, wymagane
         jest do tego implementacja interfejsu Comparable lub uzycie odpowiedniego
         Comparatora

        -LinkedHashSet - dodatkowo zapamietuje kolejnosc dodawnych elementow
         */
        Set<String> zbior1 = new HashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar
        Set<String> zbior2 = new TreeSet<>(zbior1);
        //Konstruktor moze przekopiowac kolekcje do nowej
        Set<String> zbior3 = new LinkedHashSet<>(10);
        //Konstruktor zawiera wstepny rozmiar


        //-----
        //Metody:
        zbior1.add("kamil");
        zbior1.addAll(zbior2);
        zbior1.remove("kamil");
        boolean czyZawiera2 = zbior1.contains("Kamil");
        boolean czyPusta2 = zbior1.isEmpty();
        int iloscElementow = zbior1.size();


        /*----
        Mapy

        -Kolejnosc nie jest istotna
        -Kazdy element kluczy jest unikatowy

        Mapa jest kolekcja pozwalajaca przechowywac odwzorowanie zbioru
         kluczy na liste wartosci. Klucze sa unikalne. Kluczami pownny byc
         obiekty ktorych nie mozna zmienic (Immutable) czyli np String
         lub Integer.
        Klasy kluczy powinny miec poprawna implementacje metod HashCode oraz
         equals.
        Dodanie istniejacego klucza do kolekcji z wartoscia nadpisze istniejaca
         wartosc starego klucza na nowa!

        Mapy dzielimy na:
        -HashMap
        -TreeMap
        -LinkedHashMap
         */
        Map<Integer, String> mapa1 = new HashMap<>(2);
        //Konstruktor zawiera wstepny rozmiar
        Map<Integer, String> mapa2 = new TreeMap<>(mapa1);
        //Konstruktor moze przkopiowac mape
        Map<Integer, String> mapa3 = new LinkedHashMap<>(23);
        //Konstruktor zawiera wstepny rozmiar


        //-----
        //metody:
        mapa1.clear();
        mapa1.put(0, "kamil");
        mapa1.putAll(mapa2);
        mapa1.get(0);// zwroci wartosc z klucza "0"
        mapa1.remove(0);// usunie klucz "0" i jego wartosc
        boolean czyKluczIstanieje = mapa1.containsKey(0);// czy mapa zawiera
        // klucz "0"
        boolean czyWartoscInsteniej = mapa1.containsValue("kamil");
        boolean czyPusta3 = mapa1.isEmpty();
        int iloscElementow2 = mapa1.size();
        Set<Map.Entry<Integer, String>> zbiorKluczWartosc = mapa1.entrySet();
        //kazdy element zbioru bedzie skladal sie z klucza i wartosci,
        // W petli foreach z typem Map.Entry<TypKlucza, TypWartosci> bede mogl
        // na elemencie wywolac metode getKey() i getValue()


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
        -BufferReade - odczyt linijka po linijce
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



        /*-------------------------------------------------------------------------
        -----------------------------SERIALIZACA-----------------------------------

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

            public Auto(){}//ta klasa musi miec konstruktor bezparametowy! - bezwglednie

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
        class Factory{
            String lokalizacjaX = "src/Podsumowanie/PlikiTestowe/plikObiektowy4.bin";
            void seriazlize(){
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacjaX))){
                    Audi audi = new Audi("audi", 120);
                    strWyj.writeObject(audi);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            void deserialize(){
                try(ObjectInputStream strWyj = new ObjectInputStream(new FileInputStream(lokalizacjaX))){
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
                Opona[] opony = new Opona[]{new Opona(12),new Opona(15)};
                Silnik silnik = new Silnik("Boxer");
                Samochod samochod = new Samochod(silnik, opony);
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja));
                ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))){
                    //zapis
                    strWyj.writeObject(samochod);

                    //odczyt
                    Samochod noweAuto = (Samochod)strWej.readObject();
                    //musze rzutowac
                    System.out.println("nazwa silnika: "+noweAuto.silnik.getNazwa());
                    Opona[] noweOpony = noweAuto.getOpony();
                    for(int i=0; i<noweAuto.opony.length; i++){
                        System.out.println("Opona "+(i+1)+" ma rozmiar : "+noweOpony[i].rozmiar);
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
        class Czlowiek implements Serializable{
            private transient Integer identyfikator;
            private transient int wiek;
            private String imie;
            public Czlowiek(Integer identyfikator, int wiek, String imie) {
                this.identyfikator = identyfikator;
                this.wiek = wiek;
                this.imie = imie;
            }
        }
        class CzlowiekFabryka{
            String lokalizacja = "src/Podsumowanie/PlikiTestowe/plikObiektowy3.bin";
            void zapisz(){
                Czlowiek c1 = new Czlowiek(2341, 27, "Kamil");
                try(ObjectOutputStream strWyj = new ObjectOutputStream(new FileOutputStream(lokalizacja))){
                    strWyj.writeObject(c1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            void oczytaj(){
                try(ObjectInputStream strWej = new ObjectInputStream(new FileInputStream(lokalizacja))){
                    Czlowiek c2 = (Czlowiek)strWej.readObject();
                    System.out.println("----------------------------");
                    System.out.println("czlowiek identyfikator : "+c2.identyfikator);
                    //pokaze null
                    System.out.println("czlowiek wiek : "+c2.wiek);
                    System.out.println("czlowiek imie : "+c2.imie);
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
        class Chinczyk extends Czlowiek{

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
         switch (rozmiar){
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
        for (KoszulkaRozmiar x : KoszulkaRozmiar.values()){
            System.out.print(x + " ");
        }
        System.out.println("\n\n"+"Wartosci Enuma rozszerzonego");
        for (KoszulkaRozmiarDokladnie x : KoszulkaRozmiarDokladnie.values()){
            System.out.print("\n"+x + " ");
            System.out.print(x.dajSzerokoscKlatki() + " ");
            System.out.print(x.dajwysokoscKoszulki() + " ");
            System.out.print(x.dajdlugoscRekawa());

        }


        //.valueOf("WARTOSC") - metoda statyczna wywolywana na nazwie enuma, pokaze
        //                       wartosc wpisanej w "" wartosci
        System.out.println("\n"+KoszulkaRozmiarDokladnie.valueOf("S"));
        //pokaze samo S
        System.out.println(KoszulkaRozmiar.valueOf("S"));
        //pokaze samo S


        //.ordinal(); - metoda wywolywana na zmiennej typu Enum,
        //              pokaze numer kolejnosci zmiennej Enuma
        //              ktora posiada wybrana zmienna (liczone od 0)
        KoszulkaRozmiar koszulka3 = KoszulkaRozmiar.XL;
        System.out.println("Numer zmiennej Enuma koszulki 3 : "+koszulka3.ordinal());
        //3 (XL jest 4 ale liczy od 0)


        //.name() - metoda wywolywana na zmiennej typu Enum,
        //           zwroci wartosc zmiennej na jakiej zostanie wywowlana metoda
        KoszulkaRozmiar koszulka1 = KoszulkaRozmiar.S;
        System.out.println("koszulka1 : "+koszulka1.name());
        //S
        KoszulkaRozmiarDokladnie koszulka2 = KoszulkaRozmiarDokladnie.M;
        System.out.println("koszulka2 : "+koszulka2.name());
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
        class KlasaGlowna{

            /*static*/ class KlasaWewnetrznaStatyczna{
            }

            class KlasaWewnetrzna {
            }
            //koniec klasy wewnetrznej!

            public KlasaWewnetrzna rozpocznij(){//metoda
                return new KlasaWewnetrzna();
                //nie musze pisac return this.new KlasaWeWnetrznaZwykla();
            }

            //Tworznie instancji klasy wewnetrznej
            public void main(){
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

                class KlasaWeWLokalna{//jestem w main
                    void powiedzCos(){
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

        for(Map.Entry<String, Integer> x : dniWMiesiacu.entrySet() ){
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
            int metoda(){
                return zmienna;
            }
        };//nie zapominam o sredniku
        System.out.println();
        powitanie.powiedzCzesc();//na obiekcie klasy wywoluje metode tego interfacu


        /*----
        Sortowanie z uzycem Collections.sort i interfacem Comparator
         z klasa anonimowa

        Metoda Collection.sort przyjmuje sama Kolekcje lub Kolekcje z Comparatorem!

        Jesli metoda przyjmuje:

        -TYLKO kolekcje z typem generycznym mojej klasy
        //Collections.sort(listaDoSortowania);
        To moja klasa musi implementowac interface Comparable z metoda
         int compareTo(Object o). Metoda zwraca >0 gdy this.wartosc jest wieksze
         od o.wartosc, <0 gdy odwrtnie i 0 gdy rowne
         UWAGA ! (metoda przyjmuje typ Object  wiec musze rzutowac)
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
         class KlasaDoSortowania2 implements Comparable{
            public String napis;
            public KlasaDoSortowania2(String napis) {
                this.napis = napis;
            }
            @Override
            public int compareTo(Object o) {
                KlasaDoSortowania x = (KlasaDoSortowania)o;
                return this.napis.length() - x.napis.length();
            }

        }
        Collections.sort(listaDoSortowania);
        System.out.println("Sortowanie 1 wg dlugosci:");
        for(KlasaDoSortowania x : listaDoSortowania){
            System.out.print(x.napis+ " ");
        }
        /*
        --
        Jesli klasa ma zmienna typu String to moge takze sprawdzic dlugosc
         napisu wykorzystujac lenght

         public int compareTo(Object o) {
                KlasaDoSortowania x = (KlasaDoSortowania)o;
                return this.napis.length() - x.napis.length();
         }
        --
         Lub jesli chce posortowac Stringi wedlug naturalnego porzadku to
          moge uzyc metody metody compareTo w compareTo!

         public int compareTo(Object o) {
                KlasaDoSortowania x = (KlasaDoSortowania)o;
                return this.napis.compareTo(x.napis);
         }


         -Kolekcje z typem generycznym mojej klasy ORAZ komparator
          Collections.sort(listaDoSortowania, new KlasaSortujaca());
         1. Moge stworzyc nowa klasa implementujaca interfejs
         Comparator<KlasaDoSortowania> i w niej metode interfejsu
         int compare (KlasaDoSortowania o1, KlasaDoSortowania o2)
         */
         class KlasaSortujaca2 implements Comparator<KlasaDoSortowania>{
            @Override
            public int compare(KlasaDoSortowania o1, KlasaDoSortowania o2) {
                return o1.napis.compareTo(o2.napis);
            }
         }
          Collections.sort(listaDoSortowania, new KlasaSortujaca());
        System.out.println("\n"+"Sortowanie 2 wg naturalnego porzadku:");
        for(KlasaDoSortowania x : listaDoSortowania){
            System.out.print(x.napis+ " ");
        }
          /*

          --
          2. Moge takze stworzyc unikalne sortowanie uzywjaac klasy anonimowej
           i definicje sortowania w wywolaniu metody sort

          Collections.sort(listaDoSortowanie, new Comparator<KlasaDoSortowania>() {
            @Override
            public int compare(KlasaDoSortowania o1, KlasaDoSortowania o2) {
                return o1.napis.compareTo(o2.napis);
            }
          });
         */



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
        System.out.println("Imie kota : "+kotMatcher.group(1));

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
        System.out.println("znacznik podkreslenia 1 : "+dopasowanieWZ.group(1));
        //znacznik podkreslenia 1 : em>jakis podkreslony tekst</em - BLAD

        Pattern wzorzecZachlanny2 = Pattern.compile("<([^>]+)>"); //poprawne
        Matcher dopasowanieWZ2 = wzorzecZachlanny2.matcher("<em>jakis podkreslony tekst</em>");
        dopasowanieWZ2.find();
        System.out.println("znacznik podkreslenia 2 : "+dopasowanieWZ2.group(1));
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
        System.out.println("Dopasownie niezachlanne {} : "+dopazsowanieWNZ.group(1));


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

    }

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
