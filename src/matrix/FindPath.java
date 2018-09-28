package matrix;

import java.util.Scanner;

public class FindPath {

    private static boolean findPathUtil(int[][] matrix,int i,int j,int n) {

        if (i >= n || i < 0 || j < 0 || j >= n || matrix[i][j] == 0) {
            return false;
        }
        System.out.println("i = "+i+"j = "+j);
        if (matrix[i][j] == 2) {
            return true;
        }

        if (findPathUtil(matrix, i - 1, j, n) || findPathUtil(matrix, i + 1, j, n) || findPathUtil(matrix, i, j + 1, n) || findPathUtil(matrix, i, j - 1, n)) {
            return true;
        }

        return false;
    }
    private static boolean findPath(int[][] matrix,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] ==1){
                    System.out.println("index is "+i +" "+j);
                     return findPathUtil(matrix,i,j,n);
                }
            }
        }
        return false;
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

        System.out.println("Path exists "+findPath(matrix,n));

        //printMatrix(matrix,n);
    }
}
