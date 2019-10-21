package array.sorting;

import java.util.Scanner;

public class SegregateTest {

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // if contain 0 and 1
    private static void seggregate01(int[] arr){
        int l = arr.length;
        int i=-1,j=0;
        while(j<l){
            if(arr[j] == 0){
                i++;
                swap(arr,i,j);
            }
            j++;
        }
        for (int k=0;k<l;k++){
            System.out.print(arr[k]);
        }
        System.out.println();
    }
    // if contain 0 ,1 ,2
    /*
    12
    0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1
    6
    0, 1, 2, 0, 1, 2
     */
    private static void  seggregate012(int[] arr){
        int l= arr.length;
        int low =0,mid =0,high = l-1;
        while (mid <= high){
            switch (arr[mid]){
                case 0:
                    swap(arr,low,mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;

                case 2:
                    swap(arr,mid,high);
                    high--;
                    break;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        int i=0;
        int[][] arr = new int[t][];
        while (i<t){
            int n = sc.nextInt();
            int[] a= new int[n];
            for(int j= 0;j<n;j++){
                a[j] = sc.nextInt();
            }
            seggregate012(a);
            StringBuffer sb = new StringBuffer();
            for (int k=0;k<n;k++){
                sb.append(a[k]+" ");
            }
            System.out.println(sb);
            i++;
        }

//        i=0;
//        while (i<t){
//            seggregate012(arr[i]);
//            i++;
//        }
    }
}
