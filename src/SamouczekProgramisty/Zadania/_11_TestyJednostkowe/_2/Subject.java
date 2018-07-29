package SamouczekProgramisty.Zadania._11_TestyJednostkowe._2;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Integer> grades = new ArrayList<>();
    public Subject(String name){
        this.name = name;
    }
    public void addNote(int note){
        grades.add(note);
    }
    public double getAverage(){
        int summary = 0;
        for(int i=0; i<grades.size(); i++){
            summary+=grades.get(i);
        }
        return summary/grades.size();
    }
}
