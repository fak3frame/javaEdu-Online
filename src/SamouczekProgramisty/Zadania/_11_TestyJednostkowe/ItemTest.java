package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;

    @Test
    public void priceShouldBeBiggerThanZero(){
        try{
            new Item("x", 0);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage());
        }
        try {
            new Item("x", -1);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage());
        }
    }
    @Test
    public void productHasToHaveAName(){
        try{
            new Item("",10);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Name of prodct need a name", ex.getMessage());
        }
    }
    @Test
    public void sameProductsHaveToBeEquals(){
        assertEquals(new Item("x", 10), new Item("x", 10));
    }
    @Test
    public void productWithSamePriceAndDiffrentNameCantBeEquals(){
        assertNotEquals(new Item("xx", 10), new Item("x", 10));
    }
    @Test
    public void productsWithSamePriceAndNameHaveToHaveSameHashCode(){
        assertEquals(new Item("x",20).hashCode(), new Item("x", 20).hashCode());
    }
    public void productsWithDiffrentPriceOrNameCantHaveSameHashCode(){
        assertNotEquals(new Item("x", 20).hashCode(), new Item("y", 20).hashCode());
        assertNotEquals(new Item("x", 20).hashCode(), new Item("x", 10).hashCode());
    }
}