import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//get accepted in 1.23 s
public class FastInputOuputReader {
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

    public static void main(String[] args){
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int k= fr.nextInt();
        int count =0;
        while(n-- > 0){
            int x = fr.nextInt();
            if(x%k == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
