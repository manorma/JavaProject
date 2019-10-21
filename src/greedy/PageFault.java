package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageFault {

    private void printList(List<Integer> list){

    }

    private static int findNoOfPageFault(int[] page ,int capacity){
        int fault =0;
        List<Integer> list = new ArrayList<>(capacity);
        int count =0;
        for(int i =0;i< page.length ;i++){
            if(!list.contains(page[i])){
                if(list.size() < capacity) {
                    list.add(i,page[i]);
                }
                else {
                    list.remove(0);
                    list.add(capacity-1,page[i]);
                }
                fault++;
                count++;
            }else {
                list.remove(page[i]);
                list.add(list.size()-1,page[i]);
            }
        }
        return fault;
    }

//    2
//            9
//            5 0 1 3 2 4 1 0 5
//            4
//            8
//            3 1 0 2 5 4 1 2
//            4
    //output 8 7
    //output 8 7

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int i =0;
            int[] page = new int[n];
            while (i< n){
                page[i] = sc.nextInt();
                i++;
            }
            int capacity = sc.nextInt();
            System.out.println(findNoOfPageFault(page,capacity));
        }

    }
}
