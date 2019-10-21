package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

public class FindLongestPalindrome {

/*
2
geeksforgeek
acaaabbbacdddd
mississipie
aaaaaaaa

gksforgk
acac
mpie
a
 */

    public static String removeDup(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))) {
                int c = map.get(str.charAt(i));
                map.put(str.charAt(i), ++c);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    /*
2
geeksforgeek
acaaabbbacdddd
mississipie miiipie mpie
aaaaaaaa

gksforgk
acac
mpie
a
 */
    public static String removeAdjacentDup(String s) {

        if (s.length() <= 1) {
            return s;
        }
        int l = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (i < l - 1 && s.charAt(i) == s.charAt(i + 1)) {
                if (i < l - 2 && s.charAt(i) != s.charAt(i + 2)) {
                    i = i + 2;
                } else {
                    i++;
                }
                count++;
            }

            if (i != s.length() - 1) {
                sb.append(s.charAt(i));
            } else {
                if (i == s.length() - 1 && s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(s.charAt(i));
                }
            }
        }
        if (count > 0) {
            return removeAdjacentDup(sb.toString());
        }
        return sb.toString();
    }


    /*
    1
aaaabbaa

Output:
aabbaa
     */

    public static String findLongestPalindrome(String str) {
        int len = str.length();
        int start = 0;
        int maxLen = 1;
        int high, low;

        for (int i = 1; i < len; i++) {
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (maxLen < high - low + 1) {
                    start = low;
                    maxLen = high - low + 1;
                }
                low--;
                high++;
            }

            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    start = low;
                }
                low--;
                high++;
            }
        }

        return str.substring(start, start + maxLen);

    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i < t) {
                String str = br.readLine();
                String res = removeDup(str);
                sb.append(res + "\n");
                i++;

            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
