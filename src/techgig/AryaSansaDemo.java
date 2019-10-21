package techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AryaSansaDemo {

    private static int noOfWays(int p,int r,int index,int aryaCount,int sansaCount,HashMap<String,Integer> computedVal){

        String keyVal = index+":"+aryaCount+":"+sansaCount;
        if(computedVal.containsKey(keyVal)){
            return  computedVal.get(keyVal);
        }

        int returnVal = 0;
        if(index >= r){ // index greater than round
            if(aryaCount >= (p*sansaCount)){
                returnVal = 1;
            }
            else {
                returnVal =0;
            }
        }else if(aryaCount < (p*sansaCount)){
            returnVal = 0;
        }
        else {
            int aryaWinNextRound = noOfWays(p,r,index+1,aryaCount+1,sansaCount,computedVal);
            int sansaWinNextRound = noOfWays(p,r,index+1,aryaCount,sansaCount+1,computedVal);
            returnVal = aryaWinNextRound+sansaWinNextRound;
        }
        computedVal.put(keyVal,returnVal);
        return returnVal;
    }


    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            int t= Integer.parseInt(br.readLine());
            while (t-- > 0){
                String input = br.readLine();
                String[] in = input.trim().split(" ");
                int r = Integer.parseInt(in[0]);
                int p = Integer.parseInt(in[1]);
                HashMap<String,Integer> computedVal = new HashMap<>();
                int res =noOfWays(p,r,p,p,0,computedVal);

                sb.append(res + "\n");

            }

            System.out.print(sb.toString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
