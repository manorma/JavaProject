import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeriesDemo {

    private static int gcd(int a,int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }

    private static int findNext(int n){
        int result = 1;
        for(int i =2;i<=n;i++){
            if(gcd(i,n) == 1){
                result += 1;
            }
        }
        return result;
    }

    private static String printSeries(int n){

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<= n;i++){
            sb.append(findNext(i));
            sb.append(" ");
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0){
                int n = Integer.parseInt(br.readLine());
                sb.append(printSeries(n));
                sb.append("\n");

            }
            System.out.print(sb.toString());
        } catch (IOException e) {
            System.out.print(e);
        }

    }
}
