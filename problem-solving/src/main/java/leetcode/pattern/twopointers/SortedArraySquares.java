package leetcode.pattern.twopointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 * <p>
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */
class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];

        int left = 0, right = arr.length - 1;
        for (int i = squares.length - 1; i >= 0; i--) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                squares[i] = arr[left] * arr[left];
                left += 1;
            }
            else {
                squares[i] = arr[right] * arr[right];
                right -= 1;
            }
        }
        return squares;
    }
}
