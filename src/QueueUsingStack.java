

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingStack {


//    public static class MyQueue<T> {
//        //make enqueue operation costly
//        Stack<T> stackNewestOnTop = new Stack<T>();
//        Stack<T> stackOldestOnTop = new Stack<T>();
//
//        public void enqueue(T value) { // Push onto newest stack
//
//            while(!stackNewestOnTop.empty()){
//                T val = stackNewestOnTop.peek();
//                stackOldestOnTop.push(val);
//                stackNewestOnTop.pop();
//
//            }
//            stackNewestOnTop.push(value);
//            while(!stackOldestOnTop.isEmpty()){
//                stackNewestOnTop.push(stackOldestOnTop.pop());
//            }
//
//
//        }
//
//        public T peek() {
//
//            if(stackNewestOnTop.isEmpty()){
//                System.out.println("Stack Underflow");
//                System.exit(0);
//            }
//            return stackNewestOnTop.peek();
//        }
//
//        public T dequeue() {
//            if(stackNewestOnTop.isEmpty()){
//                System.out.println("Stack Underflow");
//                System.exit(0);
//            }
//            return stackNewestOnTop.pop();
//        }
//    }


    public static class MyQueue<T> {
        //pop operation costly
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);

        }

        public T peek() {

            if(stackOldestOnTop.isEmpty() && stackNewestOnTop.isEmpty()){
                System.out.println("Stack Underflow");
                System.exit(0);
            }
            if(stackOldestOnTop.isEmpty()){
                while (!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }

            }
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()){
                System.out.println("Stack underflow");
                System.exit(0);
            }
            //if stack old is empty,move all element from stack1 to stack2
            if(stackOldestOnTop.isEmpty()){
                while (!stackNewestOnTop.isEmpty()){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }

            }

            return stackOldestOnTop.pop();
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
