package arrays.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SentenceReverseBruitForce {

    private static List<Integer> getSpaceIndexes(char[] arr) {
        List<Integer> spaceIndexes = new ArrayList<>();
        spaceIndexes.add(-1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                spaceIndexes.add(i);
        }
        return spaceIndexes;
    }

    static char[] reverseWords(char[] arr) {

        // Get space indexes
        List<Integer> spaceIndexes = getSpaceIndexes(arr);

        char[] output = new char[arr.length];
        int outputIndex = 0;
        int prevSpaceIndex = arr.length;
        for (int i = spaceIndexes.size() - 1; i >= 0; i--) {
            int spaceIndex = spaceIndexes.get(i);
            for (int j = spaceIndex + 1; j < prevSpaceIndex; j++) {
                output[outputIndex++] = arr[j];
            }
            if (i != 0)
                output[outputIndex++] = ' ';
            prevSpaceIndex = spaceIndex;
        }
        return output;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        System.out.println("output: " + Arrays.toString(reverseWords(arr)));
    }
}