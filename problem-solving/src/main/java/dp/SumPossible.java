package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * sum possible
 * <p>
 * Write a function sumPossible that takes in an amount and an array of positive numbers. The function should return a boolean indicating whether or not it is possible to create the amount by summing numbers of the array. You may reuse numbers of the array as many times as necessary.
 * <p>
 * You may assume that the target amount is non-negative.
 * <p>
 * test_00:
 * sumPossible(8, [5, 12, 4]); // -> true, 4 + 4
 * <p>
 * test_01:
 * sumPossible(15, [6, 2, 10, 19]); // -> false
 * <p>
 * test_02:
 * sumPossible(13, [6, 2, 1]); // -> true
 * <p>
 * test_03:
 * sumPossible(103, [6, 20, 1]); // -> true
 * <p>
 * test_04:
 * sumPossible(12, []); // -> false
 * <p>
 * test_05:
 * sumPossible(12, [12]); // -> true
 * <p>
 * test_06:
 * sumPossible(0, []); // -> true
 * <p>
 * test_07:
 * sumPossible(271, [10, 8, 265, 24]); // -> false
 * <p>
 * test_08:
 * sumPossible(2017, [4, 2, 10]); // -> false
 * <p>
 * test_09:
 * sumPossible(13, [3, 5]); // -> true
 */
public class SumPossible {
    public static boolean sumPossible(int target, int[] nums, Map<Integer, Boolean> memo) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == 0)
            return true;

        for (int num : nums) {
            if (num <= target && sumPossible(target - num, nums, memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sumPossible(15, new int[]{6, 2, 10, 19}, new HashMap<>())); // -> false
        System.out.println(sumPossible(13, new int[]{3, 5}, new HashMap<>())); // -> true
    }
}
