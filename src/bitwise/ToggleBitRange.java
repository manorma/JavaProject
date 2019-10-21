package bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToggleBitRange {

    //Given a non-negative number N and two values L and R. The problem is to toggle the bits in the range L to R in the binary representation of N, i.e, to toggle bits from the
    //input Input:
    //2
    //17 2 3
    //50 2 5
    //Output:
    //23
    //44
    private static Character flip(Character c){
        return c == '0'?'1':'0';
    }

    private static int toggleBit(int num,int l,int r){
       int n = ((1<<r)-1)^ ((1<<(l-1))-1);
       return (num^n);
    }

    //input
    //2
    //10 2
    //15 3
    //output
    //14
    //15
    private static int setKthBit(int num,int k){
        int p=0;
        int m =1;
        while(p<k){
            p++;
            m =m<<1;
        }
        return num|m;
    }

    private static String isPowerOfTwo(int num){

        boolean out= num != 0 && ((num & (num-1)) == 0);
        if(out){
            return "YES";
        }
        return "NO";
    }

    //Input:
    //2
    //6  110
    //11 1011

//    Output:
//            2
//            3

    private static int getCountOfSetBit(int num){
        int c =0;
        while(num>0){
            c += (num & 1);
            num >>=1;
        }
        return c;
    }

//    Example:
//    Input:
//            2
//            14  1110
//            222
//
//    Output:
//            3
//            4
    private static int longestConsecutiveSetBit(int num){
        int c= 0;
        int l =0;
        while(num >0){
            if((num & 1) == 0){
                if(c>l){
                    l =c;
                }
                c= 0;
            }else {
                c += (num & 1);

            }
            num >>=1;
        }
        if(c>l){
            return c;
        }
        return l;
    }

//    Example:
//    Input:
//            2
//            2
//            3
//
//    Output:
//            1
//            0
// sparse number  - number which is not having consecutive set bit called sparse number.
    private static int isSparseNumber(int num){
        int c= 0;
        while(num >0){
            if((num & 1) == 0){
                if(c >= 2){
                    return 0;
                }
                c=0;
            }else {
                c += (num & 1);
            }
            num >>=1;

        }
        if(c >= 2){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String line = br.readLine();
                String[] strs = line.trim().split("\\s+");
                int num = Integer.parseInt(strs[0]);
                //int l = Integer.parseInt(strs[1]);
                //int r = Integer.parseInt(strs[2]);
                //int out = toggleBit(num,l,r);
                //int out = setKthBit(num,l);
                //String out = isPowerOfTwo(num);
                //String out = String.valueOf(getCountOfSetBit(num));
                //int out = longestConsecutiveSetBit(num);
                int out = isSparseNumber(num);
                sb.append(out);
                sb.append("\n");
            }

            System.out.print(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
