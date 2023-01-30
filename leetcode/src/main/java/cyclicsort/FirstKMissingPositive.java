package cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 * Example 2:
 * <p>
 * Input: [2, 3, 4], k=3
 * Output: [1, 5, 6]
 * Explanation: The smallest missing positive numbers are 1, 5 and 6.
 * Example 3:
 * <p>
 * Input: [-2, -3, 4], k=2
 * Output: [1, 2]
 * Explanation: The smallest missing positive numbers are 1 and 2.
 */
class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            boolean inbound = nums[i] >= 1 && nums[i] <= nums.length;
            if (inbound && nums[i] != nums[nums[i] - 1]) swap(i, nums[i] - 1, nums);
            else i += 1;
        }

        Set<Integer> outboundNumbers = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j] - 1) {
                missingNumbers.add(j + 1);
                outboundNumbers.add(nums[j]);
                if (missingNumbers.size() == k) return missingNumbers;
            }
        }

        for (int idx = 0; missingNumbers.size() < k; idx++) {
            int num = nums.length + 1 + idx;
            if (!outboundNumbers.contains(num)) missingNumbers.add(num);
        }

        return missingNumbers;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}