package leetcode.pattern.cyclicsort;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given an unsorted array containing n numbers taken from the range 1 to n. The array has some numbers appearing twice, find all these duplicate numbers using constant space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 4, 4, 5, 5]
 * Output: [4, 5]
 * Example 2:
 * <p>
 * Input: [5, 4, 7, 2, 3, 5, 3]
 * Output: [3, 5]
 */
class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {

            if (nums[i] != nums[nums[i] - 1]) swap(i, nums[i] - 1, nums);
            else i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j] - 1) duplicateNumbers.add(nums[j]);
        }

        return duplicateNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

