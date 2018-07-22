package SamouczekProgramisty.Zadania._10_KlasyAnonimowe;

public class AnonymousClasses {



    public static class Robot{
        private final GreetingModule greetingModule;

        public Robot(GreetingModule greetingModule) {
            this.greetingModule = greetingModule;
        }
    }
}



interface GreetingModule {
    void seyHello();
}
