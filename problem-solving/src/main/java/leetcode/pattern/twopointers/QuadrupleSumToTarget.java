package leetcode.pattern.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Example 2:
 * <p>
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
class QuadrupleSumToTarget {

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int tripletTarget = target - arr[i];

            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                int pairTarget = tripletTarget - arr[j];

                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == pairTarget) {
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left += 1;
                        right -= 1;
                        while (left < right) {
                            if (arr[left] == arr[left - 1] && arr[right] == arr[right + 1]) {
                                left += 1;
                                right -= 1;
                            }
                            else break;
                        }
                    }
                    else if (sum < pairTarget) left += 1;
                    else right -= 1;
                }
            }
        }

        return quadruplets;
    }
}