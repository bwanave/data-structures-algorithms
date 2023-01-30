package cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 3, 1, 8, 2, 3, 5, 1]
 * Output: 4, 6, 7
 * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
 * Example 2:
 * <p>
 * Input: [2, 4, 1, 2]
 * Output: 3
 * Example 3:
 * <p>
 * Input: [2, 3, 2, 1]
 * Output: 4
 */
class AllMissingNumbers {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {

            if (nums[i] != nums[nums[i] - 1]) swap(i, nums[i] - 1, nums);
            else i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) missingNumbers.add(j + 1);
        }

        return missingNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
