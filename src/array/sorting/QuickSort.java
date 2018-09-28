package array.sorting;

public class QuickSort {

    private void sort(int[] arr,int low,int high){
        if(low<high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }


    }
    private int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);

            }
        }
        i++;
        swap(arr,i,high);
        return i;


    }
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }


    private void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        QuickSort quickSort = new QuickSort();
        quickSort.printArray(arr);
        quickSort.sort(arr,0,n-1);
        System.out.println("Print Sorted Array");
        quickSort.printArray(arr);
    }
}
