package Podsumowanie.Wzorce;

class Burger {
    private String meat = null;
    private String bread = null;

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "meat='" + meat + '\'' +
                ", bread='" + bread + '\'' +
                '}';
    }
}

class BurgerBuilderImp implements BurgerBuilder{

    private Burger burger;

    @Override
    public Burger build() {
        return burger;
    }

    public BurgerBuilderImp() {
        burger = new Burger();
    }

    @Override
    public BurgerBuilder setMeat(String meat) {
        burger.setMeat(meat);
        return this;
    }

    @Override
    public BurgerBuilder setBread(String bread) {
        burger.setBread(bread);
        return this;
    }
}

class Build{
    public static void main(String[] args) {
        BurgerBuilder builder = new BurgerBuilderImp();

        builder.setBread("white");
        builder.setMeat("chucken");

        Burger rdy = builder.build();

        System.out.println(rdy.toString());
    }
}
