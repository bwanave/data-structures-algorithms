package twopointers;

/**
 * Given an array of sorted numbers, remove all duplicate number instances from it in-place, such that each element appears only once. The relative order of the elements should be kept the same and you should not use any extra space so that that the solution have a space complexity of O(1).
 * <p>
 * Move all the unique elements at the beginning of the array and after moving return the length of the subarray that has no duplicate in it.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 * <p>
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
class RemoveDuplicates {

    public static int remove(int[] arr) {
        int uniqueElementIdx = 0; // Assume first element is unique
        for (int i = 1; i < arr.length; i++) {
            if (arr[uniqueElementIdx] != arr[i]) arr[++uniqueElementIdx] = arr[i];
        }
        return uniqueElementIdx + 1;
    }
}
