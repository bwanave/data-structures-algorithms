package leetcode.pattern.cyclicsort;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * Example 2:
 * <p>
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 */
class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) swap(i, nums[i] - 1, nums);
            else i += 1;
        }

        for (int k = 0; k < nums.length; k++) {
            if (k != nums[k] - 1) return new int[]{nums[k], k + 1};
        }

        return null;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}