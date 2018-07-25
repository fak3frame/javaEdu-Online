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
        //1
        KlasaAnonimowa ka = new KlasaAnonimowa();
        KlasaAnonimowa.Robot2 kaw = ka.new Robot2(new Powitanie() {
            @Override
            public void przywitanie() {
                System.out.println("czesc normalnie");
            }
        });
        kaw.przywitajSie();

        //2
        KlasaAnonimowa.RobotStatic ob = new KlasaAnonimowa.RobotStatic(new KlasaAnonimowa.Powitanie(){
            @Override
            public void przywitanie() {
                System.out.println("czesc statycznie");
            }
        });
        ob.przywitajSieStatic();

        //3
        RobotStatic r2 = new RobotStatic(new Powitanie() {
            @Override
            public void przywitanie() {
                System.out.println("powitanie robot");
            }
        });

    }
}
class inna{
    public static void main(String[] args) {

    }
}

