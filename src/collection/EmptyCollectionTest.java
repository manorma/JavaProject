package collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.ArrayList;

public class EmptyCollectionTest {


        private static void printArray(ArrayList<String> l) {

            for (String li : l) {
                System.out.println(l);
            }

        }



    public static void main(String[] args) {
        ArrayList<String> list = null;
        try {
            printArray(list);
        }
        catch (NullPointerException e){
            System.out.println("Null");
        }


        //list.add("Manorma");
    }
}
