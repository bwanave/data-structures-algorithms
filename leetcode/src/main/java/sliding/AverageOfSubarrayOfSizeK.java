package sliding;

import java.util.Arrays;

/**
 * Given an array, find the average of all subarrays of ‘K’ contiguous elements in it.
 */
class AverageOfSubarrayOfSizeK {
    public static double[] findAverages(int k, int[] arr) {

        int totalAverages = arr.length - k + 1;
        double[] output = new double[totalAverages];

        int sum = 0;
        int i = 0, j = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j >= k - 1) {
                double average = (double) sum / k;
                output[i] = average;
                sum -= arr[i];
                i += 1;
            }
            j += 1;
        }

        return output;
    }

    public static void main(String[] args) {
        double[] result = AverageOfSubarrayOfSizeK.findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("Averages of subarrays of size K: " + Arrays.toString(result));
    }
}