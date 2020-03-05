package collection;

import javax.lang.model.element.Element;
import java.util.*;

public class CollectionTest {
    String name;
    int count;
    CollectionTest(){

    }



    public static void main(String[] args){

        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("Geeks");
        treeSet.add("for");
        treeSet.add("Geeks");
        treeSet.add("GeeksforGeeks");

        for (String temp : treeSet)
            System.out.printf(temp + " ");

        System.out.println("\n");
        /*

        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add(2);
        list.add("D");
        list.add("E");
        //Only forward direction iterating is possible.
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        //can be used to iterate backward or forward ,applicable only for list implement classes,not universal iterate
        ListIterator iterator1 = list.listIterator();
        while (iterator1.hasNext()){

            System.out.print(iterator1.next()+" ");
        }
        while (iterator1.hasPrevious()){
            System.out.print(iterator1.previous()+" ");
        }
        System.out.println();

        //vector is same as arraylist ,only difference is ,vector is thread-safe .vector allocate double memory on adding extra elemnt than vector capacity.by default vector capacity is 10.
        Vector v = new Vector();
        v.add("M");
        v.add("A");
        v.add(1);
        v.add("N");
        v.add(2);
        v.add(4);
        v.add(5);
        v.add(1);
        v.add(2);
        v.add(1);
        v.add(3);
        Iterator i = v.iterator();
        Enumeration e  = v.elements();
        System.out.println("capacity is "+v.size() +" "+v.capacity());
        System.out.println("Vector iteration");
        while (i.hasNext()){
            System.out.print(i.next()+" ");
        }

        System.out.println("For Each iteration");
        //for each loop is meant to traverse item in collection.In for-each loop, we can’t modify collection, it will throw a ConcurrentModificationException on the other hand with iterator we can modify collection.
        //Traversing a collection using for-each loops or iterators give the same performance
        //If you iterate using the old styled C for loop then we might increase the time complexity drastically.
        //For linkedlist iteration ,we should use the for each loop instead of old styled for loop ,it might increase the time complexity.
        List<Integer> l= new LinkedList<>();
        l.add(1);
        l.add(2);
        for (int i1:l){
            System.out.print(i1);
        }
        System.out.println();

        CollectionTest cl = new CollectionTest();
        cl.name ="manorma";
        System.out.println("name is "+cl.name+"count:"+cl.count);
        */


    }
}
