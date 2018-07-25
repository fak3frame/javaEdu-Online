package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

public class KlasaAnonimowa {
    class Robot2{
        private final Powitanie powitanie;
        public Robot2(Powitanie powitanie){
            this.powitanie = powitanie;
        }
        void przywitajSie(){
            powitanie.przywitanie();
        }
    }
    static class RobotStatic{
        private final Powitanie powitanie;
        public RobotStatic(Powitanie powitanie){
            this.powitanie = powitanie;
        }
        void przywitajSieStatic(){
            powitanie.przywitanie();
        }
    }
    public interface Powitanie{
        void przywitanie();
    }

    public static void main(String[] args) {
        KlasaAnonimowa ka = new KlasaAnonimowa();
        KlasaAnonimowa.Robot2 kaw = ka.new Robot2(new Powitanie() {
            @Override
            public void przywitanie() {

            }
        });


    }
}
class inna{
    public static void main(String[] args) {

    }
}

