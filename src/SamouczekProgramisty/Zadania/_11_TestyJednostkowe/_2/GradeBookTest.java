package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;

import static org.junit.Assert.*;

public class GradeBookTest {
    private final String SUBJECT = "Math";
    private final String SUBJECT2 = "Physics";

    GradeBook gradeBookWithSubject;

    @Before
    public void setUp(){
        gradeBookWithSubject = new GradeBook();
        gradeBookWithSubject.addSubject(SUBJECT);
    }

    @Test
    public void canCreateGradeBook(){
        GradeBook gradeBook = new GradeBook();
        assertNotNull(gradeBook);
    }
    @Test
    public void canAddSubjectToGradeBook(){
        GradeBook gradeBook = new GradeBook();
        gradeBook.addSubject(SUBJECT);
    }
    @Test
    public void cantAddExistingSubjectToGradeBook(){
        try{
            gradeBookWithSubject.addSubject(SUBJECT);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Subject is in GradeBook", ex.getMessage());
        }
    }
    @Test
    public void canGetSubjectFromGradeBook(){

    }

}