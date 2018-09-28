package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumZeroMatrix {

    int start,end;
    Map<Integer,Integer> presum = new HashMap<>();
    boolean sumZero(int[] temp,int row){

        int sum =0,max_length=0;
        for(int i=0;i<row;i++){
            sum += temp[i];

            if(temp[i] == 0 && max_length == 0){
                start = i;
                end = i;
                max_length =1;
            }
            if(sum == 0){
                if(max_length < i+1){
                    start = 0;
                    end =i;
                }
                max_length = i+1;
            }

            if(presum.containsKey(sum)){
                int old=max_length;
                max_length = Math.max(max_length,i-presum.get(sum));
                if(old<max_length){
                    end =i;
                    start = presum.get(sum)+1;
                }
            }
            else {
                presum.put(sum,i);
            }
        }
        return (max_length != 0);
    }
    int sumZeroMatrix(int[][] matrix,int row,int col){
        int[] temp = new int[row];
        int curr_up=0,curr_down =0,curr_left =0,curr_right=0;
        int sum;
        int max= Integer.MIN_VALUE;

        for(int left =0;left<col;left++){
            Arrays.fill(temp,0);
            for(int right = left;right<col;right++){

                for(int i=0;i<row;i++){
                    temp[i] += matrix[i][right];
                }

                boolean csum = sumZero(temp,row);
                int ind = (curr_down-start+1)*(right-left+1);

                if(csum && ind>max){
                    curr_up = start;
                    curr_down = end;
                    curr_left = left;
                    curr_right = right;
                    max = ind;
                }
            }
        }

        if(curr_up == 0 && curr_down == 0 && curr_left == 0 && curr_right == 0 && matrix[0][0] != 0){
            //no sum exist

        }
        System.out.println("curr up " +curr_up+"down " +curr_down +"right "+curr_right+"left "+curr_left);
        for(int i = curr_up ;i<=curr_down;i++){
            for(int j = curr_left;j<=curr_right;j++){
                System.out.println(matrix[i][j]+" ");
            }
        }

        return (curr_down-curr_up+1)*(curr_right-curr_left+1);

    }



    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String st="";
            try {
                st = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return st;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int row =fr.nextInt();
        int col = fr.nextInt();
        int[][] array =new int[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                array[i][j] = fr.nextInt();
            }

        }
        SumZeroMatrix obj = new SumZeroMatrix();
        int largeRectangle = obj.sumZeroMatrix(array,row,col);
        System.out.println(largeRectangle);
    }
}
