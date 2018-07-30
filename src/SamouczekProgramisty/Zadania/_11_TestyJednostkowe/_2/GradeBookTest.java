package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import org.junit.Before;
import org.junit.Test;

import java.beans.Transient;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
            Subject s = new Subject(SUBJECT)
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
        Subject s = gradeBookWithSubject.getSubject(SUBJECT);
        assertEquals(new Integer(2), s.getGrades().get(0));
    }
    @Test
    public void canGetNotesFromGradeBook(){
        gradeBookWithSubject.addNote(SUBJECT, 2);
        gradeBookWithSubject.addNote(SUBJECT, 3);
        List<Integer> l1 = Arrays.asList(2,3);
        List<Integer> l2 = gradeBookWithSubject.getNotes(SUBJECT);
        for(int i=0; i<2; i++){
            assertEquals(l1.get(i),l2.get(i));
        }
    }
    @Test
    public void canGetAverageNodesFromSubject(){
        gradeBookWithSubject.addNote(SUBJECT, 2);
        gradeBookWithSubject.addNote(SUBJECT, 4);
        Subject s = gradeBookWithSubject.getSubject(SUBJECT);
        double average = s.getAverage();
        assertEquals(3.0, average, 0.001);
    }
    @Test void canGetAverageNodesFromGradeBook(){
        gradeBookWithSubject.addNote(SUBJECT, 4);
        gradeBookWithSubject.addSubject(SUBJECT2);
        gradeBookWithSubject.addNote(SUBJECT2, 6);
    }
}
///