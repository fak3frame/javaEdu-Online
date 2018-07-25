package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

public class KlasaAnonimowa {
    static class Robot{
        private final Powitanie powitanie;
        public Robot(Powitanie powitanie){
            this.powitanie = powitanie;
        }
        void przywitajSie(){
            powitanie.przywitanie();
        }
    }
    public interface Powitanie{
        void przywitanie();
    }

    public static void main(String[] args) {
        KlasaAnonimowa.Robot o = new KlasaAnonimowa.Robot(new KlasaAnonimowa.Powitanie(){
            @Override
            public void przywitanie() {

            }
        });
    }
}

