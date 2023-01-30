package twopointers;

/**
 * Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 * Example 2:
 * <p>
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 */
class RemoveElement {

    public static int remove(int[] arr, int key) {
        int uniqueElementIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) arr[uniqueElementIdx++] = arr[i];
        }
        return uniqueElementIdx;
    }
}
