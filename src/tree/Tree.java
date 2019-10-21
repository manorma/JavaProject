package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data =data;
        left =right= null;
    }
}
public class Tree {
    private Node root;
    private Node prev =null;
    private PrevLevel prevLevel = new PrevLevel();

    private boolean isBST(){
        //return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return isBST(root);

    }

    private boolean isBSTUtil(Node root,int min,int max){
        if(root == null){
            return true;
        }

        if(root.data < min && root.data>max){
            return false;
        }
        return (isBSTUtil(root.left,min,root.data-1) && isBSTUtil(root.right,root.data+1,max));

    }

    private boolean isBST(Node root){
        //empty tree is BST
        if(root != null){
            if(!isBST(root.left)){
                return false;
            }
            //if prev node data is greater than current node data
            if(prev != null && prev.data >= root.data){
                return false;
            }
            prev = root;
            return isBST(root.right);

            }

        return true;

    }

    private int height(Node root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(l>r){
            return l+1;
        }else {
            return r+1;
        }
    }

    private void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }

    private void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }

    private void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data+" ");

    }

    //inorder traversal without recustion

    private void inorderUsingStack(Node root){
        if(root == null){
            return;
        }
        Node current = root;
        Stack<Node> stack = new Stack<>();

        while(current != null  || stack.size()>0){
            while(current != null){
                stack.push(current);
                current = current.left;

            }

                current = stack.pop();
                System.out.println(current.data +" ");
                current = current.right;


        }


    }

    private int[][] convertArrrayListToArray(ArrayList<ArrayList<Integer>> arrayList){
        int s = arrayList.size();
        int[][] ret = new int[s][];
        Iterator<ArrayList<Integer>> iterator1 = arrayList.listIterator();
        int j=0;
        while (iterator1.hasNext()){
            ArrayList<Integer> innerList = iterator1.next();
            Iterator<Integer> iterator2 = innerList.listIterator();
            int ins = innerList.size();
            int[] innerArray = new int[ins];
            int i=0;
            while (iterator2.hasNext()){
                innerArray[i] = iterator2.next();
                i++;
            }
            ret[j] = innerArray;
            j++;
        }
        return ret;
    }

    //print spiral
    private int[][] printSpiral(Node root){
//        if(root == null){
//            return;
//        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            ArrayList<Integer> temp1 = new ArrayList<>();
            while(!s1.isEmpty()){
                Node top = s1.peek();
                s1.pop();
                temp1.add(top.data);
                //System.out.println(top.data+" ");
                if(top.left != null){
                    s2.push(top.left);
                }
                if(top.right != null){
                    s2.push(top.right);
                }

            }
            result.add(temp1);
            //System.out.print(temp1);
            ArrayList<Integer> temp2 = new ArrayList<>();
            while(!s2.isEmpty()){
                Node top = s2.peek();
                s2.pop();
                temp2.add(top.data);
                //System.out.println(top.data+" ");
                if(top.right != null){
                    s1.push(top.right);
                }
                if(top.left != null){
                    s1.push(top.left);
                }

            }
            result.add(temp2);
            //System.out.print(temp2);
        }
        //System.out.print(result);
        return convertArrrayListToArray(result);


    }
    // check tree is mirror of itself or other tree
    private boolean isMirror(Node root1,Node root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 != null && root2 != null && root1.data == root2.data){
            return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);

        }
        return false;
    }

    private boolean isSymmetric(Node root){
        return isMirror(root,root);
    }


    // left view of tree

    private void leftView(Node root){
        leftViewUtil(root,prevLevel,1);
    }


    private void leftViewUtil(Node root,PrevLevel prev_level,int level){
        if(root == null){
            return;
        }
        if(level > prev_level.prev_level){
            System.out.print(root.data +" ");
            prev_level.prev_level = level;
        }
        leftViewUtil(root.left,prev_level,level+1);
        leftViewUtil(root.right,prev_level,level+1);

    }


    //right view of tree

    private void rightView(Node root){
        rightViewUtil(root,prevLevel,1);
    }


    private void rightViewUtil(Node root,PrevLevel prev_level,int level){
        if(root == null){
            return;
        }
        if(level > prev_level.prev_level){
            System.out.print(root.data +" ");
            prev_level.prev_level = level;
        }
        rightViewUtil(root.right,prev_level,level+1);
        rightViewUtil(root.left,prev_level,level+1);

    }
    class PrevLevel{
        int prev_level;
    }
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right=  new Node(3);
        tree.root.right.left=new Node(5);
        tree.root.right.right = new Node(7);

        //for symmetric tree
//        tree.root = new Node(1);
//        tree.root.left =new Node(2);
//        tree.root.right = new Node(2);
//        tree.root.left.left = new Node(3);
//        tree.root.left.right = new Node(3);
//        tree.root.right.left = new Node(4);
//        tree.root.right.right = new Node(3);
        //System.out.println("is symmetric "+tree.isSymmetric(tree.root));



        //System.out.println("height of tree is "+tree.height(tree.root));
        System.out.println("Spiral Form : ");
        int[][] res = tree.printSpiral(tree.root);
        for(int i = 0;i<res.length ;i ++){
            for(int j =0;j<res[i].length;j++){
                System.out.print(res[i][j]);
            }
            System.out.print("\n");
        }
        //System.out.print(tree.printSpiral(tree.root));
  //      System.out.println("inorder of tree:\n");

 //       tree.inorderUsingStack(tree.root);
//        System.out.println("preorder of tree:\n");
//        tree.preorder(tree.root);
//        System.out.println("inorder of tree:\n");
//        tree.inorder(tree.root);
//        System.out.println("postorder of tree:\n");
//        tree.postorder(tree.root);

//        System.out.println("Left view of tree: ");
//        tree.leftView(tree.root);
//        tree.prevLevel.prev_level = 0;
//        System.out.println("Right View of tree: ");
//        tree.rightView(tree.root);
//        if(tree.isBST()) {
//            System.out.println("is BST");
//        }
//        else {
//            System.out.println("is not BST");
//        }


    }
}
