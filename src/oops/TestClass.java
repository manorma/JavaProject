package oops;

//parent class can hold the refernce of subclass , but subclass canot hold the refernece of parent class
// static method can be override

abstract class Shape{
    int x;
    Shape(int x){
        System.out.println("Shape constructor");
        this.x = x;
    }
    abstract void getArea();

    public static void display(){
        System.out.print("Shape");
    }

}

class Rectangle extends Shape{
    int y;
    Rectangle(int x,int y){
        super(x);
        //super(x);
        System.out.println("Rectangle constructor");
        this.y = y;
    }


    @Override
    public void getArea() {
        System.out.println("Rectangle getArea "+x*y);
    }

    public int getArea(int x){
        System.out.println("Rectangle getArea "+this.x*x);
        return this.x*x;
    }



    public static void getClassName(){
        System.out.print("Rectangle");
    }

}

class Triangle extends Rectangle{
    int z;
    Triangle(int x,int y,int z){
        super(x,y);
        this.z = z;
    }

    @Override
    public void getArea() {
        super.getArea();
        System.out.println("Triangle getArea "+this.x*this.y*this.z);
    }

//    public static void display(){
//        System.out.print("Shape");
//    }
//    public static void display(int y,int z){
//        System.out.print("Shape");
//    }

    public static void getClassName(){
        System.out.print("Triangle");

    }


}

public class TestClass {



    public static void main(String[] args){
        Rectangle s = new Rectangle(3,5);
        s.getArea();
        s.getArea(6);
        Triangle t = new Triangle(3,5,6);
        t.getArea();
        Triangle.getClassName();

    }

}
