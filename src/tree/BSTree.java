package tree;
// The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree.
// In worst case, we may have to travel from root to the deepest leaf node

public class BSTree {
    private Node root;

    private Node insert(Node root,int key){

        if(root == null){
            return new Node(key);
        }

        if(key>root.data){
            root.right = insert(root.right,key);
        }
        else {
            root.left =insert(root.left,key);
        }
        return root;

    }

    private boolean search(Node root,int key){

            if (root!= null && root.data == key) {
                System.out.println("Found key:" + key);
                return true;
            }
            if (key > root.data) {
                return search(root.right, key);
            } else {
                return search(root.left, key);
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



    public static void main(String[] args){
        BSTree bsTree = new BSTree();
        bsTree.root = bsTree.insert(bsTree.root,50);
        bsTree.insert(bsTree.root,30);
        bsTree.insert(bsTree.root,20);
        bsTree.insert(bsTree.root,40);
        bsTree.insert(bsTree.root,70);
        bsTree.insert(bsTree.root,60);
        bsTree.insert(bsTree.root,80);
        bsTree.inorder(bsTree.root);
        if(bsTree.search(bsTree.root,60)){
            System.out.println("Found");
        }
        else {
            System.out.println("Not Found");
        }




    }
}
