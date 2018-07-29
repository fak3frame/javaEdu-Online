package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import java.util.*;

public class Basket {
    Map <Item, Integer> orderedItems = new HashMap<>();

    public void addItem(Item item, int ammount){
        if(ammount<=0)
            throw new IllegalArgumentException("Ammount of prduct must be more than 0");
        orderedItems.put(item, ammount);
    }
    public void removeItem(Item item, int ammount){
        if(!orderedItems.containsKey(item))
            throw new IllegalArgumentException("There is no more that product in basket");

        if(orderedItems.get(item)<ammount){
            throw new IllegalArgumentException("You cant remove ammount of product bigger than in basket");
        }

        if(ammount<=0)
            throw new IllegalArgumentException("You cant remove less than 1 of product");

        int ammountToReplace = orderedItems.get(item) - ammount;
        if(ammountToReplace == 0)
            orderedItems.remove(item);
        else
            orderedItems.replace(item, ammountToReplace);
    }

    public double getOrderPrice(){
        double ammount = 0;
        for(Map.Entry<Item, Integer> x : orderedItems.entrySet()){
            ammount+=x.getValue();
        }
        return ammount;
    }

    public static void main(String[] args) {
        Basket b = new Basket();
        List<Item> items = Arrays.asList(
                new Item("Chair", 20.99),
                new Item("Cell Phone", 200.99),
                new Item("Shoes", 50.99),
                new Item("TV", 999.99)
                );
        for(int i = 0; i<4; i++){
            b.addItem();
        }

        System.out.println(b.getOrderPrice());
    }
}
