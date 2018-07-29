package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import java.util.*;

public class Basket {
    Map <Item, Integer> orderedItems = new HashMap<>();

    public void addItem(Item item, int ammount){
        if(ammount<=0)
            throw new IllegalArgumentException("Ammount of prduct must be more than 0");
        if(orderedItems.containsKey(item)){
            int newAmmount = orderedItems.get(item);
            orderedItems.replace(item,newAmmount+ammount);
        }
        else
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
        System.out.println();
        for(Map.Entry<Item, Integer> x : orderedItems.entrySet()){
            ammount+=x.getKey().getPrice()*x.getValue();
        }
        return ammount;
    }

    @Override
    public String toString() {
        StringBuilder toShow = new StringBuilder();
        for(Map.Entry<Item,Integer> x : orderedItems.entrySet()){
            toShow.append("item: "+x.getKey().getName()+
                    " price: "+x.getKey().getPrice()+
                    " ammount: "+x.getValue()+"\n");
        }
        return toShow.toString();
    }
    public Map<Item, Integer> getOrder() {
        return Collections.unmodifiableMap(orderedItems);
    }

    public static void main(String[] args) {
        Basket b = new Basket();
        List<Item> items = Arrays.asList(
                new Item("Chair", 100),
                new Item("Cell Phone", 300),
                new Item("Shoes", 50),
                new Item("TV", 2000)
                );
                //2450
        for(int i = 0; i<4; i++){
            b.addItem(items.get(i),1);
        }
        Item book = new Item ("Book", 30);
        b.addItem(book,7);//210 = 2660
        b.removeItem(book, 1);//-30 = 2630

        b.addItem(book,1);//+30 = 2660

        System.out.println();
        System.out.println(b);

        System.out.println("Summary price");
        System.out.println(b.getOrderPrice());
    }
}
