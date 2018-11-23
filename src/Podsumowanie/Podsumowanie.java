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
import java.util.concurrent.atomic.AtomicInteger;
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
        -----------------------Zlozonosc obiczeniowa------------------------------

        Do funkcji zlozonosci obliczeniowej wykorzystuje liczbe operacji algorytmu

        np funkcja liczaca sume elementow tablicy o rozmiarze n:

        public int sum(int[] numbers) {
            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
        1 operacja przypisania
        n operacji liczenia (sum+=)
        1 operacja zwrotu

        f(n) = 1 + n + 1 = n + 2
        zloznosc 0(n)


        0(1)
        Zlozonosc stala niezalezna od danych wejsciowych
        np: oblicznie sumy ciagu artmetycznego

        public int sum(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return 0;
            }
            return (numbers[0] + numbers[numbers.length - 1]) * numbers.length / 2;
        }


        0(n)
        Zlozonosc liniowa, czas rozwiązania problemu jest wprost proporcjonalny do
         wielkości danych wejściowych
        np funkcja liczaca sume elementow tablicy o rozmiarze n


        0(log(n))
        Zlozonosc logarytmiczna, czas rozwiązania zależy od wyniku logarytmu z wielkości
         danych wejściowych
        np: Na wejściu programu jest posortowana tablica liczb o długości N. Sprawdź czy
         liczba x istnieje w tablicy wejściowej. - algorytm przeszukiwania binarnego
         (dzieli na pol i ustawia max lub min na wartosc srodkowa jesli szukana liczba
         jest w przedziale przed polowa albo za)


        Ο(nlog(n))
        Złożoność liniowo-logarytmiczna. Czas rozwiązania problemu jest wprost proporcjonalny
         do iloczynu wielkości danych wejściowych i ich logarytmu
        np: Na wejściu programu jest tablica liczb. Zwróć tablicę, która będzie zawierała
         te same elementy, które są w tablicy wejściowej. Tablica wynikowa powinna być
         posortowana w porządku rosnącym. - algorytm sortowania przez scalania (merge sort)

        Ο(n^2)
        Złożoność kwadratowa np sortowanie babelkowe

        Ο(n^x)
        Złożoność wielomianowa

        Ο(x^n)
        Jest to złożoność wykładnicza, jej przykładem może być Ο(2^n)

        Ο(n!)
        Jest to złożoność typu silnia




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


        Rodzaje testow:

        - Testy jednostkowe - sprawdzenie poprawnosci dzialania pojedynczego fragmentu kodu
           (mozna wykorzystac biblioteke JUNIT)
        - Testy integracyjne - weryfikacja dzialania polaczonych elementow aplikacji
        - Testy akceptacyjne - nie wykrywaja bledu tylko potwierdzaja jakosc oprogramownia



        //------------------------------------------------------------------------
        ---------------------------PROTOKOL HTTP----------------------------------

        Protokół HTTP jest oparty na komunikacji pomiędzy klientem a serwerem.
        Klientem może być przegladarka internetowa a Serwerem aplikacja webowa
         ktora odpowiada na zadania klienta

        Zadanie (request) oraz odpowiedz (respones) moze zawierac naglowek - jest
         to czesc infromacji np rodzaj przegladarki oraz tresc - moze to byc
         np zawartosc strony internetowej

        Protokol HTTP operty jest o "czasowniki HTTP" okreslajace rodzaj zadania
         jakie wysyla klient np GET POST PUT DELETE

        Najpopulrniejszymi rodzajami zapytania jest POST (np informacje wyslane w
         formularzu) i GET (wpisanie adrsu strony URL i proba otworzenia strony)





        //------------------------------------------------------------------------
        ---------------------------WZORCE PROJEKTOWE------------------------------

        Wzorce kreacyjne:
        -budowniczy
        -fabryka
        -singleton

        Wzorce strukturalne
        -adapter
        -dekorator
        -fasada

        Wzorce czynnościowe
        -łańcuch odpowiedzialności
        -iterator
        -strategia
        -obserwator



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


        //------------------------------------------------------------------------
        --------------------------CLEAN CODE--------------------------------------

        SOLID

        Sa to zasady projektowania aplikacji

        S - Single Rensponsibility Principle (SRP) zasada jednej odpowidzialnosci
            Klasa powinna realizowac jedna funkcjonalnosc

        O - Open Closed Desig Principle (OCD) zasada otwarty-zamkniety
            Otwarty na rozszerzenia, zamkniety na modyfikacje

        L - Liskov Substitution Principle (LSP) zasada podstawienia Liskov
            Funkcje przyjmujace jako argument klasy bazowe musza tez umiec
             oblsluzyc obiekty klas pochodnych

        I - Interface Segregation Principle (ISP) zasada segregacji interfejsow
            Powinno sie przygotowac kilka specyficznych inrefrejsow niz jeden
             zbiorczy

        D - Dependency Inversion Principle (DIP) zasada odwrocenia zaleznosci
            Moduły wysokiego poziomu nie powinny zależeć od modułów niskiego poziomu
            Detale powinny zależeć od abstrakcji a nie odwrtonie.

        Dependency Inversion Principle - Klasa niskiego poziomu nie powinna miec
         zmiennych poziomu nizszego tylko interfejsu jaki implementruje klasa
         nizszego posiomu

        Inversion of Control - Odwrocenie kontroli, np cykl zycia serwletu - to kontener
         wywoluje odpowiednie metody w odpowiednim czasie a nie ja np metoda init

        Dependency Injection - wstrzykiwanie zaleznosci - jest to mechanizm pozwalajacy
         na dostarczenie odpwiednich zaleznosci na potrzeby dzialania obiektu.
         Moze to byc realizowane za pomoca adnotacji, seterow czy mechanizmow refleksji
        Bez wstrzykiwania wszystkie zaleznosci trorzone sa przez obiekt przec co testownie
         jest trudne



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
        Nie sa one bezpieczne do pracy z wieloma watkami poniewaz moge ustawic ich
         zasieg(singleton jest bezpieczny w zaleznosci od implementacji natiomiast
         w prototype za kazdym razem jest tworzony nowy obiekt)


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


        Plik konfiguracyjny Springa jest to plik XML ktory zawiera informacje o
         klasach ktore beda uzywane w aplikacji
        Zawiera konfiguracje klas oraz ich polaczenia
        Czytelnosc pliku XML jest wygodna


        Zamiennikiem konfiguracji XMLa jest konfiguracja przez adnotacje
         (klasa konfiguracyjna @Configuration z adnotacjami @Bean)

        Dzieki niej latwiej znalezc blad (w XML latwo o ilterowke)
        Jeslie wystapi blad bedzie to wiadome juz podczas kompilacjie programu
         a w przypadku XMLa dopiero podzczas dzialania programu
        Latwiejszy jest tez proces debugowania, refaktoringu i poruszania sie po
         strukturze aplikacji niz w przypadku konfiguracji przez XML


        Programowanie aspektowe w Springu (Aspect Oriented Programming) polega na
         rozdzieleniu aplikacji na moduly
        W programowuaniu obiektowym najwazniejsze sa obiekty a w askepktowym
         aspekty
        Aspekt jest to taka funkcjonalnosc ktora ma wplyw na cala aplikacje i
         jest wykonywana przez caly przekroj aplikacji
        Przykladem moze byc aspekt raportowania poniewaz raporty sa potrzebne
         w roznych czesciach aplikacji
        Tworze jeden modul raportowania ktory uzywny jest w roznych miejscach
         aplikacji

        Punk laczenia (JoinPoint) - jest to miejsce w aplikacji w ktorym moge podpiac
         aspekt np wywolanie metody czy modyfikacja pola


        Porada (Advice) - jest to akcja wykonywana przez aspekt w konkretnym punkcie
         przylaczenia
        Porady moga miec rozne typy czyli gdzie zostana uzyte:
        - Before - przed punktem przylaczenia (adnotacja @Before)
        - After retrurning - po wykonaniu (aspekt zostanie wykonany po czynnosci
           w punkcie przylaczania (adnotacja @AfterReturning) pod warunkiem
           ze metoda zakonczy sie poprawnie
        - After throwing - aspekt zostanie wykonany po wyrzuceniu przez metode bledu
           (adnotacja @AfterThrowing)
        - After - aspekt zostanie wykonany po wykonaniu metody niezaleznie od tego
           czy wyrzuci ona blad (adnotacja @After)
        - Around - aspekt zostanie wykonany przed i po punkcie w ktorym jest przylaczony
           (adnotacja @Around)


        Glowne moduly Springa:

        Spring Core Container podstawa frameworka, zawierajacy moduly:
        -Spring Core, Spring Bean - zapewnia podstawowe czesci frameworku
          takie jak odwrocenie kontroli czy wstrzykiwanie zaleznosci
        -SpEL (Spring Expression Language) uzywany w warstwie widoku do
          mnipulacji opiektu
        -Spring Context - umozliwia dostep do skonfigurowanych i zdefiniowanych
          w Springu obiektow

         Web - do aplikacji webowych

         Data Access/Integration (dostęp do danych i ich integracja):
         -JDBC (Java DataBase Conectivity)
         -ORM (Object Relational Mapping) - moduł ten zapewnia warstwę integracji
          dla popularnych frameworków takich jak Hibernate czy JPA
         -OXM (Object/XML Mapping, czyli mapowanie XML-owe)
         -JMS (Java Message Service)
         -Transaction

         AOP (Aspect Oriented Programming) oraz Instrumentation

         Test – moduł ten zawiera framework testowy, który wspiera componenty
          Springa przy użyciu JUnit oraz TestNG. Zawiera również mocki obiektów



         Spring Security

         Jest to wewnetrzny framewrk springa ktory odpowiada za uwierzytelnianie
          i autoryzacje

         Dziala na zasadzie filtrow ktore musi przejsc kazde zapytanie do aplikacji

         Moge dzieki niemu okreslic do jakiej czesci aplikacji ma dostep uzytkownik
          zalogowany/niezalogowany czy admin



         //JPA

         Jpa - Java Persistence API - jest to zbior interfejsow potrzebnych aby
          przeprwadzac operacje na bazach danych

         Jpa samo w sobie nie jest w stanie wykonac operacji na bazie danych

         Jpa pozwala tez w wygody sposob na mapownie obiektow javy do relacyjnych
          baz danych za pomoca adnotacji lub plikow konfiguracyjnych XML


         Hibernate jest najpopularniejsza implementacja standardu JPA

         Plik XML zawiera informacje na temat bazy danych (np nazwa uzytkownika/haslo)
          oraz zawiera informacje o encjach w aplikacji
         Plik ten powinien być przechowywany w folderze META-INF w projekcie

         Persistance context - zajmuje sie wstawianiem encji (entities) przechowujacych
          dane ktore beda zapisane w bazie danych
         Jego glywnym zadaniem jest sprawdznie czy w EntityManagerze wystepuje dokladnie
          jeden obiekt danej encji

         Jezeli klasa ma byc zachowana w bazie danych umieszczam przed nia adnotacje
          @Entity. Obiekt tej klasy bedzie jednym rekordem w tabeli


         Manager Encji (EntityManager) - jest posrenikiem pomiedzy aplikacja a baza danych

         Dzieki niemu moge np wyszukac obiektu w bazie danych, dodac, usunac lub zrobic
          update

         Rodzaje EntityManager:
         - EntityManager zarządzany przez kontener i o zakresie transakcyjnym
            (Container Managed and Transaction Scoped Entity Manager),
            EntityManger moze byc zarzadzany nie przez aplikacje ale przez
             kontener np Springa np do utworzenia transakcji @Transactional
            W przypadku gdy aplikacja mialaby to robic nalezaloby wywolac
             odpowiednie metody EntityManagera np. by otworzyć transakcję musielibyśmy
             wykorzystać entityManager.getTransaction.begin() (pobranie transakcji z EM
             a następnie jej otwarcie), natomiast aby ją wykonać musielibyśmy wywołać
             entityManager.getTransaction.commit().
         – EM zarządzany przez kontener i o rozszerzonym zakresie
            (Container Managed and Extended Scope Entity Manager),
            Polega ona na tym ze jesli w beanie wywolana zostanie metoda o tranzakcyjnym
             zakresie to tranzakcja zostanie automatycznie rozpoczeta przez kontener
             i zostanie utworzony nowy persistence context (do którego mam dostep przez EM)
            Kiedy wykonywanie metody dobiegnie końca, transakcja oraz kontekst zostaną zamknięte
             automatycznie, zaleta tego rodzaje EM jest bezpiczna praca z wieloma watkami
         – EM zarządzany przez aplikację (Application Managed Entity Manager).
            W tym przypadku czas trwania persistance context jest powiazany do czasu trwania
             beana, EM moze w tym czasie wykonac wiele metod tzn ze jest dzielony przez wszytkie
             metody


          persistent Fields (pola trwale) - dostep do danych odbywa sie bezposrenio przez
           pola danej encji - pola z adnotacja @Transient zostana zapisane

          persistent Properties (trwale wlasciwosci) - pola encji musza posiadac setery i getery
           a adnotacje sa zakladane na getery pol


          Cykle zycia JPA:

          - Nowa/przejściowa (new/transient) - utworzony zostal obiekt danej encji ale moe kesy jest
             jeszcze podlaczony pod zaden obiekt EM czyli istnieje tylko w aplikacji, w przypadku
             wykonania danej transakcji, nie zostanie zapisany do bazy danych

          - Zarządzany/trwały (managed/persisted) - obiekt jest podlaczony do EM za pomoca metody
              persist i jest przez niego zarzadzany. Wykoanie transakcji zapisze obiekt do bazy danych
             Jesli wykonam zmiany na obiekcie encji to zapisany obiekt do bazy danych takze bedzie
              zawieral zmiany

          - Oderwane (detached) - specjalny stan encji i nie jest ona zarzadzana przez EM ale dalej
              reprezentuje obiekt w bazie danych. Uzywane sa jesli chce przekazac obiekt do
              uzytkownika koncowego. Zmiany na takim obiekcie nie zostana zapisane do bazy dancych
              chyba ze podlacze encje pod EM

          - Usunięta (removed) - obiekt jest usuniety z bazy danych, tak jak metoda persist()
             musi byc wykonana w trakcjie trwania transakcji


          Nowa -persist-> Pod kontrola EM [ Zarzadzana <-remove/persist-> Usunieta]

          baza<-commit- Zarzadzana <-find-baza      Zarzadzana-clear/close->Oderwana

          Zarzadzana<-remove/persist->Usunieta

          baza<-commit- Usunieta                    Usunieta-clear/close->Oderwana


          W JPA przy kazdej transakcji tworzony jest obiek EntityManager przez EntityManagerFactory
          EntityManagerFactory jest to obiekt typu singleton gdzie trzymana jest pula polaczen do
           bazy danych
          EntityManager jest to obiekt sesji ktory tworzy sie nowy za kazdym razem gdy ma sie wykonac
           jakas operacja na bazie danych
          W Hibernate EMF nazywa sie SessionFactory a EM Session
          Spring sam umie zarzadzac SessionFactory i Session




          JPQL (Java Persistence Query Language) - jest to jezyk uzywany do operacji
            na relacyjnych bazach danych i jest czescia JPA. Skladania jest podobna
            do standardowego SQL
           Wykorzystuje aby szybko stworzyc zapytanie do bazy danych bez potrzeby tworzenia
            obiektu CriteriaBuilder i zapytan przy jego pomocy
           Zapytania JPQL przechowujemy w adnotacji @NamedQuery, która zawiera się w @NamedQueries
            i jest przechowywana w danej encji, którą ma zwracać zapytanie.
           Zapytania wywoluje przy pomocy EntityManagera z uzyciem metody createNamedQuery().



        Serwlet to klasa, która implementuje interfejs Servlet. Instancje tej klasy tworzone są
         przez kontener serwletów (na przykład Jetty). Instancje te wiedzą jak odpowiadać na żądania,
         które dostają od klienta.

        Kontener zarządza cyklem życia serwletu używając metod z tego interfejsu. Wyszukuje serwletow
         w aplikacji i tworzy ich instancje - kontener moze wyszukac je takze za pomoca pliku XML
         (potrzebna adnotacja)
        Kontener takze zarzadza zyciem komponentow (np Listnery)

        Do obsługi żądania klienta służy metoda service. Metoda ta przyjmuje jako parametry żądanie
         i odpowiedź. Na podstawie parametrów żądania odpowiednio modyfikuje przekazany argument
         odpowiedzi.

        Klasami upraszczajacymi tworzenie serwletow sa GenericServlet i HttpServlet - wazniejsza
        Mozna dziedziczyc po tych klasach nie trzeba pisac metody service tylko np jesli
         chce obluzyc zadanie GET pisze metode doGet (sa tez doPost, doPut)

        W interfejsie serwletów znajdują się też metody, które są wykorzystywane w trakcie cyklu
         życia serwletu


        Cykle zycia Serwletu:

        - Kontener szuka klas serwletow i tworzy ich instancje

        - Inicjalizacja serwletu - kontener nie przekazuje paramtrow do konstruktora tych klas
           Metoda init jest wywolywana przez kontener o inicjalizacji stanu

        - Obsluga zadan - kontener uzywa instancji do obslugi zadan czyli wywolania metody
           service

        - Zniszczenie serwletu - przed zniszczeniem wywolywana jest metoda destroy ktora moze
           np sluzyc do zamkniecia polaczenia z baza danyc, kontener decyduje jak dlugo zyje
           serwlet


        Plik WAR zawiera:

        - serwlety
        - strony jsp
        - inne klasy Java
        - zeleznosci aplikacji wbowej
        - statyczne pliki (np html/css)
        - pliki konfiguracyjne aplikacji webowej







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
        //------------------------KLASA AtomicInteger-----------------------------

        System.out.println();
        //java.util.concurrent.atomic

        AtomicInteger atomicInteger = new AtomicInteger(123);
        AtomicInteger atomicInteger2 = new AtomicInteger();
        //moze miec pusty konstruktor i zmienna przyjmie 0

        //Metody:
        int theValue = atomicInteger.get();
        //pobranie wartosci

        atomicInteger.set(234);
        //ustawienie wartosci poza konstruktorem

        int expectedValue = 234;
        int newValue = 222;
        atomicInteger.compareAndSet(expectedValue, newValue);
        //jesli wartosc atomicInteger bedzie rowna expectedValue to ustawi newValue
        // jesli nie - nie zrobi nic


        System.out.println("getAndAdd = "+atomicInteger.getAndAdd(10));
        //.getAndAdd zwroci wartosc AI a nastepnie doda 10 (222, 222 + 10)

        System.out.println("addAndGet = "+atomicInteger.addAndGet(10));
        //.addAndGet doda 10 do wartosci AI i ja zwroci (232 + 10, 242


        System.out.println("decrementAndGet = "+atomicInteger.decrementAndGet());
        //.decrementAndGet zmniejszy AI o 1 i zwroci (242-1, 241)

        System.out.println("getAndDecrement = "+atomicInteger.getAndDecrement());
        //.getAndDecrement zwroci AI i zmniejszy o 1 (241, 241-1)
        System.out.println();



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
            public Budynek b = new Budynek();
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

    //CIAG Fibonacciego

    public static int fib(int n){
        if ((n==1)||(n==2))
            return 1;
        else
            return fib(n-1)+fib(n-2);
    }

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



//--------------------------------------------------
/*-------------------SPRING------------------------------


@SpringBootApplication
//@ComponentScan({"com.dekar.ProjektDekar.aplikacja", "com.dekar.ProjektDekar.component"})
//@ImportResource("classpath:config/spring-config.xml")
//@PropertySource("classpath:rycerzFinalRepository.properties")
@EnableScheduling

//@EnableAutoConfiguration(exclude = {JndiConnectionFactoryAutoConfiguration.class,
//DataSourceAutoConfiguration.class,
//HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
// DataSourceTransactionManagerAutoConfiguration.class})

public class ProjektDekarApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjektDekarApplication.class, args);



		/*
		@Value
		@Autowired
		@Component
		@Configuration - klasa konfiguracyjna
		@Service - posrednik pomiedzy kontrolerem a repo
		@Controller - mapuje
		@SpringBootApplication - glowna kalsa
		@ComponentScan - import class
		@ImportResource - import xml
		@PropertySource - import properties
		@PostConstruct @PreDestroy
		@RequestMapping - jaki adres w argumencie adnotacji ma byc jakim plikiem html
						  zwracanym przez metode z ta adnotacja
		@EnableScheduling - wlacz timer - dodaje w klasie glownej
		@Bean(name = "lancelot") - metoda tworzaca bean w klasie @Configuration
		@Scope("prototype") - zasieg (w klasie konf po @Bean/ w klasie komponent/ w xml
		@Qualifier(value = "lancelot") - wybor beana jaki ma byc wstrzykniety po nazwie
		@Primarty - ustawienie beana jako glownego w klasie konf - gdy nie mam podanego
					Qualifier i bede szukal beana w kontenerze po TYPIE
		CommandLineRunner




		Spring

		Kolejnosc dzialania aplikacji Spring
		1. Start aplikacji
		2. Uruchamiany jest kontext springowy
		3. Skanuje on klasy szukajac z adnotacja @Component (beanow) w folderze gdzie jest klasa
		    startowa ProjektApplication z GŁOWNA metoda run oraz w folderach wyzej *standardowo
		4. Kontekst standardowo tworzy obiekty tych klas i wrzuca je do kontenera pod nazwa tej
		    klasy pisane z malej litery Zamek -> zamek i jest to robione na zasadzie mapy
			tj. nazwa klasy jest kluczem a obiekt wartoscia zamek -> obiektZamku
		   Gdy utworzy obiekt takiej klasy uruchamia metode z adnotacja @PostConstruct
		   W pierwszej kolejnosci uzupelniany jest kontener obiektami komponentow ktore
			nie maja pol z adnotacja @Autowired aby moc je wstrzyknac do nich wartosci
			majac pelny kontener klas @Component z polami potrzebymi do wstrzykniecia.
		   Gdy jakas klasa posiada pole innej klasy z adnotacja @Autowired, kontekst
			wtrzykuje jej wartosc z kontenera. Jesli nie znajdzie wyrzuci blad ze pole
			wymaga beana klasy ktora nie istnieje lub nie ma adnotacje @Component

		  Moge dodac opcje przeszukiwania gdzie kontekst ma szukac komponentow dodajac w klasie
		   glownej po adnotacji SprinngBootApplication adnotacje @ComponentScan gdzie moge
		   wprowadzic foldery lub klasy pojedynczo w liscie
		  Inna metoda przeszukiwania komponentow jest dodanie w klasie SpringBootApplication
		   dodanie adnotacji @ImportResource i opis dzialania kontekstu z klasami w pliku
		   XML
		  Ostania metoda konfiguracji kontekstu jest dodanie klas/y konfiguracyjnych
		   z adnotacja @Configuration w ktorych deklaruje metody zwracajace beany (obiekty),
		   dodatkowo moge w takiej klasie dodac takze plik XML, klasa taka nie wymaga importu
		  Wszystkie metody tworzenia benow do kontera łacza sie i moge nawzajem z siebie korzystac!
		   tj klasy z @Component, z pliku XML oraz z klas konfiguracyjnych
		5. Po uzupelnieniu kontenera wywolywane sa metody run z klas implementujacych
			inerace CommandLineRunner
		5. Po zakonczeniu nastepuje niszczenie beanow i zamykanie kontekstu + wywolanie
			metod jesli sa z adnotacja @PreDestroy

        //Uklad folderow
		-Klase głowna SpringBootApplication z metoda statyczna run tworze w glownym folderze
		  np AplikacjaDekar
		-Klasy zwykle tj ktorych obiekty bede tworzyl, takze @Component tworze w folderze domain
		  w folderze glownym
		-Klasy konfiguracyjne @Configuration w folderze config w folderze glownym
		  np. MainConfig, RycerzConfig (nie wymagaja importu)
		-Klasy @Repository czyli te z jednym obiektem do tworzenia obiektow innych
		  klas tworze w foldrze domain -> repository np. RycerzRepository
		-Klasy @Service - logik biznesowych czyli tam gdzie tworze metody jak operowac na
		  obiektach klas repository tworze w folderze glownym w services np.ZadanieService
		  Sa one posrednikiem pomiedzy klasami @Controller a @Respository aby moc
		  zapisac obiekt lub go wyciagnac + wykonac jakas filtracje
		-Klasy kontrolerow @Controller tworze w folderze glownym w controllers np HelloController
		  i sluza np do tego aby zmapowac metode @RequestMapping("/hello") i zwrocic w niej
		  nazwe pliku html

		-Pliki ze zmiennymi tworze w folderze resources, plik glowny - appliction.properties
		  *(glowny nie wymaga importu, innt juz tak) nazwa innego pliku np. rycerz.properties
		  *(import np: @PropertySource("classpath:zamek.properties"))
		-Konfiguracje XML tworze w folerze resources a w nim config glowyny spring-config.xml
		  lub dodatkowe np: rycerz-config.xml, *(XML wymaga importu w klasie glownej lub
		  konfiguracyjnej @ImportResource("classpath:config/spring-config.xml"))
		-Pliki HTML zwykle tworze w folderze resources a w nim folder static np
		  hellowrold.html
		-Pliki HTML do obslugi przez thymeleaf w folderze resources -> templates
		  np. rycerze.html


		Klasy oznaczane adnotacja @Component sa Spring beanami / komponwntami

		Konekst musi skorzystac z jakiegos konstrukora klasy ktora jest
		 komponentem - @Component - Spring bean!

		Klasy implementujace interface CommandLineRunner maja metode run ktora
		 uruchamiana jest po wczytaniu do kontenera wszystkich beanow (klas z
		 adnotacja @Component lub tych okreslonych w pliku XML lub klasach
		 konfiguracyjnych)

		Komponent moze posiadac takze metody ktore wywoluja sie po stworzeniu jej obiektu
		 przez kontekst oraz przed zniszczeniem. Uzywam do tego adnotacji @PostConstruct
		 oraz @PreDestroy przed nazwa metody


        //Konfiguracja tworzenia komponentow
		Konfigracje beanow moge zrobic na 3 sposoby:
		 -za pomoca bezposredniej adnotacji @Coponent przed nazwa klasy
		 -poprzez plik xml + dadanie w klasie SpringBootApplication lub klasie
		   konfiguracyjnej adnotacji @ImportResource("classpath:config/spring-config.xml")
		   aby zaimporotwac ten plik xml
		 -z uzyciem klasy konfiguracyjnej @Configuration - nie wymaga importu
		   + opconlne zaimportowanie do niej pliku xml
		   @ImportResource("classpath:config/spring-config.xml")

		Beany umieszczone za pomoca wszystkich metod do kontnera maja do siebie dostep!

		Podstawowa konfiguracja rozpoczyna sie porzez dodanie adnotacji @Component

		Jesli chce skorzystac z baz danych czyli zmiennych DataSource
		 czyli np ustawienie ich adresu, uzytkownikow itp uzywam konfiguracji przez
		 klasy konfiguracyjne @Configuration
		Uzywam tez dla Spring MVC czyli np gdzie sa nasze strony internetowe, templety itp
		Ustawienia spring beanow przez klase konfiguracyjna polega na stworzeniu metod
		 zwracjacych dany spring bean + wstrzykiwanie danych w srodku tej metody

		Konfiguracje XML uzywam w starszych aplikacjach i duzych projektach
		Polega ona na stworzeniu tagow bean z nazwa beana i jego adresem klasy +
		 operacje wstrzykiwnia prze konstruktor lub seter
		Importuje konfiguracje przez @ImportResource("classpath:config/spring-config.xml")



        //Wstrzykiwanie zaleznosci
		Wstrzykiwanie zaleznosci jest to uzupenienie danymi z kontenera za pomoca
		 metod (seterow), konstrukora lub bezposrenio do pol klasy

		Wstrzykiwanie zaleznosci z adnotacja @Autowired musi zostac zrealizowane
		 i polega ono na automatycznym wstrzykiwaniu po uruchomieniu kontekstu i
		 uzupelnieniu kontenera Spring beanami.
		Wstrzykiwanie STANDARDOWO z ta adnotacja polega na szukaniu w kontenerze
		 zmiennej/beana PO TYPIE! wiec jesli sa 2 jednego typu powstanie blad.
		 Aby to naprawic musze wstrzyknac bean po nazwie podajac adnotacjie @Qualifier
		@Autowired moge przypisac do pola (wstrzykiwanie przez reflection API), setera i
		 konstrukora
		Po uzupelnieniu kontenera kontekst wstrzykuje wartosci z kontenera do
		 seterow/pol/konstruktorow z ta adnotacja.

		Wstrzykiwanie w XML
		 przez konstruktor:
		 <constructor-arg index="0" value/ref="Pszemek"/>
		 constructor-arg index okrezla ktory parametr okreslam natomiast
		  value okresla konkretna wartosc a ref inny Bean
		 w xml nie moge wstrzykiwac bezposrenio do pol tylko musze przez seter:
		 <property name="zadanieProsty" value/ref="zadanieProsty"/>
		 UWAGA: property name jak w przykladnie wyzej okresla nazwe metody
		  czyli w klasie MUSI ona nazywac sie setZadanieProsty

		Wstrzykiwanie w klasach konfiguracyjnych jest przez metode @Bean
		 zwracajaca dany bean. W metodach klasy konfiguracyjnej tworze obiekty
		 wybranej klasy i wstrzykuje innego beana poprzez wywolanie innej metody
		 zwracajacej bean np ZamekProsty zamekProsty = new ZamekProsty(rycerzProsty());
		Lub opcjonalnie tworze @Autowired ze zmienna wybranego typu



		//----Przypisywanie wartosci z @Value + plik properties

		Pola typow prostych moge takze uzupelnic wartoscia z adnotacja @Value robiac
		 to bezposrenio (z = ) lub @Value lub korzystajac z pliku properties w parametrze
		 @Value

		Moge przypisac wartosc besposrenio w adnotacji @Value("Lancelot") *jest to
		 rzadko spotykane (przypisuje wartosci "Lancelot") dziala to tak samo
		 jak bym przypisal wartosci przez "=" ale tak przypisze to kontekst

		Moge przypisac wartosc takze z pliku application.properties - dodaje do niego linijke
		 z nazwa zmiennej np moj.zamek.nazwa=SUPER ZAMEK, a w adnotacji moge sie do niej odwolac
		 np: @Value("${moj.zamek.nazwa}")

		Moge takze uzyc wartosci domyslnej jesli nie jest uzupelniona taka wartosc w pliku
		 properties wpisujac po : wartosc tj. @Value("${moj.zamek.nazwa:SUPER NAZWA}")
		 wiec jesli w pliku application.properties nie znajdzie wartosci dla nazwy
		 zmiennej moj.zamek.nazwa to przypisze jej wartosci "SUPER NAZWA"

	 	Moge takze stworzyc WLASNY plik properties w folderze resources lecz aby klasa
	 	 zaczela korzystac takze z niego musze dodac kolejna adnotacje PropertySource
	 	 z classpath zaraz po adnotacji @Component np:
	 	 @PropertySource("classpath:zamek.properties")
	 	Moge to zrobic w klasie SpringBootApplication lub tej w ktorej korzystam z @Value
	 	UWAGA! jesli application.properties ma takze potrzebna zmienna to kontekst pobierze
	 	 ja najpierw z tego pliku a nie z mojego


		//----Uruchamianie aplikacji + obsluga zmiennej context

		Aplikacja uruchamiana jest z klasy z adnotacja @SpringBootApplication
		 w ktorej w main wywoluje statyczna metode main z klasy SpringApplication
		 i wysylam do niej plik class mojej klasy glownej tj. z adnotacja @SpringBootApplication
		 np ProjektDekarApplication.class oraz args z maina.
		Ta metoda zwraca kontekst
		 SpringApplication.run(ProjektDekarApplication.class, args);

		Taki kontekst moge przypisac do zmiennej typu ConfigurableApplicationContext
		ConfigurableApplicationContext ctx = SpringApplication.run(ProjektDekarApplication.class, args);
		Ta zmienna zawiera teraz caly konteks i moge z niego wyciagnac obiekty klas
		 czyli tych z adnotacja @Contekst - bean. np:
		 Zamek zamek = (Zamek)ctx.getBean("zamek");
		 musze rzutowac bo metoda zwraca obiekt typu Object!


		//----Inne przeszukiwanie komponentow

		Aby kontekst mogl przeszukiwac komponenty w innych miejscach niz standardowo moge w klasie
		 glownej dodac adnotacje po SpringBootApplication @ComponentScan i podac foldery do
		 przeszukiwania czyli liste wartosci np:
		 @ComponentScan({"com.dekar.ProjektDekar.aplikacja", "com.dekar.ProjektDekar.component"})
		 W przypadku jesli klase przeniose do innego folderu powstanie blad

		Moge takze dodac recznie kazda klase ktore sa komponentami
		 @ComponentScan(basePackageClasses = {Starter.class, StarterProsty.class, Rycerz.class,
		 RycerzProsty.class, Zadanie.class, ZadanieProsty.class, Zamek.class, ZamekProsty.class,
		 TestComponent.class})
		Dzieki takiemu podejsciu importuje te klasy wiec jesli je przeniose je do innego folderu
		 za pomoca refaktoringu to zmieni sie takze ich adres w takim imporcie!


		 //----Scope - zasieg beana

		 Kazdy bean ma swoj zasieg - scope
		 Domyslnie jest on ustawiony na singleton czyli jeden bean ma jedna instancje
		 @Scope("singleton")

		 Aby to zmienic ustawiam scope na prototype
		 Po adnotacji @Component dodaje @Scope("prototype")
		 Przez to, gdy bean ma wstrzyknac zaleznosc do innego beana to za kazdym wstrzyknieciem
		  bedzie tworzona NOWA NIEZALEZNA instancja tego beana przez co zmiana kazdej z nich
		  w klasach do ktorych zostala wstrzyknieta nie bedzie miala wplywu na pozostale
		  beany tego samego komponentu!

		 Dla klasy konfiguracyjnej aby jej metoda tworzaca beana ustawiala go jako nowy
		  niezalezny obiekt dodaje po adnotacji @Bean andotacje @Scope("prototype")

		 W XML w linijce bean dodaje kolejny atrybut scope="prototype"
		  <bean id="rycerzProsty" class="com.dekar.ProjektDekar.Aplikacja.domain.RycerzProsty"
		  scope="prototype">


		//----Tworzenie kilku beanow jednego komponentu (typu, np z inna nazwa ale ten sam typ)

		Za pomoca klasy konfiguracyjnej:

		Tworze metody jak wczesniej zwracajace obiekt wybranego beana razem z adnotacja
		 @Bean tylko zmieniam nazwe metody na wybrana lub podajac parametr name w @Bean
		 i moge stworzyc kilka metod zwracajcych ten sam typ beana ale z inna nazwa

		Teraz moge w cialach metod ustawiac takze niezalezne dane

		Powienienem tez uzyc nie nazwy metody jako nazwy beana tylko dodac do adnotacji @Bean
		 paramet name = "lancelot" to nazwe beana bedzie bralo z niego


		Standardowo adnotacja @Autowired wstrzykuje za pomoca TYPU czyli nazwa beana
		 w kontenerze jest taka jak jego typ np rycerz -> obiektRycerza i jest tylko
		 jeden bean tego typu

		Jesli bede mial w kontenerze 2 beany tego samego typu ale z inna nazwa np:
		 percival -> obiektRycerz, lancelot -> obiektRycerza
		 i kontekst bedzie chcial wstrzyknac to powstanie blad
		 @Autowired
		 Rycerz rycerz

		Aby wybrac bean do wstrzykniecia za pomoca nazwy uzywam adnotacji @Qualifier

		W przypadku pol lub seterow z pojedynczym parametrem moge uzyc adnotacji
		 po @Autowired np:
		 @Autowired
		 @Qualifier(value = "lancelot")
		 Rycerz rycerz;

		 @Autowired
		 @Qualifier(value = "lancelot")
		 public void setRycerz(Rycerz rycerz){this.rycerz = rycerz;}

		W przypadku konstruktora lub setera z 1 lub wiecej parametrem wpisuje
		 @Qualifier przed przyjmowanym parametrem:
		 public Zamek(@Qualifier(value = "lancelot") Rycerz rycerz)
		 void setRycerz(@Qualifier(value = "lancelot") Rycerz rycerz)

		Jesli jednak nie mam okreslonego @Qualifier we wstrzykiwaniu moge
		 w klasie konfiguracyjnej dac adnotacje @Primary dla JEDNEJ metody
		 tworzacej dany typ beana aby stworzony bean po mimo innej nazwy byl
		 traktowany jako glowny czyli brany po TYPIE! czyli np:
		 @Bean(name = "lancelot")
		 @Primary
		 rycerz -> obiektRycerza (metoda ustawia go jako "lancelot" ale w kontenerze
		  bedzie jako rycerz i brany bedzie po typie!)


		Konfigruajc XML dodaje kolejnego beana z innym id niz nazwa klasy bo
		 id to traktowane jako nazwa beana ktory bedzie umieszczony do kontenera.
		Moge stworzyc kilka beanow o roznym id i tym samym typie (adres klasy)
		Jako parametr ref wpisuje nowe id - dla konstruktora i setera!
		 PAMIETAM ZE W XML WSTRZYKUJE PRZEZ SETERY

		Ustawienie primary robie w linijce bean dodajac parametr primary na true
		 <bean id="rycerzProsty" class="com.dekar.ProjektDekar.Aplikacja.domain.RycerzProsty"
          primary="true">


        //----Wstrykiwanie do listy/zbioru

        Jesli wstrzykuje do listy/zbioru moge usunac @Qualifier bo moze zostac wstrzykniete
         kilka elementow

        W metodzie toString liste moge wyswietlic LISTE za pomoca strumienia
         rycerze.stream().map(Objects::toString).collect(Collectors.joining(","));

        Jesli uzywam ZBIORU jako kolekcji - kazdy element jest unikalny wiec klasa ktora
         bedzie wstrzykiwana musi generowac odpowiedzni hashcode na podstawie wybranych
         zmiennych ktore beda wybierac czy element jest unikalny!


        Jesli chce aby wstrzyknac do listy unikalnych rycerzy moge stworzyc nowa klase
         korzystajaca z konstruktora klasy bazowej np RycerzDuelujacy lecz jest to metoda brzydka


        Wstrzykiwanie do map moge zrobic TYLKO za pomoca XMLa

        Wstrzykiwanie list/zbiorow przez XMLa polega na zagniezdzeniu tagu property i takze
         robie to za pomoca setera w klasie!!
         <property name="rycerze">
            <list> //lub <set>
                <ref bean="percival"/> lub <value type="costam"/>
                <ref bean="lancelot"/>
            </list>
        </property>
        w klasie zamek trworze liste List<Rycerz> rycerze = new ArrayList<>() i setera:
        public void setRycerze(List<Rycerz> rycerze) {
        	this.rycerze = rycerze;
    	}

        Dla map uzywam podobnej konstrukcji
        <property name="rycerze">
            <map>
                <entry key="lancelot" value-ref="lancelot"/>
                <entry key="percival" value-ref="persival"/>
            </map>
        </property>


		//----Dodanie interwalow czasowych

		Sluzy do tego taskrunner ze springa
		W klasie SpringBootApplication na poczatku dodaje adnotacje @EnableScheduling
		Taskrunner bedzie odpowiadal kiedy jakie zadanie ma sie wykonac

		Aby metoda wykonywala sie co jakis interwal czasowy - dodaje adnotacje
		 @Scheduled(fixedDelay = 1000) w klasie repository
		 gdzie fixedDelay jest czasem w ms co ile
		 ma sie ona uruchamiac (od czasu zakonczenia), moge takze dac fixedRate
		 to czas zostanie liczony od uruchomienia metody.
		Jako kolejny parametr w @Scheduled moge dodac initialDelay = 3000 po ,
		 i bedzie to czas jaki uruchomi sie od uruchominia kontnera np:
		 //@Scheduled(fixedDelay = 1000, initialDelay = 3000)

		Moge takze skorzystac z czasu podanego w zmiennej String np z  pliku
		 properties :
		 @Scheduled(fixedDelayString = "${tworzenieZadaniaOczekiwanie}")


		W XMLu musze dodac linijke <task:scheduler id="myScheduler" pool-size="10"/>
		 gdzie id jest nazwa a pool-size jest ilosc metod ile moze z tego skorzystac

		Aby dodac wykonywanie metody dodaje linijki
		<task:scheduled-tasks>
        	<task:scheduled ref="zadanieFinalRepository" method="createRandomZadanieFinal"
        	 fixed-rate="1000"/>
    	</task:scheduled-tasks>



		//KONFIGURACJA KOMPONENTOW PRZEZ XML

		Dodatkowa opcja przeszukiwania komponentow jest dodanie ich do pliku xml

		Ta metoda uzywana jest w wiekszych projektach i w starszych aplikacjach

		Zaleta jest to ze nie trzeba skakac po klasach szukajac tych z adnotacjami
		 @Component oraz wartosci moge przypisywac w pliku XML

		Wszystkie klasy typu komponent umieszczone za pomoca adnotacji @Component
		 czy w pliku xml laduja w tym samym kontenrze i maja do siebie dostep!

		Wada konfiguracji xml jest to ze nie mozna wstrzyknac bezposrednio wartosci
		 (tam gdzie bylo @Autowired) do pola tylko musze zrobic to przez metode
		 wstrzykujaca (seter - nazwa musi byc setZmienna!!)
		 taka funkcjonalnosc uzywa znacznika <property>

		Aby dodac konfiguracje dzialania kontekstu za pomoca pliku xml musze dodac
		 adnotacje w glownej klasie SpringBootApplication po adnotacji SpringBootApplication
		 @ImportResource("classpath:config/spring-config.xml"), moge takze dodac ja do klasy
		 konfiguracyjnej!

		W katalogu resources tworze katalog config w ktorym tworze plik spring-config.xml
		 lub dodatkowy dla klasy np zamekProsty-config.xml


		Podstawowa struktura jest dodanie na poczatku xmlversion oraz beans xmlns z internetu.

		Kolejna rzecza jaka dodaje jest adres glownej paczki czyli tej gdzie sa WSZYSTKIE klasy!
		 <context:component-scan base-package="com.dekar.ProjektDekar"/>

		Aby dodac klase jako komponent dodaje linijke z tagiem bean
		 <bean id="zadanie" class="com.dekar.ProjektDekar.Aplikacja.domain.ZadanieProsty"/>
		 gdzie id jest to nazwa beana jaki zostanie umieszczony do kontenera oraz jej adres.
		Teraz klasa NIE MOZE miec adnotacji @Component i kontekst bedzie traktowal ja jak
		 klase komponent (z adnotacja @Component) czyli umiesci ja do kontenera

		Moge dodac do beana metody ktore wykonuja sie po stworzeniu beana oraz przed jego
		 zniszczeniem i robie to w linijce deklaracji beana uzywjac znacznikow init-method
		 oraz destroy-method gdzie podaje ich nazwe np:
		 <bean id="zamekProsty" class="com.dekar.ProjektDekar.Aplikacja.domain.ZamekProsty"
          init-method="buduj" destroy-method="zniszcz">


		Dodatkowo moge uzupelnic dane przez wstrzykiwanie czyli jak z adnotacja @Autowired
		 tzn ustawianie zaleznosci i moge to zrobic w XML TYLKO dla konstruktroa i
		 metody (setera)

		Dodaje kolejnego beana w xml lecz nie zamykam go odrazu po deklaracji (/>) tylko
		 dodaje kolejne linijki az dam zamkniecie </bean>

		Dla konstruktora uzywm znacnzika <constructor-arg> np
		 <constructor-arg index="0" value="Pszemek"/>
		 gdzie index jest to numer paramatru jaki przyjmuje konstruktor (numerowane od 0)
		 oraz value czyli wartosc
		Moge zamiast value dac ref to wtrzyknie innego beana po nazwie(obiekt z kontenera)
		 np:
		 <constructor-arg index="0" ref="rycerzProsty"/>
		 wstrzyknie do parametru 0 konstruktora bean o nazwie rycerzProsty (jego id)

		Jesli chce skorzystac z setera uzywam tagu <property>, teraz moge skorzystac
		 z wstrzykiwania tej metody (SETERA) (tam gdzie byla adnotacja @Autowired)
		 poprzez podanie ktorego setera (ZA POMOCA NAZWY) chce uzyc za pomoca name
		 oraz czy ma wtrzyknac inny bean czy wartosc np:
		<property name="zadanieProsty" ref="zadanieProsty"/>
		 jako name podaje nazwe setera (nazwa w takim przypadku musi byc : setZadanieProsty!!)
		 a ref jako nazwe beana jakiego ma wtrzyknac z kontenera (z xmla jest to id)
		 (pisane z malej litery jak obiekt w konterze)
		 UWAGA! Metoda musi byc seterem czyli miec nazwe setZadanieProsty!!
		 Moge tez dac value zeby podalo konkretna wartosc np:
		 <property name="nazwa" value="123"/>
		 to nazwa setera MUSI BYC setNazwa!!

		Moge takze ustawic wartosc wstrzykiwana z pliku properties.
		Przypisuje to tak jak value np:
		 <property name="nazwa" value="${moj.zamek.nazwa:SUPER NAZWA DEFAULTOWA}"/>
		Jesli NIE JEST to standardowy plik application.properties to musze na poczatku
		 pliku xml dodac linijke po context:component-scan :
		 <context:property-placeholder location="classpath:zamek.properties"/>


		Moge takze dodac inny plik xml do konfiguracji. Umieszczam go w tym samym folderze
		 i dodaje linijke w glownym pliku import resource np:
		 <import resource="classpath:config/zamekProsty-config.xml"/>
		Nowy plik xml takze musi posiadac konfiguracje poczatkowa - beans oraz xml version
		 ale nie musi juz miec component-scan


		Aby kazdy bean ktory bedzie wstrzykiwany nie byl singletonem (ta sama instancja)
		 dodaje kolejny parametr w tagu bean scope="prototype"


		Aby stworzyc kilka beanow jednego typu po prostu tworze kilka beanow z id innym
		 niz nazwa klasy (pisane z malej litery). Teraz bean bedzie mozliwy do wyszukania
		 po nazwie a nie po TYPIE jak standardowo!

		Aby wstrzyknac wybrany bean po nazwie po prostu w ref podaje jego nazwe

		Jesli chce ustawic aby bean jakiegos typu byl beanem GLOWNYM czyli mogl
		 po mimo innej nazwy byc wstrzykniety po TYPIE dodaje w linijce bean
		 tag primary tj: primary="true"



		//KONFIGURACJA PRZEZ KLASE KONFIGURACYJNA @Configuration

		W katalogu glownym (tam gdzie jest klasa startowa) tworze klatalog config
		 a w nim klase MainConfig
		Klasa ta bedzie zawierac definicje beanow jak w XML

		Tworzenie beana polega na metodach z adnotacja @Bean ktora zwraca konkretny
		 obiekt (standardowo metoda nie przujmije parametru) np:
		 public ZadanieProsty zadanieProsty(){
          return new ZadanieProsty();}
        UWAGA to jak nazwa sie metoda bedzie nazwa beana w kontenerze!!
         chyba ze podam w adnotacji @Bean parametr name

        Moge w takiej klasie utworzyc obiekty z wlasnymi wartosciami przypisanymi
         w konstruktorze np:
		 RycerzProsty rycerzProsty = new RycerzProsty("pawel konfig", 99);
		 (odpowiednik w xml :
		 <constructor-arg index="0" value="pawel konfig"/>
		 <constructor-arg index="0" value="99"/>)
		 oraz skorzystac z innego beana moge na nowow stworzonym obiekcie
		 w tej metodzie wywolac seter z klasy i wyslac tam to co zwroci inna
		 metoda @Bean!
		 rycerzProsty.setZadanieProsty(zadanieProsty());
		 (odpowiednik w xml:
		 <property name="zadanieProsty" ref="zadanieProsty"/>)
		 Na koniec takze musze zwrocic obiekt return rycerzProsty!

		Do klasy konfiguracyjnej moge takze dodac obsluge beanow przez plik xml
		 dodaja adnotacje @ImportResource po @Configuration np:
		 @ImportResource("classpath:config/zamekProsty-config.xml")


		Adnotacja @Bean moze takze przyjac parametry takie jak name oraz
		 moge ustawic pola metody inicjalizujacej oraz metody niszczacej np:
		 @Bean(name = "zamekProsty", initMethod = "buduj", destroyMethod = "zniszcz")
		Teraz bean w kontenerze bedzie nazywal sie jak nazwa a nie jak metoda
		 zwracajaca bean!


		Moge takze dodac obsluge pliku properties jak wczesniej w klasach np:
		 @PropertySource("classpath:zamek.properties")

		Aby skorzystac ze zmiennych pliku properties moge w metodzie zwracajacej
		 mojego beana dodac PRZYJMOWANE PARAMETRY rownowazne z typami pol pliku
		 properties oraz dodac adnotacje @Value po @Bean! np:
		  @Bean
    	  @Value("${moj.zamek.nazwa:SUPER NAZWA DEFAULTOWA}")
    	  public ZamekProsty zamekProsty(String nazwa)
    	  i na koniec moge przypisac ja przez wywolanie na obiekcie metody
          setera np:
          zamekProsty.setNazwa(name);
          i na koniec jak wczescniej tez zwrocic obiekt
          return zamekProsty;

		Moge takze skorzystac ze zmiennej z pliku properties za pomoca dodania
		 pola POZA metoda bean (metoda brzydka)
		 i skorzystac z adnotacji @Value np:
		 @Value("${moj.zamek.nazwa:SUPER NAZWA DEFAULTOWA}")
         String name;
         a na koniec skorzystanie z niej w srodku metody zwracjacej obiekt @bean


        Moge takze dodac dodatkowa klase konfiguracyjna.
        Dodaje nowa klase w tym samym folderze (config) np ZamekProstyConfig
         oraz dodaje jej takze adnotacje @Configuration
        W klasie konfiguracyjnej DODATKOWEJ dodaje adnotacje @Import i wpisuje
         klase z ktorej korzysta np:
         @Import(MainConfig.class)
        UWAGA! jesli klasa korzysta z beanow (obiektow) utworzonych w innej klasie
         klasie konfiguracyjnej NIE BEDE MOGL z nich skorzystac!


        Aby kazdy bean ktory zwroci metoda @Bean na potrzeby wstrzykniecia nie byl
         singletonem(ta sama instancja) uzywam po @Bean adnotacji @Scope("prototype")


        Aby utworzyc kilka niezalezbych beanow jednego typu ustawiem parametr name
         w @Bean lub zmieniam nazwe metody.

        Jesli wstrzykiwanie jest po TYPIE czyli nie ma okreslonej nazwy a typ
         klasy np: @Autowired Zamek zamek to moge jeden z tych metod jednego
         typu dac z adnotacja @Primarty aby byl on metoda tworzaca GŁOWNY bean
         tego typu

        Okreslenie beana po nazwie nie po typie polega na dodaniu adnotacji
         @Qualifier. W seterze/konstruktorze przed typem daje ta adnotacjie
         np public Zamek(@Qualifier(value = "lancelot") Rycerz rycerz)
        Natomiast dla smiennych po adnotacji @Autowired np:
         @Autowiered
         @Qualifier(value = "lancelot")
         Rycerz rycerz;


         //Maven - pom xml

         Import polega na dodaniu tagu <dependency>

         Dla dodatkowych bibliotek springa podaje groupId oraz artifactId poniewaz
          mam na poczatku dodanego taga parent z version

         Jedna z podstawowych bibliotek springa sa:

         Spring MVC - spring-boot-starter
         <groupId>org.springframework.boot</groupId>
		 <artifactId>spring-boot-web</artifactId>

		 Thymeleaf
		 <groupId>org.springframework.boot</groupId>
		 <artifactId>spring-boot-starter-thymeleaf</artifactId>


		 Aby dodac niezalezna biblioteke musze dodac takze wersje

		 Jquery
		 <groupId>org.webjars</groupId>
		 <artifactId>jquery</artifactId>
		 <version>3.3.1-1</version>

		 Bootstrap
		 <groupId>org.webjars</groupId>
		 <artifactId>bootstrap</artifactId>
		 <version>4.1.3</version>





		//TESTOWANIE
	    Klasa Testowa ktora ma adnotacje
	     @RunWith(SpringRunner.class)
	     @SpringBootTest
	     korzysta z kontekstu springo przez co testy sa bardzo wolne.
	     Lepiej jest stworzyc testy nie korzystajace z kontekstu

		metoda @Test "contextLoads" sprawdza czy zaladowal sie kontekst springowy

		Korzystajac z testow z uzyciem kontekstu jesli uzywam obiektow klas ktore korzystaja
		 z wstrzykiwania powninennem przed testami wstrzyknac im wartosc z
		 kontenera dodajac pole potrzebnej klasy z adnotacja @Autowired np:
		 @Autowired
	     RycerzProsty rycerzProsty;
		 poniewaz jesli stworze w tescie nowy obiekt z new nie korzystam
		 z wstrzykiwania zaleznosci jak np @Value czy @Autowired w moich klasach
		 przez co wartosci pol moga byc zle

		Lepiej jest stworzyc klase testowa nie korzystajaca z kontekstu i
		 stworzyc w niej test w ktorym stworze drzewo obiektow od "gory"
		 a na koncu sprawdze czy otrzymany String z toString bedzie rownal
		 sie z moim wpisanym reczenie Stringiem za pomoca metody assertEquals

		Moge takze wykorzystac dodatkowy konstruktor BEZ MODYFIKATORA w klasie
		 ktora przyjmuje wartosci pol ktore sa wstrzykiwane oraz umieszczam
		 klase testowa w takim samym folderze (nazwa) jakim jest ta klasa testowa
	     np domain przez co bede mial dostep do tego konstruktora. *(Klasy bez modyfikatoa
	     maja dostep do pol w klasach z tej samej paczki!)
	     Teraz tworzac obiekt w metodzie testowej moge wyslac do niego wartosci
	     jakie te pola otrzymalyby przez wstrzykiwanie

	    Moge takze usunac wstrzykiwanie proste do pol za pomoca @Value i
	     przypisac wartosci z = poniewaz tak samo to zadziala a nie bede
	     juz musial korzystac z wtrzykiwania!

	    Moge takze skorzystac z wstrzykiwania przez metode tej klasy
	     wywolujac ja na stworzonym obiekcie w tescie i wysylajac odpowienie
	     parametry lub inny obiekt



	    //OBIEKTY BEZSTANOWE / WZORZEC SINGLETON
		Kazde pole klasy nazywam stanem obiektu

		Klasa Utils jest to odpowiednik mojej klasy z nazwa Utils po nazwie klasy
		 np PersonUtils i zawiera ona tylko zestaw metod ktore robia jakies operacje
		 na obiektach i nie posiadaja wlasego stanu (pol)
		Taka klasa i nazywa sie bezstanowa i jej obiekty sa bezstanowe
		Takie klasy opakowuje we wzorzez Singleton
		Polega on na tym ze na danej maszynie wirtualnej znajduje sie tylko jedna instancja
		 danej klasy
		W klasie Utils tworze jej prywatne statyczne pole o nazwie instance i przypisuje null,
		 nastepnie tworze prywatny konstruktor nie robiacy nic aby nie mozna bylo tworzyc jej
		 obiektu oraz metode getInstance ktora zwraca obiekt tej klasy i ma wartunek jesli nie
		 jest stworzony obiekt tej klasy to go tworzy - definicja :

		 public OsobaUtils getInstance(){
         	if(instance == null){
             	instance = new OsobaUtils();
         	}
         	return instance;
         }



		//SPRING MVC - Model View Controler

    	Jest to wzorzec architektoniczny

    	Polega to na tym zeby odsperowac widok od medelu a polaczenie ich
    	 realizwoane jest przez kontroler

    	W Spring jest to zrealizowane inaczej
    	Request (np http) trafia do front kontrolera (w Spring nazywa sie Disptcher
    	 Servleter) jego zadeniem jest wyslanie go do odpowiedniego kontrolera na
    	 podstawie requestu jaki otrzymal od uzytkownika. Jednak aby wybrac komponent
    	 musi uzyc koljnego komponentu Handler Mapping
    	Handler Mapper na podstawie requestu moze wskazac do jakiego kontrolera ma
    	 trafic request, nastepnie to wskazanie przesyla z powrotem do dispatcher
    	 servletu
    	Kolejnym etapem jest wyslanie przez ten servlet requesta do wskaznego przez
    	 handler mappera - kontrolera
    	Kontrolerem jest komponent springowy ktorego zadaniem jest rozebranie requestu
    	 np http czyli wyciagniecie metadanych, parametrow z adresu url, jego
    	 nastepnym zadaniem jest przeslanie tego do odpowienich komponentow realizujacych
    	 wybrna logike biznesowa

    	NP. jesli chce dodac obiekt (rycerza) to kontroler dostanie pola formularza
    	 nastepnie przesle te informacje do komponentu knightRepository ktory wywola
    	 metode createKnight i zostanie dodany do listy rycerzy. Nastpenie ten
    	 komponent zwroci nowa liste do kontrolera.
    	 Kontrole opakowuje taka
    	 liste w dodatkowe metadane i powstaje model + dorzuca tam logiczna nazwe
    	 widoku ktory ma sie wyswietlic uzytkownikowi i ta paczka wraca do
    	 dispatcher servletu
    	 Servlet tworzy widok dla uzytkownika jako odpowiedz i robi to na podstawie nazwy
    	 widoku ktora przyszla z kontrolera lecz pomaga sobie View Resolverem ktory na
    	 podstawie nazwy logicznej widoku jest w stanie wskazac konkretna sciezke gdzie
    	 dana strona jsf sie znajduje.
    	 Gdy Disptcher Servlet wie jaki widok ma zostac uzyty wysyla to do View
    	 a nastepnie do uztkownika


    	Aby aplikacja miala paczke spring mvc musze dodac dependencje w maven czyli
    	 pliku pom.xml

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		Zostanie dodany tomcat oraz frontcontroller czyli dispatched servlet


		//Tworzenie aplikacji webowej spring mvc
		Tworze w glownym katalogu folder controllers i umieszczam tam klasy z
		 adnotacja @Controller
		Jest to specjalny typ komponentu springa ktory odpowiada za mapowanie
		 requestu na logike biznesowa

		Aby metoda zostala umieszczona do mapping handlera dodaje przed nia
		 adnotacje @RequestMapping("/hello")
		Do mapping handlera pod nazwa hello zostala umieszczona metoda kontrolera
		 getRycerze
		 public String getRycerze(Model model){
		Metoda getRycerze musi komunikowac sie z view resolverem i wyswietlac ja na ekran
		Aby to zrobic powinna zwracac string z nazwa pliku np plik.html

		Pliki standardowe html umiszczam w folderze reources/static


		Teraz wykonalem kroki:
		-Wpisalem adres w przegladarce localhost:8080/hello
		-Do dispatched servleta trafia adres localhost:8080/hello, wycina on
		 adres i wysyla samo hello do handler mappingu
		-Handler mapper @RequestMapping zmapowal /hello na metode klasy HelloController
		 z hello i odeslal ta informacje do dispatcher servleta
		-Dispatcher Servlet przechodzi do odpowiedniego juz kontroleru (HelloControler)
		-W Controlerze wykonuje sie metoda hello (nie mam zadnej logiki biznesowej)
		 i zwraca nazwa logiczna widoku czyli nazwa pliku html
		-Dispatcher Servlet wysyla ta nazwe pliku do View Reolvera
		-View Resolver odpowiada ze nazwa tego pliku znajduje sie w wybranej lokalizacji
		-Dispatcher przesyla dane do widoku i generuje on widok dla uzytkownika

		-----

		Jako silinik szablonow uzyje Thymeleaf na potrzeby html
		Dodaje dependencje
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>


		Kontroler jest komponentem frontendowym modyfikujacym widok i model
		Reposytorium jest komponentem bezposrednio komunikujacym sie z baza danych
		 Tworze interface ktory bedzie szablonem dla klasy pamieci i bazy danych
		  Bedzie on zawietal wszytskie metody i mape
		 Tworze klase pamieci reposytorium @Repository np: InMemoryRepository ktora
		  implementuje interface repo
		 Tworze klase do bazy danych np DBRycerzRepository
		Service @Service jest komponentem pomiedzy nimi


		W kontrolerze @Controller wybrnego typu np RycerzController wstrzykuje RycerzService
		 @Autowired
    	 RycerzService rycerzService;
    	Czyli bean z kontenera ktory jest posrednikiem


		//Odczyt - metoda GET
		Nastepnie dodaje mapowanie @RequestMapping("/rycerze") do metody
		 public String getRycerze() aby wywolywala sie ona po wpisaniu
		 w przegladarce /rycerze
		 @RequestMapping("/rycerze")
		Jest to metoda typu GET!

		Ta metoda przyjmuje obiekt typu Model i dodaje do niego elementy
		 public String getRycerze(Model model){

		Teraz dodaje elementy do modelu

		Moge dodac obiekt prosty w formie stringa
		 model.addAttribute("hello", "Witaj swiecie");
		 to w html element o nazwie hello bedzie mial prosta wartosci w formie
		 Stringa i bede mogl wyswietlic to w html jako text np w akapicie:
		 <p th:text="${hello}"/>
		 w ${} podaje nazwe elementu

		Dodanie listy do modelu:
		W mojej metodzie get moge stworzyc liste z typem jaki chce posiadac i
		 przypisuje do niej liste jaka zwroci mi metoda get z klasy Service
		 (posrednik) i wywoluje to metode na wstrzyknietym jej wczesniej obiekcie
		 np:
		  List<Rycerz> allRycerze = rycerzService.getAllRycerze();
		Dodaje do modelu  nowy obiekt jak wczesniej: nazwa + element, w moim przypadku
		 obiektem bedzie lista (element) a jego nazwe przypisze jako "rycerze"
		 model.addAttribute("rycerze", allRycerze);

		Na koniec metoda zwraca nazwe logiczna pliku html np rycerze;
		Bedzie on szukany w folderze reources/templates


		 //Wyjscie danych z metody
		Tworze maping do nowej metody ktora bedzie wysylac nowy pusty obiekt
		 na kotrym bede operowal
		 @RequestMapping("/newrycerz")
   		  public String createRycerz(Model model){
   		po wpisaniu adresu /newrycerz bedzie uruchamiala sie ta metoda

   		W ciele dodaje do modelu nowy obiekt mojej klasy i nazwam go "rycerz"
   		Bede na nim operowal w html
   		 model.addAttribute("rycerz", new Rycerz());
   		A na koniec zwracam nazwe logiczna pliku nowego pliku html
   		 return "rycerzform";


		//Zapis - metoda Post
		Dodaje maping ale juz na wartosc i metode
		@RequestMapping(value = "/rycerze", method = RequestMethod.POST)

   		Teraz tworze metode do ZAPISU rycerzy - komunikacja od strony FRONTENDU
   		 wiec metoda nie przyjmuje modelu tylko obiekt ktory wczesniej wyslalem i
   		 operowalem na nim w html
   		 public String saveRycerz(Rycerz rycerz){

   		Wysylam przyslnego rycerza wywolujac na wstrzyknietym obiekcie metode
   		 serwisu di zapisu i wstawiam tam przyjety przez metode obiekt
   		 rycerzService.saveRycerz(rycerz);

   		Na koniec aby przekierwalo mnie do wybranego pliku html wstawam:
   		 return "redirect:/rycerze";



		W klasie Service @Service np RycerzService tworze zmienna wybrnego interfacu reposytrium
		 i wstrzykuje ja z kontenera np:
		 @Autowired
    	 RycerzRepository rycerzRepository;

    	Nastepnie tworze metode get zwracjaca wybrany typ obiektu, w moim przykladnie bedzie
    	 to lista
    	 public List<Rycerz> getAllRycerze(){
        	return new ArrayList<>(rycerzRepository.getAllRycerze());}
		Taki posrenik w formie Service jest potrzebny gdy bede chcial jakos
		 odchudzic moje elementy i robie to w srodku metody

		Dodatkow tworze metode zapisu obiektu ktory moze byc przyslany z kontrolera
		 public void saveRycerz(Rycerz rycerz) {
		A w srodku na wstrzyknietym obiekcie wywoluje metode dodania rycerza do kolekcji
		 rycerzRepository.createRycerz(rycerz);



		W interfejsie reposytorium np RycerzRepository tworze deklaracje wszystkich
		 potrzebnych metod np:
		 -metoda dodajaca obiekt do kolekcji za pomoca pol
		  void createRycerz(String imie, int wiek);
		 -metode dodajaca obiekt do kolekcji za pomoca przeslanego obiektu
		  void createRycerz(Rycerz rycerz);
		 -metoda zwracajaca kolekcje wybranego typu obiektu
     	  Collection<Rycerz> getAllRycerze();
		 -metode zwracajaca pojedynczy obiekt z kolekcji
    	  Rycerz getRycerz(String imie);
		 -metode usuwajaca obiekt z kolekcji
    	  void deleteRycerz(String imie);
		 -metode postConstuct
          void buduj();


		W klasie reposytorium @Repository pamieci np: InMemoryRepository implementuje
		 odpowiedni interface i jego metody

		Dodatkowo dodaje nowa kolekcje w formie Mapy gdzie kluczem moze byc nazwa obiektu
		 czyli jakies jego pole a wartoscia jej obiekt np:
		 Map<String, Rycerz> rycerze = new HashMap<>();
		 moja wartoscia bedzie wartosc obiektu imie (String)

		W kazdej z metod operuje na kolekcji (dodaje/usuwam/odczytuje itp.)

		W metodzie postConstruct np: buduj dodaje adnotacje @PostConstruct oraz
		 moge dodac startowe obiekty do mojej mapy na "sztywno"




		//FRONT END - THYMELEAF / BOOTSTRAP / JQUERY

		Pliki html umieszczam w :

		zwykłe : resourced/static
		thymeleaf/bootstrap : resources/templates

		<!DOCTYPE HTML>
		<html xmlns:th="http://www.thymeleaf.org">
		<head>
			<title>Zaczynam : Web Content</title>
			<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8"/>

			<link rel="stylesheet" th:href="@{/webjars/bootstrap/4.1.3/css/bootstrap.min.css}"/>

			<script th:src="@{/webjars/jquery/3.3.1-1/jquery.min.js}"></script>
			<script th:src="@{/webjars/bootstarp/4.1.3/bootstrap.min.js}"></script>
		</head>

		<p>akapit
		<div>kontener
		<table>tablica
		<tr>wiersz
		<td>kolumna
		<thead>
		<tbody>
		<form>formularz


		//Kontenery
		Aby kontener byl obslugiwany przez bootstapa okreslam klase:
		<div class="container"> - jesli dam nazwe container to bedzie to obslugiwane
		 przez bootstrapa


		//Odnoszenie sie do elementow w thymeleaf
		Odczyt uzywa znacznika ${}

		Moge odniesc sie do przyslanych obiektow string np w th:test w akapicie
		<p th:text="${hello}"/>

		Lub w kontenerze z listy + petla foreach
		<div th:each="rycerz : ${rycerze}">
            <p th:text="${rycerz.imie}"/>
        </div>

        Lub w tablicy z listy + petla foreach
        <tbody th:each="x : ${rycerze}">
            <tr>
                <td th:text="${x.imie}"></td>
                <td th:text="${x.wiek}"></td>
            </tr>
        </tbody>



		//Tabele
		Tabele umieszczam w konterze z klasa bootstarapa:
		<div class="container">

		Aby tabela byla obslugiwana przez bootstapa okrespam klase:
		<table class="table">

		Jako glowe tabeli dodaje thead:
		<thead>
		Nastepnie dodaje wiersz tr:
		<tr>
		i w nim kolumny td:
		<td>Imie</td>

		Jako cialo tabeli dodaje z th z thymeleafe + wczytuje liste do petli
		 foreach
        <tbody th:each="x : ${rycerze}">
        Wczytuje wyslana obiekt w formie listy o nazwie "rycerze"

        Kazdy element bedzie iterowany jako "x" na ktorym bede mogl
         odwolac sie do pola klasy po . uzywajac th:text
        Dodaje wiersz <tr> a w nim elemeny w kolumnach <td>
        <tr>
            <td th:text="${x.imie}"></td>
            <td th:text="${x.wiek}"></td>
        </tr>

        Na koniec zamykam tabele </table>

        Moge dodac kolejny kontener jako wiersz aby zarezerwowal przestrzen w
         formie wiersza i byl umieszczony w nim przycisk odnoszacy sie do
         innego adresu (adres strony dodawania obiektu)
        <div class="row">
            <a href="/newrycerz">Dodaj nowego rycerza</a>
        </div>



		//Formulatrze + zapis metoda post
		Zapis uzywa znacznika *{}

		Caly formularz moge umiescic w kontenerze klasy bootstrap:
		<div class="container">


		Aby folmularz byl obslugiwany przez bootstapa okreslam klase:
		<form class="form-forizontal"

		Aby okreslic NAZWE do jakiego obiektu mam zapisywac dodaje
		th:object="${rycerz}"
		UWAGA! musze miec seter w klasie!

		Aby okreslic METODE do jakiej ma byc formularz przeslany
		th:action="@{/rycerze}"
		Metoda bedzie teraz POST i miala wartosc value = "/rycerze"!

		Aby okreslic metode jaka maja byc przeslane dane daje:
		th:method="post"

		<form class="form-forizontal" th:object="${rycerz}" th:action="@{/rycerze}"
		 th:method="post">


		Wstawianie pola formularzy robie poprzez kontenery z klasa bootastrapa
		 w okreslonym wczesniej <form> np:
		<div class="form-group"> //kazdy formularz

		Wewnatrz dodaje tytul z bootstrapa:
		<label class="control-label">Imie:</label>
		Oraz z htmla typ danych, klase bootsraoa i pole z thymeleafa
		<input type="text" class="form-control" th:field="*{imie}"/>
		Inny type to np number, input musi byc zamkniety! />

		Na koniec zamykam kontenery

		Teraz moge dodac kolejny kontener z przciskiem i klasa bootstap
		Okreslam typ operacji oraz klase bootstrapa
		<div class="row">
			<button type="submit" class="btn btn-default">Utworz rycerza</button>
	 	</div>

	 	Na koniec zamykam moj formularz </form>




		//----Konfiguracja finalna

		Hierarchia : Klasa domenowa -> (I) DomenaReposytorium ->
					 InMemoryRepository/DomenaReposytorium ->
					 DomenaService -> DomenaController -> forntend(pliki html)
					 ----
					 Component -> (autowired) Controller
					 ----
					 Utils (klasa generwania nowego id - NoweId)
					 ----
					 Formatter (w services)


		//plik pom.xml

		GropuId - nazwa firmy np com.fak3frame lub nazwa projektu
		ArtifactId - nazwa projektu np GraWCwiczenia lub nazwa modulu

		<parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.5.RELEASE</version>
            <relativePath/> <!-- lookup parent from repository -->
        </parent>

        dependencje:

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>

		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>jquery</artifactId>
			<version>3.3.1-1</version>
		</dependency>

		<dependency>
			<groupId>org.webjars</groupId>
			<artifactId>bootstrap</artifactId>
			<version>4.1.3</version>
		</dependency>
	</dependencies>



		//Klasa startowa @SpringBootApplication

		Umieszczam ja w folderze glownym com.firma.Projekt

		nazwa : NazwaProjektuApplication

        @SpringBootApplication
        public class GraWyzwaniaCwiczenioweApplication {
            public static void main(String[] args) {
                SpringApplication.run(GraWyzwaniaCwiczenioweApplication.class, args);
            }
        }



		//Klasy domenowe (bazowe)

		Umieszczam je w folderze com.firma.Projekt->domain

        Klasy ktorych obiekty umieszczam w innych nie musza byc komponentami jak np Rycerz,
         RycerzInformacje , Zadanie


		KLASA RYCERZ:

        Klasa posiada:
         -pole int id,level
         -pola z okreslonymi wymogami imie, wiek (@NotNull itp)
         -pole obiektowe Zadanie
         -pusty konstruktor(na potrzeby tworzenia obiektu)
         -konstruktor przyjmujacy podstawowe dane (swoich pol - imie/wiek)
           + ustawia lvl = 1
		 -konstruktor przujmujacy obiekt tej klasy (kopiujacy) + ustawia lvl = 1
		 -setery i getery (seter Zadania ustawia zadanie.setRozpoczety(true))
		 -metode equals
		 -metode hashCode na postawie wybranego pola zapewniajaca unikalnosc elemwntow
		   w ZBIORZE
		 -metode toString


		 Aby klasa mogla miec pola ktore moga miec przypisana konkretna wartosc
		  moge dodac adnotacje (przed deklaracja pola):
		  -@NotNull - wartosc musi byc przypisana
		  -@Size(min = 2, max = 15) - dlugosc stringa
		  -@Min(2) / @Max(40) - wartosc liczbowa min / max
		  -@Range(min = 18, max = 60) - zakres liczbowy
		 Moge takze dodac komunikat w przypadku bledu inny niz standardowy wpisujac
		  parametr message w adnotacji np:
		   @Range(min = 18, max = 60, message = "wiek musi byc z przedzialu 18-60")
		   private int wiek;

        **
		/ Aby mogly one zostac sprawdzone w formularzu na stronie - dodaje w metodzie
		/  Controllera w przyjetych parametrach (przed paramtrem obiektu - Rycerz rycerz)
		/  adnotacje @Valid oraz do operacji na bledach kolejny argument BindingResult
		/   //public String saveRycerz(@Valid Rycerz rycerz, BindingResult bindingResult){
		/ W srodku metody odpowiednie operacje na bindingResult takie jak sprawdznie
		/  czy wystapil blad if(bindingResult.hasErrors()){ i jesli tak to zwracam jeszcze
		/  raz strone do wprowadzania formularza + opcjonalne wyswietlenie bledu na konsoli
		/  a jesli nie (else) to przekierowanie na strone glowna
        /
		/ W pliku html :
		/  <p th:if="${#fields.hasErrors('wiek')}" th:errors="*{wiek}"/>
		**


		KLASA ZADANIE:

		Klasa posiada:
		-pole String opis
		-pole int nagroda = 100,
		-pole int protected dlugoscWSekundach = 3
		-pole boolean rozpoczety, zakonczony usatwione na false
		-pole int id
		  Pole ma adnotacje @Id oraz @GeneratedValue(strategy = GenerationType.AUTO) aby za kazdym
		  razem gdy bede wstawial obiekt do bazy danych to to pole bedzie mialo unikalna wartosc
		-pole protected kiedy zadanie zostanie rozpoczete LocalDateTime dataRozpoczecia;
		-pusty konstruktor (na potrzeby hibernate)
		-konstruktor przyjmujacy int id oraz String opis
		-setery i getery
		-w SETERZE rozpoczecia (setRozpoczety) dodaje:
		  -warunek sprawdzajacy czy flaga rozpoczety jest true to ustawiam zmienna dataRozpoczecia
		   na aktualny czas
		    //if(rozpoczety){
		    //    this.dataRozpoczecia = LocalDateTime.now();}
		-w GETERZE zakocznia (isZakonczony) dodaje:
		  -warunek sprawdzajacy czy flaga this.zakonczony jest true to zwracam this.zakonczony
		  -jesli nie (else) dodaje:
		    -zmienna LocalDateTime teraz z aktualnym czas
		      //LocalDateTime teraz = LocalDateTime.now();
		    -zmienna LocalDateTime dataZakonczeniaZadania ktorej przypisze date rozpoczecia z
		      metoda .plusSeconds w ktorej umieszcze wartosc dlugoscWSekundach
		    -flage czyJestZakonczony ktora okresli sie za pomoca metody .isAfter(dataZakonczeniaZadania)
		      na zmiennej daty "teraz"
		    -warunek sprawdzajacy czy flaga "czyJestZakonczony" jest true to ustawi this.zakonczony
		      na true;
		    -na koniec zwroce flage czyJestZakonczony
		      //if(this.zakonczony){
		  	  //	return this.zakonczony;
			  //}
			  //else {
			  //	LocalDateTime teraz = LocalDateTime.now();
			  //
			  //	LocalDateTime dataZakoczeniaZadania = this.dataRozpoczecia.plusSeconds(this.dlugoscWSekundach);
			  //
			  //	boolean czyJestZakoczniony = teraz.isAfter(dataZakoczeniaZadania);
			  //
			  //	if(czyJestZakoczniony){
			  //		this.zakonczony = true;
			  //	}
	  		  //
			  //	return czyJestZakoczniony;
		  	  //}
		-toString



		//Utils

		Umieszczam w Aplikacja->utils

		Np. klasa do generowania nowego id (klasa zwykla) bez adnotacji

		Posiada statyczna publiczna metede przyjmujaca ZBIOR Integer

		Metoda ma warnku sprawdzjace:
		 -jesli ma przyslany pusty zbior zwraca 0
		 -jesli nie to tworzy zmienna integer ktorej przypisuje wartosc na podstawie strumienia
		  wywolanego na przyslanym zbiorze i metody max(Integer::compare) + .get() aby
		  przypisac to do zmiennej Integer

		//static public int getNewId(Set<Integer> klucze) {
		//	if (klucze.isEmpty()){
		//		return 0;
		//	}
		//	else {
		//	  	Integer integer = klucze.stream().max(Integer::compare).get();
		//	  	return integer+1;
		//  	}
		//}



		//Reposytoria @Repositrory + inerface Repository

		Umieszczam je w folderze com.firma.Projekt->domain->repository (razem z interface)

		Interface deklaruje metody jakie ma miec klasa @Repostory i musi go implementowac

        Adnotacja @Repository dziala tak samo jak @Component ale jest informacja dla
         programisty

        Te klasy maja swoj stan i sa singletonami czyli maja tylko 1 instancje

        Reposytorium moze miec MAPE (BEZ WSTRZYKIWANIA!) dla okreslonej klasy domenowej.
         Jej kluczem jest jest id lub wybrne pole klasy domenowej
         Wartoscia jest obiekt klasy domenowej

        Klasa posiada metode toString


		REPOSYTORIUM RYCERZA:

		Mapa: (bez wstrzykiwania)
		 //Map<Integer, Rycerz> rycerze = new HashMap<>();

		Metody:

		//1
         -dodanie obiektu (stworzy nowy) na podstawie podstawowych danych klasy
            //void createRycerz(String imie, int wiek),
           Tworze w metodzie nowy obiekt klasy domentowej i przypisuje mu przyslane
            wartosci poprzez konstruktor klasy domentowej
             //Rycerz rycerz = new Rycerz(imie, wiek);
           Nastepnie przypisuje id obiektowi nowemu poprzez wywoalnie na tym obiekcie
            setera ID i jako parametr wywoluje statyczna metode klasy Utils do
            generowania nowgo ID i wysylam jej zbior kluczy mapy repo
 			//rycerz.setId(NoweId.getNewId(rycerze.keySet()));
 		   Na koniec umieszczam w mapie nowe id (poprzez wywolanie getera id na nowym
 		    obiekcie) oraz nowy obiekt jako wartosc
            //rycerze.put(rycerz.getId(), rycerz);

		//2
         -dodanie obiektu na podstawie przyslanego obiektu
            //void createRycerz(Rycerz rycerz)
           Zasada dzialania jak wyzej - tworznie nowego obiektu (korzystam z innego kosntr.),
            generownie nowego id i wlozenie wszystkiego do mapy
            //Rycerz rycerzNowy = new Rycerz(rycerz);
		    //rycerzNowy.setId(NoweId.getNewId(rycerze.keySet()));
            //rycerze.put(rycerzNowy.getId(), rycerzNowy);

		//3
         -usuniecie elementu mapy na podstawie przyslanego klucza
           //void deleteRycerz(Integer id)
           Sprawdzam czy mapa jest pusta a nastepnie czy jest wybrany element w mapie
            i jesli tak to dopiero usuwam
           //rycerze.remove(id);

		//4
         -zwrocenie obiektu Rycerza (wartosci mapy) na podstawie otrzymanego id (klucza)
           //Rycerz getRycerzById(Integer id){
           //	 return rycerze.get(id);}

		//5
         -zwrocenie obiektu mapy na podstawie jednego z podstaowych danych obiektu w
            mapie w formie Optionala
             //Optional<Rycerz> getRycerz(String imie){
           Korzystam z Optionala poniewaz moze nie byc takiego obiektu a nie moge zwrocic nulla
           W metodzie tworze zmienna Optional i pzypisuje jej wartosc poprzez wywolanie na
            wartosciach mapy strumienia i metody filtrujacej (porownuje wartosci pola imie do
            przyslanego stringa) oraz metody findAny() aby znalezc pierwsza wartosc
           Na koniec zwracam nowy Optional
            //Optional<Rycerz> rycerzPoImieniu = rycerze.values().stream()
            //		.filter(x -> x.getImie().equals(imie))
            //		.findAny();
		    //return rycerzPoImieniu;

		//6
         -zwrocenie kolekcji wartosci mapy Collection<Rycerze> na podstawie wartosci mapy
           //Collection<Rycerz> getAllRycerze() {
           //	return rycerze.values();}

        //7
         -dodanie obiektu Rycerza do mapy na podstawie przyslanego id oraz obiektu
           Rycerza (uaktualnienie poniewaz przysylam id znajdujace sie juz w mapie
           natomiast Rycerz jest inny)
           //public void uaktualniRycerza(int id, Rycerz rycerz){
           //   rycerze.put(id, rycerz);}
           **
           / Serwis przyjmuje sam obiekt Rycerza i wywoluje na nim geter id po
		   / czym wysyla przechwycone id i obiekt Rycerza do repo
		   **


        REPOSYTORIUM ZADANIA:

        Mapa:
         //Map<Integer, Zadanie> zadania = new HashMap<>();

        Zmienna Random
         //Random random = new Random();
         Na potrzeby losoania zadania

        Metody:

        //1
        -Metoda dodajaca obiekt Zadania do mapy na podstawie przyslanego Stringa (opis)
          //public void createZadanie(String opis){
         Metoda generuje nowe id za pomoca klasy utils NoweId z uzyciem jej statycznej
          metody i wyslania do niej zbiory kluczy mapy Zadan
          //int noweId = NoweId.getNewId(zadania.keySet());
         Natepnie tworzy nowy obiekt Zadania korzystajac z nowego id i przyslanego Stringa
          //Zadanie zadanie = new Zadanie(noweId, opis);
         Na koniec dodaje id i Zadania do mapy Zadan
          //zadania.put(noweId, zadanie);

		//2
		-Metoda zwracajaca Liste Zadan z mapy (na podstawie values)
		 Nie zwracam Collection<Zadanie> tylko liste wiec w retrun musze stworzyc nowa
		  liste i dac przypisac jej wartosci z mapy
		   //public List<Zadanie> getZadanieLista(){
		   //   return new ArrayList<>(zadania.values());}

		//3
		-Metoda usuwajaca Zadanie z mapy na podstawie przyslanego gotowego obiektu Zadania
		 //public void deleteZadanie(Zadanie zadanie){
		 Metoda usuwa element z mapy za pomoca wywolania na przyslanym obiekcie getera ID
		  oraz wykorzystanie tej wartosci
		   //zadania.remove(zadanie.getId());}

		//4
		-Metoda dodajaca Zadanie na podstawie przyslanego obiektu Zadania
		  //public void uaktualnij(Zadanie zadanie) {
		 Metoda przyjmuje Zadanie i dodaje je do mapy - jako klucz wywoluje geter ID na
		  przyslanym obiekcie i wartosc jako obiekt Zadnaie (Zadanie w mapie zostaje
		  nadpisane poniewaz istanieje juz takie tylko teraz z parametrem rozpoczete
		  ustawione na true)
		   //zadania.put(zadanie.getId(), zadanie);
		  **
		  / Serwis przechwytuje obiekt Zadania i przesyla go dalej natomiast Controller
		  /  na wstrzyknietym ZadanieService wykorzystuje to aby nadpisac zadanie z ustawionym
		  /  rozpoczete na true aby metoda zwracajaca liste zadan nierozpoczetych nie zawierala
		  /  juz tego zadania
		  **

		//5
		-Metoda zwracajaca Zadanie na podstawie przyslanego id
		  //public Zadanie getZadanie(Integer id) {
		  //	return zadania.get(id);}
		  **
		  / Metoda pobiera z mapy zadanie z wybranym id na potrzeby formatera do html
		  /  aby mogl on zwrocic na podstawie id przekazaego jako string Zadanie jako obiekt!
		  **



		//Service @Service

		Umieszczam je w folderze com.firma.Projekt->services

		Sa to klasy posredniczace pomiedzy kontrolerem a reposytiorum

		Na poczatku wstrzykiwany jest zmienna wybranego Reposytorium na
		 ktorym bede operowal w metodach
		Moge takze dodac zmienna Reposytorium bez wstrzykiwania i dodac
		 wstrzykiwanie @Autowired poprzez seter zmiennej repo ktory ustawi
		 jej wartosc tak samo jak bezposrenie @Autowired do zmiennej
		Robie drugim sposobem na potrzeby testow

		Serwisy sluza do tego aby pobrac lub dodac cos do Reposytiorium oraz
		 zaimplementowac posredniczace operacje na wstrzyknietych danych


		SERVICE RYCERZA:

		Wstrzykiwanie Repo
		//@Autowired
    	//RycerzRepository rycerzRepository;


		Metody:

		//1
		-Metoda zwracajaca cala liste obiektow klasy domenowej
		   //public List<Rycerz> getAllRycerze(){
		  Metoda zwraca bezposrednio w return nowa liste i przypisuje jej wartosci
		   korzystajac z metody pobrania listy wartosci z value mapy klasy repo
            //return new ArrayList<>(rycerzRepository.getAllRycerze());}

		//2
		-Metoda dodania gotowego Rycerza do wstrzyknietej zmiennej repo
		   //public void saveRycerz(Rycerz rycerz) {
		  W ciele metody na wstrzyknietym repo wywoluje metode repo dodania
		   obiektu do mapy i wysylam tam przyslany obiekt
         	//rycerzRepository.createRycerz(rycerz);}

		//3
        -Metoda zwracajaca obiekt Rycerza na podstawie przyslanego id
           //public Rycerz getRycerz(Integer id) {
          Korzysta ona z metody pobrania obiektu na podstawie zmiennej "id" na
           wstrzykniej zmiennej repo (metoda repo zaraca wartosc z mapy na podstwie
           przyslanego klucza)
            //return rycerzRepository.getRycerzById(id);}

		//4
         -Metoda usuniecia obiektu Rycerza na podstawie przyslanego id
            //public void deleteRycerz(Integer id){
           Metoda wywoluje na wstrzyknietym repo jego metode usuniecia obiektu
            na postawie id i wysyla jako parametr przyslane id
             //rycerzRepository.deleteRycerz(id);}

		//5
		-Metoda dodajaca Rycerza na podstawie przyslanego Rycerza
		  //public void uaktualniRycerza(Rycerz rycerz) {
		 Metoda na wstrzyknietej zmiennej repo wywoluje metode uaktualnienia
		  (dodania - nadpisania) obiektu Rycerza do mapy
		 Jako parametry wysylam id przyslanego obiektu (wywoluje geter na przyslanym
		  obiekcie) oraz przyslany obiekt Rycerza
		   //RycerzRepository.uaktualniRycerza(rycerz.getId(), rycerz);

		//6
		-Metoda zwracajaca nagrone (int) oraz ustawiajaca pole Zadanie rycerza na null
		  jesli jest zakonczone
		   //public int zdobadzNagrode() {

		  Tworze zmienna Predicate<Rycerz> ktora z obiektu zrobi flage true/false i jest
		   deklaracja warunkow, w moim przypadku jesli zadanie Rycerza nie jest nullem ustawi
		   flage taka zwroci metoda isZakonczony() a jesli zadanie jest Nullem to zwroci
		   false, Prdicate jest rodzajem filtru
		    //Predicate<Rycerz> rycerzPredicate = x -> {
		    //       if(x.getZadanie()!=null){
		    //            return x.getZadanie().isZakonczony();
		    //       }else{
		    //            return false;
		    //        }
		    //   };

		  Tworze zmienna int sumy i przypisuje jej wartosc poprzez wywolanie na wstrzyknietym
		   repo rycerzy strumienia i filtracji rycerzy ktorych zadania sa zakonczone za pmoca
		   wczesniej zadeklarowanej zmiennej Predicate a
		   nastepnie mapowanie do inta poprzez pobranie zlota na zadaniu za pomoca geteru i
		   na koniec sumowanie metoda .sum
		    //int sum = rycerzRepository.getAllRycerze().stream()
            //    .filter(rycerzPredicate)
            //    .mapToInt(x -> x.getZadanie().getNagroda())
            //    .sum();

          Nastepnie na repo rycerzy pobieram wszytkich rycerzy i wywoluje strumien a na nim
           filtracje rycerzy ktorych zadanie zostaly zakonczone (za pomoca Predicate) oraz
           przeiterowanie foreach aby ustawic ich zadanie na null
            //rycerzRepository.getAllRycerze().stream()
            //    .filter(rycerzPredicate)
            //    .forEach(x -> x.setZadanie(null));

          Na koniec zwracam sume zlota
           //return sum;

		//7
		-Metoda aktualizujaca zloto rycerza i zadania - Na poczatku dla kazdego Rycerza
		  wywoluje metode isZakonczony (jesli Rycerz ma zadanie) - w tej metodzie jesli czas
		  zadania minie to ustawia flage zakonczony na true. Metoda takze
		  aktualizuje zloto za pomoca metody serwisu zwracajacej zloto jesli zadanie sie
		  zakonczylo (zdobadzNagrode())
		   //public void dajMojeZloto(){

		 Tworze liste wszystkich Rycerzy
		  //List<Rycerz> rycerze = rycerzService.getAllRycerze();

		 Wywoluje petle foreach na liscie aby dla kazdego Rycerza sprawdzicz czy jego
		  zadanie jest zakonczone(metoda isZakonczony sprawdza czas zadania minal i moze
		  ustawic zadanie na zakonczone (true)
		 Musze tez dla kazdego Rycerza sprawdzic czy jego zadanie nie jest nullem
		   //rycerze.forEach(x -> {
           // 	if(x.getZadanie()!=null){
           //  	   x.getZadanie().isZakonczony();
           //	 }
           //});

         Nastepnie tworze zmienna przechowujaca zloto Rycerza z RycerzaInformacje
		   //int aktualneZloto = rycerzInformacje.getZloto();

    	 NA koniec do wstrzyknietego RycerzInformacje ustawiam zloto
    	  (do poprzedniej wartosci dodaje wartosc z metody tego serwisu zwracajacej zloto
    	   jesli zadanie jest zakonczone)
           //rycerzInformacje.setZloto(aktualneZloto + zdobadzNagrode());}



		SERVICE ZADANIA:

		Na potrzeby testow wstrzykuje zmienna zadaniaRepository za pomoca metody (setera)
		 a nie bezposrednio do zmiennej repository
		Na poczatku musze zadeklarowac zmienna zadaniaRepository BEZ WSTRZYKIWANIA!
		 //ZadanieRepository zadanieRepository;
		 //@Autowired
		 //public void setZadanieRepository(ZadanieRepository zadanieRepository) {
		 // 	this.zadanieRepository = zadanieRepository;}

		DODATKOWO na potrzeby przypisania obiektu zadania wstrzykuje zmienna repo rycerza
		 //@Autowired
    	 //RycerzRepository rycerzRepository;


    	Klasa posiada takze zmienna finalna statyczna random
  		 //final static Random rand = new Random();

		Metody:

		//1
		-Metoda losujaca zadanie i przypisujaca je do wybranego rycerza na podstawie
		  przyslanego imienia (String)
		   //public void assignRandomZadanieFinal(String imie){
		 Metoda na poczatku tworzy nowa liste Zadan za pomoca wstrzyknietej zmiennej
		  repo zadan i wywolaniu na niej metody pobrania wszystkich zadan
		   //List<Zadanie> allZadanie = zadanieRepository.getZadanieLista();
		 Nastepnie tworzy nowe zadanie i przypisuje do niego losowe zadanie z utworzonej
		  listy
		   //Zadanie randomZadanie = allZadanie.get(rand.nextInt(allZadanie.size()));
		 Na koniec do wstrzyknietego repo rycerzy przypisuje wylosowane zadanie.
		 Na repo rycerza wywoluje metode pobrania rycerza lecz zabezpieczam sie gdyby
		  byl null metoda ifPresent - jesli jednak bedzie wykona sie Consumer tego interfacu
		  i ustawie zadanie seterem
		   //rycerzRepository.getRycerz(imie).ifPresent(x -> x.setZadanie(randomZadanie));

		//2
		-Metoda zwracajaca liste nierozpoczetych zadan
    	   //public List<Zadanie> dajWszystkieNieRozpoczeteZadania() {
    	  Metoda korzysta z wstrzyknietej zmiennej ZadanieRepository i wywolaniu na niej
    	   metody pobrania listy zadan + strumien z filtrowaniem ktore zadania
    	   nie sa rozpoczete a nastepnie metoda collect toList
    	    //return zadanieRepository.getZadanieLista().stream()
    	    //                .filter(x -> !x.isRozpoczety())
    	    //                .collect(Collectors.toList());

    	//3
    	-Metoda zapisujaca przyslane zadanie do mapy repo
    	  //public void uaktualnij(Zadanie zadanie) {
    	 Metoda wywoluje na wstrzyknietym repo metode repo zapisujaca przyslane zadanie
    	  do mapy (metoda repo nadpisuje w mapie zadnie poniewaz wysylam zadanie z id
    	  ktore jest juz w mapie ale z Zadaniem bez ustawionej flagi rozpoczete na true)
    	   //zadanieRepository.uaktualnij(zadanie);

		//4
		-Metoda zwracajaca flage czy przyslane Zadanie jest zakonczone
		  //public boolean czyZadanieJestZakocznone(Zadanie zadanie){
		  //   return zadanie.isZakonczony();}



		SERWIS ZADANIA FORMATTER:

		Tworze go na potrzeby zamiany w pliku html - odwolania do pola Zadania.


		W <select th:field="*{zadanie}"> bede przypisywal obiekt Zadania do pola Zadania
		 Rycerza wiec wewnatrz robie pole wyboru z listy <option> z iterowaniem
		 aby wypisac liste Zadan do wyboru
		Podczas iterowania w <option th:each=${zadanie}> kazda iteracja bedzie stringiem
		 wiec bede musial go zamienic na odpowiadajacy mu obiekt zadania aby przypisac
		 go do pola obiektowego Zadania Rycerza (th:value jest wartoscia jaka bede
		 przypisywal)

		Tworze klase z adnotacje @Service i nazwa ZadanieFormatter

		Implementuje ona interface formatter z typem generycznym wybranej klasy
		 //public class ZadanieFormatter implements Formatter<Zadanie>

		Klasa wstrzykuje repo wybranej klasy
		 //@Autowired
		 //ZadanieRepository zadanieRepository;

		Klasa musi zaimplementowac metody interfacu


		Metoda zwracajaca obiekt Zadanie na podstawie przyslnego Stringa (id) +
		 przyslanie zmiennej Locale + wyrzucanie wyjatku ParseException
		  //public Zadanie parse(String idJakoString, Locale locale) throws ParseException {
		 Metoda tworzy zmienna id za pomoca sparsowanego przysnaego Stringa na id
		  //Integer id = Integer.parseInt(idJakoString);
		 Nastepnie tworze obiekt Zadania za pomoca wywolania na wstrzyknietej zmiennej
		  repo metody pobrania Zadania za pomoca sparsowanego id
		   //Zadanie zadanie = zadanieRepository.getZadanie(id);
		 Na koniec zwracam nowy obiekt Zadania
		  //return zadanie;

		Klasa posiada tez metode drukujaca Stinga na podstawie przyslanego
		 obiektu Zadania + zmienna Locale
		  //public String print(Zadanie zadanie, Locale locale) {
		 Metoda zwraca metode toString() na przyslanym obiekcie
		  //return zadanie.toString();



		//Componenty

		Umieszczam w com.firma.Projekt -> components

		Klasa ma adnotacja @Coponent

		Componenty wstrzykuje bezposrenio w kontrolerze oraz dodaje je do modelu

		Moge dodac zasieg @Scope pod adnotacja @Component aby okreslic kiedy
		 ma byc wstrzykiwana wartosc

		Zasiegu moge uzyc do CzasComponent/ProduktStan

		@Scope(value = "session lub request", proxyMode = ScopedProxyMode.TARGET_CLASS)

		W spring web uzywam w scope value oraz proxyMode i sa 2 typy value
		 -session - obiekt jest wstrzykiwany raz przy otwartej sesji (otwarcie karty)
		 -request - obiekt jest wstrzykiwany za kazdym zapytaniem po adres (dowolna operaca)


		Moge uzyc "request" dla klasy czasu (component) aby byla ona wstrzykiwana co
		 kazde zapytanie http

		Natiomiast "session" moge dla szegolow produktu (component) aby wstrzykiwanie
		 bylo tylko raz dla sesji (otwarcie karty)


		TIME COPONENT

		Zawierac ona bedzie zmienna czasu
		 //private LocalDateTime time = LocalDateTime.now();
		+geter seter;


		RYCERZ INFORMACJE (bez scope)

 		//private int zloto = 0;

 		+geter seter






        //Controller @Controller

        Umieszczam w com.firma.Projekt -> controllers

        Klasa taka laczy requesty http do odpowiednich plikow html

        Nazwa analogiczna do klasy domenwoej (np. RycerzController)

    	Klasa posiada metody z mapowaniem ktore obsluguja requesty http np:
    	 @RequestMapping("/rycerze")
		 public String getRycerze(Model model){
			String napis = "Witaj swiecie";
			model.addAttribute("hello", napis);
			return "rycerze";}

		Metody jesli cos maja wyswietlic przyjmuja Model i dodaja do niego
		 atrybuty

    	Metody zwracaja String z nazwa logiczna pliku html jaki ma zostac uruchomiony do
    	 wyswietlenia po wykonaniu instrukcji metody
    	 (return "rycerze";)
    	Lub przekierowanie gdy nie przyjmuja modelu
   		 ("redirect:/rycerze";)


		Przyklady:

		Prosta metoda wyswietlajaca:
		 @RequestMapping("/rycerze")
    		public String getRycerze(Model model){...}

		Teraz dodaje do modelu wybrane elementy za pomoca metody
		 addAttribute() ktora jako parametr wysyla do pliku html klucz oraz
		 obiekt np:

		 -model.addAttribute("hello", "Witaj swiecie");
		   Jako klucz (nazwe) wysylam "hello" oraz obiekt String "Wietaj Swiecie"

		 -List<Rycerz> allRycerze = rycerzService.getAllRycerze();
		   Tworze nowa liste poprzez wywolanie na wstrzyknietej zmiennej
		   metody service zwracajacej liste
          model.addAttribute("rycerze", allRycerze);
           Nastepnie wysylam do pliku html zmienna allRycerze pod kluczem
           "rycerze"

        Na koniec zwracam nazwe LOGICZNA pliku html jaki ma zostac uruchomiony
          return "rycerze";


        RODZAJE MAPOWAN:
		 -proste na strone //@RequestMapping("/rycerze")
		 -gdy przyjmuje dane z formularza okreslam wartosc value (adres) oraz metode:
		   //@RequestMapping(value = "/rycerze", method = RequestMethod.POST)
		   (metda przekierowuje i nie przyjmije modelu!)
		  **
		  / w pliku html:
		  / <form class="form-horizontal" th:object="${rycerz}" th:action="@{/rycerze}"
		  /  th:method="post">
		  / (th:action="@{/rycerze} - okresla value)
		  / (th:method="post" - okresla method))
		  **
		  -gdy chce przechwycic wartosc przez SCIEZKE
		  	W adresie bedzie zmienna ktora przechwyce wpisujac w {} oraz caly
		  	 adres bedzie w value
			//@RequestMapping(value = "/rycerz/delete/{id}")
		   **
		   / W przyjmowanych parametrach metody odwoluje sie do zmiennej "id" poprzez adnotacje
		   / @PathVariable("id) i przypisuje ja do nowej zmienej odpowiedniego typu np:
		   / //public String deleteRycerz(@PathVariable("id")Integer id){
		   /
		   / w html: <a th:href="${'/rycerz/delete/'+x.id}"/> link
		   **
		  -gdy chce przechwycic wartoc przez URL
		    Po adresie (po podanym w mapowanie) bedzie ? i po nim zmienna i przypsana jej wartosc =
		     np /rycerz?id=2
		    //@RequestMapping("/rycerz")
		    **
		    / W metodzie w parametrach korzystam z adnotacji @RequestParam("id") (id jest nazwa
		    / zmiennej w adresie) po czym analogicznie przypisuje ja do zmiennej
		    / //public String getKnight(@RequestParam("id") Integer id, Model model){
		    /
		    / W pliku html okreslam zmienna w adresie po ? id=
		    / //<a th:href="${'/rycerz?id='+x.id}"/>link
			**


		CONTROLER RYCERZA:

		Na poczatku wstrzykuje serwis rycerza, oraz component czasu i RycerzInfroamacje
		 //@Autowired
    	 //RycerzService rycerzService;

    	 //@Autowired
    	 //TimeComponent timeComponent;

    	 //@Autowired
    	 //RycerzInformacje rycerzInformacje;


		Metody:

		//1
		-Mapowanie na glowna strone z wyswietleniem
		   //@RequestMapping("/rycerze")
		   //public String getRycerze(Model model){

		  W ciele metody tworze liste Rycerzy i przypisuje jej wartosc poprzez
		   wywolanie na wstrzyknietym serwisie Rycerzy metody zwracajacej liste Rycerzy
			//List<Rycerz> allRycerze = rycerzService.getAllRycerze();

		  Nastepnie dodaje nowa liste do modelu
		   //model.addAttribute("rycerze", allRycerze);

          Oraz wstrzyknieta zmienna komponentu czasu oraz klasy szczegolow obiektu
           //model.addAttribute("timecomponent", timeComponent);
           //model.addAttribute("rycerzinformacje", rycerzInformacje);

          Na koniec zwracam logiczna nazwe pliku html
          //return "rycerze";


		//2
		-Mapowanie na nowy adres + wyslanie pustego obiektu klasy domenowej na potrzeby
		  zmian przez uzytkownika na stronie
		   //@RequestMapping("/newrycerz")

		  Metoda przyjmuje model poniewaz bedzie wyswietlac strone
		   //public String createRycerz(Model model){

		  Nastpenie dodaje do modelu pusty obiekt klasy domenowej z kluczem "rycerz"
		   korzystajac z konstruktora bezparametrowego klasy domenowej
		    //model.addAttribute("rycerz", new Rycerz());

		  Nastepnie dodaje do modelu wstrzyknieta zmienna komponentu czasu oraz
           klasy szczegolow obiektu
            //model.addAttribute("timecomponent", timeComponent);
            //model.addAttribute("rycerzinformacje", rycerzInformacje);

          Na koniec zwracam nowa strone
           //return "rycerzform"


		//3
		-Mapowanie przyjmujace dane uzupelnionego obiektu oraz metoda przekierowuje
		  na strone bazowa, mapowanie przyjmue value oraz method i nie przyjmue
		  Modelu poniewaz nie bedzie wyswietlac strony tylko przekierowuje na glowna
		  strone.
		 Value jest adresem jaki bedzie okreslony w html th:action
		  aby wybrac konkretna metode mapowania
		   //@RequestMapping(value = "/rycerze", method = RequestMethod.POST)
		  **
		  / W pliku html wszystko okreslam w <form>, jako value - th:action="@{/rycerze}"
		  / natomiast method - th:method="post"
		  **

		  Metoda obluguje takze walidacje danych przyslanego obiektu za pomoca @Valid oraz
		   za pomoca przyjetej zmiennej BindingResult
		    //public String saveRycerz(@Valid Rycerz rycerz, BindingResult bindingResult){

		  W ciele metody wykorzystje bindingResult i sprawdzam czy ma bledy w if
		   //if(bindingResult.hasErrors()){

		  Jesli tak to zwracam nazwe strony wprowadzania danych + opconalnie wyswietlenie
		   bledow na konsoli
		   //if(bindingResult.hasErrors()){
           //	 bindingResult.getAllErrors().forEach(x->
           //         System.out.println(x.getObjectName() + " "+
           //         x.getDefaultMessage()));
           // 	 return "rycerzform";}

          Jesli nie bedzie bledow (else) to na wstrzyknietym serwisie Rycerza wywoluje metode
           zapisu przyslanego obiektu do mapy repo, wysylam jako parametr przyslanego Rycerza
            //rycerzService.saveRycerz(rycerz);

          Oraz zwracam (tez w else) PRZEKIEROWANIE na glowna strone
           //return "redirect:/rycerze";


		//4
		-Mapownie na nowa strone wyswietlajaca szczegoly obiektu z listy
		   //@RequestMapping("/rycerz")

		  Metoda przechwytuje z adresu wartosc zmiennej - w adresie po tym co
		   mapuje jest ? jest jej nazwa + przypisana wartosc poprzez =
		  (przykladowy adres /rycerz?id=2)
		  **
		  / w pliku html : a th:href="${'/rycerz?id='+x.id}"/>link
		  **
		  W parmatrach metody korzystam z adnotacji RequestParam("id") przed deklaracja
		    zmiennej do jakiej bedzie przypisana przechwycona wartosc
		  Metoda przyjmuje takze model poniewaz zwraca adres strony i wyswietla
		   //public String getKnight(@RequestParam("id") Integer id, Model model){

		  Nastepnie tworze obiekt klasy domenowej i przypisuje mu wartosc poprzez
		   wywolanie na wstrzyknieje zmiennej serwisu metody zwracajacej obiek
		   na podstawie przechwyconej zmiennej "id"
		    //Rycerz rycerz = rycerzService.getRycerz(id);

		  Teraz dodaje Rycerza do modelu
           //model.addAttribute("rycerz", rycerz);

          Nastepnie dodaje do modelu wstrzyknieta zmienna komponentu czasu oraz
           klasy szczegolow obiektu
            //model.addAttribute("timecomponent", timeComponent);
            //model.addAttribute("rycerzinformacje", rycerzInformacje);

		  Na koniec zwracam adres nowej strony
		   //return "rycerz";


		  //5
		  -Mapwanie przekierowujace na glowna strone (nie zmienia strony) na potrzeby
		    usuniecia obiektu

		   Mapowanie przechwytuje zmienna takze z adresu lecz w mapowaniu podaje pozycje
		    zmiennej w adresie w {} i w srodku podaje nowa nazwe ktora bede uzywal w przyjmowanych
		    parametrach metody - wszystko przypisuje do value
		     //@RequestMapping(value = "/rycerz/delete/{id}")
		   (przykladowy adres /rycerz/delete/3 - zmienna id wynosi 3)
		   **
		   / w pliku html : <a th:href="${'/rycerz/delete/'+x.id}"/>
		   **

		   W parmatrach metody korzystam z adnotacji @PathVariable("id") przed deklaracja
		    zmiennej do jakiej bedzie przypisana przechwycona wartosc
		     //public String deleteRycerz(@PathVariable("id")Integer id){

		   Nastepnie wywoluje na zmiennej serwisu metode usuniecia obiektu za pomoca
		    przechwyconej zmiennej "id"
		     //rycerzService.deleteRycerz(id);

		   Na koniec przekierowuje do glownej strony (nie robi sie nic bo jestem na niej)
		    //return "redirect:/rycerze";



		CONTROLER ZADANIA:

		Wstrzykuje zmienne serwisu Zadania
		 //@Autowired
		 //ZadanieService zadanieService;

		Oraz rycerza na potrzeby dodawania zadan dla rycerzy
		 //@Autowired
		 //RycerzService rycerzService;

		Oraz informacje o rycerzu
		 //@Autowired
    	 //RycerzInformacje rycerzInformacje;


		Metody:

		//1
		-Mapowanie na nowa strona w ktorej bede konkretnemu obiektowi rycerza przypisywal
		  zadanie, wysylam do modelu liste nierozpoczetych zadan ktore bede przypisywal na
		  stronie.
		 Adres przechwytuje id poprzez SCIEZKE
		   //@RequestMapping(value = "/przypiszzadanie/idrycerza={id}")

		 Przypisuje id oraz dodaje model bo stona bedzie wyswietlac
		  //public String przypiszZadanie(@PathVariable("id")Integer id, Model model){

		 Metoda na poczatku tworzy obiekt rycerza i przypisuje mu wartosc za pomoca
		  metody pobrania rycerza na wstrzykniej zmiennej serwisu rycerza z uzyciem
		  przechwyconego id
		   //Rycerz rycerz = rycerzService.getRycerz(id);

		 Nastepnie tworze nowa liste Zadan ktorej przypisze nieukonczone zadania poprzez
		  wywoalnie UNIKLANEJ metody serwisu pobrania listy nierozpoczetych zadan na
		  wstrzyknietej zmienej serwisu zadan (w serwisie mam zadeklarwoane dzialanie
		  metody)
		   //List<Zadanie> zadanieNieRozpoczete = zadanieService.dajWszystkieNieRozpoczeteZadania();

		 Nastepnie dodaje do modelu stworzony obiekt na podstawie id z adresu oraz nowa liste
		  nierozpoczetych zadan
		  //model.addAttribute("rycerz", rycerz);
          //model.addAttribute("zadanianierozpoczete", zadanieNieRozpoczete);

         Na koniec zwracam nowa strone
          //return "przypiszzadanie";


        //2
        -Mapowanie na otrzymany obiekt rycerza z przypisanym zadaniem z html oraz
          uaktualnienie listy rycerzy oraz listy zadan i powrot na glowna strone

         Przekierowuje na strone wiec nie ma podelu oraz dodaje value i method
           //@RequestMapping(value = "/przypiszzadanie", method = RequestMethod.POST)
          **
		  / W pliku html wszystko okreslam w <form>, jako value - th:action="@{/przypiszzadanie}"
		  / natomiast method - th:method="post"
		  **

		 Metda przyjmuje obiekt rycerza
		  //public String przypiszZadanie(Rycerz rycerz){

         Na serwisie rycerzy uaktualniam (zastepuje) rycerza ktory zostal przyslany z przypisanym
          zadaniem korzystajac z wstrzyknietego serwisu i metody uaktualnienia Rycerza na podstawie
          obiektu Rycerza
           //rycerzService.uaktualniRycerza(rycerz);
          **
          / serwis pobiera jego id oraz przekazuje do repo id + obiekt rycerza ktory wklada
          / do mapy (zastepuje bo jest juz rycerz z takim id)
          **

         Nastepnie tworze zadanie i przypisuje wartosc z przyslanego Rycerza - geter
          (zadanie bedzie mialo flage rozpoczete na true - w pliku html przypisuje pole
           zadanie - seter w klasie rycerza ustawie rozpoczete na true)
            //Zadanie zadanie = rycerz.getZadanie();

         Teraz do wstrzyknietego serwisu zadan dodaje zadanie za pomoca metody uaktualnij
          ktore jako parametr wykorzystuje stworzone wczesniej zadanie
          (zadanie zostanie nadpisane poniewaz jest juz z takim id ale terz jest z flaga
          ropoczete na true)
           //zadanieService.uaktualnij(zadanie);
          **
          / serwis przsyla to samo do repo, repo pobiera id tego zadania i dodaje je do
          / mapy (zastepuje bo jest juz takie zadanie z takim id lecz teraz ma flage
          / rozpoczete na true)
          **

         Na koniec przkierowuje na glowna strone rycerzy (po wcisnieciu submit)
          //return "redirect:/rycerze";


		//3
		-Mapowanie aktualizujace strone glowna za pomoca nowego linku
		  //@RequestMapping(value = "/sprawdzZadania")

		 Metoda nie przyjmuje zadnych parametrow
		  //public String sprawdzZadania(){

		 W metodzie ne serwisie wywoluje metode dajMojeZloto aby kazdemu
		  Rycerzowi zakutalizowac zloto oraz Zadania
		  //rycerzService.dajMojeZloto();

		 Na koniec przekierowuje do glownej strony
		  //return "redirect/rycerze";





		//Budowa strony html:

		Pliki html thymeleaf umieszam w resources->templates

		Jesli korzystam ze standardowych plikow html to w resources->static


		Na poczatku pliku html dodaje przstrzen nazw thymeleaf,
		 oraz w head tytul storny, kodowanie, biblioteki css oraz skrypty:

		<!DOCTYPE HTML>
		<html xmlns:th="http://www.thymeleaf.org">
		<head>
			<title>Zaczynam : Web Content</title>
			<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8"/>

			<link rel="stylesheet" th:href="@{/webjars/bootstrap/4.1.3/css/bootstrap.min.css}"/>

			<script th:src="@{/webjars/jquery/3.3.1-1/jquery.min.js}"></script>
			<script th:src="@{/webjars/bootstarp/4.1.3/bootstrap.min.js}"></script>
		</head>


		Korzystam z przyslanych elementow w body

		Themeleaf operauje na znacznikach th w znacznikach html
		 (div/p/tbody/form/input/span)

		Elementy w kontrolerze wysylane sa za pomoca klucza i wartosci dodajac cos do modelu
		 String napis = "Witaj swiecie";
         model.addAttribute("hello", napis);
         model.addAttribute("czascontoller", czasController);
        Natomiast odwolanie proste do niech moze byc np:
         <p th:text="${hello}"/> (obiekt prosty string wiec mozna wyswietlic)
         <p th:test="${czascontroller}"/> (wyswietle adres obiektu lub metode toString klasy)
         <p th:test="${czascontroller.czas}"/>
         (odwoluje sie do zmiennej klasy - musi byc geter w klasie)


        Znaczniki th:
         -th:text (<p th:text="${hello}"/>) - przyjmuje obiekt o kluczu "hello" i wyswietlam
           go w akapicie
         -th:number - analogicznie
         -th:object (th:object="${rycerz}") - dodaje w <form> i przypisuje otrzymany obiekt
           o kluczu "rycerz" nastepnie w <input> odwoluje sie do niego
         -th:th:action (th:action="@{/rycerze}") - dodaje w <form> aby w metodzie controllera
           przechwycic nowy adres w value (@RequestMapping(value = "/rycerze")
         -th:method (th:method="post") - dodaje w <form> okreslam metode zapisu danych aby w
           metodzie controllera przechwycic przypisuje do method
           @RequestMapping(value = "/rycerze", method = RequestMethod.POST)
         -th:field (th:field="*{imie}") - uzywam w <form>-><div>-><input> aby zapisac
           wprowadzone dane do formularza do okrelonego pola (wymagany seter w klasie bazowej)
           Obiekt z jakiego bede korzystal okreslilem wczesniej w <form> (th:object="${rycerz}")
         -th:each (<tbody th:each="x : ${rycerze}">) - sluzy do iterowania przyslanej listy
           Za x bede mial kazdy element listy i odwoluje sie do niego z th+typ
           (<tr><td th:text="${x.imie}"></td></tr>)
         -th:href (<a th:href="${'/rycerz?id='+x.id}"/>) - sluzy do okreslenia linku z paramtrem
           (wpisuje ? i po tym nazwe zmiennej np "id" i = w '') lub za pomoca URL
           (<a th:href="${'/rycerz/delete/'+x.id}"/>)
         -th:if (<p th:if="${#fields.hasErrors('wiek')}" th:errors="*{wiek}"/>) - sluzy do
           walidacji formularzy, JESLI pole "wiek" z wybranego obiektu th:object bedzie mialo
           niespelniony warunek (z adnotacji klasy bazowej) to wyswietli blad th:errors,
           standardowy lub okreslony komunikat (okreslam w adnotacji w message)


		Znacznik th moze
			-odczytywac -$ //<p th:text="${hello}"/>
			//<p th:test="${czascontroller.czas}"/>
			//<form class="form-horizontal" th:object="${rycerz}" th:action="@{/rycerze}"
			//    	   th:method="post">
			-zapisywac -* //<input type="text" class="form-control" th:field="*{imie}"/>
			-odnoscic sie do adresu -@ (w controlerze value="")
			//<form class="form-horizontal" th:object="${rycerz}" th:action="@{/rycerze}"
			//    	   th:method="post">


		Przyklady operacj na obiektach z th:
		 -bezposrenio do elementu np w akapicie "p" - okrelam typ
		   <p th:text="${hello}"/>
		   <p th:test="${czascontroller}"/>
		   <p th:test="${czascontroller.czas}"/>
		 -w iterowaniu (w petli foreach) th:each="x : ${produkty}"
		   --w kontnerze
		      <div th:each="x : ${produkty}"> (za x bede odwolywal sie do elementow)
		       <h3 th:text="${x.nazwa}"/> (klasa bazowa musi miec geter do tej zmiennej!)
		   --w tabeli (body)
		      <table class="table">
		      	<tbody th:each="x : ${rycerze}">
		       		<tr>
                    	<td th:text="${x.imie}"></td>
         -w linkach
           --z umieszczeniem parametru (zmiennej) w URL
              <td><a th:href="${'/rycerz?id='+x.id}"/>Podglad</a></td>
             Po kliknieciu zostanie wygenerowany adres ze zmienna
              przykladowy adres:
               /rycerz?id=2
             przechwycenie w kontrolerze
			  @RequestMapping("/rycerz")
    		  public String getKnight(@RequestParam("id") Integer id, Model model){
    		 Szuka we wpisanym linku "id" po ? i jego wartosci po =
    		 Nastepnie przypisuje watosc w przyjetych parametrach metody
    	   --z umieszczeniem paramtru w sciezce
    	      <a th:href="${'/rycerz/delete/'+x.id}"/>Usun</td>
    	     Po kliknieciu zostanie wygenerowany adres ze zmienna
              przykladowy adres:
               /rycerz/delete/0
             przechwycenie w kontrolerze
              @RequestMapping(value = "/rycerz/delete/{id}")
    		  public String deleteRycerz(@PathVariable("id")Integer id){
    		 W mapowaniu adresu czesc linku umieszczam w {} i nazywam po czym
    		  przypisuje to do zmiennej @PathVariable("id") Integer id
    	 -w formularzach
    	 	<div class="container">
        		<form class="form-horizontal" th:object="${rycerz}"
        		 th:action="@{/rycerze}" th:method="post">
            		<div class="form-group">
                		<label class="control-label">Imie:</label>
                		<input type="text" class="form-control" th:field="*{imie}"/>
         -w sprawdzeniu bledow
           <p th:if="${#fields.hasErrors('wiek')}" th:errors="*{wiek}"/>


		Budowa tabeli
		 1.<div class="container">
		 2.<table class="table">
		 3.1. <thead>
		 		<tr>
		 			<td>Imie
		 3.2. <tbody th:each="x : ${rycerze}">
		 		<tr>
                    <td th:text="${x.imie}">

        Linki (klasyczne bez th):
         <div class="row">
         	<a href="/newrycerz">Dodaj nowego rycerza</a>



    	Formularze:

    	 Tworze nowa strone dodajprodukt.hmtl i na poczatku dodaje odpowiednie
    	  dane

    	 1.<div class="container">
    	 2.<form class="form-horizontal" th:object="${rycerz}" th:action="@{/rycerze}"
    	   th:method="post">
    	    -th:object jest to pusty obiekt jaki wysylam w metodzie kontrolera
    	     @RequestMapping("/newrycerz")
    		 public String createRycerz(Model model){
        		model.addAttribute("rycerz", new Rycerz());
        		return "rycerzform";}
    	    -th:action="@{/rycerze}" jest to adres jaki musi zostac przechwycony w value
    	      w nowej metodzie kontrolera ktora przyjmuje gotowy obiekt (zapisuje do value)
    	       + metoda zapisu
    	      @RequestMapping(value = "/rycerze", method = RequestMethod.POST)
    		  public String saveRycerz(Rycerz rycerz){
    		   		rycerzService.saveRycerz(rycerz);
        			return "redirect:/rycerze";}
    	 3.<div class="form-group">
    	 4.1<label class="control-label">Imie:</label>
		 4.2<input type="text" class="form-control" th:field="*{imie}"/>
		 	-klasa bazowa musi miec seter do pola "imie"
		 4.3<p th:if="${#fields.hasErrors('wiek')}" th:errors="*{wiek}"/>
		    -sprawdzam czy pole wiek ma bledy i jesli tak to wyswietle komunikat
		 5.<div class="row">
                <button type="submit" class="btn btn-default">Utworz rycerza</button>
         6.</form></div>




		STRONA GLOWNA:

		Na poczatku dodaje fromatke html

		Nastepnie otwieram glowny kontener
		 //<div class="container">

		W nim umieszczam aktualny czas pobrany z dodanego do modelu obiektu timecomponent
		 i odniesieniu sie do jego pola time
		  //Aktualny czas<span th:text="${timecomponent.time}"/>

		Nastepnie dodaje tabele z klasa bootstrapa
		 //<table class="table">

		Dodaje glowe tabeli
		 //<thead>
		I w srodku wiersz
		 //<tr>
		A w nim kolumny z nazwami pol (zwykly tekst) jakie bede uzywal w tabeli + dodaje dodatkowe
		 koluny na potrzeby przyciskow nizej
		  //<td>Imie</td>
		  //<td>Poziom</td>
		  //<td>Zadanie</td>
		  //<td></td>
		Zamykam wiersz i glowe tabeli
		 //		</tr>
		 //</thead>

		 Dodaje cialo tabeli z petla foreach korzystajaca z dodanej do modelu listy obiektow
		  Rycerzy, odwolywac sie bede w obrocie petli jako "x" i po . pole
		   //<tbody th:each="x : ${rycerze}">
		 Teraz dodaje wiersz ktory bedzie sie powielal z kazdym obrotem petli + kolumny
		  //<tr>
		 Pierwsze kolumny sa z prostymi odniesienieami do pola iterowanego obiektu z listy
		  w formie th:text
		   //<td th:text="${x.imie}"></td>
		   //<td th:text="${x.level}"></td>
		 Nastepnie dodaje kolumne ktora zawiera zagniezdzony napis (<span>) z warunkiem if ktory
		  bedzie uzupelniac sie w zaleznosci czy pole x.zadanie bedzie puste
		   //<td>
		   //		<span th:if="${x.zadanie==null}">Brak Zadania
		 Jesli puste - bedzie wyswietlac sie napis "Brak Zadania" oraz link do strony z wyciagnietym
		  id z iterowanej zmiennej x.id - strona wybierania zadania dla Rycerza z wyciagnietym id
		 Na koniec zamykam <span>
		   //			<a th:href="${'/przypiszzadanie/idrycerza='+x.id}">Przypisz zadanie</a>
		   //		</span>
		 W tym samym wierszu dodaje kolejny <span> z warunkiem gdy zadanie NIE BEDZIE nullem czyli
		  wykona sie tylko jak wczesniejszy bedzie false. Wewnatrz <span> dodaje to co ma sie
		  wyswietlic czyli th:text i wartosc pola zadania iterowanego obiektu oraz z niego
		  opis z klasy Zadanie
		   //<span th:if="${x.zadanie!=null}" th:text="${x.zadanie.opis}"/>
		 Na koniec zamykam wiersz
		  //</td>
		 Calosc:
		   //<td>
		   //	<span th:if="${x.zadanie==null}">Brak Zadania
		   //        <a th:href="${'/przypiszzadanie/idrycerza='+x.id}">Przypisz zadanie</a>
		   //   </span>
		   //   <span th:if="${x.zadanie!=null}" th:text="${x.zadanie.opis}"/>
		   //</td>

		 Dodaje kolejna kolumne z linkiem do strony szczegolow obiektu na podstawie jego id
		  (tutaj wykorzystam zmienna w adresie ?zmienna= - czyli przez URL)
		   //<td><a th:href="${'/rycerz?id='+x.id}"/>Podglad</a></td>
		 Kolejna kolumna zawiera link do usuniecia obiektu na podstawie jego id (tutaj uzyje zmienna
		  zakodowana w adresie w formie bez zmiennej - czyli przez SCIEZKE)
		  //<td><a th:href="${'/rycerz/delete/'+x.id}"/>Usun</td>
		 Na koniec zamykam iterowany wiersz oraz cialo tabeli i tabele
		  //		</tr>
          //   </tbody>
          //</table>

          Dodaje kolejny kontner w formie wiersza
           //<div class="row">
          A w nim link do nowej strony
           //<a href="/newrycerz">Dodaj nowego rycerza</a>
          Nastepnie zamykam kontener
           //</div>

          Na koniec zamykam kontner glowny oraz body i html
           //	</div>
           //</body>
           //</html>



		STRONA SZCZEGOLOW RYCERZA:

        Dodaje formatke html

        W ciele dodaje kontener glowny
         //div class="container">

        W nim umieszczam aktualny czas pobrany z dodanego do modelu obiektu timecomponent
		 i odniesieniu sie do jego pola time
		  //Aktualny czas<span th:text="${timecomponent.time}"/>

		Nastepnie dodaje akapity z wartosciami pol wyciagnietych z dodanego do modelu
		 obiektu na podstawie id, robie to zapomoca prostego th:text i odwolania do pola
		 obiektu po .
		 //<p th:text="${'Imie rycerza : '+rycerz.imie}"></p>
    	 //<p th:text="${'Wiek rycerza : '+rycerz.wiek}"></p>
    	 //<p th:text="${'Level rycerza : '+rycerz.level}"></p>
    	 //<p th:text="${'Zadanie rycerza : '+rycerz.zadanie}"></p>

    	Na koniec zamykam kontener glowny, body i html
    	 //		</div>
		 //</body>
		 //</html>



		STRONA DODANIA RYCERZA

		Dodaje formatke html

		Otwieram kontener glowny
		 //<div class="container">

		Otwieram formularz zawieracy :
		 -wskazanie do dodanego obiektu do modelu th:object="${rycerz}"
		 -przkierowanie do adresu po wcisnieciu submit th:action="@{/rycerze}" na podstawie
		   ktorego wybierana bedzie metoda kontrolera (wartosc value w parametrach req. mapping)
		 -metode zapisu th:method="post" - tez do okreslenia w adnotacji kontrolera
		   //<form class="form-horizontal" th:object="${rycerz}" th:action="@{/rycerze}"
		   // th:method="post">

		Dodany obiekt do modelu ma ZEROWANE POLA!

		W srodku dodaje pojedynczy kontner do uzupelnienia wybranego pola
		 //<div class="form-group">
		Wewnatrz dodaje nazwy w formie prostego tekstu nad polem formularza
		 //<label class="control-label">Imie:</label>
		Oraz pole wporwadzenia ktore wkazuje do jakiego pola obiektu bede wprowadzal dane
		 //<input type="text" class="form-control" th:field="*{imie}"/>
		Dodaje takze akapit pod formularzem jesli wystapi blad
		 //<p th:if="${#fields.hasErrors('imie')}" th:errors="*{imie}"/>
		 **
		 / w kontrolerze dodaje @Valid przed przyjmowanym argumentem obiektu oraz dodatkowy
		 / argument BindingResult
		 / W klasie domenowej przed polem dodaje adnotacje np @Range w ktorej okreslam message =""
		 **
		Teraz zamykam kontener uzupelniajacy to pole
		 //</div>

		Nastepnie moge dodac kolejny kontner z wprowadzaniem danych do kolejnego pola analogicznie
		 //<div class="form-group">
		 //    <label class="control-label">Wiek:</label>
		 //    <input type="number" class="form-control" th:field="*{wiek}"/>
		 //    <p th:if="${#fields.hasErrors('wiek')}" th:errors="*{wiek}"/>
		 //</div>

		Kolejnym kontnerem bedzie wiersz zawierajacy przycisk submit z napisem
		 //<div class="row">
		 //		<button type="submit" class="btn btn-default">Utworz rycerza</button>
		 //</div>

		Teraz zamykam formularz
		 //</form>

		Nastepnie zamykam kontner glowny, body i html
		 //		</div>
		 //</body>
		 //</html>



		STRONA PRZYPISYWANIA ZADANIA:

		Dodaje formatke hmtl

		Otwieram kontner glowny
		 //<div class="container">

		Otwieram formularz dla obiektu rycerza
		 //<form class="form-horizontal" th:object="${rycerz}" th:action="@{/przypiszzadanie}"
		 // th:method="post">
		Ukrywam pola (zachowuje wartosci pol obiektu ktory zostal wyslany do modelu)
		 poniewaz standardowo obiekt wysylany z htmla do controlera jest wysylany
		 z polami zerowanymi chyba ze przypisze wartosci na stronie, moge dodac
		 opcje aby automatycznie przypisywane byly wartosci takie jaki mial obiekt
		 przypisany
		  //<input type="hidden" th:field="*{id}"/>
		  //<input type="hidden" th:field="*{imie}"/>
		  //<input type="hidden" th:field="*{wiek}"/>
		  //<input type="hidden" th:field="*{level}"/>

		Nastepnie otwieram kontener do wprowadzania danych (okno formularza)
		 //<div class="form-group">

		Dodaje tytul nad formularzem
		 //<label class="control-label">Wykonaj zadanie</label>

		Dodaje liste pol do wyboru gdzie okreslam jakie pole bede zmienial (wybierajac z listy)
		 w przyslanym obiekcie Rycerza (th:object="${rycerz}")
		 //<select th:field="*{zadanie}">

		Wewnatrza dodaje ROZWIJANA liste elementow do wyboru z listy (option) +
		 -wykorzystuje petle foreach odnoszaca sie do listy zadan dodnaych do modelu,
		   (th:each="x : ${zadanianierozpoczete}"
		  Kazda iteracje bedzie OBIEKTEM!
		 -okreslam wartosc jaka bedzie przypisana po wyborze (dla pola obiektowego Zadania rycerza)
		   (th:value="${x.id}")
		  Standardowo x.id zostanie przez html przerobione na STRING z id iterowanego Zadnia ktore
		   jest intem!
		  Teraz musze zmienic ten STRING na obiekt Zadania poniewaz przypisuje wybor do
		   pola Zadania Rycerza
		  Robie to za pomoca serwisu ZadanieFormatter
		 -okrelam tez co bedzie wyswietlalo sie jako wybor elementu
		   (th:text="${x.opis}">
		  //<option th:each="x : ${zadanianierozpoczete}"
		  //        th:value="${x.id}"
		  //        th:text="${x.opis}">
		  //</option>

		 Teraz zamykam kontner pojedynczego formularza
		  //</div>

		 Dodaje kolejny formularz w kontnerze wiersza
		  //<div class="row">
          //  <button type="submit" class="btn btn-default">Wyslij rycerza</button>
          //</div>

         Zamykam formularz
          //</form>

         Zamykam kontner glowny, body i html
          //	</div>
		  //</body>
		  //</html>




		BAZY DANYCH

		JPA - interfejsy

		Hibernate - framework

		H2 - prosty rodzaj bazy danych


		Dzialanie JPA opiera sie na 2 obiektach:
		 -EntityManagerRactory - singleton gdzie trzymana jest pula polaczen do
		   bazy danych, odpowiada za tworzenie EntityManager i przekazuje mu
		   jednogo polaczenia do bazy dancyh z puli
		   W Hibernate nazywa sie SessionFactory
		 -EntityManager - obiekt sesji ktory tworzymy za kazdym razem nowy gdy
		   chce wykonac jakas operacje na bazie danych (zapisac obiekt/pobrac dane)
		   W hibernate nazywa sie Session


		Dodaje dependencje:

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>

		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.0</version>
		</dependency>


		Dodaje w glownym pliku properties linijke aby dzialala konsola w przegladarce
		 //spring.h2.console.enabled=true


		Klasa domenowa ktora bedzie korzystac z bazy danych musi miec pole id
		Dodaje przed zmienna id klasy adnotacje
		 @Id
		oraz
    	 @GeneratedValue(strategy = GenerationType.AUTO)
    	Aby za kazdym razem gdy bede wstawial obiekt do bazy danych to to pole bedzie
    	 mialo unikalna wartosc


    	Hibernate wymaga pustego konstruktora klasy


*/





/*--------------------------------------------------------------------
------------------------------BAZY DANCYH-----------------------------

----ACID----

ACID - zbiór właściwości, które pozwalają osiągnąć spójność danych

Transakcja to ciąg operacji do wspólnego niepodzielnego wykonania.

A (ang. atomicity) – atomowość
Jeśli w ramach jednej transakcji wykonywane jest kilka operacji, nie
 zostaną one wykonane jeśli jedna z operacji się nie wykona.

C (ang. consistency) – spójność
Zapewnia ona spójność danych poprzez zastosowanie mechanizmów, które
 uniemożliwiają zmianę danych w nieautoryzowany sposób

I (ang. isolation) – izolacja
Transakcje powinny sobie wzajemnie nie  przeszkadzać w działaniu

D (ang. durability) – trwałość
Dane zatwierdzone przez transakcję powinny być dostępne nawet w sytuacji
 awarii programu, komputera lub nośnika danych



----SQL Injection----

Jeden z podstawowych atakow na bazy danych
Polega on na odpowiednim spreparowaniu danych wejściowych np podcza wprwadzenia
 adresu email podczas rejestracji atakujacy wprowadzi w polu email komendy
 dla operacji bazy danych np '; DELETE FROM users WHERE 1 = 1 OR email = '

Aby zapobiec atakom nie stsosuje sie recznego budowania zapytan SQL poprzez
 laczenie lancuchow znakow.
Nalezy uzywac do tego zewnetrznych bibiotek np Hibernate
Biblioteki te odpowiednio traktuja dane ktore sluza do wypelnienia szablonow
 zapytan



---OGOLNE INFO----

Baza danych to zbiór danych zapisanych w odpowiednim formacie

W zależności od zastosowania dane zapisywane są w różny sposób co ma
 wplywn a wydajność poszczególnych operacji (zapisu, odczytu, usunięcia
 i modyfikacji danych)

Najpopularniejszym rodzajem bazy danych jest relacyjna baza danych

Dane zapisywane sa w krotkach ktore zawieraja swoje parametry oraz zapisane
 sa w relacji (tabeli)


Najpopularniejszymy impelementacjami baz danych sa:
- PostgreSQL
- MySQL
- SQLite
- Oracle
- SQL Server
- HyperSQL

Kazda implementacja rozni sie od siebie i ma inny rodzaj jezyka SQL (dialekt)


Srodowisko z baza danych zawsze sklada sie z conajmniej jednego klienta
 oraz serwera baz dancyh

Serwer bazy danych jest to porgram ktory obsluguje zapytania wyslane przez klienta
 oraz odpowiedzialny jest za zapisywanie i udostepnianie danych z bazy

Zadania sa nasluchiwane na odpowiednim porcie np. PostgreSQL na 5432


Serwer uzywa protokolow do komunikacji z klientem
- ODBC (Open Database Connectivity) zapewnia on dostep do danych niezalezny od serwera
   bazy danych
- JDBC (Java Database Connectivity)


Klient wskazuje serwer z ktorym chce sie polaczyc za pomoca URL np:
jdbc:postgresql://some.server.host:5432/database_name

Potrzebuje on takze strownika do obslugi polaczenia pomiedzy nim a serweram - klasy
 obslugujacej polaczenie (producenci udostepniaja sterowniki)

Klient uzywa jezyka SQL do zadan dotyczacych dostepu do danych po nawiazaniu
 polaczenia za pomoca sterownika

Serwer interpretuje zapytanie i pobiera lub zapisuje dane na dysku serwera
Dane przekazywane sa zgodnie z protokolem np JDBC


Encja - rodzaj obiektu (krotki) w bazie danych jej odpowiednikiem w programowaniu
         jest klasa


Atrybut - wlasciwosc encji (pole) ktore ma swoj typ, maja one swoje odpowiedniki z
            programownia np w PostgreSQL:
String  -	varchar
boolean	-   boolean
double  -   double precision
byte[]  -	bytea
int	    -   integer

Sa tez rodzaje atrybutow ktore nie maja swojego odpowiednika w programowani np:
- box
- becimal(p,s)
- polygon


Krotka - zbior wszystkich atrybutow w kolumnie tabeli (relacji), odpowiednik obiektu,
          kazdy wiersz w tabeli to inna krotka, kazda posiada unikalna wartosc
          atrybutu Id np "AlbumID" numerowanego od 1 (klucz glowny - primary key),
          moze takze posiadac atrybuty kluczy obcych (foreign key) wskazyjacych na
          klucz glowny innych relacji (tabel)


Relacja - zbior krotek, tabela, nazywa sie jak nazwa encji w liczbie mnogiej np: firmy
            Relacja to takze okreslenie zaleznosci pomiedzy tabelami np jeden do wielu


W modelu relacyjnym kazda krotka jest unikalna ale SQL pozwala na duplikaty wierszy
 w tabeli


Klucz glowny -  atrybut(kolumna) relacji (tabeli) ktory jest tworzony
                dla krotek, jest on UNIKALNY, w wiekszosci przypadkow relacje maja
                taki atrybut i jest on w postaci liczby numerowanej od 1
                (primary key) nazwa jest brana z nazwy encji np: Albumy - AlbumId

Dodajac kolejne krotki do relacji przypisywana jest automatycznie wartosci klucza (Id) o jeden
 wieksza od poprzedniego
Jesli jest kilka atrubutow kluczy w jedenej relacji to znaczy ze relacja ma klucz zlozony
Dzieki kluczom latwiej dostac sie do pojedynczej krotki relacji niz za pomoca zwyklego
 atrubutu np "nazwa"


Klucz obcy - kazda relacja moze zawierac kilka atrubutow klucza obcego i jego wartosc wskazuje
              na klucz glowny innej relacji i ten atrubut nazwya sie od nazwy encji z ktorej jest
              brany klucz np "ProducentId", jeden klucz obcy (wartosc) moze byc dla wielu krotek '
              ten sam (foreign key)


Bazy danych moga zawierac takze obiekty takie jak indeksy (index), ograniczenia (constraint)
 wyzwalacze (trigger), widoki (view)


Rodzaje powiazan (zaleznosci)
- jeden do jednego np. samochod - numer rejestracyjny
- jeden do wilu np. prudcent - samochod
- wiele do wielu np. produkt - miejsce sprzedazy

Zaleznosc wiele do wielu potrzebna jest dodatkowa tabela ktora nazywa sie po nazwach
 tabel (relacji) np. produkt_miejsce_sprzedazy i zawiera ona atrybuty kluczy
 obcych tabel ktore ma powiazac o wartosci ich klucza glownego np. ProduktId(FK),
 Miejsce_sprzedazyID (FK) - jest to klucz zlozony


Bazy danych ukrywa sposob przechowywania danych
SQL ukrywa w jako sposob dane sa przetwarzane i zwraca tylko wynik


Indeks to specjalna struktura danych mająca na celu zwiększenie prędkości wykonywania
 operacji na tabeli, jest to pewnego rodzaju spis tresci bazy danych.

CREATE INDEX UsersAgeIndex ON Users (age);

Inteksy pozwalaja na szybsze pobieranie danych ale operacja dodawania (INSTERT) i aktualizacji
 (UPDATE) staja sie wolniejsze


Tworzenie indeksu na kilku kolumnacha
CREATE INDEX UsersIdAgeIndex ON Users (id,age);


Rodzaje zlaczen:
- wenetrzne - inner join - domyslny typ zlaczen,



----SQL - Structured Query Language----

Jest to jezyk zapytan realizujacy dostep do bazy danych
Mozemy dzieki niemu pobierac i przetwarzac dane zapisane w bazie danych
Jest to jezyk deklaratywny (co chcemy zrobic a nie jak)
Wielkosc liter w zapytaniach nie ma znaczenia i zalecena jest aby pisanie slow
 kluczowych jezyka SQL wielkimmi literami

Przykladowe zapytanie :
    SELECT * FROM genere WHERE genereid = 1;


Dzieli sie on na rozne grupy rodzajow zapytan:
- DQL (Data Query Language)
- DML (Data Manipulation Language)
- DDL (Data Definition Language)
- DCL (Data Control Language)
- TCL (Transaction Control Language)

DQL - zawiera wylacznie zapytania (query) typu SELECT czyli pobieranie danych z bazy
DML - zawiera zapytania tworzenia INSERT, modyfikownia UPDATE i ususania DELETE wierszy
       w bazie danych
DDL - zwiera zapytania tworzenia obieku/tabeli w bazie CREATE, modyfikacji tabeli ALTER,
        usuniecia obiektu/tabeli z bazy DROP, usuniecia wszystkich danych z tabeli TRUNCATE
DCL - sluzy do manipulacji prawami uzytkownikow majacych dostep do danych tnz
        nadawanie uprawnien GRANT, usuwanie uprawnien REVOKE
TCL - sluzy do oblugi tranzakcji, rozpczecie transakcji BEGIN, zatwierdzenie transakcji COMMIT,
        wywcofanie transakcji ROLLBACK, zapisanie punktu przywracania aktualnej
        transakcji SAVEPOINT


Kwerenda, inaczej zapytanie to czynność polegająca na zbieraniu lub poszukiwaniu
 informacji w bazach danych.

KWERENDA MODYFIKUJĄCA:
 Pozwala na wprowadzenie zmian w wielu rekordach. Istnieją cztery rodzaje kwerend
  modyfikujących: usuwająca, aktualizująca, dołączająca i tworząca tabele.

KWERENDA USUWAJĄCA:
 Usuwa grupę rekordów z jednej lub kilku tabel. Użycie kwerendy usuwającej powoduje
  usunięcie całych rekordów, nie zaś wybranych pól w rekordach.

KWERENDA AKTUALIZUJĄCA:
 Dokonuje globalnych zmian w grupie rekordów w tabeli lub kilku tabelach. Za pomocą
  kwerend aktualizujących można zmienić dane w istniejacych tabelach.

KWERENDA DOŁĄCZAJĄCA:
 Dodaje grupę rekordów z tabeli lub tabel na końcu innej tabeli lub tabel. Kwerendy
  dołaczające są również przydatne w następujących sytuacjach:
   -dołączanie pól wybranych na podstawie kryteriów;
   -dołączanie rekordów w sytuacjach, gdy część pól jednej tabeli nie ma swoich
     odpowiedników w drugiej tabeli.


Lista podstawowych komend

SELECT * lub x,y.. / SELECT DISTINCT * lub x,y.. (unikalne wyniki, dla kilku atrybutow unikalne
 pary x|y) / x AS nazwaKolumny, y,z
FROM nazwaRleacji
WHERE / xWARNEK AND yxWARNEK / xxWARNEK OR yxWARNEK
      /x BETWEEN y AND z /x LIKE '%e%%x' ESCAPE 'e' (escape odcjonalne dla '%')
      x LIKE '%''%' (dla ') / x IS NULL / x IS NOT NULL
      / x IN ('CA', 'TX') (x ma wartosc CA lub TX)
ORDER BY x ASC lub x ASC,y DESC... (ASC sortowanie rosnaco - standardowe dzialanie order by wiec
            nie trzeba zapisywac, DESC - malejaco, nie musze sortowac wg tego co jest wyswietlone)
LIMIT x OFFSET y (offser opcjonalne - pomija y pierwszych wynikow)
UNION / UNION ALL (polaczenie wynikow zapytan z tabel, UNION tylko unikalne)



----OBSLUGA SQLite----

Nalezy pobrac klienta sqlite-tools

Mozna pobrac przykladowy plik bazy danych
    https://github.com/SamouczekProgramisty/chinook-database/blob/master/
    ChinookDatabase/DataSources/Chinook_Sqlite.sqlite?raw=true
i ma ono rozszerzenie .sqlite

aby otworzyc baze danych uruchamiam sqlite.exe i uzywam komendy
    .open Chinook_Sqlite.sqlite


KOMENDY:
.tables - wyswietlenie listy tabel

.schema NAZWATABELI - schemat tabeli (nazwa, typ i wlasciwosci atrybutow)

.headers on - wlacza wyswietlanie nazwy atrybutu
GenreId|Name
1|Rock
2|Jazz




----TYPY W SQL----

DATE - data
DATETIME - data i czas

INTEGER - liczby calkowite
NUMERIC(x, y) - liczba rzeczywista z iloscia x cyfr przed przecinkiem i y po

NVARCHAR(x) - lancuch znakow o maksymalnej dlugosci x
TEXT - lancuch bez okreslenej dlugosci

BOOLEAN - wartosc logiczne

BLOB - dane binarne (binary large object)

Wartosc NULL nie jest rowna pustej wartosci lancucha znakowego!


----Laczenie tabel, pobieranie z wielu zrodel - Indesk----

Zeby pobrac dane z wielu tabel nalezy okreslic spsob ich polaczenia oraz warunki


INNER JOIN - laczenie wewnetrzne




----SELECT - SQL----

SELECT - wybiera kolumny (atrybuty) z tableli jakie beda mialy wyswietlone krotki
FROM - wybiera tabele po nazwie
WHERE - filtruje wiersze (krotki) jakie maja byc pobrane

Instrukcje wykonane pomiedzy AND wykonaja sie wczesniej niz instrukcje pomiedzy OR
Instrukcje NOT maja wiekszy priorytet niz AND i OR

przyklady:
SELECT *
FROM genere
WHERE name = 'Rock' AND genreid < 20
OR name != 'Pop; AND IS NOT NULL

-Pokaz wszystkie atrybuty krotek (SELECT *) z tabeli genere (FROM genere) ktorych
 pole name = 'Rock' i pole genereid < 20 (WHERE name = 'Rock' AND genreid < 20)
 LUB pole name jest rozne od 'Pop' i nie ma wartosci null
 (OR name != 'Pop; AND IS NOT NULL)

SELECT billingcountry
 FROM invoice
 WHERE total < 10
      AND invoicedate > '2013-12-05 00:00:00'
      AND invoicedate < '2013-12-09 00:00:00';

SELECT billingstate
 FROM invoice
 WHERE billingcountry = 'USA'
      AND total > 15;

SELECT billingcity, billingcountry
 FROM invoice
 WHERE (billingstate IS NULL AND total > 17)
       OR (total < 1
           AND billingstate IS NOT NULL
           AND invoicedate > '2013-09-20 00:00:00');


Jesli mam wlaczone wyswietlanie nazw kolumn (.headers on)
Jesli dodam po nazwie atrybutu SELECT komende AS x to zostanie
 wyswietlony tytul kolumny wybranego pola jako x

SELECT genreid AS id
      ,name AS 'genre name'
  FROM genre
  LIMIT 5;



----WHERE - SQL----

Uzywam w:
-SELECT
-UPDATE - ogranicza wiersze ktore maja byc zaaktualizowane
-INSERT - uzywane z podzapytaniami
-DELETE - ogranicza wiersze ktore maja byc uzuniete


Operatory:
<, <=, =, !=, >, >=


SELECT invoiceid
      ,total
      ,billingcountry
  FROM invoice
 WHERE total = 21.86;

Pokaz krotki z atrybutami invoiceid ,total i billingcountry z tabeli invoice ktorych wartosc
 atrybutu total = 21.86


----Porownywanie:----

SELECT *
  FROM invoice
 WHERE billingcountry > 'A'
   AND billingcountry < 'C';

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu billingcountry
 zaczyna sie na litere 'A' lub 'B'


----Porownywanie + daty:----

SELECT *
  FROM invoice
 WHERE billingcountry = 'Poland'
   AND invoicedate > '2012-05-26';

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu
 billingcountry = 'Poland' oraz pole invoicedate ma date pozniejsza niz 2012-05-26


Moge tez skrocic date z - gdzie - uzupelnia minimalna wartoscia np:
1960- = 1960-01-01

SELECT firstname
  FROM employee
 WHERE birthdate BETWEEN '1960-' AND '1970-';

Pokaz krotki z atrubutem imie z tabeli employee ktorych wartosc atrybuty
 birthdate jest po 1960 i przed 1970-



Pomiedzy BETWEEN / NOT BETWEEN:

SELECT *
  FROM invoice
 WHERE total BETWEEN 10.91 AND 11.96;

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu
 total jest pomiedzy 10.91 a 11.96 (rownoznaczne z total >= 10.91 AND total <= 11.96)
Moge takze uzyc NOT BETWEEN


----LIKE x / NOT x LIKE y----

% - oznacza dowolną liczbę znaków
_ - oznacza jeden znak

SELECT *
  FROM invoice
 WHERE billingcountry
  LIKE '%land';

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu
 billingcountry konczy sie na 'land'

SELECT *
  FROM invoice
 WHERE billingcountry
  LIKE '%land%';

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu
 billingcountry ma w srodku wartosci wartosc 'land'


Aby uzyc w LIKE znaku _ lub % musze dodac litere przed tym znakiem a nastepnie
 dodac ESCAPE 'litera'

SELECT *
  FROM track
 WHERE name LIKE '%e%%' ESCAPE 'e';

Pokaz krotki z wszystkimi atrybutami z tabeli track ktorych wartosc atrybutu
 name zawiera w srodku swowjej wartosci %


Znaki specjalne
'
Aby przefiltrowac wiersze w ktorych wybrany argument bedzie mial w
 srodku ' musze dodac LIKE '%''%';

SELECT *
 FROM album
 WHERE title LIKE '%''%';


Warunki z LIKE moge laczyc np:

LIKE '%x%%e' ESCAPE 'x';

Pokaz wszystko co ma w srodku wartosci % i na koncu e


----IS NULL / IS NOT NULL----

Wartosc pola NULL nie jest rowna polu tekstowemu bez znakow ''
IS NULL =/= ''

SELECT *
  FROM invoice
 WHERE billingstate IS NULL;

Pokaz krotki z wszystkimi atrybutami z tabeli invoice ktorych wartosc atrybutu
 billingstate wynosci NULL


----IN (lista wartosci jakie moze przyjac atrybut)----

Wartosci umieszam w () z '' oddzielonych ,

SELECT *
  FROM invoice
 WHERE billingcountry = 'USA'
   AND billingstate IN ('CA', 'TX');



ZADANIA:

zwróci wszystkie wiersze z tabeli track, dla których: unitprice jest mniejsze niż 1
 i znak % zawarty jest w kolumnie name oraz kolumna name kończy się na e

SELECT *
  FROM track
  WHERE unitprice < 1 AND name LIKE '%x%%e' ESCAPE 'x';


zwróci wszystkie wiersze z tabeli invoice, które mają uzupełnioną kolumnę billingstate
 i nie są ze Stanów Zjednoczonych

 SELECT *
  FROM invoice
  WHERE billingstate IS NOT NULL AND billingcountry != 'USA';


zwróci wszystkie wiersze z tabeli invoice, które dotyczą Polski, Czech albo Węgier dla
 których wartość faktury przekracza 10,

 SELECT *
  FROM invoice
  WHERE billingcountry IN ('Poland', 'Czech Republic', 'Hungary') AND total > 10;


zwróci imiona pracowników z tabeli employee, które dotyczą pracowników urodzonych w latach 60.

SELECT firstname
  FROM employee
  WHERE birthdate BETWEEN '1960-' AND '1970-';



----LIMIT----

SELECT *
  FROM genre
  LIMIT 5;


Dodtkowo moge dac OFFSET ktory pominie okreslona liczbe wynikow od poczatku liczac

SELECT *
  FROM genre
 LIMIT 5 OFFSET 10;


----DISTINCT----

DISTINCT x,y,z po SELECT pozwala pokazac atrybuty krotek bez duplikatow

SELECT DISTINCT billingcountry
  FROM invoice;

To standardowo pokazaloby powielone kraje
Jesli dam kilka atrubutow to unikalnosc bedzie wyswietlona jako para oddzielona |

SELECT DISTINCT billingcountry
      ,billingcity
  FROM invoice;

USA|Boston
Germany|Frankfurt
Germany|Berlin


----SORTOWANIE----

Do sortowania uzywam komendy ORDER BY oraz okreslam czy ma byc rosnaca
 czy malejaca

ASC po nazwie pola okresla rosnaco

SELECT name
    FROM genre
    ORDER BY name ASC;

Lecz moze zostac ono pomieniete

  SELECT name
    FROM genre
    ORDER BY name;


Moge odwrocic sortowanie dodajac po nawie pola DESC

SELECT name
    FROM genre
    ORDER BY name DESC;


Moge dodac kilka pol w ORDER BY i po kazdym okrelam sortowanie
 (konieczne tylko jesli malejace), pola wymieniam po przecinku

SELECT DISTINCT billingcountry
        ,billingstate
    FROM invoice
    ORDER BY billingcountry DESC
        ,billingstate;

Pobierze krotki z wyswietlonymi atrybutami x,y (wyswielone jako unikalne pary x|y)
 z tabeli invoice gdzie x jest sortowane malejaco a y roznaco


Moge posortowac wg atrybutu ktory nie zostanie wyswietlony

SELECT DISTINCT billingcountry
    FROM invoice
    ORDER BY billingcity;



----UNION / UNION ALL----

Uzywane jest do scalania wynikow zapytan i musza byc uzyte dla pol
 z TYM SAMYM TYPEM

SELECT name AS xxx
     FROM genre
     UNION ALL
SELECT DISTINCT billingcity
     FROM invoice
     LIMIT 10;

xxx
Alternative
Alternative & Punk
Amsterdam
Berlin

Zapytanie wyswietli wyniki jeden SELECT pod drugim BEZ SORTOWANIA


SELECT name AS xxx
     FROM genre
     UNION ALL
SELECT DISTINCT billingcity
     FROM invoice
     ORDER BY xxx
     LIMIT 10;

To zapytanie zwraca w jednej kolumnie xxx oba zapytania oraz jest
 posortowane wedlug wszystkich pozycji za pomoca okreslenia
 nazwy tabeli


----ZADANIA:----

zwróci dziesięć najdłuższych ścieżek (tabela track), weź pod
 uwagę tylko te, których kompozytor (kolumna composer) zawiera literę b,

SELECT name
FROM track
WHERE composer LIKE '%b%'
ORDER BY milliseconds DESC
LIMIT 10


zwróci pięć najtańszych ścieżek (tabela track) dłuższych niż minuta,

SELECT name
FROM track
WHERE milliseconds > 60000
ORDER BY price
LIMIT 5


zwróci unikalną listę dwudziestu kompozytorów (artist) których ścieżki kosztują
 mniej niż 2$ posortowanych malejąco według identyfikatora gatunku
 (kolumna genreid) i rosnąco według rozmiaru (kolumna bytes),


SELECT DISTINCT composer
FROM artist
WHERE price < 2
ORDER BY genreid DESC, bytes
LIMIT 20;


zwróci dwie kolumny. Pierwsza z nich powinna zawierać ścieżki droższe niż 1$
 i poprawnych kompozytorów pod nazwą magic thingy. Druga powinna zawierać
 liczbę bajtów. Wynik powinien zawierać dziesięć wierszy i być posortowany
 rosnąco po liczbie bajtów

SELECT name AS 'magic thingy'
        ,bytes
    FROM track
   WHERE unitprice > 1
   UNION
  SELECT composer
        ,bytes
    FROM track
   WHERE composer IS NOT NULL
ORDER BY bytes ASC
   LIMIT 10;


zwróci piątą stronę z fakturami (tabela invoice) zakładając, że na stronie
 znajduje się dziesięć faktur i sortowane są według identyfikatora (kolumna invoiceid).

SELECT *
FROM invoice
ORDER BY invoiceid
LIMIT 10 OFFSET 40;


----FUNKCJE----

Funkcje agregujace dzialaja na grupie wartosci a nie na pojedynczym polu

ABS(x) - wartosc bezwzgledna z x
LENGTH(x) - dlugosc lancucha znakow
LOWER(x) - zwraca przyjety lancuch z wszystkimi malymi literami
UPPER(x) - analogicznie na duze litery
RANDOM - zwraca losowa liczbe calkowita
SUBSTR(x, y, z) - pobiera ciag znakow x i wyswietla od y znaku do z (z opcjonalne)
TRIM(x) - usuwa spacje z obu stron x





SELECT LENGTH('abcd') //4


SELECET LENGTH (billingstate)
FROM invoice
LIMIT 5

NULL //pokaze jako puste
NULL
2 //dlugosc wiersza 3
2
2


Z unikalnymi wartosciami (null bedzie wliczany)

SELECT DISTINCT LENGTH (billingstate)
FROM invoice

.
2
6
3


Z sortowaniem:

SELECT DISTINCT LENGTH (billingstate)
FROM invoice
ORDER BY LENGTH (billing state)

czytelniej z sortowaniem z uzyciem nazwy aliasu

SELECT DISTINCT LENGTH (billingstate) AS len
FROM invoice
ORDER BY len


RANDOM uzywam w order by

SELECT *
 FROM genre
 ORDER BY RANDOM()
 LIMIT 5;


Laczenie funkcji

SELECT MAX(LENGTH(billingstate)) //max z wszystkich parametrow wybiera najwiekszy
FROM invoice

6



----Grupowanie----

SELECT billingcountry
        ,MAX(total)
 FROM invoice
 GROUP BY billingcountry
 LIMIT 2;

Argentina 13.86
Australia 13.86

Bez grupowania pokazaloby by tylko 1 wiersz z maksymalna wartoscia dla kraju ktory
 go ma -> Czech Republic 25.86
UWAGA w przypadku wyswietlenia kilku kolumna (SELECT x,y) w innych bazach danych
 powinno byc grupowanie (GROUP BY)


Moge grupowac wiele kolumn:
SELECT billingcountry
        ,billingstate
        ,MAX(total)
 FROM invoice
 GROUP BY billingcountry
        ,billingstate
 LIMIT 5;

Argentina                     13.86
Australia       NSW           13.86
Austria                       18.86
Belgium                       13.86
Brazil          DF            13.86


----FUNKCJE GRUPUJACE----

AVG(elementy) - zwraca srednia wartosc z elementow
MIN(elementy) - zwraca minimalna wartosc z elementow
SUM(elementy) - zwraca sume elementow, jesli wszystkie elementy to NULL to zwroci NULL
TOTAL(elementy) - jak SUM lecz TOTAL jesli wszystko bedzie NULL zwroci 0
COUNT(elementy) - zwraca liczbe elementow ktore nie maja wartosc null

SELECT COUNT(customerid)
  FROM invoice;

412 - liczba wierszy customerid bez NULL


SELECT COUNT(*)
  FROM invoice;

412 - liczba wszystkich wierszy tabeli


SELECT COUNT(DISTINCT customerid)
  FROM invoice;

59 - liczba wierszy customerid bez null - lista wartosci (powtorzenia pominiete)


----FUNKCJA HAVING----

SELECT billingcountry
        ,SUM(total)
 FROM invoice
 GROUP BY billingcountry;

sumaryczny przychód dla poszczególnych krajów (jest kilka wpisow z tego samego
 kraju i sumuje ich wartosci wyswietlajac w jednej kolumnie uniklany kraj i w
 drugiej sume jego wartosci z total)


SELECT billingcountry
        ,SUM(total) AS summed_total
 FROM invoice
 GROUP BY billingcountry
 HAVING summed_total > 100;

sumaryczny przychód dla krajow lecz pokaz tylko tych co maja wiecej niz 100


Klauzula WHERE filtruje pojedynczy wiersz a HAVING filtruje grupowane wartosci!


Pokaz dwie kolumny w ktorej pierwsza zawiera kraje - billingcountry
 (bez miasta - billingcity Ottawa) a druga sume wartosci dla kazdego z nich
 i tylko tych ktorych suma > 100;

SELECT billingcountry
        ,SUM(total) AS summed_total
 FROM invoice
 WHERE billingcity != 'Ottawa'
 GROUP BY billingcountry
 HAVING summed_total > 100;


ZADANIA:

średnią, minimalną i maksymalną wartość kolumny total w tabeli invoice

SELECT ABG(total),MIN(total),MAX(total)
FROM invoice;


liczbę wierszy w tabeli invoice w których długość kolumny billingcountry jest
 większa niż 5

SELECT COUNT(*)
FROM invoice
WHERE LENGTH(billingcountry) > 5


liczbę unikalnych dat (kolumna invoicedate), w których wystawiono faktury
 (tabela invoice)

SELECT COUNT(DISTINCT invoicedate)
FROM invoice


daty (kolumna invoicedate), w których wystawiono co najmniej dwie faktury
 (tabela invoice)

SELECT invoicedate
FROM invoice
GROUP BY invoicedate
HAVING count(*) >= 2;


pięć losowych wierszy z tabeli genre

SELECT RANDOM (*) //ZLE
FROM genere
LIMIT 5;

SELECT *
 FROM genre
 ORDER BY RANDOM()
 LIMIT 5;


miesięczną (kolumna invoicedate) sumę faktur (kolumna total w tabeli invoice)
 od kupujących z identyfikatorem (kolumna customerid) mniejszym niż 30, wynik
 powinien być posortowany po miesięcznej sumie faktur i zawierać jedynie te
 miesiące dla których suma jest większa od 40

SELECT SUBSTR(invoicedate, 0, 8) AS date
       , SUM(total) AS sum
FROM invoice
WHERE customerid < 30
GROUP BY date
HAVING sum > 40
ORDER BY sum;


----INSERT----

INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);

Nie musze podawac wszystkich kolumn


----UPDATE----

Zastapienie/zmiana wartosci

UPDATE Customers
SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
WHERE CustomerID = 1;

Moge podac bez Where to wszedzie wstawi wartosc


----DELETE----

DELETE FROM Customers
WHERE CustomerName='Alfreds Futterkiste';

Wpisanie samego DELETE FROM Tabela spowoduje usuniecie wszystkich wierszy
 z tabeli

/*--------------------------------------------------------------------
----------------------Wyamagania COMARCH------------------------------

Zlozonosc obiczeniowa +
Wielowatkowosc +
String / konkatenacja +
Optional +
Stream +
Lambda +

AtomicInteger: +

junit +
mockito -


Wzorce projektowe:
builder
dekorator
Singleton
dao
prototyp
adapter
fabryka abstrakcyjna
metoda szablonowa
pyłek


SOLID +

ACID +

SQL Injection+

Indeks

Joiny pomiedzy tabelami

procedura


----
struts2
ejb
jpa
spring security
oauth2
jsp
Angular/js/jquerry


 */



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