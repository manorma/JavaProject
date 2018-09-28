package array.sorting;

import java.util.*;

public class MergeSortedArray {

    private static void merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int result[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] >= arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            result[k] = arr1[i];
            k++;
            i++;
        }
        while (j < n2) {
            result[k] = arr2[j];
            k++;
            j++;
        }
        k = 0;
        for (k = 0; k < n1 + n2; k++) {
            System.out.print(result[k]);
        }


    }
    static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }
    private static void printArray(int[] array){
        System.out.print("Arrays :");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    private static List<Integer> convertArrayToList(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        return list;
    }

    private static int[] convertListToArray(List<Integer> list){
        int[] array = new int[list.size()];
        int j=0;
        for(Integer i:list){
            array[j] = i;
            j++;
        }
        return array;
    }
   // private static<T> T[] convertListToArray(List<T> list){
//        T[] array = list.toArray(new T[list.size()]);
//        return array;

    //}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n1 = 0, n2 = 0;
        int[] arr1,arr2;
        for (int i = 0; i < t; i++) {
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            arr1 = new int[n1];
            arr2 = new int[n2];
            for (int j = 0; j < n1; j++) {
                arr1[j] = sc.nextInt();
            }
            for (int k = 0; k < n2; k++) {
                arr2[k] = sc.nextInt();
            }



            List<Integer> list1 = convertArrayToList(arr1);
            Collections.sort(list1,Collections.reverseOrder());
            List list2 = convertArrayToList(arr2);
            Collections.sort(list2,Collections.reverseOrder());
            arr1 = convertListToArray(list1);
            arr2 = convertListToArray(list2);
            printArray(arr1);
            printArray(arr2);
            merge(arr1,arr2);
        }







    }
}
