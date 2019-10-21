package dp;

public class KnapSack {

    //0-1 knapsack
    private static int max(int a,int b){
        return (a > b) ? a:b;
    }
    private static int findMaxWeight(int w,int[] val,int[] wt,int i){

        if(w == 0 || i == 0){
            return 0;
        }

        if(wt[i-1] > w){
            findMaxWeight(w,val,wt,i-1);
        }

        // return maximum of two case 1. nth item included 2. not included
        return max(val[i-1]+ findMaxWeight(w-wt[i-1],val,wt,i-1),findMaxWeight(w,val,wt,i-1));

    }
    public static void main(String[] args){
        int[] val = new int[]{60,100,120};
        int[] wt= new int[]{10,20,30};
        int w = 50;
        int n= val.length;
        System.out.println(findMaxWeight(w,val,wt,n));

    }




}
