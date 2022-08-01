package leetcode.pattern.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.
 * <p>
 * You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:
 * <p>
 * Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
 * You can start with any tree, but you can’t skip a tree once you have started.
 * You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {

        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        while (end < arr.length) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > 2) {
                char startChar = arr[start];
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) map.remove(startChar);
                start += 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end += 1;
        }

        return maxLength;
    }
}
