package bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class convertBinToDecimal {

//    Example:
//    Input:
//            2
//            10001000
//            101100
//    Output:
//            136
//            44

    private static int covertBinToDec(String bin){
        int l = bin.length();
        int p = l-1;
        int num =0;
        for(int i=0;i<l;i++){
            if(bin.charAt(i) == '1'){
                num += Math.pow(2,(p-i));
            }
        }
        return num;
    }
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            while (t-- > 0) {
                String bin = br.readLine();
                int out = covertBinToDec(bin);
                sb.append(out);
                sb.append("\n");
            }
            System.out.print(sb);
        }catch (IOException e){

        }


    }
}
