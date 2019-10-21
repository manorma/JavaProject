package tree;

import sun.awt.AppContext;

public class OverrideTest {



    public static void main(String[] args) {
        A a = new B();
        a.print();
        B b= new B();
        b.print();



    }
}

class A{
    public void print(){
        System.out.println("In class A");
    }
}

class B extends A{
    @Override
    public void print() {
        super.print();
        System.out.println("In class B");
    }
}
