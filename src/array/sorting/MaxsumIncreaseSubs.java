package array.sorting;
//find the maximum sum increasing subsequence

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxsumIncreaseSubs {

    /*
    2
7
1 101 2 3 100 4 5
4
10 5 4 3
     */

    public static int findMaxSumIncreasingSub(int[] arr){
        int len = arr.length;
        int max =0;
        int[] msis = new int[len];
        int i,j;
        for(i=0;i<len;i++){
            msis[i] = arr[i];
        }
        for(i = 1;i< len;i++){
            for(j = 0;j<i;j++){
                if(arr[i] > arr[j] && msis[i] < msis[j]+arr[i]){
                    msis[i] = msis[j]+arr[i];
                }
            }
        }

        for(i =0;i<len;i++){
            if(msis[i]> max){
                max = msis[i];
            }
        }
        return max;

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i < t) {
                int n = Integer.parseInt(br.readLine());
                String[] strs = br.readLine().split("\\s+");
                int[] a = new int[n];
                for (int j = 0; j < n; j++) {
                    a[j] = Integer.parseInt(strs[j]);
                }
                int res = findMaxSumIncreasingSub(a);
                sb.append(res+"\n");
                i++;

            }
            System.out.println(sb);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
