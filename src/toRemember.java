import PrzydatneKlasy.KlasaArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class toRemember {
    public static void main(String[] args) {
        String liczbaSlownie = Integer.toString(10);
        String liczbaSlownie2 = String.valueOf(12);

        String str = "132";

        str.trim();
        str.toUpperCase().toLowerCase();
        boolean b1 = str.isEmpty();
        int i1 = str.length();
        char[] t1 = str.toCharArray();
        char ch1 = str.charAt(0);

        str.substring(1,2);
        String[] t2 = str.split("1");
        str.replace(""," ");
        boolean b2 = str.matches("");
        int i2 = str.indexOf("1"); i2 = str.lastIndexOf("1");

        boolean b3 = str.equals(str);
        str.concat("123");
        boolean b4 = str.startsWith("123");
        boolean b5 = str.endsWith("123");
        boolean b6 = str.contains("123");

        byte[] t3 = str.getBytes();
        int i3 = str.compareTo(str);

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
        String  str2 = sb.substring(1);

        Math.abs(9);
        Math.pow(2,2);
        Math.round(9.26134);

        BigInteger bi = new BigInteger("1234");
        BigInteger bi2 = BigInteger.valueOf(1234);
        BigDecimal bd = new BigDecimal("123132.3244");

        bi.add(bi2);
        bi.subtract(bi2);
        bi.multiply(bi2);
        bi.divide(bi);

        switch (i2){
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println();
        }


        class Funkcje{
            void main(){
                int suma = sumujLiczby(1,2,3,4);

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

        //SORTOWANIE TABLICY OBIEKTOW - klasa Arrays
        KlasaArrays2 ka = new KlasaArrays2(10);
        KlasaArrays2 ka2 = new KlasaArrays2(9);
        KlasaArrays2 ka3 = new KlasaArrays2(12);
        KlasaArrays2[] t = {ka,ka2,ka3};
        Sortuj sort = new Sortuj();
        Arrays.sort(t,sort);
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

        //WYJATKI
        //“checked exceptions” wymagaja obslugi (np IOException)
        // oraz “unchecked exceptions” (np. IllegalArgumentException)
        //Throwable <- Exception <- RuntimeException <- IllegalArgumentException
        //W przypadku gdy wyjatek dziedziczy po Exception a nie ma RuntimeException jest
        //wyjatkiem checked, w kazdym innym przypadku jest typu unchecked

        //Wyjatki mozna obluzyc na 2 sposoby, jeden to poprzez blok try/catch a drugi
        //to zepchniecie go na poziom nizej czyli do metody wywolujacej za pomoca
        //klauzuli throws
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

        Pracownik p1 = new Programista(3000, 230);
        Pracownik[] pracowniks_xD = new Pracownik[2];
        pracowniks_xD[0] = new Programista(4000,400);
        pracowniks_xD[1] = new Programista(6000, 800);

        System.out.println(p1);
        //laczona metoda toString w obu klasach
        //return super.toString()+" "+String.valueOf(linieKodu);
        Programista.pokazInfo((Programista) p1);
        //musze zrzutowac bo metoada PRZYJMUJE OBIEKT a jest on typu Pracownik!
        // a metoda przyjmuje programiste. Musi przyjmowac programiste poniewaz
        // potrzebuje dostac sie do jego pol (linieKodu)
        // jest statyczna wiec wywoluje z nazwa klasy
        Pracownik.pokazInfo(p1); //tylko info o zarobkach

        p1.getZarobki();
        p1.setZarobki(4000);
        ((Programista) p1).getLinieKodu(); //rzutowanie bo metoda unikalna nadlasy
        // a typ jest Pracownika
        ((Programista) p1).setLinieKodu(350);

        Pracownik p2 = new Programista(((Programista)p1)); //kopiuje
        System.out.println("p2: "+p2);

        p2.pracuj(); //metoda interfejsu ktory implementuje klasa abstr. Pracownik
        // ktora rozszerza Programista
        ((Programista) p2).piszKod();//teraz musze wykonac rzutownie
        // poniewaz metoda jest unikalna w programiscie bez deklaracji
        // w klasie nadrzednej/badz interf. ktory implementuje
        //Musze wiec rzutowac jesli wywoluje cos czego nie ma w TYPIE obiektu
        // badz "nizej"

        //equeals / hashcode
        //moge dodac tylko w klasie "najwyzej obiektu i odwolac sie w metodzie equals i
        // hashcode do zmiennych nadklas przez akcesor
        //w equals(this==obj)true, (obj==null||this.getClass()=!obj.getClass())false
        // if(this.zmienna==((Nadklasa)obj).zmienna && this.getZmienna()==
        // ((Nadklasa)obj).getzmienna())return true, else return false
        //Do porownania moge uzyc Double.compare(zmianna, obj.getZmienna2() == 0 // zwroci 0!
        // dla zmiennoprzecinkowych a dla stringow Objects.equals(name, obj.getZmienna2());

        //w hashcode
        // public int hashCode() return Objects.hash(zmienna, getZmiannaNadklasy());
        Pracownik p3 = new Programista(3000,300);
        Pracownik p4 = new Programista(3000,300);
        System.out.println("equals: "+p3.equals(p4));
        System.out.println(p3.hashCode());
        System.out.println(p4.hashCode());
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
        return String.valueOf(zarobki);
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
        return super.toString()+" "+String.valueOf(linieKodu);
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
        if(this.linieKodu == ((Programista)obj).linieKodu && this.getZarobki() ==
                ((Pracownik)obj).getZarobki()) return true;
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