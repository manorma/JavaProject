package Thread.proble;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CutStickSolution {


    private static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min && arr[i] != 0){
                min = arr[i];
            }
        }
        return min;
    }
    private static int countOfStick(int[] arr){
        int count =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != 0){
                count++;
            }
        }
        return count;
    }
    // Complete the cutTheSticks function below.
    private static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(countOfStick(arr) != 0){
            arrayList.add(countOfStick(arr));
            int min= findMin(arr);
            for(int i=0;i<arr.length;i++){
                arr[i]= arr[i]-min;

            }

        }
        int[] result = new int[arrayList.size()];
        int i =0;
        for(Integer list:arrayList){
            result[i] = list;
            i++;
        }
        return  result;


    }



    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
