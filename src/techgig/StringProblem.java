package techgig;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringProblem {

    private static char maxCountChar(String input){
        HashMap<Character,Integer> countMap = new HashMap<>();
        for(int i=0;i<input.length();i++){
            if(countMap.containsKey(input.charAt(i))){
               int count = countMap.get(input.charAt(i));
               countMap.put(input.charAt(i),count+1);
            }
            else {
                countMap.put(input.charAt(i),1);
            }
        }
        int max = Integer.MIN_VALUE;
        char maxChar = 'z';
        for(Map.Entry<Character,Integer> set: countMap.entrySet()){
            if(set.getValue() > max){
                max = set.getValue();
                maxChar = set.getKey();
            }
            else if (set.getValue() == max){
                if(set.getKey() < maxChar){
                    maxChar = set.getKey();
                }
            }
        }
        return maxChar;
    }

//    2
//    gqtrawq
//            fnaxtyyzz
    //q
    //y

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            int t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                String input = br.readLine();
                sb.append(maxCountChar(input)+"\n");

            }
            System.out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
