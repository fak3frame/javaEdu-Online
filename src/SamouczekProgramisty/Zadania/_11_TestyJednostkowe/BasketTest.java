package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    @Test
    public void userHaveToAddMinimOneProductAsAmmountToBasket(){
        try{
            new Basket(Item, 0);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Ammount of prduct must be more than 0",ex.getMessage());
        }
        try{
            new Basket(Item, -1);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Ammount of prduct must be more than 0", ex.getMessage());
        }
    }
    @Test
    public void userCantRemoveAmmountOfProductBiggerThanAmmountInBasket(){
        try{

        }
    }
}