package cyclicsort;

/**
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [2, 1, 3, 3, 5, 4]
 * Output: 3
 * Example 3:
 * <p>
 * Input: [2, 4, 1, 4, 4]
 * Output: 4
 */
class FindDuplicate {

    public static int findNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (i != nums[i] - 1) {
                if (nums[i] == nums[nums[i] - 1]) return nums[i];
                swap(i, nums[i] - 1, nums);
            }
            else i += 1;
        }

        return -1;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}