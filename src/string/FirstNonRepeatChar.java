package string;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatChar {

    private HashMap<Character,CountIndex> countMap = new HashMap<>();

    private class CountIndex{
        int index;
        int count;
        CountIndex(int i){
            index = i;
            count = 1;
        }

        public void inCount(){
            count++;
        }
    }
    private void CharCountArray(String s){
        for(int i=0;i<s.length();i++){
            if(countMap.containsKey(s.charAt(i))){
                countMap.get(s.charAt(i)).inCount();
            }
            else {
                countMap.put(s.charAt(i),new CountIndex(i));
            }
        }
    }

    //scan string char and add the char to map and increment the count.to find non repeating again scan the char and check the count ,if its one then return.
    //scanning two times cost higher,iterate map instead of string again
    public  int firstNonRepeatingChar(String st){
        CharCountArray(st);
        int res = Integer.MAX_VALUE;
        for(Map.Entry<Character,CountIndex> entry:countMap.entrySet()){
            if(entry.getValue().count  == 1 && res> entry.getValue().index){
                res = entry.getValue().index;
            }
        }
        return res;
    }


    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String st =sc.next();
        FirstNonRepeatChar ob = new FirstNonRepeatChar();
        int result = ob.firstNonRepeatingChar(st);
        if(result == Integer.MAX_VALUE){
            System.out.print("No non repeating character");
        }
        else {
            System.out.print("Repeating char : "+st.charAt(result));
        }
    }
}
