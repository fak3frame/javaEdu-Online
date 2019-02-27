package Podsumowanie.Wzorce;

public interface BurgerBuilder {
    Burger build();

    BurgerBuilder setMeat(final String meat);
    BurgerBuilder setBread(final String bread);
}
