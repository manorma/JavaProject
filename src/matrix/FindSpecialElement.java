package matrix;


//special element means element which is smallest or largest element in row or colum
public class FindSpecialElement {

    public static int countSpecialElement(int[][] matrix,int row,int col){
        int[] rowmax = new int[row];
        int[] rowmin = new int[row];
        int[] colmax = new int[col];
        int[] colmin = new int[col];
        int i,j;
        //find max min in every row
        for(i= 0 ;i<row;i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(j=0;j<col;j++){

                if(matrix[i][j] == min || matrix[i][j] == max){
                    return 0;
                }
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }

            }
            rowmax[i] = max;
            rowmin[i] = min;

        }

        //find max min in every column
        for(j= 0 ;i<col;j++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(i=0;i<row;i++){

                if(matrix[i][j] == min || matrix[i][j] == max){
                    return 0;
                }
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }

            }
            colmax[j] = max;
            colmin[j] = min;

        }

        //find optimal solution
        int count=0;
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(matrix[i][j] == rowmax[i] || matrix[i][j] == rowmin[i] || matrix[i][j] == colmax[j] || matrix[i][j] == colmin[j]){
                    count++;
                }
            }
        }

        return count;
    }



    public static void main(String[] args){
        int[][] matrix  = {{1,6,2},{2,5,8},{9,4,3}};
        System.out.println(countSpecialElement(matrix,3,3));
    }
}
