package matrix;

import java.util.Scanner;

//rotate matrix by 90
public class RotateMatrix {


    //first methode using extra space
    private static void rotateBy90(int[][] matrix,int n){
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];  //column fixed row change
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j]; //row fixed column change
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i]; // row change column fixed
                matrix[n-1-j][i] = temp;
            }
        }

    }

    //without using extra space
    //find transpose and then reverse
    private static void rotateBy90_2(int[][] matrix,int n){
        //transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("transponse is :");
        printMatrix(matrix,n);
        //reverse each column

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp= matrix[j][i];
                matrix[j][i] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }
        System.out.println("rotated matrix is :");
        printMatrix(matrix,n);
    }



    private static void printMatrix(int[][] matrix,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args){
        System.out.println("Enter matix size");
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = scanner.nextInt();
            }
        }
        printMatrix(matrix,n);
        rotateBy90_2(matrix,n);
        //printMatrix(matrix,n);
    }
}
