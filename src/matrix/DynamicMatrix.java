package matrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DynamicMatrix {



    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> rowList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("line is "+line);
        while (line.length() > 0) {
            String[] split = line.split(" ");
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                row.add(Integer.valueOf(split[i]));
            }
            System.out.println("row is "+row);
            System.out.println("row list is "+rowList);
            rowList.add(row);
            System.out.println("row list is "+rowList);
            line = scanner.nextLine();

        }

        Iterator listIter = rowList.iterator();
        while (listIter.hasNext()){
            ArrayList<Integer> rowTemp = (ArrayList<Integer>) listIter.next();
            Iterator iter = rowTemp.iterator();
            while (iter.hasNext()){
                System.out.print((Integer) iter.next()+ " ");
            }
            System.out.println();
        }
//        for(int i=0;i<rowList.size();i++){
//            List<Integer> rowTemp = rowList.get(i);
//            System.out.println("row temp size "+rowTemp.size());
//            for(int j= 0 ;j<rowTemp.size();j++){
//                System.out.print(rowTemp.get(j));
//            }
//            System.out.print("\n");
//        }

    }
}
