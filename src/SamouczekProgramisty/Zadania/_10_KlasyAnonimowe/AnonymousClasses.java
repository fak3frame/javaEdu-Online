package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

public class AnonymousClasses {
    public static class Robot{
        private final GreetingModule greetingModule;

        public Robot(GreetingModule greetingModule) {
            this.greetingModule = greetingModule;
        }
        void seySomething(){
            greetingModule.seyHello();
        }
    }

    public static void main(String[] args) {
        Robot jan = new Robot(new GreetingModule() {
            @Override
            public void seyHello() {
                System.out.println("dzien dobry");
            }
        });
        Robot jon = new Robot(new GreetingModule() {
            @Override
            public void seyHello() {
                System.out.println("good morning");
            }
        });
        jan.seySomething();
        jon.seySomething();
    }
}



interface GreetingModule {
    void seyHello();
}
