package list;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedList {
    private Node root = null;

    //add node at head
    private void addNode(int data) {
        Node temp = new Node(data);
        temp.next = root;
        root = temp;
    }

    //add node at back

    private Node addNodeAtBack(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return root;
        }
        Node curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        return root;
    }

    private void inserAfter(Node prevNode, int data) {
        Node node = new Node(data);
        if (prevNode == null) {
            System.out.println("prev node can not be null");
            return;
        }

        node.next = prevNode.next;
        prevNode.next = node;
        return;
    }

    private void printList() {
        Node curr = root;
        while (curr != null) {
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
    }

    private void deleteNode(int data) {
        Node curr = root;
        Node prev = null;

        if (curr != null && curr.data == data) {
            root = curr.next;
            return;
        }

        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }

        prev.next = curr.next;

        return;
    }

    //reverse linked list
    private void reverseList(){
        Node temp = root,curr,prev=null;
        while(temp != null){
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
            //curr = temp;

        }

        root = prev;
    }

    //find middle of linked list

    private int findMiddle(){
        Node slow = root,fast = root;
        while(fast != null && fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow.data;
    }

    //pairwise swap pf linked list
    private void pairWiseSwap(){
        if(root == null || root.next == null){
            return;
        }
        Node fast= root.next;
        Node slow = root;
        while(slow!= null && fast != null){
            int temp = fast.data;
            fast.data = slow.data;
            slow.data = temp;
            slow = fast.next;
            if(fast.next != null) {
                fast = fast.next.next;
            }
        }
    }

    //print nth node in linked list
    private void printNthNode(int index){
        int i =0;
        Node curr = root;
        while(i< index-1 && curr != null){
            curr = curr.next;
            i++;
        }
        if(curr == null){
            System.out.println("index is out of bound");
        }
        else {
            System.out.println("Nth node is :"+curr.data);
        }

    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(4);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNodeAtBack(5);
        linkedList.inserAfter(linkedList.root.next.next, 1);
        linkedList.addNodeAtBack(6);
        linkedList.printList();
//        linkedList.deleteNode(3);
//        linkedList.deleteNode(1);
        //System.out.println("Reverse LinkedList");
        //linkedList.reverseList();
        //linkedList.pairWiseSwap();
        //linkedList.printList();
        linkedList.printNthNode(6);
        System.out.println("Middle Element "+linkedList.findMiddle());

    }
}
