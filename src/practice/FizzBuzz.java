package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    //multiple of three print Fizz
    //multiple of 5 print Buzz
    //multiple of 3 and 5 print FizzBuzz

    private static void printFizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz\n");
            } else if (i % 5 == 0) {
                System.out.print("Buzz\n");
            } else if (i % 3 == 0) {
                System.out.print("Fizz\n");
            }else {
                System.out.print(i+"\n");
            }
        }
    }


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String line = br.readLine();
                String[] input = line.split(" ");
                for (String in : input) {
                    printFizzBuzz(Integer.parseInt(in));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
