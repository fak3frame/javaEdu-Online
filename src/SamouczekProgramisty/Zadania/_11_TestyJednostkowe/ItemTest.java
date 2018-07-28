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
            new Item(0, "x");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage());
        }
        try {
            new Item(-1, "x");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage());
        }
    }
    @Test
    public void productHasToHaveAName(){
        try{
            new Item(10,"");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Name of prodct need a name", ex.getMessage());
        }
    }
    @Test
    public void sameProductsHaveToBeEquals(){
        assertEquals(new Item(10, "x"), new Item(10, "x"));
    }
    @Test
    public void productWithSamePriceAndDiffrentNameCantBeEquals(){
        assertNotEquals(new Item(10, "xx"), new Item(10, "x"));
    }
    @Test
    public void productsWithSamePriceAndNameHaveToHaveSameHashCode(){
        assertEquals(new Item(20,"x").hashCode(), new Item(20, "x").hashCode());
    }
    public void productsWithDiffrentPriceOrNameCantHaveSameHashCode(){
        assertNotEquals(new Item(20, "x").hashCode(), new Item(20, "y").hashCode());
        assertNotEquals(new Item(20, "x").hashCode(), new Item(10, "x").hashCode());
    }
}