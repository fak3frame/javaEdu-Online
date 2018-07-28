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
    private void isPriceBggerThanZero(){
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
    @Test
    private void doesTheProductHaveAName(){
        try{
            item = new Item(10,"");
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Name of prodct need a name", ex.getMessage());
        }
    }



}