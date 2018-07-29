package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BasketTest {
    Basket basket;
    Item item;

    @Before
    public void setUp(){
        item = new Item("Toy", 12.99);
        basket = new Basket();
    }
    @Test
    public void canAddOneItemToBasket(){
        basket.addItem(item);
        Map<Item,Integer> map = createOrder(item, 1);
        assertEquals(basket.getOrder(), map);
    }
    @Test
    public void canAddItemsToBasket(){
        basket.addItem(item, 10);
        Map<Item,Integer> map = createOrder(item, 10);
        assertEquals(basket.getOrder(), map);
    }
    @Test
    public void canAddSameItemstoBasket(){
        basket.addItem(item);
        basket.addItem(item, 10);
        Map<Item,Integer> map = createOrder(item, 11);
        assertEquals(basket.getOrder(), map);
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
        basket.addItem(item, 1);
        try{
            basket.removeItem(item, 2);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("You cant remove ammount of product bigger than in basket", ex.getMessage());
        }
        try{
            basket.removeItem(item);
            basket.removeItem(item);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("There is no more that product in basket", ex.getMessage());
        }
    }
    @Test
    public void userCanOnlyRemoveMoreThanZeroOfProductFromBasket(){
        basket.addItem(item, 10);
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
            basket.removeItem(item, 1);
            fail();
        }
        catch(IllegalArgumentException ex){
            assertEquals("There is no more that product in basket", ex.getMessage());
        }
        try{
            basket.removeItem(item);
            fail();
        }
        catch(IllegalArgumentException ex) {
            assertEquals("There is no more that product in basket", ex.getMessage());
        }
    }


    private static Map<Item, Integer> createOrder(Object ... items){
        Map<Item, Integer> map = new HashMap<>();
        for(int i = 0; i<items.length; i+=2){
            Item item = (Item)items[i];
            Integer integer = (Integer)items[i+1];
            map.put(item,integer);
        }
        return map;
    }
}