package sliding;

/**
 * Given an array of positive integers and a number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [5, 2].
 * Example 2:
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to ‘7’ is [8].
 * Example 3:
 * <p>
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to ‘8’ are [3, 4, 1] or [1, 1, 6].
 */
class MinSizeSubArraySum {
    public static int findMinSubArray(int s, int[] arr) {

        int minSize = Integer.MAX_VALUE;

        int slidingWindowSum = 0;
        int start = 0, end = 0;

        while (end < arr.length) {

            slidingWindowSum += arr[end];

            while (slidingWindowSum >= s) {
                minSize = Math.min(minSize, end - start + 1);
                slidingWindowSum -= arr[start];
                start += 1;
            }

            end += 1;
        }

        return minSize == Integer.MAX_VALUE // If true, then no such window/subarray exist
                ? 0
                : minSize;
    }
}
