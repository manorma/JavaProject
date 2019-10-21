package practice;



import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class LinkedList {

    private static Node[] mRoot={null,null};


    public class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next =null;
        }
    }

    private Node addNode(int i,int data) {
        Node node = new Node(data);
        Node root = mRoot[i];
        if(root == null){
            mRoot[i] = node;
            return mRoot[i];
        }
        Node curr = root;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
        return mRoot[i];
    }

    private void printList(Node head){
        Node curr = head;
        if(curr == null){
            return;
        }
        while (curr != null){
            System.out.print(curr.data +" ");
            curr = curr.next;
        }
        System.out.println();
    }

    private void countNode(int i){
        Node curr = mRoot[i];
        int count =0;
        while (curr != null){
            curr = curr.next;
            count++;
        }
        System.out.println(count);
    }
    //delete without head pointer
    private Node search(Node head,int num){
        Node cur = head;
        while(cur != null){
            if(cur.data == num){
                return cur;
            }
            cur = cur.next;
        }

        return cur;
    }

    private void delete(Node node_to_del){
        Node next = node_to_del.next;
        node_to_del.data = next.data;
        node_to_del.next = next.next;
    }

    public static void main(String[] args) {
        try {
            LinkedList linkedList = new LinkedList();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            int c =0;
            while (c < t) {
                int n = Integer.parseInt(br.readLine());
                String line = br.readLine();
                //take input data to delete
                int num_to_del = Integer.parseInt(br.readLine());
                String[] arr = line.trim().split(" ");
                if (arr.length > n || arr.length < n) {
                    System.out.println("invalid input");
                }
                for (String a : arr) {
                    linkedList.addNode(c,Integer.parseInt(a));
                }
                //search the num
                Node node = linkedList.search(mRoot[c],num_to_del);
                //delete without head
                linkedList.delete(node);
                //c is list index
                linkedList.printList(mRoot[c]);
                c++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
