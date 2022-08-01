package leetcode.pattern.sliding;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example 1:
 * <p>
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * Example 2:
 * <p>
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
class ReplacingOnes {
    public static int findLength(int[] arr, int k) {

        int longestLength = 0;

        int onesCount = 0;
        int start = 0, end = 0;

        while (end < arr.length) {
            if (arr[end] == 1) onesCount += 1;

            if (end - start + 1 - onesCount > k) {
                if (arr[start] == 1) onesCount -= 1;
                start += 1;
            }

            longestLength = Math.max(longestLength, end - start + 1);
            end += 1;
        }

        return longestLength;
    }
}
