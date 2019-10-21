package array.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSubArraySum {

    public static void findSubArray(int[] arr,int sum){
        int len = arr.length;
        System.out.println("len = "+len);
        int i,j;
        int curr_sum =0;
        for(i=0;i<len-1;i++){
            curr_sum = arr[i];
            System.out.println("curr_sum "+curr_sum);
            for(j=i+1;j<=len;j++){
                if(curr_sum == sum){
                    int p = j-1;
                    System.out.println(i +" "+p);
                    return;
                }
                if(curr_sum > sum || j == len-1)
                    break;
                curr_sum = curr_sum +arr[j];
            }
        }

    }
    /*
    2
6 33
1 4 20 3 10 5
7 7
1 4 0 0 3 10 52

     */

    public static int divide(int a,int b){
        int c= -1;
        try {
            c = a/b;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
        return c;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int[] sum = new int[t];
        int i=0;
        int[][] arr = new int[t][];
        while (i<t){
            int n =sc.nextInt();
            int s= sc.nextInt();
            sum[i] = s;
            int[] a = new int[n];
            for(int j=0;j<n;j++){
                a[j] = sc.nextInt();
            }
            arr[i] = a;
            i++;

        }
        i=0;
        while (i<t){
            findSubArray(arr[i],sum[i]);
            i++;
        }


    }
}
