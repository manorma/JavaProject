package tree;

import java.util.Scanner;

class FindUglyNumber {

    private int isUgly(int num){
        while(num%2 == 0){
            num = num/2;
        }
        while(num%3 == 0){
            num = num/3;
        }
        while(num%5== 0){
            num = num/5;
        }


        return num == 1?1:0;

    }
    private int findNthUglyNum(int n){
        int count = 1;
        int num =1;
        while(count < n){
            num++;
            if(isUgly(num) == 1){
                count++;
            }
        }
        return num;

    }

    private int finMin(int a,int b,int c){
        int min=a;
        if(b<min){
            min =b;
        }
        if(c<min){
            min =c;
        }
        return min;
    }
    //find ugly number by  dynamic programming
    private int NthuglyNumber(int n){
        int[] ugly=new int[n];
        ugly[0] =1;
        int i2 =0,i3=0,i5=0;
        int next_ugly=0;
        int next_2 =ugly[i2]*2,next_3 = ugly[i3]*3,next_5 =ugly[i5]*5;
        for(int i=1;i<n;i++){
            next_ugly = finMin(next_2,next_3,next_5);
            ugly[i] = next_ugly; //1 2 3 4 5 6 8 9 10 12 15
            System.out.println(ugly[i]);
            if(next_ugly == next_2){
                i2 =i2+1; // 1 2 3
                next_2 = ugly[i2]*2;//4 6 8 10 12 16
            }
            if(next_ugly == next_3){
                i3 =i3+1;
                next_3 = ugly[i3]*3; //6 9 12 15
            }
            if(next_ugly == next_5){
                i5 =i5+1;
                next_5 = ugly[i5]*5; //10 15
            }
        }
        return ugly[n-1];
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        FindUglyNumber ob = new FindUglyNumber();
        System.out.println(ob.NthuglyNumber(n));
    }
}
