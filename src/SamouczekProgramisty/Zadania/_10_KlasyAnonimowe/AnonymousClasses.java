package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

public class AnonymousClasses {
    public static class Robot{
        private final GreetingModule greetingModule;
        public Robot(GreetingModule greetingModule){
            this.greetingModule = greetingModule;
        }
        public void seySomething(){
            greetingModule.sayHello();
        }
    }
    public interface GreetingModule{
        void sayHello();
    }

    public static void main(String[] args) {
        Robot jan = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("czesc");
            }
        });
        Robot john = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("hello");
            }
        });
        Robot adolf = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("Arrbeit mach frei!");
            }
        });
        jan.seySomething();
        john.seySomething();
        adolf.seySomething();
    }

}
class HansRobot{
    public static void main(String[] args) {
        AnonymousClasses.Robot hanz = new AnonymousClasses.Robot(new AnonymousClasses.GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("gluten morgen");
            }
        });
        hanz.seySomething();
    }
}