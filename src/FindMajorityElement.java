import java.util.*;

//using hash map ,time complexity O(n),space O(n)
public class FindMajorityElement {

    private static int findMajority(int[] input,int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(input[i])){
                int count = map.get(input[i])+1;
                if(count > n/2){
                    return input[i];
                }
                else {
                    map.put(input[i],count);
                }

            }
            else {
                map.put(input[i],1);
            }
        }
       return -1;

    }

    private static int findCandidate(int[] input,int n){
        int maj_ind =0,count =1;
        for(int i=1;i<n;i++){
            if(input[i] == input[maj_ind]){
                maj_ind = i;
                count++;
            }
            else {
                count--;
            }
            if(count == 0){
                maj_ind = i;
                count =1;
            }
        }
        return input[maj_ind];
    }

    private static boolean isMajority(int[] input,int cand,int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(input[i] == cand){
                count++;
            }
            if(count == n/2){
                return true;
            }
        }
        return false;

    }
    //using moores voting algorith ,time O(n) space O(1)
    private static int findMajority_2(int[] input,int n){
        int can = findCandidate(input,n);
        if(isMajority(input,can,n)){
            return can;
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = scanner.nextInt();
        }
        int output =findMajority_2(input,n);
        System.out.println(output);

    }
}
