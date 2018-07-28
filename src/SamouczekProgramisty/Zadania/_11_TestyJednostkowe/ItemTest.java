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
    private void isPriceIsBggerThanZero(){
        try{
            item = new Item(0, "x");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage());
        }
        try {
            item = new Item(-1, "x");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Price cant be less than 1", ex.getMessage();
        }
    }

}