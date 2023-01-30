package twopointers;

/**
 * Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Example 2:
 * <p>
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * Example 3:
 * <p>
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * Example 4:
 * <p>
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 */
class ShortestWindowSort {

    public static int sort(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) low += 1;

        if (low == arr.length - 1) return 0;

        while (high > 0 && arr[high] >= arr[high - 1]) high -= 1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        while (low > 0 && min < arr[low - 1]) low -= 1;

        while (high < arr.length - 1 && max > arr[high + 1]) high += 1;
        return high - low + 1;
    }
}