package Thread;
//if not join thread,main thread exit ,won't wait fo rother thread
public class ThreadJoinDemo implements Runnable {


    Thread t;
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println(Thread.currentThread().getName()
                    + "  " + i);
            try
            {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            }

            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Thread t1 = new Thread(new ThreadJoinDemo());
        Thread t2 = new Thread(new ThreadJoinDemo());
        Thread t3 = new Thread(new ThreadJoinDemo());


        // start thread t1
        t1.start();
        t2.start();
        t3.start();
        //wait current thread to wait untill thread 1 finish its execution.
        //t1.join();



        // start 2nd thread
        //t2.join();
        System.out.println("Thread1 is alive: "
                + t1.isAlive());
        System.out.println("Thread2 is alive: "
                + t2.isAlive());
        System.out.println("Thread3 is alive: "
                + t3.isAlive());
        //t2.join();
    }
}
