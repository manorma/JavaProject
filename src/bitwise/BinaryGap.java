package bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BinaryGap {

    private static int findBinaryGap(int num){
        int k =1;
        int prev = 0;
        int ncount=0;
        int max=Integer.MIN_VALUE;
        // write your code in Java SE 8
        for(int i=0;i<32;i++){
            if((num&(k<<i)) != 0){
                ncount = ncount+1;
                int p = i+1;
                if(p-prev > max){
                    max = p-prev-1;
                    prev= p;
                }
                else{
                    prev= p;
                }
            }
        }
        if(ncount == 1){
            return 0;
        }

        return max;
    }

    public static int findSet(int[] A,int M){
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i =1;i<n;i++){
            for(int j=0;j<n;j++){
                if((Math.abs(A[i]-A[j]))%3 == 0){
                    set.add(i);
                    set.add(j);
                    if(set.size() < 3){
                        set.remove(i);
                        set.remove(j);
                    }
                }

            }
        }
        return set.size();

    }

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        try {
            int t = Integer.parseInt(br.readLine());
            int i = 0;
            while (i < t) {
                int num = Integer.parseInt(br.readLine());
                int r = findBinaryGap(num);
                sb.append(r+"\n");
                i++;

            }
            System.out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
