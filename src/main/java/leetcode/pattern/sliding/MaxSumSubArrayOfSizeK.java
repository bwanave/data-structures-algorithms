package leetcode.pattern.sliding;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {

        int maxSum = 0;

        int windowSum = 0;
        int start = 0, end = 0;

        while (end < arr.length) {
            windowSum += arr[end];

            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[start];
                start += 1;
            }

            end += 1;
        }

        return maxSum;
    }
}