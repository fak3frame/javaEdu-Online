package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class BasketTest {
    Basket basket;
    Item item;

    @Before
    public void setUp(){
        item = new Item("Toy", 12.99);
        basket = new Basket();
        basket.addItem(item, 10);
    }
    @Test
    public void canAddItemToBasket(){

    }
    @Test
    public void userHaveToAddMinimOneProductAsAmmountToBasket(){
        try{
            basket.addItem(item, 0);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Ammount of prduct must be more than 0",ex.getMessage());
        }
        try{
            basket.addItem(item, -1);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Ammount of prduct must be more than 0", ex.getMessage());
        }
    }
    @Test
    public void userCantRemoveAmmountOfProductBiggerThanAmmountInBasket(){
        try{
            basket.removeItem(item, 11);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("You cant remove ammount of product bigger than in basket", ex.getMessage());
        }
    }
    @Test
    public void userCanOnlyRemoveMoreThanZeroOfProductFromBasket(){
        try{
            basket.removeItem(item, 0);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("You cant remove less than 1 of product", ex.getMessage());
        }
        try{
            basket.removeItem(item, -1);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("You cant remove less than 1 of product", ex.getMessage());
        }
    }
    @Test
    public void userCantRemoveProductFromBasketIfItIsNotThere(){
        try{
            basket.removeItem(item, 10);
            basket.removeItem(item, 10);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertEquals("There is no more that product in basket", ex.getMessage());
        }
    }

    private static Map<Item, Integer> createOrder(Object ... items){
        Map<Item, Integer> map = new TreeMap<>();
        for(int i = 0; i<items.length; i+=2){
            Item item = (Item)items[i];
            Integer integer = (Integer)item[i+1];
            map.put(item,integer);
        }
        return map;
    }
}