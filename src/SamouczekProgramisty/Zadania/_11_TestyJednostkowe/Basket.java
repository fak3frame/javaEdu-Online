package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import java.util.HashMap;
import java.util.Map;

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

    }
}
