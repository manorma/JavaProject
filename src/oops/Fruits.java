package oops;

public class Fruits {
    private int val1;
    private int val2;
    Fruits(int val1,int val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2() {
        return val2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;

        }
        if(obj.getClass() == this.getClass()){
            return ((Fruits)obj).val1 == this.val1 && ((Fruits)obj).val2 == this.val2;
        }
        return false;
    }

    public static void main(String[] args){
        Fruits f1 = new Fruits(2,3);
        Fruits f2 = new Fruits(2,3);
        System.out.println(f1.equals(f2));
    }
}
