package tree;

import java.util.Scanner;


public class Tries {

    static final int MAX_SIZE = 26;

    static TrieNode root;

    static class TrieNode {
        TrieNode[] children = new TrieNode[MAX_SIZE];
        boolean isLastNode;

        TrieNode() {
            this.isLastNode = false;
            for (int i = 0; i < MAX_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    private static void addContact(String contact) {
        TrieNode pCrawl = root;
        for (int i = 0; i < contact.length(); i++) {
            int index = contact.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();

            }
            pCrawl = pCrawl.children[index];

        }
        pCrawl.isLastNode = true;

    }


    private static int findContact(String contact) {
        TrieNode pCrawl = root;
        int index;
        int count=0;
        int len = contact.length();
        for(int i=0;i<len;i++){
            index = contact.charAt(i)-'a';
            if(pCrawl.children[index] == null){
                return 0;
            }
            pCrawl = pCrawl.children[index];
        }


        while(pCrawl != null) {
            int i;
            if(pCrawl.isLastNode){
                count++;
            }
            for( i=0;i<MAX_SIZE;i++){
                if(pCrawl.children[i] != null ){
                    count++;

                }
            }
            pCrawl = pCrawl.children[i];

        }

        return count;

    }

    static void performOperation(String op, String contact) {
        if (root == null) {
            root = new TrieNode();
        }

        if (op.equals("add")) {
            addContact(contact);

        } else {
            int res =findContact(contact);
            System.out.println("count of "+contact +" is " +res);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");
            String op = opContact[0];

            String contact = opContact[1];
            performOperation(op, contact);

        }

        scanner.close();
    }
}
