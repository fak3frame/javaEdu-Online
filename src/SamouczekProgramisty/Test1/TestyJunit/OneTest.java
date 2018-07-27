package SamouczekProgramisty.Test1.TestyJunit;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneTest {

    @Test
    public void czyLiczba12JestWPrzedziale(){
        One o = new One(10,15);
        assertTrue(o.czyJestWPrzedziale(12));
    }


}