package SamouczekProgramisty.Zadania._11_TestyJednostkowe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    Basket basket;
    Item item;

    @Before
    public void setUp(){
        basket = new Basket(new Item(100,"celphone"), 10);
    }
    @Test
    public void

}