package twopointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 * <p>
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();

        int left = 0, right = 0;
        int product = 1;

        while (right < arr.length) {

            product *= arr[right];

            while (product >= target && left <= right) {
                product /= arr[left];
                left += 1;
            }

            List<Integer> subArray = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                subArray.add(0, arr[i]);
                subArrays.add(new ArrayList<>(subArray));
            }
            right += 1;
        }

        return subArrays;
    }
}