package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Input
//        1
//        3 3
//        1 1 0 0 0 1 1 0 1
//
//        Output
//        2

public class FindIsland {
    static int m_row,m_col;
    private static boolean isSafe(int[][] matrix,int r,int c,boolean[][] visited){
        //System.out.println("r ="+r +"c = "+c);
        return (r>=0) && (r<m_row) && (c>=0) && (c<m_col) && (matrix[r][c] == 1 && !visited[r][c]);
    }

    private static void DFS(int[][] matrix,int row,int col,boolean[][] visited){
        //8 connected neighbour row col index
        int[] row_in = new int[]{-1,1,-1,-1,0,0,1,1,1};
        int[] col_in = new int[]{-1,0,1,-1,1,-1,0,1};
        visited[row][col] = true;
        //check for all 8 connected neighbour
        //System.out.println("row =" +row +"col = "+col);
        for(int i=0;i<8;i++){
            //System.out.println("i= " +i+"row_in =" +row_in[i] +"col_in = "+col_in[i]);
            if(isSafe(matrix,row+row_in[i],col+col_in[i],visited)){
                DFS(matrix,row+row_in[i],col+col_in[i],visited);
            }
        }

    }
    private static int findIsland(int[][] matrix,int n,int m){
        boolean[][] visited = new boolean[n][m];
        int count =0;
        m_row = n;
        m_col = m;
        for(int i=0;i<n;i++){
            for(int j=0 ;j<m ;j++){
                if(matrix[i][j] == 1 && !visited[i][j]){
                    DFS(matrix,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){
                String row_col = br.readLine();
                String[] str1 = row_col.trim().split("\\s+");
                m_row= Integer.parseInt(str1[0]);
                m_col = Integer.parseInt(str1[1]);
                String input = br.readLine();
                String[] str2 = input.trim().split("\\s+");
                int[][] matrix = new int[m_row][m_col];
                int k =0;
                for(int i = 0;i<m_row;i++){
                    for(int j =0;j<m_col;j++){
                        if(k < 9) {
                            matrix[i][j] = Integer.parseInt(str2[k]);
                            k++;
                        }
                    }
                }
                int out = findIsland(matrix,m_row,m_col);
                sb.append(out);
                sb.append("\n");


            }
            System.out.print(sb);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
