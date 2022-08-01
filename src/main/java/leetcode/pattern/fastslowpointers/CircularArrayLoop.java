package leetcode.pattern.fastslowpointers;

/**
 * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular which means two things:
 * <p>
 * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 * Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 * Example 2:
 * <p>
 * Input: [2, 2, -1, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
 * Example 3:
 * <p>
 * Input: [2, 1, -1, -2]
 * Output: false
 * Explanation: The array does not have any cycle.
 */
class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean isForwardDirection = arr[i] >= 0;

            int slow = i;
            int fast = i;
            while (slow != -1 && fast != -1) {
                slow = getNext(slow, isForwardDirection, arr);
                fast = getNext(fast, isForwardDirection, arr);
                if (fast != -1) fast = getNext(fast, isForwardDirection, arr);

                if (slow == fast) return true;
            }
        }

        return false;
    }

    private static int getNext(int idx, boolean expectedDirection, int[] arr) {
        boolean direction = arr[idx] >= 0;
        if (expectedDirection != direction) return -1;

        int newIdx = (idx + arr[idx]) % arr.length;
        if (newIdx < 0) newIdx = newIdx + arr.length;

        return newIdx == idx ? -1 : newIdx;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[]{1, 2, -1, 2, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 2, -1, 2}));
        System.out.println(CircularArrayLoop.loopExists(new int[]{2, 1, -1, -2}));
    }
}