package cyclicsort;

/**
 * We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.
 * <p>
 * Write a function to sort the objects in-place on their creation sequence number in
 * O
 * (
 * n
 * )
 * O(n)
 * and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * Example 2:
 * <p>
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 * Example 3:
 * <p>
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
 */
class CyclicSort {

    public static void sort(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) i += 1;
            else swap(i, nums[i] - 1, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
