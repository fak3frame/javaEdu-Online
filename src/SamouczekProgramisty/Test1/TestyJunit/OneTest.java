package SamouczekProgramisty.Test1.TestyJunit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {
    One one;
    @Before
    public void start(){
        one = new One(10,42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void czyWyrzicWyjatekZlychParametrow(){
        new One(20,10);
    }

    @Test
    public void czyWyrzicWyjatekZlychParametrow2(){
        try{
            new One(20,10);
            fail("Wyjatek nie zostal rzucony");
        }
        catch (IllegalArgumentException ex){
            assertEquals("dolny przedzial jest wiekszy niz gorny!",ex.getMessage());
        }
    }

    @Test
    public void czyLiczba12JestWPrzedziale(){
        One o = new One(10,15);
        assertTrue(o.czyJestWPrzedziale(12));
        assertTrue(one.czyJestWPrzedziale(12));
    }


}