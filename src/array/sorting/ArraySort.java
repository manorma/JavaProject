package array.sorting;

public class ArraySort {


    //merge sort
    private void mergeSort(int[] arr,int l,int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    //merge two subaaray of array
    // First subarray is arr[l..m]
// Second subarray is arr[m+1..r]

    private void merge(int[] arr,int l,int m,int r){
        int i,j,k;
        int n1 = m-l+1;
        int n2 = r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(i=0;i<n1;i++){
            L[i] = arr[l+i];

        }
        for(j=0;j<n2;j++){
            R[j] = arr[m+1+j];
        }
        k=l;
        i=0;
        j=0;
        //
        while (i<n1 && j<n2){
            if(L[i] >= R[j]){
                arr[k] = R[j];
                j++;

            }
            else {
                arr[k]=L[i];
                i++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = L[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }



    }

    private void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
    public static void main(String[] args){
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        ArraySort arraySort = new ArraySort();
        arraySort.mergeSort(arr,0,n-1);
        System.out.println("Print Sorted Array ");
        arraySort.printArray(arr);

    }
}
