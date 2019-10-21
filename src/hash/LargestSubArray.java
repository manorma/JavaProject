package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {

    //find the largest subarray with zero sum
//    Input
//1
//        8
//        15 -2 2 -8 1 7 10 23
//
//    Output
//5
    //Time complexity O(n)

    int maxLen(int arr[], int n)
    {
        long sum[] = new long[n];
        sum[0] = arr[0]; // 15 13 15 7 8 15 25 48
        for(int i =1;i<n;i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        int maxlen = 0;
        // System.out.println(Arrays.toString(sum));
        Map<Long, Integer> count = new HashMap<>();
        count.put(0l,0);
        for(int i = 0;i<n;i++) {
            if(count.containsKey(sum[i])) {
                maxlen =  Math.max(maxlen,i+1 - count.get(sum[i]));
            } else {
                count.put(sum[i],i+1);
            }
        }

        return maxlen;
    }

    private static int findLargestSubarrray(int[] arr){
        int l = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        int max_len =0;

        for(int i =0 ;i<l;i++){
            sum += arr[i];
            if(arr[i] == 0 && max_len == 0){
                max_len = 1;
            }
            if(arr[i] == 0){
                max_len = i+1;
            }
            Integer prev_in = map.get(sum);
            if(prev_in != null){
                max_len = Math.max(max_len,i-prev_in);
            }
            else {
                map.put(sum,i);
            }
        }
        return max_len;

    }
    public static void main(String[] args){
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){
                int l = Integer.parseInt(br.readLine());
                String in= br.readLine();
                String[] arr = in.trim().split("\\s+");
                int[] array = new int[l];
                int j=0;
                for(String a :arr){
                    array[j] = Integer.parseInt(a);
                    j++;
                }
                int out = findLargestSubarrray(array);
                sb.append(out);
                sb.append("\n");
            }
            System.out.print(sb);
        }catch (IOException e){

        }
    }
}
