import PrzydatneKlasy.ArraysMoja;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class toRemember {
    public static void main(String[] args) {

        // STRING
        String liczbaSlownie = Integer.toString(10);
        String liczbaSlownie2 = String.valueOf(12);

        String str = "132";
        str = str+"123";
        /*kazda modyfikacja stringa to tworznie nowgo obiektu
        String x = "Kasia"
        s = x+" i Tomek"; // to tak naprawde:
        s = new StringBuilder(x).append(" i Tomek").toString();
        */

        str.trim(); //usuniecie bialych znakow na poczaku i koncu
        str.toUpperCase().toLowerCase();
        boolean b1 = str.isEmpty();
        int i1 = str.length();
        char[] t1 = str.toCharArray();
        char ch1 = str.charAt(0);

        str.substring(1,2);//wiciaga przedzial stringa od poz 1 do 2
        String[] t2 = str.split("1");//podzieli tam gdzie wystapi "1"
        str.replace("1","2");
        boolean b2 = str.matches("test");
        int i2 = str.indexOf("1"); i2 = str.lastIndexOf("1");

        boolean b3 = str.equals(str);
        str.concat("123").concat(str);
        boolean b4 = str.startsWith("123");
        boolean b5 = str.endsWith("123");
        boolean b6 = str.contains("123");

        byte[] t3 = str.getBytes();
        int i3 = str.compareTo(str);

        //Moge przeniesc zawartosc listy do Stringa za pomoca metody join
        List<String>auta = Arrays.asList("audi","mercedes");
        //wykorzystuje metode asListy klasy Arrays
        String autaString = "";//musze zainicjowac wartoscia do metody join
        autaString = autaString.join(",",auta);
        //przypisuje do Stringa z metoda join()
        System.out.println("String zrobiony z listy: "+autaString);

        //Bardziej zaawansownym uzyciem metody join jest uzycie strumienia
        // oraz metody collect() w ktorej uzyje klasy Collectors z metoda
        // joining() w ktorej okresle co ma oddzielac napisy oraz jak ciag
        // ma sie zaczynac i konczyc
        String autaString2 = auta.stream().collect(Collectors
                .joining(", ","{","}"));
        System.out.println("String zrobiony ze strumienia: "+autaString2);


        // STRING_BUILDER
        StringBuilder sb = new StringBuilder(12);
        sb.ensureCapacity(13);//z zakresem 16/34/dokladnym
        sb.append("123").append("123");
        sb.replace(0,1,"123");
        sb.insert(0, "123");
        sb.reverse();
        sb.delete(0,1);
        int i4 = sb.indexOf("x");
        int i5 = sb.capacity();
        int i6 = sb.length();
        char c = sb.charAt(0);
        String str2 = sb.substring(1,2);
        String strS = sb.toString();


        // STRING_JOINER
        /*
        rozwiazuje problem wyrazen lambda oraz upraszcza laczenie Stringow
         */
        System.out.println("StringJoiner");
        StringJoiner joiner = new StringJoiner("");
        //musze okreslic w konstruktorze 1 lub 3 parametry, gdy podam jeden
        // bedzie to separator oddzielajacy stringi, gdy podam 3 bedzie to
        // separator, prefix(to co na poczatku ciagu) i suffix(na koncu)
        StringJoiner joiner2 = new StringJoiner(",","{","}");
        joiner2.add("napis").add("napis2");
        System.out.println("StringJoiner: "+joiner2);
        String napisSJ = joiner2.toString();
        System.out.println("StringJoiner na String: "+napisSJ);


        // MATH
        Math.abs(9);
        Math.pow(2,2);
        Math.sqrt(4);
        Math.round(9.26134); //zaokrlaglenie
        Math.min(10,12);
        Math.max(10,12);


        // WIELKIE LICZBY
        BigInteger bi = new BigInteger("1234");
        BigInteger bi2 = BigInteger.valueOf(1234);
        BigDecimal bd = new BigDecimal("123132.3244");

        bi.add(bi2);
        bi.subtract(bi2);
        bi.multiply(bi2);
        bi.divide(bi);


        // SWITCH
        switch (i2){
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println();
        }


        // METODY
        class Funkcje{
            void main(){
                sumujLiczby(1,2,3,4);
                int[] tabInt = {1,2,3,4};
                sumujLiczby(tabInt);

            }
            //////////////
            int sumujLiczby(int...tab){
                int suma = 0;
                for(int x:tab){
                    suma+=x;
                }
                return suma;
            }
        }

        //------------------------------------------------------------------------

        // RANDOM
        Random random = new Random();
        boolean prawdaFalsz = random.nextBoolean();
        double los = random.nextDouble();
        // pokaze od 0 do 1 po przecinku, moge pomnozyc aby przesunac ,
        float los2 = random.nextFloat();//mniejszy zakres
        int los3 = random.nextInt();//standardowo pokaze z calego zakresu
        // int lecz moge to zawezic podajac liczbe w paramterze np:
        // random.nextInt(10) to bedzie losowac liczby z zakresu od 0 do 9

        //------------------------------------------------------------------------

        // ROBOT
        /*
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

        //------------------------------------------------------------------------

        //SORTOWANIE TABLICY OBIEKTOW / KLASA ARRAYS
        // .asList(); //zamiana tablicy na liste
        List<String>imionaLista1 = Arrays.asList("kamil","tomek");
        String[] imionaTablica = {"kamil","tomek"};
        List<String>imionaLista2 = Arrays.asList(imionaTablica);

        //.equals();

        //.fill();//tylko dla tablic!
        Arrays.fill(imionaTablica, "xD");

        //.sort();

        KlasaArrays2 ka = new KlasaArrays2(10);
        KlasaArrays2 ka2 = new KlasaArrays2(9);
        KlasaArrays2 ka3 = new KlasaArrays2(12);
        KlasaArrays2[] t = {ka,ka2,ka3};
        Sortuj mojSort = new Sortuj();
        //Tworze obiekt klasy sortujacej
        Arrays.sort(t, mojSort);
        //wywoluje metode klasy Arrays - sort() i umieszczam w niej tablice
        // obiektow oraz obiekt sorujacy
        System.out.println("Posortowane wielkosci:");
        for(KlasaArrays2 x : t){
            System.out.println(x.getWielkosc());
        }
        class KlasaArrays2{
            private int wielkosc;
            KlasaArrays2(int wielkosc){
                this.wielkosc = wielkosc;
            }
            public int getWielkosc(){
                return wielkosc;
            }
        }
        class Sortuj implements Comparator<KlasaArrays2> {
            public int compare(KlasaArrays2 o1, KlasaArrays2 o2){
                if(o2 == null) return -1;
                if(o1.getWielkosc()>o2.getWielkosc()) return 1;
                else if(o1.getWielkosc()<o2.getWielkosc()) return -1;
                else return 0;
            }
        }

        //------------------------------------------------------------------------

        // LISTY
        /*
        Jedna ze struktur danych sa listy w ktorych wyrozniamy najlpopularniejsze
         ArrayList - implemenacja tablicowa oraz LinkedList -/- dowiazana
        ArrayList uzywamy gdy mamy czesty dostep do elementow natomiast
         LikedListy gdy bedziemy czesto wynonywac operacje takie jak dodawanie
         usuwanie elementow itp

        Dobra praktyka jest deklarowanie ich jako List aby moc w przyszlosci
         podmienic implementajce
        */
        List lista1 = new ArrayList(32); // w przypadku listy tablicowej dobrze
        // jest dodac domyslny poczatkowy rozmiar
        //Ta lista jest typu OBJECT!
        lista1.add("Kamil");
        List lista2 = new LinkedList();
        /*
        Podstawowe operacje:
        add(obj);
        remove(obj);
        remove(int);
        size();
        get(int);
        */

        //------------------------------------------------------------------------

        // ZBIORY
        /*
        Zbior ma unikalne elementy standardowo bez ustalonej kolejnosci

        TYPY:
        HashSet - w srodku umieszczona jest tablica mieszajaca, wymaga
         implementacji hashCode oraz equals
        TreeSet - uporzadkowywwuje elementy wg naturalnego porzedku, wymagane
         jest do tego implementacja interfejsu Comparable lub uzycie odpowiedniego
         Comparatora
        LinkedHashSet - dodatkowo zapamietuje kolejnosc dodawnych elementow

        METODY:
        add() - dodanie elem. gdy taki juz wystepuje, dodawnie jest pominienete
         w przypadku obiektow sprawdzanie odbywa sie za pomoca wartosci hashCode
         oraz equals wiec nalezy je zaimpelemntowac
        contains(wartosc) - zwraca flage czy zbior posiada podana wartosc
        isEmpty() - zwraca flage czy zbior jest pusty
        size() - zwraca rozmiar zbioru
        remove(wartosc) - usuniecie wartosci ze zbioru
        iterator() - zwraca iterator (typ Iterator)
        *dodatkowo w TreeSet mamy dodatkowo mozliwosc zworcenia "najmniejszego"
          elementu first() oraz najwiekszego()
         */
        System.out.println("\n"+"ZBIORY:");

        Set<String>imiona = new TreeSet<>();
        imiona.add("kamil");
        imiona.add("kamil");
        imiona.add("tomek");
        System.out.println("rozmiar: "+imiona.size());
        System.out.println("czy jest tomek: "+imiona.contains("tomek"));
        System.out.println("czy zbior jest pusty: "+imiona.isEmpty());
        imiona.remove("kamil");
        System.out.println(imiona);
        System.out.println(imiona.iterator());

        //------------------------------------------------------------------------

        // MAPY
        /*
        Mapa nie rozszerza kolekcji, obiekty skladaja sie z Klucz-Wartosc

        Wartosc klucza jest unikalna, gdy dodamy taka sama wartosc klucza
         stara zostanie zastapiona

        TYPY:
        HashMap - posiada tablice mieszajaca i kolejnosc elementow nie jest
         ustalona
        TreeMap - Dodatkowo posiada sortowanie, wymagana implementacja interfejsu
         Comprable lub implementacji Comparatora
        LinkedHashMap - zapamietuje dodatkowo kolejnosc dodawanych elementow,
         wykorzystuje liste wiazana. Prdzydatne przy iteracji

        Klasa definiujaca wymaga implementacji equals oraz hashCode

        Mapy nie posiadaja metody add();

        METODY:
        put(K, V) - wstawia do mapy wartosci K-V np mapa.put(17,"kamil");
        get(wartoscKlucza) - pobieram wartosc przypisana do podanego klucza
        remove(wartoscKlucza) - usuwam wartosc przypisana do klucza, po usunieciu
         wartosc bedzie ustawiona na null
        isEmpty() - zwroci flage czy mapa jest pusta
        size() - zwroci rozmiar mapy
        keySet() - zwroci wartosci kluczy, mozemy uzyc aby przypisac je do nowego
         zbioru kluczy
        values() - zwroci wartosci, moge uzyc gdy chce przypisac wartosci do nowej
         kolekcji
        entrySet() - zwroci klucz z przypisana do niego wartoscia, moge to wykorzystac
         do stworzenia zbioru z elementami typu Entry z klasy Map posiadajace elementy
         klucz-wartosc
         np:Set<Map.Entry<Integer,String>>zbiorKluczWartosc = mapa.entrySet();
         Wypisanie w petli foreach bedzie wygladalo:
         for(Entry<Integer,String> x: zbiorKluczWartosc){
            sout(x.getKey()+x.getValue());
         */
        System.out.println("\n"+"MAPY:");

        Map<Integer, String> pracownicy = new TreeMap<>();
        //treeMap posortuje wg klucza
        pracownicy.put(3,"kamil");
        pracownicy.put(2,"tomek");
        pracownicy.put(7,"przemek");
        pracownicy.put(1,"waclaw");

        System.out.println("czy jest puste:"+pracownicy.isEmpty());
        System.out.println("rozmiar:"+pracownicy.size());
        pracownicy.remove(2);
        System.out.println("wartosc w id:2 to:"+pracownicy.get(2));
        System.out.println("klucze mapy:"+pracownicy.keySet());
        System.out.println("wartosci mapy:"+pracownicy.values());
        System.out.println("klucze i wartosci:"+pracownicy.entrySet());

        Set<Integer> zbiorKluczy = pracownicy.keySet();
        Collection<String> kolekcjaWartosci = pracownicy.values();

        Set<Map.Entry<Integer,String>> zbiorKluczWartosc = pracownicy.entrySet();
        for(Map.Entry<Integer,String>x:zbiorKluczWartosc){
            System.out.println("klucz:"+x.getKey()+" wartosc:"+x.getValue());
        }

        //------------------------------------------------------------------------

        // WYJATKI
        /*
        “checked exceptions” wymagaja obslugi (np IOException)
          oraz “unchecked exceptions” (np. IllegalArgumentException)
        Throwable <- Exception <- RuntimeException <- IllegalArgumentException
        W przypadku gdy wyjatek dziedziczy po Exception a nie ma RuntimeException jest
         wyjatkiem checked, w kazdym innym przypadku jest typu unchecked

        Wyjatki mozna obluzyc na 2 sposoby, jeden to poprzez blok try/catch a drugi
         to zepchniecie go na poziom nizej czyli do metody wywolujacej za pomoca
         klauzuli throws
        */
        boolean czyPoprawne = false;
        if(!czyPoprawne && 1>2){
            try{
                Scanner sc = new Scanner(System.in);
                String nazwa = sc.nextLine();
                int liczba = sc.nextInt();

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String imie = br.readLine();
                int wiek = Integer.parseInt(br.readLine());

                czyPoprawne = true;
                //moge tez dac break; do wyjscia z while
            }catch (IOException ex){
                ex.getMessage();
            }catch (NumberFormatException | NullPointerException ex){
                //obsluga 2 wyjatkow w jednym bloku catch
                ex.getMessage();
            }finally {
                System.out.println("zawsze kurde");
            }

        }
        class ObslugaWyjatkow{
            public void wyjatki()throws NumberFormatException,IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int x = Integer.parseInt(br.readLine());
                int y = Integer.parseInt(br.readLine());
                if(y==0){
                    throw new ArithmeticException("nie moge dzilic przez 0");
                }
                else System.out.println(x/y);
                //////////////////
                Scanner wczytaj = new Scanner(System.in);
                double mojaLiczba = 0;
                while (true) {
                    try {
                        mojaLiczba = wczytaj.nextDouble();
                        break;//wyjdzie z while
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Podaj poprawną liczbę!");
                        // ignoring wrong token
                        wczytaj.next();
                    }
                }
            }
        }

        //------------------------------------------------------------------------

        // OBIEKTY POLIMORFIZM DZIEDZICZENIE
        System.out.println("\n"+"OBIEKTY");

        Pracownik p1 = new Programista(3000, 230);
        Pracownik[] pracowniks_xD = new Pracownik[2];
        pracowniks_xD[0] = new Programista(4000,400);
        pracowniks_xD[1] = new Programista(6000, 800);

        System.out.println("wyswietlenie proste obiektu (metoda toString):");
        System.out.println(p1);
        //laczona metoda toString w obu klasach
        //return super.toString()+" "+String.valueOf(linieKodu);

        System.out.println("Programista.pokazInfo((Programista) p1):");
        Programista.pokazInfo((Programista) p1);
        //public static void pokazInfo(final Programista p){
        //   System.out.println(p.getZarobki()+" "+p.linieKodu); }
        //musze zrzutowac bo metoada PRZYJMUJE OBIEKT a jest on typu Pracownik!
        // a metoda przyjmuje programiste. Musi przyjmowac programiste poniewaz
        // potrzebuje dostac sie do jego pol (linieKodu)
        // jest statyczna wiec wywoluje z nazwa klasy

        System.out.println("Pracownik.pokazInfo(p1):");
        Pracownik.pokazInfo(p1); //tylko info o zarobkach

        p1.getZarobki();
        p1.setZarobki(4000);
        ((Programista) p1).getLinieKodu(); //rzutowanie bo metoda unikalna nadlasy
        // a typ jest Pracownika
        ((Programista) p1).setLinieKodu(350);

        Pracownik p2 = new Programista(((Programista)p1)); //kopiuje
        System.out.println("p2: "+p2);

        p2.pracuj(); //metoda interfejsu ktory implementuje klasa abstr. Pracownik
        // ktora rozszerza Programista (klasa abstr. nie musi go deklarwoac
        // w kodzie

        ((Programista) p2).piszKod();//teraz musze wykonac rzutownie
        // public void piszKod(){ linieKodu+=10; }
        // poniewaz metoda jest unikalna w programiscie bez deklaracji
        // w klasie nadrzednej/badz interf. ktory implementuje
        //Musze wiec rzutowac jesli wywoluje cos czego nie ma w TYPIE obiektu
        // badz "nizej"

        //EQUALS HASHCODE
        /*
        moge dodac tylko w klasie "najwyzej" obiektu i odwolac sie w metodzie equals i
         hashcode do zmiennych nadklas przez akcesor

        deklaracja public boolean equals(Obj o){
        warunki:
         if(this==obj) return true;
         if(obj==null||this.getClass()=!obj.getClass()) return false;
         Klasa k = (Klasa)k;
         if(this.zmienna==k.zmienna && this.getZmienna2()==
            k.getzmienna2())return true
         else return false

        Do porownania moge uzyc Double.compare(zmianna, ((Nadklasa)obj).zmianna()) == 0
         zwroci 0!
        dla zmiennoprzecinkowych a dla stringow Objects.equals(name, obj.getZmienna2());
        zmienne int moge porownywac bezposrenio zmienna==((Klasa)obj).zmienna;
        np. return Double.compare(zmienna, ((Klasa)obj.zmienna)==0;
        lub return Objects.equals(zmienna, ((Klasa)obj.zmienna); //nie zwroci 0!

        w hashcode
         public int hashCode() return Objects.hash(zmienna, getZmiannaNadklasy());
        */
        Pracownik p3 = new Programista(3000,300);
        Pracownik p4 = new Programista(3000,300);
        System.out.println("equals: "+p3.equals(p4));
        System.out.println("hashCode obiektu 1: "+p3.hashCode());
        System.out.println("hashCode obiektu 2: "+p4.hashCode());
    }
}

interface Praca{
    public void pracuj();
}
abstract class Pracownik implements Praca{ //klasa abstr. nie musi implementowac
    //metod implementowego interf. natomiast klasy dziedziczace juz tak
    private int zarobki;
    Pracownik(){
        this.zarobki = 0;
    }
    Pracownik(int zarobki){
        this.zarobki = zarobki;
    }
    Pracownik(Pracownik p){
        this.zarobki = p.zarobki; //konstr. kopii
    }
    int getZarobki(){return zarobki;}

    public void setZarobki(int zarobki) {
        this.zarobki = zarobki;
    }
    public String toString(){
        return "zarobki: "+String.valueOf(zarobki);
    }
    public static void pokazInfo(final Pracownik p){ //zablokowalem zmiane
        // referencji
        //Metoda moze takze przyjac Programiste lecz do pola zarobki juz musialbym
        // odwolac sie przez geter
        System.out.println(p.zarobki);
        //lub System.out.println(p.getZarobki());
        //tutaj nie mam dostepu do zawartosci Programisty

    }

}
class Programista extends Pracownik{ //nie musze implementowac interf.
    private int linieKodu;
    Programista(){
        super(); //niejawnie i tak sie wykonaloby
        this.linieKodu = 0;
    }
    Programista(int zarobki, int linieKodu){
        super(zarobki); //niejawnie wykonaloby sie samo super()
        // ustawiajac zarobki na 0 wg konstruktora bezparam. Pracownika
        this.linieKodu = linieKodu;
    }
    Programista(Programista p){ //musze przyjac programiste
        // poniewaz inaczej nie bedzie widzial zmiennej lini kodu
        super(p);
        this.linieKodu = p.linieKodu;
    }
    public int getLinieKodu() {
        return linieKodu;
    }

    public void setLinieKodu(int linieKodu) {
        this.linieKodu = linieKodu;
    }

    public String toString(){
        return super.toString()+" linie kodu: "+String.valueOf(linieKodu);
    }
    @Override
    public void pracuj() {
        linieKodu++;
    }
    public void piszKod(){
        linieKodu+=10;
    }//metoda unikalna, musi byc rzutowanie
    public static void pokazInfo(final Programista p){
        System.out.println(p.getZarobki()+" "+p.linieKodu);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(this.getClass() != obj.getClass() || obj == null)return false;
        Programista objP = (Programista)obj;
        if(this.linieKodu == objP.linieKodu && this.getZarobki() ==
                objP.getZarobki()) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(getZarobki(), linieKodu);
    }
}

//////////////implementacja wzorca w kodzie
class KlasaArrays2{
    private int wielkosc;
    KlasaArrays2(int wielkosc){
        this.wielkosc = wielkosc;
    }
    public int getWielkosc(){
        return wielkosc;
    }
}
class Sortuj implements Comparator<KlasaArrays2> {
    public int compare(KlasaArrays2 o1, KlasaArrays2 o2){
        if(o2 == null) return -1;
        if(o1.getWielkosc()>o2.getWielkosc()) return 1;
        else if(o1.getWielkosc()<o2.getWielkosc()) return -1;
        else return 0;
    }
}

///////
class toExtend{
    int lowInt;
}
class Testequals extends toExtend{
    int int1;
    int int2;
    double double1;
    double double2;
    String str1;
    String str2;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Testequals that = (Testequals) o;
        return int1 == that.int1 &&
                int2 == that.int2 &&
                Double.compare(that.double1, double1) == 0 &&
                Double.compare(that.double2, double2) == 0 &&
                Objects.equals(str1, that.str1) &&
                Objects.equals(str2, that.str2);
    }

    @Override
    public int hashCode() {

        return Objects.hash(int1, int2, double1, double2, str1, str2);
    }
}