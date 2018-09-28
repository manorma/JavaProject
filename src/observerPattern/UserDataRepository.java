package observerPattern;


import java.util.Observable;
import java.util.Scanner;
import java.util.logging.Handler;

public class UserDataRepository extends Observable implements Runnable{

    private String mFullName;
    private int mAge;
    private static UserDataRepository instance = null;



    public static UserDataRepository getInstance(){
        if(instance == null){
            System.out.println("Createing object");
            instance = new UserDataRepository();
        }
        return instance;
    }

    private void setUserData(String fullName,int age){
        mFullName = fullName;
        mAge = age;
        setChanged();
        notifyObservers();

    }

    public String getFullName(){
        return mFullName;
    }
    public int getAge(){
        return mAge;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Enter name and age");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            if("exit".equals(name)){
                System.exit(0);
            }
            int age = scanner.nextInt();
            setUserData(name, age);
        }

    }
}
