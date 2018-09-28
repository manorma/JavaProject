import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxReward {

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
    private boolean taskValid(int[][] matrix,int r){
        if(matrix[r][2]< matrix[r][0]){
            return true;
        }
        return false;
    }
    private int calculateMaxReward(int[][] matrix,int row){

        int max_reward = Integer.MIN_VALUE;
        int reward;
        for(int i=0;i<row;i++){
            for(int j=i+1;j<row;j++){
                reward =0;
                if(taskValid(matrix,i) && taskValid(matrix,j)){
                    reward = matrix[i][1] + matrix[j][1];

                }
                if(reward > max_reward){
                    max_reward = reward;
                }
            }
        }
        return max_reward;

    }
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int t =fr.nextInt();
        int n = fr.nextInt();
        int[][] array =new int[n][3];
        MaxReward obj = new MaxReward();
        for(int i =0;i<t;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++) {
                    array[j][k] = fr.nextInt();

                }
            }
            int maxReward = obj.calculateMaxReward(array,n);
            System.out.println(maxReward);
        }


    }
}
