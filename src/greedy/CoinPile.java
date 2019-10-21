package greedy;

import java.util.Scanner;

public class CoinPile {
    //There are N piles of coins each containing  Ai (1<=i<=N) coins.  Now, you have to adjust the number of coins in each pile such that for any two pile, if a be the number of coins in first pile and b is the number of coins in second pile then |a-b|<=K. I


//    6 3
//            1 2 5 1 1 1
//            6 3
//            1 5 1 2 5 1
    // output 1 2
    private static int findCoinRemove(int[] pile,int k){
        int n = pile.length;
        int c =0 ;
        for(int i=1;i<n-1;i++){
            int dif = pile[0] - pile[i];
            if(dif < 0){
                if((dif * (-1)) > k){
                    c += ((-1)*dif)-k;
                }
            }
            else {
                if(dif > k){
                    c += dif-k;
                }
            }
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] p = new int[n];
            int i=0;
            while(i < n){
                p[i] = scanner.nextInt();
                i++;

            }
            System.out.println(findCoinRemove(p,k));
        }
    }


}
