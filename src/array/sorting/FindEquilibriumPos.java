package array.sorting;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindEquilibriumPos {


    private static int findEquiPos(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        } else if (len == 2) {
            return -1;
        }


        int l_sum = 0, sum = 0, r_sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + arr[i];
        }
        r_sum = sum - arr[0];
        for (int i = 1; i < len - 1; i++) {
            l_sum = l_sum + arr[i - 1];
            r_sum = r_sum - arr[i];
            if (l_sum - r_sum == 0) {
                return i + 1;
            }
        }
        return -1;

    }

/*
5
2 2 5 1 3
8
43 34 2 8 17 5 11 8
 */

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            int i = 0;
            int[][] arr = new int[t][];
            StringBuffer sb = new StringBuffer();
            while (i < t) {
                int n = Integer.parseInt(br.readLine());
                int[] a = new int[n];
                String line = br.readLine();
                String[] strs = line.trim().split(" ");
                for (int j = 0; j < n; j++) {
                    a[j] = (Integer.parseInt(strs[j]));
                }
                int pos = findEquiPos(a);

                sb.append(pos + "\n");

                i++;

            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
