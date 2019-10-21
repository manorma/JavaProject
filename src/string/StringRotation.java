package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRotation {

/*
1
amazon
azonam
 */

    public static void main(String[] args){
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        float f =  -0.9f;
        System.out.println(String.valueOf(f));
        try {
            int t = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int i=0;
            while (i<t){
                String str1 = br.readLine();
                int res = sameOnRotatingByTwo(str,str1);
                System.out.println(res);
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    private static int sameOnRotatingByTwo(String str1, String str2) {
        if(str1.length() != str2.length()){
            return 0;
        }

        char[] strArr1 = str1.toCharArray();
        char[] strArr2 = str2.toCharArray();

        //rotate clockwise by 2
        char temp = 0;
        for(int i =0;i<2;i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (j == 0) {

                    temp = strArr2[j];
                }
                if (j < str2.length() - 1) {
                    strArr2[j] = strArr2[j + 1];
                } else {
                    strArr2[j] = temp;
                }

            }
        }
        if(str1.equals(String.valueOf(strArr2))){
            return 1;
        }
        // rotate anti clockwise
        strArr2 = str2.toCharArray();
        temp = 0;
        for(int i =0;i<2;i++) {
            for (int j = strArr2.length-1; j >= 0; j--) {
                if (j == strArr2.length-1) {
                    temp = strArr2[j];
                }
                if (j > 0) {
                    strArr2[j] = strArr2[j - 1];
                } else {
                    strArr2[j] = temp;
                }

            }
        }
        if(str1.equals(String.valueOf(strArr2))){
            return 1;
        }
        return 0;

    }

    /*
    1
rellnmpapqfwkhop
llnmpapqfwkhopre
     */
}
