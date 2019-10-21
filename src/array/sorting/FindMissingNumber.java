package array.sorting;

import java.util.Scanner;

public class FindMissingNumber {


    public static void findMissing(int[] arr,int count){
        int n= arr.length;
        int exp_sum = count *(count+1)/2;
        int sum =0;
        for (int i=0;i<n;i++){
            sum =sum +arr[i];
        }

        System.out.println(exp_sum-sum);


    }

    /*
    2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10
     */


    public static void main(String[] args){
        System.out.println("Enter testcase");
        Scanner sc = new Scanner(System.in);
        int t= Integer.parseInt(sc.nextLine());
        int[] count = new int[t];
        int i=0;
        int[][] arr = new int[t][];
        while (i<t){
            count[i] = Integer.parseInt(sc.nextLine());
            String[] str = sc.nextLine().split(" ");
            int[] a = new int[str.length];
            for(int j=0;j<str.length;j++){
                a[j] = Integer.parseInt(str[j]);
            }
            arr[i] = a;
            i++;

        }
        i=0;
        while (i<t){
            findMissing(arr[i],count[i]);
            i++;
        }


    }


}
