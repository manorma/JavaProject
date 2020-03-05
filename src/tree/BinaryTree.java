package tree;

import java.util.*;

class Pair {
    Node data;
    int d;

    public Pair(Node data, int d) {
        this.data = data;
        this.d = d;
    }
}

public class BinaryTree {

    private static void leftView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("Left View:\n");
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                if(i == 0) {
                    System.out.print(temp.data + " ");
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

        }
    }
    private static void rightView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> s1 = new Stack<>();
        queue.add(root);
        System.out.println("Right View:\n");
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if(i == n) {
                    System.out.print(temp.data + " ");
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

        }
    }

    private static void topView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while (queue.size() > 0) {
            Node temp = queue.peek().data;
            int hd = queue.peek().d;
            queue.remove();
            if (mp.get(hd) == null) {
                mp.put(hd, temp.data);
            }
            if (temp.left != null) {
                queue.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair(temp.right, hd + 1));
            }
        }
        System.out.print("Top View of Binary Tree\n");
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println("");

    }

    private static void veticalView(Node root) {
        if (root == null) {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        queue.add(new Pair(root, 0));
        while (queue.size() > 0) {
            Node temp = queue.peek().data;
            int hd = queue.peek().d;
            queue.remove();
            if (mp.get(hd) == null) {
                mp.put(hd, temp.data);
            } else {
                mp.put(hd, mp.get(hd) + temp.data);
            }
            if (temp.left != null) {
                queue.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair(temp.right, hd + 1));
            }
        }
        System.out.print("vertical View of Binary Tree\n");
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(14);
       // BinaryTree.topView(root);
        //BinaryTree.veticalView(root);
        BinaryTree.leftView(root);
        BinaryTree.rightView(root);
    }
}
