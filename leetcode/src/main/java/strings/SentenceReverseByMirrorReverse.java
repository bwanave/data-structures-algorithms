package strings;

import java.util.Arrays;

class SentenceReverseByMirrorReverse {

    private static void mirrorReverse(char[] arr, int startIndex, int endIndex) {
        char temp;
        while (startIndex < endIndex) {
            temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    static char[] reverseWords(char[] arr) {
        mirrorReverse(arr, 0, arr.length - 1);
        int wordStartIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                mirrorReverse(arr, wordStartIndex, i - 1);
                wordStartIndex = i + 1;
            }
            if (i == arr.length - 1)
                mirrorReverse(arr, wordStartIndex, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        char[] arr = new char[]{'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        System.out.println("output: " + Arrays.toString(reverseWords(arr)));
    }
}