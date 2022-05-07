package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OverlapSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        return longestCommonSubsequence(str1, str2, 0, 0, new HashMap<>());
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2, int i, int j, Map<String, List<Character>> memo) {
        String key = i + "," + j;
        if (memo.containsKey(key))
            return memo.get(key);

        if (i == str1.length() || j == str2.length())
            return new ArrayList<>();

        List<Character> lcm;
        if (str1.charAt(i) == str2.charAt(j)) {
            lcm = longestCommonSubsequence(str1, str2, i + 1, j + 1, memo);
            lcm = new ArrayList<>(lcm);
            lcm.add(0, str1.charAt(i));
        }
        else {
            List<Character> lcm1 = longestCommonSubsequence(str1, str2, i, j + 1, memo);
            List<Character> lcm2 = longestCommonSubsequence(str1, str2, i + 1, j, memo);
            lcm = lcm1.size() > lcm2.size() ? lcm1 : lcm2;
        }
        memo.put(key, lcm);
        return lcm;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ZXVVYZW", "XKYKZPW")); //[X, Y, Z, W]
        System.out.println(longestCommonSubsequence("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAG")); //["C", "D", "E", "G", "H", "J", "K", "L", "W"]
    }
}
