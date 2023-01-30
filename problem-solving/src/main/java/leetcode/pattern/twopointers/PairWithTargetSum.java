package leetcode.pattern.twopointers;

/**
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 * <p>
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {

        int low = 0, high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == targetSum) return new int[]{low, high};
            else if (sum < targetSum) low += 1;
            else high -= 1;
        }

        return null;
    }
}