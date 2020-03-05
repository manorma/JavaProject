package practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left;
    Node right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class HeightTree {

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){

            }
        }catch (IOException e){
            System.out.println("Exception : "+e);
        }

    }
}
