package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    Basket basket;
    Item item;

    @Before
    public void setUp(){
        item = new Item(12.33, "Toy");
        basket = new Basket();
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
            new Basket(item, 10);
        }
    }
}