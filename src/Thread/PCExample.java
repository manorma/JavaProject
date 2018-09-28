package Thread;

import java.util.Scanner;

public class PCExample {

    public static class Producer extends Thread{
        final PC pc;
        Producer(PC pc){
           this.pc= pc;
        }
        @Override
        public void run() {
            synchronized (pc) {
                pc.produce();
            }
        }
    }
    public static class Consumer extends Thread{
        final PC pc;
        Consumer(PC pc){
            this.pc= pc;
        }
        @Override
        public void run() {
            synchronized (pc) {
                pc.consume();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();
        PCExample pcExample = new PCExample();
        Thread t1 = new Producer(pc);
        Thread t2 = new Producer(pc);
        Thread t3 = new Consumer(pc);
        Thread t4 = new Consumer(pc);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();

        t2.join();
        t3.join();
        t4.join();


    }


    public static class PC {

        private void produce() {

            synchronized(this){
                try {
                    System.out.println("producer thread running"+Thread.currentThread().getName());
                    wait();
                    System.out.println("  Resumed ");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


        private void consume() {

            Scanner s = new Scanner(System.in);

            // synchronized block ensures only one thread
            // running at a time.
            synchronized(this)
            {
                System.out.println("Waiting for return key."+Thread.currentThread().getName());
                s.nextLine();
                System.out.println("Return key pressed");

                // notifies the produce thread that it
                // can wake up.
                notifyAll();


                // Sleep
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
