package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item;
    @BeforeClass
    private void setUp(){
        item = new Item(100, "cell Phone");
    }
    @Test
    private void priceShouldBeBiggerThanZero(){
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
            assertEquals("Price cant be less than 1", ex.getMessage();
        }
    }
    @Test
    private void productHasToHaveAName(){
        try{
            new Item(10,"");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Name of prodct need a name", ex.getMessage());
        }
    }
    @Test
    private void sameProductsHaveToBeEquals(){
        assertEquals(new Item(10, "x"), new Item(10, "x"));
    }
    @Test void productWithSamePriceAndDiffrentNameCantBeEquals(){
        assertNotEquals(new Item(10, "xx"), new Item(10, "x"));
    }





}