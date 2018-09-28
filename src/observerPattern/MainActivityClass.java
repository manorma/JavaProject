package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class MainActivityClass{
    private static UserDataRepository observable;


    public static void main(String[] args){

        observable = UserDataRepository.getInstance();
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                UserDataRepository userDataRepository=(UserDataRepository)o;
                System.out.println("name is:"+userDataRepository.getFullName());
                System.out.println("Age is:"+userDataRepository.getAge());
            }
        });

        new Thread(observable).start();

    }


}
