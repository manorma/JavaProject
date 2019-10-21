package array.sorting;

import java.util.Scanner;

public class FindContMaxSum {

    public static void findMaxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + arr[i];
            if(sum < 0 ){
                if(sum > max){
                    max = sum;
                }
                sum =0;
            }
            else if (max < sum)
                max = sum;
        }
        System.out.println(max);
    }
    /*
    2
3
1 2 3
4
-1 -2 -3 -4
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        int[][] arr = new int[t][];
        while (i < t) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            arr[i] = a;
            i++;

        }
        i = 0;
        while (i < t) {
            findMaxSum(arr[i]);
            i++;
        }

    }
}
