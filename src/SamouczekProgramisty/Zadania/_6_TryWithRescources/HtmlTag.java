package SamouczekProgramisty.Zadania._6_TryWithRescources;

public class HtmlTag implements AutoCloseable{
    String s;
    static int zmiennaStatic;
    int zmiennaInt;
    public HtmlTag(String s){
        this.s = s;
        System.out.println("<"+s+">");
    }
    public void body(String s){
        System.out.println(s);
    }
    @Override
    public void close() {
        System.out.println("</"+s+">");
    }
}
