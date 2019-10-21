package bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindRightMostDiffBit {

    //input 11 9  1011 1001
    //output 2
    private static int findRightMostDiffBit(int num1, int num2) {
        int pos = 1;
        int m =1;
        while((num1 & m) == (num2 & m)){
            pos++;
            m = m<<1;
        }
        return pos;
    }

    //input 4 , 0
    //output No

    //input 4 2 1


    private static String checkKthBitSetOrNot(int num ,int k){
        int i = 0;
        int m =1;
        while( i < k){
            i++;
            m = m<<1;
        }
        System.out.println("m ="+m);
        if((num & m) == 0){
            return "No";
        }
        return "Yes";
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String line1 = br.readLine();
                String line2 = br.readLine();
                //String[] strs = line.trim().split("\\s+");
                int num1 = Integer.parseInt(line1);
                int num2 = Integer.parseInt(line2);
                //int diff = findRightMostDiffBit(num1, num2);
                String ret = checkKthBitSetOrNot(num1,num2); // num2 = kth bit
                sb.append(ret);
                sb.append("\n");
            }

            System.out.print(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
