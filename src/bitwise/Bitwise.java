package bitwise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bitwise {

    // sparse number  - number which is not having consecutive set bit called sparse number.

    private Character flip(Character c){
        return c == '0'?'1':'0';
    }
    private String getOnesCompliment(String num){
        int l = num.length();
        StringBuilder ones= new StringBuilder();
        for(int i=0;i<l;i++){
            ones.append(flip(num.charAt(i)));
        }
        return ones.toString();
    }

    private String getTwosCompliment(String num){
        String ones = getOnesCompliment(num);
        StringBuilder twos = new StringBuilder(ones);
        int i;
        for(i=twos.length()-1;i>=0;i--){
            if(twos.charAt(i) == '1'){
                twos.setCharAt(i,'0');
            }
            else {
                twos.setCharAt(i,'1');
                break;
            }
        }


        if(i == -1){
            twos = new StringBuilder('1' +twos.toString());
        }
        return twos.toString();
    }


    private void findRightMostDifferentBit(String num1,String num2){

    }

    private int findFirstSetBitFromRight(int num){
        int pos =1;
        int m=1;
        while((num & m) == 0){
            pos++;
            m = m << 1;
        }

        return pos;
    }

    private String convertNumToBinary(int num){
        int[] bin = new int[100];
        String binary="";
        int i=0;
        while(num > 0){
            bin[i] = num%2;
            i++;
            num = num/2;
        }
        for(int j=i-1;j>=0;j--){
            binary += String.valueOf(bin[j]);
        }
        return binary;
    }

    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringBuffer sb = new StringBuffer();
            int i = 0;
            while (i < t) {
                String num = br.readLine();
                Bitwise ob = new Bitwise();
                System.out.println("Binary :" + ob.convertNumToBinary(Integer.parseInt(num)));
//                String bin = ob.convertNumToBinary(Integer.parseInt(num));
//                System.out.println("One's Compliment :" + ob.getOnesCompliment(bin));
//                System.out.println("Two's Compliment :" + ob.getTwosCompliment(bin));
                int pos = ob.findFirstSetBitFromRight(Integer.parseInt(num));
                sb.append(pos);
                sb.append("\n");
                i++;
            }
            System.out.println(sb);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        Bitwise ob = new Bitwise();
//        int t = Integer.parseInt(sc.next());
//        for(int i=0;i<t;i++){
//            String input1 = sc.next();
//            String input2 = sc.next();
//
//
//        }
//
//
//    }
}
