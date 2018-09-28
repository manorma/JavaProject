import java.util.HashMap;
import java.util.Scanner;

public class NthPrimeNumber {


    private int nthPrime(int input){

        int count=1,num=2;
        while(count < input){
            num++;
            int c=0;
            for(int i=2;i<num;i++){
                if(num%i == 0){
                    c++;
                }
            }

            if(c == 0) {
                count++;
            }
        }
        return num;



    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        NthPrimeNumber ob = new NthPrimeNumber();
        int output = ob.nthPrime(input);
        System.out.println(output);

    }
}
