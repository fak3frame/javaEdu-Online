import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class toRemember {
    public static void main(String[] args) {
        String liczbaSlownie = Integer.toString(10);

        String str = "132";

        str.trim();
        str.toUpperCase().toLowerCase();
        boolean b1 = str.isEmpty();
        int i1 = str.length();
        char[] t1 = str.toCharArray();

        str.substring(1,2);
        String[] t2 = str.split("1");
        str.replace(""," ");
        boolean b2 = str.matches("");
        int i2 = str.indexOf("1"); i2 = str.lastIndexOf("1");

        boolean b3 = str.equals(str);
        str.concat("123");
        boolean b4 = str.startsWith("1@3");
        boolean b5 = str.endsWith("123");
        boolean b6 = str.contains("123");

        byte[] t3 = str.getBytes();
        int i3 = str.compareTo(str);

        StringBuilder sb = new StringBuilder(12);
        sb.ensureCapacity(13);//z zakresem 16/34/niesk.
        sb.append("123").append("123");
        sb.replace(0,1,"123");
        sb.insert(0, "123");
        sb.reverse();
        sb.delete(0,1);
        int i4 = sb.indexOf("1");
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

        if(1>2){
            try{
                Scanner sc = new Scanner(System.in);
                String nazwa = sc.nextLine();
                int liczba = sc.nextInt();

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String imie = br.readLine();
                int wiek = Integer.parseInt(br.readLine());
            }catch (IOException ex){
                ex.getMessage();
            }catch (NumberFormatException ex){
                ex.getMessage();
            }
        }

        Pracownik p1 = new Programista(3000, 230);
        Pracownik[] pracowniks_xD = new Pracownik[2];
        pracowniks_xD[0] = new Programista(4000,400);
        pracowniks_xD[1] = new Programista(6000, 800);

        System.out.println(p1);
        Programista.pokazInfo((Programista) p1);
        //musze zrzutowac bo przyjmuje obiekt jest typu Pracownik
        // a metoda przyjmuje programiste
        // jest statyczna wiec wywoluje z nazwa klasy
        Pracownik.pokazInfo(p1);

        p1.getZarobki();
        p1.setZarobki(4000);
        ((Programista) p1).getLinieKodu();
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
        System.out.println(p.getZarobki());
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
        // poniewaz inaczej nie bedzie widzial lini kodu
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
    }
    public static void pokazInfo(final Programista p){
        System.out.println(p.getZarobki()+" "+p.linieKodu);
    }
}