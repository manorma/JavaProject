package matrix;

public class Island {

    private static final int row =5,col =5;

    private boolean isSafe(int M[][],int i,int j,boolean visibility[][]){
        return (i>=0) && (j>=0) && (i<row) && (j<col) && (M[i][j] ==1) && (!visibility[i][j]);
    }
    private void DFS(int M[][],int i,int j,boolean visibility[][]){

        int r[]=new int[]{-1,-1,-1,0,0,1,1,1};
        int c[] = new int[]{-1,0,1,-1,1,-1,0,1};
        visibility[i][j] = true;
        for(int k=0;k<8;k++){
            if(isSafe(M,i+r[k],j+c[k],visibility)){
                DFS(M,i+r[k],j+c[k],visibility);
            }
        }


    }

    private int countIsland(int M[][]){
        boolean visibility[][] = new boolean[row][col];
        int count =0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(M[i][j] == 1 && !visibility[i][j]){
                    DFS(M,i,j,visibility);
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args){
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Island I = new Island();
        System.out.println("Number of islands is: "+ I.countIsland(M));
    }
}
