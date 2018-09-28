import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FindLonelyInteger {


    // Complete the findLonely function below.
    static int findLonely(List<Integer> arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        if(arr.size() == 1){
            return arr.get(0);
        }


        for(int i=0;i<arr.size();i++){
            if(map.get(arr.get(i)) ==  null){
                map.put(arr.get(i),1);

            }
            else {
                map.put(arr.get(i),map.get(arr.get(i))+1);
            }

        }
        for(int j=0;j<arr.size();j++){
            if(map.get(arr.get(j)) == 1){
                return arr.get(j);
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        //using buffer reader
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//        System.out.println("n :" +n);
//
//        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        //using scanner
        System.out.println("Enter size of array");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(in.nextInt());

        }


//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr.add(arrItem);
//        }
        System.out.println("arr is :" +arr);

        int res = findLonely(arr);
        System.out.println("result is "+res);

       // bufferedWriter.write(String.valueOf(res));
       // bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }

}
