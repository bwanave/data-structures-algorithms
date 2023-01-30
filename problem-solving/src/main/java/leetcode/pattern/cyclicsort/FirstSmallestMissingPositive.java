package leetcode.pattern.cyclicsort;

/**
 * Given an unsorted array containing numbers, find the smallest missing positive number in it.
 * <p>
 * Note: Positive numbers start from ‘1’.
 * <p>
 * Example 1:
 * <p>
 * Input: [-3, 1, 5, 4, 2]
 * Output: 3
 * Explanation: The smallest missing positive number is '3'
 * Example 2:
 * <p>
 * Input: [3, -2, 0, 1, 2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: [3, 2, 5, 1]
 * Output: 4
 */
class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            boolean inbound = nums[i] >= 1 && nums[i] <= nums.length;
            if (inbound && nums[i] != nums[nums[i] - 1]) swap(i, nums[i] - 1, nums);
            else i += 1;
        }

        for (int j = 0; j < nums.length; j++) {
            if (j != nums[j] - 1) return j + 1;
        }

        return nums.length + 1;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
