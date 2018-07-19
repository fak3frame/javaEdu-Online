package SamouczekProgramisty.Zadania._8_Enum;

public enum Kalkulator {
    DODAJ{
        @Override
        public double wykonaj(double x, double y) {
            return x+y;
        }
    },
    ODEJMIJ{
        @Override
        public double wykonaj(double x, double y) {
            return x-y;
        }
    },
    POMNOZ{
        @Override
        public double wykonaj(double x, double y) {
            return x*y;
        }
    },
    PODZIEL{
        @Override
        public double wykonaj(double x, double y) {
            return x/y;
        }
    };
    public abstract double wykonaj(double x, double y);
}
