package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubjectTest {
    Subject subject;

    @Test
    public void canAddSubject(){
        subject = new Subject("Math");
        assertNotNull(subject);
    }
    @Test
    public void canComputeAverageNote(){
        subject = new Subject("Math");
        subject.addNote(3);
        subject.addNote(5);
        assertEquals(4, subject.getAverage(), 0.001);
    }
}