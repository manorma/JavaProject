package Thread;

public class Singleton {
    private volatile static Singleton instance = null;

    public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null){
                        instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Singleton() {

        System.out.println("Singleton instance is creating");
    }


    public static void main(String[] args) {
//        Thread thread1 = new SingletonThread();
//        Thread thread2 = new SingletonThread();
//        Thread thread3 = new SingletonThread();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        try {
//            thread1.join();
//            thread2.join();
//
//            thread3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        for(int i=0;i<10;i++){
            Thread t = new SingletonThread();
            t.start();
        }
    }
}


class SingletonThread extends Thread {
    @Override
    public void run() {
        Singleton instance = Singleton.getInstance();
    }
}

