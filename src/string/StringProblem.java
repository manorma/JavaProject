package string;

import java.util.Arrays;
import java.util.Scanner;

public class StringProblem {


    private static String reverseString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    //manorma orm
    private static int findPattern(String str,String pat){
       int ls = str.length();
       int ps = pat.length();
       for(int i =0;i<=ls-ps;i++){
           int k =0;
           for(int j=i;j<i+ps;j++){
               if(str.charAt(j) != pat.charAt(k++)){
                   break;
               }
               if(k == ps){
                   return i;
               }
           }
       }
        return -1;
    }

    //check string is panagram or not ,if string contains all char from a to z,then its called panagram

    private static boolean isPanagram(String string){
        boolean[] present = new boolean[26];
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                present[string.charAt(i)- 'A'] = true;
            }
            else if(string.charAt(i) >= 'a' && string.charAt(i) <= 'z'){
                present[string.charAt(i)- 'a'] = true;
            }
        }
        for(int i=0;i<26;i++){
            if(!present[i]){
                return false;
            }
        }
        return true;
    }

    private static void printAllPalindrom(String str){
        int low;
        int high;
        for(int i=1;i<str.length();i++){
            low = i-1;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)){
                System.out.println(str.substring(low,high+1));
                low--;
                high++;

            }
            low = i-1;
            high = i+1;
            while (low >= 0 && high <str.length() && str.charAt(low) == str.charAt(high)){
                System.out.println(str.substring(low,high+1));
                low--;
                high++;
            }
        }
    }
    //print all palindeome including one character

    private static void printAllPalindrom2(String str){
        int low;
        int high;
        for(int i=0;i<str.length();i++){
            low = i;
            high = i;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)){
                System.out.println(str.substring(low,high+1));
                low--;
                high++;

            }
            low = i;
            high = i+1;
            while (low >= 0 && high <str.length() && str.charAt(low) == str.charAt(high)){
                System.out.println(str.substring(low,high+1));
                low--;
                high++;
            }
        }
    }

    //input listen ,silent
    //integral , triangle

    private static boolean areAnagram(String str1,String str2){
        int l1= str1.length();
        int l2 = str2.length();
        int[] count = new int[256];
        Arrays.fill(count,0);

        if(l1 != l2){
            return false;
        }
        for(int i= 0;i<str1.length();i++){
            count[str1.charAt(i)]++;
        }
        for(int i=0;i<str2.length();i++){
            count[str2.charAt(i)]--;
        }
        for(int i=0 ;i<256;i++){
            if(count[i] == 1){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String input = sc.nextLine();
        //String pat = sc.nextLine();
        //System.out.println("Reverse of string :" +reverseString(input));
//        int res = findPattern(input,pat);
//        if(res == -1){
//            System.out.println("Pattern not found");
//        }else {
//            System.out.println("Pattern found " +res);
//        }

//        if(isPanagram(input)){
//            System.out.println( input + " is panagram");
//        }
//        else {
//            System.out.println( input + " is not panagram");
//        }

        printAllPalindrom(input);
//        if(areAnagram(input,pat)){
//            System.out.println("Anagram");
//
//        }else {
//            System.out.println("not anagram");
//        }
    }
}
