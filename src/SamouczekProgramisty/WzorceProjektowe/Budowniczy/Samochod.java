package SamouczekProgramisty.WzorceProjektowe.Budowniczy;

public class Samochod{
    private String marka;
    private int moc;
    private String kolor;


    private Samochod(Budowniczy budowniczy){
        this.marka = budowniczy.marka;
        this.moc = budowniczy.moc;
        this.kolor = budowniczy.kolor;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", moc=" + moc +
                ", kolor='" + kolor + '\'' +
                '}';
    }

    public static class Budowniczy{
        private final String marka;
        private int moc;
        private String kolor;
        public Budowniczy(final String marka){
            this.marka = marka;
        }
        public Budowniczy moc(final int moc){
            this.moc = moc;
            return this;
        }
        public Budowniczy kolor(final String kolor){
            this.kolor = kolor;
            return this;
        }

        public Samochod buduj(){
            return new Samochod(this);
        }

    }
}
