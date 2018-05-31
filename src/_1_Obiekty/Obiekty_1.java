package _1_Obiekty;

public class Obiekty_1 {

    public static void main(String[] args) {
        //----KLASY METODY I OBIEKTY-----
        /*
        metody i pola static sa zwiazane z klasa a nie jej obiektem
        Obiekt jest naturalna reprezentacja klasy, przechowuje informacje
         o zmiennych oraz mozemy sie do nich odwolac, mozemy za pomoca
         obiektow wywolac metody jej klasy

        */
        System.out.println("-1-");
        Punkt punkt1 = new Punkt();
        punkt1.wspX = 10;
        punkt1.wspY = 20;
        System.out.println("Wspolrzedne punktu to: "+punkt1.wspX+" "+punkt1.wspY);

        System.out.println("\n"+"-2-"); //wlasciwy sposob dostepu do pol (zapis odczyt)
        Punkt punkt2 = new Punkt();
        punkt2.ustawX(10);
        punkt2.ustawY(20);
        System.out.println("Wspolrzedne punktu to: "+punkt2.dajX()+" "+punkt2.wspY);

        System.out.println("\n"+"-3-");
        int[][] punkty = new int[3][2];
        punkty[0][0] = 1;
        punkty[0][1] = 5;
        punkty[1][0] = 2;
        punkty[1][1] = 6;
        punkty[2][0] = 3;
        punkty[2][1] = 7;
        Punkt[] punktyKlasy = new Punkt[3];

        for(int i = 0; i < punkty.length; i++){
            punktyKlasy[i]=new Punkt();
            punktyKlasy[i].ustawX(punkty[i][0]);
            punktyKlasy[i].ustawY(punkty[i][1]);
        }
        int i = 0;
        for(Punkt x : punktyKlasy){
            System.out.println("Punkt "+i+" x: "+x.dajX()+" y: "+x.dajY());
            i++;
        }

        //--------------------METODY-------------------------------

        System.out.println("\n"+"METODY");

        //Przeciazanie metod - mozemy nazwyac metody tak samo jesli przyjmuja
        // inne typy zmiennych (to co zwracaja NIE MA ZNACZENIA!)

        System.out.println("-1-");
        Punkt punkt3 = new Punkt();
        punkt3.ustawX(15);
        punkt3.ustawY(3);
        System.out.println("Klasa.odejmujLiczby(x,y) : "+Punkt.odejmujLiczby(10,7));
        //przekazuje tutaj zmienne poprzez WARTOSC !
        //zmienne proste utworzone w metodzie znikaja po jej zakonczeniu
        //wywoluje metode za pomoca klasy poniwaz jest STATYCZNA

        System.out.println("\n"+"-2-");
        System.out.println("KLASA.sumujXY(obiekt.akcesorX(), obiekt.ackesorY())) : "+
                Punkt.odejmujLiczby(punkt3.dajX(),punkt3.dajY()));
        //tutaj wykorzystje pobranie wartosci z akcesorow i wysalnie ich do metody


        System.out.println("\n"+"-3-");
        System.out.println("obiekt.sumujXY(oiekt)) : "+punkt3.sumujXY(punkt3));
        /*
        teraz korzystam z metody przyjmujacej obiekt na ktorym wewnatrz
         metody korzysta z akcesorow
        Motoda bez sensu poniewaz moge uzyc slowka this. i odniesc sie
         do pol obiektu na ktorym wywolywana jest metoda !


        WYSYLAM REFERENCJE ! - jest to KOPIA adresu obieku, jesli zmienie wartosci
         pol obiektu w metodzie ktora na nim operuje - zmiany pozostana
        Referencja przyjeta przez metode moze zostac zmieniona przez co nie bedzie
         wskazywala juz na ten sam obiekt ktory wyslalismy lecz mozemy to zablokowac
         przyjmujac zmienna obiektu final! int sumujXY(final Punkt pkt)
        */

        //test referencji
        System.out.println("\n"+"-4-");
        Punkt punkt4 = new Punkt();
        punkt4.ustawX(77);
        Punkt.zwiekszX(punkt4); //metoda statyczna
        System.out.println(punkt4.dajX());

        System.out.println("\n"+"-5-");
        System.out.println("obiekt.sumujXY() : "+punkt3.sumujXY());//wykorzystam zmienne w obiekcie
        //metoda nie przyjmuje wartosci tylko zwraca sume pol obiektu
        // majac do nich dostep dzieki wywolaniu jej na konktetnym obiekcie
        // z ustalonymi polami, wykorzystje this.
        //metoda moze nazywac sie tak sama jak inna jesli przyjmuje inna ilosc paramtrow
        // lub inny ich rodzaj


        //-------------------Konstruktory------------------------

        System.out.println("\n"+"Konstruktory");
        /*
        Konstruktor nie okresla zwracanego typu, nazwa identyczna jak nazwa klasy
        Sluzy glownie do nadanie wartosci pol podczas tworzenia obiektu
         moga one wykonywac operacje jak i wywolywac metody

        W pierwszej kolejnosci wywolywany jest konstruktor bezparamtrowy klasy
         nadrzednej ! tzn w kazdym konstrukotrze (niewazne z jaka iloscia param.)
         na poczatku jest niejawna instukcja super(); Jesli kasa nie dziedziczy
         wywolany jest konstruktor klasy Object. Gdy dodamy wlasne odwolanie konstruktora
         z intreukcji super() (niewazne z jaka iloscia param.) ten niejawny przestaje istniec

        Dobra praktyka jest tworznie konstrukotra bezparamtrowego z nadanymi wartosciami
         aby w przypadku proby dostania sie do nich nie otrzymac wyjatku
         NullPointerException !

        Moge tworzyc tablice obiektow:
        Punkt2[] pkt = new Punkt2[2];
        Punkt2[0] = new Punkt2(10,20);
        Punkt2[1] = new Punkt2(22,33);
        */

        Punkt2 pkt1 = new Punkt2(11,22); //slowo new wywoluje konstuktor
        /*
        Strworzylem konstruktor przyjmajacy 2 parametry i ustawiacy wartosc
         pol obiektu.
        w przypadku obiektu bez paramtrow Punkt2 pkt1 = new Punkt2(); musze
         stworzyc takze konstruktor bezparametrowy poniewaz ten z parametrami
         automatycznie usuwa ten standardowy (niewidoczny) tworzeony automatycznie
         przez klase
        */

        Punkt2 pkt2 = new Punkt2(pkt1);//wykorszytuje konstruktor kopiujacy ktory
        // przyjmuje inny obiekt i korzysta z jego pol do przypisania pol nowemu
        // obiektowi Punkt2(Punkt2 pkt){this.x = pkt.x; this.y = pkt.y;}
        System.out.println("-1-");
        System.out.println(pkt2.x + " " + pkt2.y);


        //-------------------Dziedziczenie------------------------

        System.out.println("\n"+"Dziedziczenie");

        //Klasa moze rozszerzac TYLKO 1 klasa
        //Kazdy konstrukor posiada niejawna instrukcje super() ktora wywoluje
        // konstrukotr bezparametrowy klasy nadrzednej, chyba ze dodamy
        // wlasna jej deklaracje. ilosc i rodzaj rzeczy jakie wyslemy
        // z pomoca instrukcji super(obiekt, liczba) decyduje jaki konstuktor
        // klasy nadrzednej zostanie wywolany

        System.out.println("-1-");
        Pracownik prac = new Pracownik("Wlodek", "Zięba", 3000);
        System.out.println("Imię: "+prac.imie);
        System.out.println("Nazwisko: "+prac.nazwisko);
        System.out.println("Wypłata: "+prac.wyplata+"\n");

        Szef szef = new Szef();//dzieki dziedziczneiu mam dostep do pol
        // i metod klasy nadrzednej.

        System.out.println("Imię: "+szef.imie);
        System.out.println("Nazwisko: "+szef.nazwisko);
        System.out.println("Wypłata: "+szef.wyplata);
        System.out.println("Premia: "+szef.premia+"\n");

        Szef szef2 = new Szef("Tadek","Kowalski",10000,2000);

        System.out.println("Imię: "+szef2.imie);
        System.out.println("Nazwisko: "+szef2.nazwisko);
        System.out.println("Wypłata: "+szef2.wyplata);
        System.out.println("Premia: "+szef2.premia);

        //-------------------Interfejsy------------------------

        /*
        Interfejsy jest to wymog jaki narzycamy na klase ktora go implementuje
        jest to inaczej kontrakt ktora mowi co dana klasa ma robic ale nie wie jak
         (nie okreslamy w metodach ciala tylko to co zwracaja i co przyjmuja)
        Klasy implementujace interfejs moga takze posiadac wlasne pola i metody
        "Dodawanie własnych metod nie jest jednak dobrym podejściem, ponieważ
         tracimy w ten sposób nieco możliwości jakie niesie ze sobą polimorfizm
         - aby móc korzystać z metod, których nie ma w interfejsie zarówno typ
         referencji jak i typ obiektu muszą być zgodne - użycie interfejsu wydaje
         się wtedy zbędne"
        Klasa moze implementowac kilka interfejsow
        Wszystkie metody interfejsu są domyślnie publiczne i abstrakcyjne                                               !
        Wszystkie pola interfejsu muszą być zadeklarowane jako publiczne,
         statyczne i finalne
        Interfejs moze rozszerzac tylko interfejsy
        Metody interfejsu NIE moga byc zadeklarowane jako statyczne
        */

        //Moge wykorzystac polmorfizm do tworzenia obiektow:
        Pojazd samochod = new Samochod();
        Pojazd rower = new Rower();
        ((Samochod) samochod).drift(); //przez polimorfizm aby odwolac sie do
        // "unikalnej" metody klasy (takiej ktorej nie ma w intefejsie) musze
        // wykorzystac rzutowanie - trace na polimorfizmie
        Samochod samochod1 = new Samochod();
        samochod1.drift(); //bez polimorfizmu nie musze rzutowac


        //-------Dziedziczenie  2 + instrukcja super()-------------------
        /*
        Instrukcji super() uzywam do wywolanie konstruktora klasy nadrzednej.
        Ilosc parametrow jakie w nim umieszcze decyduje ktory to konstuktor
         np. super("","",0); wywola mi 3-param. konstruktor klasy nadrzednej
        Instrukcja super() musi byc ZAWSZE na poczatku w konstruktorze
        Zawsze dodawana jest automatycznie instukcja niejawna super(); w kazdym
         konstruktorze chyba ze zadeklaruje wlasna

        Wywolanie metody z klasy nadrzednej uzywamy z "." np. super.metoda();
         i nie musi byc ona juz na poczatku deklracji metody
         */
        System.out.println("\n"+"Dziedziczenie 2");
        System.out.println("-1-");
        Pracownik2 pielegniarka = new Pielegniarka();
        pielegniarka.pokazCos();


    }
}

//----KLASY METODY I OBIEKTY-----
class Punkt{
    int wspX;
    int wspY;
    void ustawX(int x){
        this.wspX = x;
    }
    void ustawY(int y){
        this.wspY = y;
    }
    int dajX(){
        return wspX;
    }
    int dajY(){
        return wspY;
    }

    static int odejmujLiczby(int x, int y){ //metoda statyczne - moge ja wywolac
        // z uzyciem nazwy klasy Punkt.odejmujLiczby(liczba1, liczba2);
        return x-y;
    }

    int sumujXY(){
        return this.wspX + this.wspY; //korzystam ze zmiennych obiektu
        //na ktorym zostaje wywolana metoda
    }
    int sumujXY(Punkt pkt){ //z wykorzystaniem obiektu
        return pkt.dajX()+pkt.dajY();
        //uzywam akcesrow na obiekcie na ktorym zostala wywolana metoda
    }

    static void zwiekszX(Punkt pkt){
        pkt.ustawX(pkt.dajX()+1);
    }
}
//-------------------Konstruktory------------------------
class Punkt2{
    int x;
    int y;
    Punkt2(){
        this.x = 0;
        this.y = 0;
    } //konstruktor domyslny bezparamtrowy
    //jest on generowany automatycznie i usuwany jesli dodamy wlasny
    // z parametrami

    Punkt2(int x, int y){
        this.x = x;
        this.y = y;
    }

    Punkt2(Punkt2 pkt){//konstruktor kopiujacy
        this.x = pkt.x;
        this.y = pkt.y;
    }
}
//-------------------Dziedziczenie------------------------
class Pracownik{
    String imie,nazwisko;
    int wyplata;
    public Pracownik(){
        this.imie="";
        this.nazwisko="";
        this.wyplata=0;
    }
    public Pracownik(String i, String n, int w){
        this.imie=i;
        this.nazwisko=n;
        this.wyplata=w;
    }
}
class Szef extends Pracownik{
    int premia;
    public Szef(){
        this.imie="";
        /*
        moge tak zadeklarwoa tylko dlatego ze  zmienne sa publiczne (a nie powinny)
        w takim przypadku gdy zmienne klasy nadrzednej sa prywatne nalezy uzyc
         konstruktora klasy nadrzednej i wyslac do niego zmienne przy uzyciu instrukcji
         super() z parametrami ktora MUSI byc na poczatku deklaracji w konstruktorze
         np: super("","",0,0) lub po prostu super(); poniewaz wywolalbym tak konstuktor
         bezparametrowy klasy nadrzednej ktory juz ustawia pola na wartosci domyslne.
        Standardowo jest wykonywana niejawna instukcja super() czyli wywolanie konstruktora
          bezparamtrowego klasy nadrzednej
         Najbardziej optymalna opcja jest deklaracja tylko premii na wartosc 0 poniewaz
          niejawnie wywoluje sie konstruktor klasy nadrzednej super() ktor ustawia wartosci
          na domyslne
        */
        this.nazwisko="";
        this.wyplata=0;
        this.premia = 0;
    }
    public Szef(String i, String n, int w, int p){
        this.imie=i;
        this.nazwisko=n;
        this.wyplata=w;
        this.premia = p;
    }
}
//-------------------Interfejsy-----------------------
interface Pojazd{
    public void jazda(int predkosc);
    public void stop();
}
class Samochod implements Pojazd{
    @Override
    public void jazda(int predkosc) {

    }
    @Override
    public void stop() {

    }
    public void drift(){}
}
class Rower implements Pojazd{
    @Override
    public void jazda(int predkosc) {

    }
    @Override
    public void stop() {

    }
    public void skok(){}
}
//-------Dziedziczenie  2 + instrukcja super()-------------------
class Pracownik2 {
    private String imie;
    private String nazwisko;
    private double wyplata;

    public Pracownik2(){
        this.imie = "";
        this.nazwisko = "";
        this.wyplata = 0;
    }

    public Pracownik2(String imie, String nazwisko, double wyplata){
        //konstruktor dla wartosci domyslnych
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wyplata = wyplata;
    }

    String getImie(){ return imie; }
    String getNazwisko(){ return nazwisko; }
    double getWyplata(){ return wyplata; }

    public void pokazCos(){
        System.out.println("Pracownik");
    }
}
class Pielegniarka extends Pracownik2{
    private int nadgodziny;

    public Pielegniarka(){ //kontrukror dla wartosci domyslnych
        //nijawenie wywowla sie instukcja super()
        //czyli konstuktor bezparam. klasy nadrzednej i usatwi
        // pozostale pola instancji na wartosci domyslne
        //przez co nie musze pisac super("","",0) co wywolaloby
        // mi konstuktor 3-param. ustawiajacy wartosci na domyslne
        // i powtrzalbym wlasny kod (brak metody DRY)
        this.nadgodziny = 0;
    }

    public Pielegniarka(String imie, String nazwisko, double wyplata, int nadgodziny) {
        //konstruktor ustawiacy
        super(imie, nazwisko, wyplata);//wywoluje konstruktor 3-param klasy nadrzednej
        this.nadgodziny = nadgodziny;
    }

    public int getNadgodziny(){ return nadgodziny; }
    public void setNadgodziny(int n){
        nadgodziny += n;
    }

    @Override
    public void pokazCos() {
        super.pokazCos(); //wywolanie metody super z metoda, nie musi byc na poczatku
        System.out.println("Pielegniarka");
        super.pokazCos();
    }
}
class Lekarz extends Pracownik2{
    private double premia;

    public Lekarz(){
        this.premia=0;
    }

    public Lekarz(String imie, String nazwisko, double wyplata, double premia) {
        super(imie, nazwisko, wyplata);
        this.premia = premia;
    }

    public double getPremia(){ return premia; }
    public void setPremia(double d){
        premia = d;
    }
}