package leetcode.pattern.sliding;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * <p>
 * Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:
 * <p>
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * If a string has ‘n’ distinct characters, it will have
 * n
 * !
 * n!
 * permutations.
 * <p>
 * Example 1:
 * <p>
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * Example 2:
 * <p>
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * Example 3:
 * <p>
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 */
class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {

        Map<Character, Integer> map = str.chars().mapToObj(c -> (char) c)
                                         .collect(Collectors.toMap(Function.identity(), c -> 1, Integer::sum));

        int matched = 0;

        int start = 0, end = 0;
        while (end < str.length()) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) matched += 1;
            }
            if (matched == map.size()) return true;

            if (end - start + 1 >= pattern.length()) {
                char startChar = str.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) == 0) matched += 1;
                    map.put(startChar, map.get(startChar) + 1);
                }
                start += 1;
            }
            end += 1;
        }
        return false;
    }
}
