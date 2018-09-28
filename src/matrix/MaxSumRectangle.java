package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//naive solution - time complexity n^4
//use kadane's algorithm - time complexity n^3

public class MaxSumRectangle {

    private MaxSumRectangle(){

    }

    private int[] findMaxSum(int[] temp,int row){
        int[] result = new int[]{Integer.MIN_VALUE,0,-1};
        int currentSum =0;
        int start =0;
        for(int i=0;i<row;i++){
            currentSum += temp[i];
            if(currentSum <0){
                start = i+1;
                currentSum =0;
            }
            else if(currentSum > result[0]){
                result[0] = currentSum;
                result[1] = start;
                result[2] = i;
            }

        }
        //if number are negetive
        if(result[2] == -1) {
            result[0] = 0;
            for(int i=0;i<temp.length;i++){
                if(temp[i]>result[0]){
                    result[0] = temp[i];
                }
            }

        }

        return result;
    }

    private int findMaxSumRectangle(int[][] matrix,int row,int col){
        int maxSum =Integer.MIN_VALUE;
        int final_left=0,final_right=0,final_up=0,final_down=0;
        int[] arrayResult;
        int[] temp = new int[row];
        for(int left =0;left<col;left++){
            Arrays.fill(temp,0);
            for(int right =left;right<col;right++){
                for(int i=0;i<row;i++){
                    temp[i] += matrix[i][right];
                }
                arrayResult = findMaxSum(temp,row);
                if(arrayResult[0] > maxSum){
                    final_left = left;
                    final_right = right;
                    final_up = arrayResult[1];
                    final_down = arrayResult[2];
                    maxSum = arrayResult[0];
                }


            }
        }
        for(int i=final_left;i<=final_right;i++){
            for(int j= final_up;j<=final_down;j++){
                System.out.println(matrix[i][j]);
            }
            System.out.println("");
        }
        return maxSum;
    }





    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int row= scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix= new int[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        MaxSumRectangle ob = new MaxSumRectangle();
        System.out.println("max sum rectangle is "+ob.findMaxSumRectangle(matrix,row,col));

    }
}
