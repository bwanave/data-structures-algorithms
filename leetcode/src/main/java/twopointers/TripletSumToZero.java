package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example 1:
 * <p>
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 * <p>
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] == arr[i - 1]) continue;
            searchPair(-arr[i], i + 1, triplets, arr);
        }

        return triplets;
    }

    private static void searchPair(int target, int idx, List<List<Integer>> triplets, int[] arr) {
        int left = idx;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                triplets.add(Arrays.asList(-target, arr[left], arr[right]));
                left += 1;
                right -= 1;
                while (left < right) {
                    if (arr[left] == arr[left - 1]) left += 1;
                    else if (arr[right] == arr[right + 1]) right -= 1;
                    else break;
                }
            }
            else if (sum < target) left += 1;
            else right -= 1;
        }
    }
}