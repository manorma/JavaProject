import java.nio.channels.Pipe;

public class RectangleOverlap {
    private static class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2){
        //one rectangle left of another rectangle
        if(l2.x > r1.x && l1.x > r2.x){
            return false;
        }
        //if one rectangle r2 lies above another r1,return false
        if(r2.y > l1.y && l2.y<r1.y){
            return false;
        }
        return true;

    }
    public static void main(String[] args){
        Point l1 = new Point(0,10);
        Point r1 = new Point(10,0);
        Point l2 = new Point(5,5);
        Point r2 = new Point(15,0);
        if(doOverlap(l1,r1,l2,r2)){
            System.out.println("Rectangle Overlap");
        }
        else {
            System.out.println("Rectangle not overlap");
        }


    }
}
