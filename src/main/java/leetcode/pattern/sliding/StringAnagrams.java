package leetcode.pattern.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * <p>
 * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get
 * N
 * !
 * N!
 * permutations (or anagrams) of a string having
 * N
 * N
 * characters. For example, here are the six anagrams of the string “abc”:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * <p>
 * Example 1:
 * <p>
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * Example 2:
 * <p>
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : pattern.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int matched = 0;
        int start = 0, end = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) matched += 1;
            }

            if (matched == map.size()) resultIndices.add(start);

            if (end - start + 1 == pattern.length()) {
                char startChar = str.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) matched -= 1;
                    map.put(startChar, map.get(startChar) + 1);
                }
                start += 1;
            }
            end += 1;
        }
        return resultIndices;
    }
}
