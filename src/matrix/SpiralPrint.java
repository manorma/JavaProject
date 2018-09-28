package matrix;

import java.util.Scanner;

public class SpiralPrint {
    private int matrix[][];
    private int size;

    //print spiral form of matrix
    private void spiralPrint(){
        int r1 = 0,r2 = size-1,c1 = 0,c2 = size-1;
        while(r1<=r2 && c1<=c2){
            int c= c1;
            int r;
            while(c<=c2){
                System.out.print(matrix[r1][c]+" ");
                c++;
            }
            r1++;
            r=r1;
            while(r<=r2){
                System.out.print(matrix[r][c2]+" ");
                r++;
            }
            c2--;
            c=c2;
            while(c>=c1){
                System.out.print(matrix[r2][c]+" ");
                c--;
            }
            r2--;
            r=r2;
            while (r>=r1){
                System.out.print(matrix[r][c1]+" ");
                r--;
            }
            c1++;
        }


    }
    private void printMatrix(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

    }
    public static void main(String [] args){
        System.out.println("Enter matrix size");
        Scanner scanner=new Scanner(System.in);
        int s = scanner.nextInt();
        SpiralPrint matrix = new SpiralPrint();
        matrix.matrix = new int[s][s];
        matrix.size =s;

        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                matrix.matrix[i][j] = scanner.nextInt();
            }
        }
        matrix.printMatrix();
        System.out.println("Spiral form of matrix: \n");
        matrix.spiralPrint();


    }
}
