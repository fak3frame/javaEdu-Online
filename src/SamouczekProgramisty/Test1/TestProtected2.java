package SamouczekProgramisty.Test1;

public class TestProtected2 extends  TestProtected{

    public final void metodaProt(){

    }

    public static void main(String[] args) {
        TestProtected o = new TestProtected();
        System.out.println(o.zmiennaProt);
        //System.out.println(o.metodaProt());
        System.out.println("---------------");
        TestProtected2 o2 = new TestProtected2();
        o2.metodaProt();

    }
}
