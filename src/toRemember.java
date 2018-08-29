import PrzydatneKlasy.ArraysMoja;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.management.BufferPoolMXBean;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class toRemember {
    public static void main(String[] args) throws IOException, URISyntaxException {

        KlasaArrays3 obiektKlasy = new KlasaArrays3(10);
        String string1 = "asd";
        String string2 = "asd";
        Integer mojInteger = 1234;
        int[] intsTab = {1234,2134};

        //Objects.compare(bb1,bb1,bb1); ?
        Integer.compare(1,2);
        Character.compare('c','d');
        Double.compare(23.2, 234.2);
        Arrays.compare(intsTab,intsTab);
        //Mozna wywolac TYLKO z nazwy klasy (STANDAROWEJ) a nie obiektu

        //Metode compare() uzywam glownie gdy chce posortowac tablice wlasnych
        // obiekow za pomoca metody sort z klasy Arrays
        // Arrays.sort(tablicaObiektow, new ObiektKlasySortujacej)

        //Taka metodaZwykla oprocz tablicy przyjmuje obiekt klasy sortujacej

        //Klasa sortujaca implementuje intefejs Comparator z typem generycznym
        // klasy obiektow ktore chcemy posrotowac i w niej deklarauje
        // metode public int compare(Klasa o1, Klasa o2)

        //Moge takze uzyc klasy anonimowej aby nie deklarowac oddzilnej klasy
        // na potrzebe tworzenia Coparatora
        /*
        Arrays.sort(tabObiektow, new Comparator<KlasaObiektow>() {
            @Override
            public int compare(KlasaObiektow o1, KlasaObiektow o2) {
                if(o1.wielkosc>o2.wielkosc) return 1;
                else if(o1.wielkosc<o2.wielkosc) return -1;
                else return 0;
            }
        });
        */

        //Glowny rodzaj sortowania robie w glownej klasie z uzyciem interfejsu
        // Comparable i metodaZwykla compareTo()


        string1.compareTo(string2);
        string1.compareToIgnoreCase(string2);
        mojInteger.compareTo(mojInteger);
        obiektKlasy.compareTo(obiektKlasy);
        //Brak tablic!
        //Mozna wywolac TYLKO na obiekcie

        //Metode compareTo deklaruje w klasie obiekow aby miec mozliwosc sortowania
        // tablicy obiektow metodaZwykla sort klasy Arrays -
        // Arrays.sort(tab)
        // uzywam w argumencie tylko tablicy obiekow!

        //Klasa taka musi implementowac interface Comparable i deklarwoac metode
        // public int compareTo(Object o1) - przyjmuje 1 obiekt!

        //Mozna implementowac interfejs z typem generycznym to
        // w deklaracji metody compareTo uzywamy obiektu typu tej klasy
        // public int compare(Klasa o1) - 1 OBIEKT!


        Objects.equals(string1, string2); //dla Stringow
        Arrays.equals(intsTab, intsTab); //dla tablic
        string1.equals(string2);
        mojInteger.equals(mojInteger);
        intsTab.equals(intsTab);
        obiektKlasy.equals(obiektKlasy);
        //Mozna wywolac na nazwie klasy TYLKO standardowej (Objects/Arrays)
        // inaczej wywoluje na obiekcie lub tablicy

        //W przypadku obiektu klasy wlasnej wymagana jest deklaracja
        // metody boolean equals(Object o) oraz metody int hashCode()

        //Warunki w metodzie public boolean equals(Object o):
        // if(this = o) return true
        // if(o = null || this.getClass() != o.getClass()) return false
        // if(this.zmienna == ((klasa)o).zmienna return true
        // else return false

        //Warunki w metodzie public int hashCode():
        // return Objects.hash(zmienna1, getzmienna2());



        /*
        TEORIA:
        Hermetyzajca/Enkapsulacja - ustawianie pol klas jako prywatne/protected
         i dostep do niech poprzez akcesory i mutatory
        Rekursja - odwolanie sie do innego konstruktora
        Klasy/meotdy final nie mozna rozszerzac
        Zmiennych final nie mozna zmieniac po 1 deklaracji

         */

        // STRING
        Integer stringInteger = 54637;
        String liczbaSlownie3 = Integer.toString(stringInteger);
        String liczbaSlownie = Integer.toString(10);
        String liczbaSlownie2 = String.valueOf(12);

        String str = "132";
        String strX = "1234";
        str = str+"123";
        /*kazda modyfikacja stringa to tworznie nowgo obiektu
        String x = "Kasia"
        String s = x+" i Tomek"; // to tak naprawde:
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
        int i3 = str.compareTo(strX);//porowna alfabetycznie
        //gdy str bedzie "wiekszy" zwroci -1, gdy "mniejszy" 1 i gdy rowny to 0


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
        Rozwiazuje problem wyrazen lambda oraz upraszcza laczenie Stringow
         */
        System.out.println("StringJoiner");
        StringJoiner joiner = new StringJoiner("");
        //Musze okreslic w konstruktorze 1 lub 3 parametry, gdy podam jeden
        // bedzie to separator oddzielajacy stringi, gdy podam 3 bedzie to
        // separator, prefix(to co na poczatku ciagu) i suffix(na koncu)
        StringJoiner joiner2 = new StringJoiner(",","{","}");
        joiner2.add("napis").add("napis2");
        System.out.println("StringJoiner: "+joiner2);
        String napisSJ = joiner2.toString();
        //Nie ma metody substring();
        System.out.println("Dlugosc StringJoinera: "+joiner2.length());
        System.out.println("StringJoiner na String: "+napisSJ);


        // MATH
        Math.abs(9);
        Math.pow(2,2);
        Math.sqrt(4);
        Math.round(9.26134); //zaokrlaglenie
        Math.min(10,12);
        Math.max(10,12);

        // KLASY OSLONOWE
        Integer testInteger = 1234;
        Integer testInteger2 = new Integer(12343);
        //Z uzyciem boxingu

        //metody:
        Integer mojInteger1 = Integer.valueOf(10);
        Integer mojInteger2 = Integer.valueOf("123");
        int mojInt1 = Integer.valueOf(444);
        int mojInt2 = Integer.valueOf("1234");
        //Metoda valueOf dziala dla int i string
        //Metoda valueOf dziala dla int i string
        //Moze zapisac wartosci liczbowe go Integera i int

        Integer mojInteger3 = Integer.parseInt("123");
        int mojInt3 = Integer.parseInt("123");
        //parseInt dla stringa i moze zapisac do Integera i inta

        Integer.compare(mojInteger1, mojInteger2);
        //Zwroci 1 gdy mojInteger1 wiekszy, -1 gdy mniejszy i 0 gdy rowny
        //Przydante podczas tworzenia metod compare() oraz compareTo()

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
                System.out.println();//wykona tylko gdy zaden case
                 // nie zostanie uruchomiony
        }

        while (true){
            int sdfwef = 10;
            break;
        }
        //uproszczone wyjscie z uzyciem brek
        // break wyjdzie takze z for

        for (int i = 0; i < 10; i+=10) {
            break;
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

        //KLASA ARRAYS / SORTOWANIE TABLICY OBIEKTOW
        System.out.println("KLASA ARRAYS:");

        // .asList(); //zamiana tablicy na liste
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

        //.toString()
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

        //.sort() z wykorzystaniem komparatora
        KlasaArrays2 ka = new KlasaArrays2(10);
        KlasaArrays2 ka2 = new KlasaArrays2(9);
        KlasaArrays2 ka3 = new KlasaArrays2(12);
        KlasaArrays2[] t = {ka,ka2,ka3};
        Sortuj mojSort = new Sortuj();
        //Tworze obiekt klasy sortujacej
        Arrays.sort(t, mojSort);
        //Wywoluje metode klasy Arrays - sort() i umieszczam w niej tablice
        // obiektow oraz obiekt sorujacy
        Arrays.sort(t, new Sortuj());
        //lub umieszczam nowy obiekt prosto w metodie
        System.out.println("\n"+"Posortowane wielkosci z uzyciem komparatora:");
        for(KlasaArrays2 x : t){
            System.out.print(x.getWielkosc()+" ");
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
        //lub z uzyciem klasy anonimowej
        /*Arrays.sort(t, new Comparator<KlasaArrays2>() {
            @Override
            public int compare(KlasaArrays2 o1, KlasaArrays2 o2) {
                if(o2 == null) return -1;
                if(o1.getWielkosc()>o2.getWielkosc()) return 1;
                else if(o1.getWielkosc()<o2.getWielkosc()) return -1;
                else return 0;
            }
        });
         */

        //.sort() z wykorzystaniem interfejsu Comparable
        KlasaArrays3 ka4 = new KlasaArrays3(10);
        KlasaArrays3 ka5 = new KlasaArrays3(9);
        KlasaArrays3 ka6 = new KlasaArrays3(12);
        KlasaArrays3[] t4 = {ka4,ka5,ka6};
        Arrays.sort(t4);
        System.out.println("\n"+"Posortowane wielkosci z uzyciem Comparable:");
        for(KlasaArrays3 x : t4){
            System.out.print(x.getWielkosc()+" ");
        }
        class KlasaArrays3 implements Comparable{
            private int wielkosc;
            KlasaArrays3(int wielkosc){
                this.wielkosc = wielkosc;
            }
            public int getWielkosc(){
                return wielkosc;
            }
            public int compareTo(Object o){
                if(this.wielkosc>((KlasaArrays3)o).getWielkosc()) return 1;
                else if(this.wielkosc<((KlasaArrays3)o).getWielkosc()) return 0;
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
        List<String>lista3 = Arrays.asList("costam");
        /*
        Podstawowe operacje:
        add(obj);
        remove(obj);
        remove(int);
        size(); // nie lenght! jak w tablicach
        get(int);
        contains(value);
        isEmpty();
        clear();
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
          elementu first() oraz najwiekszego last()
         */
        System.out.println("\n\n"+"ZBIORY:");

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

        // SORTOWANIE LIST COMPARABLE COMPARATOR

        System.out.println("\n"+"SORTOWANIE LIST COMPARABLE COMPARATOR:");
        Czlowiek c1 = new Czlowiek("Kamil","bbb", 'm' );
        Czlowiek c2 = new Czlowiek("Pauilna","ddd", 'k' );
        Czlowiek c3 = new Czlowiek("Agata","ccc", 'k' );
        Czlowiek c4 = new Czlowiek("Tomek","aaa", 'm' );
        Czlowiek c5 = new Czlowiek("Filip","eee", 'm' );
        List<Czlowiek> listaLudzi = new ArrayList<Czlowiek>();
        listaLudzi.add(c1);
        listaLudzi.add(c2);
        listaLudzi.add(c3);
        listaLudzi.add(c4);
        listaLudzi.add(c5);
        for (Czlowiek x : listaLudzi)
            System.out.println(x);

        System.out.println("po sortowaniu wg nazwiska:");
        Collections.sort(listaLudzi);//sortowanie listy obiektow
        for (Czlowiek x : listaLudzi)
            System.out.println(x);

        System.out.println("po sortowaniu wg plci");
        Collections.sort(listaLudzi, new CzlowiekKomparator());
        for (Czlowiek x : listaLudzi)
            System.out.println(x);
        Collections.sort(listaLudzi, new Comparator<Czlowiek>() {
            @Override
            public int compare(Czlowiek o1, Czlowiek o2) {
                return o1.getImie().compareToIgnoreCase(o2.getImie());
            }
        });
        System.out.println("Po kolejnym sortowaniu wg imion");
        for (Czlowiek x : listaLudzi)
            System.out.println(x);

        class Czlowiek implements Comparable<Czlowiek>{
            private String imie,nazwisko;
            private char plec;

            public char getPlec() {
                return plec;
            }
            public String getImie(){
                return imie;
            }
            public Czlowiek(String imie, String nazwisko, char plec){
                this.imie=imie;
                this.nazwisko=nazwisko;
                this.plec=plec;
            }
            public String toString(){
                return imie+" "+nazwisko+" "+Character.toString(plec);
            }
            public int compareTo(Czlowiek o){
                int wyjscie = this.nazwisko.compareTo(o.nazwisko);
                if(wyjscie==0)
                    return this.imie.compareTo(o.imie);
                else
                    return wyjscie;
            }
        }
        class CzlowiekKomparator implements Comparator<Czlowiek>{
            public int compare(Czlowiek o1, Czlowiek o2) {
                //najpierw kobiety iksde k<m
                int wyjscie = Character.compare(o1.getPlec(), o2.getPlec());
                //lub  int wyjscie = o1.getPlec() - o2.getPlec();
                if(wyjscie == 0)
                    return o1.compareTo(o2);
                else
                    return wyjscie;
            }
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

        // WCZYTYWANIE WEJSCIA
        Scanner mojScanner = new Scanner(System.in);
        if(1>2){
            int liczba = mojScanner.nextInt();
            String napis = mojScanner.nextLine();
            mojScanner.close();

            while(mojScanner.hasNext()){
                List<Integer> liczbySkaner = new LinkedList<>();
                liczbySkaner.add(mojScanner.nextInt());
            }
        }


        //------------------------------------------------------------------------

        // PLIKI
        if(1>2){
            //stary rodzaj tworzenia plikow
            File plik = new File("C:/Users/Fak3frame/plikTestowy.txt");
            //moge dac sciazke + nazwe
            File plik2 = new File("plikTestowy2.txt");
            //lub sama nazwe
            if(!plik.exists())
                plik.createNewFile();

            //od Javy 7:
            Files.createFile(Paths.get("plikTestowy3.txt"));
            //korzystam bezposrenio z klasy Files oraz metody get klasy Paths
            Files.createFile(Paths.get("C:/Users/Fak3frame/plikTestowy.txt"));
            //jesli plik istnieje wyrzuci wyjatek FileAlreadyExistsException

            //Tworzenie folderu
            Files.createDirectory(Paths.get("Folder"));

            BasicFileAttributeView atrybutPodglad = Files
                    .getFileAttributeView(Paths.get("plik.txt"), BasicFileAttributeView.class);
            BasicFileAttributes atrybuty = atrybutPodglad.readAttributes();
            System.out.println("Rozmiar pliku: "+atrybuty.size());
            System.out.println("Ostatnia modyfikacja: "+atrybuty.lastModifiedTime());

            //Wczytywanie pliku i zapis wierszy do listy (niezalecane do dlugich plikow
            List<String> listaWierszy = Files
                    .readAllLines(Paths.get("plik.txt"), Charset.forName("UTF-8"));
            for(String x : listaWierszy){
                System.out.println(x);
            }

            //Wczytywanie pliku i zapis go do stringa
            String zbior = Files.lines(Paths.get(ClassLoader.getSystemResource("plik.txt").toURI()))
                    .filter(strx->strx.length()>3)
                    .collect(Collectors.joining(", ","{","}"));
            //w tym przypadku odczytuje z pliku ciagi znakow linia po lini o odrzucam
            // te krotsze od dlugosci 3

            //kopiowanie pliku z nadpisaniem starego
            Files.copy(Paths.get("plik.txt"),
                    Paths.get("C:/Users/Fak3frame/plik.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
            //przenoszenie pliku z nadpisaniem starego
            Files.move(Paths.get("plik.txt"),
                    Paths.get("C:/Users/Fak3frame/plik.txt"),
                    StandardCopyOption.REPLACE_EXISTING);

            //Wszystkie atrybuty kontroli dostepu
            AclFileAttributeView kontrolaDostepuPodglad = Files.getFileAttributeView(Paths
                    .get("plik.txt"), AclFileAttributeView.class);
            List<AclEntry> listaKontoliDostepu = kontrolaDostepuPodglad.getAcl();
            for (AclEntry x : listaKontoliDostepu){
                x.flags().forEach(System.out::println);
                x.permissions().forEach(System.out::println);
                System.out.println(x.principal().getName());
            }
        }

        //------------------------------------------------------------------------

        // OBIEKTY POLIMORFIZM DZIEDZICZENIE
        System.out.println("\n"+"OBIEKTY");

        Pracownik p1 = new Programista(3000, 230);
        Pracownik[] pracowniks_xD = new Pracownik[2];
        pracowniks_xD[0] = new Programista(4000,400);
        pracowniks_xD[1] = new Programista(6000, 800);

        System.out.println("wyswietlenie proste obiektu (metodaZwykla toString):");
        System.out.println(p1);
        //laczona metodaZwykla toString w obu klasach
        //return super.toString()+" "+String.valueOf(linieKodu);

        System.out.println("Programista.pokazInfo((Programista) p1):");
        Programista.pokazInfo((Programista) p1);
        //public static void pokazInfo(final Programista p){
        //   System.out.println(p.getZarobki()+" "+p.linieKodu); }
        //musze zrzutowac bo metoada PRZYJMUJE OBIEKT a jest on typu Pracownik!
        // a metodaZwykla przyjmuje programiste. Musi przyjmowac programiste poniewaz
        // potrzebuje dostac sie do jego pol (linieKodu)
        // jest statyczna wiec wywoluje z nazwa klasy

        System.out.println("Pracownik.pokazInfo(p1):");
        Pracownik.pokazInfo(p1); //tylko info o zarobkach

        p1.getZarobki();
        p1.setZarobki(4000);
        ((Programista) p1).getLinieKodu(); //rzutowanie bo metodaZwykla unikalna nadlasy
        // a typ jest Pracownika
        ((Programista) p1).setLinieKodu(350);

        Pracownik p2 = new Programista(((Programista)p1)); //kopiuje
        System.out.println("p2: "+p2);

        p2.pracuj(); //metodaZwykla interfejsu ktory implementuje klasa abstr. Pracownik
        // ktora rozszerza Programista (klasa abstr. nie musi go deklarwoac
        // w kodzie lecz jesli tego nie zrobi to klasa rozszerzajaca ta klase
        // abstrakcyjna bedzie musiala to zrobic

        ((Programista) p2).piszKod();//teraz musze wykonac rzutownie
        // public void piszKod(){ linieKodu+=10; }
        // poniewaz metodaZwykla jest unikalna w programiscie bez deklaracji
        // w klasie nadrzednej/badz interf. ktory implementuje
        //Musze wiec rzutowac jesli wywoluje cos czego nie ma w TYPIE obiektu
        // badz "nizej"

        // EQUALS HASHCODE
        /*
        moge dodac tylko w klasie "najwyzej" obiektu i odwolac sie w metodzie equals i
         hashcode do zmiennych nadklas przez akcesor

        deklaracja public boolean equals(Object o){
        warunki:
         if(this==o) return true;
         if(o==null||this.getClass()=!o.getClass()) return false;
         Klasa k = (Klasa)o;
         if(this.zmienna==k.zmienna && this.getZmienna2()==
            k.getzmienna2())return true
         else return false

        Do porownania moge uzyc Double.compare(zmianna, ((Nadklasa)obj).zmianna()) == 0
         zwroci 0! dla zmiennoprzecinkowych
        a dla stringow Objects.equals(name, obj.getZmienna2());
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
    private static int id = 0;
    Pracownik(){
        this.zarobki = 0;
        //konstruktor domyslny (bez deklaracji ustawia wartosici pol na 0
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
    }//metodaZwykla unikalna, musi byc rzutowanie
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
//---------------------------------------
class Czlowiek implements Comparable<Czlowiek>{
    private String imie,nazwisko;
    private char plec;
    public String getImie(){
        return imie;
    }
    public char getPlec() {
        return plec;
    }

    public Czlowiek(String imie, String nazwisko, char plec){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.plec=plec;
    }

    public String toString(){
        return imie+" "+nazwisko+" "+Character.toString(plec);
    }

    public int compareTo(Czlowiek o){
        int wyjscie = this.nazwisko.compareTo(o.nazwisko);
        if(wyjscie==0)
            return this.imie.compareTo(o.imie);
        else
            return wyjscie;
    }
}
class CzlowiekKomparator implements Comparator<Czlowiek>{
    public int compare(Czlowiek o1, Czlowiek o2) {
        //najpierw kobiety iksde k<m
        int wyjscie = Character.compare(o1.getPlec(), o2.getPlec());
        //lub  int wyjscie = o1.getPlec() - o2.getPlec();
        if(wyjscie == 0)
            return o1.compareTo(o2);
        else
            return wyjscie;
    }
}

class KlasaArrays3 implements Comparable{
    private int wielkosc;
    KlasaArrays3(int wielkosc){
        this.wielkosc = wielkosc;
    }
    public int getWielkosc(){
        return wielkosc;
    }
    public int compareTo(Object o){
        if(this.wielkosc>((KlasaArrays3)o).getWielkosc()) return 1;
        else if(this.wielkosc<((KlasaArrays3)o).getWielkosc()) return -1;
        else return 0;
    }
}
//---------------------------
class TestKomparatora implements Comparator<TestKomparatora>{
    int wielkosc;
    public int compare(TestKomparatora o1, TestKomparatora o2){
        if(o1.wielkosc>o2.wielkosc) return 1;
        else if(o1.wielkosc<o2.wielkosc) return -1;
        else return 0;
    }
}