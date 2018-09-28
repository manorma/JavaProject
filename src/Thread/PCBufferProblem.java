package Thread;

import java.util.LinkedList;
import java.util.List;

public class PCBufferProblem {


    public static void main(String[] args) {
        final PC pc = new PC();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static class PC {

        int capacity = 2;
        List<Integer> list = new LinkedList<>();

        private void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (PC.this) {
                    while (list.size() == capacity) {
                        wait();
                    }
                    System.out.println("Producer produced-"
                            + value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }

        }


        private void consume() throws InterruptedException {
            while (true) {

                synchronized (PC.this) {
                    while (list.size() == 0) {
                        System.out.println("Consumer Waiting ");
                        wait();
                    }

                    int val = list.remove(0);
                    System.out.println("Consumer consumed-"
                            + val);
                    notify();
                    Thread.sleep(1000);
                }

            }
        }


    }
}
