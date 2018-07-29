package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import org.junit.Test;

import static org.junit.Assert.*;

public class GradeBookTest {
    GradeBook gradeBook;
    Subject subject;
    @Test
    public void canAddSubject(){
        gradeBook = new GradeBook(new Subject("Math"));
        assertNotNull(gradeBook);
    }

}