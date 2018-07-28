package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import java.util.Objects;

public class Item {
    private double price;
    private String name;

    public Item(double price, String name) {
        if (price <= 0)
            throw new IllegalArgumentException("Price cant be less than 1");
        else if(name.length()<=0)
            throw new IllegalArgumentException("Name of prodct need a name");
        this.price = price;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Item) {
            Item tmp = (Item) obj;
            return Double.compare(this.price, tmp.price) == 0
                    && this.name.equals(tmp.name);
        } else
            return false;
    }
}