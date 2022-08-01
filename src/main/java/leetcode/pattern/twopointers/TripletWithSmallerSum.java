package leetcode.pattern.twopointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * <p>
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {

            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count += right - left;
                    left += 1;
                }
                else right -= 1;
            }
        }
        return count;
    }
}