package array.sorting;

import java.util.Scanner;

public class CipherTest {



    private String decrypt(String input){
        String alph ="abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<input.length();i++){
            char s = input.charAt(i);
            int p = alph.indexOf(s);
            char t;
            if(p+3 < 26) {
                t = alph.charAt(p + 3);
            }
            else{
                int in = p+3-26;
                t = alph.charAt(in);
            }

            sb.append(t);
            System.out.println("s="+s+"p="+p+"t="+t+"sb ="+sb.toString());
        }
        return sb.toString();
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        CipherTest ob = new CipherTest();
        String output = ob.decrypt(input);
        System.out.println(output);
    }
}
