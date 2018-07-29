package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

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
            Subject s = new Subject(Subject)
            gradeBookWithSubject.addSubject(s);
            fail();
        }
        catch (IllegalArgumentException ex){
            assertEquals("Subject is in GradeBook", ex.getMessage());
        }
    }
    @Test
    public void canGetSubjectFromGradeBook(){
        Subject s = gradeBookWithSubject.getSubject(SUBJECT);
        assertEquals(SUBJECT, s.getName());
    }
    @Test
    public void canAddNoteToSubject(){
        gradeBookWithSubject.addNote(SUBJECT, 2);

    }
    public void canGet

}