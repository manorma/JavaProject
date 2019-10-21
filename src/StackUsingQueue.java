import java.util.LinkedList;
import java.util.Observer;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueue  {

    private static class MyStack<T> {

        int curr_size;
        Queue<T> queue1 = new LinkedList<T>();
        Queue<T> queue2 = new LinkedList<T>();

        private void pop() {
            if(queue1.isEmpty()){
                return;
            }
            while (queue1.size()>1){
                queue2.add(queue1.peek());
                queue1.remove();
            }
           queue1.remove();
            curr_size--;
            Queue<T> queue = queue1;
            queue1 = queue2;
            queue2 = queue;
        }

        private void push(T data) {
            queue1.add(data);
            curr_size++;

        }

        private T top() {

            while (queue1.size()>1){
                queue2.add(queue1.peek());
                queue1.remove();
            }
            //get last element
            T temp = queue1.peek();
            queue1.remove();
            //add last element in queu2
            queue2.add(temp);
            //swap queue name
            Queue<T> queue = queue1;
            queue1= queue2;
            queue2 = queue;
            return temp;
        }

        private int size(){
            return curr_size;
        }


    }



    public static void main(String[] args){
        MyStack<Integer> myStack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);
        int numOfOperation = scanner.nextInt();
        for(int i=0;i<numOfOperation;i++){
            int op = scanner.nextInt();
            if(op == 1){
                int num = scanner.nextInt();
                myStack.push(num);
            }
            else if(op == 2){
                myStack.pop();
            }
            else if(op == 3){
                System.out.println("top element is:"+myStack.top());
            }
            else if(op == 4){
                System.out.println("current stack size is:"+myStack.size());
            }
        }

    }
}
