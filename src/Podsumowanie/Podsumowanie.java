package Podsumowanie;

import java.io.*;
import java.util.*;

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
        -HashSet
        -TreeSet
        -LinkedHashSet
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
        -Kazdy element jest unikatowy

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
        // odwolujac sie do elementu 0 moge wywolac na nim metode
        // getKey() oraz getValue()


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
         w konstruktorze mojej klasy do konstruktora innej, chyba ze posiada ona konstruktor
         bezparamtrowy to nie musze (wykona sie niejawne wywolanie odwolanie do konstruktora
         bezparametrowegeo super(); )
        */

        class Auto {
            private String marka;

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



    }

}

interface Figura{
    String dajNazwe();
}