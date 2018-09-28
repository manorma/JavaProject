package Thread;
//creating thread using extend thread ,we can't extend other class,as java doesn't support multi inheritance.
//We can achieve basic functionality of a thread by extending Thread class because it provides some inbuilt methods like yield(), interrupt() etc. that are not available in Runnable interface.

class MultiThread extends Thread {
    @Override

    public void run() {
        try {
            System.out.println("Thread 1 " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }


    }
}

//creating thread using implement runnable ,can't use method like yield and
class MultiThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread 2"+Thread.currentThread().getId() + " is running");
    }


}
public class ThreadExample {

    public static void main(String[] args){

        int num = 4;
        for(int i=0;i<4;i++){
            //MultiThread t = new MultiThread();
            Thread t = new Thread(new MultiThread2());
            t.start();
        }
    }
}
