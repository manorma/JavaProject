package greedy;

import java.util.*;

class MyComparator implements Comparator<HuffmanCode.HuffmanNode>{

    @Override
    public int compare(HuffmanCode.HuffmanNode o1, HuffmanCode.HuffmanNode o2) {
        return o1.data - o2.data;
    }

}

public class HuffmanCode {

    Map<Character,Integer> freq = new HashMap<>();
    Map<Character,String> code = new HashMap<>();
    String encodeStr ="";

    class HuffmanNode{
        int data;
        char c;

        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(char c,int d){
            this.c =c;
            this.data = d;
            left = right = null;
        }
        HuffmanNode(){

        }
    }


    public void calculateFreq(String str){
        char[] s = str.toCharArray();
        for(int i=0;i<s.length;i++){
            if(freq.containsKey(s[i])){
                int c = freq.get(s[i]);
                freq.put(s[i],c+1);
            }
            else {
                freq.put(s[i],1);
            }

        }
    }
    private void storeCode(HuffmanNode root,String s){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && Character.isLetter(root.c)){
            code.put(root.c,s);
            return;
        }
        storeCode(root.left,s+'0');
        storeCode(root.right,s+'1');

    }
    private void printCode(HuffmanNode root,String s){
        for(Map.Entry<Character,String> m : code.entrySet()){
            System.out.println(m.getKey()+ " " +m.getValue());
        }

    }
    private String  getEncodedString(String s){
        String encode ="";
        char[] str = s.toCharArray();
        for(int i =0 ;i< str.length ;i++){
            encode += code.get(str[i]);
        }

        return encode;
    }

    private HuffmanNode buildMinHeapTree(String s){

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(s.length(),new MyComparator());
        char[] str = s.toCharArray();

        for(int i =0;i< str.length;i++){
            HuffmanNode node = new HuffmanNode(str[i],freq.get(str[i]));
            node.left =node.right =null;
            q.add(node);
        }
        HuffmanNode node = null;
        while (q.size() > 1){
            HuffmanNode left = q.peek();
            q.poll();
            HuffmanNode right = q.peek();
            q.poll();

            HuffmanNode top = new HuffmanNode();
            top.data = left.data+right.data;
            top.c = '-';

            top.left = left;
            top.right = right;
            node = top;
            q.add(top);
        }
        return node;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HuffmanCode ob = new HuffmanCode();
        ob.calculateFreq(str);
        for (Map.Entry<Character,Integer> v : ob.freq.entrySet() ){
            System.out.println("Char is:" +v.getKey() +"Val : " +v.getValue());
        }
        HuffmanNode root =ob.buildMinHeapTree(str);
        ob.storeCode(root,"");
        ob.printCode(root,"");
        System.out.println("Encoded String : "+ob.getEncodedString(str));

    }
}
